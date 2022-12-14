USE [master]
GO
/****** Object:  Database [J3SP0011_Blogging]    Script Date: 2/6/2021 11:16:09 AM ******/
CREATE DATABASE [J3SP0011_Blogging]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'J3SP0011_Blogging', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\J3SP0011_Blogging.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'J3SP0011_Blogging_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\J3SP0011_Blogging_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [J3SP0011_Blogging] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [J3SP0011_Blogging].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [J3SP0011_Blogging] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET ARITHABORT OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [J3SP0011_Blogging] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [J3SP0011_Blogging] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET  ENABLE_BROKER 
GO
ALTER DATABASE [J3SP0011_Blogging] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [J3SP0011_Blogging] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET RECOVERY FULL 
GO
ALTER DATABASE [J3SP0011_Blogging] SET  MULTI_USER 
GO
ALTER DATABASE [J3SP0011_Blogging] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [J3SP0011_Blogging] SET DB_CHAINING OFF 
GO
ALTER DATABASE [J3SP0011_Blogging] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [J3SP0011_Blogging] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [J3SP0011_Blogging] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [J3SP0011_Blogging] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'J3SP0011_Blogging', N'ON'
GO
ALTER DATABASE [J3SP0011_Blogging] SET QUERY_STORE = OFF
GO
USE [J3SP0011_Blogging]
GO
/****** Object:  Table [dbo].[Blog]    Script Date: 2/6/2021 11:16:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Blog](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NULL,
	[type] [varchar](50) NULL,
	[image] [varchar](1000) NULL,
	[description] [ntext] NULL,
	[author] [nvarchar](255) NULL,
	[created_at] [date] NULL,
 CONSTRAINT [PK__Blog__3213E83F5C0B7393] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 2/6/2021 11:16:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[description] [ntext] NULL,
	[author] [nvarchar](255) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[View]    Script Date: 2/6/2021 11:16:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[View](
	[viewed] [int] NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Blog] ON 

INSERT [dbo].[Blog] ([id], [title], [type], [image], [description], [author], [created_at]) VALUES (1, N'Essential skills for a happy life!', N'article', N'/myblog.com/view/image/pic1.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex
                                                                    ea commodo consequat.</p> <p>At eam doctus oportere, eam feugait delectus ne. Quo cu vulputate persecuti. Eum ut natum possim comprehensam, habeo dicta scaevola eu nec. Ea adhuc reformidans eam. Pri dolore epicuri eu, ne cum tantas fierent instructior. Pro
                                                                    ridens intellegam ut, sea at graecis scriptorem eloquentiam.</p> <p>Per an labitur lucilius ullamcorper, esse erat ponderum ad vim. Possim laoreet suscipit ex pri, vix numquam eruditi feugait in. Nec maluisset complectitur te, at sea decore semper. Falli numquam
                                                                    perpetua sea et, tibique repudiandae an pro. Ut his solum persius postulant. Soluta nemore debitis ne eos, cum an scripta pericula partiendo.', NULL, CAST(N'2015-11-16' AS Date))
INSERT [dbo].[Blog] ([id], [title], [type], [image], [description], [author], [created_at]) VALUES (2, N'You''ve gotta dance', N'quote', NULL, N'"“You''ve gotta dance like there''s nobody watching,<br>Love like you''ll never be hurt,<br>Sing like there''s nobody listening,<br>And live like it''s heaven on earth.” "', N'William W. Purkey', CAST(N'2015-11-16' AS Date))
INSERT [dbo].[Blog] ([id], [title], [type], [image], [description], [author], [created_at]) VALUES (3, N'Photo', N'photo', N'/myblog.com/view/image/pic2.jpg', NULL, NULL, CAST(N'2015-11-16' AS Date))
INSERT [dbo].[Blog] ([id], [title], [type], [image], [description], [author], [created_at]) VALUES (4, N'Essential skills for a happy life!', N'article', N'/myblog.com/view/image/pic1.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex
                                                                    ea commodo consequat.</p> <p>At eam doctus oportere, eam feugait delectus ne. Quo cu vulputate persecuti. Eum ut natum possim comprehensam, habeo dicta scaevola eu nec. Ea adhuc reformidans eam. Pri dolore epicuri eu, ne cum tantas fierent instructior. Pro
                                                                    ridens intellegam ut, sea at graecis scriptorem eloquentiam.</p> <p>Per an labitur lucilius ullamcorper, esse erat ponderum ad vim. Possim laoreet suscipit ex pri, vix numquam eruditi feugait in. Nec maluisset complectitur te, at sea decore semper. Falli numquam
                                                                    perpetua sea et, tibique repudiandae an pro. Ut his solum persius postulant. Soluta nemore debitis ne eos, cum an scripta pericula partiendo.', NULL, CAST(N'2015-11-16' AS Date))
SET IDENTITY_INSERT [dbo].[Blog] OFF
GO
INSERT [dbo].[Contact] ([description], [author]) VALUES (N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.

Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.', N'Vivianne Russell')
GO
INSERT [dbo].[View] ([viewed]) VALUES (9)
GO
USE [master]
GO
ALTER DATABASE [J3SP0011_Blogging] SET  READ_WRITE 
GO
