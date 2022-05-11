-- IN(��1, ��2, ��3, ...) -> WHERE ��1 OR ��2 OR ��3 OR ...
select EMP_ID, EMP_NAME, DEPT_CODE
from EMPLOYEE where DEPT_CODE in ('D1', 'D5');

-- NOT IN(��1, ��2, ��3, ...) / NULL ���� �������� ����
select EMP_ID, EMP_NAME, DEPT_CODE
from EMPLOYEE where DEPT_CODE not in ('D1', 'D5');

-- ABS(��) : Ư�� ������ ���밪 ǥ��.
select ABS(-10), ABS(10);

-- MOD(��1, ��2) : �־��� �÷��̳� ���� ���� �������� ��ȯ
-- ��1 / ��2 �� �Ͽ� �������� ������
select MOD(10, 3), mod(3, 10);

-- ROUND(��1, ����) : ������ �ڸ��� ���� �ݿø�.
select ROUND(123.456, 0), 
	   ROUND(123.456, 1), 
	   ROUND(123.456, 2),
	   ROUND(123.456, -2),
	   ROUND(123.456, -1);

-- CEIL : �Ҽ��� ù° �ڸ����� �ø�
-- FLOOR : �Ҽ��� ���� �ڸ��� ��� ����
select CEIL(123.456), FLOOR(123.456);

-- TRUNCATE() : ������ ��ġ���� ���ڸ� ������ �Լ�
select TRUNCATE(123.456, 0), 
	   TRUNCATE(123.456, 1),
	   TRUNCATE(123.456, 2),
	   TRUNCATE(123.456, -2);
	  
-- CEILING(����) : �Ҽ��� �ݿø� (�Է��� ������ ū ������ ��Ÿ���� �Լ�)
select CEILING(4.0),
	   ceiling(4.1),
	   ceiling(4.2),
	   ceiling(3.9),
	   ceiling(3.1),
	   ceiling(3.8);	 
	  
select CEILING(-4.0),
	   ceiling(-4.1),
	   ceiling(-3.9);

-- �ǽ� [1]
-- EMPLOYEE ���̺��� �Ի��� ���� ���ڰ� Ȧ�� ���� ������
-- ���, �����, �Ի��� ������ ��ȸ
select EMP_ID "���", EMP_NAME "�����", HIRE_DATE "�Ի���"
from EMPLOYEE where mod(SUBSTR(HIRE_DATE, 7, 1), 2) = 1;

-- DATE_ADD(��¥��, INTERVAL) : Ư�� ��¥ ���� (��¥ ���� INTERVAL �� ���� ��ŭ ��¥�� �˷���)
-- DATE_SUB(��¥��, INTERVAL) : Ư�� ��¥ ���� (��¥ ���� INTERVAL �� ���� ��ŭ ��¥�� �˷���)

select EMP_NAME, HIRE_DATE,
	DATE_ADD(HIRE_DATE, interval 1 DAY)
from EMPLOYEE;

select EMP_NAME, HIRE_DATE,
	DATE_SUB(HIRE_DATE, interval 1 DAY)
from EMPLOYEE;

-- DAYOFWEEK(��¥��) : ��¥ ���� ���� ���� �������� �˷��ִ� �Լ�
-- 1 = �Ͽ���, 2 = ������, 3 = ȭ����, 4 = ������, 5 = �����, 6 = �ݿ���, 7 = �����
select DAYOFWEEK(NOW());

select EMP_NAME,
	case 
		when DAYOFWEEK(HIRE_DATE) = 1 then '�Ͽ���'
		when DAYOFWEEK(HIRE_DATE) = 2 then '������'
		when DAYOFWEEK(HIRE_DATE) = 3 then 'ȭ����'
		when DAYOFWEEK(HIRE_DATE) = 4 then '������'
		when DAYOFWEEK(HIRE_DATE) = 5 then '�����'
		when DAYOFWEEK(HIRE_DATE) = 6 then '�ݿ���'
		when DAYOFWEEK(HIRE_DATE) = 7 then '�����'
	end '����'
from EMPLOYEE;

-- LAST_DAY(��¥ ��) : ��¥�� ������ ���ڸ� ��ȸ
select LAST_DAY(NOW());

-- �ǽ� [2]
-- EMPLOYEE ���̺��� �ٹ������ 20�� �̻��� �������
-- ���, �����, �μ��ڵ�, �Ի��� ��ȸ
select EMP_ID "���", EMP_NAME "�����", DEPT_CODE "�μ��ڵ�", HIRE_DATE "�Ի���" 
from EMPLOYEE where DATE_ADD(HIRE_DATE, interval 20 YEAR) <= NOW();

-- ����ȯ �Լ� --
-- STR_TO_STR, DATE_FORMAT
-- CAST(�� AS ����), CONVERT(��, ����) : �־��� ���� ���ϴ� �������� ����.

select cast(20220429 as DATE), convert(20220429, DATE);
select CAST(20220101030330 as CHAR), convert(20220101030330, CHAR);
select CAST(NOW() as CHAR), convert(NOW(), CHAR);

-- �� Ÿ��
-- BINARY 	: ���� ������
-- CHAR		: ����
-- DATE		: ��¥
-- INTEGER	: ����(���, ����) / UNSIGEND INTEGER : ����� | SIGEND INTEGER : ������
-- DECIMAL	: �Ҽ�������
-- JOSN		: JSONŸ�� ������

select '123' + '456';
select CONCAT('123', '456');
select '123' + '456ABC';
select '123' + '4A56BC';

-- SELECT�� ���� ����--
/* 
 * �� ��ȣ�� ���� ����
 * 5: SELECT �÷�, ����, �Լ��� AS ��Ī, ...
 * 1: FROM ���̺��
 * 2: WHERE ����
 * 3: GROUP BY �׷��� ���� �÷�
 * 4: HAVING �׷쿡 ���� ���ǽ�
 * 6: ORDER BY �÷� | ��Ī | ����
 * 
 */

-- ORDER BY
-- SELECT ���� ��ȸ�� ���� ������� Ư�� ���ؿ� ���� ����

select EMP_ID, EMP_NAME "�̸�", SALARY, DEPT_CODE
from employee
-- ORDER by EMP_ID; -- ������ �⺻���� ASC
-- order by EMP_NAME ASC;
-- ������ �÷����� ������������ ���� ��
-- order by DEPT_CODE desc, EMP_NAME;  -- desc : ��������
-- ������ �÷����� ������������ ���� ��
-- order by �̸� DESC;
order by 3 desc; -- ���ڸ� ����Ͽ� select ���� �÷��� 3��° �÷��� ������ �����ض�� �ǹ�

-- GROUP BY --
-- �μ��� ���
-- ��ü
select TRUNCATE(AVG(SALARY), -4) from EMPLOYEE;

-- D1 ��� �޿�
select TRUNCATE(AVG(SALARY), -4), DEPT_CODE from EMPLOYEE
where DEPT_CODE = 'D1';

-- Ư�� �÷��� �ϳ��� �׷����� ���� �� ���̺� ������ 
-- ��ȸ�ϰ��� �Ҷ� �����ϴ� ����.

select DEPT_CODE, TRUNCATE(AVG(SALARY), -4) from employee
group by DEPT_CODE
order by 1;

-- EMPLOYEE ���̺��� �μ��� �� �ο�, �޿� �հ�, �޿� ���, �ִ� �޿�, �ּ� �޿��� ��ȸ
-- �μ��ڵ� �������� ����, TRUNCATE(, -3) �� ó��
select DEPT_CODE,
	COUNT(*) "�� �ο�",
	SUM(SALARY) "�޿� �հ�", 
	TRUNCATE(AVG(SALARY), -3) "�޿� ���",
	MAX(SALARY) "�ִ� �޿�",
	MIN(SALARY) "�ּ� �޿�"
from employee
group by DEPT_CODE 
order by 1;

-- HAVING -- / GROUP BY�� �־�� ��� ����
-- GROUP BY �� �ұ׷쿡 ���� ������ ����

-- �μ��� �޿� ����� 300���� ���� �μ��� ��ȸ
select DEPT_CODE, AVG(SALARY) ��� from EMPLOYEE where SALARY >= 3000000 group by DEPT_CODE;
-- �� SELECT ���� �޿��� 300���� �̻� �� ����� �߿��� �޿��� ��ճ� DEPT_CODE ������ ��
-- (�޿��� 300���� ������ ������� �ɷ����� ����� ���� ������ �����)

select DEPT_CODE, TRUNCATE(AVG(SALARY), -4) ���
from EMPLOYEE
group by DEPT_CODE
having AVG(SALARY) >= 3000000
order by 1;
-- �� SELECT ���� �� �μ��� �޿� ��� ���� 300���� �̻�� �μ��� ��ȸ, ������ ��
-- (�޿��� 300���� ������ ����� �����Ͽ� ����� ���� ����)

-- �ǽ� [3]
-- �μ��� �׷��� �޿� �հ� �� 900���� �ʰ��ϴ� �μ��� �μ��ڵ�� �޿� �հ� ��ȸ
select DEPT_CODE "�μ��ڵ�", SUM(SALARY) "�޿� �հ�"
from employee
group by DEPT_CODE 
having SUM(SALARY) >= 9000000
order by 1;

select DEPT_CODE, JOB_CODE, SUM(SALARY)
from employee
group by DEPT_CODE, JOB_CODE;

-- �ǽ� [4]
-- EMPLOYEE ���̺��� ���� �� �׷��� ���Ͽ�
-- �����ڵ�, �޿� �հ�, �޿� ���, �ο� ���� ��ȸ
-- ��, �ο����� 3���� �ʰ��ϴ� ���޸��� ��ȸ
-- ��ȸ ����� �ο��� ���������Ͽ� ��ȸ
select JOB_CODE �����ڵ�, SUM(SALARY) "�޿� �հ�", 
	TRUNCATE(AVG(SALARY), -4) "�޿� ���",
	COUNT(*) "�ο� ��"
from EMPLOYEE
group by JOB_CODE
having COUNT(*) > 3
order by 4 DESC;

-- SET OPERATION --
-- ������ --
-- UNION : 
-- �� �� �̻��� SELECT �� ���(RESULTSET)�� ���ϴ� ��ɾ�
-- �ߺ��� ���� ��� �ߺ��Ǵ� ����� 1���� ������
-- UNION ALL:
-- �� �� �̻��� SELECT �� ���(RESULTSET)�� ���ϴ� ����
-- �ߺ��� ���� ��� �ߺ��Ǵ� ���� �״�� ��ȸ

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
-- �� �� �̻��� ���̺��� �ϳ��� ���� ����ϴ� ��� ����

-- ���࿡ 'J6'��� ������ ���� ������� �ٹ� �μ����� �ñ��ϴ�.
select EMP_NAME, JOB_CODE, DEPT_CODE
from EMPLOYEE
where JOB_CODE = 'J6';

select * from DEPARTMENT;
select * from EMPLOYEE;

select EMP_NAME, JOB_CODE, DEPT_CODE, DEPT_TITLE
from EMPLOYEE 
join DEPARTMENT ON(DEPT_CODE = DEPT_ID);
-- ON ���ǿ� �� ���̺� ���� ��ġ�� �����͸� ���ؾ� ������ ���� ����

select * from EMPLOYEE;
select * from JOB;

select EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
from EMPLOYEE
-- join JOB ON(EMPLYOEE.JOB_CODE = JOB.JOB_CODE);
join JOB USING(JOB_CODE);
-- USING : �÷� ���� ���� �� ���

-- �ǽ� [5]
-- EMPLOYEE ���̺��� ���� �޿� ������
-- SAL_GRADE�� �޿� ����� ���ļ�
-- ���, �����, �޿����, ��� ���� �ּұ޿�, ��� ���� �ִ�޿��� ��ȸ
select * from EMPLOYEE;
select * from SAL_GRADE;

select EMP_ID '���', EMP_NAME '�����', SAL_LEVEL '�޿����', 
	MIN_SAL '��� ���� �ּұ޿�', MAX_SAL '��� ���� �ִ�޿�'
from EMPLOYEE
join SAL_GRADE using(SAL_LEVEL);

-- INNER JOIN -- : ���ǿ� �����ϴ� �����͸� ����.
-- OUTER JOIN --
-- LEFT OUTER JOIN : ù��° ���̺� �������� �ι�° ���̺��� JOIN. 
-- 					(���ǿ� �������� �ʴ� ��� ù��° ���̺��� ���� ����)
-- RIGHT OUTER JOIN : LEFT�� �ݴ�. �ι�° ���̺��� ������

-- INNER JOIN -> INNER�� ���� ����
-- ǥ�� SQL ���
select DEPT_CODE, DEPT_TITLE
from employee
join DEPARTMENT ON(DEPT_CODE = DEPT_ID)
order by 1;

-- MYSQL ���
select DEPT_CODE, DEPT_TITLE
from employee , department 
where DEPT_CODE = DEPT_ID;

select E.DEPT_CODE, D.DEPT_TITLE
from employee E, department D
where E.DEPT_CODE = D.DEPT_ID
order by 1;

-- LEFT JOIN
-- ù��° ���̺��� �������� �ι�° ���̺��� ����.
select EMP_NAME, DEPT_CODE, DEPT_TITLE
from employee
left outer join DEPARTMENT on(DEPT_CODE = DEPT_ID);

-- RIGHT JOIN
-- �ι�° ���̺� �������� ���̺� ����
select EMP_ID, EMP_NAME, DEPT_CODE, DEPT_ID
from EMPLOYEE
right join DEPARTMENT ON(DEPT_CODE = DEPT_ID)
order by 4;

-- -----------------------------
select EMP_NAME, DEPT_CODE, SALARY, E.SAL_LEVEL
from EMPLOYEE E
join SAL_GRADE S ON(SALARY between MIN_SAL and MAX_SAL);

-- SELF JOIN
-- �ڱ� �ڽ��� JOIN�ϴ� ���

-- ������ ������ ������ �����ϴ� �ų����� ������ ��ȸ
select EMP_ID, EMP_NAME, MANAGER_ID from EMPLOYEE;

select E.EMP_ID '���', E.EMP_NAME '�����', E.MANAGER_ID "������ ���", M.EMP_NAME '�����ڸ�'
from EMPLOYEE E
join EMPLOYEE M on(E.MANAGER_ID = M.EMP_ID);

-- ���� JOIN --
-- ���� ���� ���̺��� JOIN�ϴ� ��.
select EMP_NAME, DEPT_TITLE, LOCAL_NAME
from EMPLOYEE
join DEPARTMENT on (DEPT_CODE = DEPT_ID)
join LOCATION on (LOCATION_ID = LOCAL_CODE);

-- �ǽ� [6]
-- ������ �븮�̸鼭, �ƽþ� �������� �ٹ��ϴ� ��� ��ȸ
-- ���, �����, ���޸�, �μ���, �ٹ�������, �޿�
select * from employee;
select * from JOB;
select * from DEPARTMENT;
select * from LOCATION;

-- 1�� ���
select EMP_ID '���', EMP_NAME '�����', 
	JOB_NAME '���޸�', DEPT_TITLE '�μ���',
	LOCAL_NAME '�ٹ�������', SALARY '�޿�'
from EMPLOYEE
join JOB USING(JOB_CODE)
join department ON(DEPT_CODE = DEPT_ID)
join LOCATION on (LOCATION_ID = LOCAL_CODE)
where JOB_NAME = '�븮' and LOCAL_NAME like 'ASIA%';

-- 2�� ���
select EMP_ID '���', EMP_NAME '�����', 
	JOB_NAME '���޸�', DEPT_TITLE '�μ���',
	LOCAL_NAME '�ٹ�������', SALARY '�޿�'
from EMPLOYEE E
join JOB J ON(E.JOB_CODE = J.JOB_CODE and JOB_NAME = '�븮')
join department ON(DEPT_CODE = DEPT_ID)
join LOCATION on (LOCATION_ID = LOCAL_CODE and LOCAL_NAME LIKE 'ASIA%');

-- �ǽ� [7]
-- �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �ٹ� �������� ������ ��ȸ�Ͻÿ�.
-- �̶�, �����, �μ���, ������, ������ ��ȸ
select * from employee;
select * from JOB;
select * from DEPARTMENT;
select * from LOCATION;
select * from national;

-- 1�� ���
select EMP_NAME '�����', DEPT_TITLE '�μ���',
	LOCAL_NAME '������', NATIONAL_NAME '������'
from employee
join DEPARTMENT on (DEPT_CODE = DEPT_ID)
join LOCATION on (LOCATION_ID = LOCAL_CODE)
join national USING(NATIONAL_CODE)
where NATIONAL_NAME in('�ѱ�', '�Ϻ�');
-- WHERE NATIONAL_CODE IN('KO', 'JP');

-- 2�� ���
select EMP_NAME '�����', DEPT_TITLE '�μ���',
	LOCAL_NAME '������', NATIONAL_NAME '������'
from employee 
join DEPARTMENT on (DEPT_CODE = DEPT_ID)
join LOCATION L on (LOCATION_ID = LOCAL_CODE)
join national N on (L.NATIONAL_CODE = N.NATIONAL_CODE and NATIONAL_NAME in('�ѱ�', '�Ϻ�'));

-- -----------------------
-- SUB QUERY --
-- ���� ���� �ȿ� 
-- �����̳� �˻��� ���� �� �ϳ��� ������ �߰��ϴ� ���
-- SELECT �ȿ� SELECT�� ���� ��

-- -----------------------
-- ���� �� ��������
-- ��� ���� 1�� ������ ��������

-- �ּ� �޿��� �޴� ��� ���� ��ȸ
select MIN(SALARY) from EMPLOYEE;
-- 1380000
select * from employee
where SALARY = 1380000;
-- ��� ���� ��ȸ

-- �� �� �ܰ踦 ��ġ�� �Ǹ�
select * from employee
where SALARY = (select MIN(SALARY) from EMPLOYEE);
-- -----------------------

-- ���� �� ��������
-- ��� ���� ���� �� ������ ��������

-- �� ���޺� �ּ� �޿��� �޴� ��� ����
select MIN(SALARY) from EMPLOYEE
group by JOB_CODE;

select * 
from EMPLOYEE
where SALARY in (select MIN(SALARY)
				from EMPLOYEE
				group by JOB_CODE);

-- ������ ���߿� ��������
-- ���� �÷�, ���� ���� ����� �������� ���������� ���
-- ������ ���߿�	
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

-- ������ ���߿� �������� Ȱ�� �ڵ带
-- ������ ���������� Ȱ���� �������� ����

-- ����� �������� ���� ����, ���� �μ��� �ٹ��ϴ� ���� ���� ��ȸ
-- ����� �������� ����
select * from EMPLOYEE where ENT_YN = 'Y';

-- ������ �������� Ȱ��
select * from EMPLOYEE
where DEPT_CODE = (select DEPT_CODE from EMPLOYEE where ENT_YN = 'Y')
and JOB_CODE = (select JOB_CODE from EMPLOYEE where ENT_YN = 'Y')
and EMP_ID <> (select EMP_ID from EMPLOYEE where ENT_YN = 'Y');

-- ���߿�
select * from EMPLOYEE 
where (DEPT_CODE, JOB_CODE) = (select DEPT_CODE, JOB_CODE from EMPLOYEE where ENT_YN = 'Y')
and EMP_NAME <> (select EMP_NAME from EMPLOYEE where ENT_YN = 'Y');

-- FROM ��ġ�� ���Ǵ� ��������
-- InLine View(�ζ��� ��)
-- ���̺��� ���̺������ ���� ��ȸ�ϴ� ���
-- ���������� resultSet�� Ȱ���Ͽ� ������ ��ȸ

-- �Ϲ����� SELECT �� �ڿ� ���̺��
select * from EMPLOYEE;

-- InLine View(�ζ��� ��)�� Ȱ���� SELECT���� �־� ���
select * 
from (
	select EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
	from employee
	join DEPARTMENT on (DEPT_CODE = DEPT_ID)
	join JOB using(JOB_CODE)
	) T;
-- ��Ī�� ����Ͽ� �ϳ��� ���� ���̺��� ��ó�� ���־�� ��� �����ϴ�.
-- ������ �����ͺ��̽� �ȿ� ���̺��� ������ �Ȱ��� �ƴ� ������ ���̺��̴�.
-- ���̺� ó�� ���̰� �� ���â�� ���°� ���̴�.

select EMP_NAME, SALARY,
	RANK() OVER(order by SALARY DESC) ����
from EMPLOYEE;

select * 
from (select EMP_NAME, SALARY,
	RANK() OVER(order by SALARY DESC) ���� 
	from EMPLOYEE) T
where ���� <= 10;