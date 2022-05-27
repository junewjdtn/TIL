-- Jsp03_MVC ---------------------------------------------------------------------------

create table MVCBOARD(
	SEQ INT auto_increment primary key,
	WRITER VARCHAR(100) not null,
	TITLE VARCHAR(1000) not null,
	CONTENT VARCHAR(2000) not null,
	REGDATE DATE not NULL
);

select * from MVCBOARD;

insert into MVCBOARD VALUES(null, '관리자', '테스트', '테스트중입니다. 1234 ABCD', NOW());