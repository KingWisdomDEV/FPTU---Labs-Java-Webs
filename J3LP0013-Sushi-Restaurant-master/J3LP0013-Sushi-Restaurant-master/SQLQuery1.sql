use J3SP0013_Sushi_Restaurant

create table SocialNetwork(
	id int PRIMARY KEY IDENTITY(1,1),
	name nvarchar(255),
	icon varchar(255),
	link varchar(1000)
)

create table Contact (
	id int PRIMARY KEY IDENTITY(1, 1),
	name nvarchar(255),
	address nvarchar(1000),
	tel varchar(20),
	email varchar(100), 
	openHours ntext
)

create table Menu (
	id int PRIMARY KEY IDENTITY(1,1),
	name nvarchar(255),
	price float,
	shortDesc nvarchar(255),
	detailDesc ntext
)

create table Home(
	id int PRIMARY KEY IDENTITY(1,1),
	title nvarchar(255),
	image varchar(255),
	description ntext
)

create table [View](
	viewed int
)