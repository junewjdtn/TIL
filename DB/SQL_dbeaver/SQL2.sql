-- CRUD 	: ������ �⺻ ó�� ����
-- CREATE 	: ������ �߰� / INSERT
-- READ 	: ������ ��ȸ / SELECT
-- UPDATE 	: ������ ���� / UDPATE
-- DELETE	: ������ ���� / DELETE

-- SELECT : ��ȸ�� SQL
-- EX)
-- SELECT *(��ȸ �÷�)
-- FROM ���̺��
-- WHERE ����
-- ORDER BY �÷�
-- ;

-- ����� ���� �޴� ��(�ؿ� ����� ������ â)�� RESULT SET �̶� ��

-- 1. AS ǥ��
select EMP_ID as "�����ȣ", EMP_NAME as "�����" from EMPLOYEE;
-- AS "~" : ���� ���� ��Ī (RESULT SET�� �÷����� ""�ȿ� �������� �ٲٴ� ���)

-- 2. AS ����
select EMP_ID "�����ȣ" , EMP_NAME '�����' from EMPLOYEE;
-- AS�� ���� �����ϴ�
select EMP_ID �����ȣ, EMP_NAME ����� from EMPLOYEE;
-- "", '' ���� ���������� ���⳪ ()�� ���� �Ǹ� ������ ���� ������ �ظ��ϸ� '', ""�� ����ϴ°� ����.

select EMP_NAME "�����", (SALARY * 12) "����", BONUS "���ʽ�", 
	(SALARY + (SALARY * BONUS)) * 12 "��������"  from EMPLOYEE;
-- �÷����� �������� ������ ��Ī�� ����Ͽ� �����ϰ� �ľ� �����ϴ�

-- IFNULL() : ���� ���� ��ȸ�ϴ� ���� NULL�̸� ������ ������ ����
select EMP_NAME "�����", (SALARY * 12) "����", '��' ����, IFNULL(BONUS,0) "���ʽ�", 
	(SALARY + (SALARY * IFNULL(BONUS, 0))) * 12 "��������", '��' ���� from EMPLOYEE;

-- DISTINCT
-- �ߺ� ���� �ϰ� �� ���� ��ȸ
select EMP_NAME, DEPT_CODE from EMPLOYEE;

select distinct DEPT_CODE from EMPLOYEE;
-- DISTINCT�� �� ��� ���� (���� ���� �����̱⵵ �ϱ� ������ �ߺ����Ŵ� �ٸ� ������� ���� ���)

-- �ǽ� [1]
-- DEPARTMENT ���̺��� �����Ͽ�,
-- �μ��� '�ؿܿ���2��'�� �μ��� �μ��ڵ带 ã��,
-- EMPLOYEE ���̺��� �ش� �μ���
-- ����� �� �޿��� 200�������� ���� �޴� ������
-- ���, �����, �޿��� ��ȸ�Ͻÿ�.

-- HINT. 1) '�ؿܿ���2��' �μ��� �μ��ڵ� ��ȸ
-- HINT. 2) ���� ��ȸ

-- 1)
select * from DEPARTMENT;
select DEPT_TITLE from DEPARTMENT where DEPT_TITLE='�ؿܿ���2��';
-- => �ؿܿ���2�� D6 ã��

-- 2)
select * from EMPLOYEE;
select EMP_ID "���", EMP_NAME "�����", SALARY "�޿�" from EMPLOYEE 
where DEPT_CODE = 'D6' and SALARY > 2000000;

-- ������ --
-- �񱳿�����
-- <, >, <=, >= : ũ�⸦ ��Ÿ���� �ε�ȣ
-- =  			: ����
-- !=, <>		: ���� �ʴ�

-- EMPLOYEE ���̺��� �μ��ڵ尡 'D9'�� �ƴ� ��������
-- ��� ������ ��ȸ
select * from EMPLOYEE where DEPT_CODE != 'D9';
-- OR
select * from EMPLOYEE where DEPT_CODE <> 'D9';

-- �޿��� 350���� �̻�, 550���� ������ 
-- ������ ���, �����, �μ��ڵ�, �����ڵ�, �޿��� ��ȸ
-- [1]
select EMP_ID "���", EMP_NAME "�����", DEPT_CODE "�μ��ڵ�", SALARY "�޿�"
from EMPLOYEE where SALARY >= 3500000 and SALARY <= 5500000;

-- [2]
select EMP_ID "���", EMP_NAME "�����", DEPT_CODE "�μ��ڵ�", SALARY "�޿�" 
from EMPLOYEE where SALARY between 3500000 and 5500000;
-- BETWEEN A AND B -> A�� �̻� B�� ������ ���� ���� ���ϴ� ���

-- LIKE
-- �Է��� ����, ���ڰ� ���Ե� ������ ��ȸ�� �� ����ϴ� ������
-- '_' : ������ �� ���ڸ� ����Ŵ
-- '%'

-- ����� �̸��� ��� ���ڰ� '��'�� ��� ���� ��ȸ
select * from EMPLOYEE where EMP_NAME like '_��_';

-- �ֹε�Ϲ�ȣ ���� ������ ����� ������ ��ȸ
select * from EMPLOYEE where EMP_NO like '%-1%';

-- ��� �� �̸��� ���̵� 5���� �̻��� ����� �����, ���, �̸��� ��ȸ
select EMP_NAME "�����", EMP_ID "���", EMAIL "�̸���" from EMPLOYEE
where EMAIL like '_____%@%';

select * from EMPLOYEE where EMP_NAME like '��%';

-- ��� �� �̸��� 4��° ���ڰ� '_'�� ����� ���� ��ȸ
-- ESCAPE ���ڸ� ���� / �ڿ����� ���ڸ� Ư�����ڰ� �ƴ� �Ϲ� ���ڷ� �����Ͽ� ���
select * from EMPLOYEE where EMAIL like '___#_%@%' escape '#';

-- IN ������
-- IN(��1, ��2, ��3, ...)
-- ���� �ڵ尡 J1 �̰ų� J4�� ���� ���� ��ȸ
-- SELECT * FROM EMPLOYEE WHERE JOB_CODE = 'J1' OR JOB_CODE ='J4';
select * from EMPLOYEE WHERE JOB_CODE IN('J1', 'J4');

-- NOT IN ������
-- IN(��1, ��2, ��3, ...)�� �ƴ� ���� �������� ���
select  * from EMPLOYEE where JOB_CODE not IN('J1', 'J4');

-- �Լ�(FUNCTION) --
-- LENGTH : ���ڿ��� ���̸� ����ϴ� �Լ� / BYTE ���� (���� �ѱ��ڴ� : 1, �ѱ� �� ���ڴ� : 3)
select LENGTH('HELLO');
select LENGTH('������');

-- CHAR_LENGTH : ���� ��
select LENGTH('HELLO'), CHAR_LENGTH('HELLO');
select LENGTH('������'), CHAR_LENGTH('������');

-- INSTR() : �־��� ������ ���ϴ� ���ڰ� ���°���� ã�� ��ȯ�ϴ� �Լ�
select INSTR('ABCD', 'A'), INSTR('ABCD', 'C'), INSTR('ABCD', 'F');

select INSTR('ABCDEF', 'CD');

-- SUBSTR('�־��� ��', 'A', 'B') : '�־��� ��'���� 'A'���� 'B'������ �߶� �����´�. 
select 'HELLO WORLD', SUBSTR('HELLO WORLD', 1, 6);

-- SUBSTR('�־��� ��', 'A') : '�־��� ��'���� 'A'���� �߶� �����´�. 
select 'HELLO WORLD', SUBSTR('HELLO WORLD', 7);

-- �ǽ� [2]
-- EMPLOYEE ���̺��� ������� �̸�, �̸��� �ּҸ� ��ȸ
-- ��, �̸����� ���̵� �κи� ��ȸ

-- HINT 1) �̸��� �̸����� ��ȸ
select EMP_NAME "�����", EMAIL "�̸��� �ּ�" from EMPLOYEE;
-- HINT 2) @ ��ġ ã��
select EMP_NAME "�����", INSTR(EMAIL, '@')"�̸��� �ּ�" from EMPLOYEE ;
-- HINT 3) SUBSTR Ȱ��
select EMP_NAME "�����", SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') - 1) "�̸��� �ּ�" from EMPLOYEE;

-- LPAD / RPAD
-- ��ĭ�� ������ ���ڷ� ä��� �Լ�
-- LPAD ���ʿ� ������ ä���� / RPAD �����ʿ� ������ ä����
-- LPAD/RPAD('A', 'B','C'); -> 'A'�� ���ڿ��� 'B'ũ�⸸ŭ('B'-'A'�� ��ĭ��ŭ) 'C'�� ä����
select LPAD(EMAIL, 20, '#') from EMPLOYEE;
select RPAD(EMAIL, 20, '*') from EMPLOYEE;

-- TRIM
-- LTRIM / RTRIM : ���鸸 ã�� �����ִ� �Լ�
select LTRIM('   HELLO'), RTRIM('HELLO    ');
select LTRIM('HELLO   '), RTRIM('    HELLO');

-- TRIM : �糡�� �������� Ư�� ���ڸ� �����ִ� �Լ�
select TRIM('    5����    ');
select TRIM('0' from '000123000');
-- LEADING / TRAILING
-- LEADING : ������ ���ڸ� ����Ͽ� ���ʿ� �ִ� ���ڸ� ����
select TRIM(leading '0' from '000123000');

-- TRAILING : ������ ���ڸ� ����Ͽ� ���ʿ� �ִ� ���ڸ� ����
select TRIM(TRAILING '0' from '000123000');

-- BOTH : ������ ���ڸ� ����Ͽ� ���ʿ� �ִ� ���ڸ� ����
select TRIM(both '0' from '000123000');

-- CONCAT : ���� ���ڿ��� �ϳ��� ���ڿ��� ��ġ�� �Լ�
-- CONCAT('A', 'B'); -> 'A'���ڿ��� 'B'���ڿ��� ��ġ�� �Լ�
select CONCAT('���̿���ť��', '�ʹ��ʹ� ����־�� :)');

-- REPLACE : �־��� ���ڿ����� Ư�� ���ڸ� ������ �� ����ϴ� �Լ�
-- REPLACE('���ڿ�', 'A', 'B'); -> ���ڿ��� A�� B�� �ٲپ� �ִ� �Լ�
select REPLACE('HELLO WORLD', 'HELLO', 'BYE');

-- �ǽ�[3]
-- EMPLOYEE ���̺��� ��� ����� ���, �����, �̸���, �ֹι�ȣ�� ��ȸ
-- �� ��, �̸����� '@' ������,
-- �ֹι�ȣ�� 7��° �ڸ� ���� '*' ó���Ͽ� ��ȸ

select * from EMPLOYEE;

select EMP_ID "�����ȣ", EMP_NAME "�����", EMAIL "�̸���", EMP_NO "�ֹι�ȣ" 
from EMPLOYEE;

select SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) from EMPLOYEE;

select EMP_ID "�����ȣ", EMP_NAME "�����", SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1),
EMP_NO "�ֹι�ȣ" from EMPLOYEE;

select SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-') + 1) from EMPLOYEE;

select EMP_ID "�����ȣ", EMP_NAME "�����", SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 
"�̸���", RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') "�ֹι�ȣ" from EMPLOYEE;

-- EMPLOYEE ���̺��� ���� �ٹ��ϴ�
-- ���� ����� ���, �����, �����ڵ带 ��ȸ
-- ENT_YN : ��� ����(Y�� ����ߴ�)
-- WHERE ������ �Լ� ��� ����
select * from EMPLOYEE;

-- ������ �Լ� : ��� ã�Ƽ� ����� ������ (�� �ึ��) �Լ� ����
select EMP_ID, EMP_NAME, JOB_CODE, ENT_YN from EMPLOYEE 
where ENT_YN = 'N' and SUBSTR(EMP_NO, 8, 1) = '2';


select EMP_ID, EMP_NAME, JOB_CODE, ENT_YN from EMPLOYEE 
where ENT_YN = 'N' and EMP_NO like '%-2%';

select SUBSTR(EMP_NO, 8, 1) from EMPLOYEE;

-- -----------------------------------------------------------------
-- ������ �Լ� : ���ǿ� �����ϴ� ��� ���� ã�� ���� �ѹ��� ����
-- �׷��Լ� : SUM(), AVG(), MAX(), MIN(), COUNT()
-- �������� ���� ���� �Ѱ��� ������ ��Ÿ��

-- SUM(���ڰ� ��ϵ� �÷�) : �ش� �÷����� �հ�
select SUM(SALARY) from EMPLOYEE;

-- AVG('') : ����� ���
select AVG(SALARY) from EMPLOYEE;

-- MAX(''), MIN('') : �ִ�, �ּ� ��
select MAX(SALARY), MIN(SALARY) from EMPLOYEE;

-- EMPLOYEE ���̺��� '�ؿܿ���1��'�� �ٹ��ϴ� ��� �����
-- ��� �޿�, ���� ���� �޿�, ���� ���� �޿�, �޿� �հ� ��ȸ
select * from DEPARTMENT where DEPT_TITLE = '�ؿܿ���1��';

select AVG(SALARY) "��� �޿�", MAX(SALARY) "���� ���� �޿�", 
MIN(SALARY) "���� ���� �޿�", SUM(SALARY) "�޿� �հ�" 
from EMPLOYEE where DEPT_CODE = 'D5';

select MAX(SALARY), EMP_NAME from EMPLOYEE;

-- COUNT(�÷���) : ���� ���� (NULL�� ī��Ʈ�� ���� ����)
select COUNT(*), COUNT(DEPT_CODE), COUNT(distinct DEPT_CODE) from EMPLOYEE;

select distinct DEPT_CODE from EMPLOYEE;

-- -----------------------------------------------------------------
-- ��¥ ó�� �Լ�
-- SYSDATE() : ���� ��ǻ���� ��¥�� ��ȯ (SYSDATE()�� ���� ���� �� �� �ð��� ��Ÿ��)
select SYSDATE();

-- NOW() : ���� �ð� (�������� ���� ���� �� �ð��� ��Ÿ��)
select NOW(), SLEEP(5), SYSDATE();

-- �� ��¥ ������ ����
-- DATEDIFF 	 : �ܼ� �� ����
-- TIMESTAMPDIFF : ��, �б�, ��, ��, ��, ��, ��, �ʸ� �����Ͽ� ����

-- DATADIFF('A'��, 'B'��); -> 'A'��¥ - 'B'��¥ �� �A ���� ����
select HIRE_DATE "�Ի���", DATEDIFF(NOW(), HIRE_DATE) + 1 "�� ��" from EMPLOYEE;

-- TIMESTAMPDIFF('���ϴ� Ÿ�� ����', 'A'��, 'B'��);
-- -> 'B'������ 'A'���� �� '���ϴ� Ÿ�� ����'��ŭ ��Ÿ���ش�
select HIRE_DATE "�Ի���", TIMESTAMPDIFF(year, HIRE_DATE, NOW()) from EMPLOYEE;
select HIRE_DATE "�Ի���", TIMESTAMPDIFF(QUARTER, HIRE_DATE, NOW()) from EMPLOYEE;
select HIRE_DATE "�Ի���", TIMESTAMPDIFF(month  , HIRE_DATE, NOW()) from EMPLOYEE;
select HIRE_DATE "�Ի���", TIMESTAMPDIFF(second  , HIRE_DATE, NOW()) from EMPLOYEE;

-- SECOND : ��, MINUTE : ��, HOUR : ��, DAY : ��
-- WEEK : ��, MONTH : ��, QUARTER : �б�, YEAR : ��

-- EXTRACT( YEAR | MONTH | DAY FROM ��¥);
select HIRE_DATE, EXTRACT(year from HIRE_DATE), EXTRACT(month FROM HIRE_DATE),
EXTRACT(day from HIRE_DATE) from EMPLOYEE;

-- DATE_FORMAT() -> ��¥�� ���ڷ�
-- ��¥ ���� ����
select HIRE_DATE, DATE_FORMAT(HIRE_DATE, '%Y%m%d%H%i%s'),
DATE_FORMAT(HIRE_DATE, '%Y/%m/%d %H:%i:%s'),
DATE_FORMAT(HIRE_DATE, '%y/%m/%d %H:%i:%s'),
DATE_FORMAT(NOW(), '%Y/%m/%d %H:%i:%s')
from EMPLOYEE;

-- STR_TO_DATE(CHAR, FORMAT) -> ���ڸ� ��¥��
select 20190322, STR_TO_DATE('20190322', '%Y%m%d');
select 20190322, STR_TO_DATE('190322', '%y%m%d');
select 20190322, STR_TO_DATE('2019 03 22 12 52 10', '%Y%m%d%H%i%s');
select 20190322, STR_TO_DATE(190322, '%y%m%d');

-- -----------------------------------------------------------------
-- IF(����, ��(��), ��(����))

-- ���� �ٹ��ϴ� �������� ������ ��, �� ����
select EMP_NAME "�����", EMP_NO "�ֹι�ȣ", 
IF(SUBSTR(EMP_NO, 8, 1) = 1, '��', '��') "����"
from EMPLOYEE;

-- �ǽ� [4]-1
-- EMPLOYEE ���̺��� ��� ������ ���, �����, �μ��ڵ�, �����ڵ�, �ٹ�����, ������ ���θ� ��ȸ
-- �̶�, �ٹ�����(ENT_YN)�� 'Y' �����, 'N'�̸� �ٹ���
-- ������ ���(MANAGER_ID)�� ������ ���, ������ �����ڷ� ��ȸ�϶�.
select * from employee;
select * from DEPARTMENT;
select EMP_ID "���", EMP_NAME "�����", DEPT_CODE "�μ��ڵ�", JOB_CODE "�����ڵ�", 
if(ENT_YN = 'N', '�ٹ���', '�����') "�ٹ�����"  ,
IF(MANAGER_ID is null, '������', '���') "������ ����"
-- IF(IFNULL(MANAGER_ID,0) = 0, '������', '���') "������ ����"
from EMPLOYEE;

-- CASE
-- �ڹ��� IF, SWITCH ó�� ��� ����
-- -----------------------
-- CASE
-- 	WHEN ���ǽ�1 THEN �����1
-- 	WHEN ���ǽ�2 THEN �����2
-- 	ELSE �����3
-- END "��Ī"
-- -----------------------

-- �ǽ� [4]-2
select EMP_ID "���", EMP_NAME "�����", DEPT_CODE "�μ��ڵ�", JOB_CODE "�����ڵ�",
case 
	when ENT_YN = 'Y' then '�����'
	else '�ٹ���'
end "�ٹ� ����",
case 
	when MANAGER_ID is null then '������'
	else '���'
end "������ ����"
from EMPLOYEE;


-- ���� [1]
-- ������ 'J2'�̸鼭 200���� �̻� �޴� ���� �̰ų�,
-- ������ 'J7'�� ����� ���, �����, �����ڵ�, �޿� ���� ��ȸ�ϱ�
select EMP_ID, EMP_NAME, JOB_CODE, SALARY from employee
where (JOB_CODE = 'J2' and SALARY >=2000000) or JOB_CODE = 'J7';

-- ���� [2]
-- EMPLOYEE ���̺��� ����� �ֹ� ��ȣ�� Ȯ���Ͽ�
-- ���� �� ���� ���� ��ȸ�Ͻÿ�.
-- �̸� | ���� | ���� | ����
-- ȫ�� | 00�� |00�� | 00�� 
select EMP_NAME "�̸�", 
CONCAT(SUBSTR(EMP_NO, 1, 2), '��') "����",
CONCAT(SUBSTR(EMP_NO, 3, 2), '��') "��",  
CONCAT(SUBSTR(EMP_NO, 5, 2), '��') "��" 
from EMPLOYEE;


-- == ���� == --
-- 1. �μ��ڵ尡 D5, D9�� ������ �߿��� 2004�⵵�� �Ի��� ������ �� ��ȸ��
-- ��� ����� �μ��ڵ� �Ի��� ��ȸ
select 	EMP_ID "���",
		EMP_NAME "�����",
		DEPT_CODE "�μ��ڵ�",
		HIRE_DATE "�Ի���"
from EMPLOYEE 
where (DEPT_CODE = 'D5' or DEPT_CODE= 'D9') and HIRE_DATE like '2004%';
-- WHERE DEPT_CODE IN('D5', 'D9') AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;


-- 2. ������, �Ի���, �Ի��� ���� �ٹ��ϼ� ��ȸ
-- ��, �ָ��� ������ (LAST_DAY() : �־��� ��¥�� �ش���� ������ �� ��ȯ)
select 	EMP_NAME "������", 
		HIRE_DATE "�Ի���", 
 		DATEDIFF(LAST_DAY(HIRE_DATE), HIRE_DATE) + 1 "�Ի��� ���� �ٹ��ϼ�"
-- TIMESTAMPDIFF(DAY, HIRE_DATE, LAST_DAY(HIRE_DATE)) + 1 "�Ի��� ���� �ٹ��ϼ�"
from EMPLOYEE;

-- 3. *** ������, �μ��ڵ�, �������, ���� ��ȸ
-- ��, ��������� �ֹι�ȣ���� �����ؼ� 00�� 00�� 00�Ϸ� ��µǰ� ��.
-- CONCAT ����ؼ� �غ��� -> 00�� 00�� 00��
-- ���̴� �ֹι�ȣ���� �����ؼ� ��¥ �����ͷ� ��ȯ�� ����, �����
select 	EMP_NAME "������",
		DEPT_CODE "�μ��ڵ�",
 		CONCAT(CONCAT(CONCAT(SUBSTR(EMP_NO, 1, 2), "�� "),
	 	CONCAT(SUBSTR(EMP_NO, 3, 2), "�� ")), 
 		CONCAT(SUBSTR(EMP_NO, 5, 2), "��")) "�������",
-- 		DATE_FORMAT(CONCAT('19', SUBSTR(EMP_NO, 1, 6)), '%y�� %m�� %d��') "�������",
		TIMESTAMPDIFF(YEAR, STR_TO_DATE(SUBSTR(EMP_NO,1,6), '%y%m%d'), NOW()) "����"
from EMPLOYEE;

select EXTRACT(year from NOW()) - EXTRACT(year from (STR_TO_DATE(CONCAT('19', SUBSTR(EMP_NO, 1, 6)), '%y%m%d'))) '����'
from EMPLOYEE;


-- 4. �μ��ڵ尡 D5�̸� �ѹ���, D6�̸� ��ȹ��, D9�̸� �����η� ó���Ͻÿ�.
-- ��, �μ��ڵ尡 D5, D6, D9�� ������ ������ ��ȸ��
-- => CASE ���
-- �����, �μ��ڵ�, �μ���
select 	EMP_NAME "�����",
		DEPT_CODE "�μ��ڵ�",
		case 
			when DEPT_CODE = 'D5' then '�ѹ���'
			when DEPT_CODE = 'D6' then '��ȹ��'
			when DEPT_CODE = 'D9' then '������'
		end	"�μ���"
from EMPLOYEE where DEPT_CODE in('D5', 'D6', 'D9');

