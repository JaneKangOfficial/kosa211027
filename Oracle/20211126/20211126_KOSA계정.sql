-- ex3_6이라는 테이블을 만들고, 사원테이블 (employees)에서 
-- 관리자 사번이 124번이고 급여가 2000에서 3000사이에 있는 사원의 사번, 사원명, 급여, 관리자 사번을 입력하는 insert문을 작성해보자.
create table ex3_6 (
    employee_id     number(6),
    emp_name        varchar2(80),
    salary          number(8,2),
    manager_id      number(6)
);

insert into ex3_6
select employee_id, first_name, salary, manager_id from employees
where employee_id = 124 and salary between 2000 and 10000;

-- 사원테이블(employees)에서 커미션(commission_pct) 값이 없는 사원의 사번과 사원명을 추출하는 쿼리를 작성해보자.
select employee_id, first_name, commission_pct
from employees
where commission_pct is null;

-- 논리연산으로 변경하시오.
--    select employee_id, salary
--    from employees
--    where salary between 2000 and 2500
--    order by employee_id;

select employee_id, salary
from employees
where salary >= 2000 and salary <= 2500;

-- any로 변경하세요.
--    select employe_id, salary
--    from employees
--    where salary IN (2000, 3000, 4000)
--    order by employee_id;

select employee_id, salary
from employees
where salary = any (2000, 3000, 4000)
order by employee_id;

-- all로 변경하세요.
--    select employe_id, salary
--    from employees
--    where salary not IN (2000, 3000, 4000)
--    order by employee_id;

select employe_id, salary
from employees
where salary <> all (2000, 3000, 4000)
order by employee_id;

-- 사원테이블(employees)에는 phone_number라는 컬럼에 사원의 전화번호가 ###.###.#### 형태로 저장되어 있다.
-- 여기서 처음 3자리 숫자 대신 서울 지역번호인 (02)를 붙여 전화번호를 출력하도록 쿼리를 작성해보자. Lpad 사용.
select lpad(substr(phone_number,5), length(phone_number), '(02)')
from employees;

-- 현재일자 기준으로 사원테이블의 입사일자(hire_date)를 참조해서 근속년수가 10년 이상인 사원을 다음과 같은 형태의 결과로 출력하도록 쿼리를 작성해보자.
-- (근속년수가 많은 사원순서대로 결과를 나오도록 하자), 사원번호, 사원명, 입사일자, 근속년수,
select employee_id, first_name, hire_Date, round((sysdate - hire_date) / 365) as 근속년수
from employees
where  round((sysdate - hire_date) / 365) >= 10
order by 근속년수 desc;

--- 사원번호, 사원명, 급여, 전화번호를 출력할 때, 급여를 통화 단위로, 전화번호는 . 대신 -로 출력되게 쿼리문을 작성하시오.
select employee_id, first_name, to_char(salary, '$999,999,999'), replace(phone_number, '.', '-')
from employees;

-- 근속년수가 19년차 이상이면 이사
--          18년차 이상이면 본부장
--          17년차 이상이면 부장
--          16년차 이상이면 차장
--          15년차 이상이면 과장
--          14년차 이상이면 대리
--                이하 사원으로 출력하시오.
select employee_id, first_name, round((sysdate - hire_date)/365) as 근무연수,
        case when round((sysdate - hire_date)/365) >= 19 then '이사'
             when round((sysdate - hire_date)/365) >= 18 then '본부장'
             when round((sysdate - hire_date)/365) >= 17 then '부장'
             when round((sysdate - hire_date)/365) >= 16 then '차장'
             when round((sysdate - hire_date)/365) >= 15 then '과장'
             when round((sysdate - hire_date)/365) >= 14 then '대리'
             else '사원' end 직책
from employees
order by 근무연수 desc;

-- 급여를 1000으로 나눈 몫이 3이하면 사원, 5이하면 주임, 7이하면 대리, 
-- 9이하면 과장, 10이하면 차장, 13이하면 부장, 15이하면 본부장, 그 외 이사
select first_name, salary, trunc(salary/1000) as sal,
        case when trunc(salary/1000) <= 3 then '사원'
             when trunc(salary/1000) <= 5 then '주임'
             when trunc(salary/1000) <= 7 then '대리'
             when trunc(salary/1000) <= 9 then '과장'
             when trunc(salary/1000) <= 10 then '차장'
             when trunc(salary/1000) <= 13 then '부장'
             when trunc(salary/1000) <= 15 then '본부장'
             else '이사' end 직책
from employees
order by sal desc;
                            
-- 사원테이블에서 입사년도별 사원수를 구하는 쿼리를 작성해보자.
select to_char(hire_date,'yyyy')as y, count(*)
from employees
group by to_char(hire_date,'yyyy')      -- 날짜일 경우 substr보다는 to_char를 사용하는 것이 낫다.
order by y desc;

-- 아래의 쿼리는 분할 rollup을 적용한 쿼리이다.
--    select department_id, job_id, sum(salary) totl_jan
--    from employees
--    where hire_date like '03%'
--    group by department_id, rollup(job_id);          
--이 쿼리를 rollup을 사용하지 않고, 집합연산자를 사용해서 동일한 결과가 나오도록 쿼리를 작성해보자. union

select department_id, job_id, sum(salary) totl_jan
from employees
where hire_date like '03%'
group by department_id, job_id
union
select department_id, null, sum(salary) totl_jan
from employees
where hire_date like '03%'
group by department_id;
-- rollup이 뒤에 있을 경우 : '모두 다'는 안 나온다.

-- 사번, 사원명, job 명칭, job 시작일자, job 종료일자, job 수행부서명, 101번 사원만 출력
select e.employee_id, e.first_name, j.job_title, jh.start_date, jh.end_date, d.department_name
from employees e, jobs j, job_history jh, departments d
where e.employee_id = jh.employee_id and jh.department_id = d.department_id and j.job_id = jh.job_id
        and e.employee_id = 101;

-- 다음의 쿼리를 ANSI JOIN으로 변경해보자.
--    select a.department_id, a.department_name
--    from departments a, employees b
--    where a.department_id = b.department_id
--    and b.salary > 3000
--    order by a.department_name;

select a.department_id, a.department_name
from departments a join employees b
on a.department_id = b.department_id
where b.salary > 3000
order by a.department_name;

-- 각 부서의 급여를 제일 적게 받는 사원들을 구하시오.
select e.employee_id, first_name, last_name, hire_date, salary, d.department_id, minsal
from employees e, (select department_id, min(salary) as minsal
                from employees
                group by department_id) d
where e.department_id = d.department_id
order by department_id;

select * from employees
where salary in (select min(salary) from employees group by department_id);

--- merge : insert, update
-- 원하는 테이블에 데이터가 없으면 insert
--              데이터가 있으면 update
select * from ex3_6;
desc ex3_6;
merge into ex3_6 a              -- 장바구니 상품 수량
      using (select * from employees where employee_id = 103) b
      on (a.employee_id = b.employee_id)
WHEN MATCHED THEN
      update set salary = salary * 1.1
WHEN not MATCHED THEN
      insert (a.employee_id, a.emp_name, a.salary, a.manager_id)
      values (b.employee_id, b.first_name, 15000, 100);

select * from ex3_6;