-- ����� �μ�
select * from DEPARTMENT;
select * from LOCATION;
select * from EMPLOYEE;

desc EMPLOYEE;

-- ����� �μ��� ����� Ȯ��
select COUNT(*) from DEPARTMENT;

-- ����� ������� Ȯ��

select COUNT(*) from EMPLOYEE;

-- ����� ����
select * from SAL_GRADE;

-- ��� ����
select * from EMPLOYEE;

-- ���� [1]
-- ������ 250���� ���� ���� �޴� ����� ��� ������ �������, ������� �����.
select * from EMPLOYEE where SALARY>2500000;
select COUNT(*) from EMPLOYEE where SALARY>2500000;

-- ���� [2]
-- EMPLOYEE ���̺��� �Ի��� ��¥�� '2000-01-01' ���� �� ������� �̸�, �ֹι�ȣ, �Ի����� ��ȸ
-- HINT : ��¥������ �� ���� ����
select EMP_NAME, EMP_NO, HIRE_DATE from EMPLOYEE where HIRE_DATE > "20000101";

-- �μ� �ڵ�(DEPT_CODE)�� 'D6'�� ��� ���� ��� ��ȸ�ϱ�
select * from employee WHERE DEPT_CODE = "D6";

-- ����(JOB_CODE)�� 'J1'�� ����� ���(EMP_ID), �����(EMP_NAME), �����ڵ�(JOB_CODE), �μ��ڵ�(DEPT_CODE)�� ��ȸ�Ͻÿ�.
select EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE from EMPLOYEE where JOB_CODE = 'J1';

-- ������ 2�� �̻� �پ��� ��� (AND | OR)
-- �μ��ڵ尡 'D6' �̸鼭, �̸��� '�����'��
-- ����� ��� ���� ��ȸ�ϱ�
select * from EMPLOYEE where DEPT_CODE ="D6" and EMP_NAME = "�����";
