 -- 테이블 복사 (테이블과 데이터를 복사)
 create table emp3_7
 as
 select * from employees;
 
 select * from emp3_7;
 
 -- 테이블 구조만 복사 (데이터는 복사 안됨)(현업에서 많이 사용)
 create table emp3_8
 as
 select * from employees where 1 = 2;   -- 1 = 2 : 거짓
 
 select * from emp3_8;
 
 -- 데이터 복사 (현업에서 많이 사용)
 -- employees에 있는 데이터를 emp3_8에 복사
 insert into emp3_8         -- 테이블이 존재할 때 데이터 복사
 select * from employees;
 
 select * from emp3_8;
 
 -- 일부 컬럼만 데이터 복사
 insert into emp3_8(employee_id, last_name, email, hire_date, job_id, salary)
 select employee_id, last_name, email, hire_date, job_id, salary
 from employees;
 
 --=====================================================================
 
--- 변수 선언과 초기화
DECLARE
    myname varchar2(20);    -- 변수선언
BEGIN
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
    myname := 'John';        -- 값을 초기화 , BEGIN에서 END 사이에서만 사용 가능
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
END;
/

DECLARE
    myname varchar2(20) := 'Rhee';    -- 변수선언
BEGIN
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
    myname := q'\ John's day \';        -- 값을 대입    " ' " 사용하기 : q'\ \'
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
    myname := q'[ John's day ]';        -- 값을 대입
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
    myname := q'! John's day !';        -- 값을 대입
    DBMS_OUTPUT.PUT_LINE('My name is : ' || myname);
END;
/

DECLARE
    first_name varchar2(20) := 'GilDong';
    last_name varchar2(20) default 'Hong';   -- default를 이용해서 변수 초기화
BEGIN
    DBMS_OUTPUT.PUT_LINE(first_name);
    DBMS_OUTPUT.PUT_LINE(last_name);
END;
/

DECLARE
    valid BOOLEAN := true;
BEGIN
    DBMS_OUTPUT.PUT_LINE(valid);    -- 문자나 숫자만 출력 가능
    valid := false;
    DBMS_OUTPUT.PUT_LINE(valid);    -- BOOLEAN 타입 출력 불가
END;
/

DECLARE     -- %TYPE : 테이블의 컬럼타입을 사용할 때
    empno employees.employee_id%TYPE;
BEGIN
    empno := 10;
    DBMS_OUTPUT.PUT_LINE(empno);
END;
/

--- 바인드 변수
VARIABLE emp_salary NUMBER      -- DECLARE 선언 안해도 된다.
BEGIN
    select salary
    into :emp_salary
    from employees
    where employee_id = 107;
END;
/
print emp_salary;   -- 바인드 변수를 사용한 경우 프로시져가 종료된 후에도 사용 가능
select * from employees
where salary = :emp_salary;


VARIABLE fname NUMBER
VARIABLE lname NUMBER
BEGIN
    :fname := 45;
    :lname := 15;
END;
/
print fname;    -- 바인드 변수는 print로 확인 (DBMS_OUTPUT.PUT_LINE() : 바인드변수는 사용불가)
print lname;


VARIABLE deptno NUMBER
SET AUTOPRINT ON    -- 바인드 변수가 가진 값을 출력, print 없이 출력 가능
BEGIN
    select department_id 
    into :deptno
    from employees
    where employee_id = 100;
END;
/

--- PL/SQL 레코드 생성
-- 필드 모음을 논리적 단위로 처리
-- 레코드 안에 변수 : 필드 / 필드 묶음 : 레코드
DECLARE
    TYPE emp_record_type is RECORD(     -- 사용자 자료형
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
    TYPE emp_record_type is RECORD(     -- 사용자 자료형
        employee_id NUMBER NOT NULL := 100, -- 필드
        last_name employees.last_name%TYPE,
        job_id employees.job_id%TYPE
    );
    emp_record emp_record_type;     -- 레코드 변수명   레코드 타입
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
-- 기본 데이터베이스 열과 데이터 유형
-- SELECT * 문을 사용하여 행을 검색할 때 유용합니다.
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

-- 레코드를 사용하여 테이블의 행 갱신
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

-- INDEX BY 테이블 : 여러개의 행을 저장하기 위한 테이블
-- 정수 또는 문자열 데이터 유형의 Primary Key
-- 의 자료형 : BINARY_INTEGER 및 PLS_INTEGER : 크기가 작아야 하기 때문에

DECLARE
    TYPE dept_table_type IS TABLE OF
        departments%ROWTYPE     -- departments에 있는 모든 컬럼
        INDEX BY PLS_INTEGER;   -- 여러개의 행이 들어가기 때문에 index(pk)가 필요하다.
    dept_table dept_table_type; -- dept_table_type 이 타입을 dept_table 변수명에 담는다.
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

-- 명시적 커서 : 행 데이터를 수동으로 제어할 수 있다. 커서는 SELECT에서 사용
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
    FETCH emp_cursor    -- 현재 커서 값 가져오기
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
    if not emp_cursor%isopen then   -- 커서가 열려 있는지 테스트, open 안되어 있으면 open 해주세요.
        open emp_cursor;
    end if;

    OPEN emp_cursor;
    loop
        FETCH emp_cursor 
        INTO emp;
        -- %rowcount : 커서가 움직일 때마다 1씩 증가하는 값을 가진다. 지금까지 반환된 행의 수
        EXIT WHEN emp_cursor%notfound or emp_cursor%rowcount > 10;  -- cursor를 찾지 못하면 loop를 빠져나와라 or 10번만 돌겠다. 명시적커서에서 EXIT 꼭 필요
        DBMS_OUTPUT.PUT_LINE(emp.first_name || ' ' || emp.last_name || ' ' || emp.department_id);
    end loop;
    CLOSE emp_cursor;
END;
/

--- subquery를 사용하는 커서 for 루프
BEGIN
    for emp_record in (select employee_id, last_name 
                        from employees where department_id = 30) loop
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ' ' || emp_record.last_name);              
    end loop;                        
END;
/

-- 파라미터가 포함된 커서
DECLARE
    CURSOR emp_cursor(deptno NUMBER) is
        select *
        from employees
        where department_id = deptno;
    emp employees%rowtype;
BEGIN
    OPEN emp_cursor(10);        -- cursor open 후에 loop
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
    for emp in emp_cursor(10) loop  -- cursor를 for문에서 open
        DBMS_OUTPUT.PUT_LINE(emp.employee_id|| ' ' || emp.first_name || ' ' || emp.department_id);
    EXIT WHEN emp_cursor%notfound;
    end loop;
END;
/

--- 파라미터가 있는 커서를 만들 때 부서 번호와 직무를 받도록하고 
-- 이름, 직무, 부서번호를 부서번화와 직무에 해당하는 사원이 출력되게 하세요.
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
for update nowait;  -- select 하는 동안 다른 사용자가 update, delete 하지 못하도록 막는다. : 잠금
--for update;       -- 계정 접속해제를 해야 다른 사용자가 update, delete 할 수 있다.

-- SQL ===============
conn /as sysdba;     -- sqlplus 비밀번호 없이 system 계정으로 접속 (관리자 계정 비밀번호 모를시)
show user;           -- user 확인
-- SQL ===============

-- 커서 사용할 때 잠금
DECLARE
    CURSOR emp_cursor is
        select * from emp3_7
        where department_id = 80 FOR UPDATE OF salary;  -- 내가 select 하는 동안 다른 사용자가 salary update 하지 못하도록 잠금
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
        FOR UPDATE;     -- update시 꼭 있어야 한다.
    emp emp3_7%rowtype;
BEGIN
    OPEN emp_cursor(10);
    loop
        FETCH emp_cursor into emp;
        EXIT when emp_cursor%notfound;  -- 없으면 무한루프 : "invalid ROWID"
        update emp3_7 
        set salary = salary * 1.1
        where CURRENT OF emp_cursor;    -- 현재 커서에 해당하는 행을 update
    end loop;
END;
/

-- EXCEPTION (Oracle 10g PL&SQL Fundmentals(K).pdf - p235 참조)
DECLARE
    lname VARCHAR2(15);
BEGIN
    select last_name into lname from employees
    where first_name = 'John';  -- 프로시져는 단일행만 출력한다. 멀티행 출력하려면 index table 사용
    DBMS_OUTPUT.PUT_LINE(lname); -- 실제 인출은 요구된 것보다 많은 수의 행을 추출합니다(멀티행이라 에러 발생)
    EXCEPTION
    when TOO_MANY_ROWS then
    DBMS_OUTPUT.PUT_LINE('행의 수가 너무 많아요');
    when NO_DATA_FOUND then
    DBMS_OUTPUT.PUT_LINE('데이터가 없습니다.');
    when INVALID_CURSOR or ZERO_DIVIDE or DUP_VAL_ON_INDEX then
    DBMS_OUTPUT.PUT_LINE('커서가 정확하지 않습니다. 0으로 나누지 못함. index가 중복됨.');
    when others then
    DBMS_OUTPUT.PUT_LINE('나머지');
END;
/

-- 시퀀스 생성
CREATE SEQUENCE DEPT_NUM
INCREMENT BY 10
start WITH 400;

--- 프로시저(반환값 없음) 및 함수(반환값 있음) (p256)
CREATE or REPLACE PROCEDURE add_dept
is
    dept_id dept.department_id%TYPE;
    dept_name dept.department_name%TYPE;
BEGIN
    dept_id := 320;
    dept_name := '개발부';
    INSERT INTO dept(department_id, department_name)
    values (dept_num.nextval, dept_name);       -- 시퀀스 사용
    DBMS_OUTPUT.PUT_LINE('Inserted ' || SQL%ROWCOUNT || ' row');
END;
/
exec add_dept;  -- 함수 호출
select * from dept where department_id = 320;
select * from dept;

-- 매개변수를 받아오는 프로시저
CREATE OR REPLACE PROCEDURE update_sal
(v_empno    IN      NUMBER)     -- 변수명 IN : 값을 받아오겠다.
is
BEGIN
    UPDATE emp3_7
    SET salary = salary * 1.1
    where employee_id = v_empno;
END;
/
exec update_sal(100);   -- 변수명 매개변수 값을 꼭 적어줘야 한다.
select * from emp3_7 where employee_id = 100;


CREATE OR REPLACE PROCEDURE prc_tree
(
    v_emp_code IN VARCHAR2,     -- IN : varchar2 값을 프로시저 안으로 받아온다.
    p_code OUT VARCHAR2,        -- OUT : varchar2 값을 프로시저 밖으로 보낸다.
    t_code OUT VARCHAR2
)
is
BEGIN
    select department_id, job_id into p_code, t_code    -- 내보내기 위한 값을 프로시저 내에서 받아온다.
    from employees
    where employee_id = v_emp_code;
END prc_tree;
/
DECLARE
    p_code VARCHAR2(20);
    t_code VARCHAR2(20);
BEGIN
    prc_tree('100', p_code, t_code);    -- 프로시저에서 전달된 OUT 값을 받기 위한 변수(p_code, t_code) 선언
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