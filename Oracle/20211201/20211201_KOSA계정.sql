-- �Լ� (p260)
-- (���ν����� return ���� ����, �Լ��� return ���� �ִ�.)
CREATE OR REPLACE FUNCTION check_sal    -- �Ű������� ���� ��� () ���� �ٷ� return�� 
RETURN number               -- boolean Ÿ���� return ���� �޾ƿ� ���� ����.
is
    dept_id employees.department_id%TYPE;
    emp_no employees.employee_id%TYPE;
    sal employees.salary%TYPE;
    avg_sal employees.salary%TYPE;
BEGIN
    -- 100�� ����� �޿�, �μ�
    emp_no := 100;
    SELECT salary, department_id
    into sal, dept_id
    from employees
    where employee_id = emp_no;
    
    -- 100�� ��� �μ��� ��� �޿�
    select avg(salary)
    into avg_sal
    from employees
    where department_id = dept_id;
    
    if sal > avg_sal then
        return 1;
    else
        return 0;
    end if;
END;
/
-- return boolean Ÿ�� �ƴ� ��� exec ���
var aaa varchar2(20);
exec :aaa := check_sal();
print aaa;
-- return boolean Ÿ���� ��� if�� ���
begin
    if(check_sal is null) then
        DBMS_OUTPUT.PUT_LINE('check_sal�� null�Դϴ�.');
    elsif (check_sal) then
        DBMS_OUTPUT.PUT_LINE('salary > average');
    else
        DBMS_OUTPUT.PUT_LINE('salary < average');
    end if;
end;
/

CREATE OR REPLACE FUNCTION FC_update_sal
(v_empno    in      number)
return number
is
    sal employees.salary%TYPE;
BEGIN
    update emp3_7
    set salary = salary * 1.1
    where employee_id = v_empno;
    
    -- return �ϱ� ����
    select salary into sal
    from emp3_7
    where employee_id = v_empno;
    
    return sal;     -- FUNCTION�� return���� �� �����ؾ� �մϴ�.
END;
/
var sal1 number;
exec :sal1 := FC_update_sal(110);
print sal1;

-- EMP3_7 ���̺��� �̸����� �μ� ��ȣ�� �˻��ϴ� �Լ��� �ۼ��Ͻÿ�.
CREATE OR REPLACE FUNCTION search_deptno
(fname      in       employees.first_name%TYPE)
return number
is
    deptno employees.department_id%TYPE;
BEGIN
    select department_id
    into deptno
    from employees
    where first_name = fname;
    
    return deptno;    
EXCEPTION
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�.');
    WHEN too_many_rows THEN
        DBMS_OUTPUT.PUT_LINE('�����Ͱ� 2�� �̻��Դϴ�.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('��Ÿ �����Դϴ�.');
END;
/
select * from emp3_7;
var n number;
exec :n := search_deptno('Neena');
print n;

-- EMP3_7 ���̺��� �̸��� �Է� �޾� �μ���ȣ, �μ���, �޿��� ����ϴ� FUNCTION�� �ۼ��Ͻÿ�.
-- ��, �μ���ȣ�� RETURN�� ���
CREATE OR REPLACE FUNCTION search_emp
(
    v_fname  in  employees.first_name%TYPE,
    v_deptna out departments.department_name%TYPE,
    v_sal out employees.salary%TYPE
)
return number               -- department_id �� return ���� �޴´�.
is
    v_deptno employees.department_id%TYPE;
    v_deptna_temp departments.department_name%TYPE;
    v_sal_temp employees.salary%TYPE;
BEGIN
    select salary, department_id
    into v_sal_temp, v_deptno
    from employees
    where upper(first_name) = upper(v_fname);
    
    select department_name
    into v_deptna_temp
    from departments
    where department_id = v_deptno;
    
    v_deptna := v_deptna_temp;   -- output ������ ����, return�� �ϳ��� ����(department_id) �����ϱ� ������ 
    v_sal := v_sal_temp;         -- output ������ ����, ����ϱ� ���� output ������ ������
    DBMS_OUTPUT.PUT_LINE('��   �� : ' || v_fname);
    DBMS_OUTPUT.PUT_LINE('�μ���ȣ : ' || to_char(v_deptno));
    DBMS_OUTPUT.PUT_LINE('�� �� �� : ' || v_deptna_temp);
    DBMS_OUTPUT.PUT_LINE('��   �� : ' || to_char(v_sal_temp, '$999,999'));

    return v_deptno;
EXCEPTION
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�.');
    WHEN too_many_rows THEN
        DBMS_OUTPUT.PUT_LINE('�����Ͱ� 2�� �̻��Դϴ�.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('��Ÿ �����Դϴ�.');
END;
/
VAR g_deptno NUMBER;
VAR g_dname VARCHAR2(20);
VAR g_sal NUMBER;
EXECUTE :g_deptno := search_emp('Neena',:g_dname,:g_sal)
PRINT g_dname;
print g_sal;
print g_deptno;

-- �Ի��� ���ϴ� �Լ��� ����� ����, �����ȣ�� �̿�
CREATE OR REPLACE FUNCTION search_hdate
(
    v_empid number,
    v_fmt varchar2       -- ��¥ ����
)
return varchar2
is
    v_hdate varchar2(20);
BEGIN
    select to_char(hire_date, v_fmt)
    into v_hdate
    from employees
    where employee_id = v_empid;
    
    return v_hdate;
END;
/
var h varchar2(20);
exec :h := search_hdate(100, 'dd-mm-yyyy');
print h;


-- �������
CREATE OR REPLACE FUNCTION year_sal
(v_empid number)
return number
is
    v_sal number;
BEGIN
    select salary * (1 + nvl(commission_pct,0)) * 12
    into v_sal
    from employees
    where employee_id = v_empid;
    
    return v_sal;
END;
/
var v number;
exec :v := year_sal(100);
print v;

-- �����޿����
CREATE OR REPLACE FUNCTION refire_money
(v_empno number)
return number
is
    v_sal number;
BEGIN
    select round(salary * (1 + nvl(commission_pct,0)) *
            round(months_between(sysdate, hire_date), 0) /12, 0)
    into v_sal
    from employees
    where employee_id = v_empno;
    
    return v_sal;
END;
/
var refire number;
exec :refire := refire_money(100);
print refire;

--- TRIGGER (�ڵ� update ���ν���)
-- old ���̺� : ���� �� �����ͳ� ������ ������
-- new ���̺� : ����ǰų� ���� �Էµ� ������
-- emp3_7(old ���̺�)�� data�� update �ȴٸ� emp3_8(new ���̺�)�� data�� �ڵ� update
insert into emp3_8
select * from employees;

select * from emp3_8;

CREATE OR REPLACE TRIGGER emp_tri_row
after update of salary on emp3_7        -- 1. emp3_7(old ���̺�)�� salary�� update�� �ȴٸ�
for each row                        -- �������� ����࿡ ���ؼ� Ʈ���� ����
BEGIN
    if :old.salary < :new.salary then
        update emp3_8                   -- 2. emp3_8(new ���̺�) �ڵ� update
        set salary = :old.salary * 1.1
        where employee_id = :new.employee_id;
    end if;
END;
/
select * from emp3_7 where employee_id = 174;
select * from emp3_8 where employee_id = 174;

update emp3_7
set salary = 12000
where employee_id = 174;

select * from emp3_7 where employee_id = 174;
select * from emp3_8 where employee_id = 174;

-- emp3_7�� 170�� ����� �����͸� employees ���̺��� �ҷ��� �����Ѵٸ�
-- emp3_8���� 170�� ����� �����Ͱ� ����ǰ� �Ͻÿ�.
delete from emp3_7 where employee_id = 170;
delete from emp3_8 where employee_id = 170;

CREATE OR REPLACE TRIGGER emp_test_ins
after insert on emp3_7      -- emp3_7(old ���̺�)�� insert�� �߻��� �Ŀ�
for each row
BEGIN
    insert into emp3_8
    select * from employees where employee_id = :new.employee_id;
END;
/
insert into emp3_7
select * from employees where employee_id = 170;

select * from emp3_7 where employee_id = 170;
select * from emp3_8 where employee_id = 170;

-- emp3_7 ���̺� employees ���̺��� 145�� ����� �����͸� �����ϰ�
-- emp3_7�� �ִ� 145�� ����� Ŀ�̼��� 0.5�� ������ �� ���� �� ���� ���� �� ������ ���� ��� 
-- emp3_8�� 145����� �޿��� 15% �λ��Ͽ� �����Ͻÿ�.
CREATE OR REPLACE TRIGGER emp_aft_udt_row
after update of commission_pct on emp3_7
for each row
BEGIN
    if :old.commission_pct < :new.commission_pct then
        update emp3_8
        set salary = salary * 1.15
        where employee_id = :new.employee_id;
    end if;
END;
/
select * from emp3_8 where employee_id = 145;

update emp3_7
set commission_pct = 0.5
where employee_id = 145;

select * from emp3_8 where employee_id = 145;

-- emp3_7 ���̺� 151�� ����� ������ 'ST_CLERK'�� ����Ǿ��ٸ� emp3_8�� Ŀ�̼��� 0.6���� ����
CREATE OR REPLACE TRIGGER test_up_tri
after update of job_id on emp3_7
for each row
BEGIN
    if :new.job_id = 'ST_CLERK' then
        update emp3_8
        set commission_pct = 0.6
        where employee_id = :new.employee_id;
    end if;
END;
/
select * from emp3_7 where employee_id = 151;
select * from emp3_8 where employee_id = 151;

update emp3_7 set job_id = 'ST_CLERK'
where employee_id = 151;

select * from emp3_8 where employee_id = 151;

--
create table emp_empty
as
select * from employees where 1 = 2;

CREATE OR REPLACE TRIGGER emp_test_del
after delete on emp3_7
for each row
BEGIN
    insert into emp_empty(employee_id, last_name, email, hire_date, job_id)
    values (:old.employee_id, :old.last_name, :old.email, :old.hire_date, :old.job_id);
END;
/
delete from emp3_7 where employee_id = 110;
select * from emp_empty;

--
create table old_new
(
    old_first_name varchar2(20),
    new_first_name varchar2(20)
);

CREATE OR REPLACE TRIGGER emp_test_upd
after update on emp3_7
for each row
BEGIN
    insert into old_new
    values (:old.first_name, :new.first_name);
END;
/
delete from old_new;
select * from old_new;
update emp3_7
set first_name = 'Hong'
where employee_id = 100;
select * from old_new;

--
CREATE OR REPLACE TRIGGER emp_test_ins
AFTER INSERT ON emp3_7
FOR EACH ROW
BEGIN
    insert into emp_empty(employee_id, last_name, email, hire_date, job_id)
    values(:new.employee_id, :new.last_name, :new.email, :new.hire_date, :new.job_id);  -- emp3_7 data
END;
/
select * from emp_empty;

insert into emp3_7 
select * from employees where employee_id = 200;

select * from emp_empty where employee_id = 200;