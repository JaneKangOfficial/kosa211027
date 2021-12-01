-- 함수 (p260)
-- (프로시저는 return 값이 없고, 함수는 return 값이 있다.)
CREATE OR REPLACE FUNCTION check_sal    -- 매개변수가 없을 경우 () 없이 바로 return문 
RETURN number               -- boolean 타입은 return 값을 받아올 수가 없다.
is
    dept_id employees.department_id%TYPE;
    emp_no employees.employee_id%TYPE;
    sal employees.salary%TYPE;
    avg_sal employees.salary%TYPE;
BEGIN
    -- 100번 사원의 급여, 부서
    emp_no := 100;
    SELECT salary, department_id
    into sal, dept_id
    from employees
    where employee_id = emp_no;
    
    -- 100번 사원 부서의 평균 급여
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
-- return boolean 타입 아닌 경우 exec 사용
var aaa varchar2(20);
exec :aaa := check_sal();
print aaa;
-- return boolean 타입인 경우 if문 사용
begin
    if(check_sal is null) then
        DBMS_OUTPUT.PUT_LINE('check_sal가 null입니다.');
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
    
    -- return 하기 위해
    select salary into sal
    from emp3_7
    where employee_id = v_empno;
    
    return sal;     -- FUNCTION은 return문이 꼭 존재해야 합니다.
END;
/
var sal1 number;
exec :sal1 := FC_update_sal(110);
print sal1;

-- EMP3_7 테이블에서 이름으로 부서 번호를 검색하는 함수를 작성하시오.
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
        DBMS_OUTPUT.PUT_LINE('데이터가 없습니다.');
    WHEN too_many_rows THEN
        DBMS_OUTPUT.PUT_LINE('데이터가 2건 이상입니다.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('기타 에러입니다.');
END;
/
select * from emp3_7;
var n number;
exec :n := search_deptno('Neena');
print n;

-- EMP3_7 테이블에서 이름을 입력 받아 부서번호, 부서명, 급여를 출력하는 FUNCTION을 작성하시오.
-- 단, 부서번호를 RETURN에 사용
CREATE OR REPLACE FUNCTION search_emp
(
    v_fname  in  employees.first_name%TYPE,
    v_deptna out departments.department_name%TYPE,
    v_sal out employees.salary%TYPE
)
return number               -- department_id 는 return 으로 받는다.
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
    
    v_deptna := v_deptna_temp;   -- output 변수에 저장, return은 하나의 값만(department_id) 가능하기 때문에 
    v_sal := v_sal_temp;         -- output 변수에 저장, 출력하기 위해 output 변수에 저장함
    DBMS_OUTPUT.PUT_LINE('성   명 : ' || v_fname);
    DBMS_OUTPUT.PUT_LINE('부서번호 : ' || to_char(v_deptno));
    DBMS_OUTPUT.PUT_LINE('부 서 명 : ' || v_deptna_temp);
    DBMS_OUTPUT.PUT_LINE('급   여 : ' || to_char(v_sal_temp, '$999,999'));

    return v_deptno;
EXCEPTION
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('데이터가 없습니다.');
    WHEN too_many_rows THEN
        DBMS_OUTPUT.PUT_LINE('데이터가 2건 이상입니다.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('기타 에러입니다.');
END;
/
VAR g_deptno NUMBER;
VAR g_dname VARCHAR2(20);
VAR g_sal NUMBER;
EXECUTE :g_deptno := search_emp('Neena',:g_dname,:g_sal)
PRINT g_dname;
print g_sal;
print g_deptno;

-- 입사일 구하는 함수를 만들어 보자, 사원번호를 이용
CREATE OR REPLACE FUNCTION search_hdate
(
    v_empid number,
    v_fmt varchar2       -- 날짜 형식
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


-- 연봉계산
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

-- 퇴직급여계산
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

--- TRIGGER (자동 update 프로시저)
-- old 테이블 : 변경 전 데이터나 삭제된 데이터
-- new 테이블 : 변경되거나 새로 입력된 데이터
-- emp3_7(old 테이블)의 data가 update 된다면 emp3_8(new 테이블)의 data도 자동 update
insert into emp3_8
select * from employees;

select * from emp3_8;

CREATE OR REPLACE TRIGGER emp_tri_row
after update of salary on emp3_7        -- 1. emp3_7(old 테이블)에 salary가 update가 된다면
for each row                        -- 여러개의 모든행에 대해서 트리거 적용
BEGIN
    if :old.salary < :new.salary then
        update emp3_8                   -- 2. emp3_8(new 테이블) 자동 update
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

-- emp3_7에 170번 사원의 데이터를 employees 테이블에서 불러와 저장한다면
-- emp3_8에도 170번 사원의 데이터가 저장되게 하시오.
delete from emp3_7 where employee_id = 170;
delete from emp3_8 where employee_id = 170;

CREATE OR REPLACE TRIGGER emp_test_ins
after insert on emp3_7      -- emp3_7(old 테이블)에 insert가 발생한 후에
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

-- emp3_7 테이블에 employees 테이블에서 145번 사원의 데이터를 저장하고
-- emp3_7에 있는 145번 사원의 커미션을 0.5로 변경할 때 변경 전 값이 변경 후 값보다 작은 경우 
-- emp3_8의 145사원의 급여를 15% 인상하여 저장하시오.
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

-- emp3_7 테이블에 151번 사원의 직무를 'ST_CLERK'로 변경되었다면 emp3_8의 커미션을 0.6으로 변경
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