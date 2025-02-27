USE [master]
GO
/****** Object:  Database [QuanLyNhanVien_Java]    Script Date: 12/12/2023 9:02:06 CH ******/
CREATE DATABASE [QuanLyNhanVien_Java]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyNhanVien_Java', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QuanLyNhanVien_Java.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyNhanVien_Java_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QuanLyNhanVien_Java_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyNhanVien_Java].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET QUERY_STORE = ON
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QuanLyNhanVien_Java]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 12/12/2023 9:02:06 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[ChucVu] [nvarchar](50) NOT NULL,
	[HeSoLuong] [float] NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[ChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 12/12/2023 9:02:06 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[MaND] [nchar](10) NOT NULL,
	[TenDangNhap] [nchar](50) NULL,
	[MatKhau] [nchar](50) NULL,
	[VaiTro] [nchar](10) NULL,
 CONSTRAINT [PK_NguoiDung] PRIMARY KEY CLUSTERED 
(
	[MaND] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/12/2023 9:02:06 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nchar](10) NOT NULL,
	[MaND] [nchar](10) NULL,
	[Ten] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[STK] [nchar](30) NULL,
	[SDT] [nchar](20) NULL,
	[email] [nchar](50) NULL,
	[ChucVu] [nvarchar](50) NULL,
	[ChamCong] [int] NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChucVu] ([ChucVu], [HeSoLuong]) VALUES (N'0', 0)
INSERT [dbo].[ChucVu] ([ChucVu], [HeSoLuong]) VALUES (N'Bán Hàng', 30000)
INSERT [dbo].[ChucVu] ([ChucVu], [HeSoLuong]) VALUES (N'Chăm sóc khách hàng', 20000)
INSERT [dbo].[ChucVu] ([ChucVu], [HeSoLuong]) VALUES (N'Đóng hàng', 30000)
INSERT [dbo].[ChucVu] ([ChucVu], [HeSoLuong]) VALUES (N'Nhân Viên Kho', 25000)
INSERT [dbo].[ChucVu] ([ChucVu], [HeSoLuong]) VALUES (N'test', 10000)
GO
INSERT [dbo].[NguoiDung] ([MaND], [TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'1         ', N'admin                                             ', N'Abc                                               ', N'Admin     ')
INSERT [dbo].[NguoiDung] ([MaND], [TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'2         ', N'hung                                              ', N'123                                               ', N'User      ')
INSERT [dbo].[NguoiDung] ([MaND], [TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'3         ', N'hoang                                             ', N'123                                               ', N'User      ')
INSERT [dbo].[NguoiDung] ([MaND], [TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'4         ', N'lam                                               ', N'123                                               ', N'User      ')
INSERT [dbo].[NguoiDung] ([MaND], [TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'5         ', N'hung1                                             ', N'123                                               ', N'Admin     ')
INSERT [dbo].[NguoiDung] ([MaND], [TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'6         ', N'Lam                                               ', N'Lam                                               ', N'User      ')
INSERT [dbo].[NguoiDung] ([MaND], [TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'7         ', N'nvhung                                            ', N'123                                               ', N'User      ')
GO
INSERT [dbo].[NhanVien] ([MaNV], [MaND], [Ten], [NgaySinh], [DiaChi], [GioiTinh], [STK], [SDT], [email], [ChucVu], [ChamCong]) VALUES (N'NV01      ', N'1         ', N'Hoàng Mạnh Hùng', CAST(N'2003-10-04' AS Date), N'Hà Nội', N'Nam', N'mb: 0327765479                ', N'0327765479          ', N'kbmkhkkb@gmail.com                                ', N'Đóng hàng', 38)
INSERT [dbo].[NhanVien] ([MaNV], [MaND], [Ten], [NgaySinh], [DiaChi], [GioiTinh], [STK], [SDT], [email], [ChucVu], [ChamCong]) VALUES (N'NV02      ', N'2         ', N'hùng 2003', CAST(N'2006-12-07' AS Date), N'cụm 5 hạ mỗ ', N'Nam', N'mb: 0327765479                ', N'0327765479          ', N'không có                                          ', N'Bán Hàng', 21)
INSERT [dbo].[NhanVien] ([MaNV], [MaND], [Ten], [NgaySinh], [DiaChi], [GioiTinh], [STK], [SDT], [email], [ChucVu], [ChamCong]) VALUES (N'NV03      ', N'3         ', N'Hùng', CAST(N'2004-02-02' AS Date), N'Hà Tây', N'Nam', N'không có                      ', N'no                  ', N'no                                                ', N'Đóng hàng', 50)
INSERT [dbo].[NhanVien] ([MaNV], [MaND], [Ten], [NgaySinh], [DiaChi], [GioiTinh], [STK], [SDT], [email], [ChucVu], [ChamCong]) VALUES (N'NV04      ', N'4         ', N'lâm', CAST(N'2001-02-02' AS Date), N'hà nội', N'Nam', N'no                            ', N'no                  ', N'no                                                ', N'Nhân Viên Kho', 21)
INSERT [dbo].[NhanVien] ([MaNV], [MaND], [Ten], [NgaySinh], [DiaChi], [GioiTinh], [STK], [SDT], [email], [ChucVu], [ChamCong]) VALUES (N'NV05      ', N'5         ', N'123', CAST(N'2003-02-02' AS Date), N'asdasd', N'Nam', N'                              ', N'                    ', N'                                                  ', N'Chăm sóc khách hàng', 0)
INSERT [dbo].[NhanVien] ([MaNV], [MaND], [Ten], [NgaySinh], [DiaChi], [GioiTinh], [STK], [SDT], [email], [ChucVu], [ChamCong]) VALUES (N'NV06      ', N'6         ', N'Trí Văn Lâm', CAST(N'2004-02-04' AS Date), N'ád', N'04/02/2004', N'mb:99999                      ', N'0327765479          ', N'no                                                ', N'test', 0)
INSERT [dbo].[NhanVien] ([MaNV], [MaND], [Ten], [NgaySinh], [DiaChi], [GioiTinh], [STK], [SDT], [email], [ChucVu], [ChamCong]) VALUES (N'NV07      ', N'7         ', N'hưng', CAST(N'2003-04-10' AS Date), N'hà nội', N'10/04/2003', N'                              ', N'                    ', N'khong                                             ', N'Nhân Viên Kho', 0)
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([ChucVu])
REFERENCES [dbo].[ChucVu] ([ChucVu])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_NguoiDung] FOREIGN KEY([MaND])
REFERENCES [dbo].[NguoiDung] ([MaND])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_NguoiDung]
GO
USE [master]
GO
ALTER DATABASE [QuanLyNhanVien_Java] SET  READ_WRITE 
GO
