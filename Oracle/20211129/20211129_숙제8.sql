-- 1. ���� PL/SQL ��� �� ���������� ����Ǵ� ����� �����Դϱ�? : d
--a. BEGIN 
--END;
-- a �� ����� ���� ���ǿ� ��ɹ��� ���� ������ ������� �ʽ��ϴ�.
--b. DECLARE 
--amount INTEGER(10); 
--END;
--b �� ��Ͽ��� BEGIN Ű����� �����ϴ� �ʼ� ���� ������ �����ϴ�.
--c. DECLARE 
--BEGIN 
--END;
--c �� ��Ͽ��� �ʿ��� �׸��� ��� ������ ���� ���ǿ� ��ɹ��� �����ϴ�. 
--d. DECLARE 
--amount INTEGER(10); 
--BEGIN 
--DBMS_OUTPUT.PUT_LINE(amount); 
--END;

--2.  "Hello World"�� ����ϴ� ������ �͸� ����� �����Ͽ� �����մϴ�
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello World');
END;
/

--3.  ���� �͸� ����� �����ϰ� �ùٸ� ������ �����մϴ�. : a
SET SERVEROUTPUT ON
DECLARE
  fname VARCHAR2(20);
  lname VARCHAR2(15) DEFAULT 'fernandez';
BEGIN
  DBMS_OUTPUT.PUT_LINE( FNAME ||' ' ||lname);
END;
/
--a. ����� ���������� ����ǰ� "fernandez"�� ��µ˴ϴ�.
--b. fname ������ �ʱ�ȭ���� �ʰ� ���Ǿ��� ������ ������ �߻��մϴ�.
--c. ����� ���������� ����ǰ� "null fernandez"�� ��µ˴ϴ�.
--d. VARCHAR2 ������ ������ �ʱ�ȭ�ϴ� �� DEFAULT Ű���带 ����� �� ���� ������ ������ �߻��մϴ�.
--e. ��Ͽ��� FNAME ������ ������� �ʾұ� ������ ������ �߻��մϴ�.

--4. �͸� ����� �����մϴ�. 
--a. �� PL/SQL ��Ͽ� ���� ������ �߰��մϴ�. ���� ���ǿ��� ���� ������ �����մϴ�.
--1. DATE ������ today ����. today�� SYSDATE�� �ʱ�ȭ�մϴ�.
--2. today ������ tomorrow ����. %TYPE �Ӽ��� ����Ͽ� �� ������ �����մϴ�.
--b. ���� ���ǿ��� ���� ��¥�� ����ϴ� ǥ����(today ���� 1 �߰�)�� ����Ͽ� tomorrow ������ �ʱ�ȭ�մϴ�. 
--   "Hello World"�� ����� �� today�� tomorrow�� ���� ����մϴ�.
--c. ������ ��� ����� ������ �����ϴ�
--anonymous block completed
-- Hello World
--TODAY IS : 28-JAN-09
--TOMORROW IS : 29-JAN-09

DECLARE
    today date := sysdate;
    tomorrow today%TYPE;
BEGIN
    tomorrow := today + 1;
    DBMS_OUTPUT.PUT_LINE('Hello World');
    DBMS_OUTPUT.PUT_LINE('TODAY IS : ' || today);
    DBMS_OUTPUT.PUT_LINE('TOMORROW IS : ' || tomorrow);
END;
/

--5. �͸� ����� �����մϴ�. 
--a. �� ���� ���ε� ������ �����ϴ� �ڵ带 �߰��մϴ�. NUMBER ������ ���ε� ����
--basic_percent �� pf_percent�� �����մϴ�.
--b. PL/SQL ����� ���� ���ǿ��� basic_percent�� pf_percent�� ���� �� 45��
--12�� �Ҵ��մϴ�.
--c. "/"�� PL/SQL ����� �����ϰ� PRINT ����� ����Ͽ� ���ε� ���� ���� ǥ���մϴ�.
--d. ������ ��� ����� ������ �����ϴ�
--anonymous block completed
-- Hello World
--TODAY IS : 28-JAN-09
--TOMORROW IS : 29-JAN-09
--
--basic_percent
----
--45
--
--pf_percent
----
--12

VARIABLE basic_percent NUMBER
VARIABLE pf_percent NUMBER
    :basic_percent := 45;
    :pf_percent := 12;
/
PRINT basic_percent
PRINT pf_percent


/*
DECLARE
    weight NUMBER(3) := 600;
    message VARCHAR2(255) := 'Product 10012';
BEGIN
    DECLARE
        weight NUMBER(3) := 1;
        message VARCHAR2(255) := 'Product 11001';
        new_locn VARCHAR2(50) := 'Europe';
    BEGIN
        weight := weight + 1;
        new_locn := 'Western ' || new_locn;
--        1
    END;
    weight := weight + 1;
    message := message || ' is in stock';
    new_locn := 'Western ' || new_locn;
--    2
END;
/
*/
--6. ���� ���õ� PL/SQL ����� �����Ͽ� ���� ���� ��Ģ�� ���� ���� �� ������ ������ ����
--�� ���� �Ǻ��մϴ�.
--a. 1 ��ġ������ weight ��: 2
--b. 1 ��ġ������ new_locn ��: 'Western Europe'
--c. 2 ��ġ������ weight ��: 601
--d. 2 ��ġ������ message ��: 'Product 10012 is in stock'
--e. 2 ��ġ������ new_locn ��: new_locn �� ���� ��� �ܺο��� �� �� ���� ������ �߸��� �����̴�.


--7. �͸� ����� �����Ͻÿ�,
--a. ���� �� �ּ� ������ ����Ͽ� ���ε� ������ �����ϴ� ���� �ּ� ó���մϴ�.
--b. ���� ���ǿ��� ���� �� �ּ��� ����Ͽ� ���ε� ������ ���� �Ҵ��ϴ� ���� �ּ� ó���մϴ�.
--c. ������ ������ VARCHAR2�̰� ũ�Ⱑ 15�� fname �� ������ ������ NUMBER�̰� ũ�Ⱑ 10�� emp_sal�̶�� �� ������ �����մϴ�.
--d. ���� SQL ���� ���� ���ǿ� ���Խ�ŵ�ϴ�.
--SELECT first_name, salary 
--INTO fname, emp_sal FROM employees 
--WHERE employee_id=110;
--e. 'Hello World'�� ����ϴ� ���� 'Hello'�� �̸��� ����ϵ��� �����մϴ�. �ʿ��� ��� ��¥�� ǥ���ϰ� ���ε� ������ ����ϴ� ���� �ּ� ó���մϴ�.
--f. ���� ���(PF)�� ���� ����� �δ���� ����մϴ�. PF�� �⺻ �޿��� 12%�̸� �⺻ �޿��� �޿��� 45%�Դϴ�. ����� ���� ���ε� ������ ����մϴ�. ǥ������ �ϳ��� ����Ͽ� PF�� ����մϴ�. ����� �޿� �� PF �δ���� ����մϴ�.
--g. ������ ��� ����� ������ �����ϴ�.
--anonymous block completed
-- Hello John
--YOUR SALARY IS : 8200
--YOUR CONTRIBUTION TOWARDS PF : 442.8


-- VARIABLE basic_percent NUMBER 
-- VARIABLE pf_percent NUMBER
/* :basic_percent:=45; 
   :pf_percent:=12; */
    fname varchar2(15);
    emp_sal number(10);

    select first_name, salary
    into fname, emp_sal
    from employees
    where employee_id = 110;
    DBMS_OUTPUT.PUT_LINE('Hello ' || fname);
    DBMS_OUTPUT.PUT_LINE('YOUR SALARY IS : ' || emp_sal);
    DBMS_OUTPUT.PUT_LINE('YOUR CONTRIBUTION TOWARDS PF : ' || emp_sal*:basic_percent/100*:pf_percent/100);
END;
/

--8. �͸� ����� �����Ͻÿ�.
--a. employees �� employee_details ���̺��� ������ �����Ͱ� �ֽ��ϴ�. 
--employee_details ���̺��� �����͸� �����մϴ�. employees ���̺��� �����ʹ� �����ϰų� �������� ���ʽÿ�. 
--b. �� �ڵ�� ������ �Է��� ��� ��ȣ �� �μ� ��ȣ�� �޾Ƶ��Դϴ�. 
create table employee_details
as
select * from employees;

select * from employee_details;

DECLARE
    eid employees.employee_id%TYPE := &eid;
    did employees.department_id%TYPE := &did;
BEGIN
    select employee_id, department_id
    into eid, did
    from employees
    DBMS_OUTPUT.PUT_LINE(eid);
    DBMS_OUTPUT.PUT_LINE(did);
END;
/

--9. departments ���̺��� �ִ� �μ� ID�� �����Ͽ� max_deptno ������ �����ϴ�
--PL/SQL ����� �����մϴ�. �ִ� �μ� ID�� ǥ���մϴ�.
--a. ���� ���ǿ��� NUMBER ������ max_deptno ������ �����մϴ�.
--b. BEGIN Ű����� ���� ������ �����ϰ� departments ���̺��� �ִ�
--department_id�� �˻��ϴ� SELECT ���� ���Խ�ŵ�ϴ�.
--c. max_deptno�� ǥ���ϰ� ���� ����� �����մϴ�.
--d. ��ũ��Ʈ�� �����ϰ� lab_04_01_soln.sql�� �����մϴ�. ������ ���
--����� ������ �����ϴ�.
--anonymous block completed
--The maximum department_id is : 270
DECLARE
    max_deptno NUMBER;
BEGIN
    select max(department_id)
    into max_deptno
    from departments;
    DBMS_OUTPUT.PUT_LINE('The maximum department_id is : '|| max_deptno);
END;
/

--10 .���� 9���� ������ PL/SQL ����� departments ���̺� �� �μ��� �����ϵ��� �����մϴ�. 
--a. departments.department_name ������ dept_name �� NUMBER ������ dept_id��� �� ���� ������ �����մϴ�. ���� ���ǿ��� dept_name�� "Education"�� �Ҵ��մϴ�.
--b. �տ��� �̹� departments ���̺��� ���� �ִ� �μ� ��ȣ�� �˻��߽��ϴ�. 
--�� �μ� ��ȣ�� 10�� ���Ͽ� �ش� ����� dept_id�� �Ҵ��մϴ�. 
--c. departments ���̺��� department_name, department_id �� location_id ���� �����͸� �����ϴ� INSERT ���� ���Խ�ŵ�ϴ�. 
--department_name, department_id���� dept_name, dept_id�� ���� ����ϰ� location_id���� NULL�� ����մϴ�.
--d. SQL �Ӽ� SQL %ROWCOUNT�� ����Ͽ� ����Ǵ� �� ���� ǥ���մϴ�. 
--e. select ���� �����Ͽ� �� �μ��� ���ԵǾ����� Ȯ���մϴ�. "/"�� PL/SQL ����� �����ϰ� ��ũ��Ʈ�� SELECT ���� ���Խ�ŵ�ϴ�.
--f. ������ ��� ����� ������ �����ϴ�.
--annoymous block completed
--The maximum department_id is : 280
-- SQL%ROWCOUNT gives 1
--
--DEPARTMENT_ID   DEPARTMENT_NAME     MANAGER_ID      LOCATION_ID
--280             Education           (null)          (null)

VARIABLE dept_id NUMBER;
dept_name departments.department_name%TYPE := 'Education';
dept_id := max_deptno + 10
insert into departments
        (department_id, department_name, location_id)
values (:dept_id, dept_name, NULL);

DBMS_OUTPUT.PUT_LINE(' SQL%ROWCOUNT gives : '|| SQL%ROWCOUNT);
/

select * from departments
where department_id := dept_id;

--11. ���� ���� 10���� location_id�� �η� �����߽��ϴ�. �� �μ��� location_id��
--3000���� �����ϴ� PL/SQL ����� �����մϴ�. ���� dept_id ���� ����Ͽ� ����
--�����մϴ�. 
--a. BEGIN Ű����� ���� ����� �����մϴ�. �� �μ�(dept_id = 280)��
--location_id�� 3000���� �����ϴ� UPDATE ���� ���Խ�ŵ�ϴ�.
--b. END Ű����� ���� ����� �����մϴ�. "/" �� PL/SQL ����� �����ϰ� ������ �μ���
--ǥ�õǵ��� SELECT ���� ���Խ�ŵ�ϴ�.
--c. �߰��� �μ��� �����ϵ��� DELETE ���� ���Խ�ŵ�ϴ�.
--d. ������ ��� ����� ������ �����ϴ�.
--anonymous block completed
--DEPARTMENT_ID    DEPARTMENT_NAME     MANAGER_ID      LOCATION_ID
--280               Education                           3000
--
--1 rows selected
--1 rows selected

BEGIN
    update departments
    set location_id = 3000
    where dept_id = 280;
END;
/
select * from departments where department_id = :dept_id;
DELETE FROM departments WHERE department_id = 280;

--12. �͸���� �����Ͻÿ�.
--a. 1���� 10������ ���ڸ� �����մϴ�(6, 8 ����).
--b. ��� ���� ���� Ŀ���մϴ�.
--c. SELECT ���� �����Ͽ� PL/SQL ����� ����Ǿ����� Ȯ���մϴ�. ����� ������ ���ƾ� �մϴ�
--results
--1
--2
--3
--4
--5
--7
--9
--10
BEGIN
    for i in 1..10 loop
        if i = 6 or i = 8 then
            null;
        else
            DBMS_OUTPUT.PUT_LINE(i);
        end if;
    end loop;
END;
/

--13. �͸���� �����Ͻÿ�. 
--a. employees ���̺��� �������� emp ���̺��� �����մϴ�. �� ��ũ��Ʈ�� ������ ������ VARCHAR2�̰� ũ��� 50�� �� �� stars�� �߰��ϵ��� emp ���̺��� �����մϴ�. ����� �޿��� ���� $1000 �������� stars ���� ��ǥ�� �����ϴ� PL/SQL ����� �����մϴ�. 
--a. DEFINE ����� ����Ͽ� empno��� ������ �����ϰ� 176���� �ʱ�ȭ�մϴ�.
--b. ����� ���� ������ �����ϰ� ġȯ ������ ���� empno ���� PL/SQL ������� �����մϴ�. emp.stars ������ asterisk ������ �����ϰ� NULL�� �ʱ�ȭ�մϴ�. 
--emp.salary ������ sal ������ �����մϴ�.
--c. ���� ���ǿ��� �޿� �ݾ׿� ���� $1000 �������� ��ǥ(*)�� �߰��ϴ� ���� �ۼ��մϴ�. ���� ���, ����� �޿��� $8000�̸� ��ǥ ���ڿ����� 8���� ��ǥ�� �־�� �մϴ�. �޿��� $12500�̸� ��ǥ ���ڿ����� 13���� ��ǥ�� �־�� �մϴ�. 
--d. �ش� ����� stars ���� ��ǥ ���ڿ��� �����մϴ�. ��� ���� ���� Ŀ���մϴ�.
--e. emp ���̺��� ���� ����Ͽ� PL/SQL ����� ���������� ����Ǿ����� Ȯ���մϴ�
--EMPLOYEE_ID     SALARY      STARS
--176             8600        *********

