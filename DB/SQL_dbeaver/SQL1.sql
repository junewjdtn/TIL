-- 사원의 부서
select * from DEPARTMENT;
select * from LOCATION;
select * from EMPLOYEE;

desc EMPLOYEE;

-- 사원의 부서가 몇개인지 확인
select COUNT(*) from DEPARTMENT;

-- 사원의 몇명인지 확인

select COUNT(*) from EMPLOYEE;

-- 사원의 월급
select * from SAL_GRADE;

-- 사원 정보
select * from EMPLOYEE;

-- 문제 [1]
-- 월급이 250만원 보다 많이 받는 사원의 모든 정보를 출력하자, 몇명인지 세어보자.
select * from EMPLOYEE where SALARY>2500000;
select COUNT(*) from EMPLOYEE where SALARY>2500000;

-- 문제 [2]
-- EMPLOYEE 테이블에서 입사한 날짜가 '2000-01-01' 이후 인 사원들의 이름, 주민번호, 입사일을 조회
-- HINT : 날짜데이터 비교 연산 가능
select EMP_NAME, EMP_NO, HIRE_DATE from EMPLOYEE where HIRE_DATE > "20000101";

-- 부서 코드(DEPT_CODE)가 'D6'인 사원 정보 모두 조회하기
select * from employee WHERE DEPT_CODE = "D6";

-- 직급(JOB_CODE)이 'J1'인 사원의 사번(EMP_ID), 사원명(EMP_NAME), 직급코드(JOB_CODE), 부서코드(DEPT_CODE)를 조회하시오.
select EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE from EMPLOYEE where JOB_CODE = 'J1';

-- 조건이 2개 이상 붙었을 경우 (AND | OR)
-- 부서코드가 'D6' 이면서, 이름이 '유재식'인
-- 사원의 모든 정보 조회하기
select * from EMPLOYEE where DEPT_CODE ="D6" and EMP_NAME = "유재식";
