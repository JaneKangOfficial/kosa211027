-- 테이블(자료형), not null, default, primay key, unique
-- insert
-- number, char, varchar2, date, long, clob, timestemp
-- number(4), number(8,2)(권장) => number(7,2)
-- print("나의 키는 %8.2f입니다."  %17555.50)

select * from departments;
drop table departments;
create table departments(       -- 부서 정보
    department_id number(4) primary key,
    department_name varchar2(30) not null,
    manager_id number(6),
    location_id number(4)
);

select * from employees;
desc employees;

desc departments;

-- 제약조건 확인
select * from user_constraints where table_name = 'DEPARTMENTS';

drop table departments;
-- 제약조건(constraint)에 이름 붙이기
create table departments (  -- 열레벨
    department_id number(4) constraint dep_depid_PK PRIMARY KEY,
    department_name varchar2(30) CONSTRAINT dep_depname_nn not null,
    manager_id number(6),
    location_id number(4)
);

desc departments;

-- 테이블명은 대문자로 찾아야 한다.
select * from user_constraints where table_name = 'DEPARTMENTS';

drop table departments;
create table departments (  -- table 레벨 (주로 열레벨보다 테이블레벨을 많이 사용함)
    department_id number(4),
    department_name varchar2(30) not null,  -- not null은 열레벨만 가능
    manager_id number(6),   -- 부서장번호 -- 직원번호
    location_id number(4),
    constraint dep_depId_PK primary key(department_id)
--    constraint dep_depname_NN not null(department_name)  -- not null 은 테이블레벨에 쓸 수 없다. 무조건 열레벨
);

desc departments;
select * from user_constraints where table_name = 'DEPARTMENTS';

insert into departments
values(90, 'Executive', 100, 1700);

select * from departments;
select * from employees where employee_id = 100;

--- 외래키
drop table departments;
create table departments(
    department_id number(4) primary key,
    department_name varchar2(30),
    manager_id number(6) REFERENCES employees(employee_id), -- 기본키를 참조 
    location_id number(4)
);

select * from user_constraints where table_name = 'EMPLOYEES';

-- 열레벨
drop table departments;
create table departments ( 
    department_id number(4) constraint dep_depid_PK primary key,
    department_name varchar2(30) not null,  
    manager_id number(6) constraint dep_mngid_FK REFERENCES employees(employee_id),  
    location_id number(4)
);

-- table 레벨 (유지보수가 편하다)
drop table departments;
create table departments ( 
    department_id number(4),
    department_name varchar2(30),  
    manager_id number(6),  
    location_id number(4),
    constraint dep_depid_PK primary key(department_id),
    constraint dep_mngid_FK foreign key(manager_id) REFERENCES employees (employee_id)
);

select * from employees;

insert into departments values(90, 'Executive', 100, 1700);

select * from departments;

-- insert into departments values(100, 'Finance', 108, 1700); -- 부모 키가 없습니다 (employee_id에 없는 manager_id)

delete from employees where employee_id = 100; -- 참조하고 있는 data가 있으면 삭제할 수 없다.
-- employees를 부모테이블
-- departments를 자식테이블
-- 자식테이블에 참조키가 있는 경우 : 자식테이블에 데이터가 있으면 부모테이블의 데이터(기본키)는 삭제할 수가 없다.

delete from departments     -- 자식테이블
where manager_id = 100;

delete from employees       -- 부모테이블
where employee_id = 100;

-- 복합식별자 
drop table a;
create table a (
    a1 number primary key,
    a2 number
);
insert into a values (1,1);

create table b(
    a1 number,     -- 외래키     -- 기본키      -- pk / fk
    b1 number,                   -- 기본키     -- pk
    b2 number,
    constraints b_a1_FK foreign key(a1) references a(a1),
    constraints b_a1_PK primary key(a1, b1)     -- 복합키 (키 하나, 컬럼 둘)
-- constraints b_b1_PK primary key(b1) -- 테이블에는 하나의 기본 키만 가질 수 있습니다.
);
-- 기본키는 무조건 테이블에 한개이다.
-- 복합키는 하나의 기본키에 여러개 컬럼을 묶어 놓은 것을 말한다.
-- 복합키인 경우 컬럼 값 중 하나만 달라도 중복 값이 아니다.

select * from a;
insert into b values(1, 11, 12);
-- insert into b values(1, 11, 22); -- pk(a1, b1) 중복
insert into b values(1, 22, 22); -- pk(a1, b1) 둘중 하나만 다르면 다른 값

create table c (
    a1 number,  -- 외래키   -- fk
    b1 number,  -- 외래키   -- fk
    c1 number,  -- 기본키   -- pk
    c2 number,
    constraint c_a1_b1_FK foreign key(a1, b1) references b(a1, b1)  -- 복합키를 foreign key로 사용할 경우 칼럼의 순서와 개수가 같아야 한다.
    constraint c_c1_PK primary key(c1)
);

--- check 
insert into employees(
    employee_id, first_name, last_name, email, phone_number, 
    hire_date, job_id, salary, department_id)
values(
    100, 'Steven', 'King', 'SKING', '515.123.4567', 
    '2003-06-17', 'AD_PRES', -24000, 90);

select * from employees;

create table c1 (
    c1 number check (c1 > 0),   -- c1은 0보다 커야 한다.
    c2 number
);

-- insert into c1 values (0, 1);   -- 체크 제약조건(KOSA.SYS_C008371)이 위배되었습니다
insert into c1 values (1, 1);
select * from c1;

create table c2 (
    c1 number check (c1 > 0),
--    c2 number check (c2 > c1)   -- 열 검사제약은 다른 열을 참조할 수 없습니다 / 열레벨로는 안됨
);

create table c2 (
    c1 number,
    c2 number,
    check (c1 > 0),
    check (c2 > c1)     -- 테이블레벨에서는 가능
);

-- insert into c2 values(1,1);     -- 체크 제약조건(KOSA.SYS_C008373)이 위배되었습니다
insert into c2 values(1,2);
select * from user_constraints where table_name = 'C2';

create table c3 (
    c1 number,
    c2 number,
    constraint c_c1_CK check (c1 > 0),
    constraint c_c2_CK check (c2 > c1)
);

select * from user_constraints where table_name = 'C3';

drop table c4;
create table c4 (
    c1 number check (c1 between 1 and 100),     -- c1은 1과 100사이만 가능 
    c2 varchar2(20) check (c2 in ('a', 'b', 'c')),     -- c2는 a,b,c만 저장 가능
    c3 varchar2(20) check (c3 in ('서울', '부산', '대구', '대전')),      -- c3는 서울,부산,대구,대전만 저장 가능
--    c4 varchar2(20) check (c4 like '[a-f]%')    -- c4의 첫글자는 a에서 f까지 가능하다. -- 예전엔 됐으나 지금은 안되는 기능 
);

create table c4 (
    c1 number check (c1 between 1 and 100),
    c2 varchar2(20) check (c2 in ('a', 'b', 'c')), 
    c3 varchar2(20) check (c3 in ('서울', '부산', '대구', '대전'))
);

insert into c4(c1, c2, c3) values(100, 'a', '서울');

-- 테이블 수정 : alter
create table c5 (
    c1 number,
    c2 number,
    c3 number
);

-- c3을 name으로 컬럼명 변경
alter table c5 
rename column c3 to name;

desc c5;

-- name 컬럼에 number인 데이터타입을 varchar2로 변경
alter table c5
modify name varchar2(20);

desc c5;

-- name 컬럼에 varchar2인 데이터타입을 number로 변경
alter table c5
modify name number;     -- '홍길동' varchar2 데이터가 있는 경우 number로 변경할 수 없다.

desc c5;

alter table c5
modify name varchar2(20);
desc c5;

alter table c5
modify name varchar2(100);
desc c5;

-- 컬럼 추가하기
alter table c5
add (c4 number, c5 varchar2(30));
desc c5;

alter table c5
add (c6 number);
desc c5;

-- 컬럼 삭제하기
alter table c5
drop column c6;     -- delete : 데이터 삭제 / drop : 객체 삭제
desc c5;

-- alter table c5
-- drop column (c4, c5);   -- 삭제는 무조건 하나씩만 가능하다.

--
drop table departments;
create table departments ( 
    department_id number(4),
    department_name varchar2(30),  
    manager_id number(4)
);
desc departments;

alter table departments
add (location_id number(4));
desc departments;

alter table departments
modify manager_id number(6);
desc departments;

alter table departments
add first_name varchar2(25);
desc departments;

alter table departments
drop column first_name;
desc departments;

-- 테이블에 제약조건 추가하기
select * from user_constraints where table_name = 'DEPARTMENTS';
-- table 레벨
alter table departments
add constraint dep_depid_PK primary key(department_id);

alter table departments
drop constraint dep_depid_PK;

-- 열레벨
alter table departments
modify department_id constraint dep_depid_PK primary key;

-- 외래키 추가
alter table departments     -- table 레벨
add constraint dep_mng_fk foreign key (manager_id) references employees(employee_id);

alter table departments
drop constraint dep_mng_fk;

alter table departments     -- 열레벨
modify manager_id constraint dep_mng_fk references employees(employee_id);

select * from user_constraints where table_name = 'DEPARTMENTS';

-- table레벨 : 동시에 여러개 컬럼 추가 됨
alter table departments
add (constraint dep_depid_pk primary key (department_id),
    constraint dep_mngid_fk foreign key (department_id) references employess(department_id));
    
-- 동시에 여러개 컬럼을 변경할 수 있다.
alter table departments
modify (manager_id number(4), location_id varchar2(20));

alter table departments
modify (manager_id number(6), location_id number(4));

-- 열레벨로 여러개의 제약조건을 추가할 수 있다.
alter table departments
modify(
    department_id constraint dep_depid_pk primary key,
    manager_id constraint dep_mngid_fk REFERENCES employees(employee_id)
);

--
drop table departments;
drop table employees;

create table employees(
    employee_id     number(6),
    first_name   varchar2(20),
    last_name    varchar2(25),
    email        varchar2(25),
    phone_number    varchar2(20),
    hire_date       date,
    job_id      varchar2(10),
    salary      number(8,2),
    commission_pct   number(2,2),
    manager_id       number(6),
    department_id   number(4)
);
desc employees;

create table departments ( 
    department_id number(4),
    department_name varchar2(30) not null,  
    manager_id number(6),  
    location_id number(4)
);
desc departments;

-- primary key
alter table departments
add constraint dep_depid_pk primary key(department_id);

alter table employees
add constraint emp_empid_pk primary key(employee_id);

-- foreign key
alter table employees
add constraint emp_deptid_fk foreign key(department_id)
    references departments(department_id);
    
alter table departments
add constraint emp_mngid_fk foreign key(manager_id)
    references employees(employee_id);

-- unique (UU, UK)
alter table employees
add constraint emp_email_UK unique (email);

-- check (CK)
alter table employees
add constraint emp_salary_CK check (salary > 0);

-- not null, default
alter table employees
modify (last_name not null, email not null, hire_date default sysdate not null, job_id not null);

alter table departments
rename column department_name to department_name;

alter table departments
modify (department_name not null);

select * from user_constraints where table_name = 'EMPLOYEES';
select * from user_constraints where table_name = 'DEPARTMENTS';

-- table 만들기
drop table job_history;
create table job_history (
    employee_id    number(6),
    start_date     date not null,
    end_date       date not null,
    job_id         varchar2(10) not null,
    department_id  number(4)
);
desc job_history;  
    
alter table job_history
add constraint job_depid_PK primary key (employee_id, start_date);

alter table job_history
add constraint job_depid_FK foreign key (department_id)
    references departments(department_id);

alter table job_history
add constraint job_empid_FK foreign key (employee_id)
    references employees(employee_id);

select * from user_constraints where table_name = 'JOB_HISTORY';

drop table jobs;
create table jobs (
    job_id varchar2(10),
    job_title varchar2(35) not null,
    min_salary number(6),
    max_salary number(6)
);
--alter table jobs
--modify job_title not null;

alter table jobs
add constraint jobs_jobid_PK primary key (job_id);

alter table job_history
add constraint job_jobid_FK foreign key (job_id)
    references jobs(job_id);
    
desc jobs;
insert into jobs(job_id, job_title, min_salary, max_salary)
values('AD_PRES', 'President', 20080, 40000);

insert into jobs(job_id, job_title, min_salary, max_salary)
values('AD_VP', 'Administration Vice President', 15000, 30000);

select * from jobs;

-- 사용 중지
Alter table departments
disable constraint emp_mngid_fk;

desc departments;

insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
values(10, 'Administration', 200, 1700);

select * from departments;

insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
values(20, 'Marketing', 201, 1800);

select * from departments;  -- data 27개
select * from employees;    -- data 107개
select * from jobs;         -- date 19개

-- 사용
Alter table departments
enable constraint emp_mngid_fk;

desc job_history;

insert into job_history(EMPLOYEE_ID, START_DATE, END_DATE, JOB_ID, DEPARTMENT_ID)
values(102, '2001-01-13', '2006-07-24', 'IT_PROG', 60);

insert into job_history(EMPLOYEE_ID, START_DATE, END_DATE, JOB_ID, DEPARTMENT_ID)
values(101, '1997-09-21', '2001-10-27', 'AC_ACCOUNT', 110);

insert into job_history(EMPLOYEE_ID, START_DATE, END_DATE, JOB_ID, DEPARTMENT_ID)
values(101, '2001-10-28', '2005-03-15', 'AC_MGR', 110);

select * from job_history;  -- data 10개

select * from employees;
select * from jobs;
select * from user_constraints where table_name = 'EMPLOYEES';
select * from user_cons_columns where table_name = 'EMPLOYEES';

alter table employees
add constraint emp_jobs_id_fk foreign key(job_id)
    references jobs(job_id);        -- job_id 같으면 생략 가능
    
--- INDEX
SELECT * FROM employees
WHERE first_name = 'Lex';

drop index first_name_IDX;

create INDEX first_name_IDX
ON employees(first_name);
--- INDEX는 SELECT를 하면 자동으로 사용하게 된다.
--- WHERE 조건절에서 주로 사용되는 컬럼에 INDEX를 만들어 준다.

alter table c
add constraint c_pk primary key(c1, c2, c3);    -- PRIMARY KEY는 자동으로 INDEX를 만들어서 사용한다.
--- 정렬된 컬럼부터 앞에 오는 것이 좋다.
--- 자주 사용되는 컬럼부터 앞에 오는 것이 좋다.
--- INDEX는 SELECT할 때 사용된다.
--- INDEX는 INSERT나 DELETE 나 UPDATE시 INDEX를 조회한 후 사용해야 되는 경우 시스템 성능에 영향을 미칠 수 있다.

select * from employees where employee_id = 100;

-- 시퀀스 : 번호 자동 생성기
select * from employees;
create SEQUENCE SEQ_NUM
INCREMENT BY 1      -- 증가분
START WITH 207      -- 207부터 시작
MAXVALUE 999999999999
-- MINVALUE 21        -- 주로 사용하지 않는다. 
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_NUM;

SELECT SEQ_NUM.NEXTVAL FROM dual;
SELECT SEQ_NUM.CURRVAL FROM dual;

desc c1;
insert into c1(c1,c2) values(seq_num.nextVal, 1);
select * from c1;

SELECT * FROM DEPARTMENTS;
INSERT INTO DEPARTMENTS
VALUES(SEQ_NUM.NEXTVAL, 'TEST', 100, 1500);

SELECT * FROM DEPARTMENTS;