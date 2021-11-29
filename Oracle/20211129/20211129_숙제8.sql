-- 1. 다음 PL/SQL 블록 중 성공적으로 실행되는 블록은 무엇입니까? : d
--a. BEGIN 
--END;
-- a 의 블록은 실행 섹션에 명령문이 없기 때문에 실행되지 않습니다.
--b. DECLARE 
--amount INTEGER(10); 
--END;
--b 의 블록에는 BEGIN 키워드로 시작하는 필수 실행 섹션이 없습니다.
--c. DECLARE 
--BEGIN 
--END;
--c 의 블록에는 필요한 항목이 모두 있지만 실행 섹션에 명령문이 없습니다. 
--d. DECLARE 
--amount INTEGER(10); 
--BEGIN 
--DBMS_OUTPUT.PUT_LINE(amount); 
--END;

--2.  "Hello World"를 출력하는 간단한 익명 블록을 생성하여 실행합니다
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello World');
END;
/

--3.  다음 익명 블록을 검토하고 올바른 문장을 선택합니다. : a
SET SERVEROUTPUT ON
DECLARE
  fname VARCHAR2(20);
  lname VARCHAR2(15) DEFAULT 'fernandez';
BEGIN
  DBMS_OUTPUT.PUT_LINE( FNAME ||' ' ||lname);
END;
/
--a. 블록이 성공적으로 실행되고 "fernandez"가 출력됩니다.
--b. fname 변수가 초기화하지 않고 사용되었기 때문에 오류가 발생합니다.
--c. 블록이 성공적으로 실행되고 "null fernandez"가 출력됩니다.
--d. VARCHAR2 유형의 변수를 초기화하는 데 DEFAULT 키워드를 사용할 수 없기 때문에 오류가 발생합니다.
--e. 블록에서 FNAME 변수가 선언되지 않았기 때문에 오류가 발생합니다.

--4. 익명 블록을 생성합니다. 
--a. 이 PL/SQL 블록에 선언 섹션을 추가합니다. 선언 섹션에서 다음 변수를 선언합니다.
--1. DATE 유형의 today 변수. today를 SYSDATE로 초기화합니다.
--2. today 유형의 tomorrow 변수. %TYPE 속성을 사용하여 이 변수를 선언합니다.
--b. 실행 섹션에서 내일 날짜를 계산하는 표현식(today 값에 1 추가)을 사용하여 tomorrow 변수를 초기화합니다. 
--   "Hello World"를 출력한 후 today와 tomorrow의 값을 출력합니다.
--c. 예제의 출력 결과는 다음과 같습니다
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

--5. 익명 블록을 생성합니다. 
--a. 두 개의 바인드 변수를 생성하는 코드를 추가합니다. NUMBER 유형의 바인드 변수
--basic_percent 및 pf_percent를 생성합니다.
--b. PL/SQL 블록의 실행 섹션에서 basic_percent와 pf_percent에 각각 값 45와
--12를 할당합니다.
--c. "/"로 PL/SQL 블록을 종료하고 PRINT 명령을 사용하여 바인드 변수 값을 표시합니다.
--d. 예제의 출력 결과는 다음과 같습니다
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
--6. 위에 제시된 PL/SQL 블록을 검토하여 범위 지정 규칙에 따라 다음 각 변수의 데이터 유형
--및 값을 판별합니다.
--a. 1 위치에서의 weight 값: 2
--b. 1 위치에서의 new_locn 값: 'Western Europe'
--c. 2 위치에서의 weight 값: 601
--d. 2 위치에서의 message 값: 'Product 10012 is in stock'
--e. 2 위치에서의 new_locn 값: new_locn 은 하위 블록 외부에서 볼 수 없기 때문에 잘못된 구문이다.


--7. 익명 블록을 생성하시오,
--a. 단일 행 주석 구문을 사용하여 바인드 변수를 생성하는 행을 주석 처리합니다.
--b. 실행 섹션에서 다중 행 주석을 사용하여 바인드 변수에 값을 할당하는 행을 주석 처리합니다.
--c. 데이터 유형이 VARCHAR2이고 크기가 15인 fname 및 데이터 유형이 NUMBER이고 크기가 10인 emp_sal이라는 두 변수를 선언합니다.
--d. 다음 SQL 문을 실행 섹션에 포함시킵니다.
--SELECT first_name, salary 
--INTO fname, emp_sal FROM employees 
--WHERE employee_id=110;
--e. 'Hello World'를 출력하는 행을 'Hello'와 이름을 출력하도록 변경합니다. 필요한 경우 날짜를 표시하고 바인드 변수를 출력하는 행을 주석 처리합니다.
--f. 적립 기금(PF)에 대한 사원의 부담금을 계산합니다. PF는 기본 급여의 12%이며 기본 급여는 급여의 45%입니다. 계산할 때는 바인드 변수를 사용합니다. 표현식을 하나만 사용하여 PF를 계산합니다. 사원의 급여 및 PF 부담금을 출력합니다.
--g. 예제의 출력 결과는 다음과 같습니다.
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

--8. 익명 블록을 생성하시오.
--a. employees 및 employee_details 테이블에는 동일한 데이터가 있습니다. 
--employee_details 테이블의 데이터를 갱신합니다. employees 테이블의 데이터는 갱신하거나 변경하지 마십시오. 
--b. 이 코드는 유저가 입력한 사원 번호 및 부서 번호를 받아들입니다. 
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

--9. departments 테이블에서 최대 부서 ID를 선택하여 max_deptno 변수에 저장하는
--PL/SQL 블록을 생성합니다. 최대 부서 ID를 표시합니다.
--a. 선언 섹션에서 NUMBER 유형의 max_deptno 변수를 선언합니다.
--b. BEGIN 키워드로 실행 섹션을 시작하고 departments 테이블에서 최대
--department_id를 검색하는 SELECT 문을 포함시킵니다.
--c. max_deptno를 표시하고 실행 블록을 종료합니다.
--d. 스크립트를 실행하고 lab_04_01_soln.sql로 저장합니다. 예제의 출력
--결과는 다음과 같습니다.
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

--10 .연습 9에서 생성한 PL/SQL 블록을 departments 테이블에 새 부서를 삽입하도록 수정합니다. 
--a. departments.department_name 유형의 dept_name 및 NUMBER 유형의 dept_id라는 두 개의 변수를 선언합니다. 선언 섹션에서 dept_name에 "Education"을 할당합니다.
--b. 앞에서 이미 departments 테이블에서 현재 최대 부서 번호를 검색했습니다. 
--이 부서 번호에 10을 더하여 해당 결과를 dept_id에 할당합니다. 
--c. departments 테이블의 department_name, department_id 및 location_id 열에 데이터를 삽입하는 INSERT 문을 포함시킵니다. 
--department_name, department_id에는 dept_name, dept_id의 값을 사용하고 location_id에는 NULL을 사용합니다.
--d. SQL 속성 SQL %ROWCOUNT를 사용하여 적용되는 행 수를 표시합니다. 
--e. select 문을 실행하여 새 부서가 삽입되었는지 확인합니다. "/"로 PL/SQL 블록을 종료하고 스크립트에 SELECT 문을 포함시킵니다.
--f. 예제의 출력 결과는 다음과 같습니다.
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

--11. 연습 문제 10에서 location_id를 널로 설정했습니다. 새 부서의 location_id를
--3000으로 갱신하는 PL/SQL 블록을 생성합니다. 변수 dept_id 값을 사용하여 행을
--갱신합니다. 
--a. BEGIN 키워드로 실행 블록을 시작합니다. 새 부서(dept_id = 280)의
--location_id를 3000으로 설정하는 UPDATE 문을 포함시킵니다.
--b. END 키워드로 실행 블록을 종료합니다. "/" 로 PL/SQL 블록을 종료하고 갱신한 부서가
--표시되도록 SELECT 문을 포함시킵니다.
--c. 추가한 부서를 삭제하도록 DELETE 문을 포함시킵니다.
--d. 예제의 출력 결과는 다음과 같습니다.
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

--12. 익명블럭을 생성하시오.
--a. 1에서 10까지의 숫자를 삽입합니다(6, 8 제외).
--b. 블록 종료 전에 커밋합니다.
--c. SELECT 문을 실행하여 PL/SQL 블록이 실행되었는지 확인합니다. 출력은 다음과 같아야 합니다
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

--13. 익명블럭을 생성하시오. 
--a. employees 테이블의 복제본인 emp 테이블을 생성합니다. 이 스크립트는 데이터 유형은 VARCHAR2이고 크기는 50인 새 열 stars를 추가하도록 emp 테이블을 변경합니다. 사원의 급여에 대해 $1000 단위마다 stars 열에 별표를 삽입하는 PL/SQL 블록을 생성합니다. 
--a. DEFINE 명령을 사용하여 empno라는 변수를 정의하고 176으로 초기화합니다.
--b. 블록의 선언 섹션을 시작하고 치환 변수를 통해 empno 값을 PL/SQL 블록으로 전달합니다. emp.stars 유형의 asterisk 변수를 선언하고 NULL로 초기화합니다. 
--emp.salary 유형의 sal 변수를 생성합니다.
--c. 실행 섹션에서 급여 금액에 대해 $1000 단위마다 별표(*)를 추가하는 논리를 작성합니다. 예를 들어, 사원의 급여가 $8000이면 별표 문자열에는 8개의 별표가 있어야 합니다. 급여가 $12500이면 별표 문자열에는 13개의 별표가 있어야 합니다. 
--d. 해당 사원의 stars 열을 별표 문자열로 갱신합니다. 블록 종료 전에 커밋합니다.
--e. emp 테이블의 행을 출력하여 PL/SQL 블록이 성공적으로 실행되었는지 확인합니다
--EMPLOYEE_ID     SALARY      STARS
--176             8600        *********

