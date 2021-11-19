--1. Ʋ�� ���� ã���ÿ�
--select employee_id, last_name sal x 12 ANNUAL SALARY
--FROM hr.employees
select employee_id, last_name, salary, salary * 12 as "ANNUAL SALARY"
from employees;

--2. departments���̺��� ������ ǥ���ϰ� ��� �����͸� ����Ͻÿ�.
desc departments;
select * from departments;

--3. employees���̺� ������ ǥ���ϰ�,
--�̸�, ����, �Ի����� ��µǵ��� �Ͻÿ�.
desc employees;
select first_name, job_id, hire_date
from employees;

--4. �����ȣ, ��, ����, �Ի����� ����Ͻÿ�.
select employee_id, last_name, job_id, hire_date
from employees;

--5. ������̺��� ������ ����� �� �ߺ� ���� ����Ͻÿ�.
select DISTINCT job_id
from employees;

--6. ��� ��ȣ�� Emp #, �̸��� employee, ������ job,�Ի����� Hire Date�� heading name�� ��µǰ� �Ͻÿ�.
select employee_id as "Emp #", first_name as "employee", job_id as "job", hire_date as "Hire Date"
from employees;

--7. ������ �̸��� �ٿ��� ����ϵ� ���̿� ', '������ ����Ͻÿ�.
select job_id || ', ' || first_name
from employees;

--8. ��� ���̺��� ��� ���� �ٿ��� ����ϵ� ���� ���̿� ','�� ������ �Ͻÿ�.
desc employees;
select employee_id||', '||first_name||', '||last_name||', '||email||', '||phone_number||', '|| hire_date||', '|| job_id||', '||salary||', '||commission_pct||', '|| manager_id||', '||department_id
from employees;

--9. �޿��� 12,000�Ѵ� ����� �̸��� �޿��� ����Ͻÿ�.
select first_name, salary
from employees
where salary > 12000;

--10. ��� ��ȣ 176�� ����� �̸��� �μ���ȣ�� ����Ͻÿ�.
select first_name, department_id
from employees
where employee_id = 176;

--11. �Ի����� 2002�� 2�� 20�� ���� 2002�� 5��1�� ���̿� �Ի��� ����� �̸�, ���� �� �Ի����� ����Ͻÿ�.
select first_name, job_id, hire_date
from employees
where hire_date BETWEEN '02/02/20' and '02/05/01';

--12. ������(manager_id)�� ���� ����� ����Ͻÿ�.
select * from employees
where manager_id is null;

--13. ������ 'AP'�� ���ԵǾ� �ִ� ������� ��� ����Ͻÿ�.
select * from employees
where job_id like '%AP%';

--14. ������̺��� ������ MAN�� �����ϰ� �޿��� 10000�̻���
--����� �����ȣ�� ���� ���� �׸��� �޿��� ����Ͻÿ�.
select employee_id, last_name, job_id, salary
from employees
where job_id like '%MAN%' and salary >= 10000;

--15. ������ SA_REP�̰ų� AD_PRES �̸鼭 �޿��� 15000�� �ʰ��ϴ�
--����� ����Ͻÿ�.
--��, ��, ����, �޿��� ��� or�� and�� ���
select last_name, job_id, salary
from employees
where (job_id = 'SA_REP' or job_id = 'AD_PRES') and salary > 15000;

--16. �������̺��� �μ���ȣ�� ������������ �����Ͽ� ����Ͻÿ�.
--�μ���ȣ , �޿�, �Ի���, ��
select department_id, salary, hire_date, last_name
from employees
order by department_id;

--17. �μ��� ������������ �����ϰ� �Ի��ϵ� ������������ ����
--�μ���ȣ , �޿�, �Ի���, ��
select department_id, salary, hire_date, last_name
from employees
order by department_id desc, hire_date desc;

--18. �μ��� ������������ �����ϰ� �Ի����� ������������ �����Ͽ� ���
--�μ���ȣ , �޿�, �Ի���, ��
select department_id, salary, hire_date, last_name
from employees
order by department_id desc, hire_date;

--����)�μ��� ������������ �����ϰ� �Ի����� ������������ �����Ͽ�
--�޿��� ������������ �����Ͽ� ���
--�μ���ȣ , �Ի���, �޿�, ��
select department_id, hire_date, salary, last_name
from employees
order by department_id desc, hire_date, salary desc;