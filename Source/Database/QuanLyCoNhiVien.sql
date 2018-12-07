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
	MaNV int not null ,
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
	TrangThai int not null default 0,
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
	primary key(MaTaiTro, MaNhaTaiTro)
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
	MaChiTieu int,
	TenCTChiTieu nvarchar(100) not null,
	SoTien float not null default 0,
	primary key(MaCT_ChiTieu,MaChiTieu)
)
go
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
--Ràng buộc miền giá trị
--Giới tính của trẻ là 'Nam' hoặc 'Nữ'
alter table Tre add constraint GioiTinh_Tre check (GioiTinh in('Nam',N'Nữ'))
go
--Giới tính của nhân viên là 'Nam' hoặc 'Nữ'
alter table NhanVien add constraint GioiTinh_NhanVien check (GioiTinh in('Nam',N'Nữ'))
go
--Trạng thái của trẻ là 0 hoặc 1 với 0 là trẻ không còn ở cô nhi viện, 1 là trẻ đang ở cô nhi viện
alter table Tre add constraint TrangThai_Tre check (TrangThai in(0,1))
go
--Trạng thái của nhân viên là 0 hoặc 1 với 0 là đã nghỉ việc, 1 là đang làm việc
alter table NhanVien add constraint TrangThai_NhanVien check(TrangThai in(0,1))
go
--Tuổi nhân viên phải lớn hơn bằng 18 tuổi
alter table NhanVien add constraint Tuoi_NhanVien check((getDate()-year(NgaySinh))>=18)
go
--Hình thức tài trợ trong bảng tài trợ là 'Tiền mặt', 'Chuyển khoản','Hiện vật'
alter table TaiTro add constraint HinhThucTaiTro check (HinhThucTaiTro in(N'Tiền mặt',N'Chuyển khoản',N'Hiện vật'))
go
--Ràng buộc liên thuộc tính
--Ngày sinh của trẻ phải nhỏ hơn hoặc bằng ngày trẻ vào
alter table Tre add constraint KT_NgaySinh_NgayVao check (NgaySinh<=NgayVao)
go
--Ngày sinh của nhân viên phải nhỏ hơn vào ngày vào làm của nhân viên
alter table NhanVien add constraint KT_NgaySinh_NgayVL check(NgaySinh<NgayVL)
go
-- Trigger cập nhật trạng thái của trẻ có người nhận trẻ
alter trigger trg_ins_CT_NguoiNhanTre_Tre on CT_NguoiNhanTre_Tre
for insert
as
begin
	declare @MaTre int
	select @MaTre =MaTre
	from inserted
	update Tre
	set TrangThai='0'
	where MaTre=@MaTre
end
go
-- Trigger cập nhật trạng thái của trẻ khi xóa 1 chi tiết người nhận trẻ
alter trigger trg_del_CT_NguoiNhanTre_Tre on CT_NguoiNhanTre_Tre
for delete
as
begin
	declare @MaTre int
	select @MaTre =MaTre
	from deleted
	update Tre
	set TrangThai='1'
	where MaTre=@MaTre
end
go
--Trigger kiểm tra xem nhân viên chăm sóc trẻ phải là nhân viên thuộc loại nhân viên bảo mẫu và hiện đang làm việc
create trigger trg_ins_up_Tre on Tre
for insert, update
as
begin
	declare @MaNV int
	select @MaNV=MaNV
	from inserted
	if(select count(*)
		from NhanVien,LoaiNhanVien
		where NhanVien.MaLoaiNV=LoaiNhanVien.MaLoaiNV and MaNV=@MaNV and TenLoaiNV=N'Bảo mẫu' and TrangThai=1)=0
		begin
			print N'Nhân viên chăm sóc trẻ phải là nhân viên bảo mẫu và hiện đang làm việc'
			rollback tran
		end
end
go

--Thêm loại nhân viên
create proc sp_ThemLoaiNhanVien
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
@TenNV nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh nvarchar(19), @DiaChi nvarchar(100), @SoDT nvarchar(10), @NgayVL nvarchar(19), @MaLoaiNV int,@TrangThai int
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
	insert into NhanVien values (@MaNV,@TenNV,@GioiTinh,@NgaySinh_,@DiaChi,@SoDT,@NgayVL_,@MaLoaiNV,@TrangThai)
end
go
--Cập nhật nhân viên
create proc sp_CapNhatNhanVien
@MaNV int,@TenNV nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh nvarchar(19), @DiaChi nvarchar(100), @SoDT nvarchar(10), @NgayVL nvarchar(19), @MaLoaiNV int,@TrangThai int
as
begin
	declare @NgaySinh_ smalldatetime,@NgayVL_ smalldatetime
	set @NgaySinh_=CONVERT(smalldatetime,@NgaySinh,103)
	set @NgayVL_=CONVERT(smalldatetime,@NgayVL,103)
	update NhanVien
	set TenNV=@TenNV, GioiTinh=@GioiTinh,NgaySinh=@NgaySinh_,DiaChi=@DiaChi,SoDT=@SoDT,NgayVL=@NgayVL_,MaLoaiNV=@MaLoaiNV,TrangThai=@TrangThai
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
	select MaNV,TenNV,GioiTinh,NgaySinh,DiaChi,SoDT,NgayVL,TenLoaiNV,TrangThai
	from NhanVien,LoaiNhanVien
	where NhanVien.MaLoaiNV=LoaiNhanVien.MaLoaiNV
end
go 
--Tìm nhân viên
create proc sp_TimNhanVien
@key nvarchar(100)
as
begin
	select MaNV,TenNV,GioiTinh,NgaySinh,DiaChi,SoDT,NgayVL,TenLoaiNV, TrangThai
	from NhanVien ,LoaiNhanVien
	WHERE NhanVien.MaLoaiNV=LoaiNhanVien.MaLoaiNV and [dbo].[GetUnsignString](TenNV) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
--Hiện thị danh sách trẻ
alter proc sp_HienThiDanhSachTre
as 
begin
	select MaTre,TenTre,Tre.NgaySinh,Tre.GioiTinh,NgayVao,HoanCanh,NguoiDuaTreVao,Tre.TrangThai,TenNV
	from Tre,NhanVien
	where Tre.MaNV=NhanVien.MaNV 
end
go
--Hiện thị danh sách trẻ hiện ở cô nhi viện
create proc sp_HienThiDanhSachTreHienOCoNhiVien
as 
begin
	select MaTre,TenTre,Tre.NgaySinh,Tre.GioiTinh,NgayVao,HoanCanh,NguoiDuaTreVao,Tre.TrangThai,TenNV
	from Tre,NhanVien
	where Tre.MaNV=NhanVien.MaNV  and Tre.TrangThai=1
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
exec sp_ThemTre 'a','Nam','1/1/2018','25/11/2018','a','a',1,1
go
select * from Tre
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
	select MaTre,TenTre,Tre.GioiTinh,Tre.NgaySinh,NgayVao,HoanCanh,NguoiDuaTreVao,Tre.TrangThai,TenNV
	from Tre,NhanVien
	where Tre.MaNV=NhanVien.MaNV and [dbo].[GetUnsignString](TenTre) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
--Hiện thi danh sách nhân viên là bảo mẫu hiện đang làm việc
alter proc sp_HienThiDanhSachBaoMau
as
begin
	select MaNV,TenNV,GioiTinh,NgaySinh,DiaChi,SoDT,NgayVL,TenLoaiNV,TrangThai
	from NhanVien,LoaiNhanVien
	where NhanVien.MaLoaiNV=LoaiNhanVien.MaLoaiNV and TenLoaiNV=N'Bảo mẫu' and TrangThai=1
end
go

--LẤY THÔNG TIN CHI TIÊU
CREATE PROC SP_LOADEXPENSE
AS
BEGIN
	SELECT * FROM ChiTieu
END
GO
--THÊM CHI TIÊU
create PROC SP_INSERTEXPENSE
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
ALTER PROC SP_ThemCTCT
@MaChiTieu int, @TenCTChiTieu nvarchar(100), @SoTien float
AS
BEGIN
	DECLARE @Max_MaCT_ChiTieu int, @i int

	SELECT @Max_MaCT_ChiTieu = MAX(MaCT_ChiTieu)
	FROM CT_ChiTieu
	WHERE MaChiTieu = @MaChiTieu
	GROUP BY MaChiTieu
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
go
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
go
-- TÌM KIẾM CT_CHITIEU THEO NGÀY
create PROC SP_SEARCHEXPENSEINFO
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
go
--TRIGGER KHI THÊM, SỬA CT_CHITIEU
create TRIGGER TRG_INSUP_CT_CHITIEU ON CT_CHITIEU
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
go
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
alter proc sp_ThemTaiTro
@MaNhaTaiTro int, @NgayTaiTro nvarchar(19),@HinhThuc nvarchar(100), @SoTien money
as
begin
	declare @MaTaiTro int,@MaTaiTro_Max int,@i int=1, @NgayTaiTro_ smalldatetime
	if(select count(*)
		from NhaTaiTro
		where MaNhaTaiTro=@MaNhaTaiTro)=0
		print N'Mã nhà tài trợ không tồn taị'
	else
	begin
		set @MaTaiTro_Max=(select max(MaTaiTro)
							from TaiTro
							where MaNhaTaiTro=@MaNhaTaiTro)
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
	set NgayTaiTro=@NgayTaiTro_,HinhThucTaiTro=@HinhThuc,SoTien=@SoTien
	where MaTaiTro=@MaTaiTro and MaNhaTaiTro=@MaNhaTaiTro
end
go
--Xóa tài trợ
alter proc sp_XoaTaiTro
@MaTaiTro int,@MaNhaTaiTro int
as
begin
	delete from TaiTro
	where MaTaiTro=@MaTaiTro and MaNhaTaiTro=@MaNhaTaiTro
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
--Hiện thị danh sách người nhận trẻ
create proc sp_HienThiDanhSachNguoiNhanTre
as
begin
	select * from NguoiNhanTre
end
go
-- Thêm người nhân nuôi trẻ
create proc sp_ThemNguoiNhanTre
@TenNguoiNhan nvarchar(100), @DiaChi nvarchar(100), @SoDT nvarchar(10)
as
begin
	declare @MaNguoiNhan int, @MaNguoiNhan_Max int,@i int =1
	set @MaNguoiNhan_Max=(select max(MaNguoiNhan)
							from NguoiNhanTre)
	if(@MaNguoiNhan_Max is null)
		set @MaNguoiNhan=@i
	else
		begin
			while(@i<=@MaNguoiNhan_Max+1)
				begin
					if(select count(*)
						from NguoiNhanTre
						where MaNguoiNhan=@i)=0
						begin
							set @MaNguoiNhan=@i
							break
						end
					set @i=@i+1
				end
		end
	insert into NguoiNhanTre values(@MaNguoiNhan,@TenNguoiNhan,@DiaChi,@SoDT)
end
go
--Cập nhật người nhận trẻ
create proc sp_CapNhatNguoiNhanTre
@MaNguoiNhan int, @TenNguoiNhan nvarchar(100), @DiaChi nvarchar(100), @SoDT nvarchar(10)
as
begin
	update NguoiNhanTre
	set TenNguoiNhan=@TenNguoiNhan,DiaChi=@DiaChi,SoDT=@SoDT
	where MaNguoiNhan=@MaNguoiNhan
end
go
--Tra cứu người nhận trẻ
create proc sp_TraCuuNguoiNhanTre
@key nvarchar(100)
as
begin
	select *
	from NguoiNhanTre
	where [dbo].[GetUnsignString](TenNguoiNhan) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'

end
go
--Hiện thị chi tiết người nhận trẻ 
create proc sp_HienThiChiTietNguoiNhanTre
as
begin
	select TenNguoiNhan ,TenTre ,NgayNhan
	from NguoiNhanTre,CT_NguoiNhanTre_Tre,Tre
	where NguoiNhanTre.MaNguoiNhan=CT_NguoiNhanTre_Tre.MaNguoiNhan and Tre.MaTre=CT_NguoiNhanTre_Tre.MaTre
end
go
exec sp_HienThiChiTietNguoiNhanTre
--Thêm chi tiết người nhận trẻ
alter proc sp_ThemChiTietNhanTre
@MaNguoiNhan int, @MaTre int, @NgayNhan nvarchar(19)
as
begin
	declare @NgayNhan_ smalldatetime
	set @NgayNhan_=CONVERT(smalldatetime,@NgayNhan,103)
	insert into CT_NguoiNhanTre_Tre values(@MaNguoiNhan,@MaTre,@NgayNhan_)
end
go
--Cập nhật chi tiết người nhận trẻ
alter proc sp_CapNhatChiTietNhanTre
@MaNguoiNhan int, @MaTre int, @NgayNhan nvarchar(19)
as
begin
	declare @NgayNhan_ smalldatetime
	set @NgayNhan_=CONVERT(smalldatetime,@NgayNhan,103)
	update CT_NguoiNhanTre_Tre
	set NgayNhan=@NgayNhan_
	where MaTre=@MaTre and MaNguoiNhan=@MaNguoiNhan
end
go
--Xóa chi tiết người nhận trẻ
create proc sp_XoaChiTietNhanTre
@MaNguoiNhan int, @MaTre int
as
begin
	delete from CT_NguoiNhanTre_Tre
	where MaNguoiNhan=@MaNguoiNhan and MaTre=@MaTre
end
go
--Tìm chi tiết người nhận trẻ theo tên trẻ
create proc sp_TraCuuChiTietNguoiNhanTreTheoTenTre
@key nvarchar(100)
as
begin
	select TenNguoiNhan ,TenTre ,NgayNhan
	from NguoiNhanTre,CT_NguoiNhanTre_Tre,Tre
	where NguoiNhanTre.MaNguoiNhan=CT_NguoiNhanTre_Tre.MaNguoiNhan and Tre.MaTre=CT_NguoiNhanTre_Tre.MaTre
	and [dbo].[GetUnsignString](TenTre) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
--Tìm chi tiết người nhận trẻ theo tên người nhận
create proc sp_TimChiTietNguoiNhanTreTheoTenNguoiNhan
@key nvarchar(100)
as
begin
	select TenNguoiNhan ,TenTre ,NgayNhan
	from NguoiNhanTre,CT_NguoiNhanTre_Tre,Tre
	where NguoiNhanTre.MaNguoiNhan=CT_NguoiNhanTre_Tre.MaNguoiNhan and Tre.MaTre=CT_NguoiNhanTre_Tre.MaTre
	and [dbo].[GetUnsignString](TenNguoiNhan) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
-- BÁO CÁO TRẺ THÊM MỚI
alter PROC SP_BaoCaoTreThemMoi
@TuNgay nvarchar(19), @DenNgay nvarchar(19)
AS
BEGIN
	
	DECLARE @TuNgay_ smalldatetime, @DenNgay_ smalldatetime
	SET @TuNgay_ = CONVERT(smalldatetime, @TuNgay, 103)
	SET @DenNgay_ = CONVERT(smalldatetime, @DenNgay, 103)

	SELECT MaTre, TenTre, Tre.GioiTinh, Tre.NgaySinh, NgayVao, HoanCanh, NguoiDuaTreVao, Tre.TrangThai, TenNV 
	FROM Tre, NhanVien
	WHERE Tre.MaNV = NhanVien.MaNV AND NgayVao >= @TuNgay_ AND NgayVao <= @DenNgay_
END

exec SP_BaoCaoTreThemMoi '1-1-2017', '1-12-2018'

GO
-- BÁO CÁO TRẺ ĐƯỢC NHẬN NUÔI
CREATE PROC SP_BaoCaoTreDuocNhanNuoi
@TuNgay nvarchar(19), @DenNgay nvarchar(19)
AS
BEGIN
	
	DECLARE @TuNgay_ smalldatetime, @DenNgay_ smalldatetime
	SET @TuNgay_ = CONVERT(smalldatetime, @TuNgay, 103)
	SET @DenNgay_ = CONVERT(smalldatetime, @DenNgay, 103)

	SELECT Tre.MaTre, TenTre, Tre.GioiTinh, Tre.NgaySinh, NgayVao, HoanCanh, NguoiDuaTreVao, Tre.TrangThai, TenNV 
	FROM Tre, NhanVien, CT_NguoiNhanTre_Tre
	WHERE Tre.MaNV = NhanVien.MaNV AND Tre.MaTre = CT_NguoiNhanTre_Tre.MaTre AND  NgayNhan >= @TuNgay_ AND NgayNhan <= @DenNgay_
END
GO
--BÁO CÁO TRẺ ĐANG Ở CÔ NHI VIỆN
alter PROC SP_BaoCaoTreDangOCoNhiVien
@TuTuoi int, @DenTuoi int
AS
BEGIN
	IF(@TuTuoi = 0 OR @DenTuoi = 0)
	BEGIN
		SELECT MaTre, TenTre, Tre.GioiTinh, Tre.NgaySinh, NgayVao, HoanCanh, NguoiDuaTreVao, Tre.TrangThai, TenNV 
		FROM Tre, NhanVien
		WHERE Tre.MaNV = NhanVien.MaNV AND Tre.TrangThai = 1
	END
	ELSE
	BEGIN
		SELECT MaTre, TenTre, Tre.GioiTinh, Tre.NgaySinh, NgayVao, HoanCanh, NguoiDuaTreVao, Tre.TrangThai, TenNV 
		FROM Tre, NhanVien
		WHERE Tre.MaNV = NhanVien.MaNV AND Tre.TrangThai = 1 AND (DATEDIFF(YEAR, Tre.NgaySinh, GETDATE()) >= @TuTuoi) AND (DATEDIFF(YEAR, Tre.NgaySinh, GETDATE()) <= @DenTuoi)
	END	
END
GO
-- THỐNG KÊ SỐ LƯỢNG TRẺ NAM ĐANG Ở CÔ NHI VIỆN
CREATE PROC SP_ThongKeTreNam
AS
BEGIN
	SELECT COUNT (*) AS Nam
	FROM Tre
	WHERE GioiTinh = 'Nam' AND TrangThai = 1
END
GO

--THỐNG KÊ SỐ LƯỢNG TRẺ NỮ ĐANG Ở CÔ NHI VIỆN
CREATE PROC SP_ThongKeTreNu
AS
BEGIN
	SELECT COUNT (*) Nu
	FROM Tre
	WHERE GioiTinh = N'Nữ' AND TrangThai = 1
END
GO
--THỐNG KÊ TỔNG TIỀN TÀI TRỢ TRONG KHOẢNG THỜI GIAN
ALTER PROC SP_ThongKeTaiTro
@TuNgay nvarchar(19), @DenNgay nvarchar(19)
AS
BEGIN
	DECLARE @TuNgay_ smalldatetime, @DenNgay_ smalldatetime
	SET @TuNgay_ = CONVERT(smalldatetime, @TuNgay, 103)
	SET @DenNgay_ = CONVERT(smalldatetime, @DenNgay, 103)

	SELECT SUM(SoTien) AS TienTaiTro
	FROM TaiTro
	WHERE @TuNgay_ <= NgayTaiTro AND NgayTaiTro <= @DenNgay_

END
exec SP_ThongKeTaiTro '1-1-2017', '5-12-2018'
GO
--THỐNG KÊ SỐ TIỀN CHI TIÊU TRONG KHOẢNG THỜI GIAN
ALTER PROC SP_ThongKeChiTieu
@TuNgay nvarchar(19), @DenNgay nvarchar(19)
AS
BEGIN
	DECLARE @TuNgay_ smalldatetime, @DenNgay_ smalldatetime
	SET @TuNgay_ = CONVERT(smalldatetime, @TuNgay, 103)
	SET @DenNgay_ = CONVERT(smalldatetime, @DenNgay, 103)

	SELECT SUM(TongSoTien) AS TienChiTieu
	FROM ChiTieu
	WHERE @TuNgay_ <= NgayChi AND NgayChi <= @DenNgay_

END

exec SP_ThongKeChiTieu '1-1-2017', '5-12-2018'

GO
--THỐNG KÊ QUỸ TIỀN CÒN LẠI
ALTER PROC SP_ThongKeQuy
AS
BEGIN
	DECLARE @TienTaiTro float, @TienChi float

	SELECT @TienTaiTro = SUM(SoTien)
	FROM TaiTro

	SELECT @TienChi = SUM(TongSoTien)
	FROM ChiTieu

	SELECT (@TienTaiTro - @TienChi) AS Quy
END
