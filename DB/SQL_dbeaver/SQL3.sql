-- IN(값1, 값2, 값3, ...) -> WHERE 값1 OR 값2 OR 값3 OR ...
select EMP_ID, EMP_NAME, DEPT_CODE
from EMPLOYEE where DEPT_CODE in ('D1', 'D5');

-- NOT IN(값1, 값2, 값3, ...) / NULL 값은 가져오지 못함
select EMP_ID, EMP_NAME, DEPT_CODE
from EMPLOYEE where DEPT_CODE not in ('D1', 'D5');

-- ABS(값) : 특정 숫자의 절대값 표현.
select ABS(-10), ABS(10);

-- MOD(값1, 값2) : 주어진 컬럼이나 값을 나눈 나머지를 반환
-- 값1 / 값2 를 하여 나머지를 구해줌
select MOD(10, 3), mod(3, 10);

-- ROUND(값1, 숫자) : 지정한 자리수 부터 반올림.
select ROUND(123.456, 0), 
	   ROUND(123.456, 1), 
	   ROUND(123.456, 2),
	   ROUND(123.456, -2),
	   ROUND(123.456, -1);

-- CEIL : 소수점 첫째 자리에서 올림
-- FLOOR : 소수점 이하 자리를 모두 버림
select CEIL(123.456), FLOOR(123.456);

-- TRUNCATE() : 지정한 위치까지 숫자를 버리는 함수
select TRUNCATE(123.456, 0), 
	   TRUNCATE(123.456, 1),
	   TRUNCATE(123.456, 2),
	   TRUNCATE(123.456, -2);
	  
-- CEILING(숫자) : 소수점 반올림 (입력한 값보다 큰 정수를 나타내는 함수)
select CEILING(4.0),
	   ceiling(4.1),
	   ceiling(4.2),
	   ceiling(3.9),
	   ceiling(3.1),
	   ceiling(3.8);	 
	  
select CEILING(-4.0),
	   ceiling(-4.1),
	   ceiling(-3.9);

-- 실습 [1]
-- EMPLOYEE 테이블에서 입사한 달의 숫자가 홀수 달인 직원의
-- 사번, 사원명, 입사일 정보를 조회
select EMP_ID "사번", EMP_NAME "사원명", HIRE_DATE "입사일"
from EMPLOYEE where mod(SUBSTR(HIRE_DATE, 7, 1), 2) = 1;

-- DATE_ADD(날짜값, INTERVAL) : 특정 날짜 이후 (날짜 값에 INTERVAL 값 이후 만큼 날짜를 알려줌)
-- DATE_SUB(날짜값, INTERVAL) : 특정 날짜 이전 (날짜 값에 INTERVAL 값 이전 만큼 날짜를 알려줌)

select EMP_NAME, HIRE_DATE,
	DATE_ADD(HIRE_DATE, interval 1 DAY)
from EMPLOYEE;

select EMP_NAME, HIRE_DATE,
	DATE_SUB(HIRE_DATE, interval 1 DAY)
from EMPLOYEE;

-- DAYOFWEEK(날짜값) : 날짜 값의 주중 무슨 요일인지 알려주는 함수
-- 1 = 일요일, 2 = 월요일, 3 = 화요일, 4 = 수요일, 5 = 목요일, 6 = 금요일, 7 = 토요일
select DAYOFWEEK(NOW());

select EMP_NAME,
	case 
		when DAYOFWEEK(HIRE_DATE) = 1 then '일요일'
		when DAYOFWEEK(HIRE_DATE) = 2 then '월요일'
		when DAYOFWEEK(HIRE_DATE) = 3 then '화요일'
		when DAYOFWEEK(HIRE_DATE) = 4 then '수요일'
		when DAYOFWEEK(HIRE_DATE) = 5 then '목요일'
		when DAYOFWEEK(HIRE_DATE) = 6 then '금요일'
		when DAYOFWEEK(HIRE_DATE) = 7 then '토요일'
	end '요일'
from EMPLOYEE;

-- LAST_DAY(날짜 값) : 날짜의 마지막 일자를 조회
select LAST_DAY(NOW());

-- 실습 [2]
-- EMPLOYEE 테이블에서 근무년수가 20년 이상인 사원들의
-- 사번, 사원명, 부서코드, 입사일 조회
select EMP_ID "사번", EMP_NAME "사원명", DEPT_CODE "부서코드", HIRE_DATE "입사일" 
from EMPLOYEE where DATE_ADD(HIRE_DATE, interval 20 YEAR) <= NOW();

-- 형변환 함수 --
-- STR_TO_STR, DATE_FORMAT
-- CAST(값 AS 형식), CONVERT(값, 형식) : 주어진 값을 원하는 형식으로 변경.

select cast(20220429 as DATE), convert(20220429, DATE);
select CAST(20220101030330 as CHAR), convert(20220101030330, CHAR);
select CAST(NOW() as CHAR), convert(NOW(), CHAR);

-- 형 타입
-- BINARY 	: 이진 데이터
-- CHAR		: 문자
-- DATE		: 날짜
-- INTEGER	: 숫자(양수, 음수) / UNSIGEND INTEGER : 양수만 | SIGEND INTEGER : 음수만
-- DECIMAL	: 소수점까지
-- JOSN		: JSON타입 데이터

select '123' + '456';
select CONCAT('123', '456');
select '123' + '456ABC';
select '123' + '4A56BC';

-- SELECT문 실행 순서--
/* 
 * 각 번호는 실행 순서
 * 5: SELECT 컬럼, 계산식, 함수식 AS 별칭, ...
 * 1: FROM 테이블명
 * 2: WHERE 조건
 * 3: GROUP BY 그룹을 묶을 컬럼
 * 4: HAVING 그룹에 대한 조건식
 * 6: ORDER BY 컬럼 | 별칭 | 순서
 * 
 */

-- ORDER BY
-- SELECT 통해 조회한 행의 결과들을 특정 기준에 맞춰 정렬

select EMP_ID, EMP_NAME "이름", SALARY, DEPT_CODE
from employee
-- ORDER by EMP_ID; -- 정렬의 기본값은 ASC
-- order by EMP_NAME ASC;
-- 정해준 컬럼으로 오름차순으로 정렬 함
-- order by DEPT_CODE desc, EMP_NAME;  -- desc : 내림차순
-- 정해준 컬럼으로 내림차순으로 정렬 함
-- order by 이름 DESC;
order by 3 desc; -- 숫자를 사용하여 select 문의 컬럼의 3번째 컬럼을 가르켜 정렬해라는 의미

-- GROUP BY --
-- 부서별 평균
-- 전체
select TRUNCATE(AVG(SALARY), -4) from EMPLOYEE;

-- D1 평균 급여
select TRUNCATE(AVG(SALARY), -4), DEPT_CODE from EMPLOYEE
where DEPT_CODE = 'D1';

-- 특정 컬럼을 하나의 그룹으로 묶어 한 테이블 내에서 
-- 조회하고자 할때 선언하는 구문.

select DEPT_CODE, TRUNCATE(AVG(SALARY), -4) from employee
group by DEPT_CODE
order by 1;

-- EMPLOYEE 테이블에서 부서별 총 인원, 급여 합계, 급여 평균, 최대 급여, 최소 급여를 조회
-- 부서코드 오름차순 정렬, TRUNCATE(, -3) 로 처리
select DEPT_CODE,
	COUNT(*) "총 인원",
	SUM(SALARY) "급여 합계", 
	TRUNCATE(AVG(SALARY), -3) "급여 평균",
	MAX(SALARY) "최대 급여",
	MIN(SALARY) "최소 급여"
from employee
group by DEPT_CODE 
order by 1;

-- HAVING -- / GROUP BY가 있어야 사용 가능
-- GROUP BY 한 소그룹에 대한 조건을 설정

-- 부서별 급여 평균이 300만원 상인 부서만 조회
select DEPT_CODE, AVG(SALARY) 평균 from EMPLOYEE where SALARY >= 3000000 group by DEPT_CODE;
-- 위 SELECT 문은 급여가 300만원 이상 인 사람들 중에서 급여를 평균내 DEPT_CODE 정렬한 것
-- (급여가 300만원 이하인 사람들은 걸러지고 평균을 내는 과정이 실행됨)

select DEPT_CODE, TRUNCATE(AVG(SALARY), -4) 평균
from EMPLOYEE
group by DEPT_CODE
having AVG(SALARY) >= 3000000
order by 1;
-- 위 SELECT 문은 각 부서별 급여 평균 값이 300만원 이상안 부서를 조회, 정렬한 것
-- (급여가 300만원 이하인 사람들 포함하여 평균을 내는 과정)

-- 실습 [3]
-- 부서별 그룹의 급여 합계 중 900만원 초과하는 부서의 부서코드와 급여 합게 조회
select DEPT_CODE "부서코드", SUM(SALARY) "급여 합계"
from employee
group by DEPT_CODE 
having SUM(SALARY) >= 9000000
order by 1;

select DEPT_CODE, JOB_CODE, SUM(SALARY)
from employee
group by DEPT_CODE, JOB_CODE;

-- 실습 [4]
-- EMPLOYEE 테이블에서 직급 별 그룹을 편성하여
-- 직급코드, 급여 합계, 급여 평균, 인원 수를 조회
-- 단, 인원수는 3명을 초과하는 직급만을 조회
-- 조회 결과는 인원수 내림차순하여 조회
select JOB_CODE 직급코드, SUM(SALARY) "급여 합계", 
	TRUNCATE(AVG(SALARY), -4) "급여 평균",
	COUNT(*) "인원 수"
from EMPLOYEE
group by JOB_CODE
having COUNT(*) > 3
order by 4 DESC;

-- SET OPERATION --
-- 합집합 --
-- UNION : 
-- 두 개 이상의 SELECT 한 결과(RESULTSET)를 구하는 명령어
-- 중복이 있을 경우 중복되는 결과는 1번만 보여줌
-- UNION ALL:
-- 두 개 이상의 SELECT 한 결과(RESULTSET)를 구하는 명렁어
-- 중복이 있을 경우 중복되는 내용 그대로 조회

-- union 
select EMP_ID, EMP_NAME, DEPT_CODE, SALARY
from EMPLOYEE
where DEPT_CODE = 'D5'
union 
select EMP_ID, EMP_NAME, DEPT_CODE, SALARY
from EMPLOYEE
where SALARY > 3000000;

-- UNION ALL
select EMP_ID, EMP_NAME, DEPT_CODE, SALARY
from EMPLOYEE
where DEPT_CODE = 'D5'
union ALL
select EMP_ID, EMP_NAME, DEPT_CODE, SALARY
from EMPLOYEE
where SALARY > 3000000;

-- JOIN --
-- 두 개 이상의 테이블을 하나로 합쳐 사용하는 명령 구문

-- 만약에 'J6'라는 직급을 가진 사원들의 근무 부서명이 궁금하다.
select EMP_NAME, JOB_CODE, DEPT_CODE
from EMPLOYEE
where JOB_CODE = 'J6';

select * from DEPARTMENT;
select * from EMPLOYEE;

select EMP_NAME, JOB_CODE, DEPT_CODE, DEPT_TITLE
from EMPLOYEE 
join DEPARTMENT ON(DEPT_CODE = DEPT_ID);
-- ON 조건에 두 테이블 간에 겹치는 데이터를 비교해야 오류가 나지 않음

select * from EMPLOYEE;
select * from JOB;

select EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
from EMPLOYEE
-- join JOB ON(EMPLYOEE.JOB_CODE = JOB.JOB_CODE);
join JOB USING(JOB_CODE);
-- USING : 컬럼 명이 같을 때 사용

-- 실습 [5]
-- EMPLOYEE 테이블의 직원 급여 정보와
-- SAL_GRADE의 급여 등급을 합쳐서
-- 사번, 사원명, 급여등급, 등급 기준 최소급여, 등급 기준 최대급여를 조회
select * from EMPLOYEE;
select * from SAL_GRADE;

select EMP_ID '사번', EMP_NAME '사원명', SAL_LEVEL '급여등급', 
	MIN_SAL '등급 기준 최소급여', MAX_SAL '등급 기준 최대급여'
from EMPLOYEE
join SAL_GRADE using(SAL_LEVEL);

-- INNER JOIN -- : 조건에 만족하는 데이터만 선택.
-- OUTER JOIN --
-- LEFT OUTER JOIN : 첫번째 테이블 기준으로 두번째 테이블을 JOIN. 
-- 					(조건에 만족하지 않는 경우 첫번째 테이블의 값은 유지)
-- RIGHT OUTER JOIN : LEFT의 반대. 두번째 테이블이 기준임

-- INNER JOIN -> INNER는 생략 가능
-- 표준 SQL 방식
select DEPT_CODE, DEPT_TITLE
from employee
join DEPARTMENT ON(DEPT_CODE = DEPT_ID)
order by 1;

-- MYSQL 방식
select DEPT_CODE, DEPT_TITLE
from employee , department 
where DEPT_CODE = DEPT_ID;

select E.DEPT_CODE, D.DEPT_TITLE
from employee E, department D
where E.DEPT_CODE = D.DEPT_ID
order by 1;

-- LEFT JOIN
-- 첫번째 테이블을 기준으로 두번째 테이블을 조합.
select EMP_NAME, DEPT_CODE, DEPT_TITLE
from employee
left outer join DEPARTMENT on(DEPT_CODE = DEPT_ID);

-- RIGHT JOIN
-- 두번째 테이블 기준으로 테이블 조합
select EMP_ID, EMP_NAME, DEPT_CODE, DEPT_ID
from EMPLOYEE
right join DEPARTMENT ON(DEPT_CODE = DEPT_ID)
order by 4;

-- -----------------------------
select EMP_NAME, DEPT_CODE, SALARY, E.SAL_LEVEL
from EMPLOYEE E
join SAL_GRADE S ON(SALARY between MIN_SAL and MAX_SAL);

-- SELF JOIN
-- 자기 자신을 JOIN하는 방법

-- 직원의 정보와 직원을 관리하는 매너저의 정보를 조회
select EMP_ID, EMP_NAME, MANAGER_ID from EMPLOYEE;

select E.EMP_ID '사번', E.EMP_NAME '사원명', E.MANAGER_ID "관리자 사번", M.EMP_NAME '관리자명'
from EMPLOYEE E
join EMPLOYEE M on(E.MANAGER_ID = M.EMP_ID);

-- 다중 JOIN --
-- 여러 개의 테이블을 JOIN하는 것.
select EMP_NAME, DEPT_TITLE, LOCAL_NAME
from EMPLOYEE
join DEPARTMENT on (DEPT_CODE = DEPT_ID)
join LOCATION on (LOCATION_ID = LOCAL_CODE);

-- 실습 [6]
-- 직급이 대리이면서, 아시아 지역에서 근무하는 사원 조회
-- 사번, 사원명, 직급명, 부서명, 근무지역명, 급여
select * from employee;
select * from JOB;
select * from DEPARTMENT;
select * from LOCATION;

-- 1번 방법
select EMP_ID '사번', EMP_NAME '사원명', 
	JOB_NAME '직급명', DEPT_TITLE '부서명',
	LOCAL_NAME '근무지역명', SALARY '급여'
from EMPLOYEE
join JOB USING(JOB_CODE)
join department ON(DEPT_CODE = DEPT_ID)
join LOCATION on (LOCATION_ID = LOCAL_CODE)
where JOB_NAME = '대리' and LOCAL_NAME like 'ASIA%';

-- 2번 방법
select EMP_ID '사번', EMP_NAME '사원명', 
	JOB_NAME '직급명', DEPT_TITLE '부서명',
	LOCAL_NAME '근무지역명', SALARY '급여'
from EMPLOYEE E
join JOB J ON(E.JOB_CODE = J.JOB_CODE and JOB_NAME = '대리')
join department ON(DEPT_CODE = DEPT_ID)
join LOCATION on (LOCATION_ID = LOCAL_CODE and LOCAL_NAME LIKE 'ASIA%');

-- 실습 [7]
-- 한국(KO)과 일본(JP)에 근무하는 근무 직원들의 정보를 조회하시오.
-- 이때, 사원명, 부서명, 지역명, 국가명 조회
select * from employee;
select * from JOB;
select * from DEPARTMENT;
select * from LOCATION;
select * from national;

-- 1번 방법
select EMP_NAME '사원명', DEPT_TITLE '부서명',
	LOCAL_NAME '지역명', NATIONAL_NAME '국가명'
from employee
join DEPARTMENT on (DEPT_CODE = DEPT_ID)
join LOCATION on (LOCATION_ID = LOCAL_CODE)
join national USING(NATIONAL_CODE)
where NATIONAL_NAME in('한국', '일본');
-- WHERE NATIONAL_CODE IN('KO', 'JP');

-- 2번 방법
select EMP_NAME '사원명', DEPT_TITLE '부서명',
	LOCAL_NAME '지역명', NATIONAL_NAME '국가명'
from employee 
join DEPARTMENT on (DEPT_CODE = DEPT_ID)
join LOCATION L on (LOCATION_ID = LOCAL_CODE)
join national N on (L.NATIONAL_CODE = N.NATIONAL_CODE and NATIONAL_NAME in('한국', '일본'));

-- -----------------------
-- SUB QUERY --
-- 메인 쿼리 안에 
-- 조건이나 검색을 위한 또 하나의 쿼리를 추가하는 기법
-- SELECT 안에 SELECT가 들어가는 뜻

-- -----------------------
-- 단일 행 서브쿼리
-- 결과 값이 1개 나오는 서브쿼리

-- 최소 급여를 받는 사원 정보 조회
select MIN(SALARY) from EMPLOYEE;
-- 1380000
select * from employee
where SALARY = 1380000;
-- 사원 정보 조회

-- 이 두 단계를 합치게 되면
select * from employee
where SALARY = (select MIN(SALARY) from EMPLOYEE);
-- -----------------------

-- 다중 행 서브쿼리
-- 결과 값이 여러 줄 나오는 서브쿼리

-- 각 직급별 최소 급여를 받는 사원 정보
select MIN(SALARY) from EMPLOYEE
group by JOB_CODE;

select * 
from EMPLOYEE
where SALARY in (select MIN(SALARY)
				from EMPLOYEE
				group by JOB_CODE);

-- 다중행 다중열 서브쿼리
-- 여러 컬럼, 여러 줄의 결과를 가져오는 서브쿼리를 사용
-- 다중행 다중열	
select JOB_CODE, MIN(SALARY)
from EMPLOYEE
group by JOB_CODE;
			
select *
from EMPLOYEE
where (JOB_CODE, SALARY) in (select JOB_CODE, 
							MIN(SALARY)
							from EMPLOYEE
							group by JOB_CODE);
select * from EMPLOYEE;
select * from JOB;
select * from SAL_GRADE;

-- 다중행 다중열 서브쿼리 활용 코드를
-- 단일행 서브쿼리를 활용한 내용으로 변경

-- 퇴사한 여직원과 같은 직급, 같은 부서에 근무하는 직원 정보 조회
-- 퇴사한 여직원의 정보
select * from EMPLOYEE where ENT_YN = 'Y';

-- 단일행 서브쿼리 활용
select * from EMPLOYEE
where DEPT_CODE = (select DEPT_CODE from EMPLOYEE where ENT_YN = 'Y')
and JOB_CODE = (select JOB_CODE from EMPLOYEE where ENT_YN = 'Y')
and EMP_ID <> (select EMP_ID from EMPLOYEE where ENT_YN = 'Y');

-- 다중열
select * from EMPLOYEE 
where (DEPT_CODE, JOB_CODE) = (select DEPT_CODE, JOB_CODE from EMPLOYEE where ENT_YN = 'Y')
and EMP_NAME <> (select EMP_NAME from EMPLOYEE where ENT_YN = 'Y');

-- FROM 위치에 사용되는 서브쿼리
-- InLine View(인라인 뷰)
-- 테이블을 테이블명으로 직접 조회하는 대신
-- 서브쿼리의 resultSet을 활용하여 데이터 조회

-- 일반적인 SELECT 문 뒤에 테이블명
select * from EMPLOYEE;

-- InLine View(인라인 뷰)를 활용해 SELECT문을 넣어 사용
select * 
from (
	select EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
	from employee
	join DEPARTMENT on (DEPT_CODE = DEPT_ID)
	join JOB using(JOB_CODE)
	) T;
-- 별칭을 사용하여 하나의 가상 테이블인 것처럼 해주어야 사용 가능하다.
-- 실제로 데이터베이스 안에 테이블이 생성이 된것이 아닌 가상의 테이블이다.
-- 테이블 처럼 보이게 끔 결과창에 나온것 뿐이다.

select EMP_NAME, SALARY,
	RANK() OVER(order by SALARY DESC) 순위
from EMPLOYEE;

select * 
from (select EMP_NAME, SALARY,
	RANK() OVER(order by SALARY DESC) 순위 
	from EMPLOYEE) T
where 순위 <= 10;