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

-- ���� [1] EMPLOYEE ���̺��� ��� ��ȣ�� 200~209 �� �޿��� 300���� �̻��� ������ ���, �����,  ����, ��ȭ��ȣ, ���޸�, �޿�, ���ʽ��� ��ȸ �Ͻÿ�.
select EMP_ID, EMP_NAME, EMAIL, PHONE, JOB_NAME, SALARY, BONUS 
from EMPLOYEE 
join JOB USING(JOB_CODE)
where EMP_ID like '20%' and SALARY >= 3000000;


-- ���� [3] EMPLOYEE ���̺��� �μ� ��, ������, �� �μ� �� ��� �� ��, �� �μ� �� ��� ������ ��ȸ�Ѵ�.
--  �μ��� ���� ����� ���� ��Ÿ���ÿ�.
-- 	��� ������ �����ڸ��� �ݿø��Ͻÿ�.
-- 	��� ������ ������������ �����Ͻÿ�.

select DEPT_TITLE, LOCAL_NAME, COUNT(*), ROUND(AVG(SALARY),-2)
from EMPLOYEE
LEFT join DEPARTMENT ON(DEPT_CODE = DEPT_ID)
LEFT join LOCATION ON(LOCATION_ID = LOCAL_CODE)
group by DEPT_TITLE
order by AVG(SALARY);

select * from EMPLOYEE order by DEPT_CODE;

-- ���� [2] EMPLOYEE ���̺��� 90��� �Ի��� ����� �� �޿� ����� S5�� �����
-- ���, �����, �ֹε�Ϲ�ȣ, ��ȭ��ȣ, �޿������ ��ȸ�Ͻÿ�
-- ��ȸ�� ������ ��Ī ����Ͽ� ��Ÿ���ÿ�.
select EMP_ID '���', EMP_NAME '�����', EMP_NO '�ֹε�Ϲ�ȣ', PHONE '��ȭ��ȣ', SAL_LEVEL '�޿����' 
from EMPLOYEE 
where HIRE_DATE like '199%' 
order by HIRE_DATE;


-- ���� [4] EMPLOYEE ���̺�κ��� ������� '���ö' ������� �޿��� �� ���� �޴� ����� ���, �����, �޿��� ����Ͻÿ�.
select EMP_ID, EMP_NAME, SALARY 
from employee 
where SALARY > (select SALARY from EMPLOYEE where EMP_NAME='���ö');

select * from employee;

-- ���� [5] EMPLOYEE ���̺��� �����, �Ի���, ��ü �ٹ��ϼ��� ��ȸ�Ͻÿ�
-- �Ի��ϰ� �ָ� �����Ͽ� ��ȸ
select 	EMP_NAME "�����", 
		HIRE_DATE "�Ի���", 
 		DATEDIFF(now(), HIRE_DATE) + 1 "��ü �ٹ��ϼ�"
from EMPLOYEE;

select * from location ;
select * from EMPLOYEE;
select * from department;
select * from JOB;

-- ���� [6] EMPLOYEE ���̺��� �������� 'ASIA1'�� ����� �� �޿��ݾ�, ��ձݾ�, �ο����� ��ȸ�Ͻÿ�
select SUM(SALARY), ROUND(AVG(SALARY),-3), COUNT(*) from employee
join department ON (DEPT_CODE=DEPT_ID)
join LOCATION on(LOCATION_ID=LOCAL_CODE)
where LOCAL_NAME='ASIA1';

-- ���� [7] EMPLOYEE ���̺��� �������� 'EU'�� �����
-- �����ȣ, �����, �ֹι�ȣ, ��ȭ��ȣ�� ��Ī�� ����Ͽ� ��ȸ�Ͻÿ�.
select EMP_ID "�����ȣ", EMP_NAME "�����", RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') "�ֹι�ȣ",
REPLACE(PHONE, SUBSTR(PHONE, 4, 4), '****') "��ȭ��ȣ"
from EMPLOYEE
join DEPARTMENT on(DEPT_CODE=DEPT_ID)
join LOCATION ON(LOCATION_ID = LOCAL_CODE)
where LOCAL_NAME='EU';

-- ���� [8] �����ڰ� ���� ��� ����� �����, �޿�, �Ի���, ���޸��� ��ȸ�Ͻÿ�.
select EMP_NAME, SALARY, HIRE_DATE, job_NAME
from employee
join JOB USING(JOB_CODE)
where DEPT_CODE is null;