USE [master]
GO
/****** Object:  Database [J3SP0014_Trekking_and_Hiking]    Script Date: 1/17/2021 2:02:05 PM ******/
CREATE DATABASE [J3SP0014_Trekking_and_Hiking]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'J3SP0014_Trekking_and_Hiking', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\J3SP0014_Trekking_and_Hiking.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'J3SP0014_Trekking_and_Hiking_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\J3SP0014_Trekking_and_Hiking_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [J3SP0014_Trekking_and_Hiking].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET ARITHABORT OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET  ENABLE_BROKER 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET RECOVERY FULL 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET  MULTI_USER 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET DB_CHAINING OFF 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'J3SP0014_Trekking_and_Hiking', N'ON'
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET QUERY_STORE = OFF
GO
USE [J3SP0014_Trekking_and_Hiking]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 1/17/2021 2:02:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[short_desc] [ntext] NULL,
	[image] [varchar](255) NULL,
	[link] [varchar](255) NULL,
 CONSTRAINT [PK__Catagori__3213E83F93E64FE8] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Diary]    Script Date: 1/17/2021 2:02:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diary](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NULL,
	[description] [ntext] NULL,
	[image] [varchar](255) NULL,
 CONSTRAINT [PK__Diary__3213E83FAB5AAC86] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Home]    Script Date: 1/17/2021 2:02:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Home](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NULL,
	[description] [ntext] NULL,
	[image] [varchar](255) NULL,
 CONSTRAINT [PK__Home__3213E83F07B5D882] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhotoAlbum]    Script Date: 1/17/2021 2:02:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhotoAlbum](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
	[image] [varchar](255) NULL,
 CONSTRAINT [PK__Photo_Al__3213E83F92D009F7] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SocialNetwork]    Script Date: 1/17/2021 2:02:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SocialNetwork](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[link] [varchar](255) NULL,
	[icon] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TrekkingLink]    Script Date: 1/17/2021 2:02:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TrekkingLink](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NULL,
	[short_desc] [ntext] NULL,
	[link] [varchar](255) NULL,
 CONSTRAINT [PK__Useful_L__3213E83FABD9575B] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[View]    Script Date: 1/17/2021 2:02:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[View](
	[viewed] [int] NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([id], [name], [short_desc], [image], [link]) VALUES (1, N'Our Diary', N'Typi non habent claritatem insitam liber.', N'/Trekking_and_Hiking/View/Image/Categories/our-diary.jpg', N'our-diary')
INSERT [dbo].[Category] ([id], [name], [short_desc], [image], [link]) VALUES (2, N'Photo Album', N'Duis autem vel eum iriure dolor soluta habent.', N'/Trekking_and_Hiking/View/Image/Categories/photo-album.jpg', N'photo-album')
INSERT [dbo].[Category] ([id], [name], [short_desc], [image], [link]) VALUES (3, N'Trekking Links', N'Nam liber tempor cum soluta nobis eleifend habent.', N'/Trekking_and_Hiking/View/Image/Categories/trekking-links.jpg', N'trekking-link')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Diary] ON 

INSERT [dbo].[Diary] ([id], [title], [description], [image]) VALUES (1, N'Day 1', N'Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.', N'/Trekking_and_Hiking/View/Image/Diary/day1.jpg')
INSERT [dbo].[Diary] ([id], [title], [description], [image]) VALUES (2, N'Day 2', N'Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius.', NULL)
INSERT [dbo].[Diary] ([id], [title], [description], [image]) VALUES (3, N'Day 3', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.', N'/Trekking_and_Hiking/View/Image/Diary/day3.jpg')
INSERT [dbo].[Diary] ([id], [title], [description], [image]) VALUES (4, N'Day 4', N'Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.', NULL)
SET IDENTITY_INSERT [dbo].[Diary] OFF
GO
SET IDENTITY_INSERT [dbo].[Home] ON 

INSERT [dbo].[Home] ([id], [title], [description], [image]) VALUES (1, N'Welcome', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius.', N'/Trekking_and_Hiking/View/Image/Home/welcome.jpg')
INSERT [dbo].[Home] ([id], [title], [description], [image]) VALUES (2, N'Hello', NULL, NULL)
SET IDENTITY_INSERT [dbo].[Home] OFF
GO
SET IDENTITY_INSERT [dbo].[PhotoAlbum] ON 

INSERT [dbo].[PhotoAlbum] ([id], [name], [image]) VALUES (1, N'Pic 1', N'/Trekking_and_Hiking/View/Image/Photo/pic1.jpg')
INSERT [dbo].[PhotoAlbum] ([id], [name], [image]) VALUES (2, N'Pic 2', N'/Trekking_and_Hiking/View/Image/Photo/pic2.jpg')
INSERT [dbo].[PhotoAlbum] ([id], [name], [image]) VALUES (3, N'Pic 3', N'/Trekking_and_Hiking/View/Image/Photo/pic3.jpg')
INSERT [dbo].[PhotoAlbum] ([id], [name], [image]) VALUES (4, N'Pic 4', N'/Trekking_and_Hiking/View/Image/Photo/pic4.jpg')
INSERT [dbo].[PhotoAlbum] ([id], [name], [image]) VALUES (5, N'Pic 5', N'/Trekking_and_Hiking/View/Image/Photo/pic5.jpg')
INSERT [dbo].[PhotoAlbum] ([id], [name], [image]) VALUES (6, N'Pic 6', N'/Trekking_and_Hiking/View/Image/Photo/pic6.jpg')
INSERT [dbo].[PhotoAlbum] ([id], [name], [image]) VALUES (7, N'Pic 7', N'/Trekking_and_Hiking/View/Image/Photo/pic7.jpg')
INSERT [dbo].[PhotoAlbum] ([id], [name], [image]) VALUES (8, N'Pic 8', N'/Trekking_and_Hiking/View/Image/Photo/pic8.jpg')
SET IDENTITY_INSERT [dbo].[PhotoAlbum] OFF
GO
SET IDENTITY_INSERT [dbo].[SocialNetwork] ON 

INSERT [dbo].[SocialNetwork] ([id], [name], [link], [icon]) VALUES (1, N'Facebook', N'https://www.facebook.com/', NULL)
INSERT [dbo].[SocialNetwork] ([id], [name], [link], [icon]) VALUES (2, N'Twitter', N'https://twitter.com/', NULL)
INSERT [dbo].[SocialNetwork] ([id], [name], [link], [icon]) VALUES (3, N'Instagram', N'https://www.instagram.com/', NULL)
SET IDENTITY_INSERT [dbo].[SocialNetwork] OFF
GO
SET IDENTITY_INSERT [dbo].[TrekkingLink] ON 

INSERT [dbo].[TrekkingLink] ([id], [title], [short_desc], [link]) VALUES (1, N'Adventure travel', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad mini', N'http://www.lonelyplanet.com/travel-tips-and-articles/adventure-travel')
INSERT [dbo].[TrekkingLink] ([id], [title], [short_desc], [link]) VALUES (2, N'The Wildland Trekking Com', N'Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iust', N'http://www.tripadvisor.dk/Attraction_Review-g143028-d2018905-Reviews-The_Wildland_Trekking_Company_Hiking_Guides-Grand_Canyon_National_Park_Arizona.html')
INSERT [dbo].[TrekkingLink] ([id], [title], [short_desc], [link]) VALUES (3, N'World''s Best Hikes: Epic', N'Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est us', N'http://adventure.nationalgeographic.com/adventure/trips/best-trails/worlds-best-grail-trails/')
INSERT [dbo].[TrekkingLink] ([id], [title], [short_desc], [link]) VALUES (4, N'The 10 best treks in the', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad mini', N'http://www.lonelyplanet.com/travel-tips-and-articles/76228')
INSERT [dbo].[TrekkingLink] ([id], [title], [short_desc], [link]) VALUES (5, N'Tour trekking Tà Năng - Phan Dũng 3 ngày gi﻿á rẻ - Divui.com', N'Trải nghiệm Tour trekking Tà Năng - Phan Dũng 3 ngày cực hấp dẫn. Đặt vé online gi﻿á rẻ, tiết kiệm 10-30%. Nhận vé trong vòng 24h.', N'https://divui.com/tour-trekking-ta-nang-phan-dung')
INSERT [dbo].[TrekkingLink] ([id], [title], [short_desc], [link]) VALUES (6, N'Tour leo núi Lảo Thẩn - Nóc nhà Y Tý | Viettrekking', N'Hành trình leo Lảo Thẩn ngắm đại dương mây khi thì băng qua những khu rừng cháy rụi ... 07h30: Xe đón đoàn tới điểm trek tại Y Tý, cách Sa Pa khoảng 80km.', N'https://viettrekking.vn/tours/tour-leo-nui-lao-than-noc-nha-y-ty/')
SET IDENTITY_INSERT [dbo].[TrekkingLink] OFF
GO
INSERT [dbo].[View] ([viewed]) VALUES (27)
GO
USE [master]
GO
ALTER DATABASE [J3SP0014_Trekking_and_Hiking] SET  READ_WRITE 
GO
