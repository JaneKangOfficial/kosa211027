--- PL / SQL
DECLARE
    v_fname varchar2(20);
BEGIN
    SELECT first_name
    INTO    v_fname     -- first_name ������� v_fname ������ �����ϰڽ��ϴ�.
    FROM employees
    WHERE employee_id = 100;
    DBMS_OUTPUT.PUT_LINE(v_fname);      -- v_fname ������ �ش��ϴ� ���� ����ϰڽ��ϴ�.
END;
/   -- ��������� ���ν����Դϴ�.

DECLARE
/*  ���ν��� �������� �ּ�
--    emp_hiredate date;      -- �ʱⰪ ���� ���
--    vn_num1 NUMBER := 1;    -- ���� �ʱⰪ ����
--    emp_deptno NUMBER(2) not null := 10;
--    c_comm CONSTANT NUMBER := 1400;     -- ��� ����
*/
    vn_num1 NUMBER := 1;    -- ���� �ʱⰪ ����
    vn_num2 NUMBER := 2;
BEGIN
    if vn_num1 >= vn_num2 then 
        DBMS_OUTPUT.PUT_LINE(vn_num1 || '�� ū �� �Դϴ�.');
    else
        DBMS_OUTPUT.PUT_LINE(vn_num2 || '�� ū �� �Դϴ�.');
    end if;
END;
/

DECLARE
    employee_id number(6);      -- ���� �̸��� �ĺ��ڴ� ������� �ʴ� ���� ����.
BEGIN
    select employee_id          -- ���� ���̺��� �ƴ� �ٸ� ���̺��� ��� ���������� ����ϴ� ���� ����.
    into employee_id
    from employees
    where last_name = 'Kochhar';
    DBMS_OUTPUT.PUT_LINE(employee_id);
END;
/

DECLARE
    num1 number(10,3);
    bf_var BINARY_FLOAT;
    bd_var BINARY_DOUBLE;
BEGIN
    num1 := 270/35;
    bf_var := 270/35f;
    bd_var := 140d/0.35;
    DBMS_OUTPUT.PUT_LINE('number : ' || num1);
    DBMS_OUTPUT.PUT_LINE('bf : ' || bf_var);
    DBMS_OUTPUT.PUT_LINE('bd : ' || bd_var);
END;
/
-- BINARY_FLOAT, BINARY_DOUBLE : NUMBER ������ �������� ������ �� �ִ� �� ������ ��� ���� �����մϴ�.

--- %TYPE �Ӽ�
-- �����ͺ��̽� �� ����
-- �����(���� ���ǵ�) �ٸ� ���� 
-- empl_lname employees.last_name%TYPE;
-- balance NUMBER(7,2);
-- min_balance balance%TYPE := 1000;

DECLARE
    v_lastname employees.last_name%TYPE;
    v_firstname employees.first_name%TYPE;
BEGIN
    select last_name, first_name
    into v_lastname, v_firstname
    from employees
    where employee_id = 143;
    DBMS_OUTPUT.PUT_LINE(v_lastname);
    DBMS_OUTPUT.PUT_LINE(v_firstname);
END;    
/

DECLARE
    flag BOOLEAN := FALSE;
BEGIN
    flag := TRUE;
--    DBMS_OUTPUT.PUT_LINE(flag); -- boolean type�� ��� �Ұ�.
END;
/

--- ���ε� ����
-- ȣ��Ʈ ������� �Ѵ�.
-- VARIABLE Ű���带 ����Ͽ� ����
-- PL/SQL ����� ����� �Ŀ��� �׼����� �� �ִ�.
-- VARIABLE return_code NUMBER
-- VARIABLE return_msg VARCHAR2(30)

VARIABLE emp_salary NUMBER
SET AUTOPRINT ON
BEGIN
    select salary 
    into :emp_salary    -- VARIABLE ���ε� ���� ����� �� ":" �־�� �Ѵ�. ���ε� �������� �˷��ش�.
    from employees
    where employee_id = 143;
    -- emp_salary �� DECLARE�� ����Ǿ� �־�� �Ѵ�.
END;
/

--- ġȯ ����   ( = Scanner , ���� �Է� ����)
-- ���� �Է��� ��µ� ����ϴ� ����
-- �տ� ���ۻ���(&)�� �ٿ� PL/SQL ��� ������ ����
-- ���� �߿� ���� �� �ִ� ���� ���� �ڵ��ϴ� ���� ���� �� �ִ�.
VARIABLE emp_salary NUMBER
SET AUTOPRINT ON
DECLARE
    empno NUMBER(6) := &empno;  -- ġȯ ����
BEGIN
    select salary 
    into :emp_salary
    from employees
    where employee_id = empno;
END;
/

SET VERIFY OFF
VARIABLE emp_salary NUMBER
ACCEPT empno PROMPT '�����ȣ�� �Է����ּ��� : '
SET AUTOPRINT ON
DECLARE
    empno NUMBER(6) := &empno;  -- ġȯ ����
BEGIN
    select salary 
    into :emp_salary
    from employees
    where employee_id = empno;
END;
/

DECLARE
    outer_variable VARCHAR2(20) := 'GLOBAL VARIABLE';
BEGIN
    DECLARE
        inner_variable VARCHAR2(20) := 'LOCAL VARIABLE';
    BEGIN
        DBMS_OUTPUT.PUT_LINE(inner_variable);
        DBMS_OUTPUT.PUT_LINE(outer_variable);
    END;
    DBMS_OUTPUT.PUT_LINE(outer_variable);
END;
/
/* 
LOCAL VARIABLE
GLOBAL VARIABLE
GLOBAL VARIABLE 
*/

DECLARE
    fname varchar2(20) := 'Patrick';
    hdate date := '2000-01-20';
BEGIN
    DECLARE
        lname varchar2(20) := 'Mike';
        hdate date := '2001-12-25';
    BEGIN
        DBMS_OUTPUT.PUT_LINE(lname);    
        DBMS_OUTPUT.PUT_LINE(hdate);    -- ���� �̸��� ������ ����� ��� : ���� �� �ȿ� �ִ� ���� �켱�Ѵ�.
        DBMS_OUTPUT.PUT_LINE(fname);
    END;
    DBMS_OUTPUT.PUT_LINE(hdate);
END;
/
/*
Mike
01/12/25
Patrick
00/01/20
*/

BEGIN <<OUTER>>     -- �������� ��,�� ���� ���(hdate) ��� : �ĺ����� ��Ȯ�� ����
DECLARE
    fname varchar2(20) := 'Patrick';
    hdate date := '2000-01-20';
BEGIN
    DECLARE
        lname varchar2(20) := 'Mike';
        hdate date := '2001-12-25';
    BEGIN
        DBMS_OUTPUT.PUT_LINE(lname);
        DBMS_OUTPUT.PUT_LINE(hdate);    -- ���� �̸��� ������ ����� ��� : ���� �� �ȿ� �ִ� ���� �켱�Ѵ�.
        DBMS_OUTPUT.PUT_LINE(outer.hdate);
        DBMS_OUTPUT.PUT_LINE(fname);
    END;
    DBMS_OUTPUT.PUT_LINE(hdate);
END;
END OUTER;
/
/*
Mike
01/12/25
00/01/20
Patrick
00/01/20
*/

SET SERVEROUTPUT ON
DECLARE
    sum_sal NUMBER(10,2);
    deptno NUMBER NOT NULL := 60;
BEGIN
    select sum(salary)      -- group function
    into sum_sal
    from employees
    where department_id = deptno;
    DBMS_OUTPUT.PUT_LINE('60 �μ��� �޿� �հ�� ' ||sum_sal);
END;
/

DECLARE     -- ���� �̸��� �÷���, ������ ������� �ʴ� ���� ���� : ��ȣ���� ����
-- �����ͺ��̽� �� �̸��� �ĺ��ڷ� ������� �ʴ´�.
-- ���� ������ ���� �Ķ������ �̸��� �����ͺ��̽� ���̺��� �̸����� �켱 (�������� �켱)
    hire_date employees.hire_date%TYPE;
    sysdate hire_date%TYPE;
    employee_id employees.employee_id%TYPE := 176;
BEGIN
    SELECT hire_date, sysdate
    INTO hire_date, sysdate
    FROM employees
    WHERE employee_id = employee_id;
END;
/

CREATE SEQUENCE employees_seq;

BEGIN
INSERT INTO emp
    (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    VALUES (employees_seq.NEXTVAL, 'Ruth', 'Cores', 'RCORES', sysdate, 'AD_ASST', 4000);
END;
/

select * from emp;

ACCEPT fname PROMPT '��� �̸��� �Է����ּ��� : '
ACCEPT lname PROMPT '��� ���� �Է����ּ��� : '
ACCEPT mail PROMPT '��� �̸����� �Է����ּ��� : '
ACCEPT hdate PROMPT '��� �Ի����� yyyy-mm-dd �������� �Է����ּ��� : '
ACCEPT jid PROMPT '��� ������ �Է����ּ��� : '
ACCEPT sal PROMPT '��� �޿��� �Է����ּ��� : '
DECLARE
    fname employees.first_name%TYPE := &fname;      -- ġȯ����
    lname employees.last_name%TYPE := &lname;
    mail employees.email%TYPE := &mail;
    hdate employees.hire_date%TYPE := &hdate;
    jid employees.job_id%TYPE := &jid;
    sal employees.salary%TYPE := &sal;
BEGIN
INSERT INTO emp
    (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    VALUES (employees_seq.NEXTVAL, fname, lname, mail, hdate, jid, sal);
    DBMS_OUTPUT.PUT_LINE('���������� ����Ǿ����ϴ�.');
END;
/

DECLARE
    sal_increase employees.salary%TYPE := 800;
BEGIN
    UPDATE employees
    SET salary = salary + sal_increase
    WHERE job_id = 'ST_CLERK';
    DBMS_OUTPUT.PUT_LINE('ST_CLERK �����Ͱ� �����Ǿ����ϴ�.');
END;
/

DECLARE
    empid emp.employee_id%TYPE := 1;
BEGIN
    DELETE FROM emp
    WHERE employee_id = empid;
    DBMS_OUTPUT.PUT_LINE(empid || '�� ����� �����Ǿ����ϴ�.');
END;
/

DECLARE
    empno emp.employee_id%TYPE := 200;
BEGIN
merge into ex3_6 a
    using (select * from emp where employee_id = empno) b
    on (a.employee_id = b.employee_id)
WHEN MATCHED THEN
    update set salary = salary * 1.1
WHEN not MATCHED THEN
    insert (a.employee_id, a.emp_name, a.salary, a.manager_id)     -- merge 'into'�� �־ insert 'into'�� �� ��� �ȴ�.
    values (b.employee_id, b.first_name, 15000, 100);
END;
/

select * from ex3_6;

DECLARE
    myage number := 31;
BEGIN
    if myage < 11 then
        DBMS_OUTPUT.PUT_LINE('���� 11�� �̸��Դϴ�.');
    else
        DBMS_OUTPUT.PUT_LINE('���� ���̴� ' || myage || '�� �Դϴ�');
    end if;
END;
/

-- �޿��� 1000���� ���� ���� 3���ϸ� ���, 5���ϸ� ����, 7���ϸ� �븮, 9���ϸ� ����, 10���ϸ� ����, 13���ϸ� ����, 15���ϸ� ������, �׿� �̻�
-- 130�� ���, ���ν����� ���� ����ϼ���.
DECLARE
    empid emp.employee_id%TYPE := 130;
    sal number;
BEGIN
    select trunc(salary/1000)
    into sal
    from employees
    where employee_id = empid;
    DBMS_OUTPUT.PUT_LINE(sal);
    if sal <= 3 then
        DBMS_OUTPUT.PUT_LINE('���');
    elsif sal <= 5 then
        DBMS_OUTPUT.PUT_LINE('����');
    elsif sal <= 7 then
        DBMS_OUTPUT.PUT_LINE('�븮');
    elsif sal <= 9 then
        DBMS_OUTPUT.PUT_LINE('����');
    elsif sal <= 10 then
        DBMS_OUTPUT.PUT_LINE('����');    
    elsif sal <= 13 then
        DBMS_OUTPUT.PUT_LINE('����');
    elsif sal <= 15 then
        DBMS_OUTPUT.PUT_LINE('������');
    else
        DBMS_OUTPUT.PUT_LINE('�̻�');
    end if;
END;
/

-- �޿��� 1000���� ���� ���� 3���ϸ� ���, 5���ϸ� ����, 7���ϸ� �븮, 9���ϸ� ����, 10���ϸ� ����, 13���ϸ� ����, 15���ϸ� ������, �׿� �̻�
-- 130�� ���, ���ν����� ���� ����ϼ���. case������

DECLARE
    empid emp.employee_id%TYPE := 130;
    grade varchar2(20);
BEGIN
    select 
    case when trunc(salary / 1000) <= 3 then '���'
         when trunc(salary / 1000) <= 5 then '����'
         when trunc(salary / 1000) <= 7 then '�븮'
         when trunc(salary / 1000) <= 9 then '����'
         when trunc(salary / 1000) <= 10 then '����'
         when trunc(salary / 1000) <= 13 then '����'
         when trunc(salary / 1000) <= 15 then '������'
         else '�̻�' end
    into grade
    from emp
    where employee_id = empid;
    DBMS_OUTPUT.PUT_LINE('������ ��å�� : ' || grade);
END;   
/

DECLARE
    grade CHAR(1) := UPPER('&grade');
    result1 VARCHAR2(30);
BEGIN
    result1 :=
    case grade 
        when 'A' then '90�� �̻��Դϴ�.'
        when 'B' then '80�� �̻��Դϴ�.'
        when 'C' then '70�� �̻��Դϴ�.'
        when 'D' then '60�� �̻��Դϴ�.'
        when 'F' then '60�� �̸��Դϴ�.'
    end;
    DBMS_OUTPUT.PUT_LINE('grade : ' || grade || '�� �� ' || result1);
END;
/

DECLARE
    empid emp.employee_id%TYPE := &empid;
    sal number;
    result1 varchar2(30);
BEGIN
    select trunc(salary/1000)
    into sal
    from employees
    where employee_id = empid;
    DBMS_OUTPUT.PUT_LINE(sal);
    /* case�� �����Ͻÿ� */
    result1 :=
    case when sal <= 3 then '���'
         when sal <= 5 then '����'
         when sal <= 7 then '�븮'
         when sal <= 9 then '����'
         when sal <= 10 then '����'
         when sal <= 13 then '����'
         when sal <= 15 then '������'
         else '�̻�'
    end;
    DBMS_OUTPUT.PUT_LINE('������ ��å�� : ' || result1 ||'�Դϴ�.');
END;
/

DECLARE
    grade CHAR(1) := UPPER('&grade');
BEGIN
    case
        when grade = 'A' then DBMS_OUTPUT.PUT_LINE('Excellent');
        when grade in ('B','C') then DBMS_OUTPUT.PUT_LINE('Good');
        else DBMS_OUTPUT.PUT_LINE('No such grade');
    end case;
END;
/

--- �μ��� ��ȣ�� �Է� �޾Ƽ� �μ����� �μ���ȣ�� �μ��̸��� �������� �� �μ��� ������� ������ ������.
-- 108�� �μ����� �μ��� 90���̰� �μ����� �������̸� ������� 20���Դϴ�.
select * from departments where manager_id is not null;

DECLARE
    mngid departments.manager_id%TYPE := &mngid;
    deptid NUMBER;
    deptname VARCHAR2(20);
    emps NUMBER;
BEGIN
    case mngid
        when 200 then 
            select department_id, department_name
            into deptid, deptname
            from departments
            where manager_id = mngid;
            select count(*) 
            into emps
            from employees 
            where department_id = deptid;            
        when 201 then 
            select department_id, department_name
            into deptid, deptname
            from departments
            where manager_id = mngid;
            select count(*) 
            into emps
            from employees 
            where department_id = deptid;            
        when 203 then 
            select department_id, department_name
            into deptid, deptname
            from departments
            where manager_id = mngid;
            select count(*) 
            into emps
            from employees 
            where department_id = deptid;
    end case;        
    DBMS_OUTPUT.PUT_LINE(mngid||'�� �μ����� �μ��� ' ||deptid||'�̰� �μ����� ' ||deptname||'�̸� ������� '||emps||'���Դϴ�.');
END;
/

--- LOOP
-- �⺻ LOOP�� (���� LOOP)
DECLARE
    counter NUMBER(2) := 1;     -- ���� ����
    empid NUMBER(6) := &empid;
    eid NUMBER;
    fname VARCHAR2(20);
    sal NUMBER;
    mngid NUMBER;
BEGIN
    LOOP
        select employee_id, first_name, salary, manager_id
        into eid, fname, sal, mngid
        from employees
        where employee_id = empid + counter;
        insert into ex3_6
        values(eid, fname, sal, mngid);
        counter := counter + 1;   
        EXIT WHEN counter > 3;      -- EXIT : Ż���ϱ� ���� ������ �� �ʿ��ϴ�.
    END LOOP;
END;
/
delete from ex3_6;
select * from ex3_6;
commit;

-- while Loop��
DECLARE
    counter NUMBER(2) := 1;
    empid number(6) := &empid;
    eid number;
    fname varchar2(20);
    sal number;
    mngid number;
BEGIN
    while counter <= 3 loop
        select employee_id, first_name, salary, manager_id
        into eid, fname, sal, mngid
        from employees
        where employee_id = empid + counter;
        insert into ex3_6
        values(eid, fname, sal, mngid);
        counter := counter + 1;
    end loop;
END;
/

select * from ex3_6;

-- for�� loop
BEGIN
    for i in 1..9 loop      -- ���̽� : for in range(1,10): 1���� 9����
        DBMS_OUTPUT.PUT_LINE(i);
    end loop;
end;
/

DECLARE
    empid number := &empid;
    eid number;
    fname varchar2(20);
    sal number;
    mngid number;
BEGIN
    for i in 1..3 loop
        select employee_id, first_name, salary, manager_id
        into eid, fname, sal, mngid
        from employees
        where employee_id = empid + i;
        insert into ex3_6
        values (eid, fname, sal, mngid);
    end loop;
END;
/

select * from ex3_6;

-- ������ ����Ͻÿ�.
BEGIN   -- ��ø ���� : ��ø ������ ��� ���̺��� �����ִ� ���� �������� ����.
    <<Outer_loop>>  -- ���̺�
    for i in 2..9 loop
        <<Inner_loop>>
        for j in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(i ||' * '|| j || ' = ' || i*j);
        end loop Inner_loop;
    end loop Outer_loop;
END;
/