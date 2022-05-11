-- RANK() / DENSE_RANK() / ROW_NUMBER()
-- 순위를 매겨주는 함수

-- 동일한 값이 있을 경우 같은 번호를 매겨주고 다음 번호는 그만큼 추가된 번호가 온다
-- EX) 19 - 19 - 21 - 22 ...
select EMP_NAME, SALARY,
	RANK() OVER(order by SALARY DESC) 순위
from EMPLOYEE;

-- 동일한 값이 있을 경우 같은 번호를 매겨주고 번호를 건너 뛰지 않고 다음 번호를 사용
-- EX) 19 - 19 - 20 - 21 ...
select EMP_NAME, SALARY,
	DENSE_RANK() over (order by SALARY DESC) 순위
from EMPLOYEE;

-- 동일한 값이 있을 경우 무시하고 그냥 순번을 매겨줌
select EMP_NAME, SALARY,
	row_number() OVER(order by SALARY DESC) 순위
from EMPLOYEE;

-- 오류
select EMP_NAME, SALARY,
	RANK() OVER(order by SALARY DESC) 순위
from EMPLOYEE
where 순위 < 4;

-- 인라인뷰를 사용하여 원하는 순위까지만 사용 가능
select *
from (select EMP_NAME, SALARY,
	RANK() OVER(order by SALARY DESC) 순위
	from EMPLOYEE) T
where 순위 < 4;

-- ------------------------------------------
-- DDL 
-- CREATE TABLE
-- 제약조건
-- 컬럼에 조건을 걸어주는 것임.

-- 테이블 생성
drop table MEMBER;

create table MEMBER(
	MEMBER_NO INT, 			-- 회원 번호
	MEMBER_ID VARCHAR(20), 	-- 회원 아이디
	MEMBER_PW VARCHAR(20), 	-- 회원 비밀번호
	MEMBER_NAME VARCHAR(15) COMMENT '회원이름'
);

-- 테이블 확인 방법
desc member;

select * from member;

-- 제약조건(CONSTRAINTS)
-- 테이블 생성 할 때 컬럼에 값을 기록하는 것에 대한 제약사항을 설정 조건.

-- NOT NULL		: 컬럼에 NULL값을 허용하지 않는다. (필수 입력 사항에 조건을 걸어둠)
-- UNIQUE		: 같은 컬럼안에 중복 값 허용하지 않는다. 
-- CHECK		: 지정한 입력사항 외에는 받지 못하게 막는 조건. (EX. 성별 : 남, 여)
-- PRIMARY KEY	: NOT NULL + UNIQUE 테이블 내에서 해당 행을 인식할 수 있는 고유 값. (EX. 주민번호)
-- FOREIGN KEY	: 다른 테이블에서 지정된 값을 연결 지어서 참조로 가져오는 데이터에 지정하는 제약조건

-- 걸려있는 제약조건 확인
select * from INFORMATION_SCHEMA.table_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'MULTI';

desc EMPLOYEE;

-- NOT NULL
-- '널값 허용하지 않는다.'

drop table user_NOCONS;
create table USER_NOCONS(
	USER_NO INT,
	USER_ID VARCHAR(20),
	USER_PW VARCHAR(20)
);

desc USER_NOCONS;
select * from user_nocons;

-- 테이블에 값 추가하기
insert into USER_NOCONS VALUES(1, 'USER01', 'PASS01');
insert into USER_NOCONS VALUES(2, null, NULL);

-- 
create table USER_NOT_NULL(
	USER_NO INT not null,
	USER_ID VARCHAR(20) not null,
	USER_PW VARCHAR(20) not NULL
);

desc USER_NOT_NULL;

insert into USER_NOT_NULL VALUES(1, null, 'PASS01');

select * from USER_NOT_NULL;

-- UNIQUE 제약조건 -- 
-- 중복을 허용하지 않는 제약 조건
insert into USER_NOCONS VALUES(3, 'USER01', 'PASS03');

select * from USER_NOCONS;

create table USER_UNIQUE(
	USER_NO INT,
	USER_ID VARCHAR(20) unique,
	USER_PW VARCHAR(30)
);

desc USER_UNIQUE;
select * from USER_UNIQUE;
insert into USER_UNIQUE VALUES(1, 'USER01', 'PASS01');
insert into USER_UNIQUE VALUES(2, 'USER01', 'PASS02');
-- SQL Error [1062] [23000]: Duplicate entry 'USER01' for key 'user_unique.USER_ID'

select * from USER_UNIQUE;
desc USER_UNIQUE;

-- 제약 조건을 따로 설정해 줄 수 있음
create table USER_UNIQUE2(
	USER_NO INT,
	USER_ID VARCHAR(20),
	USER_PW VARCHAR(30),
	UNIQUE(USER_ID)
);

desc USER_UNIQUE2;
insert into USER_UNIQUE2 VALUES(1, 'USER01', 'PASS01');
insert into USER_UNIQUE2 VALUES(2, 'USER01', 'PASS02');
-- SQL Error [1062] [23000]: Duplicate entry 'USER01' for key 'user_unique.USER_ID'

select * from USER_UNIQUE2;

-- UNIQUE 제약조건을 여러개 컬럼에 적용
-- 1, USER01
-- 1, USER02
-- 2, USER01
-- 2, USER02

-- USER_NO과 USER_ID를 묶어서 사용한다.
-- USER_NO과 USER_ID가 모두 같을 때 오류가 발생한다.
create table USER_UNIQUE3(
	USER_NO INT,
	USER_ID VARCHAR(20),
	USER_PW VARCHAR(30),
	UNIQUE(USER_NO, USER_ID) -- 테이블 레벨이라고 말함.
);

desc USER_UNIQUE3;

insert into USER_UNIQUE3 VALUES(1, 'USER01', 'PASS01');
insert into USER_UNIQUE3 VALUES(1, 'USER02', 'PASS01');
insert into USER_UNIQUE3 VALUES(2, 'USER01', 'PASS01');
insert into USER_UNIQUE3 VALUES(2, 'USER02', 'PASS01');

select * from USER_UNIQUE3;

-- UNIQUE를 각각 조건을 걸고 싶으면
-- create table USER_UNIQUE3(
-- 	USER_NO INT UNIQUE,
--  USER_ID VARCHAR(20) UNIQUE,
-- 	USER_PW VARCHAR(30),
-- );

show keys from EMPLOYEE;
-- 모든 제약조건 확인------------------------------------------------------
select * from information_schema.TABLE_CONSTRAINTS;

-- 제약조건에 이름 설정
create table CONS_NAME(
	TEST_DATA1 INT,
	TEST_DATA2 VARCHAR(20) UNIQUE,
	TEST_DATA3 VARCHAR(20),
	constraint UK_DATA3 UNIQUE(TEST_DATA3)
-- 	constraint UK_DATA2 UNIQUE(TEST_DATA2)
-- CONSTRAINT 정할이름_컬럼명 
);

-- CHECK 제약조건------------------------------------------------------
-- 지정한 값 이외에는 값이 기록되지 않도록 범위를 제한하는 조건.
create table USER_CHECK(
	USER_NO INT,
	USER_ID VARCHAR(20),
	USER_PW VARCHAR(30),
	GENDER VARCHAR(3) CHECK(GENDER in('남', '여'))
);

insert into USER_CHECK VALUES(1, 'USER01', 'PASS01', '남');

insert into USER_CHECK VALUES(2, 'USER02', 'PASS02', '남자');
-- SQL Error [3819] [HY000]: Check constraint 'user_check_chk_1' is violated.

insert into USER_CHECK VALUES(2, 'USER02', 'PASS02', 'F');
-- SQL Error [3819] [HY000]: Check constraint 'user_check_chk_1' is violated.

insert into USER_CHECK VALUES(2, 'USER02', 'PASS02', '여');

select * from USER_CHECK;

-- CHECK 제약조건에 부등호------------------------------------------------------
create table TEST_CHECK2(
	TEST_DATA INT,
	constraint CK_TEST_DATA CHECK(TEST_DATA > 0)
);

insert into TEST_CHECK2 VALUES(10);

insert into TEST_CHECK2 VALUES(-10);
-- SQL Error [3819] [HY000]: Check constraint 'CK_TEST_DATA' is violated.

create table TEST_CHECK3(
	C_NAME VARCHAR(15),
	C_PRICE INT,
	C_DATE DATE,
	C_QUAL VARCHAR(1),
	CHECK(C_PRICE between 1 and 9999999),
	CHECK(C_DATE >= '2010/10/01'),
	CHECK(C_QUAL >= 'A' and C_QUAL <= 'D')
);

-- 하나의 컬럼에 제약조건 여러개------------------------------------------------------
create table TEST_CONS(
	TEST_NO INT not null UNIQUE
);

-- PRIMARY KEY 제약조건 ------------------------------------------------------
-- '기본키  제약조건'
-- 테이블 내의 한 행에서 그 행을 식별하기 위한 고유값을 가지는 컬럼에
-- NOT NULL과 UNIQUE 제약조건을 함께 걸어주는 식별자 역할을 수행시키는 제약조건

create table USER_PK_TABLE(
	USER_NO INT primary key,
	USER_ID VARCHAR(20) unique,
	USER_PW VARCHAR(20) not null,
	GENDER VARCHAR(3) CHECK(GENDER in('남', '여'))
);

desc user_pk_table;

insert into USER_PK_TABLE VALUES(1, 'USER01', 'PASS01', '남');

insert into USER_PK_TABLE VALUES(2, 'USER02', 'PASS02', '여');

insert into USER_PK_TABLE VALUES(1, 'USER03', 'PASS03', '여');
-- SQL Error [1062] [23000]: Duplicate entry '1' for key 'user_pk_table.PRIMARY'

insert into USER_PK_TABLE VALUES(NULL, 'USER03', 'PASS03', '여');
-- SQL Error [1048] [23000]: Column 'USER_NO' cannot be null

select * from user_pk_table;

create table USER_PK_TABLE2(
	USER_NO INT,
	USER_ID VARCHAR(20) unique,
	USER_PW VARCHAR(30) not null,
	GENDER VARCHAR(15) CHECK(GENDER in('남', '여')),
	constraint PK_USER_NOID primary KEY(USER_NO, USER_ID)
);

-- 1, USER01 --> 성공
-- 2, USER02 --> 성공
-- 3, USER03 --> 성공
-- 2, USER01 --> 실패

-- CREATE 	: 생성
-- DROP		: 삭제 (DELETE는 데이터를 삭제 / DROP은 테이블을 삭제)
drop table member;

-- FOREIGN KEY
-- 외래키, 외부키, 참조키
-- 다른 테이블의 컬럼값을 참조하여 테이블의 값만을 허용함.

create table USER_GRADE(
	GRADE_CODE INT primary key,
	GRADE_NAME VARCHAR(30) not null
);

insert into USER_GRADE VALUES(1, '일반회원');
insert into USER_GRADE VALUES(2, 'VIP');
insert into USER_GRADE VALUES(3, 'VVIP');
insert into USER_GRADE VALUES(4, 'VVVIP');

select * from USER_GRADE;

create table USER_FOREIGN_KEY(
	USER_NO INT primary key,
	USER_ID VARCHAR(20),
	USER_PW VARCHAR(20),
	GENDER VARCHAR(1) CHECK(GENDER in('M', 'F')),
	GRADE_CODE INT,
	constraint FK_GRADE_CODE foreign KEY(GRADE_CODE)
	references USER_GRADE(GRADE_CODE)
);

insert into USER_FOREIGN_KEY VALUES(1, '123', '321', 'F', 2);
insert into USER_FOREIGN_KEY VALUES(2, 'ABC', 'ABC1', 'M', 4);
insert into USER_FOREIGN_KEY VALUES(3, 'DEF', 'DEF1', 'M', 1);
insert into USER_FOREIGN_KEY VALUES(4, 'GHI', 'GHI1', 'F', 3);
insert into USER_FOREIGN_KEY VALUES(5, 'JKL', 'JKL1', 'F', 1);

select * from user_foreign_key;

insert into USER_FOREIGN_KEY VALUES(6, '123', '321', 'F', 10);
-- SQL Error [1452] [23000]: Cannot add or update a child row: a foreign key constraint fails 

select * from user_foreign_key
join USER_GRADE using(GRADE_CODE)
order by USER_NO;

delete from user_grade where GRADE_CODE = 4;
-- SQL Error [1451] [23000]: Cannot delete or update a parent row: a foreign key constraint fails 

-- 삭제 옵션 ------------------------------------------------------
-- ON DELETE CASCADE : 자식 테이블의 데이터도 삭제.
drop table USER_FOREIGN_KEY;

create table USER_FOREIGN_KEY(
	USER_NO INT primary key,
	USER_ID VARCHAR(20),
	USER_PW VARCHAR(20),
	GENDER VARCHAR(1) CHECK(GENDER in('M', 'F')),
	GRADE_CODE INT,
	constraint FK_GRADE_CODE foreign KEY(GRADE_CODE)
	references USER_GRADE(GRADE_CODE) on delete cascade
);

insert into USER_FOREIGN_KEY VALUES(1, '123', '321', 'F', 2);
insert into USER_FOREIGN_KEY VALUES(2, 'ABC', 'ABC1', 'M', 4);
insert into USER_FOREIGN_KEY VALUES(3, 'DEF', 'DEF1', 'M', 1);
insert into USER_FOREIGN_KEY VALUES(4, 'GHI', 'GHI1', 'F', 3);
insert into USER_FOREIGN_KEY VALUES(5, 'JKL', 'JKL1', 'F', 1);

select * from user_foreign_key;

delete from USER_GRADE where GRADE_CODE = 4;

select * from user_foreign_key;
select * from USER_GRADE;

-- 추가 옵션 ------------------------------------------------------
-- ON UPDATE CASCADE : 
update USER_GRADE set GRADE_CODE = 10 where GRADE_CODE = 1;
-- SQL Error [1451] [23000]: Cannot delete or update a parent row: a foreign key constraint fails

drop table USER_FOREIGN_KEY;

create table USER_FOREIGN_KEY(
	USER_NO INT primary key,
	USER_ID VARCHAR(20),
	USER_PW VARCHAR(20),
	GENDER VARCHAR(1) CHECK(GENDER in('M', 'F')),
	GRADE_CODE INT,
	constraint FK_GRADE_CODE foreign KEY(GRADE_CODE)
	references USER_GRADE(GRADE_CODE) on delete cascade on update CASCADE
);

insert into USER_FOREIGN_KEY VALUES(1, '123', '321', 'F', 2);
-- insert into USER_FOREIGN_KEY VALUES(2, 'ABC', 'ABC1', 'M', 4);
insert into USER_FOREIGN_KEY VALUES(3, 'DEF', 'DEF1', 'M', 1);
insert into USER_FOREIGN_KEY VALUES(4, 'GHI', 'GHI1', 'F', 3);
insert into USER_FOREIGN_KEY VALUES(5, 'JKL', 'JKL1', 'F', 1);

select * from user_foreign_key;
select * from USER_GRADE;

update USER_GRADE set GRADE_CODE = 10 where GRADE_CODE = 1;

-- 기본값 설정하기
create table DEFAULT_TABLE(
	DATA_COL1 VARCHAR(30) default '없음',
	DATA_COL2 DATE default (CURRENT_DATE),
	-- 날짜 값
	DATA_COL3 DATETIME default (CURRENT_TIME)
	-- 날짜 시분초 값 
);

insert into DEFAULT_TABLE VALUES(default, default, DEFAULT);

select * from default_table;

-- DDL -> ALTER
-- ALTER : 수정 (UPDATE는 데이터 값을 수정하는 것이고 / ALTER는 테이블의 값을 수정)
-- ALTER ~ ADD : 제약조건 추가 
alter table DEPARTMENT add constraint PK_DEPT_DEPTID primary KEY(DEPT_ID);

alter table EMPLOYEE add constraint foreign key(DEPT_CODE) references DEPARTMENT(DEPT_ID);
alter table EMPLOYEE add constraint foreign key(SAL_LEVEL) references SAL_GRADE(SAL_LEVEL);

alter table EMPLOYEE add CHECK(ENT_YN IN('Y', 'N'));
alter table EMPLOYEE add CHECK(SALARY>0);

alter table EMPLOYEE add UNIQUE(EMP_NO);

alter table EMPLOYEE add foreign KEY(JOB_CODE) references JOB(JOB_CODE);

alter table DEPARTMENT add foreign KEY(LOCATION_ID) references LOCATION(LOCAL_CODE);

-- DML
-- SELECT, INSERT, UPDATE, DELETE
-- [CRUD]
-- C : INSERT | R : SELECT | U : UPDATE | D : DELETE

-- INSERT : 새로운 로우(행)를 특정 테이블에 추가하는 명령어
-- insert into EMPLOYEE(컬럼명, 컬럼명, ...) VALUES();
-- 컬럼 명시
insert into EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE,
					 JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE,
					 ENT_DATE, ENT_YN)
values(500, '임정수', '970711-1010101', 'JUNEWJDTN@GMAIL.COM', '01051298380', 'D1', 'J7', 'S4',
		3100000, 0.1, '200', NOW(), null, DEFAULT);
select * from EMPLOYEE;

-- 컬럼 생략 (모든 컬럼에 값 추가)
insert into EMPLOYEE VALUES(900, '이하석', '103949-2938495', 'LEE@gmail.com', '01023445321', 'D1',
							'J7', 'S3', 3300000, 0.2, '200', NOW(), null, default);

select * from EMPLOYEE;

-- INSERT + SUBQUERY
create table EMP_01(
	EMP_ID INT,
	EMP_NAME VARCHAR(20),
	DEPT_TITLE VARCHAR(40)
);

insert into EMP_01 (select EMP_ID, EMP_NAME, DEPT_TITLE 
					from EMPLOYEE 
					left JOIN DEPARTMENT on(DEPT_CODE = DEPT_ID)
);

select * from EMP_01;

-- UPDATE : 해당 테이블의 데이터를 수정하는 명령어
create table DEPT_COPY
as select * from DEPARTMENT;
-- AS : 참조하겠다
select * from DEPT_COPY;

-- UPDATE (테이블명) SET (수정할 컬럼명 = '수정내용') WHERE (조건 컬럼 = '조건');
update DEPT_COPY set DEPT_TITLE = '전략기획부' where DEPT_ID = 'D9';
select * from DEPT_COPY;

-- EMPLOYEE에 주민번호 잘못 표기된 데이터.
select EMP_ID, EMP_NO
from employee 
where SUBSTR(EMP_NO, 5, 2) > 31;

desc EMPLOYEE;
update EMPLOYEE set EMP_NO = CONCAT('621230', SUBSTR(EMP_NO, 7))
where EMP_ID = 200;

update EMPLOYEE set EMP_NO = CONCAT('631126', SUBSTR(EMP_NO, 7))
where EMP_ID = 201;

update EMPLOYEE set EMP_NO = CONCAT('850705', SUBSTR(EMP_NO, 7))
where EMP_ID = 214;

update EMPLOYEE set EMP_NO = CONCAT('930511', SUBSTR(EMP_NO, 7))
where EMP_ID = 900;

select EMP_ID, EMP_NO
from EMPLOYEE
where EMP_ID IN('200', '201', '214', '900');

update EMPLOYEE set DEPT_CODE = 'D0' where DEPT_CODE = 'D6';
-- SQL Error [1452] [23000]: Cannot add or update a child row: a foreign key constraint fails 

select * from EMPLOYEE;

update EMPLOYEE set ENT_YN = default where EMP_ID = 222;

-- DELETE ------------------------------------------------------
-- 테이블의 행을 삭제하는 명령어
create table TEST_DELETE
as select * from EMPLOYEE;

select * from TEST_DELETE;

-- DELETE를 통해 데이터 전체 삭제
delete from TEST_DELETE;
-- DELETE FROM (테이블명) WHERE (조건); -> 조건을 사용하여 원하는 행만 삭제 가능하다.
select * from TEST_DELETE;

-- ------------------------------------------------------
drop table DEPT_COPY;

-- 컬럼을 복사를 해올때는 데이터 값과 형태만 복사해 오고 제약조건은 가져오지 않음.
create table DEPT_COPY
as select * from DEPARTMENT;

select * from DEPT_COPY;

-- 컬럼 추가
alter table DEPT_COPY add (LNAME VARCHAR(20));
-- ALTER TABLE (테이블명) ADD (추가할 컬럼명 컬럼명의 타입값);
select * from DEPT_COPY;

-- 컬럼 삭제
alter table DEPT_COPY drop column LNAME;
-- ALTER TABLE (테이블명) DROP COLUMN (삭제할 컬럼명);
select * from DEPT_COPY;

-- 컬럼 추가(기본 값을 적용하여 추가)
alter table DEPT_COPY add (LNAME VARCHAR(20) default '한국');
-- ALTER TABLE (테이블명) ADD (추가할 컬럼명 컬럼명의 타입값 DEFAULT '넣을값');
-- 												 DEFAULT : 기본값 의미
-- DEPT_COPY 테이블에 VARCHAR(20) 크기의 기본값은 '한국'이 들어간 LNAME의 컬럼을 추가한다.
select * from DEPT_COPY;

alter table DEPT_COPY add constraint PK_DEPTCOPY primary KEY(DEPT_ID);
desc DEPT_COPY;

-- TCL
-- COMMIT, ROLLBACK (+ SAVEPOINT, ROLLBACK TO)
-- 트랜잭션 : 데이터를 처리하는 최소 작업 단위.
-- 하나의 트랜잭션으로 이루어진 작업은 반드시 작업 내용이 모두 성공하여 저장되거나, 실패하여 모두 이전으로 복구되어야 한다.

commit;

create table USER_TBL(
	USER_NO INT unique,
	USER_ID VARCHAR(20) not null unique,
-- NOT NULL과 UNIQUE를 동시 선언하면 정보창에 PRIMARY KEY로 뜸
	USER_PW VARCHAR(30) not NULL
);

desc USER_TBL;

insert into USER_TBL VALUES(1, 'TEST01', 'PASS01');
insert into USER_TBL VALUES(2, 'TEST02', 'PASS02');
select * from USER_TBL;

commit; -- 현재까지 작업한 DM1 내용을 DB에 반영한다.

insert into USER_TBL VALUES(3, 'TEST03', 'PASS03');
select * from USER_TBL;

rollback; -- 가장 최근에 COMMIT했던 구간으로 되돌아 가겠다.
select * from USER_TBL; 

insert into USER_TBL VALUES(3, 'TEST03', 'PASS03');
select * from USER_TBL;
savepoint SP1;
-- 데이터가 3개가 들어간 시점에서 SAVEPOINT를 해줌

insert into USER_TBL VALUES(4, 'TEST04', 'PASS04');
select * from USER_TBL;

rollback to SP1;
-- ROLLBACK TO SP1; -> SP1로 되돌아 가겠다.
select * from USER_TBL;

rollback;
-- 가장 최근에 COMMIT 했던 구간으로 돌아감 (2개의 데이터를 넣고 COMMIT을 했기 때문에 데이터 2개가 나옴)
select * from USER_TBL;

-- ----------------------------------------------------
-- VIEW(뷰) --
-- SELECT를 통해 그 결과를 담는다.

-- CREATE VIEW (뷰 이름) AS (서브쿼리 / 뷰에서 확인할 SELECT 쿼리)
create view V_EMP
as select EMP_ID, EMP_NAME, DEPT_CODE from EMPLOYEE;
-- V_EMP라고 하는 뷰에 EMPLOYEE 테이블의 EMP_ID, EMP_NAME, DEPT_CODE를 가져오겠다.
-- = SELECT * FROM (select EMP_ID, EMP_NAME, DEPT_CODE from EMPLOYEE); 와 같은 개념

select * from V_EMP;
desc V_EMP;

-- 사번, 이름, 직급명, 부서명, 근무지역을 조회 -------------------
-- 그 결과를 V_RES_EMP 라는 뷰를 만들고 해당 뷰를 통해 결과 조회
-- [1] 서브 쿼리 준비
-- [2] 뷰 생성
-- 전체 테이블 확인
select * from EMPLOYEE;
select * from LOCATION;
select * from JOB;
select * from DEPARTMENT;
-- ----------------------------------------------------
-- [1]번 서브쿼리 준비
select EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
from EMPLOYEE
join JOB using(JOB_CODE)
join DEPARTMENT on(DEPT_CODE = DEPT_ID)
join LOCATION on(LOCATION_ID = LOCAL_CODE);

-- [2]번 뷰 생성
create view V_RES_EMP
as 
select EMP_ID '사번', EMP_NAME '사원명', JOB_NAME '직급명', DEPT_TITLE '부서명', LOCAL_NAME '근무지역'
from EMPLOYEE
left join JOB using(JOB_CODE)
left join DEPARTMENT on(DEPT_CODE = DEPT_ID)
left join LOCATION on(LOCATION_ID = LOCAL_CODE);
-- CREATE VIEW V_RES_EMP(사번, 이름, 직급명, 부서명, 근무지) 
-- 이런식으로 작성할 경우 컬럼의 별칭을 사용할 수 있음

-- CREATE OR REPLACE VIEW V_RES_EMP
-- OR REPLACE -> 기존에 있던 뷰(V_RES_EMP)에 덮어 쓴다는 의미

-- 뷰 확인
select * from V_RES_EMP;

-- 뷰 삭제
drop view V_RES_EMP;
commit;

show create view V_RES_EMP;

-- 만들어진 VIEW(V_RES_EMP)를 활용하여
-- 사번이 '205'인 직원 정보 조회하기.
select * from V_RES_EMP
where 사번 = '205';

commit;

-- 뷰 삭제
drop view V_RES_EMP;

-- 뷰 생성
create or replace view V_EMP(사번, 사원명, 부서코드)
as 
select EMP_ID, EMP_NAME, DEPT_CODE
from EMPLOYEE;

select * from V_EMP;

-- 뷰에는 연산, 함수 결과도 포함하여 저장 가능.
-- 사번, 이름, 성별, 근무년수 조회
-- 1)
select EMP_ID, EMP_NAME,
	if(SUBSTR(EMP_NO, 8, 1)=1, '남성', '여성'),
	EXTRACT(year from NOW()) - EXTRACT(year from hire_date)
from EMPLOYEE;

-- 2)
create or replace view V_EMP(사번, 이름, 성별, 근무년수)
as
select EMP_ID, EMP_NAME,
	if(SUBSTR(EMP_NO, 8, 1)=1, '남성', '여성'),
	EXTRACT(year from NOW()) - EXTRACT(year from hire_date)
from EMPLOYEE;

select * from V_EMP;

-- 뷰에 데이터 삽입, 수정 삭제하기
create or replace view V_JOB
as
select * from JOB;

select * from V_JOB;

-- 뷰를 통한 데이터 추가
insert into V_JOB VALUES('J8', '인턴');

select * from JOB;
select * from V_JOB;

-- 뷰를 통해 데이터 수정도 가능
update V_JOB 
set JOB_NAME = '알바'
where JOB_CODE = 'J8';

select * from V_JOB;
select * from JOB;

-- 뷰를 통해 데이터 삭제도 가능
delete from V_JOB
where JOB_CODE = 'J8';

select * from JOB;
select * from V_JOB;

-- -------------------------------------------------
-- AUTO_INCREMENT
-- 자동으로 1씩 증가 시켜주는 기능
-- INSERT 할때 마다 자동으로 1씩 증가.
create table AT_TEST(
	ID INT auto_increment primary key,
	NAME VARCHAR(30)
);

select * from AT_TEST;
desc AT_TEST;

insert into AT_TEST VALUES(1, '임정수');
insert into AT_TEST VALUES(11, '엄규진');
select * from AT_TEST;

insert into AT_TEST VALUES(null, '고태윤');
select * from AT_TEST;

insert into AT_TEST VALUES(null, '김준규');
select * from AT_TEST;

insert into AT_TEST(NAME) VALUES('이우정');
select * from AT_TEST;

-- 현재 어느 숫자까지 증가 되었는지 확인
select LAST_INSERT_ID();

-- 변경
alter table AT_TEST auto_increment = 50;
-- AUTO_INCREMENT = 숫자; -> 입력한 숫자값 부터 번호를 매길수 있음

select * from AT_TEST;
insert into AT_TEST(NAME) VALUES('이우정');

set @@AUTO_INCREMENT_INCREMENT = 3;
-- 증가 값을 3씩 증가시킴
-- 공용 설정이기 때문에 ( 모든 테이블에 적용되기 떄문에 ) 설정할때 주의를 기울여야 함

create table AT_TEST2(
	ID INT,
	NAME VARCHAR(30) auto_increment
-- SQL Error [1063] [42000]: Incorrect column specifier for column 'NAME'
-- INT (정수) 타입과 식별자에 대해 AUTO_INCREMENT가 지정 가능하다.
);

create table AT_TEST2(
	ID inT auto_increment primary KEY,
	NAME VARCHAR(30) 
);

insert into AT_TEST2 VALUES(null, "A");
insert into AT_TEST2 VALUES(null, "B");
select * from AT_TEST2;


