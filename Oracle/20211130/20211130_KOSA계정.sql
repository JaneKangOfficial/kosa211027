 -- ���̺� ���� (���̺�� �����͸� ����)
 create table emp3_7
 as
 select * from employees;
 
 select * from emp3_7;
 
 -- ���̺� ������ ���� (�����ʹ� ���� �ȵ�)(�������� ���� ���)
 create table emp3_8
 as
 select * from employees where 1 = 2;   -- 1 = 2 : ����
 
 select * from emp3_8;
 
 -- ������ ���� (�������� ���� ���)
 -- employees�� �ִ� �����͸� emp3_8�� ����
 insert into emp3_8         -- ���̺��� ������ �� ������ ����
 select * from employees;
 
 select * from emp3_8;
 
 -- �Ϻ� �÷��� ������ ����
 insert into emp3_8(employee_id, last_name, email, hire_date, job_id, salary)
 select employee_id, last_name, email, hire_date, job_id, salary
 from employees;
 
 --=====================================================================
 
--- ���� ����� �ʱ�ȭ
DECLARE
    myname varchar2(20);    -- ��������
BEGIN
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
    myname := 'John';        -- ���� �ʱ�ȭ , BEGIN���� END ���̿����� ��� ����
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
END;
/

DECLARE
    myname varchar2(20) := 'Rhee';    -- ��������
BEGIN
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
    myname := q'\ John's day \';        -- ���� ����    " ' " ����ϱ� : q'\ \'
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
    myname := q'[ John's day ]';        -- ���� ����
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
    myname := q'! John's day !';        -- ���� ����
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
END;
/

DECLARE
    first_name varchar2(20) := 'GilDong';
    last_name varchar2(20) default 'Hong';   -- default�� �̿��ؼ� ���� �ʱ�ȭ
BEGIN
    DBMS_OUTPUT.PUT_LINE(first_name);
    DBMS_OUTPUT.PUT_LINE(last_name);
END;
/

DECLARE
    valid BOOLEAN := true;
BEGIN
    DBMS_OUTPUT.PUT_LINE(valid);    -- ���ڳ� ���ڸ� ��� ����
    valid := false;
    DBMS_OUTPUT.PUT_LINE(valid);    -- BOOLEAN Ÿ�� ��� �Ұ�
END;
/

DECLARE     -- %TYPE : ���̺��� �÷�Ÿ���� ����� ��
    empno employees.employee_id%TYPE;
BEGIN
    empno := 10;
    DBMS_OUTPUT.PUT_LINE(empno);
END;
/

--- ���ε� ����
VARIABLE emp_salary NUMBER      -- DECLARE ���� ���ص� �ȴ�.
BEGIN
    select salary
    into :emp_salary
    from employees
    where employee_id = 107;
END;
/
print emp_salary;   -- ���ε� ������ ����� ��� ���ν����� ����� �Ŀ��� ��� ����
select * from employees
where salary = :emp_salary;


VARIABLE fname NUMBER
VARIABLE lname NUMBER
BEGIN
    :fname := 45;
    :lname := 15;
END;
/
print fname;    -- ���ε� ������ print�� Ȯ�� (DBMS_OUTPUT.PUT_LINE() : ���ε庯���� ���Ұ�)
print lname;


VARIABLE deptno NUMBER
SET AUTOPRINT ON    -- ���ε� ������ ���� ���� ���, print ���� ��� ����
BEGIN
    select department_id 
    into :deptno
    from employees
    where employee_id = 100;
END;
/

--- PL/SQL ���ڵ� ����
-- �ʵ� ������ ���� ������ ó��
-- ���ڵ� �ȿ� ���� : �ʵ� / �ʵ� ���� : ���ڵ�
DECLARE
    TYPE emp_record_type is RECORD(     -- ����� �ڷ���
        employee_id NUMBER NOT NULL := 100,
        last_name employees.last_name%TYPE,
        job_id employees.job_id%TYPE
    );
    emp_record emp_record_type;
BEGIN
    emp_record.employee_id := 10;
    emp_record.last_name := 'Rhee';
    emp_record.job_id := 'AP';
    DBMS_OUTPUT.PUT_LINE(emp_record.employee_id);
    DBMS_OUTPUT.PUT_LINE(emp_record.last_name);
    DBMS_OUTPUT.PUT_LINE(emp_record.job_id);
END;
/

DECLARE
    TYPE emp_record_type is RECORD(     -- ����� �ڷ���
        employee_id NUMBER NOT NULL := 100, -- �ʵ�
        last_name employees.last_name%TYPE,
        job_id employees.job_id%TYPE
    );
    emp_record emp_record_type;     -- ���ڵ� ������   ���ڵ� Ÿ��
BEGIN
    select employee_id, last_name, job_id
    into emp_record.employee_id, emp_record.last_name, emp_record.job_id
    from employees
    where employee_id = emp_record.employee_id;
    DBMS_OUTPUT.PUT_LINE(emp_record.employee_id);
    DBMS_OUTPUT.PUT_LINE(emp_record.last_name);
    DBMS_OUTPUT.PUT_LINE(emp_record.job_id);
END;
/

--- %ROWTYPE
-- �⺻ �����ͺ��̽� ���� ������ ����
-- SELECT * ���� ����Ͽ� ���� �˻��� �� �����մϴ�.
DECLARE
    emp_rec employees%ROWTYPE;
BEGIN
    select * into emp_rec
    from employees
    where employee_id = &employee_id;
    
    insert into emp3_7(
    employee_id, last_name, email, hire_date, salary, job_id)
    values(
    emp_rec.employee_id, emp_rec.last_name, emp_rec.email, emp_rec.hire_date, emp_rec.salary, emp_rec.job_id);
END;
/
select * from emp3_7;

DECLARE
    emp_rec emp3_7%ROWTYPE;
BEGIN
    select * into emp_rec
    from employees
    where employee_id = &empid;
    
    insert into emp3_7 
    values emp_rec;
END;
/

select * from emp3_7 where employee_id = 178;

-- ���ڵ带 ����Ͽ� ���̺��� �� ����
DECLARE
    emp_rec emp3_7%ROWTYPE;
BEGIN
    emp_rec.hire_date := sysdate;
    update emp3_7
    set hire_date = emp_rec.hire_date
    where employee_id = &empid;
END;
/
select * from emp3_7 where employee_id = 100;

-- INDEX BY ���̺� : �������� ���� �����ϱ� ���� ���̺�
-- ���� �Ǵ� ���ڿ� ������ ������ Primary Key
-- �� �ڷ��� : BINARY_INTEGER �� PLS_INTEGER : ũ�Ⱑ �۾ƾ� �ϱ� ������

DECLARE
    TYPE dept_table_type IS TABLE OF
        departments%ROWTYPE     -- departments�� �ִ� ��� �÷�
        INDEX BY PLS_INTEGER;   -- �������� ���� ���� ������ index(pk)�� �ʿ��ϴ�.
    dept_table dept_table_type; -- dept_table_type �� Ÿ���� dept_table ������ ��´�.
    max_count NUMBER(3) :=  20;
BEGIN
    for i in 1..max_count loop
        select * into dept_table(i)
        from departments where department_id = i * 10;
    end loop;
    for i in dept_table.first..dept_table.last loop
        insert into dept3_1 values dept_table(i);
    end loop;
END;
/
select * from departments;
create table dept3_1
as
select * from departments where 1=2;
select * from dept3_1;

-- ����� Ŀ�� : �� �����͸� �������� ������ �� �ִ�. Ŀ���� SELECT���� ���
-- open (BOF : Begin Of File), close (EOF : End Of File)
DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, last_name 
        FROM employees
        where department_id = 30;
    empno employees.employee_id%TYPE;
    lname employees.last_name%TYPE;
BEGIN
    OPEN emp_cursor;
    FETCH emp_cursor    -- ���� Ŀ�� �� ��������
    INTO empno, lname;
    DBMS_OUTPUT.PUT_LINE(empno ||' '|| lname);
END;
/

DECLARE
    CURSOR emp_cursor IS
        SELECT * FROM employees
        WHERE department_id = &deptid;
    emp employees%ROWTYPE;
BEGIN
    if not emp_cursor%isopen then   -- Ŀ���� ���� �ִ��� �׽�Ʈ, open �ȵǾ� ������ open ���ּ���.
        open emp_cursor;
    end if;

    OPEN emp_cursor;
    loop
        FETCH emp_cursor 
        INTO emp;
        -- %rowcount : Ŀ���� ������ ������ 1�� �����ϴ� ���� ������. ���ݱ��� ��ȯ�� ���� ��
        EXIT WHEN emp_cursor%notfound or emp_cursor%rowcount > 10;  -- cursor�� ã�� ���ϸ� loop�� �������Ͷ� or 10���� ���ڴ�. �����Ŀ������ EXIT �� �ʿ�
        DBMS_OUTPUT.PUT_LINE(emp.first_name || ' ' || emp.last_name || ' ' || emp.department_id);
    end loop;
    CLOSE emp_cursor;
END;
/

--- subquery�� ����ϴ� Ŀ�� for ����
BEGIN
    for emp_record in (select employee_id, last_name 
                        from employees where department_id = 30) loop
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ' ' || emp_record.last_name);              
    end loop;                        
END;
/

-- �Ķ���Ͱ� ���Ե� Ŀ��
DECLARE
    CURSOR emp_cursor(deptno NUMBER) is
        select *
        from employees
        where department_id = deptno;
    emp employees%rowtype;
BEGIN
    OPEN emp_cursor(10);        -- cursor open �Ŀ� loop
    loop
        FETCH emp_cursor into emp;
        EXIT WHEN emp_cursor%notfound;
        DBMS_OUTPUT.PUT_LINE(emp.employee_id|| ' ' || emp.first_name || ' ' || emp.department_id);
    end loop;
END;
/

DECLARE
    CURSOR emp_cursor(deptno NUMBER) is
        select * from employees
        where department_id = deptno;
BEGIN
    for emp in emp_cursor(10) loop  -- cursor�� for������ open
        DBMS_OUTPUT.PUT_LINE(emp.employee_id|| ' ' || emp.first_name || ' ' || emp.department_id);
    EXIT WHEN emp_cursor%notfound;
    end loop;
END;
/

--- �Ķ���Ͱ� �ִ� Ŀ���� ���� �� �μ� ��ȣ�� ������ �޵����ϰ� 
-- �̸�, ����, �μ���ȣ�� �μ���ȭ�� ������ �ش��ϴ� ����� ��µǰ� �ϼ���.
DECLARE
    CURSOR emp_cursor(deptno NUMBER, jobno VARCHAR2) is
        select * from employees
        where department_id = deptno and job_id = jobno;
BEGIN
    for emp in emp_cursor(30, 'PU_CLERK') loop
        DBMS_OUTPUT.PUT_LINE(emp.first_name|| ' ' || emp.job_id || ' ' || emp.department_id);
    end loop;
END;
/

select * from emp3_7
for update nowait;  -- select �ϴ� ���� �ٸ� ����ڰ� update, delete ���� ���ϵ��� ���´�. : ���
--for update;       -- ���� ���������� �ؾ� �ٸ� ����ڰ� update, delete �� �� �ִ�.

-- SQL ===============
conn /as sysdba;     -- sqlplus ��й�ȣ ���� system �������� ���� (������ ���� ��й�ȣ �𸦽�)
show user;           -- user Ȯ��
-- SQL ===============

-- Ŀ�� ����� �� ���
DECLARE
    CURSOR emp_cursor is
        select * from emp3_7
        where department_id = 80 FOR UPDATE OF salary;  -- ���� select �ϴ� ���� �ٸ� ����ڰ� salary update ���� ���ϵ��� ���
        emp emp3_7%rowtype;
BEGIN
    OPEN emp_cursor;
    loop
        FETCH emp_cursor into emp;
        EXIT when emp_cursor%notfound;
        DBMS_OUTPUT.PUT_LINE(emp.last_name || ' ' || emp.salary);
    end loop;
END;
/

DECLARE
    CURSOR emp_cursor (deptno NUMBER) is
        select * from emp3_7
        where department_id = deptno
        FOR UPDATE;     -- update�� �� �־�� �Ѵ�.
    emp emp3_7%rowtype;
BEGIN
    OPEN emp_cursor(10);
    loop
        FETCH emp_cursor into emp;
        EXIT when emp_cursor%notfound;  -- ������ ���ѷ��� : "invalid ROWID"
        update emp3_7 
        set salary = salary * 1.1
        where CURRENT OF emp_cursor;    -- ���� Ŀ���� �ش��ϴ� ���� update
    end loop;
END;
/

-- EXCEPTION (Oracle 10g PL&SQL Fundmentals(K).pdf - p235 ����)
DECLARE
    lname VARCHAR2(15);
BEGIN
    select last_name into lname from employees
    where first_name = 'John';  -- ���ν����� �����ุ ����Ѵ�. ��Ƽ�� ����Ϸ��� index table ���
    DBMS_OUTPUT.PUT_LINE(lname); -- ���� ������ �䱸�� �ͺ��� ���� ���� ���� �����մϴ�(��Ƽ���̶� ���� �߻�)
    EXCEPTION
    when TOO_MANY_ROWS then
    DBMS_OUTPUT.PUT_LINE('���� ���� �ʹ� ���ƿ�');
    when NO_DATA_FOUND then
    DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�.');
    when INVALID_CURSOR or ZERO_DIVIDE or DUP_VAL_ON_INDEX then
    DBMS_OUTPUT.PUT_LINE('Ŀ���� ��Ȯ���� �ʽ��ϴ�. 0���� ������ ����. index�� �ߺ���.');
    when others then
    DBMS_OUTPUT.PUT_LINE('������');
END;
/

-- ������ ����
CREATE SEQUENCE DEPT_NUM
INCREMENT BY 10
start WITH 400;

--- ���ν���(��ȯ�� ����) �� �Լ�(��ȯ�� ����) (p256)
CREATE or REPLACE PROCEDURE add_dept
is
    dept_id dept.department_id%TYPE;
    dept_name dept.department_name%TYPE;
BEGIN
    dept_id := 320;
    dept_name := '���ߺ�';
    INSERT INTO dept(department_id, department_name)
    values (dept_num.nextval, dept_name);       -- ������ ���
    DBMS_OUTPUT.PUT_LINE('Inserted ' || SQL%ROWCOUNT || ' row');
END;
/
exec add_dept;  -- �Լ� ȣ��
select * from dept where department_id = 320;
select * from dept;

-- �Ű������� �޾ƿ��� ���ν���
CREATE OR REPLACE PROCEDURE update_sal
(v_empno    IN      NUMBER)     -- ������ IN : ���� �޾ƿ��ڴ�.
is
BEGIN
    UPDATE emp3_7
    SET salary = salary * 1.1
    where employee_id = v_empno;
END;
/
exec update_sal(100);   -- ������ �Ű����� ���� �� ������� �Ѵ�.
select * from emp3_7 where employee_id = 100;


CREATE OR REPLACE PROCEDURE prc_tree
(
    v_emp_code IN VARCHAR2,     -- IN : varchar2 ���� ���ν��� ������ �޾ƿ´�.
    p_code OUT VARCHAR2,        -- OUT : varchar2 ���� ���ν��� ������ ������.
    t_code OUT VARCHAR2
)
is
BEGIN
    select department_id, job_id into p_code, t_code    -- �������� ���� ���� ���ν��� ������ �޾ƿ´�.
    from employees
    where employee_id = v_emp_code;
END prc_tree;
/
DECLARE
    p_code VARCHAR2(20);
    t_code VARCHAR2(20);
BEGIN
    prc_tree('100', p_code, t_code);    -- ���ν������� ���޵� OUT ���� �ޱ� ���� ����(p_code, t_code) ����
    DBMS_OUTPUT.PUT_LINE(p_code || ' ' || t_code);
END;
/

CREATE OR REPLACE PROCEDURE sal_mng
(
    empid IN VARCHAR2,
    sal OUT NUMBER,
    mng OUT NUMBER
)
is
BEGIN
    select salary, manager_id into sal, mng
    from employees
    where employee_id = empid;
END;
/
DECLARE
    aaa number;     -- sal
    bbb number;     -- mng
BEGIN
    sal_mng('110', aaa, bbb);
    DBMS_OUTPUT.PUT_LINE(aaa|| ' ' || bbb);
END;
/

CREATE OR REPLACE PROCEDURE emp_del_proc
(empid in number)
is
BEGIN
    delete from emp3_7
    where employee_id = empid;
    commit;
END;
/
exec emp_del_proc(300);