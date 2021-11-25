select employee_id, last_name, salary
from employees
where department_id = 80;

-- view 생성
create view vw_80
as
select employee_id, last_name, salary
from employees
where department_id = 80;

select * from vw_80;
desc vw_80;

create view vw_50
as
select employee_id as eid, last_name as lname, salary as sal
from employees
where department_id = 50;

select * from vw_50;
desc vw_50;

create view vw_70
(did, lname, sal)
as
select employee_id, last_name, salary
from employees
where department_id = 70;

select * from vw_70;

-- view 는 실제 데이터가 아니라 부분수정이 불가능하다.

create or replace view vw_70    -- create or replace : view를 다시 삭제했다가 만드는거와 마찬가지
(did, lname, year_sal)
as
select employee_id, last_name, salary * 12
from employees
where department_id = 70;

create or replace view vw_year_sal      -- 일반적으로 처음 만들 때부터 or replace로 만든다.
(eid, fname, hire_date, year_sal)
as
select employee_id, first_name, hire_date, (salary + salary * nvl(commission_pct,0)) * 12
from employees
where job_id like '%MAN%';

select * from vw_year_sal;

--- 각 부서명별 최저 임금과 최대 임금, 평균 임금을 출력하시오.
select department_name, min(salary), max(salary), avg(salary)
from employees, departments
group by department_name;

create or replace view dept_sal_vw      -- 복합뷰 : 두개의 테이블을 조인
(dname, minsal, maxsal, avgsal)
as
select department_name, min(salary), max(salary), avg(salary)
from employees, departments
group by department_name;

select * from dept_sal_vw;

-- 직원번호, 이름, 입사일, 급여, 부서번호, 부서명을 출력하는 뷰를 만들자.
create or replace view emp_dept_vw          -- 복합뷰
(eid, fname, hdate, sal, did, dname)
as
select employee_id, first_name, hire_date, salary, d.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;

select * from emp_dept_vw;

create or replace view vw_30
as
select employee_id, last_name, email, hire_date, job_id, department_id
from emp
where department_id = 30;

select * from vw_30;

insert into vw_30   -- 뷰를 통해서 실제 테이블에 데이터가 들어갈 수 있다.
values(310, 'Rhee', 'hemail', sysdate, 'AP', 210);

select * from emp;

insert into vw_30 (  -- 뷰를 통해서 보여지지 않는 컬럼이 있으면 데이터를 저장할 수 없다.
                    employee_id, last_name, email, hire_date, job_id, department_id, manager_id) 
values(320, 'Park', 'pmail', sysdate, 'AP', 210, 110);

update vw_30         -- 뷰를 통해서 보여지지 않는 데이터는 수정할 수 없다.
set last_name = 'srhee'
where employee_id = 310;

select * from emp;

update vw_30        -- 뷰를 통해서 보여지는 데이터는 수정이 가능하다.
set hire_date = sysdate
where employee_id = 115;

select * from vw_30;

update vw_30        -- 뷰를 통해서 보여지지 않는 컬럼의 데이터는 수정할 수 없다.
set manager_id = 100
where employee_id = 115;

delete from vw_30      -- delete : 행 자체를 삭제
where employee_id = 115;    -- 뷰를 통해서 보여지는 데이터는 삭제할 수 있다.

select * from vw_30;

delete from vw_30   -- 뷰를 통해서 보여지지 않는 데이터는 삭제할 수 없다.
where employee_id = 310;

--- 뷰를 통해서 DML문을 사용할 수 있다.
-- 단 insert만 뷰에서 보이지 않아도 저장이 된다.

create table viewup1(
    c1 number primary key,
    c2 number
);

create table viewup2(
    c1 number primary key,
    c3 number
);

insert into viewup1 values(1, 1);
insert into viewup2 values(1, 1);

create or replace view v_viewup
as
select t1.c1, t1.c2, t2.c3
from viewup1 t1, viewup2 t2
where t1.c1 = t2.c1;

select * from v_viewup;

update v_viewup
set c2 = 10         -- 복합뷰에서 한 테이블에 있는 컬럼의 값(c2)은 수정이 가능하다.
where c1 = 1;

select * from v_viewup;
select * from viewup1;

update v_viewup
set c3 = 10         -- 복합뷰에서 한 테이블에 있는 컬럼의 값(c3)은 수정이 가능하다.
where c1 = 1;

select * from v_viewup;
select * from viewup2;

update v_viewup
set c3 = 20, c2 = 20     -- 뷰를 통해서 두 테이블의 데이터를 수정할 수가 없다.
where c1 = 1;

insert into v_viewup values(2,2,2); -- 뷰를 통해서 두 테이블의 데이터를 입력할 수 없다.
insert into v_viewup(c1,c2) values(2,2);

select * from v_viewup;
select * from viewup1;     

insert into v_viewup(c1,c3) values(2,2);    -- c1은 viewup1에 있는 것을 사용하므로 viewup2에서는 c1을 사용할 수 없다.
select * from v_viewup;
select * from viewup2;

delete from v_viewup
where c1 = 1;           -- viewup1에 있는 c1을 삭제하겠다.
select * from v_viewup;
select * from viewup1;      -- c1 : 2, c2 : 2
select * from viewup2;      -- c1 : 1, c3 : 10
-- 복합뷰는 DML문이 제한적으로 사용이 된다.

create or replace view empvw20
as
select * from emp where department_id = 20;

select * from empvw20;

insert into empvw20 (employee_id, last_name, email, hire_date, job_id, department_id)
values(320, 'Park', 'pamail', sysdate, 'AP', 210);

select * from emp where employee_id = 320;

-- 20인 부서만 insert 하도록
create or replace view empvw20
as
select * from emp where department_id = 20
with check option constraint empvw20_ck;    -- with check option은 뷰에서 보이게 되는 데이터로만 수정, 삭제, 삽입이 가능

select * from empvw20;

insert into empvw20 (employee_id, last_name, email, hire_date, job_id, department_id)
values(330, 'Park', 'pamail', sysdate, 'AP', 210);      -- ORA-01402: 뷰의 WITH CHECK OPTION의 조건에 위배 됩니다

--
update empvw20
set department_id = 50      -- 수정 후 보여지지 않는 데이터는 수정할 수 없다. ORA-01402: 뷰의 WITH CHECK OPTION의 조건에 위배 됩니다
where employee_id = 201;

create or replace view empvw80
as
select * from emp
where department_id = 80
with read only;             -- with read only : 읽기 전용 뷰 -- 모든 DML문을 거부

select * from empvw80;

delete from empvw80         -- ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.
where employee_id = 147;

-- 뷰 삭제
drop view empvw80;
select * from empvw80;      -- 테이블 또는 뷰가 존재하지 않습니다.
-- select는 테이블 또는 뷰에 있는 데이터를 검색하기 위해서 사용

-- from절에 있는 sub query : 인라인 뷰
--- 성, 급여, 부서번호, 부서의 최소급여
select last_name, salary, e.department_id, minsal
from employees e, (select department_id, min(salary) as minsal 
                    from employees
                    group by department_id) d       -- 인라인 뷰
where e.department_id = d.department_id;

--- 직원번호, 이름, 직무, 입사일, 급여, 각 부서의 사원수 및 평균급여를 출력
select employee_id, first_name, job_id, hire_date, salary, d.department_id, cnt, avgsal
from employees e , ( select department_id, count(*) as cnt, avg(salary) as avgsal
                     from employees
                     group by department_id) d
where e.department_id = d.department_id;

-- 사원번호, 이름, 급여, 부서, 직무, 급여를 제일 많이 받는 사람부터 출력
select employee_id, first_name, salary, department_id, job_id
from employees
order by salary desc;

-- top - n
-- select 에는 항상 rownum 이 숨어져 있다.
-- 급여를 제일 많이 받는 사람 5명을 가져오시오.
select rownum, rn, employee_id, first_name, salary, department_id, job_id
from ( select rownum rn, employee_id, first_name, salary, department_id, job_id
        from employees
        order by salary desc)   -- rn은 데이터 순으로 1,2,3... salary에 맞게 정렬 후 rn 섞임, rownum은 salary 정렬 순으로 1,2,3...
where rownum <= 5;

-- 최근 게시글 제목만 5개 가져오기
--select rownum, subject
--from (select subject, reg_date
--      from board
--      order by reg_date desc)
--where rownum <= 5;

-- 급여를 제일 많이 받는 사원 10위부터 15위까지 출력하시오. 사원번호, 이름, 급여, 부서, 직무
select rownum, rn, employee_id, first_name, salary, department_id, job_id    
-- rownum은 범위 값을 가질 수 없다. 범위 값을 가지려면 한번 더 서브쿼리를 만든다. rn을 가지기 위해서.
from   ( select rownum rn, employee_id, first_name, salary, department_id, job_id
        from (select employee_id, first_name, salary, department_id, job_id
                        from employees
                        order by salary desc)
        )
where rn >= 10 and rn <= 15;            -- paging할 때 사용 

-- 사원번호, 이름, 급여, 부서, 직무를 출력할 때 커미션을 제일 많이 받는 사원 5명을 출력하세요.
select rownum, rn, employee_id, first_name, salary, department_id, job_id, commission_pct
from (select rownum rn, employee_id, first_name, salary, department_id, job_id, commission_pct 
      from employees
      where commission_pct is not null
      order by commission_pct desc)
where rownum <= 5;

-- 사원번호, 이름, 급여, 부서, 직무를 출력할 때 커미션을 포함한 연봉을 제일 많이 받는 사원 6위에서 10위까지 출력하세요.
select rownum, rn, employee_id, first_name, salary, department_id, job_id, year_sal
from ( select rownum rn, employee_id, first_name, salary, department_id, job_id, year_sal
       from (select employee_id, first_name, salary, department_id, job_id, (salary + salary * nvl(commission_pct,0)) * 12 as year_sal
             from employees
             order by year_sal desc)
     )
where rn >= 6 and rn <= 10;

-- group by 절의 향상된 기능
-- 부서별 직무에 대한 급여 합계, 부서번호, 직무를 출력하시오.
select department_id, job_id, sum(salary)
from employees 
group by department_id, job_id;                
                
-- 부서별 급여의 평균이 9500이상인 부서만 출력하세요.
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) >= 9500;

---- 부서별 직무의 급여 평균, 부서별 급여 평균, 전체 평균 출력하세요.
select department_id,    job_id,        avg(salary)
from employees
group by department_id, job_id
union
select department_id,   to_char(null),   avg(salary)
from employees
group by department_id
union
select to_number(null),  to_char(null),   avg(salary)
from employees;
------------------------------------------------------
-- rollup : 뒤에서부터 지우면서 묶는다. 하위 집계
select department_id,    job_id,        avg(salary)
from employees
group by ROLLUP (department_id, job_id);
-- (department_id, job_id)
-- (department_id)
-- ()
--======================================================

--- 각 부서에서 같은 직무를 하면서 입사일이 같은 사원수, 급여평균
--- 각 부서의 직무별 사원수, 급여평균
--- 각 부서의 사원수, 급여평균
--- 전체 사원수, 급여평균
select department_id, job_id, hire_date, count(*), avg(salary)
from employees
group by department_id, job_id, hire_date
union
select department_id, job_id,   null,     count(*), avg(salary)
from employees
group by department_id, job_id
union
select department_id, null,     null,     count(*), avg(salary)
from employees
group by department_id, null
union
select      null,     null,     null,     count(*), avg(salary)
from employees
group by    null,       null;
----------------------------------------------------------------
select department_id, job_id, hire_date, count(*), avg(salary)
from employees
group by ROLLUP(department_id, job_id, hire_date);
--- (department_id, job_id, hire_date)
--- (department_id, job_id)
--- (department_id)
--- ()
--======================================================

-- 부서와 직무의 급여 합계
-- 부서의 급여 합계
-- 직무의 급여 합계
-- 전체 급여 합계
select department_id,   job_id,    sum(salary)
from employees
group by department_id, job_id
union
select department_id,   null,      sum(salary)
from employees
group by department_id
union
select      null,       job_id,    sum(salary)
from employees
group by job_id
union
select      null,       null,      sum(salary)
from employees;
---------------------------------------------------
-- cube(정육면체) : 모든 조합을 묶는다. 교차 집계
select department_id,   job_id,    sum(salary)
from employees
group by cube (department_id, job_id);
-- (department_id, job_id)
-- (department_id)
-- (job_id)
-- ()
--======================================================

--- 각 부서에서 같은 직무를 하면서 입사일이 같은 사원수, 급여평균
--- 각 부서의 직무별 사원수, 급여평균
--- 각 직무별 입사일 같은 사원수, 급여평균
--- 각 부서에서 입사일 같은 사원수, 급여평균
--- 각 부서의 사원수, 급여평균
--- 각 직무의 사원수, 급여평균
--- 입사일이 같은 사원수, 급여평균
--- 전체 사원수, 급여평균
select department_id, job_id, hire_date, count(*), avg(salary)
from employees
group by cube (department_id, job_id, hire_date);
-- (department_id, job_id, hire_date)
-- (department_id, job_id)
-- (job_id, hire_date)
-- (department_id, hire_date)
-- (department_id)
-- (job_id)
-- (hire_date)
-- ()
--======================================================

--- grouping 함수 : 집계된 컬럼을 확인하기 위해서 사용
-- 집계된 컬럼은 0, 집계되지 않은 컬럼은 1
select department_id, job_id, sum(salary), grouping(department_id), grouping(job_id)
from employees
group by ROLLUP (department_id, job_id);

--- 각 부서의 직무별 같은 상사를 가지고 있는 사원들의 평균급여
--- 각 부서별 같은 상사를 가진 사원들의 평균급여
--- 직무별 같은 상사를 가진 사원들의 평균급여
select department_id, job_id, manager_id, avg(salary)
from employees
group by grouping sets  (department_id, job_id, manager_id),    -- grouping sets : 원하는 컬럼만 집계할 수 있다.
                        (department_id, manager_id),
                        (job_id, manager_id);
--======================================================

-- rollup (a,(b,c),d)
select department_id, job_id, manager_id, sum(salary)
from employees
group by rollup (department_id, (job_id, manager_id));
-- (department_id, (job_id, manager_id))
-- (job_id, manager_id)
-- (department_id)
-- ()

select department_id, job_id, manager_id, sum(salary)
from employees
group by department_id, rollup (job_id), cube(manager_id);
-- (department_id, job_id, manager_id)
-- (department_id, job_id)
-- (department_id)
-- (department_id, manager_id)
-- (job_id, manager_id)은 job_id가 rollup으로 지워져서 묶이지 않는다.

-- 둘은 같은 의미이다.
-- group by department_id, rollup(job_id), rollup(manager_id);
-- group by rollup(department_id, job_id, manager_id);
--======================================================

--- 104번 사원의 부서와 상사가 같은 사원을 출력하시오.
-- 하나씩 비교 : 비쌍 비교
select * from employees
where department_id = (select department_id from employees where employee_id = 104)
and manager_id = (select manager_id from employees where employee_id = 104);

-- 50인 부서에서 하는 업무와 같은 업무를 담당하는 직원들을 찾으시오.
select * from employees
where job_id in (select job_id from employees where department_id = 50);

-- employee_id 가 178번 또는 174번인 사원의 관리자 및 부서와 같은 관리자 및 부서를 갖는 사원의 정보를 표시한다.
-- 단, 178과 174은 출력하지 말것.
select * from employees
where manager_id = (select manager_id from employees where employee_id = 178)
and department_id = (select department_id from employees where employee_id = 178)
union
select * from employees
where manager_id = (select manager_id from employees where employee_id = 174)
and department_id = (select department_id from employees where employee_id = 174);

-- 쌍비교
select * from employees
where (manager_id, department_id) in (
                                    select manager_id, department_id
                                    from employees
                                    where employee_id in (178, 174))
and employee_id not in (178, 174);
--======================================================

-- window 함수
-- 1. RANK() : 동일한 값인 경우 동일한 순위, 다음 등수는 +(동일한 등수의 개수)
-- 1, 2, 2, 4 ... 9, 10, 10, 10, 13

-- 급여를 제일 많이 받는 사람부터 순위를 출력하시오.
select first_name, salary, job_id, 
        rank() over (order by salary desc) all_rank
from employees;

select rownum,  first_name, salary, job_id      -- rownum : 같은 등수가 없다.
from ( select first_name, salary, job_id
       from employees
       order by salary desc);
       
-- 직무별 급여의 순위를 내림차순으로 출력하시오.
select first_name, job_id, salary,
        rank() over(partition by job_id order by salary desc) job_rank    -- partition by: group by 와 마찬가지. rank() over()에는 group by 사용 못함.
from employees;

-- 각 부서에서 입사일이 빠른 사원부터 이름, 직무, 입사일, 랭킹순으로 출력하세요.
select department_id, first_name, job_id, hire_date, 
        rank() over(partition by department_id order by hire_date) hire_rank
from employees;

-- 급여를 제일 많이 받는 사람부터 순위와 직무별 급여의 순위를 출력하시오.
select job_id, salary,
        rank() over(order by salary desc) all_rank,         -- partition by 가 없는 것이 우선순위가 높다.
        rank() over(partition by job_id order by salary desc) job_rank
from employees;

-- 2. DENSE_RANK()   : 동률일 경우 같은 등수이고 다음 등수는 연속적인 값을 갖는다.
-- 1, 2, 2, 3 ... 9, 10, 10, 10, 11
select first_name, job_id, salary,
        rank() over(order by salary desc) all_rank,        
        DENSE_RANK() over(order by salary desc) DENSE_RANK
from employees;

-- 3. row_number()  : 동률도 계속 증가하는 값을 갖는다.
-- 1, 2, 3, 4 ... 9, 10, 11, 12
select first_name, job_id, salary,
        rank() over(order by salary desc) all_rank,        
        row_number() over(order by salary desc) row_number
from employees;

-- 사번, 이름, 이메일, 직무, 급여, 부서의 평균 급여를 출력하세요.
select employee_id, first_name, email, job_id, salary, d.department_id, avgsal
from employees e, (select department_id, avg(salary) as avgsal
                   from employees
                   group by department_id) d
where e.department_id = d.department_id;

-- window 함수 사용
select employee_id, first_name, email, job_id, salary, department_id,
        avg(salary) over (partition by department_id) avgsal
from employees;        