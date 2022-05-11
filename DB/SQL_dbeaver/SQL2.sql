-- CRUD 	: 데이터 기본 처리 로직
-- CREATE 	: 데이터 추가 / INSERT
-- READ 	: 데이터 조회 / SELECT
-- UPDATE 	: 데이터 수정 / UDPATE
-- DELETE	: 데이터 삭제 / DELETE

-- SELECT : 조회용 SQL
-- EX)
-- SELECT *(조회 컬럼)
-- FROM 테이블명
-- WHERE 조건
-- ORDER BY 컬럼
-- ;

-- 결과를 돌려 받는 것(밑에 결과가 나오는 창)을 RESULT SET 이라 함

-- 1. AS 표현
select EMP_ID as "사원번호", EMP_NAME as "사원명" from EMPLOYEE;
-- AS "~" : 쉽게 말해 별칭 (RESULT SET의 컬럼명을 ""안에 내용으로 바꾸는 기능)

-- 2. AS 생략
select EMP_ID "사원번호" , EMP_NAME '사원명' from EMPLOYEE;
-- AS를 생략 가능하다
select EMP_ID 사원번호, EMP_NAME 사원명 from EMPLOYEE;
-- "", '' 생략 가능하지만 띄어쓰기나 ()가 들어가게 되면 오류가 나기 때문에 왠만하면 '', ""를 사용하는게 좋다.

select EMP_NAME "사원명", (SALARY * 12) "연봉", BONUS "보너스", 
	(SALARY + (SALARY * BONUS)) * 12 "연봉총합"  from EMPLOYEE;
-- 컬럼명이 길이지기 때문에 별칭을 사용하여 간단하게 파악 가능하다

-- IFNULL() : 만약 현재 조회하는 값이 NULL이면 지정한 값으로 변경
select EMP_NAME "사원명", (SALARY * 12) "연병", '원' 단위, IFNULL(BONUS,0) "보너스", 
	(SALARY + (SALARY * IFNULL(BONUS, 0))) * 12 "연봉총합", '원' 단위 from EMPLOYEE;

-- DISTINCT
-- 중복 제거 하고 한 개만 조회
select EMP_NAME, DEPT_CODE from EMPLOYEE;

select distinct DEPT_CODE from EMPLOYEE;
-- DISTINCT는 잘 사용 안함 (성능 저하 원인이기도 하기 때문에 중복제거는 다른 방식으로 많이 사용)

-- 실습 [1]
-- DEPARTMENT 테이블을 참조하여,
-- 부서가 '해외영업2부'인 부서의 부서코드를 찾고,
-- EMPLOYEE 테이블에서 해당 부서의
-- 사원들 중 급여를 200만원보다 많이 받는 직원의
-- 사번, 사원명, 급여를 조회하시오.

-- HINT. 1) '해외영업2부' 부서의 부서코드 조회
-- HINT. 2) 직원 조회

-- 1)
select * from DEPARTMENT;
select DEPT_TITLE from DEPARTMENT where DEPT_TITLE='해외영업2부';
-- => 해외영업2부 D6 찾음

-- 2)
select * from EMPLOYEE;
select EMP_ID "사번", EMP_NAME "사원명", SALARY "급여" from EMPLOYEE 
where DEPT_CODE = 'D6' and SALARY > 2000000;

-- 연산자 --
-- 비교연산자
-- <, >, <=, >= : 크기를 나타내는 부등호
-- =  			: 같다
-- !=, <>		: 같지 않다

-- EMPLOYEE 테이블에서 부서코드가 'D9'이 아닌 직원들의
-- 모든 정보를 조회
select * from EMPLOYEE where DEPT_CODE != 'D9';
-- OR
select * from EMPLOYEE where DEPT_CODE <> 'D9';

-- 급여가 350만원 이상, 550만원 이하인 
-- 직원의 사번, 사원명, 부서코드, 직급코드, 급여를 조회
-- [1]
select EMP_ID "사번", EMP_NAME "사원명", DEPT_CODE "부서코드", SALARY "급여"
from EMPLOYEE where SALARY >= 3500000 and SALARY <= 5500000;

-- [2]
select EMP_ID "사번", EMP_NAME "사원명", DEPT_CODE "부서코드", SALARY "급여" 
from EMPLOYEE where SALARY between 3500000 and 5500000;
-- BETWEEN A AND B -> A는 이상 B는 이하인 사이 값을 구하는 기능

-- LIKE
-- 입력한 숫자, 문자가 포함된 정보를 조회할 때 사용하는 연산자
-- '_' : 임의의 한 문자를 가르킴
-- '%'

-- 사원의 이름에 가운데 글자가 '중'인 사원 정보 조회
select * from EMPLOYEE where EMP_NAME like '_중_';

-- 주민등록번호 기준 남성인 사원의 정보만 조회
select * from EMPLOYEE where EMP_NO like '%-1%';

-- 사원 중 이메일 아이디가 5글자 이상인 사원의 사원명, 사번, 이메일 조회
select EMP_NAME "사원명", EMP_ID "사번", EMAIL "이메일" from EMPLOYEE
where EMAIL like '_____%@%';

select * from EMPLOYEE where EMP_NAME like '이%';

-- 사원 중 이메일 4번째 글자가 '_'인 사원의 정보 조회
-- ESCAPE 문자를 선언 / 뒤에오는 문자를 특수문자가 아닌 일반 문자로 선언하여 사용
select * from EMPLOYEE where EMAIL like '___#_%@%' escape '#';

-- IN 연산자
-- IN(값1, 값2, 값3, ...)
-- 직급 코드가 J1 이거나 J4인 직원 정보 조회
-- SELECT * FROM EMPLOYEE WHERE JOB_CODE = 'J1' OR JOB_CODE ='J4';
select * from EMPLOYEE WHERE JOB_CODE IN('J1', 'J4');

-- NOT IN 연산자
-- IN(값1, 값2, 값3, ...)이 아닌 값을 가져오는 기능
select  * from EMPLOYEE where JOB_CODE not IN('J1', 'J4');

-- 함수(FUNCTION) --
-- LENGTH : 문자열의 길이를 계산하는 함수 / BYTE 길이 (영어 한글자당 : 1, 한글 한 글자당 : 3)
select LENGTH('HELLO');
select LENGTH('임정수');

-- CHAR_LENGTH : 글자 수
select LENGTH('HELLO'), CHAR_LENGTH('HELLO');
select LENGTH('임정수'), CHAR_LENGTH('임정수');

-- INSTR() : 주어진 값에서 원하는 문자가 몇번째인지 찾아 반환하는 함수
select INSTR('ABCD', 'A'), INSTR('ABCD', 'C'), INSTR('ABCD', 'F');

select INSTR('ABCDEF', 'CD');

-- SUBSTR('주어진 값', 'A', 'B') : '주어진 값'에서 'A'부터 'B'개까지 잘라서 가져온다. 
select 'HELLO WORLD', SUBSTR('HELLO WORLD', 1, 6);

-- SUBSTR('주어진 값', 'A') : '주어진 값'에서 'A'부터 잘라서 가져온다. 
select 'HELLO WORLD', SUBSTR('HELLO WORLD', 7);

-- 실습 [2]
-- EMPLOYEE 테이블에서 사원들의 이름, 이메일 주소를 조회
-- 단, 이메일은 아이디 부분만 조회

-- HINT 1) 이름과 이메일을 조회
select EMP_NAME "사원명", EMAIL "이메일 주소" from EMPLOYEE;
-- HINT 2) @ 위치 찾기
select EMP_NAME "사원명", INSTR(EMAIL, '@')"이메일 주소" from EMPLOYEE ;
-- HINT 3) SUBSTR 활용
select EMP_NAME "사원명", SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') - 1) "이메일 주소" from EMPLOYEE;

-- LPAD / RPAD
-- 빈칸을 지정한 문자로 채우는 함수
-- LPAD 왼쪽에 공간을 채우자 / RPAD 오른쪽에 공간을 채우자
-- LPAD/RPAD('A', 'B','C'); -> 'A'의 문자열을 'B'크기만큼('B'-'A'의 빈칸만큼) 'C'로 채우자
select LPAD(EMAIL, 20, '#') from EMPLOYEE;
select RPAD(EMAIL, 20, '*') from EMPLOYEE;

-- TRIM
-- LTRIM / RTRIM : 공백만 찾아 지워주는 함수
select LTRIM('   HELLO'), RTRIM('HELLO    ');
select LTRIM('HELLO   '), RTRIM('    HELLO');

-- TRIM : 양끝을 기준으로 특정 문자를 지워주는 함수
select TRIM('    5교시    ');
select TRIM('0' from '000123000');
-- LEADING / TRAILING
-- LEADING : 지정한 문자를 사용하여 앞쪽에 있는 문자만 제거
select TRIM(leading '0' from '000123000');

-- TRAILING : 지정한 문자를 사용하여 뒤쪽에 있는 문자만 제거
select TRIM(TRAILING '0' from '000123000');

-- BOTH : 지정한 문자를 사용하여 양쪽에 있는 문자를 제거
select TRIM(both '0' from '000123000');

-- CONCAT : 여러 문자열을 하나의 문자열로 합치는 함수
-- CONCAT('A', 'B'); -> 'A'문자열과 'B'문자열을 합치는 함수
select CONCAT('마이에스큐엘', '너무너무 재미있어요 :)');

-- REPLACE : 주어진 문자열에서 특정 문자를 변경할 때 사용하는 함수
-- REPLACE('문자열', 'A', 'B'); -> 문자열의 A를 B로 바꾸어 주는 함수
select REPLACE('HELLO WORLD', 'HELLO', 'BYE');

-- 실습[3]
-- EMPLOYEE 테이블에서 모든 사원의 사번, 사원명, 이메일, 주민번호를 조회
-- 이 때, 이메일은 '@' 전까지,
-- 주민번호는 7번째 자리 이후 '*' 처리하여 조회

select * from EMPLOYEE;

select EMP_ID "사원번호", EMP_NAME "사원명", EMAIL "이메일", EMP_NO "주민번호" 
from EMPLOYEE;

select SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) from EMPLOYEE;

select EMP_ID "사원번호", EMP_NAME "사원명", SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1),
EMP_NO "주민번호" from EMPLOYEE;

select SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-') + 1) from EMPLOYEE;

select EMP_ID "사원번호", EMP_NAME "사원명", SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 
"이메일", RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') "주민번호" from EMPLOYEE;

-- EMPLOYEE 테이블에서 현재 근무하는
-- 여성 사원의 사번, 사원명, 직급코드를 조회
-- ENT_YN : 퇴사 여부(Y면 퇴사했다)
-- WHERE 절에도 함수 사용 가능
select * from EMPLOYEE;

-- 단일행 함수 : 결과 찾아서 출력할 때마다 (각 행마다) 함수 적용
select EMP_ID, EMP_NAME, JOB_CODE, ENT_YN from EMPLOYEE 
where ENT_YN = 'N' and SUBSTR(EMP_NO, 8, 1) = '2';


select EMP_ID, EMP_NAME, JOB_CODE, ENT_YN from EMPLOYEE 
where ENT_YN = 'N' and EMP_NO like '%-2%';

select SUBSTR(EMP_NO, 8, 1) from EMPLOYEE;

-- -----------------------------------------------------------------
-- 다중행 함수 : 조건에 만족하는 모든 행을 찾고 나서 한번에 연산
-- 그룹함수 : SUM(), AVG(), MAX(), MIN(), COUNT()
-- 여러개의 행의 값을 한개의 값으로 나타냄

-- SUM(숫자가 기록된 컬럼) : 해당 컬럼들의 합계
select SUM(SALARY) from EMPLOYEE;

-- AVG('') : 평균을 계산
select AVG(SALARY) from EMPLOYEE;

-- MAX(''), MIN('') : 최대, 최소 값
select MAX(SALARY), MIN(SALARY) from EMPLOYEE;

-- EMPLOYEE 테이블에서 '해외영업1부'에 근무하는 모든 사원의
-- 평균 급여, 가장 높은 급여, 가장 낮은 급여, 급여 합계 조회
select * from DEPARTMENT where DEPT_TITLE = '해외영업1부';

select AVG(SALARY) "평균 급여", MAX(SALARY) "가장 높은 급여", 
MIN(SALARY) "가장 낮은 급여", SUM(SALARY) "급여 합계" 
from EMPLOYEE where DEPT_CODE = 'D5';

select MAX(SALARY), EMP_NAME from EMPLOYEE;

-- COUNT(컬럼명) : 행의 갯수 (NULL은 카운트를 하지 않음)
select COUNT(*), COUNT(DEPT_CODE), COUNT(distinct DEPT_CODE) from EMPLOYEE;

select distinct DEPT_CODE from EMPLOYEE;

-- -----------------------------------------------------------------
-- 날짜 처리 함수
-- SYSDATE() : 현재 컴퓨터의 날짜를 반환 (SYSDATE()의 문이 연산 될 때 시간을 나타냄)
select SYSDATE();

-- NOW() : 현재 시간 (쿼리문이 시작 됬을 때 시간이 나타남)
select NOW(), SLEEP(5), SYSDATE();

-- 두 날짜 사이의 차이
-- DATEDIFF 	 : 단순 일 차이
-- TIMESTAMPDIFF : 연, 분기, 월, 주, 일, 시, 분, 초를 지정하여 차이

-- DATADIFF('A'날, 'B'날); -> 'A'날짜 - 'B'날짜 를 뺸 값이 나옴
select HIRE_DATE "입사일", DATEDIFF(NOW(), HIRE_DATE) + 1 "일 수" from EMPLOYEE;

-- TIMESTAMPDIFF('원하는 타임 지정', 'A'날, 'B'날);
-- -> 'B'날에서 'A'날을 빼 '원하는 타임 지정'만큼 나타내준다
select HIRE_DATE "입사일", TIMESTAMPDIFF(year, HIRE_DATE, NOW()) from EMPLOYEE;
select HIRE_DATE "입사일", TIMESTAMPDIFF(QUARTER, HIRE_DATE, NOW()) from EMPLOYEE;
select HIRE_DATE "입사일", TIMESTAMPDIFF(month  , HIRE_DATE, NOW()) from EMPLOYEE;
select HIRE_DATE "입사일", TIMESTAMPDIFF(second  , HIRE_DATE, NOW()) from EMPLOYEE;

-- SECOND : 초, MINUTE : 분, HOUR : 시, DAY : 일
-- WEEK : 주, MONTH : 월, QUARTER : 분기, YEAR : 연

-- EXTRACT( YEAR | MONTH | DAY FROM 날짜);
select HIRE_DATE, EXTRACT(year from HIRE_DATE), EXTRACT(month FROM HIRE_DATE),
EXTRACT(day from HIRE_DATE) from EMPLOYEE;

-- DATE_FORMAT() -> 날짜를 문자로
-- 날짜 정보 변경
select HIRE_DATE, DATE_FORMAT(HIRE_DATE, '%Y%m%d%H%i%s'),
DATE_FORMAT(HIRE_DATE, '%Y/%m/%d %H:%i:%s'),
DATE_FORMAT(HIRE_DATE, '%y/%m/%d %H:%i:%s'),
DATE_FORMAT(NOW(), '%Y/%m/%d %H:%i:%s')
from EMPLOYEE;

-- STR_TO_DATE(CHAR, FORMAT) -> 문자를 날짜로
select 20190322, STR_TO_DATE('20190322', '%Y%m%d');
select 20190322, STR_TO_DATE('190322', '%y%m%d');
select 20190322, STR_TO_DATE('2019 03 22 12 52 10', '%Y%m%d%H%i%s');
select 20190322, STR_TO_DATE(190322, '%y%m%d');

-- -----------------------------------------------------------------
-- IF(조건, 값(참), 값(거짓))

-- 현재 근무하는 직원들의 성별을 남, 여 구분
select EMP_NAME "사원명", EMP_NO "주민번호", 
IF(SUBSTR(EMP_NO, 8, 1) = 1, '남', '여') "성별"
from EMPLOYEE;

-- 실습 [4]-1
-- EMPLOYEE 테이블에서 모든 직원의 사번, 사원명, 부서코드, 직급코드, 근무여부, 관리자 여부를 조회
-- 이때, 근무여부(ENT_YN)가 'Y' 퇴사자, 'N'이면 근무자
-- 관리자 사번(MANAGER_ID)가 있으면 사원, 없으면 관리자로 조회하라.
select * from employee;
select * from DEPARTMENT;
select EMP_ID "사번", EMP_NAME "사원명", DEPT_CODE "부서코드", JOB_CODE "직급코드", 
if(ENT_YN = 'N', '근무자', '퇴사자') "근무여부"  ,
IF(MANAGER_ID is null, '관리자', '사원') "관리자 여부"
-- IF(IFNULL(MANAGER_ID,0) = 0, '관리자', '사원') "관리자 여부"
from EMPLOYEE;

-- CASE
-- 자바의 IF, SWITCH 처럼 사용 가능
-- -----------------------
-- CASE
-- 	WHEN 조건식1 THEN 결과값1
-- 	WHEN 조건식2 THEN 결과값2
-- 	ELSE 결과값3
-- END "별칭"
-- -----------------------

-- 실습 [4]-2
select EMP_ID "사번", EMP_NAME "사원명", DEPT_CODE "부서코드", JOB_CODE "직급코드",
case 
	when ENT_YN = 'Y' then '퇴사자'
	else '근무자'
end "근무 여부",
case 
	when MANAGER_ID is null then '관리자'
	else '사원'
end "관리자 여부"
from EMPLOYEE;


-- 문제 [1]
-- 직급이 'J2'이면서 200만원 이상 받는 직원 이거나,
-- 직급이 'J7'인 사원의 사번, 사원명, 직급코드, 급여 정보 조회하기
select EMP_ID, EMP_NAME, JOB_CODE, SALARY from employee
where (JOB_CODE = 'J2' and SALARY >=2000000) or JOB_CODE = 'J7';

-- 문제 [2]
-- EMPLOYEE 테이블에서 사원의 주민 번호를 확인하여
-- 생년 월 일을 각각 조회하시오.
-- 이름 | 생년 | 생월 | 생일
-- 홍길 | 00년 |00월 | 00일 
select EMP_NAME "이름", 
CONCAT(SUBSTR(EMP_NO, 1, 2), '년') "생년",
CONCAT(SUBSTR(EMP_NO, 3, 2), '월') "월",  
CONCAT(SUBSTR(EMP_NO, 5, 2), '일') "일" 
from EMPLOYEE;


-- == 선물 == --
-- 1. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 수 조회함
-- 사번 사원명 부서코드 입사일 조회
select 	EMP_ID "사번",
		EMP_NAME "사원명",
		DEPT_CODE "부서코드",
		HIRE_DATE "입사일"
from EMPLOYEE 
where (DEPT_CODE = 'D5' or DEPT_CODE= 'D9') and HIRE_DATE like '2004%';
-- WHERE DEPT_CODE IN('D5', 'D9') AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;


-- 2. 직원명, 입사일, 입사한 달의 근무일수 조회
-- 단, 주말도 포함함 (LAST_DAY() : 주어진 날짜의 해당월의 마지막 날 변환)
select 	EMP_NAME "직원명", 
		HIRE_DATE "입사일", 
 		DATEDIFF(LAST_DAY(HIRE_DATE), HIRE_DATE) + 1 "입사한 달의 근무일수"
-- TIMESTAMPDIFF(DAY, HIRE_DATE, LAST_DAY(HIRE_DATE)) + 1 "입사한 달의 근무일수"
from EMPLOYEE;

-- 3. *** 직원명, 부서코드, 생년월일, 나이 조회
-- 단, 생년월일은 주민번호에서 추출해서 00년 00월 00일로 출력되게 함.
-- CONCAT 사용해서 해보기 -> 00년 00월 00일
-- 나이는 주민번호에서 추출해서 날짜 데이터로 변환한 다음, 계산함
select 	EMP_NAME "직원명",
		DEPT_CODE "부서코드",
 		CONCAT(CONCAT(CONCAT(SUBSTR(EMP_NO, 1, 2), "년 "),
	 	CONCAT(SUBSTR(EMP_NO, 3, 2), "월 ")), 
 		CONCAT(SUBSTR(EMP_NO, 5, 2), "일")) "생년월일",
-- 		DATE_FORMAT(CONCAT('19', SUBSTR(EMP_NO, 1, 6)), '%y년 %m월 %d일') "생년월일",
		TIMESTAMPDIFF(YEAR, STR_TO_DATE(SUBSTR(EMP_NO,1,6), '%y%m%d'), NOW()) "나이"
from EMPLOYEE;

select EXTRACT(year from NOW()) - EXTRACT(year from (STR_TO_DATE(CONCAT('19', SUBSTR(EMP_NO, 1, 6)), '%y%m%d'))) '나이'
from EMPLOYEE;


-- 4. 부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.
-- 단, 부서코드가 D5, D6, D9인 직원의 정보만 조회함
-- => CASE 사용
-- 사원명, 부서코드, 부서명
select 	EMP_NAME "사원명",
		DEPT_CODE "부서코드",
		case 
			when DEPT_CODE = 'D5' then '총무부'
			when DEPT_CODE = 'D6' then '기획부'
			when DEPT_CODE = 'D9' then '영업부'
		end	"부서명"
from EMPLOYEE where DEPT_CODE in('D5', 'D6', 'D9');

