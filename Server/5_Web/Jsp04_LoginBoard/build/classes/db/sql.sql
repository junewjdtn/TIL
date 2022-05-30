-- Jsp04_LoginBoard --------------------------------------------------------------------

create table MYMEMBER(
	MYNO INT auto_increment not null primary key,
	MYID VARCHAR(500) not null unique,
	MYPW VARCHAR(500) not null,
	MYNAME VARCHAR(1000) not null,
	MYADDR VARCHAR(4000) not null,
	MYPHONE VARCHAR(100) not null unique,
	MYEMAIL VARCHAR(100) not null unique,
	MYENABLED VARCHAR(2) not null CHECK(MYENABLED in ('Y','N')),
	MYROLE VARCHAR(50) not null
);

select * from MYMEMBER;

insert into MYMEMBER VALUES(null, 'ADMIN', 'ADMIN1234', '관리자', '관리시 관리구 관리동', '010-1234-5678', 'ADMIN@MYMEMBER.COM', 'Y', 'ADMIN');