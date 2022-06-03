-- Jsp08_MVC --------------------------------------------------------------------

create table MYMVCBOARD(
	SEQ INT auto_increment primary key,
	WRITER VARCHAR(200) not null,
	TITLE VARCHAR(2000) not null,
	CONTENT VARCHAR(4000) not null,
	REGDATE DATE not NULL
);

insert into MYMVCBOARD VALUES(null, '관리자', '테스트', '테스트 중입니다.123123', NOW());

select * from MYMVCBOARD;