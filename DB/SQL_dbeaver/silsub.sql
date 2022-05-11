drop TABLE BOARD;

CREATE TABLE BOARD(
	no INT PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	writer VARCHAR(100) NOT NULL,
	content VARCHAR(500) NOT NULL,
	regdate DATE NOT NULL
);

select * from BOARD;

desc BOARD;

select * from department;
select * from EMPLOYEE;
select * from JOB;
select * from LOCATION;
select * from national;
select * from sal_grade;

-- 문제 [1] EMPLOYEE 테이블에서 사번 번호가 200~209 중 급여가 300만원 이상인 직원의 사번, 사원명,  메일, 전화번호, 직급명, 급여, 보너스를 조회 하시오.
select EMP_ID, EMP_NAME, EMAIL, PHONE, JOB_NAME, SALARY, BONUS 
from EMPLOYEE 
join JOB USING(JOB_CODE)
where EMP_ID like '20%' and SALARY >= 3000000;


-- 문제 [3] EMPLOYEE 테이블에서 부서 명, 지역명, 각 부서 별 사원 총 수, 각 부서 별 평균 연봉을 조회한다.
--  부서가 없는 사람들 또한 나타내시오.
-- 	평균 연봉은 십의자리로 반올림하시오.
-- 	평균 연봉의 오름차순으로 정리하시오.

select DEPT_TITLE, LOCAL_NAME, COUNT(*), ROUND(AVG(SALARY),-2)
from EMPLOYEE
LEFT join DEPARTMENT ON(DEPT_CODE = DEPT_ID)
LEFT join LOCATION ON(LOCATION_ID = LOCAL_CODE)
group by DEPT_TITLE
order by AVG(SALARY);

select * from EMPLOYEE order by DEPT_CODE;

-- 문제 [2] EMPLOYEE 테이블에서 90년대 입사한 사람들 중 급여 등급이 S5인 사원의
-- 사번, 사원명, 주민등록번호, 전화번호, 급여등급을 조회하시오
-- 조회할 내용을 별칭 사용하여 나타내시오.
select EMP_ID '사번', EMP_NAME '사원명', EMP_NO '주민등록번호', PHONE '전화번호', SAL_LEVEL '급여등급' 
from EMPLOYEE 
where HIRE_DATE like '199%' 
order by HIRE_DATE;


-- 문제 [4] EMPLOYEE 테이블로부터 사원명이 '노옹철' 사원보다 급여를 더 많이 받는 사원의 사번, 사원명, 급여를 출력하시오.
select EMP_ID, EMP_NAME, SALARY 
from employee 
where SALARY > (select SALARY from EMPLOYEE where EMP_NAME='노옹철');

select * from employee;

-- 문제 [5] EMPLOYEE 테이블에서 사원명, 입사일, 전체 근무일수를 조회하시오
-- 입사일과 주말 포함하여 조회
select 	EMP_NAME "사원명", 
		HIRE_DATE "입사일", 
 		DATEDIFF(now(), HIRE_DATE) + 1 "전체 근무일수"
from EMPLOYEE;

select * from location ;
select * from EMPLOYEE;
select * from department;
select * from JOB;

-- 문제 [6] EMPLOYEE 테이블에서 지역명이 'ASIA1'인 사원의 총 급여금액, 평균금액, 인원수를 조회하시오
select SUM(SALARY), ROUND(AVG(SALARY),-3), COUNT(*) from employee
join department ON (DEPT_CODE=DEPT_ID)
join LOCATION on(LOCATION_ID=LOCAL_CODE)
where LOCAL_NAME='ASIA1';

-- 문제 [7] EMPLOYEE 테이블에서 지역명이 'EU'인 사원의
-- 사원번호, 사원명, 주민번호, 전화번호를 별칭을 사용하여 조회하시오.
select EMP_ID "사원번호", EMP_NAME "사원명", RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') "주민번호",
REPLACE(PHONE, SUBSTR(PHONE, 4, 4), '****') "전화번호"
from EMPLOYEE
join DEPARTMENT on(DEPT_CODE=DEPT_ID)
join LOCATION ON(LOCATION_ID = LOCAL_CODE)
where LOCAL_NAME='EU';

-- 문제 [8] 관리자가 없는 모든 사원의 사원명, 급여, 입사일, 직급명을 조회하시오.
select EMP_NAME, SALARY, HIRE_DATE, job_NAME
from employee
join JOB USING(JOB_CODE)
where DEPT_CODE is null;