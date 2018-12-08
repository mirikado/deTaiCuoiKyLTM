USE [master]
GO
/****** Object:  Database [TestPrograming]    Script Date: 12/8/2018 10:47:12 AM ******/
CREATE DATABASE [TestPrograming]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TestPrograming', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\TestPrograming.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'TestPrograming_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\TestPrograming_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [TestPrograming] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TestPrograming].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TestPrograming] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TestPrograming] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TestPrograming] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TestPrograming] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TestPrograming] SET ARITHABORT OFF 
GO
ALTER DATABASE [TestPrograming] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TestPrograming] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TestPrograming] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TestPrograming] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TestPrograming] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TestPrograming] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TestPrograming] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TestPrograming] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TestPrograming] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TestPrograming] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TestPrograming] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TestPrograming] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TestPrograming] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TestPrograming] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TestPrograming] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TestPrograming] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TestPrograming] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TestPrograming] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TestPrograming] SET  MULTI_USER 
GO
ALTER DATABASE [TestPrograming] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TestPrograming] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TestPrograming] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TestPrograming] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [TestPrograming] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [TestPrograming] SET QUERY_STORE = OFF
GO
USE [TestPrograming]
GO
/****** Object:  Table [dbo].[QUESTION]    Script Date: 12/8/2018 10:47:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QUESTION](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[QuestionContent] [nvarchar](50) NULL,
	[A] [nvarchar](50) NULL,
	[B] [nvarchar](50) NULL,
	[C] [nvarchar](50) NULL,
	[D] [nvarchar](50) NULL,
	[result] [nvarchar](50) NULL,
 CONSTRAINT [PK_QUESTION] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USER]    Script Date: 12/8/2018 10:47:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USER](
	[username] [varchar](50) NOT NULL,
	[email] [varchar](50) NULL,
	[password] [varchar](50) NULL,
 CONSTRAINT [PK_USER] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [TestPrograming] SET  READ_WRITE 
GO
