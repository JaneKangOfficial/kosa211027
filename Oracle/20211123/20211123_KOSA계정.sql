--1. 성과 이름을 붙여서 출력하시오.
select last_name || first_name
from employees;
-- 또는 concat이용 가능하나, 이용하기 복잡하기 떄문에 || 기호가 편리함

select concat('나의 이름은 ' , concat(last_name, first_name))
from employees;

-- 2. nvl
-- 성, 이름, 직무, 급여, 커미션을 포함한 연봉
select last_name, first_name, job_id, salary, 
       (salary + salary * nvl(commission_pct,0)) * 12 year_sal
from employees;

-- 3. nvl2
select last_name, first_name, job_id, salary,
--                              널이 아니면 두번째 값 출력,           널이면 세번째 값 출력
        nvl2(commission_pct, (salary + salary * commission_pct) * 12, salary * 12)
from employees;

-- 4. nullif
select first_name, length(first_name),
        last_name, length(last_name),
        --          exp1                   exp2
        nullif(length(first_name), length(last_name)) result
        -- exp1과 exp2가 같으면 null 출력
        -- exp1과 exp2가 다르면 exp1 출력
from employees;

--- 5. coalesce 함수
--                              exp1       exp2   exp3
select last_name, coalesce(commission_pct, salary, 10) comm
--                          exp1 null이 아니면 exp1 출력
--                          exp1 null이면 exp2 출력
--                          exp1과 exp2가 모두 null이면 exp3 출력
from employees;

-- 다중행 함수 (여러개 행의 값을 전달)
--- 6. 급여를 제일 많이 받는 사람과 적게 받는 사람, 급여 평균을 출력하시오.
select max(salary), min(salary), avg(salary)
from employees;

--- 7. 급여를 받는 사람의 수와 부서를 가지고 있는 사람의 수를 출력하시오.
select count(salary), count(department_id)
from employees;
--- 다중행 함수는 null 값은 제외하고 계산한다.

-- 8. 커미션을 받는 사원들의 커미션 평균과 직원 전체의 커미션 평균을 구하시오.
select avg(commission_pct), sum(commission_pct) / count(*)
from employees;
--- 다중행 함수는 null 값을 포함하지 않으므로 전체의 값을 구할 때 값이 다를 수 있다.

-- 9. 전체 사원의 수를 구하시오. (행 전체 개수)
select count(*) from employees;

-- 10. 제일 늦게 입사한 사원과 제일 처음에 입사한 사원을 출력하시오.
select max(hire_date), min(hire_date)
from employees;

-- 11. 직무에 'REP'를 가지고 있는 사원들 중 제일 많이 받는 급여와 적게 받는 급여를 출력하시오.
-- 평균 급여와 사원의 수는
select max(salary), min(salary), avg(salary), count(*)
from employees
where job_id like '%REP%';

-- 출력 결과        107개        107개
select first_name, salary, to_char(hire_date, 'dd-mm-yyyy')
from employees;

-- 출력 결과 1개
select sum(salary) from employees;

-- 다중행 함수를 사용하는 경우 다중행 함수만 사용해야 한다. 컬럼을 추가할 수 없다.
--select first_name, sum(salary)        -- 단일, 다중 같이 사용할 수가 없다.
--from employees;

-- 12. 80번 부서에서 커미션을 받는 사원의 수와 최대 커미션 값과 최소 커미션 값을 출력하시오.
--      부서에 속해 있는 사원의 수
select count(commission_pct), max(commission_pct), min(commission_pct),
        count(*)
from employees
where department_id = 80;

-- 13. 중복되지 않은 부서는?
select distinct(department_id) 
from employees;

-- 14. 중복되지 않은 부서의 수는?
select count(distinct(department_id))
from employees;     -- null은 부서가 아니므로 제외

-- 15. 커미션을 받는 사원의 커미션 평균과 커미션을 받지 않는 사원의 커미션 평균을 구하시오.
select trunc(avg(commission_pct), 4),               -- 0.2228
       trunc(sum(commission_pct) / count(*), 4),    -- 0.0728
       trunc(avg(nvl(commission_pct,0)),4)          -- 0.0728
from employees;

-- 16. 90인 부서의 급여 평균, 합계, 최대, 최소, 사원의 수
select avg(salary), sum(salary), max(salary), min(salary), count(*)
from employees
where department_id = 90;

--     80인 부서의 급여 평균, 합계, 최대, 최소, 사원의 수
select avg(salary), sum(salary), max(salary), min(salary), count(*)
from employees
where department_id = 80;

--     70인 부서의 급여 평균, 합계, 최대, 최소, 사원의 수
select avg(salary), sum(salary), max(salary), min(salary), count(*)
from employees
where department_id = 70;

-- group by
-- 17. 각 부서별 부서의 급여 평균, 합계, 최대, 최소, 사원의 수
select department_id,    -- group by절에 있는 컬럼은 select절에 사용 가능하다.
       trunc(avg(salary),2), sum(salary), max(salary), min(salary), count(*)
from employees
group by department_id
order by department_id;

-- 18. 같은 직무를 하는 사원들 중 제일 먼저 들어온 사원과 제일 늦게 들어온 사원의 입사일을 출력하시오.
--              늦게 들어온 날    빨리 들어온 날
select job_id, max(hire_date), min(hire_date)
from employees
group by job_id
order by job_id;

-- 19. 사원번호, 이름, 입사일, 직무, 부서를 출력할 때, 부서는 오름차순으로 정렬하고 각 부서의 직무를 오름차순으로 정렬하여 출력하시오.
select department_id, job_id, employee_id, first_name, hire_date
from employees
order by department_id, job_id;

-- 20. 각 부서의 직무별 급여 평균, 합계, 담당하는 사원의 수를 출력
select department_id, job_id, trunc(avg(salary)), sum(salary), count(*)
from employees
group by department_id, job_id
order by department_id, job_id;

-- 21. 90 부서에서 직무별 급여 합계와 평균을 구하시오.
select job_id, sum(salary), avg(salary)     -- 4
from employees                              -- 1
where department_id = 90                    -- 2
group by job_id;                            -- 3

-- 22. 각 부서에서 직무가 같은 사원들 중 입사일이 같은 사원의 수를 출력
select department_id, job_id, hire_date, count(*)                          -- 4
from employees                                                             -- 1
group by department_id, job_id, hire_date                                  -- 2
having count(*) >=2;     -- group 함수의 조건이 있는 경우 having 절을 사용       -- 3

-- 23. 평균급여가 7000이상인 부서만 출력, 평균급여 높은 것부터 출력하시오.
select department_id, trunc(avg(salary))
from employees
group by department_id
having avg(salary) >= 7000
order by avg(salary) desc;
-- order by 2 desc;

-- 24. 부서의 직원 수가 10명 미만인 부서를 출력하시오.
select department_id, count(*)
from employees
group by department_id
having count(*) < 10
order by department_id;

-- 25. 직무에 'REP'가 포함되어 있지 않은 직무별 급여 평균, 합계, 최소, 최대 값을 출력할 때 급여의 합계가 13000이상인 직무만 출력하시오.
select job_id, avg(salary), sum(salary), min(salary), max(salary)
from employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000;

--- 다중행 함수, group by, having
--- sum, avg, max, min, count

select max(employee_id) + 1
from employees;

-- select max(board_num) + 1 from board;        -- 많이 사용!

select employee_id, first_name, department_id
from employees
where employee_id = 100;

select department_id, department_name
from departments
where department_id = 90;

--         100                        90
select employee_id, first_name, employees.department_id, department_name
from employees, departments
where employee_id = 100 
--                  90                          90
        and employees.department_id = departments.department_id;
        
        
-- 부서테이블에서 90인 부서정보를 출력하시오.
select * from departments where department_id = 90;

-- 90인 부서의 직원을 구하시오.
select * from employees where department_id = 90;

-- 100번 사원 정보를 출력하시오.
select * from employees where employee_id = 100;

-- 27. 모든 사원의 성, 이름, 급여, 직무, 부서번호, 지역번호, 부서명을 출력하시오.
select employee_id, last_name, first_name, salary, job_id,              -- 3
        departments.department_id, location_id, department_name
from employees, departments                                             -- 1
--              10            =             10
--              20            =             20
where employees.department_id = departments.department_id;              -- 2

--- 카티시안 조인
select employee_id, last_name, first_name, salary, job_id,              -- 3
        departments.department_id, location_id, department_name
from employees, departments;

-- 사원의 성, 급여, 입사일, 직무를 출력할 때 직무명도 같이 출력하시오.
select * from jobs;
select * from employees;

select last_name, salary, hire_date, employees.job_id, job_title
from employees, jobs
where employees.job_id = jobs.job_id;

-- T-SQL join
select employee_id, last_name, first_name, salary, job_id,             
        d.department_id, location_id, department_name
from employees e, departments d                                            
where e.department_id = d.department_id;

-- Ansi - join
-- 29. 직원번호, 성, 이름, 급여, 직무, 부서번호, 지역번호, 부서명을 Ansi-join
select employee_id, last_name, first_name, salary, job_id,             
        d.department_id, location_id, department_name
from employees e join departments d                                            
on e.department_id = d.department_id;

-- 30. ansi-join으로 직원번호, 성, 이름, 급여, 부서번호, 부서명을 100번 사원만 출력하시오.
select employee_id, last_name, first_name, salary, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id    -- join 조건
where employee_id = 100;

-- 31. natural join
-- 직원 번호, 성, 이름, 직무, 직무명을 출력하시오.
-- T-SQL join
select employee_id, last_name, first_name, e.job_id, job_title
from employees e , jobs j
where e.job_id = j. job_id;     -- 일반적으로 join조건은 primary key = foreign key

-- Ansi join
select employee_id, last_name, first_name, e.job_id, job_title
from employees e join jobs j
on e.job_id = j. job_id;

-- natural join
select employee_id, last_name, first_name, job_id, job_title
from employees NATURAL JOIN jobs;    -- 별칭을 가질 수 없다.
--- 테이블에서 같은 이름의 컬럼을 비교하는 것이므로 조인 조건이 필요없다. : natural join

-- 32. 부서장이 상사인 직원을 구하시오. 직원번호, 성, 급여, 입사일, 부서번호, 부서장 번호를 출력하시오.
select * from departments;
select * from employees;

-- T-SQL join
select employee_id, last_name, salary, hire_date, d.department_id, d.manager_id
from employees e, departments d
where e.department_id = d.department_id and d.manager_id = e.manager_id;

-- Ansi join
select employee_id, last_name, salary, hire_date, d.department_id, d.manager_id
from employees e join departments d
on e.department_id = d.department_id and d.manager_id = e.manager_id;

-- natural join
select employee_id, last_name, salary, hire_date, department_id, manager_id
from employees natural join departments;

-- using절 사용
select employee_id, last_name, salary, hire_date, department_id, manager_id
from employees join departments using(department_id, manager_id);

---------- natural join은 같은 이름의 컬럼을 다 비교하기 때문에 하나만 비교하는 경우 natural join을 사용할 수 없다.
select last_name, first_name, salary, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id;
-- 같은 이름의 컬럼이 두개이므로 natural join으로 변경할 수 없다.
----------

-- 33. 성, 이름, 직원번호, 전화번호, 급여, 부서번호, 부서명을 ansi-join으로 출력하시오.
select last_name, first_name, employee_id, phone_number, salary, d.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id;

-- using절 사용
select last_name, first_name, employee_id, phone_number, salary, department_id, department_name
from employees join departments using(department_id);

-- 34. 각 부서의 부서의 정보와 부서장의 이름을 출력하시오.
select d.department_id, department_name, location_id, d.manager_id,
        employee_id, first_name
from departments d, employees e
where d.manager_id = e.employee_id;
--          FK     =      PK

--- 35. 삼중 조인
--- 직원 번호, 직무 번호, 직무내용
desc jobs;
desc employees;
desc departments;

select employee_id, j.job_id, job_title
from employees e, jobs j
where e.job_id = j.job_id;

--- 직원 번호, 부서 번호, 부서명
select employee_id, d.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;

--- 삼중조인
--- 각 직원의 직원번호, 직무번호, 직무내용, 부서번호, 부서명,
-- T-SQL join
select employee_id, j.job_id, job_title, d.department_id, department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id and e.department_id = d.department_id;
-- 테이블 3개이면 조인 조건은 최소 2개
-- 테이블이 n개이면 조인 조건은 n-1개

-- Ansi join        -- 현업에서 주로 사용
select employee_id, j.job_id, job_title, d.department_id, department_name
from employees e join jobs j
on e.job_id = j.job_id join departments d 
on e.department_id = d.department_id;

-- natural join , using join
select employee_id, job_id, job_title, department_id, department_name
from employees Natural join jobs join departments using (department_id);

--- 36. 부서장의 직무내용을 출력하시오. 부서장 번호, 직무내용
select d.manager_id, j.job_title
from departments d, jobs j, employees e
where e.employee_id = d.manager_id and e.job_id = j.job_id;

--- 37. 부서가 없는(null) 직원도 같이 출력
select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e left outer join departments d
on e.department_id = d.department_id;

select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from departments d right outer join employees e
on e.department_id = d.department_id;

--- 38. 직원이 없는(null) 부서도 같이 출력
-- ansi join
select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from departments d left outer join employees e
on e.department_id = d.department_id;

select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e right outer join departments d
on e.department_id = d.department_id;

-- t-sql join
select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e , departments d
where e.department_id = d.department_id(+);     -- employees쪽을 더 출력하고 싶으면 department쪽에 (+)

select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e , departments d
where e.department_id(+) = d.department_id;     -- department쪽을 더 출력하고 싶으면 employees쪽에 (+)

-- 39. 부서가 없는 직원과 직원이 없는 부서를 출력
-- ansi join
select first_name, last_name, salary, e.department_id,
        d.department_id, department_name
from employees e full outer join departments d
on e.department_id = d.department_id;

-- t-sql join
--select first_name, last_name, salary, e.department_id,
--        d.department_id, department_name
--from employees e , departments d
--where e.department_id(+) = d.department_id(+);    -- full outer join은 ansi join에서만 가능하다.