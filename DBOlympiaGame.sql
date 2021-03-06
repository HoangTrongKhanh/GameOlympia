USE [DBGameOlympia]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblVeDick](
	[STT] [int] NOT NULL,
	[Question] [nvarchar](500) NOT NULL,
	[AnswerA] [nvarchar](50) NULL,
	[AnswerB] [nvarchar](50) NULL,
	[AnswerC] [nvarchar](50) NULL,
	[AnswerD] [nvarchar](50) NULL,
	[Answer] [nchar](10) NOT NULL,
	[Point] [int] NOT NULL,
 CONSTRAINT [PK_tblVeDick] PRIMARY KEY CLUSTERED 
(
	[STT] ASC,
	[Point] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (1, N'Thuật ngữ WAN dùng để diễn tả', N'Mạng diện rộng', N'Mạng toàn cầu', N'Mạng Cục bộ', N'Một ý nghĩa khác', N'A         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (2, N'Asean là hiệp hội của các nước thuộc khu vực nào?', N'Đông á', N'Trung á', N'Nam Á', N'Đông Nam Á', N'D         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (2, N'Câu "Tình yêu giống chiến tranh ở chỗ dễ bắt đầu mà khó chấm dứt" thuộc thể loại văn học nào?', N'Ca dao', N'Danh ngôn', N'Tục ngữ', N'Châm ngôn', N'B         ', 20)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (2, N'Câu "Tiền bạc vật chất, mất đi kiếm lại được. Nhưng niềm tin tưởng đã mất đi rồi thì không làm sao kiếm lại được" thuộc thể loại nào?', N'Ca dao', N'Danh ngôn', N'Châm ngôn', N'Tục ngữ', N'C         ', 30)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (3, N'Câu "Sống trong tinh thần đạo đức tức là sống bất diệt vượt khỏi mọi tai biến bất cứ trong thời cuộc nào" thuộc thể loại văn học nào?', N'Danh ngôn', N'Châm ngôn', N'Ca dao', N'Tục ngữ', N'B         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (3, N'Hút thuốc lá có hại cho cơ quan nào?', N'Tim', N'Gan', N'Toàn bộ cơ thể', N'Phổi', N'C         ', 20)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (3, N'"Người biết đức tất không thích tiếng tăm lừng lẫy" thuộc thể loại văn học nào?', N'Danh ngôn', N'Ca dao', N'Châm ngôn', N'Tục ngữ', N'C         ', 30)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (4, N'Câu nào sau đây chỉ người ở trạng thái mê man không biết gì?', N'Bất tỉnh nhân sự', N'Bất khả xâm phạm', N'Bất đắc kỳ tử', N'Bất di bất dịch', N'A         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (5, N'Trong các thứ tự sau đây, thứ tự nào đúng với một câu thành ngữ?', N'Rau nấy sâu nào', N'Nấy sâu nào rau', N'Sâu nào rau nấy', N'Rau nào sâu nấy', N'D         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (6, N'Loài hoa nào là biểu tượng của tình yêu?', N'Hoa hướng dương', N'Hoa tulip', N'Hoa Phăng', N'Hoa hồng', N'D         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (7, N'Con cáo và tổ ong là tác phẩm của nhà thơ nào?', N'Nguyễn KHuyến', N'Ho Chi Minh', N'Tố Hữu', N'Nguyễn Thanh Hải', N'B         ', 20)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (8, N'Điều khiển từ xa được phát minh vào năm nào?', N'1918', N'1898', N'1788', N'1828', N'C         ', 30)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (9, N'Người ta thường nói nói ngang như?', N'Ghẹ', N'Cua', N'Ngỗng', N'Heo', N'B         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (10, N'Tóc người Việt Nam đa số có màu gì?', N'Màu vàng', N'Màu nâu', N'Màu đen', N'Màu đỏ', N'C         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (11, N'Trong bàn cờ Tướng, mỗi bên có bao nhiêu quân Pháo?', N'4', N'3', N'2', N'1', N'A         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (12, N'Dụng cụ để đo hiệu điện thế?', N'Vôn kế', N'Lực kế', N'Ampe kế', N'Nhiệt kế', N'A         ', 10)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (13, N'Thành phố nào được cho là thơ mộng nhất Việt Nam?', N'Tp. Hồ Chí Minh', N'Tp. Hải Phòng', N'Tp. Đà Lạt', N'Tp. Huế', N'C         ', 20)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (14, N'Thung lũng tình yêu thuộc tỉnh nào của Việt Nam?', N'Bình Thuận', N'Lâm Đồng', N'Ninh Thuận', N'Khánh Hoà', N'B         ', 20)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (15, N'Đảo Phú Quốc trực thuộc tỉnh nào?', N'Cà Mau', N'Trà Vinh', N'An Giang', N'Kiên Giang', N'D         ', 20)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (16, N'Từ nào sau đây đồng nghĩa với từ thi nhân?', N'Nhà văn', N'Nhà thơ', N'Nhà báo', N'Nghệ sĩ', N'B         ', 20)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (17, N'Ngày 30/07 là quốc khánh của quốc gia nào sau đây?', N'Vatican', N'Vanuata', N'Venezuela', N'Việt Nam', N'B         ', 30)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (18, N'Đóng gói, chế biến và phân phối sản phẩm là chức năng của?', N'Lục lạp', N'Ty thể', N'Bộ máy golgy', N'Lưới nội chất', N'C         ', 30)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (19, N'Rêu là thực vật như thế nào?', N'Chưa có hệ mạch', N'Thụ tinh nhờ gió', N'Thụ tinh nhờ côn trùng', N'Tinh trùng không có roi', N'A         ', 30)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (20, N'Dấu hiệu nào là cơ sở cho sự tiến hoá của sinh vật?', N'Tích luỹ thông tin di truyền', N'Tự đổi mới', N'Tự sao chép', N'Tự điều chỉnh', N'A         ', 30)
INSERT [dbo].[tblVeDick] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer], [Point]) VALUES (21, N'Máy bay trực thăng được phát minh vào năm nào?', N'1880', N'1914', N'1936', N'1945', N'C         ', 30)

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KeyVCNV](
	[STT] [int] NOT NULL,
	[Question] [nvarchar](500) NOT NULL,
	[Answer] [nvarchar](100) NOT NULL,
	[SoOHN] [int] NULL,
	[Path] [nvarchar](500) NULL,
 CONSTRAINT [PK_KeyVCNV] PRIMARY KEY CLUSTERED 
(
	[STT] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[KeyVCNV] ([STT], [Question], [Answer], [SoOHN], [Path]) VALUES (1, N'Đây là một loại hình nghệ thuật ca hát cổ truyền của Việt Nam. Đây là hình thức lễ nhạc trong nghi thức hầu đồng của tín ngưỡng Tứ phủ và tín ngưỡng thờ Đức Thánh Trần?', N'chauvan', 7, N'https://i.imgur.com/QbklTW5.jpg')
INSERT [dbo].[KeyVCNV] ([STT], [Question], [Answer], [SoOHN], [Path]) VALUES (2, N'cai ban dang dung de choi tro choi nay', N'maytinh', 7, N'https://i.imgur.com/c3oWEbt.jpg')
INSERT [dbo].[KeyVCNV] ([STT], [Question], [Answer], [SoOHN], [Path]) VALUES (3, N'vat dung dung de nghe goi', N'dienthoai', 9, N'https://i.imgur.com/N8Kt1hY.jpg')
INSERT [dbo].[KeyVCNV] ([STT], [Question], [Answer], [SoOHN], [Path]) VALUES (4, N'Đây là một thể loại thơ?', N'thomoi', 6, N'https://i.imgur.com/rV41RWG.jpg')
INSERT [dbo].[KeyVCNV] ([STT], [Question], [Answer], [SoOHN], [Path]) VALUES (5, N'Mặt trời là ........ của nhân loại?', N'anhsang', 7, N'https://i.imgur.com/f7HJ5qo.jpg')
INSERT [dbo].[KeyVCNV] ([STT], [Question], [Answer], [SoOHN], [Path]) VALUES (6, N'Bà là người con gái sinh ra ở quận Cửu Chân,là bậc hùng tài trong nữ giới sinh năm Bính Ngọ (226)?', N'batrieu', 7, N'https://i.imgur.com/EuhguQB.jpg')

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblVeDich_SelectByID]
@STT int
as
SELECT  STT 
      , STTQuestion 
      , Question 
      , AnswerA 
      , AnswerB 
      , AnswerC 
      , AnswerD 
      , Answer 
      , Point 
  FROM   tblVeDich where STT= @STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblVeDich_SelectBy2ID]
@STT int,
@STTQuestion int
as
SELECT  STT 
      , STTQuestion 
      , Question 
      , AnswerA 
      , AnswerB 
      , AnswerC 
      , AnswerD 
      , Answer 
      , Point 
  FROM   tblVeDich where STT= @STT and STTQuestion=@STTQuestion
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblKeyVeDich](
	[STT] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblKeyVeDich] PRIMARY KEY CLUSTERED 
(
	[STT] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblKeyVeDich] ([STT], [Name]) VALUES (1, N'Gói 40 điểm')
INSERT [dbo].[tblKeyVeDich] ([STT], [Name]) VALUES (2, N'Gói 60 điểm')
INSERT [dbo].[tblKeyVeDich] ([STT], [Name]) VALUES (3, N'Gói 80 điểm')

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblKhoiDong](
	[STT] [int] NOT NULL,
	[Question] [nvarchar](500) NULL,
	[Answer] [bit] NULL,
 CONSTRAINT [PK_tblKhoiDong] PRIMARY KEY CLUSTERED 
(
	[STT] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
UPDATE STATISTICS [dbo].[tblKhoiDong]([PK_tblKhoiDong]) WITH STATS_STREAM = 0x01000000010000000000000000000000876080D2000000001B03000000000000DB02000000000000380300003800000004000A00000000000000000000000000070000007C3122013CA20000110000000000000011000000000000000000803FF1F0703D00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000900000009000000010000001400000000008040000088410000000000008040000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000019000000000000000000000000000000170100000000000067010000000000006F0100000000000048000000000000005F0000000000000076000000000000008D00000000000000A400000000000000BB00000000000000D200000000000000E9000000000000000001000000000000100014000000803F000000000000803F01000000040000100014000000803F0000803F0000803F03000000040000100014000000803F0000803F0000803F05000000040000100014000000803F0000803F0000803F07000000040000100014000000803F0000803F0000803F09000000040000100014000000803F0000803F0000803F0B000000040000100014000000803F0000803F0000803F0D000000040000100014000000803F0000803F0000803F0F000000040000100014000000803F0000803F0000803F1100000004000001000000F624280037A200000000000000002A400D0000000000000007000000000000203BB1B33F0000000000001040000000000000000000000000000004C00000000000001AC0B79FB390D0F1DF3F1100000000000000, ROWCOUNT = 14, PAGECOUNT = 1
GO
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (1, N'Mặt trăng là màu xanh lá cây.', 0)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (2, N'TNeil Armstrong, phi hành gia của phi thuyền Apollo 12 là người đầu tiên đi bộ trên mặt trăng, nói rằng sự kiện này là một “bước tiến khổng lồ cho nhân loại', 0)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (3, N'Con bò có 4 chân đúng hay sai', 0)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (4, N'Hoa Mai là quốc hoa của Việt Nam đúng hay sai ?', 0)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (5, N'Ure Là Phân Đạm đúng hay sai ?', 1)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (6, N'Châu Mĩ Tiếp Giáp với Ấn Đô Dương và Đại Tây Dương đúng hay sai? ', 0)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (7, N'Môi Trường Chân Không không truyền được âm thanh đúng hay sai ?', 0)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (8, N'Bùi Công Duy là nhạc sĩ violong nổi tiếng đúng hay sai', 1)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (9, N'Theo Ngũ Hành Kim khắc với Thổ đúng hay sai ?', 0)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (10, N'Đen là đai cao nhất trong Taewondo đúng hay sai ?', 0)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (11, N'Chương trình Đô rê mí bắt đầu phát sóng từ năm 2006 đúng hay sai ?', 1)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (12, N'February trong tiếng Anh là tháng 3 trong năm?', 0)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (13, N'Sep trong tiếng Anh là tháng 9 trong năm?', 1)
INSERT [dbo].[tblKhoiDong] ([STT], [Question], [Answer]) VALUES (14, N'Ngựa có trong tứ linh đúng hay sai?', 0)

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPoint](
	[STT] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Diem] [int] NULL,
 CONSTRAINT [PK_tblPoint] PRIMARY KEY CLUSTERED 
(
	[STT] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tblPoint] ON
INSERT [dbo].[tblPoint] ([STT], [Name], [Diem]) VALUES (1, N'Luan', 380)
INSERT [dbo].[tblPoint] ([STT], [Name], [Diem]) VALUES (18, N'vdluan.it', 320)
INSERT [dbo].[tblPoint] ([STT], [Name], [Diem]) VALUES (27, N'luan', 210)
INSERT [dbo].[tblPoint] ([STT], [Name], [Diem]) VALUES (28, N'luanvd', 430)
INSERT [dbo].[tblPoint] ([STT], [Name], [Diem]) VALUES (29, N'vdluan.ictu', 180)
SET IDENTITY_INSERT [dbo].[tblPoint] OFF

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTangToc](
	[STT] [int] NOT NULL,
	[Question] [nvarchar](500) NOT NULL,
	[AnswerA] [nvarchar](50) NULL,
	[AnswerB] [nvarchar](50) NULL,
	[AnswerC] [nvarchar](50) NULL,
	[AnswerD] [nvarchar](50) NULL,
	[Answer] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblTangToc] PRIMARY KEY CLUSTERED 
(
	[STT] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (1, N'Thủ đô của Việt Nam là gì', N'Hà Nội', N'Đà Nẵng', N'Sài Gòn', N'Nha Trang', N'A')
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (2, N'Việt Nam thuộc châu lục nào', N'Châu Âu', N'Châu Á', N'Châu Mỹ', N'Châu Phi', N'B')
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (3, N'Con người có mấy chi?', N'5', N'2', N'3', N'4', N'D')
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (4, N'Để kết thúc việc trình diễn trong PowerPoint, ta bấm?', N'Phím Enter', N'Phím Backspace', N'Phím ESC', N'Phím F1', N'C')
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (5, N'"Người biết đức tất không thích tiếng tăm lừng lẫy" thuộc thể loại văn học nào?', N'Danh ngôn', N'Châm ngôn', N'Ca dao', N'Tục ngữ', N'B')
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (6, N'Thuyền về có nhớ bến chăng. Bến thì một dạ khăng khăng......thuyền?', N'Chờ', N'Đợi', N'Mong', N'Trông', N'B')
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (7, N'"Những khi đã biết lầm lỗi thì biết ăn năn cải hối" thuộc thể loại văn học nào?', N'Danh ngôn', N'Châm ngôn', N'Ca dao', N'Tục ngữ', N'B')
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (9 ,N'Giải Grand Slam đầu tiên trong năm là giải nào? ', N'Austrlia mở rộng', N'Wimbledon', N'Roland Garos', N'Mỹ mở rộng', N'A' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (10 ,N'Trong môn quần vợt, giành được Grand Slam nghĩa là trong 1 năm đoạt chức vô địch cả 4 giải sau:', N'Úc mở rộng', N' Wimbledon', N'Pháp mở rộng', N'Mỹ mở rộng', N'B' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (11 ,N'An Dương Vương đặt quốc hiệu nước ta là gì ?', N'Âu Lạc', N'Vạn Xuân', N'Đại Cồ Việt', N'Đại Việt', N'A' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (12 ,N'Tỉnh nào đăng cai tổ chức Năm du lịch Quốc gia 2012? ', N'Thừa Thiên Huế', N'Thanh Hoá', N'Hải Phòng', N'Lâm Đồng', N'A' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (13 ,N'Sự kiện giờ Trái Đất, sáng kiến của WWF được tổ chức lần đầu tiên vào năm 2007 tại thành phố', N'Sydney', N'Tokyo', N'Bắc Kinh', N'Singapore', N'A' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (14 ,N' Các vua Hùng đặt quốc hiệu nước ta là gì?', N'Âu Lạc', N'Âu Lạc', N'.Vạn Xuân', N'Đại Việt', N'A' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (15 ,N' Sông Bến Hải và sông Thạch Hãn nằm ở tỉnh nào?', N'Quảng Bình', N'Quảng Bình', N'Quảng Trị', N'Quảng Ngãi', N'C' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (16 ,N'Trong các cây cầu sau, cầu nào là cầu xoay? ', N'Cầu Thanh Trì ', N'Cầu Thị Nại', N'Cầu Sông Hàn', N'Cầu Cần Thơ', N'C' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (17 ,N'Đại Ngu là quốc hiệu của triều đại nào?', N'Triều Ngô', N'Nhà Tây Sơn', N'Triều Hồ ', N'Các chúa Nguyễn', N'C' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (18 ,N'Ai là nhạc sĩ Việt Nam đầu tiên viết opera với tác phẩm “Cô sao” và sau đó là “Người tạc tượng”?', N'Đỗ Nhuận', N'Hoàng Vân', N'Trần Hoàn', N'Trọng Đài', N'A' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (19 ,N'Đội nào lên ngôi vô địch AFC Asian Cup 2011 tổ chức tại Qatar?', N'Nhật Bản', N'Australia', N'Hàn Quốc', N'Uzbekistan', N'A' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (20 ,N'AFC Asian Cup 2011 được tổ chức tại quốc gia nào?', N'Nhật Bản', N'Quatar', N'Hàn Quốc', N'Iraq', N'A' )
INSERT [dbo].[tblTangToc] ([STT], [Question], [AnswerA], [AnswerB], [AnswerC], [AnswerD], [Answer]) VALUES (8 ,N'Cùng với Hà Nội T&T (vô địch V-League 2010), CLB nào của Việt Nam tham dự AFC Cup 2011? ', N'Sông Lam Nghệ An', N'SHB Đà Nẵng', N'Becamex Bình Dương', N'Hoàng Anh Gia Lai', N'A' )



SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblPoint_Update]
@Name nvarchar(50)  
      ,@Diem int  
      ,@STT int 
      as
UPDATE tblPoint
   SET Name = @Name  
      ,Diem = @Diem   
      
 WHERE STT = @STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblPoint_SelectAll]
as
SELECT [STT]
      ,[Name]
      ,[Diem]
  FROM [DBGameOlympia].[dbo].[tblPoint]
  order by Diem DESC
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblPoint_Insert]
@Name  nvarchar(50)
           ,@Diem  int
           as
INSERT INTO tblPoint
           (Name
           ,Diem
           )
     VALUES
           (@Name  
           ,@Diem    )
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblPoint_Delete]
@STT int
as
DELETE FROM tblPoint
      WHERE STT = @STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblKhoiDong_Update]
		@STT  int
      ,@Question nvarchar(500)
      ,@Answer bit
      as
UPDATE  tblKhoiDong 
   SET  
      Question  = @Question
      ,Answer  = @Answer
       WHERE STT  = @STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblKhoiDong_Insert]
(@STT int
           ,@Question nvarchar(500)
           ,@Answer bit)
           as
INSERT INTO tblKhoiDong
           (STT
           ,Question
           ,Answer)
     VALUES
           (@STT
           ,@Question 
           ,@Answer )
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblKhoiDong_Delete]
@STT int
as

DELETE FROM tblKhoiDong
      WHERE STT=@STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblKeyVeDich_Update]
@STT int
      , @Name nvarchar(50)
as
UPDATE tblKeyVeDich
   SET 
      Name = @Name
 WHERE STT = @STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblKeyVeDich_SelectByID]
@STT int
as

SELECT  STT 
      , Name 
  FROM   tblKeyVeDich where STT=@STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblKeyVeDich_SelectAll]
as

SELECT  STT 
      , Name 
  FROM   tblKeyVeDich
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblKeyVeDich_Insert]
(@STT int
           ,@Name nvarchar(50))
           as
INSERT INTO  tblKeyVeDich 
           ( STT 
           ,Name )
     VALUES
           (@STT 
           ,@Name )
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblKeyVeDich_Delete]
@STT int
as
DELETE FROM tblKeyVeDich
      WHERE STT=@STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[KhoiDong_SelectBySTT]
@STT int
as
SELECT 
STT,Question
      ,Answer
  FROM tblKhoiDong
  where STT=@STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[KhoiDong_SelectAll]
as
SELECT STT
      ,Question
      ,Answer
  FROM tblKhoiDong
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[KeyVCNV_Update]
		@STT int
      , @Question nvarchar(500)
      , @Answer nvarchar(100)
      , @SoOHN int
      ,@Path nvarchar(500)
as
UPDATE KeyVCNV
   SET
      Question = @Question
      ,Answer = @Answer
      ,SoOHN = @SoOHN
      ,[Path]=@Path
 WHERE  STT = @STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[KeyVCNV_SelectByID]
@STT int 
as

SELECT  STT 
      , Question 
      , Answer 
      , SoOHN
      ,[Path]
      
  FROM  KeyVCNV where STT=@STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[KeyVCNV_SelectAll]
as
SELECT [STT]
      ,[Question]
      ,[Answer]
      ,[SoOHN]
      ,[Path]
  FROM [DBGameOlympia].[dbo].[KeyVCNV]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[KeyVCNV_Insert]
(@STT int 
           ,@Question nvarchar(500) 
           ,@Answer nvarchar(100) 
           ,@SoOHN int 
           ,@Path nvarchar(500))
as
INSERT INTO KeyVCNV
           (STT
           ,Question
           ,Answer
           ,SoOHN
           ,[Path])
     VALUES
           (@STT 
           ,@Question 
           ,@Answer 
           ,@SoOHN 
           ,@Path )
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[KeyVCNV_Delete]
		@STT int
		as
DELETE FROM KeyVCNV
      WHERE STT=@STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVeDich_SelectAll]
as
SELECT [STT]
      ,[Question]
      ,[AnswerA]
      ,[AnswerB]
      ,[AnswerC]
      ,[AnswerD]
      ,[Answer]
      ,[Point]
  FROM [dbo].[tblVeDick]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVeDich_Insert]
(@STT int 
           ,@Question nvarchar(500) 
           ,@AnswerA nvarchar(50) 
           ,@AnswerB nvarchar(50) 
           ,@AnswerC nvarchar(50) 
           ,@AnswerD nvarchar(50) 
           ,@Answer nchar(10) 
           ,@Point int )
		   as
INSERT INTO   tblVeDick 
           ( STT ,
            Question, 
            AnswerA ,
            AnswerB ,
            AnswerC ,
            AnswerD ,
            Answer ,
            Point )
     VALUES
           (@STT
           ,@Question 
           ,@AnswerA  
           ,@AnswerB  
           ,@AnswerC 
           ,@AnswerD 
           ,@Answer  
           ,@Point )
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVeDich_Delete]
@STT int ,
@Point int
as			
DELETE FROM tblVeDick
      WHERE STT=@STT and Point=@Point
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblTangToc_Update]
		@STT int
	   , @Question nvarchar(500)
	  , @AnswerA nvarchar(50)
	   , @AnswerB nvarchar(50)
	   , @AnswerC nvarchar(50)
		, @AnswerD nvarchar(50)
	   , @Answer nvarchar(50)
	   as
UPDATE  tblTangToc 
   SET  
       AnswerA  = @AnswerA 
       ,AnswerB  = @AnswerB 
       ,AnswerC  = @AnswerC
       ,AnswerD  = @AnswerD 
       ,Answer  = @Answer 
 WHERE STT  = @STT
    and Question  = @Question
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblTangToc_SelectByID]
@STT int
as
SELECT  STT 
      , Question 
      , AnswerA 
      , AnswerB 
      , AnswerC 
      , AnswerD 
      , Answer 
  FROM   tblTangToc where STT=@STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblTangToc_SelectAll]
as
SELECT  STT 
      , Question 
      , AnswerA 
      , AnswerB 
      , AnswerC 
      , AnswerD 
      , Answer 
  FROM  tblTangToc
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblTangToc_Insert]
			(@STT int 
           ,@Question nvarchar(500) 
           ,@AnswerA nvarchar(50) 
           ,@AnswerB nvarchar(50) 
           ,@AnswerC nvarchar(50) 
           ,@AnswerD nvarchar(50) 
           ,@Answer nvarchar(50) )
as
INSERT INTO tblTangToc
           (STT
           ,Question
           ,AnswerA
           ,AnswerB
           ,AnswerC
           ,AnswerD
           ,Answer)
     VALUES
           (@STT 
           ,@Question 
           ,@AnswerA 
           ,@AnswerB
           ,@AnswerC 
           ,@AnswerD 
           ,@Answer )
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblTangToc_Delete]
 @STT int
   
    as
DELETE FROM tblTangToc
      WHERE STT  = @STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblVuotChuongNgaiVat](
	[STT] [int] NOT NULL,
	[STTHN] [int] NOT NULL,
	[SoOHN] [int] NOT NULL,
	[Question] [nvarchar](500) NOT NULL,
	[Answer] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblVuotChuongNgaiVat] PRIMARY KEY CLUSTERED 
(
	[STT] ASC,
	[STTHN] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (1, 1, 12, N'Trần Hưng Đạo được suy tôn danh vị nào?', N'ducthanhtran')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (1, 2, 7, N'Hội chợ Viềng họp mùng 8 tháng Giêng hằng năm của tỉnh nào?', N'namdinh')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (1, 3, 5, N'Là một tín ngưỡng nằm trong tín ngưỡng thờ mẫu Việt Nam?', N'tuphu')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (1, 4, 6, N'Trong ban nhạc "Ngũ tuyệt" của nhạc thính phòng cổ truyền thì đàn ..... đóng vai trò điều khiển?', N'nguyet')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (2, 1, 7, N'keyboad nghĩa là gì', N'banphim')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (2, 2, 5, N'Mouse nghĩa là gì', N'chuot')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (2, 3, 4, N'Switch .......', N'case')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (2, 4, 7, N'........LCD?', N'manhinh')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (3, 1, 3, N'Nạp tiền vào ....... để gọi?', N'sim')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (3, 2, 7, N'Hệ điều hành phổ biến trên smartphone do Google phát triển', N'android')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (3, 3, 13, N'Hệ điều hành mới nhất từ nokia', N'windowsphone8')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (3, 4, 6, N'.......... dùng để lưu trữ với kích thước nhỏ gọn', N'thenho')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (4, 1, 4, N'Giải bóng đá vô địch quốc gia pháp là hạng thi đấu cao nhất của nước pháp bắt đầu từ năm nào?', N'1932')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (4, 2, 6, N'Bản ngã là cách gọi khác của khái niệm nào?', N'caitoi')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (4, 3, 7, N'Đây là tên của trào lưu văn học mà nhà văn, nhà thơ, nhà viết kịch vĩ đại của nước pháp Victo Hugo được coi là “cánh chim đầu đàn”', N'langman')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (4, 4, 4, N'Tượng nữ thần nào có hình dáng mặc áo choàng có dáng tay phải cầm ngọn đuốc tay trái cầm đá phiến khắc ngày tháng độc lập của Hoa Kỳ?', N'tudo')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (5, 1, 2, N'Theo truyền thuyết, sơn tinh và chử đồng tử là con trai của vua thứ bao nhiêu?', N'18')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (5, 2, 6, N'Nguyên lý bảo toàn động lượng là công trình của nhà vật lý học nào?', N'newton')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (5, 3, 6, N'Đàn lia và cây cũng là những vật dụng tượng trưng của vị thần nào?', N'apollo')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (5, 4, 8, N'Pha sáng và pha tối là giai đoạn nào của quá trình ở cây?', N'quanghop')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (6, 1, 8, N'Miền Trung việt nam bắt đầu từ tỉnh nào ?', N'thanhhoa')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (6, 2, 2, N'Người sinh ra bố/mẹ ta được gọi là gì?', N'ba')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (6, 3, 3, N'Loài vật đặc trưng ở bản đôn?', N'voi')
INSERT [dbo].[tblVuotChuongNgaiVat] ([STT], [STTHN], [SoOHN], [Question], [Answer]) VALUES (6, 4, 8, N'........ là một triều đại trong lịch sử Việt Nam, truyền được hai đời nhưng có tới ba vị vua, kéo dài từ năm 939 đến năm 965?', N'trieungo')

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVeDich_Update]
@STT int 
      ,@Question nvarchar(500) 
      , @AnswerA nvarchar(50) 
      ,@AnswerB nvarchar(50) 
      , @AnswerC nvarchar(50) 
      , @AnswerD nvarchar(50) 
      ,@Answer nchar(10) 
      ,@Point int 
as
UPDATE tblVeDick
   SET
      Question = @Question
      ,AnswerA = @AnswerA 
      ,AnswerB = @AnswerB 
      ,AnswerC = @AnswerC 
      ,AnswerD = @AnswerD
      ,Answer = @Answer 
      ,Point = @Point
 WHERE  STT = @STT and Point=@Point
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblVeDich_SelectbyPoint]
@Point int
as
SELECT [STT]
      ,[Question]
      ,[AnswerA]
      ,[AnswerB]
      ,[AnswerC]
      ,[AnswerD]
      ,[Answer]
      ,[Point]
  FROM [dbo].[tblVeDick] where Point=@Point
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVuotChuongNgaiVatSelectByID]
@STT int 
as
SELECT  
      STTHN 
      , SoOHN 
      , Question 
      , Answer 
  FROM  tblVuotChuongNgaiVat where STT=@STT
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVuotChuongNgaiVat_Update]
		@STT int
        ,@STTHN int
        ,@SoOHN int
        , @Question nvarchar(500)
        ,@Answer nvarchar(50)
as
UPDATE     tblVuotChuongNgaiVat  
   SET   
       
        SoOHN   = @SoOHN 
        ,Question   = @Question 
        ,Answer   = @Answer
 WHERE STT   = @STT and  STTHN   = @STTHN
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tblVuotChuongNgaiVat_SelectBy2ID]
@STT int,
@STTHN int
as

SELECT  STT 
      , STTHN 
      , SoOHN 
      , Question 
      , Answer 
  FROM   tblVuotChuongNgaiVat 
  where STT=@STT and STTHN=@STTHN
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVuotChuongNgaiVat_SelectAll]
as
SELECT STT
      ,STTHN
      ,SoOHN
      ,Question
      ,Answer
  FROM tblVuotChuongNgaiVat
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVuotChuongNgaiVat_Insert]
 (@STT  int 
           ,@STTHN  int 
           ,@SoOHN  int 
           ,@Question  nvarchar(500) 
           ,@Answer  nvarchar(50) )
		   as
INSERT INTO    tblVuotChuongNgaiVat 
           ( STT ,
             STTHN, 
             SoOHN ,
             Question, 
             Answer )
     VALUES
           (@STT   
           ,@STTHN   
           ,@SoOHN   
           ,@Question  
		   ,@Answer  )
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVuotChuongNgaiVat_Delete]
@STT int
,@STTHN int
as

DELETE FROM tblVuotChuongNgaiVat
      WHERE STT=@STT
		and  STTHN=@STTHN
GO

ALTER TABLE [dbo].[tblVuotChuongNgaiVat]  WITH CHECK ADD  CONSTRAINT [FK_tblVuotChuongNgaiVat_KeyVCNV] FOREIGN KEY([STT])
REFERENCES [dbo].[KeyVCNV] ([STT])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblVuotChuongNgaiVat] CHECK CONSTRAINT [FK_tblVuotChuongNgaiVat_KeyVCNV]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblKhoiDong_LastSTT]
AS
SELECT TOP 1 STT
FROM tblKhoiDong
ORDER BY STT DESC
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblTangToc_LastSTT]
AS
SELECT TOP 1 STT
FROM tblTangToc
ORDER BY STT DESC
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblVeDich_LastSTT]
AS
SELECT TOP 1 STT
FROM tblVeDick
ORDER BY STT DESC
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tblPoint_LastSTT]
AS
SELECT TOP 1 STT
FROM tblPoint
ORDER BY STT DESC
GO