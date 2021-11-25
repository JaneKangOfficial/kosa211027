select employee_id, last_name, salary
from employees
where department_id = 80;

-- view ����
create view vw_80
as
select employee_id, last_name, salary
from employees
where department_id = 80;

select * from vw_80;
desc vw_80;

create view vw_50
as
select employee_id as eid, last_name as lname, salary as sal
from employees
where department_id = 50;

select * from vw_50;
desc vw_50;

create view vw_70
(did, lname, sal)
as
select employee_id, last_name, salary
from employees
where department_id = 70;

select * from vw_70;

-- view �� ���� �����Ͱ� �ƴ϶� �κм����� �Ұ����ϴ�.

create or replace view vw_70    -- create or replace : view�� �ٽ� �����ߴٰ� ����°ſ� ��������
(did, lname, year_sal)
as
select employee_id, last_name, salary * 12
from employees
where department_id = 70;

create or replace view vw_year_sal      -- �Ϲ������� ó�� ���� ������ or replace�� �����.
(eid, fname, hire_date, year_sal)
as
select employee_id, first_name, hire_date, (salary + salary * nvl(commission_pct,0)) * 12
from employees
where job_id like '%MAN%';

select * from vw_year_sal;

--- �� �μ��� ���� �ӱݰ� �ִ� �ӱ�, ��� �ӱ��� ����Ͻÿ�.
select department_name, min(salary), max(salary), avg(salary)
from employees, departments
group by department_name;

create or replace view dept_sal_vw      -- ���պ� : �ΰ��� ���̺��� ����
(dname, minsal, maxsal, avgsal)
as
select department_name, min(salary), max(salary), avg(salary)
from employees, departments
group by department_name;

select * from dept_sal_vw;

-- ������ȣ, �̸�, �Ի���, �޿�, �μ���ȣ, �μ����� ����ϴ� �並 ������.
create or replace view emp_dept_vw          -- ���պ�
(eid, fname, hdate, sal, did, dname)
as
select employee_id, first_name, hire_date, salary, d.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;

select * from emp_dept_vw;

create or replace view vw_30
as
select employee_id, last_name, email, hire_date, job_id, department_id
from emp
where department_id = 30;

select * from vw_30;

insert into vw_30   -- �並 ���ؼ� ���� ���̺� �����Ͱ� �� �� �ִ�.
values(310, 'Rhee', 'hemail', sysdate, 'AP', 210);

select * from emp;

insert into vw_30 (  -- �並 ���ؼ� �������� �ʴ� �÷��� ������ �����͸� ������ �� ����.
                    employee_id, last_name, email, hire_date, job_id, department_id, manager_id) 
values(320, 'Park', 'pmail', sysdate, 'AP', 210, 110);

update vw_30         -- �並 ���ؼ� �������� �ʴ� �����ʹ� ������ �� ����.
set last_name = 'srhee'
where employee_id = 310;

select * from emp;

update vw_30        -- �並 ���ؼ� �������� �����ʹ� ������ �����ϴ�.
set hire_date = sysdate
where employee_id = 115;

select * from vw_30;

update vw_30        -- �並 ���ؼ� �������� �ʴ� �÷��� �����ʹ� ������ �� ����.
set manager_id = 100
where employee_id = 115;

delete from vw_30      -- delete : �� ��ü�� ����
where employee_id = 115;    -- �並 ���ؼ� �������� �����ʹ� ������ �� �ִ�.

select * from vw_30;

delete from vw_30   -- �並 ���ؼ� �������� �ʴ� �����ʹ� ������ �� ����.
where employee_id = 310;

--- �並 ���ؼ� DML���� ����� �� �ִ�.
-- �� insert�� �信�� ������ �ʾƵ� ������ �ȴ�.

create table viewup1(
    c1 number primary key,
    c2 number
);

create table viewup2(
    c1 number primary key,
    c3 number
);

insert into viewup1 values(1, 1);
insert into viewup2 values(1, 1);

create or replace view v_viewup
as
select t1.c1, t1.c2, t2.c3
from viewup1 t1, viewup2 t2
where t1.c1 = t2.c1;

select * from v_viewup;

update v_viewup
set c2 = 10         -- ���պ信�� �� ���̺� �ִ� �÷��� ��(c2)�� ������ �����ϴ�.
where c1 = 1;

select * from v_viewup;
select * from viewup1;

update v_viewup
set c3 = 10         -- ���պ信�� �� ���̺� �ִ� �÷��� ��(c3)�� ������ �����ϴ�.
where c1 = 1;

select * from v_viewup;
select * from viewup2;

update v_viewup
set c3 = 20, c2 = 20     -- �並 ���ؼ� �� ���̺��� �����͸� ������ ���� ����.
where c1 = 1;

insert into v_viewup values(2,2,2); -- �並 ���ؼ� �� ���̺��� �����͸� �Է��� �� ����.
insert into v_viewup(c1,c2) values(2,2);

select * from v_viewup;
select * from viewup1;     

insert into v_viewup(c1,c3) values(2,2);    -- c1�� viewup1�� �ִ� ���� ����ϹǷ� viewup2������ c1�� ����� �� ����.
select * from v_viewup;
select * from viewup2;

delete from v_viewup
where c1 = 1;           -- viewup1�� �ִ� c1�� �����ϰڴ�.
select * from v_viewup;
select * from viewup1;      -- c1 : 2, c2 : 2
select * from viewup2;      -- c1 : 1, c3 : 10
-- ���պ�� DML���� ���������� ����� �ȴ�.

create or replace view empvw20
as
select * from emp where department_id = 20;

select * from empvw20;

insert into empvw20 (employee_id, last_name, email, hire_date, job_id, department_id)
values(320, 'Park', 'pamail', sysdate, 'AP', 210);

select * from emp where employee_id = 320;

-- 20�� �μ��� insert �ϵ���
create or replace view empvw20
as
select * from emp where department_id = 20
with check option constraint empvw20_ck;    -- with check option�� �信�� ���̰� �Ǵ� �����ͷθ� ����, ����, ������ ����

select * from empvw20;

insert into empvw20 (employee_id, last_name, email, hire_date, job_id, department_id)
values(330, 'Park', 'pamail', sysdate, 'AP', 210);      -- ORA-01402: ���� WITH CHECK OPTION�� ���ǿ� ���� �˴ϴ�

--
update empvw20
set department_id = 50      -- ���� �� �������� �ʴ� �����ʹ� ������ �� ����. ORA-01402: ���� WITH CHECK OPTION�� ���ǿ� ���� �˴ϴ�
where employee_id = 201;

create or replace view empvw80
as
select * from emp
where department_id = 80
with read only;             -- with read only : �б� ���� �� -- ��� DML���� �ź�

select * from empvw80;

delete from empvw80         -- ORA-42399: �б� ���� �信���� DML �۾��� ������ �� �����ϴ�.
where employee_id = 147;

-- �� ����
drop view empvw80;
select * from empvw80;      -- ���̺� �Ǵ� �䰡 �������� �ʽ��ϴ�.
-- select�� ���̺� �Ǵ� �信 �ִ� �����͸� �˻��ϱ� ���ؼ� ���

-- from���� �ִ� sub query : �ζ��� ��
--- ��, �޿�, �μ���ȣ, �μ��� �ּұ޿�
select last_name, salary, e.department_id, minsal
from employees e, (select department_id, min(salary) as minsal 
                    from employees
                    group by department_id) d       -- �ζ��� ��
where e.department_id = d.department_id;

--- ������ȣ, �̸�, ����, �Ի���, �޿�, �� �μ��� ����� �� ��ձ޿��� ���
select employee_id, first_name, job_id, hire_date, salary, d.department_id, cnt, avgsal
from employees e , ( select department_id, count(*) as cnt, avg(salary) as avgsal
                     from employees
                     group by department_id) d
where e.department_id = d.department_id;

-- �����ȣ, �̸�, �޿�, �μ�, ����, �޿��� ���� ���� �޴� ������� ���
select employee_id, first_name, salary, department_id, job_id
from employees
order by salary desc;

-- top - n
-- select ���� �׻� rownum �� ������ �ִ�.
-- �޿��� ���� ���� �޴� ��� 5���� �������ÿ�.
select rownum, rn, employee_id, first_name, salary, department_id, job_id
from ( select rownum rn, employee_id, first_name, salary, department_id, job_id
        from employees
        order by salary desc)   -- rn�� ������ ������ 1,2,3... salary�� �°� ���� �� rn ����, rownum�� salary ���� ������ 1,2,3...
where rownum <= 5;

-- �ֱ� �Խñ� ���� 5�� ��������
--select rownum, subject
--from (select subject, reg_date
--      from board
--      order by reg_date desc)
--where rownum <= 5;

-- �޿��� ���� ���� �޴� ��� 10������ 15������ ����Ͻÿ�. �����ȣ, �̸�, �޿�, �μ�, ����
select rownum, rn, employee_id, first_name, salary, department_id, job_id    
-- rownum�� ���� ���� ���� �� ����. ���� ���� �������� �ѹ� �� ���������� �����. rn�� ������ ���ؼ�.
from   ( select rownum rn, employee_id, first_name, salary, department_id, job_id
        from (select employee_id, first_name, salary, department_id, job_id
                        from employees
                        order by salary desc)
        )
where rn >= 10 and rn <= 15;            -- paging�� �� ��� 

-- �����ȣ, �̸�, �޿�, �μ�, ������ ����� �� Ŀ�̼��� ���� ���� �޴� ��� 5���� ����ϼ���.
select rownum, rn, employee_id, first_name, salary, department_id, job_id, commission_pct
from (select rownum rn, employee_id, first_name, salary, department_id, job_id, commission_pct 
      from employees
      where commission_pct is not null
      order by commission_pct desc)
where rownum <= 5;

-- �����ȣ, �̸�, �޿�, �μ�, ������ ����� �� Ŀ�̼��� ������ ������ ���� ���� �޴� ��� 6������ 10������ ����ϼ���.
select rownum, rn, employee_id, first_name, salary, department_id, job_id, year_sal
from ( select rownum rn, employee_id, first_name, salary, department_id, job_id, year_sal
       from (select employee_id, first_name, salary, department_id, job_id, (salary + salary * nvl(commission_pct,0)) * 12 as year_sal
             from employees
             order by year_sal desc)
     )
where rn >= 6 and rn <= 10;

-- group by ���� ���� ���
-- �μ��� ������ ���� �޿� �հ�, �μ���ȣ, ������ ����Ͻÿ�.
select department_id, job_id, sum(salary)
from employees 
group by department_id, job_id;                
                
-- �μ��� �޿��� ����� 9500�̻��� �μ��� ����ϼ���.
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) >= 9500;

---- �μ��� ������ �޿� ���, �μ��� �޿� ���, ��ü ��� ����ϼ���.
select department_id,    job_id,        avg(salary)
from employees
group by department_id, job_id
union
select department_id,   to_char(null),   avg(salary)
from employees
group by department_id
union
select to_number(null),  to_char(null),   avg(salary)
from employees;
------------------------------------------------------
-- rollup : �ڿ������� ����鼭 ���´�. ���� ����
select department_id,    job_id,        avg(salary)
from employees
group by ROLLUP (department_id, job_id);
-- (department_id, job_id)
-- (department_id)
-- ()
--======================================================

--- �� �μ����� ���� ������ �ϸ鼭 �Ի����� ���� �����, �޿����
--- �� �μ��� ������ �����, �޿����
--- �� �μ��� �����, �޿����
--- ��ü �����, �޿����
select department_id, job_id, hire_date, count(*), avg(salary)
from employees
group by department_id, job_id, hire_date
union
select department_id, job_id,   null,     count(*), avg(salary)
from employees
group by department_id, job_id
union
select department_id, null,     null,     count(*), avg(salary)
from employees
group by department_id, null
union
select      null,     null,     null,     count(*), avg(salary)
from employees
group by    null,       null;
----------------------------------------------------------------
select department_id, job_id, hire_date, count(*), avg(salary)
from employees
group by ROLLUP(department_id, job_id, hire_date);
--- (department_id, job_id, hire_date)
--- (department_id, job_id)
--- (department_id)
--- ()
--======================================================

-- �μ��� ������ �޿� �հ�
-- �μ��� �޿� �հ�
-- ������ �޿� �հ�
-- ��ü �޿� �հ�
select department_id,   job_id,    sum(salary)
from employees
group by department_id, job_id
union
select department_id,   null,      sum(salary)
from employees
group by department_id
union
select      null,       job_id,    sum(salary)
from employees
group by job_id
union
select      null,       null,      sum(salary)
from employees;
---------------------------------------------------
-- cube(������ü) : ��� ������ ���´�. ���� ����
select department_id,   job_id,    sum(salary)
from employees
group by cube (department_id, job_id);
-- (department_id, job_id)
-- (department_id)
-- (job_id)
-- ()
--======================================================

--- �� �μ����� ���� ������ �ϸ鼭 �Ի����� ���� �����, �޿����
--- �� �μ��� ������ �����, �޿����
--- �� ������ �Ի��� ���� �����, �޿����
--- �� �μ����� �Ի��� ���� �����, �޿����
--- �� �μ��� �����, �޿����
--- �� ������ �����, �޿����
--- �Ի����� ���� �����, �޿����
--- ��ü �����, �޿����
select department_id, job_id, hire_date, count(*), avg(salary)
from employees
group by cube (department_id, job_id, hire_date);
-- (department_id, job_id, hire_date)
-- (department_id, job_id)
-- (job_id, hire_date)
-- (department_id, hire_date)
-- (department_id)
-- (job_id)
-- (hire_date)
-- ()
--======================================================

--- grouping �Լ� : ����� �÷��� Ȯ���ϱ� ���ؼ� ���
-- ����� �÷��� 0, ������� ���� �÷��� 1
select department_id, job_id, sum(salary), grouping(department_id), grouping(job_id)
from employees
group by ROLLUP (department_id, job_id);

--- �� �μ��� ������ ���� ��縦 ������ �ִ� ������� ��ձ޿�
--- �� �μ��� ���� ��縦 ���� ������� ��ձ޿�
--- ������ ���� ��縦 ���� ������� ��ձ޿�
select department_id, job_id, manager_id, avg(salary)
from employees
group by grouping sets  (department_id, job_id, manager_id),    -- grouping sets : ���ϴ� �÷��� ������ �� �ִ�.
                        (department_id, manager_id),
                        (job_id, manager_id);
--======================================================

-- rollup (a,(b,c),d)
select department_id, job_id, manager_id, sum(salary)
from employees
group by rollup (department_id, (job_id, manager_id));
-- (department_id, (job_id, manager_id))
-- (job_id, manager_id)
-- (department_id)
-- ()

select department_id, job_id, manager_id, sum(salary)
from employees
group by department_id, rollup (job_id), cube(manager_id);
-- (department_id, job_id, manager_id)
-- (department_id, job_id)
-- (department_id)
-- (department_id, manager_id)
-- (job_id, manager_id)�� job_id�� rollup���� �������� ������ �ʴ´�.

-- ���� ���� �ǹ��̴�.
-- group by department_id, rollup(job_id), rollup(manager_id);
-- group by rollup(department_id, job_id, manager_id);
--======================================================

--- 104�� ����� �μ��� ��簡 ���� ����� ����Ͻÿ�.
-- �ϳ��� �� : ��� ��
select * from employees
where department_id = (select department_id from employees where employee_id = 104)
and manager_id = (select manager_id from employees where employee_id = 104);

-- 50�� �μ����� �ϴ� ������ ���� ������ ����ϴ� �������� ã���ÿ�.
select * from employees
where job_id in (select job_id from employees where department_id = 50);

-- employee_id �� 178�� �Ǵ� 174���� ����� ������ �� �μ��� ���� ������ �� �μ��� ���� ����� ������ ǥ���Ѵ�.
-- ��, 178�� 174�� ������� ����.
select * from employees
where manager_id = (select manager_id from employees where employee_id = 178)
and department_id = (select department_id from employees where employee_id = 178)
union
select * from employees
where manager_id = (select manager_id from employees where employee_id = 174)
and department_id = (select department_id from employees where employee_id = 174);

-- �ֺ�
select * from employees
where (manager_id, department_id) in (
                                    select manager_id, department_id
                                    from employees
                                    where employee_id in (178, 174))
and employee_id not in (178, 174);
--======================================================

-- window �Լ�
-- 1. RANK() : ������ ���� ��� ������ ����, ���� ����� +(������ ����� ����)
-- 1, 2, 2, 4 ... 9, 10, 10, 10, 13

-- �޿��� ���� ���� �޴� ������� ������ ����Ͻÿ�.
select first_name, salary, job_id, 
        rank() over (order by salary desc) all_rank
from employees;

select rownum,  first_name, salary, job_id      -- rownum : ���� ����� ����.
from ( select first_name, salary, job_id
       from employees
       order by salary desc);
       
-- ������ �޿��� ������ ������������ ����Ͻÿ�.
select first_name, job_id, salary,
        rank() over(partition by job_id order by salary desc) job_rank    -- partition by: group by �� ��������. rank() over()���� group by ��� ����.
from employees;

-- �� �μ����� �Ի����� ���� ������� �̸�, ����, �Ի���, ��ŷ������ ����ϼ���.
select department_id, first_name, job_id, hire_date, 
        rank() over(partition by department_id order by hire_date) hire_rank
from employees;

-- �޿��� ���� ���� �޴� ������� ������ ������ �޿��� ������ ����Ͻÿ�.
select job_id, salary,
        rank() over(order by salary desc) all_rank,         -- partition by �� ���� ���� �켱������ ����.
        rank() over(partition by job_id order by salary desc) job_rank
from employees;

-- 2. DENSE_RANK()   : ������ ��� ���� ����̰� ���� ����� �������� ���� ���´�.
-- 1, 2, 2, 3 ... 9, 10, 10, 10, 11
select first_name, job_id, salary,
        rank() over(order by salary desc) all_rank,        
        DENSE_RANK() over(order by salary desc) DENSE_RANK
from employees;

-- 3. row_number()  : ������ ��� �����ϴ� ���� ���´�.
-- 1, 2, 3, 4 ... 9, 10, 11, 12
select first_name, job_id, salary,
        rank() over(order by salary desc) all_rank,        
        row_number() over(order by salary desc) row_number
from employees;

-- ���, �̸�, �̸���, ����, �޿�, �μ��� ��� �޿��� ����ϼ���.
select employee_id, first_name, email, job_id, salary, d.department_id, avgsal
from employees e, (select department_id, avg(salary) as avgsal
                   from employees
                   group by department_id) d
where e.department_id = d.department_id;

-- window �Լ� ���
select employee_id, first_name, email, job_id, salary, department_id,
        avg(salary) over (partition by department_id) avgsal
from employees;        