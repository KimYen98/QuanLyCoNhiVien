create database QuanLyCoNhiVien
go
use QuanLyCoNhiVien
go
--Tạo bảng Trẻ
create table Tre
(
	MaTre int,
	TenTre nvarchar(100) not null,
	GioiTinh nvarchar(100) not null,
	NgaySinh smalldatetime,
	NgayVao smalldatetime not null,
	HoanCanh nvarchar(4000),
	NguoiDuaTreVao nvarchar(100),
	TrangThai int not null default 0,
	MaNV int not null default 0,
	primary key(MaTre)
)
go
--Tạo bảng nhân viên
create table NhanVien
(	
	MaNV int,
	TenNV nvarchar(100) not null,
	GioiTinh nvarchar(100) not null,
	NgaySinh smalldatetime,
	DiaChi nvarchar(100) not null,
	SoDT nvarchar(10),
	NgayVL smalldatetime not null,
	MaLoaiNV int not null,
	primary key(MaNV)
)
go
--Tạo bảng loại nhân viên
create table LoaiNhanVien
(
	MaLoaiNV int,
	TenLoaiNV nvarchar(100) not null,
	primary key(MaLoaiNV)
)
go
--Tạo bảng nhà tài trợ
create table NhaTaiTro
(
	MaNhaTaiTro int,
	TenNhaTaiTro nvarchar(100) not null,
	SoDT nvarchar(10) not null,
	DiaChi nvarchar(100) not null,
	primary key(MaNhaTaiTro)
)
go
--Tạo bảng tài trợ
create table TaiTro
(
	MaTaiTro int,
	MaNhaTaiTro int not null,
	NgayTaiTro smalldatetime,
	HinhThucTaiTro nvarchar(100) not null,
	SoTien float not null default 0,
	primary key(MaTaiTro)
)
go
--Tạo bảng chi tiêu
create table ChiTieu
(
	MaChiTieu int,
	TenChiTieu nvarchar(100) not null,
	NgayChi smalldatetime not null,
	TongSoTien float not null default 0,
	primary key(MaChiTieu)
)
go
--Tạo bảng chi tiết chi tiêu
create table CT_ChiTieu
(
	MaCT_ChiTieu int,
	TenCTChiTieu nvarchar(100) not null,
	SoTien float not null default 0,
	MaChiTieu int not null,
	primary key(MaCT_ChiTieu)
)
--Tạo bảng người nhận trẻ
create table NguoiNhanTre
(
	MaNguoiNhan int,
	TenNguoiNhan nvarchar(100) not null,
	DiaChi nvarchar(100)not null,
	SoDT nvarchar(100) not null,
	primary key(MaNguoiNhan)
)
go
--Tạo bảng chi tiết người nhận trẻ
create table CT_NguoiNhanTre_Tre
(
	MaNguoiNhan int,
	MaTre int,
	NgayNhan smalldatetime not null ,
	primary key(MaNguoiNhan, MaTre)
)
go
--Tạo bảng tài khoản
create table TaiKhoan
(
	TenDangNhap nvarchar(100),
	MatKhau nvarchar(100) not null,
	TenHienThi nvarchar(100) not null,
	primary key(TenDangNhap)
)
go
--Tạo khóa ngoại
alter table NhanVien add constraint fk_NhanVien_LoaiNhanVien foreign key(MaLoaiNV) references LoaiNhanVien(MaLoaiNV)
go
alter table Tre add constraint fk_Tre_NhanVien foreign key (MaNV) references NhanVien(MaNV)
go
alter table TaiTro add constraint fk_TaiTro_NhaTaiTro foreign key(MaNhaTaiTro) references NhaTaiTro(MaNhaTaiTro)
go
alter table CT_ChiTieu add constraint fk_CT_ChiTieu_ChiTieu foreign key(MaChiTieu) references ChiTieu(MaChiTieu)
go
alter table CT_NguoiNhanTre_Tre add constraint fk_CT_NguoiNhanTre_Tre foreign key(MaTre) references Tre(MaTre)
go
alter table CT_NguoiNhanTre_Tre add constraint fk_CT_NguoiNhanTre_NguoiNhan foreign key(MaNguoiNhan) references NguoiNhanTre(MaNguoiNhan)
go
--Thêm loại nhân viên
alter proc sp_ThemLoaiNhanVien
@TenLoaiNV nvarchar(100)
as
begin
	declare @MaLoaiNV int, @MaLoaiNV_Max int ,@i int 
	set @i=1
	select @MaLoaiNV_max=(max(MaLoaiNV))
	from LoaiNhanVien
	if(select count(*)
		from LoaiNhanVien
		where TenLoaiNV=@TenLoaiNV)>0
		begin
			print N'Tên loại nhân viên không được phép trùng'
		end
	else
		begin
			if(@MaLoaiNV_Max is null)
				set @MaLoaiNV=@i
			else
				begin
					while(@i<=@MaLoaiNV_Max+1)
						begin
							if(select count(*)
								from LoaiNhanVien
								where MaLoaiNV=@i)=0
								begin
									set @MaLoaiNV=@i
									break
								end
							set @i=@i+1
						end
				end
			insert into LoaiNhanVien values(@MaLoaiNV,@TenLoaiNV)
		end
end
go
--Cập nhật loại nhân viên
create proc sp_CapNhatLoaiNhanVien
@MaLoaiNV int, @TenLoaiNV nvarchar(100)
as
begin
	update LoaiNhanVien
	set TenLoaiNV=@TenLoaiNV
	where MaLoaiNV=@MaLoaiNV
end
go
--Xóa loại nhân viên
create proc sp_XoaLoaiNhanVien
@MaLoaiNV int
as
begin
	delete from LoaiNhanVien
	where MaLoaiNV=@MaLoaiNV
end
go
-- Hàm chuyển sang tiếng Việt k dấu để tìm gần đúng
CREATE FUNCTION [dbo].[GetUnsignString](@strInput NVARCHAR(4000)) 
RETURNS NVARCHAR(4000)
AS
BEGIN     
    IF @strInput IS NULL RETURN @strInput
    IF @strInput = '' RETURN @strInput
    DECLARE @RT NVARCHAR(4000)
    DECLARE @SIGN_CHARS NCHAR(136)
    DECLARE @UNSIGN_CHARS NCHAR (136)

    SET @SIGN_CHARS = N'ăâđêôơưàảãạáằẳẵặắầẩẫậấèẻẽẹéềểễệếìỉĩịíòỏõọóồổỗộốờởỡợớùủũụúừửữựứỳỷỹỵýĂÂĐÊÔƠƯÀẢÃẠÁẰẲẴẶẮẦẨẪẬẤÈẺẼẸÉỀỂỄỆẾÌỈĨỊÍÒỎÕỌÓỒỔỖỘỐỜỞỠỢỚÙỦŨỤÚỪỬỮỰỨỲỶỸỴÝ'+NCHAR(272)+ NCHAR(208)
    SET @UNSIGN_CHARS = N'aadeoouaaaaaaaaaaaaaaaeeeeeeeeeeiiiiiooooooooooooooouuuuuuuuuuyyyyyAADEOOUAAAAAAAAAAAAAAAEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYDD'

    DECLARE @COUNTER int
    DECLARE @COUNTER1 int
    SET @COUNTER = 1
 
    WHILE (@COUNTER <=LEN(@strInput))
    BEGIN   
      SET @COUNTER1 = 1
      --Tim trong chuoi mau
       WHILE (@COUNTER1 <=LEN(@SIGN_CHARS)+1)
       BEGIN
     IF UNICODE(SUBSTRING(@SIGN_CHARS, @COUNTER1,1)) = UNICODE(SUBSTRING(@strInput,@COUNTER ,1) )
     BEGIN           
          IF @COUNTER=1
              SET @strInput = SUBSTRING(@UNSIGN_CHARS, @COUNTER1,1) + SUBSTRING(@strInput, @COUNTER+1,LEN(@strInput)-1)                   
          ELSE
              SET @strInput = SUBSTRING(@strInput, 1, @COUNTER-1) +SUBSTRING(@UNSIGN_CHARS, @COUNTER1,1) + SUBSTRING(@strInput, @COUNTER+1,LEN(@strInput)- @COUNTER)    
              BREAK         
               END
             SET @COUNTER1 = @COUNTER1 +1
       END
      --Tim tiep
       SET @COUNTER = @COUNTER +1
    END
    RETURN @strInput
END
go
--Tìm loại nhân viên
create proc sp_TimLoaiNhanVien
@key nvarchar(100)
as
begin
	select * from LoaiNhanVien WHERE [dbo].[GetUnsignString](TenLoaiNV) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
--Thêm nhân viên
create proc sp_ThemNhanVien
@TenNV nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh nvarchar(19), @DiaChi nvarchar(100), @SoDT nvarchar(10), @NgayVL nvarchar(19), @MaLoaiNV int
as
begin
	declare @NgaySinh_ smalldatetime,@NgayVL_ smalldatetime, @MaNV int, @MaNV_Max int,@i int =1
	set @NgaySinh_=CONVERT(smalldatetime,@NgaySinh,103)
	set @NgayVL_=CONVERT(smalldatetime,@NgayVL,103)
	select @MaNV_Max=max(MaNV)
	from NhanVien
	if(@MaNV_Max is null)
		set @MaNV=@i
	else
		while(@i <=@MaNV_Max+1)
			begin
				if(select count(*)
					from NhanVien
					where MaNV=@i)=0
					begin 
						set @MaNV=@i
						break
					end
				set @i=@i+1
			end
	insert into NhanVien values (@MaNV,@TenNV,@GioiTinh,@NgaySinh_,@DiaChi,@SoDT,@NgayVL_,@MaLoaiNV)
end
go
--Cập nhật nhân viên
create proc sp_CapNhatNhanVien
@MaNV int,@TenNV nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh nvarchar(19), @DiaChi nvarchar(100), @SoDT nvarchar(10), @NgayVL nvarchar(19), @MaLoaiNV int
as
begin
	declare @NgaySinh_ smalldatetime,@NgayVL_ smalldatetime
	set @NgaySinh_=CONVERT(smalldatetime,@NgaySinh,103)
	set @NgayVL_=CONVERT(smalldatetime,@NgayVL,103)
	update NhanVien
	set TenNV=@TenNV, GioiTinh=@GioiTinh,NgaySinh=@NgaySinh_,DiaChi=@DiaChi,SoDT=@SoDT,NgayVL=@NgayVL_,MaLoaiNV=@MaLoaiNV
	where MaNV=@MaNV
end
go
--Xóa nhân viên
create proc sp_XoaNhanVien
@MaNV int
as
begin
	delete from NhanVien
	where MaNV=@MaNV
end
go
--Hiện thi danh sách nhân viên
create proc sp_HienThiDanhSachNhanVien
as
begin
	select MaNV,TenNV,GioiTinh,NgaySinh,DiaChi,SoDT,NgayVL,TenLoaiNV
	from NhanVien,LoaiNhanVien
	where NhanVien.MaLoaiNV=LoaiNhanVien.MaLoaiNV
end
go
--Tìm nhân viên
create proc sp_TimNhanVien
@key nvarchar(100)
as
begin
	select MaNV,TenNV,GioiTinh,NgaySinh,DiaChi,SoDT,NgayVL,TenLoaiNV
	from NhanVien ,LoaiNhanVien
	WHERE NhanVien.MaLoaiNV=LoaiNhanVien.MaLoaiNV and [dbo].[GetUnsignString](TenNV) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
--Hiện thị danh sách trẻ
create proc sp_HienThiDanhSachTre
as 
begin
	select MaTre,TenTre,Tre.GioiTinh,Tre.NgaySinh,NgayVao,HoanCanh,NguoiDuaTreVao,TrangThai,TenNV
	from Tre,NhanVien
	where Tre.MaNV=NhanVien.MaNV
end
go
--Thêm trẻ
create proc sp_ThemTre
@TenTre nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh nvarchar(19),@NgayVao nvarchar(19), @HoanCanh nvarchar(4000),@NguoiDuaTreVao nvarchar(100), @TrangThai int,@MaNV int
as
begin
	declare @MaTre int, @MaTre_Max int, @i int =1
	declare @NgaySinh_ smalldatetime,@NgayVao_ smalldatetime
	set @NgaySinh_=CONVERT(smalldatetime,@NgaySinh,103)
	set @NgayVao_=CONVERT(smalldatetime,@NgayVao,103)
	set @MaTre_Max=(select max(MaTre)
					from Tre)
	if(@MaTre_Max is null)
		set @MaTre=@i
	else
	begin
		while(@i<=@MaTre_Max+1)
			begin
				if(select count(*)
					from Tre
					where MaTre=@i)=0
					begin
						set @MaTre=@i
						break
					end
			set @i=@i+1
			end
	end
	insert into Tre values(@MaTre,@TenTre,@GioiTinh,@NgaySinh_,@NgayVao_,@HoanCanh,@NguoiDuaTreVao,@TrangThai,@MaNV)
end
go
exec sp_ThemTre 'a','Nam','11/5/2015','2/5/2016','a','a','0',1
 --Cập nhật trẻ
 create proc sp_CapNhatTre
@MaTre int, @TenTre nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh nvarchar(19),@NgayVao nvarchar(19), @HoanCanh nvarchar(4000),@NguoiDuaTreVao nvarchar(100), @TrangThai int,@MaNV int
as
begin
	declare @NgaySinh_ smalldatetime,@NgayVao_ smalldatetime
	set @NgaySinh_=CONVERT(smalldatetime,@NgaySinh,103)
	set @NgayVao_=CONVERT(smalldatetime,@NgayVao,103)
	update Tre
	set TenTre=@TenTre,GioiTinh=@GioiTinh,NgaySinh=@NgaySinh_,NgayVao=@NgayVao_,HoanCanh=@HoanCanh,NguoiDuaTreVao=@NguoiDuaTreVao,TrangThai=@TrangThai,MaNV=@MaNV
	where MaTre=@MaTre
	end
go
--Tìm trẻ
create proc sp_TimTre
@key nvarchar(100)
as
begin
	select MaTre,TenTre,Tre.GioiTinh,Tre.NgaySinh,NgayVao,HoanCanh,NguoiDuaTreVao,TrangThai,TenNV
	from Tre,NhanVien
	where Tre.MaNV=NhanVien.MaNV and [dbo].[GetUnsignString](TenTre) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
--Hiện thi danh sách nhân viên là bảo mẫu
create proc sp_HienThiDanhSachBaoMau
as
begin
	select MaNV,TenNV,GioiTinh,NgaySinh,DiaChi,SoDT,NgayVL,TenLoaiNV
	from NhanVien,LoaiNhanVien
	where NhanVien.MaLoaiNV=LoaiNhanVien.MaLoaiNV and TenLoaiNV=N'Bảo mẫu'
end
go
<<<<<<< HEAD
--LẤY THÔNG TIN CHI TIÊU
CREATE PROC SP_LOADEXPENSE
AS
BEGIN
	SELECT * FROM ChiTieu
END
GO
--THÊM CHI TIÊU
ALTER PROC SP_INSERTEXPENSE
@TenChiTieu nvarchar(100), @NgayChi nvarchar(19)
AS
BEGIN
	DECLARE @NgayChi_ smalldatetime, @Max_MaChiTieu int, @i int

	SET @NgayChi_ = CONVERT(smalldatetime, @NgayChi, 103)
	SET @i = 1

	SELECT @Max_MaChiTieu = MAX(MaChiTieu)
	FROM CHITIEU

	IF(@Max_MaChiTieu IS NULL)
		INSERT INTO ChiTieu VALUES(@i, @TenChiTieu, @NgayChi_, 0)
	ELSE
	BEGIN
		WHILE(@I <= @Max_MaChiTieu + 1)
		BEGIN
			IF((SELECT COUNT(*) FROM CHITIEU WHERE MaChiTieu = @i) < 1)
			BEGIN
				INSERT INTO ChiTieu VALUES(@i, @TenChiTieu, @NgayChi_, 0)
				BREAK
			END
			SET @i = @i + 1
		END
	END
END
GO
--CẬP NHẬT CHI TIÊU
CREATE PROC SP_UPDATEEXPENSE
 @MaChiTieu int, @TenChiTieu nvarchar(100), @NgayChi nvarchar(19)
AS
BEGIN
	DECLARE @NgayChi_ smalldatetime
	SET @NgayChi_ = CONVERT(smalldatetime, @NgayChi, 103)

	UPDATE ChiTieu
	SET TenChiTieu = @TenChiTieu, NgayChi = @NgayChi_
	WHERE MaChiTieu = @MaChiTieu 
END
GO
-- XOÁ CHI TIÊU
CREATE PROC SP_DELETEEXPENSE
@MaChiTieu int
AS
BEGIN
	DELETE FROM ChiTieu 
	WHERE MaChiTieu = @MaChiTieu
END
GO
--TÌM KIẾM CHI TIÊU THEO THỜI GIAN
CREATE PROC SP_SEARCHEXPENSE
@Month int, @Year int
AS
BEGIN
	SELECT * 
	FROM ChiTieu
	WHERE MONTH(NgayChi) = @Month AND YEAR(NgayChi) = @Year
END
GO
-- LẤY THÔNG TIN CHI TIẾT CHI TIÊU
CREATE PROC SP_LOADEXPENSEINFO
@MaChiTieu int
AS
BEGIN
	SELECT MaChiTieu, MaCT_ChiTieu, TenCTChiTieu, SoTien
	FROM CT_ChiTieu
	WHERE MaChiTieu = @MaChiTieu
END
GO
-- THÊM CHI TIẾT CHI TIÊU
CREATE PROC SP_INSERTEXPENSEINFO
@MaChiTieu int, @TenCTChiTieu nvarchar(100), @SoTien float
AS
BEGIN
	DECLARE @Max_MaCT_ChiTieu int, @i int

	SELECT @Max_MaCT_ChiTieu = MAX(MaCT_ChiTieu)
	FROM CT_ChiTieu
	SET @i = 1

	IF(@Max_MaCT_ChiTieu IS NULL)
		INSERT INTO CT_ChiTieu VALUES(@i, @TenCTChiTieu, @SoTien, @MaChiTieu)
	ELSE
	BEGIN
		WHILE(@i <= @Max_MaCT_ChiTieu + 1)
		BEGIN
			IF((SELECT COUNT(*) FROM CT_ChiTieu WHERE MaCT_ChiTieu = @i) < 1)
			BEGIN
				INSERT INTO CT_ChiTieu VALUES(@i, @TenCTChiTieu, @SoTien, @MaChiTieu)
				BREAK
			END
			SET @i = @i + 1
		END
	END
END
-- CẬP NHẬT CT_CHITIEU
CREATE PROC SP_UPDATEEXPENSEINFO
@MaCT_ChiTieu int, @TenCTChiTieu nvarchar(100), @SoTien float
AS
BEGIN
	UPDATE CT_ChiTieu
	SET TenCTChiTieu = @TenCTChiTieu, SoTien = @SoTien
	WHERE MaCT_ChiTieu = @MaCT_ChiTieu
END
GO
-- XOÁ CT_CHITIEU
CREATE PROC SP_DELETEEXPENSEINFO
@MaCT_ChiTieu int
AS
BEGIN
	DELETE FROM CT_ChiTieu
	WHERE MaCT_ChiTieu = @MaCT_ChiTieu
END
-- TÌM KIẾM CT_CHITIEU THEO NGÀY
ALTER PROC SP_SEARCHEXPENSEINFO
@Day nvarchar(19)
AS
BEGIN
	DECLARE @Day_ smalldatetime
	SET @Day_ = CONVERT(smalldatetime, @Day, 103)

	SELECT CT_ChiTieu.MaChiTieu, MaCT_ChiTieu, TenCTChiTieu, SoTien
	FROM CT_ChiTieu, ChiTieu
	WHERE CT_ChiTieu.MaChiTieu = ChiTieu.MaChiTieu AND NgayChi = @Day_
END
exec SP_SEARCHEXPENSEINFO N'12/11/2018'
--TRIGGER KHI THÊM, SỬA CT_CHITIEU
ALTER TRIGGER TRG_INSUP_CT_CHITIEU ON CT_CHITIEU
FOR INSERT, UPDATE
AS
BEGIN
	DECLARE @MaChiTieu int, @TongSoTien float

	SELECT @MaChiTieu = MaChiTieu
	FROM inserted

	SET @TongSoTien = (SELECT SUM(SoTien) 
					  FROM CT_ChiTieu 
					  WHERE MaChiTieu = @MaChiTieu )

	UPDATE ChiTieu
	SET TongSoTien = @TongSoTien
	WHERE MaChiTieu = @MaChiTieu
END
--TRIGGER KHI XOÁ CT_CHITIEU
create TRIGGER TRG_DELETE_CT_CHITIEU ON CT_CHITIEU
FOR DELETE
AS
BEGIN
	DECLARE @MaChiTieu int, @SoTien float, @TongSoTien_Moi float, @TongSoTien float

	SELECT @MaChiTieu = MaChiTieu, @SoTien = SoTien
	FROM deleted

	SET @TongSoTien = (SELECT TongSoTien 
					  FROM ChiTieu 
					  WHERE MaChiTieu = @MaChiTieu)
	SET @TongSoTien_Moi = @TongSoTien - @SoTien

	UPDATE ChiTieu
	SET TongSoTien = @TongSoTien_Moi
	WHERE MaChiTieu = @MaChiTieu
END
=======
--Hiện thi danh sách nhà tài trợ
create proc sp_HienThiDanhSachNhaTaiTro
as
begin
	select * from NhaTaiTro
end
go
--Thêm nhà tại trợ
create proc sp_ThemNhaTaiTro
@TenNhaTaiTro nvarchar(100),@SoDT nvarchar(10), @DiaChi nvarchar(100)
as
begin
	declare @MaNhaTaiTro int, @MaNhaTaiTro_Max int ,@i int=1
	set @MaNhaTaiTro_Max=(select Max(MaNhaTaiTro)
							from NhaTaiTro)
	if(@MaNhaTaiTro_Max is null)
		set @MaNhaTaiTro=@i
	else
		begin
		while(@i<=@MaNhaTaiTro_Max+1)
			begin
				if(select count(*)
					from NhaTaiTro
					where MaNhaTaiTro=@i)=0
					begin
						set @MaNhaTaiTro=@i
						break
					end
					set @i=@i+1
			end

		end
	insert into NhaTaiTro values(@MaNhaTaiTro,@TenNhaTaiTro,@SoDT,@DiaChi)
end
go
--Cập nhật nhà tài trợ
create proc sp_CapNhatNhaTaiTro
@MaNhaTaiTro int,@TenNhaTaiTro nvarchar(100),@SoDT nvarchar(10),@DiaChi nvarchar(100)
as 
begin
	update NhaTaiTro 
	set TenNhaTaiTro=@TenNhaTaiTro,SoDT=@SoDT,DiaChi=@DiaChi
	where MaNhaTaiTro=@MaNhaTaiTro
end
go
--Xóa nhà tài trợ
create proc sp_XoaNhaTaiTro
@MaNhaTaiTro int
as 
begin
	delete from NhaTaiTro
	where MaNhaTaiTro=@MaNhaTaiTro
end
go
--Tìm nhà tài trợ
create proc sp_TimNhaTaiTro
@key nvarchar(100)
as
begin
	select *
	from NhaTaiTro
	where  [dbo].[GetUnsignString](TenNhaTaiTro) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
--Hiện thị danh sách tài trợ
create proc sp_HienThiDanhSachTaiTro
as
begin
	select MaTaiTro, TenNhaTaiTro,NgayTaiTro,HinhThucTaiTro,SoTien
	from TaiTro,NhaTaiTro
	where TaiTro.MaNhaTaiTro=NhaTaiTro.MaNhaTaiTro
end
go
--Thêm tài trợ
create proc sp_ThemTaiTro
@MaNhaTaiTro int, @NgayTaiTro nvarchar(19),@HinhThuc nvarchar(100), @SoTien money
as
begin
	declare @MaTaiTro int,@MaTaiTro_Max int,@i int=1, @NgayTaiTro_ smalldatetime
	set @MaTaiTro_Max=(select max(MaTaiTro)
						from TaiTro)
	if(@MaTaiTro_Max is null)
		set @MaTaiTro=@i
	else
		begin
		while(@i<=@MaTaiTro_Max+1)
			begin
				if(select count(*)
					from TaiTro
					where MaTaiTro=@i)=0
					begin
						set @MaTaiTro=@i
						break
					end
				set @i=@i+1
			end
		end
	set @NgayTaiTro_=CONVERT(smalldatetime,@NgayTaiTro,103)
	insert into TaiTro values(@MaTaiTro,@MaNhaTaiTro,@NgayTaiTro_,@HinhThuc,@SoTien)
end
go
--Cập nhật tài trợ
create proc sp_CapNhatTaiTro
@MaTaiTro int,@MaNhaTaiTro int, @NgayTaiTro nvarchar(19),@HinhThuc nvarchar(100), @SoTien money
as
begin
	declare @NgayTaiTro_ smalldatetime
	set @NgayTaiTro_=CONVERT(smalldatetime,@NgayTaiTro,103)
	update TaiTro
	set MaNhaTaiTro=@MaNhaTaiTro,NgayTaiTro=@NgayTaiTro_,HinhThucTaiTro=@HinhThuc,SoTien=@SoTien
	where MaTaiTro=@MaTaiTro
end
go
--Xóa tài trợ
create proc sp_XoaTaiTro
@MaTaiTro int
as
begin
	delete from TaiTro
	where MaTaiTro=@MaTaiTro
end
go
--Tìm tài trợ
create proc sp_TimTaiTro
@key nvarchar(100)
as
begin
	select MaTaiTro, TenNhaTaiTro,NgayTaiTro,HinhThucTaiTro,SoTien
	from TaiTro,NhaTaiTro
	where TaiTro.MaNhaTaiTro=NhaTaiTro.MaNhaTaiTro and   [dbo].[GetUnsignString](TenNhaTaiTro) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
select MaNhaTaiTro from NhaTaiTro where TenNhaTaiTro=N'Công ty TNHH Hồng Hà'
select * from NhaTaiTro
>>>>>>> 33da1c7067d4c32639b384ed049409ce6d5a8bd2
