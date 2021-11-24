-- 1. ���� Abel�� ����� ������ ����ϼ���.
select last_name, job_id
from employees
where last_name = 'Abel';

-- 2. ���� Abel�� ����� ���� ������ �ϴ� ������� ����ϼ���.
select last_name, job_id
from employees
where job_id = 'SA_REP';

-- ���������� ���� �������� ���� ������ �ȴ�.
-- ���������� �Ұ�ȣ �ȿ� �־�� �Ѵ�.
select last_name, job_id
from employees
where job_id = (select job_id
                from employees
                where last_name = 'Abel');
                
-- 3. 106���� ����� �޿��� ���Ͻÿ�.
select employee_id, salary
from employees
where employee_id = 106;

-- 4. 106���� ����� ���� �޿��� �޴� ����� ���Ͻÿ�.
select employee_id, salary
from employees
where salary = (select salary
                from employees
                where employee_id = 106);
                
-- 5. ���� Austin�̶�� ����� ���� ���ϴ� ������� ���Ͻÿ�.
select job_id
from employees
where last_name = 'Austin';

select job_id
from employees
where job_id = (select job_id
                from employees
                where last_name = 'Austin');
                
-- 6. 141���� ������ ����Ͻÿ�.
select job_id
from employees
where employee_id = 141;

--    143���� �޿��� ����Ͻÿ�.
select salary
from employees
where employee_id = 143;

-- 7. 141���� ������ ���� 143���� �޿��� ���� �������?
-- ��, ������ ST_CLERK�̰� �޿��� 2600�� ����� ���Ͻÿ�.
select job_id, salary
from employees
where job_id = (select job_id from employees where employee_id = 141) 
and salary = (select salary from employees where employee_id = 143);

-- 8. ���� �޿��� �޴� ����� ���Ͻÿ�.
select min(salary) from employees;
select * from employees where salary = (select min(salary) from employees);

-- 9. 90�� �μ��� ��� �޿����� ���� �޿��� �޴� ����� ���Ͻÿ�.
select avg(salary) from employees where department_id = 90;
select * from employees 
where salary > (select avg(salary) from employees where department_id = 90);

-- 10. �Ի����� 178������ �ʰ� �Ի��� ����� ���Ͻÿ�.
select * from employees 
where hire_date > (select hire_date from employees where employee_id = 178);

-- 11. 50�� �μ��� ��� �޿�
select avg(salary) from employees where department_id = 50;

-- 12. �� �μ��� ��� �޿��� 3475���� ū �μ���?
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) > 3475;

-- 13. 50�� �μ��� ��� �޿����� ��� �޿��� ���� �μ��� ���Ͻÿ�.
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) > (select avg(salary) from employees where department_id = 50);

-- 14. 60�� �μ��� ���� �޿����� �� ���� �޿��� �޴� �����?
select min(salary) from employees where department_id = 60;

select * from employees
where salary < (select min(salary) from employees where department_id = 60);

-- 15. 50, 60, 70�� �μ��� ���� �ݾװ� ���� �޿��� �޴� �������?
select min(salary) from employees where department_id in (50, 60, 70) group by department_id;

select * from employees 
where salary in (select min(salary) from employees 
                 where department_id in (50, 60, 70) 
                 group by department_id);

-- 16. �� �μ��� ���� �ݾ��� ���ϰ� �� ���� �ݾ׿� �ش� �Ǵ� ��� ������� ����Ͻÿ�.
select department_id, min(salary) from employees group by department_id;

select * from employees 
where salary in (select min(salary) from employees group by department_id);

-- 17. ��� �޿��� ���� ���� ������ ã������.
select job_id, avg(salary) 
from employees 
group by job_id
having avg(salary) = (select min(avg(salary)) from employees group by job_id);

-- 18. 50�� �μ��� �޿��� ����Ͻÿ�.
select salary from employees where department_id = 50 order by salary;
--           |------------------------------------------------->
        -----|-------------------------------------------|-----
--          2100                                       8200

-- 19. 50�� �μ� ������� �޿� �� ���� �ݾ׺��� �� ���� �޴� ������� ����Ͻÿ�.
--      ���� �ͺ��� ũ��. : any
select * from employees where salary > 2100;

select * from employees 
where salary > (select min(salary) from employees where department_id = 50);

select * from employees 
where salary > any(select salary from employees where department_id = 50);

-- 20. 50�� �μ� ������� �޴� �޿� �� ���� ���� �޴� �޿����� ���� �޿��� �޴� ������� ����Ͻÿ�.
--      ū �ͺ��� �۴�. : any
select * from employees 
where salary < (select max(salary) from employees where department_id = 50);

select * from employees 
where salary < any(select salary from employees where department_id = 50);

-- 21. 90�� �μ� ������� �޴� �޿� �� ���� ���� �޿����� ���� �޿��� �޴� ������� ���Ͻÿ�.
--      �����ͺ��� ����. : all
select * from employees
where salary < (select min(salary) from employees where department_id = 90);

select * from employees
where salary < all(select salary from employees where department_id = 90);

-- 22. 50�� �μ� ������� �޴� �޿� �� ���� ���� �޿����� �� ���� �޿��� �޴� ������� ���Ͻÿ�.
--      ū�ͺ��� ũ��. : all
select * from employees
where salary > (select max(salary) from employees where department_id = 50);

select * from employees
where salary > all(select salary from employees where department_id = 50);

-- 23. 30�� �μ��� ������� �޴� �޿��� ���� �޿��� �޴� ������� ����Ͻÿ�.
select salary from employees where department_id = 30;

select * from employees
where salary in (select salary from employees where department_id = 30);

select * from employees     --      '= any' = 'in'
where salary = any (select salary from employees where department_id = 30);

create table testa (a1 number(10), a2 number(10));
create table testb (a1 number(10), b1 number(10));
insert into testa values (1, 1);
select * from testa;
select max(a1) + 1 from testa;
insert into testa values((select max(a1) + 1 from testa), 3);

-- ���տ����� (���̽� set : union(������), intersect(������), minus(������))
-- union : �������̺�, ������̺�, ���������� ���̵� �ߺ� Ȯ��

--select user_id
--from employees
--where user_id = 'highland0'
--union
--select user_id
--from member
--where user_id = 'highland0'

-- 24. ������̺��� 108���� ��� ���
select manager_id from employees where employee_id = 108;
-- �μ����̺��� 80�� �μ��� �μ����� ���
select manager_id from departments where department_id = 80;
-- 108���� ���� 80�� �μ��� �μ����� ����Ͻÿ�.
select manager_id from employees where employee_id = 108
union
select manager_id from departments where department_id = 80;

-- 25. ������̺� �����ȣ�� ������ ���
select employee_id, job_id from employees;
--      �������� ���̺��� �����ȣ�� ������ ���
select employee_id, job_id from job_history;
--      ������̺� �����ȣ�� ���� �׸��� �������� ���̺��� �����ȣ�� ������ ���
select employee_id, job_id from employees
union
select employee_id, job_id from job_history;    -- union : �ߺ� ������ �����ϰ� ���

select employee_id, job_id from employees
union all
select employee_id, job_id from job_history;    -- union all : �ߺ� ������ ���� ���

-- 26. ������̺� �ִ� ���� ���� ���� �׸��� �����������̺� ������ȣ�� ������ ���
select manager_id, job_id from employees
union
select employee_id, job_id from job_history;
-- �÷��� �̸��� �������� �ʾƵ� �ȴ�.

-- 27. ������̺����� �̸�, �޿��� ����ϰ� �μ����̺����� �μ���, �μ����� ���
-- �� ���� ������ Ÿ�Ը� ��ġ�ϸ� �ȴ�.
-- heading name�� ù��° ���̺��� �� �̸��� �ȴ�.
--        ����       ����
select first_name, salary from employees
union
--         ����             ����
select department_name, manager_id from departments;

-- 28. ù��° ���̺��� ���̸��� ��Ī �ֱ�
-- ��Ī�� heading name�� ����
select first_name as dname, salary as mng from employees
union
select department_name, manager_id from departments;

-- 29. ��� ���̺����� �޿��� �μ���ȣ �׸��� �μ� ���̺����� �μ���� �μ��̸�
--      ����         ����
select salary, department_id from employees
union
--      ����          ����
select manager_id, department_name from departments;    -- ORA-01790: �����ϴ� �İ� ���� ������ �����̾�� �մϴ�.

-- 30. 29������ ������ ���� ���
select salary,       department_id,   '����'              from employees
union
select manager_id,       0,           department_name    from departments;

------------------------------------------------
select salary,       department_id,      to_char(null)        from employees
union
select manager_id,   to_number(null),    department_name      from departments;

-- 31. ��� ���̺��� �μ���ȣ, �Ի��� �׸��� �μ� ���̺��� �μ���ȣ, ������ȣ ���
select department_id, hire_date as h_date, to_number(null) as l_id      from employees
union
select department_id, to_date(null),        location_id                 from departments;

-- 32. �μ����̺��� �������� �ʰ� �������̺��� �����ϴ� ��� ���
--      �μ����� �ƴ� ��縦 ���
select DISTINCT manager_id from employees 
where manager_id not in (select manager_id from departments where manager_id is not null);

select manager_id from employees
minus   -- ������
select manager_id from departments;

-- �μ����� ����ȣ�� ��� (�μ����̸鼭 ���)
select manager_id from employees 
intersect   -- ������
select manager_id from departments;
-------------------------------- �⺻ select�� --------------------------------

----- DML : insert, delete, update (������ ����)
----- Ȯ�� DML : select, insert, delete, update
create table aa1(
    a1 number primary key,
    a2 number
);
insert into aa1 values(1,1);
select * from aa1;
create table bb1(
    a1 number REFERENCES aa1(a1),
    b1 number
);
insert into bb1 values(1,11);
select * from bb1;

--drop table bb1;
--drop table aa1;

delete from aa1 
where a1 = 1;   -- ���Ἲ ��������(KOSA.SYS_C008424)�� ����Ǿ����ϴ�

delete from bb1
where a1 = 1;
delete from aa1
where a1 = 1;

create table aa2 (
    a1 number primary key,
    a2 number
);
insert into aa2 values(1,1);
select * from aa2;

drop table bb2;
create table bb2(
    a1 number references aa2(a1) on delete set null ,
    b1 number                   -- �θ� �����Ǿ �ڽ��� null�� ������
);
insert into bb2 values(1,11);
select * from bb2;

create table cc2(
    a1 number references aa2(a1) on delete cascade,
    c1 number                   -- �θ� �����Ǹ� �ڽĵ� ���� ����
);
insert into cc2 values(1,22);
select * from cc2;

insert into aa2 values(2,2);
insert into bb2 values(2,111);
insert into cc2 values(2,222);
select * from aa2;
select * from bb2;
select * from cc2;

delete from aa2
where a1 = 1;

create table aa3 (
    a1 number, 
    a2 number
);
alter table aa3
add constraint aa3_a1 primary key(a1);

create table bb3(
    a1 number,
    b1 number
);
alter table bb3
add constraint bb3_a1_fk foreign key (a1)
    references aa3(a1) on delete set null;

create table cc3 (
    a1 number,
    c1 number
);
alter table cc3
add constraint cc3_a1_fk foreign key (a1)
    references aa3 (a1) on delete cascade;
    
create table dd3 (
    a1 number,
    d1 number
);
alter table dd3 
add constraint dd3_a1_fk foreign key (a1) 
    references a1(a1);      -- �ڽ� �����Ͱ� ���� ������ �� �θ� �����Ͱ� ����
    
----- ���̺� ����
create table emp
as
select * from employees;    -- null�� ������ ���������� ������� �ʴ´�.
select * from user_constraints where table_name = 'EMP';
select * from emp;

----- delete
-- 33. 100������� �����Ͻÿ�.
delete from emp
where employee_id = 100;

select * from emp where employee_id = 100;

-- 34. ������ IT_PROG�� ������� �����ϼ���.
select * from emp where job_id = 'IT_PROG';
delete from emp where job_id = 'IT_PROG';

-- 35. Neena�� ���� �޿��� �޴� ����� �����Ͻÿ�.
select * from emp 
where salary = (select salary from emp where first_name = 'Neena');

delete from emp 
where salary = (select salary from emp where first_name = 'Neena');

rollback;
-- DML �۾����� ��� ����ϰ� �ȴ�.
commit;
-- DML �۾����� ��� �������ϰ� �ȴ�. (����)
-- �ڵ� commit�� �Ǵ� ��� DDL(create, alter, drop)���� ����� ���,
-- �۾� â�� ���� ���

create table dept 
as          -- ����
select * from departments;

select * from dept;

-- 36. �μ��� Public�� ���Ե� �μ��� ������� ��� �����ϼ���.
select department_id from dept where department_name like '%Public%';

delete from dept        -- delete : �ٸ� ������ �����ص״ٰ� commit�ϸ� �����ϱ� ������ commit�� �ϱ��������� rollback�� �����ϴ�.
where department_id in (select department_id from dept where department_name like '%Public%');

truncate table emp;     -- ���� �ӵ��� �������� ������ �� ����. rollback �Ұ���
select * from emp;

-- 37. ������ ����
insert into emp
select * from employees;

select * from emp;
commit;

------------------- update ---------------
-- 38. emp���� 60�� �μ��� ������� ����ϼ���.
select * from emp where department_id = 60;

--      60�� �μ��� 120�� �μ��� ����
update emp
set department_id = 120
where department_id = 60;

select * from emp where department_id = 60;
select * from emp where department_id = 120;

-- 39. 120�� �μ��� 60�� �μ��� ����
update emp
set department_id = 60
where department_id = 120;

select * from emp where department_id = 60;
select * from emp where department_id = 120;

-- 39. �����ȣ 113�� ����� �μ��� 70�� �μ��� ����
select * from emp where employee_id = 113;
update emp
set department_id = 70
where employee_id = 113;

update emp
set department_id = 130;    -- where �������� ������ ��� ������ ����

select * from emp;

rollback;

-- 40. 205�� ����� ���� ���
select job_id from emp where employee_id = 205;

--     205�� ����� �޿� ���
select salary from emp where employee_id = 205;

-- �̶� 114���� ������ �޿��� 205���� ������ �޿��� �����Ͻÿ�.
select job_id, salary from emp where employee_id = 114;
select job_id, salary from emp where employee_id = 205;

update emp
set job_id = (select job_id from emp where employee_id = 205),
    salary = (select salary from emp where employee_id = 205)
where employee_id = 114;

-- 41. 200�� ����� ������ 140�� ����� ���ӻ�縦 130�� ����� �����Ű����.
update emp
set job_id = (select job_id from emp where employee_id = 200),
    manager_id = (select manager_id from emp where employee_id = 140)
where employee_id = 130;
rollback;

-- 42. employees ���̺� �ִ� 100�� ����� �޿��� 
--     employees ���̺� �ִ� 114�� ����� ������
--     emp ���̺� �ִ� 130�� ������� �����Ű����.
select salary from employees where employee_id = 100;
select job_id from employees where employee_id = 114;

update emp
set salary = (select salary from employees where employee_id = 100),
    job_id = (select job_id from employees where employee_id = 114)
where employee_id = 130;

-- 43. 200�� ����� ���� ������ ���� ������� �μ��� �����ȣ�� 114�� �μ��� �����Ͻÿ�.
update emp
set department_id = (select department_id from emp where employee_id = 114)
where job_id = (select job_id from emp where employee_id = 200);

-- 44. 114���� ������ �޿��� 205�� ����� ���� �����Ͻÿ�.
update emp
set job_id = (select job_id from employees where employee_id = 205),
    salary = (select salary from employees where employee_id = 205)
where employee_id = 114;

rollback;
-- 45. �μ��� ��ҹ��� ���о��� pu�� ���ԵǾ� �ִ� �μ��� �������� 120�� ����� �޿��� �����Ͻÿ�.
update emp
set salary = (select salary from emp where employee_id = 120)
where department_id in (select department_id from dept where lower(department_name) like '%pu%');

--- insert, select, update, delete
---    C       R       U       D     : DML

insert into (select employee_id, first_name, last_name, hire_date, salary, department_id, email, job_id
             from emp
             where department_id = 50)
values(300, 'GilDong', 'Hong', sysdate, 15000, 10, 'hmail', 'AP');  -- �μ��� 10�̾ insert�� ��

insert into (select employee_id, first_name, last_name, hire_date, salary, department_id, email, job_id
             from emp
             where department_id = 50 with check option)  -- with check option : 50�� �μ��� insert
values(300, 'GilDong', 'Hong', sysdate, 15000, 50, 'hmail', 'AP');

----------- DML�� �� -----------
-- DML -- insert, select, update, delete
-- DDL -- create, alter, drop
-- TCL -- rollback, commit, savepoint
-- DCL -- grant, revoke
            -- grant resource, connect, dba to kosa
            -- revoke resource, connect, dba from kosa
rollback;
------------------------------------------------------------------------------------------
delete from emp
where job_id like '%REP%';

select * from emp;

savepoint a;        ----------------------------------------------------------------------- rollback to a;

delete from emp
where department_id = 90;

select * from emp;

savepoint b;        ----------------------------------------------------------------------- rollback to b;

delete from emp;
select * from emp;
rollback to a;
select * from emp;

rollback;

----------- TCL�� �� -----------

--- view object ---
-- 46. �����ȣ, �̸�, �̸���, �Ի���, �޿�, Ŀ�̼�, Ŀ�̼��� ������ ������ ����ϴµ� null���� 0���� ����
--      �μ� �̸��� ��ҹ��� ���о��� 'pu'�� �ִ� �μ��� ����� ���
select employee_id, first_name, email, hire_date, salary, commission_pct, (salary + salary * nvl(commission_pct,0)) * 12
from emp
where department_id in (select department_id from dept where lower(department_name) like '%pu%');

-- 47. 46���� view�� ������
create view vw_pu
as
select employee_id, first_name, email, hire_date, salary, commission_pct, (salary + salary * nvl(commission_pct,0)) * 12 as year_sal
from emp
where department_id in (select department_id from dept where lower(department_name) like '%pu%');

select * from vw_pu;

-- 48. 90�� �μ��� ����� ���� �߿� �̸�, ��ȭ��ȣ, �μ�, �����ȣ�� ����Ͻÿ�.
select first_name, phone_number, department_id, employee_id
from employees
where department_id = 90;

create view vw_90
as
select first_name, phone_number, department_id, employee_id
from employees
where department_id = 90;

select * from vw_90;
-- view : ���̺� �ִ� �����͸� �����ִ� ��
-- view ����� ���� : ���Ȼ� �����Ǹ� �ȵǴ� ����, ������ �����ؼ� ����ϱ� ������ ���