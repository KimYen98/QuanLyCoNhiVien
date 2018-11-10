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