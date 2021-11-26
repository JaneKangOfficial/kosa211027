-- ex3_6�̶�� ���̺��� �����, ������̺� (employees)���� 
-- ������ ����� 124���̰� �޿��� 2000���� 3000���̿� �ִ� ����� ���, �����, �޿�, ������ ����� �Է��ϴ� insert���� �ۼ��غ���.
create table ex3_6 (
    employee_id     number(6),
    emp_name        varchar2(80),
    salary          number(8,2),
    manager_id      number(6)
);

insert into ex3_6
select employee_id, first_name, salary, manager_id from employees
where employee_id = 124 and salary between 2000 and 10000;

-- ������̺�(employees)���� Ŀ�̼�(commission_pct) ���� ���� ����� ����� ������� �����ϴ� ������ �ۼ��غ���.
select employee_id, first_name, commission_pct
from employees
where commission_pct is null;

-- ���������� �����Ͻÿ�.
--    select employee_id, salary
--    from employees
--    where salary between 2000 and 2500
--    order by employee_id;

select employee_id, salary
from employees
where salary >= 2000 and salary <= 2500;

-- any�� �����ϼ���.
--    select employe_id, salary
--    from employees
--    where salary IN (2000, 3000, 4000)
--    order by employee_id;

select employee_id, salary
from employees
where salary = any (2000, 3000, 4000)
order by employee_id;

-- all�� �����ϼ���.
--    select employe_id, salary
--    from employees
--    where salary not IN (2000, 3000, 4000)
--    order by employee_id;

select employe_id, salary
from employees
where salary <> all (2000, 3000, 4000)
order by employee_id;

-- ������̺�(employees)���� phone_number��� �÷��� ����� ��ȭ��ȣ�� ###.###.#### ���·� ����Ǿ� �ִ�.
-- ���⼭ ó�� 3�ڸ� ���� ��� ���� ������ȣ�� (02)�� �ٿ� ��ȭ��ȣ�� ����ϵ��� ������ �ۼ��غ���. Lpad ���.
select lpad(substr(phone_number,5), length(phone_number), '(02)')
from employees;

-- �������� �������� ������̺��� �Ի�����(hire_date)�� �����ؼ� �ټӳ���� 10�� �̻��� ����� ������ ���� ������ ����� ����ϵ��� ������ �ۼ��غ���.
-- (�ټӳ���� ���� ���������� ����� �������� ����), �����ȣ, �����, �Ի�����, �ټӳ��,
select employee_id, first_name, hire_Date, round((sysdate - hire_date) / 365) as �ټӳ��
from employees
where  round((sysdate - hire_date) / 365) >= 10
order by �ټӳ�� desc;

--- �����ȣ, �����, �޿�, ��ȭ��ȣ�� ����� ��, �޿��� ��ȭ ������, ��ȭ��ȣ�� . ��� -�� ��µǰ� �������� �ۼ��Ͻÿ�.
select employee_id, first_name, to_char(salary, '$999,999,999'), replace(phone_number, '.', '-')
from employees;

-- �ټӳ���� 19���� �̻��̸� �̻�
--          18���� �̻��̸� ������
--          17���� �̻��̸� ����
--          16���� �̻��̸� ����
--          15���� �̻��̸� ����
--          14���� �̻��̸� �븮
--                ���� ������� ����Ͻÿ�.
select employee_id, first_name, round((sysdate - hire_date)/365) as �ٹ�����,
        case when round((sysdate - hire_date)/365) >= 19 then '�̻�'
             when round((sysdate - hire_date)/365) >= 18 then '������'
             when round((sysdate - hire_date)/365) >= 17 then '����'
             when round((sysdate - hire_date)/365) >= 16 then '����'
             when round((sysdate - hire_date)/365) >= 15 then '����'
             when round((sysdate - hire_date)/365) >= 14 then '�븮'
             else '���' end ��å
from employees
order by �ٹ����� desc;

-- �޿��� 1000���� ���� ���� 3���ϸ� ���, 5���ϸ� ����, 7���ϸ� �븮, 
-- 9���ϸ� ����, 10���ϸ� ����, 13���ϸ� ����, 15���ϸ� ������, �� �� �̻�
select first_name, salary, trunc(salary/1000) as sal,
        case when trunc(salary/1000) <= 3 then '���'
             when trunc(salary/1000) <= 5 then '����'
             when trunc(salary/1000) <= 7 then '�븮'
             when trunc(salary/1000) <= 9 then '����'
             when trunc(salary/1000) <= 10 then '����'
             when trunc(salary/1000) <= 13 then '����'
             when trunc(salary/1000) <= 15 then '������'
             else '�̻�' end ��å
from employees
order by sal desc;
                            
-- ������̺��� �Ի�⵵�� ������� ���ϴ� ������ �ۼ��غ���.
select to_char(hire_date,'yyyy')as y, count(*)
from employees
group by to_char(hire_date,'yyyy')      -- ��¥�� ��� substr���ٴ� to_char�� ����ϴ� ���� ����.
order by y desc;

-- �Ʒ��� ������ ���� rollup�� ������ �����̴�.
--    select department_id, job_id, sum(salary) totl_jan
--    from employees
--    where hire_date like '03%'
--    group by department_id, rollup(job_id);          
--�� ������ rollup�� ������� �ʰ�, ���տ����ڸ� ����ؼ� ������ ����� �������� ������ �ۼ��غ���. union

select department_id, job_id, sum(salary) totl_jan
from employees
where hire_date like '03%'
group by department_id, job_id
union
select department_id, null, sum(salary) totl_jan
from employees
where hire_date like '03%'
group by department_id;
-- rollup�� �ڿ� ���� ��� : '��� ��'�� �� ���´�.

-- ���, �����, job ��Ī, job ��������, job ��������, job ����μ���, 101�� ����� ���
select e.employee_id, e.first_name, j.job_title, jh.start_date, jh.end_date, d.department_name
from employees e, jobs j, job_history jh, departments d
where e.employee_id = jh.employee_id and jh.department_id = d.department_id and j.job_id = jh.job_id
        and e.employee_id = 101;

-- ������ ������ ANSI JOIN���� �����غ���.
--    select a.department_id, a.department_name
--    from departments a, employees b
--    where a.department_id = b.department_id
--    and b.salary > 3000
--    order by a.department_name;

select a.department_id, a.department_name
from departments a join employees b
on a.department_id = b.department_id
where b.salary > 3000
order by a.department_name;

-- �� �μ��� �޿��� ���� ���� �޴� ������� ���Ͻÿ�.
select e.employee_id, first_name, last_name, hire_date, salary, d.department_id, minsal
from employees e, (select department_id, min(salary) as minsal
                from employees
                group by department_id) d
where e.department_id = d.department_id
order by department_id;

select * from employees
where salary in (select min(salary) from employees group by department_id);

--- merge : insert, update
-- ���ϴ� ���̺� �����Ͱ� ������ insert
--              �����Ͱ� ������ update
select * from ex3_6;
desc ex3_6;
merge into ex3_6 a              -- ��ٱ��� ��ǰ ����
      using (select * from employees where employee_id = 103) b
      on (a.employee_id = b.employee_id)
WHEN MATCHED THEN
      update set salary = salary * 1.1
WHEN not MATCHED THEN
      insert (a.employee_id, a.emp_name, a.salary, a.manager_id)
      values (b.employee_id, b.first_name, 15000, 100);

select * from ex3_6;