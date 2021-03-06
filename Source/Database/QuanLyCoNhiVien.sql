﻿fcreate database QuanLyCoNhiVien
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
	SoTien money not null default 0,
	primary key(MaTaiTro, MaNhaTaiTro)
)
go
--Tạo bảng chi tiêu
create table ChiTieu
(
	MaChiTieu int,
	TenChiTieu nvarchar(100) not null,
	NgayChi smalldatetime not null,
	TongSoTien money not null default 0,
	primary key(MaChiTieu)
)
go
--Tạo bảng chi tiết chi tiêu
create table CT_ChiTieu
(
	MaCT_ChiTieu int,
	MaChiTieu int,
	TenCTChiTieu nvarchar(100) not null,
	SoTien money not null default 0,
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
insert into TaiKhoan values('admin','123','ADMIN')
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
create trigger ins_up_NgaySinhNhanVien on NhanVien
for insert, update
as
begin
	declare @MaNV int, @NgaySinh smalldatetime
	select @MaNV=MaNV, @NgaySinh=NgaySinh
	from inserted
	if(year(getdate())-year(@NgaySinh)<18)
		begin
			print N'Tuổi của nhân viên phải lớn hơn bằng 18'
			rollback tran
		end
end
go
update NhanVien
set NgaySinh='1/1/2002'
where MaNV=1
--Hình thức tài trợ trong bảng tài trợ là 'Tiền mặt', 'Chuyển khoản','Hiện vật'
alter table TaiTro add constraint HinhThucTaiTro check (HinhThucTaiTro in(N'Tiền mặt',N'Chuyển khoản',N'Hiện vật'))
go
update TaiTro
set HinhThucTaiTro=N'Quyên góp'
where MaTaiTro=1 and MaNhaTaiTro=1
select * from TaiTro
--Ràng buộc liên thuộc tính
--Ngày sinh của trẻ phải nhỏ hơn hoặc bằng ngày trẻ vào
alter table Tre add constraint KT_NgaySinh_NgayVao check (NgaySinh<=NgayVao)
go
update Tre
set NgaySinh='30/12/2018'
where MaTre=1
select * from Tre
--Ngày sinh của nhân viên phải nhỏ hơn vào ngày vào làm của nhân viên
alter table NhanVien add constraint KT_NgaySinh_NgayVL check(NgaySinh<NgayVL)
go
update NhanVien
set NgayVL='1/1/1970'
where MaNV=1
GO
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
	select * 
	from LoaiNhanVien
	WHERE [dbo].[GetUnsignString](TenLoaiNV) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
--Thêm nhân viên
create proc sp_ThemNhanVien
@TenNV nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh smalldatetime, @DiaChi nvarchar(100), 
@SoDT nvarchar(10), @NgayVL smalldatetime, @MaLoaiNV int,@TrangThai int
as
begin
	declare  @MaNV int, @MaNV_Max int,@i int =1
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
	insert into NhanVien values (@MaNV,@TenNV,@GioiTinh,@NgaySinh,@DiaChi,@SoDT,@NgayVL,@MaLoaiNV,@TrangThai)
end
go
--Cập nhật nhân viên
create proc sp_CapNhatNhanVien
@MaNV int,@TenNV nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh smalldatetime, @DiaChi nvarchar(100), @SoDT nvarchar(10), 
@NgayVL smalldatetime, @MaLoaiNV int,@TrangThai int
as
begin
	update NhanVien
	set TenNV=@TenNV, GioiTinh=@GioiTinh,NgaySinh=@NgaySinh,DiaChi=@DiaChi,SoDT=@SoDT,NgayVL=@NgayVL,MaLoaiNV=@MaLoaiNV,TrangThai=@TrangThai
	where MaNV=@MaNV
end
go
--Hiển thị danh sách nhân viên
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
--Hiển thị danh sách trẻ
create proc sp_HienThiDanhSachTre
as 
begin
	select MaTre,TenTre,Tre.NgaySinh,Tre.GioiTinh,NgayVao,HoanCanh,NguoiDuaTreVao,Tre.TrangThai,TenNV
	from Tre,NhanVien
	where Tre.MaNV=NhanVien.MaNV 
end
go
--Hiển thị danh sách trẻ hiện ở cô nhi viện
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
@TenTre nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh smalldatetime,@NgayVao smalldatetime, @HoanCanh nvarchar(4000),
@NguoiDuaTreVao nvarchar(100), @TrangThai int,@MaNV int
as
begin
	declare @MaTre int, @MaTre_Max int, @i int =1
	set @MaTre_Max=(select max(MaTre)
					from Tre with(holdlock,updlock))
	if(@MaTre_Max is null)
		set @MaTre=@i
	else
	begin
		while(@i<=@MaTre_Max+1)
			begin
				if(select count(*)
					from Tre with(holdlock,updlock)
					where MaTre=@i)=0
					begin
						set @MaTre=@i
						break
					end
			set @i=@i+1
			end
	end
	waitfor delay '00:00:10'
	insert into Tre with (holdlock,updlock) values(@MaTre,@TenTre,@GioiTinh,@NgaySinh,@NgayVao,@HoanCanh,@NguoiDuaTreVao,@TrangThai,@MaNV)
end
go
exec sp_ThemTre 'a','Nam','1/1/2018','25/11/2018','a','a',1,1
go
 --Cập nhật trẻ
 create proc sp_CapNhatTre
@MaTre int, @TenTre nvarchar(100), @GioiTinh nvarchar(100), @NgaySinh smalldatetime,@NgayVao smalldatetime, @HoanCanh nvarchar(4000),
@NguoiDuaTreVao nvarchar(100), 
@TrangThai int,@MaNV int
as
begin
	update Tre
	set TenTre=@TenTre,GioiTinh=@GioiTinh,NgaySinh=@NgaySinh,NgayVao=@NgayVao,HoanCanh=@HoanCanh,NguoiDuaTreVao=@NguoiDuaTreVao,
	TrangThai=@TrangThai,MaNV=@MaNV
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
--Hiển thi danh sách nhân viên là bảo mẫu hiện đang làm việc
alter proc sp_HienThiDanhSachBaoMau
as
begin
	select MaNV,TenNV,GioiTinh,NgaySinh,DiaChi,SoDT,NgayVL,TenLoaiNV,TrangThai
	from NhanVien,LoaiNhanVien
	where NhanVien.MaLoaiNV=LoaiNhanVien.MaLoaiNV and TenLoaiNV=N'Bảo mẫu' and TrangThai=1
end
go



--Thêm chi tiêu
create PROC SP_ThemChiTieu
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
--Cập nhật chi tiêu
CREATE PROC SP_CapNhatChiTieu
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

CREATE PROC SP_XoaChiTieu
@MaChiTieu int
AS
BEGIN
	DELETE FROM ChiTieu 
	WHERE MaChiTieu = @MaChiTieu
END
GO
--TÌM KIẾM CHI TIÊU THEO THỜI GIAN

CREATE PROC SP_TimChiTieu
@Month int, @Year int
AS
BEGIN
	SELECT * 
	FROM ChiTieu
	WHERE MONTH(NgayChi) = @Month AND YEAR(NgayChi) = @Year
END
GO
-- LẤY THÔNG TIN CHI TIẾT CHI TIÊU

CREATE PROC SP_HienThiCTCT
@MaChiTieu int
AS
BEGIN
	SELECT MaChiTieu, MaCT_ChiTieu, TenCTChiTieu, SoTien
	FROM CT_ChiTieu
	WHERE MaChiTieu = @MaChiTieu
END
GO
select * from CT_ChiTieu
-- Thêm chi tiết chi tiêu
exec SP_ThemCTCT 1, 'a',1
alter PROC SP_ThemCTCT
@MaChiTieu int, @TenCTChiTieu nvarchar(100), @SoTien money
AS
BEGIN
	DECLARE @Max_MaCT_ChiTieu int, @i int

	SELECT @Max_MaCT_ChiTieu = MAX(MaCT_ChiTieu)
	FROM CT_ChiTieu
	WHERE MaChiTieu = @MaChiTieu
	GROUP BY MaChiTieu
	SET @i = 1

	IF(@Max_MaCT_ChiTieu IS NULL)
		INSERT INTO CT_ChiTieu VALUES(@i,@MaChiTieu, @TenCTChiTieu, @SoTien)
	ELSE
	BEGIN
		WHILE(@i <= @Max_MaCT_ChiTieu + 1)
		BEGIN
			IF((SELECT COUNT(*) FROM CT_ChiTieu WHERE MaCT_ChiTieu = @i) < 1)
			BEGIN
				INSERT INTO CT_ChiTieu VALUES(@i,@MaChiTieu, @TenCTChiTieu, @SoTien)
				BREAK
			END
			SET @i = @i + 1
		END
	END
END
go

-- CẬP NHẬT CT_CHITIEU

CREATE PROC SP_CapNhatCTCT
@MaChiTieu int, @MaCT_ChiTieu int, @TenCTChiTieu nvarchar(100), @SoTien float
AS
BEGIN
	UPDATE CT_ChiTieu
	SET TenCTChiTieu = @TenCTChiTieu, SoTien = @SoTien
	WHERE MaCT_ChiTieu = @MaCT_ChiTieu AND MaChiTieu = @MaChiTieu
END
GO
-- XOÁ CT_CHITIEU

CREATE PROC SP_XoaCTCT
@MaChiTieu int, @MaCT_ChiTieu int
AS
BEGIN
	DELETE FROM CT_ChiTieu
	WHERE MaCT_ChiTieu = @MaCT_ChiTieu AND MaChiTieu = @MaChiTieu
END
go
-- TÌM KIẾM CT_CHITIEU THEO NGÀY
-- Tra cứu chi tiết chi tiêu theo ngày
create PROC SP_TimKiemCTCT
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
GO
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
--Thêm nhà tài trợ
create proc sp_ThemNhaTaiTro
@TenNhaTaiTro nvarchar(100),@SoDT nvarchar(10), @DiaChi nvarchar(100)
as
begin
	declare @MaNhaTaiTro int, @MaNhaTaiTro_Max int ,@i int=1
	set @MaNhaTaiTro_Max=(select Max(MaNhaTaiTro) 
							from NhaTaiTro with(holdlock,updlock))
	if(@MaNhaTaiTro_Max is null)
		set @MaNhaTaiTro=@i
	else
		begin
		while(@i<=@MaNhaTaiTro_Max+1)
			begin
				if(select count(*)
					from NhaTaiTro with(holdlock,updlock)
					where MaNhaTaiTro=@i)=0
					begin
						set @MaNhaTaiTro=@i
						break
					end
					set @i=@i+1
			end

		end
	waitfor delay '00:00:10'
	insert into NhaTaiTro with(holdlock,updlock) values(@MaNhaTaiTro,@TenNhaTaiTro,@SoDT,@DiaChi)
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
@MaNhaTaiTro int, @NgayTaiTro smalldatetime,@HinhThuc nvarchar(100), @SoTien money
as
begin
	declare @MaTaiTro int,@MaTaiTro_Max int,@i int=1
	if(select count(*)
		from NhaTaiTro
		where MaNhaTaiTro=@MaNhaTaiTro)=0
		print N'Mã nhà tài trợ không tồn taị'
	else
	begin
		set @MaTaiTro_Max=(select max(MaTaiTro)
							from TaiTro
							where MaNhaTaiTro=@MaNhaTaiTro
							group by MaNhaTaiTro)
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
		insert into TaiTro values(@MaTaiTro,@MaNhaTaiTro,@NgayTaiTro,@HinhThuc,@SoTien)
	end
end
go
exec sp_HienThiDanhSachTaiTro
go
--Cập nhật tài trợ
create proc sp_CapNhatTaiTro
@MaTaiTro int,@MaNhaTaiTro int, @NgayTaiTro smalldatetime,@HinhThuc nvarchar(100), @SoTien money
as
begin
	update TaiTro
	set NgayTaiTro=@NgayTaiTro,HinhThucTaiTro=@HinhThuc,SoTien=@SoTien
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
-- Thêm người nhận nuôi trẻ
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
--Hiện thị chi tiết nhận trẻ 
create proc sp_HienThiChiTietNguoiNhanTre
as
begin
	select TenNguoiNhan ,TenTre ,NgayNhan
	from NguoiNhanTre,CT_NguoiNhanTre_Tre,Tre
	where NguoiNhanTre.MaNguoiNhan=CT_NguoiNhanTre_Tre.MaNguoiNhan and Tre.MaTre=CT_NguoiNhanTre_Tre.MaTre
end
go
--Tìm chi tiết nhận trẻ theo tên trẻ
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
--Tìm chi tiết nhận trẻ theo tên người nhận
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

-- Báo cáo trẻ thêm mới
create PROC SP_BaoCaoTreThemMoi
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
GO
-- Báo cáo trẻ được nhận nuôi
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

-- Báo cáo trẻ đang ở cô nhi viện
create PROC SP_BaoCaoTreDangOCoNhiVien
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
		WHERE Tre.MaNV = NhanVien.MaNV AND Tre.TrangThai = 1 AND (DATEDIFF(YEAR, Tre.NgaySinh, GETDATE()) >= @TuTuoi) 
			  AND (DATEDIFF(YEAR, Tre.NgaySinh, GETDATE()) <= @DenTuoi)
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

--Thống kê tổng tiền tài trợ trong khoảng thời gian
CREATE PROC SP_ThongKeTaiTro
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
GO

--Thống kê số tiền chi tiêu trong khoảng thời gian
CREATE PROC SP_ThongKeChiTieu
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

--Thống kê quỹ tiền còn lại
CREATE PROC SP_ThongKeQuy
AS
BEGIN
	DECLARE @TienTaiTro float, @TienChi float

	SELECT @TienTaiTro = SUM(SoTien)
	FROM TaiTro
	SELECT @TienChi = SUM(TongSoTien)
	FROM ChiTieu
	SELECT (@TienTaiTro - @TienChi) AS Quy
END
GO
--Tìm trẻ còn ở cô nhi viện
create proc sp_TimTreConOCoNhiVien
@key nvarchar(100)
as
begin
	select MaTre,TenTre,Tre.GioiTinh,Tre.NgaySinh,NgayVao,HoanCanh,NguoiDuaTreVao,Tre.TrangThai,TenNV
	from Tre,NhanVien
	where Tre.MaNV=NhanVien.MaNV and Tre.TrangThai=1 and [dbo].[GetUnsignString](TenTre) LIKE N'%' + [dbo].[GetUnsignString](@key) + '%'
end
go
--Đăng nhập
create proc sp_DangNhap
@TenDangNhap nvarchar(100), @MatKhau nvarchar(100)
as
begin
	SELECT *
	FROM TaiKhoan
	WHERE TenDangNhap=@TenDangNhap and MatKhau=@MatKhau
end