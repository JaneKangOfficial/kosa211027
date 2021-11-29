--- PL / SQL
DECLARE
    v_fname varchar2(20);
BEGIN
    SELECT first_name
    INTO    v_fname     -- first_name 결과값을 v_fname 변수명에 저장하겠습니다.
    FROM employees
    WHERE employee_id = 100;
    DBMS_OUTPUT.PUT_LINE(v_fname);      -- v_fname 변수명에 해당하는 값을 출력하겠습니다.
END;
/   -- 여기까지가 프로시져입니다.

DECLARE
/*  프로시져 내에서의 주석
--    emp_hiredate date;      -- 초기값 없을 경우
--    vn_num1 NUMBER := 1;    -- 변수 초기값 선언
--    emp_deptno NUMBER(2) not null := 10;
--    c_comm CONSTANT NUMBER := 1400;     -- 상수 선언
*/
    vn_num1 NUMBER := 1;    -- 변수 초기값 선언
    vn_num2 NUMBER := 2;
BEGIN
    if vn_num1 >= vn_num2 then 
        DBMS_OUTPUT.PUT_LINE(vn_num1 || '이 큰 수 입니다.');
    else
        DBMS_OUTPUT.PUT_LINE(vn_num2 || '이 큰 수 입니다.');
    end if;
END;
/

DECLARE
    employee_id number(6);      -- 같은 이름의 식별자는 사용하지 않는 것이 좋다.
BEGIN
    select employee_id          -- 같은 테이블이 아닌 다른 테이블인 경우 제한적으로 사용하는 것이 좋다.
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
-- BINARY_FLOAT, BINARY_DOUBLE : NUMBER 데이터 유형에서 저장할 수 있는 값 범위를 벗어난 값을 저장합니다.

--- %TYPE 속성
-- 데이터베이스 열 정의
-- 선언된(먼저 정의된) 다른 변수 
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
--    DBMS_OUTPUT.PUT_LINE(flag); -- boolean type은 출력 불가.
END;
/

--- 바인드 변수
-- 호스트 변수라고도 한다.
-- VARIABLE 키워드를 사용하여 생성
-- PL/SQL 블록이 실행된 후에도 액세스할 수 있다.
-- VARIABLE return_code NUMBER
-- VARIABLE return_msg VARCHAR2(30)

VARIABLE emp_salary NUMBER
SET AUTOPRINT ON
BEGIN
    select salary 
    into :emp_salary    -- VARIABLE 바인드 변수 사용할 때 ":" 있어야 한다. 바인드 변수임을 알려준다.
    from employees
    where employee_id = 143;
    -- emp_salary 가 DECLARE로 선언되어 있어야 한다.
END;
/

--- 치환 변수   ( = Scanner , 값을 입력 받음)
-- 유저 입력을 얻는데 사용하는 변수
-- 앞에 앰퍼샌드(&)를 붙여 PL/SQL 블록 내에서 참조
-- 실행 중에 얻을 수 있는 값을 직접 코딩하는 것을 피할 수 있다.
VARIABLE emp_salary NUMBER
SET AUTOPRINT ON
DECLARE
    empno NUMBER(6) := &empno;  -- 치환 변수
BEGIN
    select salary 
    into :emp_salary
    from employees
    where employee_id = empno;
END;
/

SET VERIFY OFF
VARIABLE emp_salary NUMBER
ACCEPT empno PROMPT '사원번호를 입력해주세요 : '
SET AUTOPRINT ON
DECLARE
    empno NUMBER(6) := &empno;  -- 치환 변수
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
        DBMS_OUTPUT.PUT_LINE(hdate);    -- 같은 이름의 변수가 선언된 경우 : 같은 블럭 안에 있는 것이 우선한다.
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

BEGIN <<OUTER>>     -- 변수명이 안,밖 같을 경우(hdate) 사용 : 식별자의 명확한 지정
DECLARE
    fname varchar2(20) := 'Patrick';
    hdate date := '2000-01-20';
BEGIN
    DECLARE
        lname varchar2(20) := 'Mike';
        hdate date := '2001-12-25';
    BEGIN
        DBMS_OUTPUT.PUT_LINE(lname);
        DBMS_OUTPUT.PUT_LINE(hdate);    -- 같은 이름의 변수가 선언된 경우 : 같은 블럭 안에 있는 것이 우선한다.
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
    DBMS_OUTPUT.PUT_LINE('60 부서의 급여 합계는 ' ||sum_sal);
END;
/

DECLARE     -- 같은 이름의 컬럼명, 변수명 사용하지 않는 것이 좋다 : 모호성을 방지
-- 데이터베이스 열 이름을 식별자로 사용하지 않는다.
-- 로컬 변수와 형식 파라미터의 이름은 데이터베이스 테이블의 이름보다 우선 (변수명이 우선)
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

ACCEPT fname PROMPT '사원 이름을 입력해주세요 : '
ACCEPT lname PROMPT '사원 성을 입력해주세요 : '
ACCEPT mail PROMPT '사원 이메일을 입력해주세요 : '
ACCEPT hdate PROMPT '사원 입사일을 yyyy-mm-dd 형식으로 입력해주세요 : '
ACCEPT jid PROMPT '사원 업무를 입력해주세요 : '
ACCEPT sal PROMPT '사원 급여를 입력해주세요 : '
DECLARE
    fname employees.first_name%TYPE := &fname;      -- 치환변수
    lname employees.last_name%TYPE := &lname;
    mail employees.email%TYPE := &mail;
    hdate employees.hire_date%TYPE := &hdate;
    jid employees.job_id%TYPE := &jid;
    sal employees.salary%TYPE := &sal;
BEGIN
INSERT INTO emp
    (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    VALUES (employees_seq.NEXTVAL, fname, lname, mail, hdate, jid, sal);
    DBMS_OUTPUT.PUT_LINE('정상적으로 저장되었습니다.');
END;
/

DECLARE
    sal_increase employees.salary%TYPE := 800;
BEGIN
    UPDATE employees
    SET salary = salary + sal_increase
    WHERE job_id = 'ST_CLERK';
    DBMS_OUTPUT.PUT_LINE('ST_CLERK 데이터가 수정되었습니다.');
END;
/

DECLARE
    empid emp.employee_id%TYPE := 1;
BEGIN
    DELETE FROM emp
    WHERE employee_id = empid;
    DBMS_OUTPUT.PUT_LINE(empid || '번 사원이 삭제되었습니다.');
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
    insert (a.employee_id, a.emp_name, a.salary, a.manager_id)     -- merge 'into'가 있어서 insert 'into'는 안 적어도 된다.
    values (b.employee_id, b.first_name, 15000, 100);
END;
/

select * from ex3_6;

DECLARE
    myage number := 31;
BEGIN
    if myage < 11 then
        DBMS_OUTPUT.PUT_LINE('저는 11살 미만입니다.');
    else
        DBMS_OUTPUT.PUT_LINE('저의 나이는 ' || myage || '살 입니다');
    end if;
END;
/

-- 급여를 1000으로 나눈 몫이 3이하면 사원, 5이하면 주임, 7이하면 대리, 9이하면 과장, 10이하면 차장, 13이하면 부장, 15이하면 본부장, 그외 이사
-- 130번 사원, 프로시져로 만들어서 사용하세요.
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
        DBMS_OUTPUT.PUT_LINE('사원');
    elsif sal <= 5 then
        DBMS_OUTPUT.PUT_LINE('주임');
    elsif sal <= 7 then
        DBMS_OUTPUT.PUT_LINE('대리');
    elsif sal <= 9 then
        DBMS_OUTPUT.PUT_LINE('과장');
    elsif sal <= 10 then
        DBMS_OUTPUT.PUT_LINE('차장');    
    elsif sal <= 13 then
        DBMS_OUTPUT.PUT_LINE('부장');
    elsif sal <= 15 then
        DBMS_OUTPUT.PUT_LINE('본부장');
    else
        DBMS_OUTPUT.PUT_LINE('이사');
    end if;
END;
/

-- 급여를 1000으로 나눈 몫이 3이하면 사원, 5이하면 주임, 7이하면 대리, 9이하면 과장, 10이하면 차장, 13이하면 부장, 15이하면 본부장, 그외 이사
-- 130번 사원, 프로시져로 만들어서 사용하세요. case문으로

DECLARE
    empid emp.employee_id%TYPE := 130;
    grade varchar2(20);
BEGIN
    select 
    case when trunc(salary / 1000) <= 3 then '사원'
         when trunc(salary / 1000) <= 5 then '주임'
         when trunc(salary / 1000) <= 7 then '대리'
         when trunc(salary / 1000) <= 9 then '과장'
         when trunc(salary / 1000) <= 10 then '차장'
         when trunc(salary / 1000) <= 13 then '부장'
         when trunc(salary / 1000) <= 15 then '본부장'
         else '이사' end
    into grade
    from emp
    where employee_id = empid;
    DBMS_OUTPUT.PUT_LINE('직원의 직책은 : ' || grade);
END;   
/

DECLARE
    grade CHAR(1) := UPPER('&grade');
    result1 VARCHAR2(30);
BEGIN
    result1 :=
    case grade 
        when 'A' then '90점 이상입니다.'
        when 'B' then '80점 이상입니다.'
        when 'C' then '70점 이상입니다.'
        when 'D' then '60점 이상입니다.'
        when 'F' then '60점 미만입니다.'
    end;
    DBMS_OUTPUT.PUT_LINE('grade : ' || grade || '일 때 ' || result1);
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
    /* case로 변경하시오 */
    result1 :=
    case when sal <= 3 then '사원'
         when sal <= 5 then '주임'
         when sal <= 7 then '대리'
         when sal <= 9 then '과장'
         when sal <= 10 then '차장'
         when sal <= 13 then '부장'
         when sal <= 15 then '본부장'
         else '이사'
    end;
    DBMS_OUTPUT.PUT_LINE('직원의 직책은 : ' || result1 ||'입니다.');
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

--- 부서장 번호를 입력 받아서 부서장의 부서번호와 부서이름을 가져오고 그 부서의 사원수도 가지고 오세요.
-- 108번 부서장의 부서는 90번이고 부서명은 영업부이며 사원수는 20명입니다.
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
    DBMS_OUTPUT.PUT_LINE(mngid||'번 부서장의 부서는 ' ||deptid||'이고 부서명은 ' ||deptname||'이며 사원수는 '||emps||'명입니다.');
END;
/

--- LOOP
-- 기본 LOOP문 (무한 LOOP)
DECLARE
    counter NUMBER(2) := 1;     -- 증가 변수
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
        EXIT WHEN counter > 3;      -- EXIT : 탈출하기 위한 조건이 꼭 필요하다.
    END LOOP;
END;
/
delete from ex3_6;
select * from ex3_6;
commit;

-- while Loop문
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

-- for문 loop
BEGIN
    for i in 1..9 loop      -- 파이썬 : for in range(1,10): 1부터 9까지
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

-- 구구단 출력하시오.
BEGIN   -- 중첩 루프 : 중첩 루프일 경우 레이블을 적어주는 것이 가독성에 좋다.
    <<Outer_loop>>  -- 레이블
    for i in 2..9 loop
        <<Inner_loop>>
        for j in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(i ||' * '|| j || ' = ' || i*j);
        end loop Inner_loop;
    end loop Outer_loop;
END;
/