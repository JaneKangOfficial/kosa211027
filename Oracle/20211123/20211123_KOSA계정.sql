--1. ���� �̸��� �ٿ��� ����Ͻÿ�.
select last_name || first_name
from employees;
-- �Ǵ� concat�̿� �����ϳ�, �̿��ϱ� �����ϱ� ������ || ��ȣ�� ����

select concat('���� �̸��� ' , concat(last_name, first_name))
from employees;

-- 2. nvl
-- ��, �̸�, ����, �޿�, Ŀ�̼��� ������ ����
select last_name, first_name, job_id, salary, 
       (salary + salary * nvl(commission_pct,0)) * 12 year_sal
from employees;

-- 3. nvl2
select last_name, first_name, job_id, salary,
--                              ���� �ƴϸ� �ι�° �� ���,           ���̸� ����° �� ���
        nvl2(commission_pct, (salary + salary * commission_pct) * 12, salary * 12)
from employees;

-- 4. nullif
select first_name, length(first_name),
        last_name, length(last_name),
        --          exp1                   exp2
        nullif(length(first_name), length(last_name)) result
        -- exp1�� exp2�� ������ null ���
        -- exp1�� exp2�� �ٸ��� exp1 ���
from employees;

--- 5. coalesce �Լ�
--                              exp1       exp2   exp3
select last_name, coalesce(commission_pct, salary, 10) comm
--                          exp1 null�� �ƴϸ� exp1 ���
--                          exp1 null�̸� exp2 ���
--                          exp1�� exp2�� ��� null�̸� exp3 ���
from employees;

-- ������ �Լ� (������ ���� ���� ����)
--- 6. �޿��� ���� ���� �޴� ����� ���� �޴� ���, �޿� ����� ����Ͻÿ�.
select max(salary), min(salary), avg(salary)
from employees;

--- 7. �޿��� �޴� ����� ���� �μ��� ������ �ִ� ����� ���� ����Ͻÿ�.
select count(salary), count(department_id)
from employees;
--- ������ �Լ��� null ���� �����ϰ� ����Ѵ�.

-- 8. Ŀ�̼��� �޴� ������� Ŀ�̼� ��հ� ���� ��ü�� Ŀ�̼� ����� ���Ͻÿ�.
select avg(commission_pct), sum(commission_pct) / count(*)
from employees;
--- ������ �Լ��� null ���� �������� �����Ƿ� ��ü�� ���� ���� �� ���� �ٸ� �� �ִ�.

-- 9. ��ü ����� ���� ���Ͻÿ�. (�� ��ü ����)
select count(*) from employees;

-- 10. ���� �ʰ� �Ի��� ����� ���� ó���� �Ի��� ����� ����Ͻÿ�.
select max(hire_date), min(hire_date)
from employees;

-- 11. ������ 'REP'�� ������ �ִ� ����� �� ���� ���� �޴� �޿��� ���� �޴� �޿��� ����Ͻÿ�.
-- ��� �޿��� ����� ����
select max(salary), min(salary), avg(salary), count(*)
from employees
where job_id like '%REP%';

-- ��� ���        107��        107��
select first_name, salary, to_char(hire_date, 'dd-mm-yyyy')
from employees;

-- ��� ��� 1��
select sum(salary) from employees;

-- ������ �Լ��� ����ϴ� ��� ������ �Լ��� ����ؾ� �Ѵ�. �÷��� �߰��� �� ����.
--select first_name, sum(salary)        -- ����, ���� ���� ����� ���� ����.
--from employees;

-- 12. 80�� �μ����� Ŀ�̼��� �޴� ����� ���� �ִ� Ŀ�̼� ���� �ּ� Ŀ�̼� ���� ����Ͻÿ�.
--      �μ��� ���� �ִ� ����� ��
select count(commission_pct), max(commission_pct), min(commission_pct),
        count(*)
from employees
where department_id = 80;

-- 13. �ߺ����� ���� �μ���?
select distinct(department_id) 
from employees;

-- 14. �ߺ����� ���� �μ��� ����?
select count(distinct(department_id))
from employees;     -- null�� �μ��� �ƴϹǷ� ����

-- 15. Ŀ�̼��� �޴� ����� Ŀ�̼� ��հ� Ŀ�̼��� ���� �ʴ� ����� Ŀ�̼� ����� ���Ͻÿ�.
select trunc(avg(commission_pct), 4),               -- 0.2228
       trunc(sum(commission_pct) / count(*), 4),    -- 0.0728
       trunc(avg(nvl(commission_pct,0)),4)          -- 0.0728
from employees;

-- 16. 90�� �μ��� �޿� ���, �հ�, �ִ�, �ּ�, ����� ��
select avg(salary), sum(salary), max(salary), min(salary), count(*)
from employees
where department_id = 90;

--     80�� �μ��� �޿� ���, �հ�, �ִ�, �ּ�, ����� ��
select avg(salary), sum(salary), max(salary), min(salary), count(*)
from employees
where department_id = 80;

--     70�� �μ��� �޿� ���, �հ�, �ִ�, �ּ�, ����� ��
select avg(salary), sum(salary), max(salary), min(salary), count(*)
from employees
where department_id = 70;

-- group by
-- 17. �� �μ��� �μ��� �޿� ���, �հ�, �ִ�, �ּ�, ����� ��
select department_id,    -- group by���� �ִ� �÷��� select���� ��� �����ϴ�.
       trunc(avg(salary),2), sum(salary), max(salary), min(salary), count(*)
from employees
group by department_id
order by department_id;

-- 18. ���� ������ �ϴ� ����� �� ���� ���� ���� ����� ���� �ʰ� ���� ����� �Ի����� ����Ͻÿ�.
--              �ʰ� ���� ��    ���� ���� ��
select job_id, max(hire_date), min(hire_date)
from employees
group by job_id
order by job_id;

-- 19. �����ȣ, �̸�, �Ի���, ����, �μ��� ����� ��, �μ��� ������������ �����ϰ� �� �μ��� ������ ������������ �����Ͽ� ����Ͻÿ�.
select department_id, job_id, employee_id, first_name, hire_date
from employees
order by department_id, job_id;

-- 20. �� �μ��� ������ �޿� ���, �հ�, ����ϴ� ����� ���� ���
select department_id, job_id, trunc(avg(salary)), sum(salary), count(*)
from employees
group by department_id, job_id
order by department_id, job_id;

-- 21. 90 �μ����� ������ �޿� �հ�� ����� ���Ͻÿ�.
select job_id, sum(salary), avg(salary)     -- 4
from employees                              -- 1
where department_id = 90                    -- 2
group by job_id;                            -- 3

-- 22. �� �μ����� ������ ���� ����� �� �Ի����� ���� ����� ���� ���
select department_id, job_id, hire_date, count(*)                          -- 4
from employees                                                             -- 1
group by department_id, job_id, hire_date                                  -- 2
having count(*) >=2;     -- group �Լ��� ������ �ִ� ��� having ���� ���       -- 3

-- 23. ��ձ޿��� 7000�̻��� �μ��� ���, ��ձ޿� ���� �ͺ��� ����Ͻÿ�.
select department_id, trunc(avg(salary))
from employees
group by department_id
having avg(salary) >= 7000
order by avg(salary) desc;
-- order by 2 desc;

-- 24. �μ��� ���� ���� 10�� �̸��� �μ��� ����Ͻÿ�.
select department_id, count(*)
from employees
group by department_id
having count(*) < 10
order by department_id;

-- 25. ������ 'REP'�� ���ԵǾ� ���� ���� ������ �޿� ���, �հ�, �ּ�, �ִ� ���� ����� �� �޿��� �հ谡 13000�̻��� ������ ����Ͻÿ�.
select job_id, avg(salary), sum(salary), min(salary), max(salary)
from employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000;

--- ������ �Լ�, group by, having
--- sum, avg, max, min, count

select max(employee_id) + 1
from employees;

-- select max(board_num) + 1 from board;        -- ���� ���!

select employee_id, first_name, department_id
from employees
where employee_id = 100;

select department_id, department_name
from departments
where department_id = 90;

--         100                        90
select employee_id, first_name, employees.department_id, department_name
from employees, departments
where employee_id = 100 
--                  90                          90
        and employees.department_id = departments.department_id;
        
        
-- �μ����̺��� 90�� �μ������� ����Ͻÿ�.
select * from departments where department_id = 90;

-- 90�� �μ��� ������ ���Ͻÿ�.
select * from employees where department_id = 90;

-- 100�� ��� ������ ����Ͻÿ�.
select * from employees where employee_id = 100;

-- 27. ��� ����� ��, �̸�, �޿�, ����, �μ���ȣ, ������ȣ, �μ����� ����Ͻÿ�.
select employee_id, last_name, first_name, salary, job_id,              -- 3
        departments.department_id, location_id, department_name
from employees, departments                                             -- 1
--              10            =             10
--              20            =             20
where employees.department_id = departments.department_id;              -- 2

--- īƼ�þ� ����
select employee_id, last_name, first_name, salary, job_id,              -- 3
        departments.department_id, location_id, department_name
from employees, departments;

-- ����� ��, �޿�, �Ի���, ������ ����� �� ������ ���� ����Ͻÿ�.
select * from jobs;
select * from employees;

select last_name, salary, hire_date, employees.job_id, job_title
from employees, jobs
where employees.job_id = jobs.job_id;

-- T-SQL join
select employee_id, last_name, first_name, salary, job_id,             
        d.department_id, location_id, department_name
from employees e, departments d                                            
where e.department_id = d.department_id;

-- Ansi - join
-- 29. ������ȣ, ��, �̸�, �޿�, ����, �μ���ȣ, ������ȣ, �μ����� Ansi-join
select employee_id, last_name, first_name, salary, job_id,             
        d.department_id, location_id, department_name
from employees e join departments d                                            
on e.department_id = d.department_id;

-- 30. ansi-join���� ������ȣ, ��, �̸�, �޿�, �μ���ȣ, �μ����� 100�� ����� ����Ͻÿ�.
select employee_id, last_name, first_name, salary, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id    -- join ����
where employee_id = 100;

-- 31. natural join
-- ���� ��ȣ, ��, �̸�, ����, �������� ����Ͻÿ�.
-- T-SQL join
select employee_id, last_name, first_name, e.job_id, job_title
from employees e , jobs j
where e.job_id = j. job_id;     -- �Ϲ������� join������ primary key = foreign key

-- Ansi join
select employee_id, last_name, first_name, e.job_id, job_title
from employees e join jobs j
on e.job_id = j. job_id;

-- natural join
select employee_id, last_name, first_name, job_id, job_title
from employees NATURAL JOIN jobs;    -- ��Ī�� ���� �� ����.
--- ���̺��� ���� �̸��� �÷��� ���ϴ� ���̹Ƿ� ���� ������ �ʿ����. : natural join

-- 32. �μ����� ����� ������ ���Ͻÿ�. ������ȣ, ��, �޿�, �Ի���, �μ���ȣ, �μ��� ��ȣ�� ����Ͻÿ�.
select * from departments;
select * from employees;

-- T-SQL join
select employee_id, last_name, salary, hire_date, d.department_id, d.manager_id
from employees e, departments d
where e.department_id = d.department_id and d.manager_id = e.manager_id;

-- Ansi join
select employee_id, last_name, salary, hire_date, d.department_id, d.manager_id
from employees e join departments d
on e.department_id = d.department_id and d.manager_id = e.manager_id;

-- natural join
select employee_id, last_name, salary, hire_date, department_id, manager_id
from employees natural join departments;

-- using�� ���
select employee_id, last_name, salary, hire_date, department_id, manager_id
from employees join departments using(department_id, manager_id);

---------- natural join�� ���� �̸��� �÷��� �� ���ϱ� ������ �ϳ��� ���ϴ� ��� natural join�� ����� �� ����.
select last_name, first_name, salary, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id;
-- ���� �̸��� �÷��� �ΰ��̹Ƿ� natural join���� ������ �� ����.
----------

-- 33. ��, �̸�, ������ȣ, ��ȭ��ȣ, �޿�, �μ���ȣ, �μ����� ansi-join���� ����Ͻÿ�.
select last_name, first_name, employee_id, phone_number, salary, d.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id;

-- using�� ���
select last_name, first_name, employee_id, phone_number, salary, department_id, department_name
from employees join departments using(department_id);

-- 34. �� �μ��� �μ��� ������ �μ����� �̸��� ����Ͻÿ�.
select d.department_id, department_name, location_id, d.manager_id,
        employee_id, first_name
from departments d, employees e
where d.manager_id = e.employee_id;
--          FK     =      PK

--- 35. ���� ����
--- ���� ��ȣ, ���� ��ȣ, ��������
desc jobs;
desc employees;
desc departments;

select employee_id, j.job_id, job_title
from employees e, jobs j
where e.job_id = j.job_id;

--- ���� ��ȣ, �μ� ��ȣ, �μ���
select employee_id, d.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;

--- ��������
--- �� ������ ������ȣ, ������ȣ, ��������, �μ���ȣ, �μ���,
-- T-SQL join
select employee_id, j.job_id, job_title, d.department_id, department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id and e.department_id = d.department_id;
-- ���̺� 3���̸� ���� ������ �ּ� 2��
-- ���̺��� n���̸� ���� ������ n-1��

-- Ansi join        -- �������� �ַ� ���
select employee_id, j.job_id, job_title, d.department_id, department_name
from employees e join jobs j
on e.job_id = j.job_id join departments d 
on e.department_id = d.department_id;

-- natural join , using join
select employee_id, job_id, job_title, department_id, department_name
from employees Natural join jobs join departments using (department_id);

--- 36. �μ����� ���������� ����Ͻÿ�. �μ��� ��ȣ, ��������
select d.manager_id, j.job_title
from departments d, jobs j, employees e
where e.employee_id = d.manager_id and e.job_id = j.job_id;

--- 37. �μ��� ����(null) ������ ���� ���
select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e left outer join departments d
on e.department_id = d.department_id;

select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from departments d right outer join employees e
on e.department_id = d.department_id;

--- 38. ������ ����(null) �μ��� ���� ���
-- ansi join
select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from departments d left outer join employees e
on e.department_id = d.department_id;

select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e right outer join departments d
on e.department_id = d.department_id;

-- t-sql join
select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e , departments d
where e.department_id = d.department_id(+);     -- employees���� �� ����ϰ� ������ department�ʿ� (+)

select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e , departments d
where e.department_id(+) = d.department_id;     -- department���� �� ����ϰ� ������ employees�ʿ� (+)

-- 39. �μ��� ���� ������ ������ ���� �μ��� ���
-- ansi join
select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e full outer join departments d
on e.department_id = d.department_id;

-- t-sql join
--select first_name, last_name, salary, e.department_id,
--        d.department_id, department_name
--from employees e , departments d
--where e.department_id(+) = d.department_id(+);    -- full outer join�� ansi join������ �����ϴ�.