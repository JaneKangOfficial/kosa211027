--- 직무에 'REP'포함된 직원의 급여의 합계 , 평균, 최대, 최소, 사원 수를 구하시오.
select sum(salary), trunc(avg(salary),2), max(salary), min(salary), count(*)
from employees
where job_id like '%REP%';

--- 80인 부서에서 커미션을 받는 사원의 수는 
select count(commission_pct)
from employees
where department_id = 80;

--- 부서별 급여의 평균을 구하고 급여의 평균을 내림차순으로 출력하시오.
select department_id, trunc(avg(salary),2)
from employees
group by department_id
order by trunc(avg(salary),2) desc;

--- 그룹함수를 사용한 경우 select 절에 올 수 있는 컬럼은 group by절에 있는 컬럼만 올수 있다.

--- 직원의 급여가 6000이상인 사원들의 부서별 평균을 구하고 부서별 평균이 7000이상인 부서만 출력하시오. 부서를 내림차순
select department_id, trunc(avg(salary),2)
from employees
where salary >= 6000
group by department_id
having avg(salary) >= 7000
order by avg(salary) desc;

--- 직무가 'REP'를 포함하고 있지 않은 직원들의 직무별 급여의 합계가 13000이상인 직무만 출력하시오.급여의 합계를 오름차순으로 정렬
select job_id, sum(salary)
from employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000
order by sum(salary);

--문제) 직무에 IT_PROG, ST_CLERK, SA_REP가 포함되어 있지 않은 사원
select * from employees
where job_id not in ('%IT_PROG%' , '%ST_CLERK%' , '%SA_REP%');

--문제) 급여가 3000에서 5000사이에 있지 않은 사원
select * from employees
where salary not between 3000 and 5000;

--1.사원 테이블에서 부서번호, 사원번호, 이름 , 입사일을 출력하는 데 부서번호가 70인 부서를 출력하시오.
select department_id, employee_id, first_name, hire_date
from employees
where department_id = 70;

--2.사원테이블에서 사원번호, 부서번호, 이름, 급여를 출력하는데 입사일이 02/06/07인 사원들만 출력하시오.
select employee_id, department_id, first_name, salary, hire_date
from employees
where hire_date = to_date('02/06/07');

--3. 사원 테이블에서 부서번호, 사원 번호, 이름, 직무번호를 출력하는데 이름이 William 인 사원을 출력하시오.
select department_id, employee_id, first_name, job_id
from employees
where first_name = 'William';

--4. 사원 테이블에서 부서번호 사원번호 이름 직무번호 급여를 출력하는데 직무 번호가 FI_ACCOUNT인 사원 들을 출력하시오.
select department_id, employee_id, first_name, job_id, salary
from employees
where job_id = 'FI_ACCOUNT';

--5. 사원테이블을 출력하는 이름 name으로 부서번호는 did 사원번호는 eid 직무번호를 출력할 때 부서번호 50이상인 부서의 사원
select first_name as name, department_id as did, employee_id as eid, job_id
from employees
where department_id >= 50;

--6. 사원 테이블을 출력하는 데 급여가 4000에서 10000사이만 출력하시오.
select * from employees
where salary between 4000 and 10000;

--7. 사원 테이블에서 직무가 FI_ACCOUNT가 아닌 사원들을 출력하시오.
select * from employees
where job_id not in ('FI_ACCOUNT');

--8. 사원테이블을 출력하는데 부서번호가 50이거나, 70인 사원 출력하시오
select * from employees
where department_id in (50, 70);

--9. 사원테이블에서 사원이름이 Daniel보다 큰 사원을 출력하시오.
select * from employees
where first_name > 'Daniel';

--10. 사원 테이블에서 사원이름이 Daniel보다 크고 Julia보다 작은 사원들을 출력.
select * from employees
where first_name > 'Daniel' and first_name < 'Julia';
--where first_name between 'Daniel' and 'Julia';

--11. 사원테이블을 출력할 때  입사일이 01/01/13부터 06/01/03까지  입사한 사원들만 출력하시오.
select * from employees
where hire_date between '01/01/13' and '06/01/03';

--12. 사원테이블에서 급여가 10000에서  15000사이의 사원들만 출력하시오.
select * from employees
where salary between 10000 and 15000;

--13. 사원 테이블에서 부서번호가   50이거나 70이거나 90인   사원을 출력하시오.
select * from employees
where department_id in (50, 70, 90);

--14. 사원 테이블에서 직무번호가  FI_MGR이거나 SA_MAN이거나  MK_MAN인 사원을 출력하시오.
select * from employees
where job_id in ('FI_MGR', 'SA_MAN', 'MK_MAN');

--15. 사원테이블에서 사원번호, 성, 급여,  상사번호를 출력하는데 상사가 100,101,201인 사원들을  출력하시오.
select employee_id, last_name, salary, manager_id
from employees
where manager_id in (100, 101, 201);

--16. 사원 테이블에서 사원번호, 상사번호, 부서번호를 출력하는데 성이 Hartstein과 Vargas사이의 사원들만 출력하시오.
select employee_id, manager_id, department_id
from employees
where last_name BETWEEN 'Hartstein' and 'Vargas';

--17. 사원 테이블에서 사원번호, 상사번호, 부서번호를 출력하는데 성이 Hartstein와 Vargas인 사원만 출력하시오.
select employee_id, manager_id, department_id
from employees
where last_name in ( 'Hartstein' , 'Vargas');

--18. 사원 테이블에서 커미션이 null인 사원들만 출력하세요.
select * from employees
where commission_pct is null;

--19. 사원 테이블에서 성, 직무번호, 상사를 출력하는게 상사가 없는 사원을 출력하시오.
select last_name, job_id, manager_id
from employees
where manager_id is null;

--20. 사원 테이블에서 부서가 없는 사원을 출력 하시오.
select * from employees
where department_id is null;

--21. 사원테이블에서 이름의 첫글자가 'S'로 시작되는 사원을 출력하시오.
select first_name
from employees
where first_name like 'S%';

--22. 사원테이블에서 입사일 중 day가 6일인 사원들을 출력하시오.
select * from employees
where hire_date like '%/06';

--23 사원테이블에서 02년도에 입사한 사원들을 출력하시오.
select * from employees
where hire_date like '02/%';
--select * from hr.employees where to_char(hire_date,'yy') = '02';

--24. 사원테이블에서 직무번호에 MA를 포함하고 사원출력하시오.
select * from employees
where job_id like '%MA%';

--25. 사원 테이블에서 이름이 두번째 글자가 's'인 사원들을 출력하시오.
select first_name
from employees
where first_name like '_s%';

--26. 사원 테이블에서 이름의 세번째 글자에 's'를 포함하는 사원은
select first_name
from employees
where first_name like '__s%';

--27. 사원테이블에서 이름에 's'가 뒤에서 두번째에 포함되어 있는 사원은?
select first_name
from employees
where first_name like '%s_';

--28. 사원 테이블에서 직무에 'A_'를 포함하고 있는 사원은?
select job_id
from employees
where job_id like '%A\_%' escape '\';

--29.사원테이블에서 급여가 10000 미만이고 15000을 초과하는 사원
select salary
from employees
where salary not between 10000 and 15000;

--30. 사원 테이블에서 사원 성이 Doran부터 Fox사이에 있는 사원을 제외한 나머지 사원을 출력
select * from employees
where last_name not between 'Doran' and 'Fox';

--31. 사원 테이블에서 부서번호가 50, 70, 90부서가 아닌 사원은?
select * from employees
where department_id not in (50, 70, 90);

--32. 사원테이블에서 성과 직무를 출력하는데 직무가 IT_PROG,ST_CLERK, SA_REP가 아닌 사원
select last_name, job_id
from employees
where job_id not in ('IT_PROG', 'ST_CLERK', 'SA_REP');

--33. 사원테이블에 있는 commission_pct가 null이 아닌 사원들을 출력하시오.
select * from employees
where commission_pct is not null;

--34. 사원테이블에서 상사가 있는 사원들만 출력하시오.
select * from employees
where manager_id is not null;

--35. 부서를 가지고 있는 사원은?
select * from employees
where department_id is not null;

--36. 직무에 'SA'를 포함하는 사원은?
select * from employees
where job_id like '%SA%';

--37. 직무에 'SA'를 포함하고 있지 않은 사원은?
select * from employees
where job_id not like '%SA%';

--38. 사원테이블에서 부서가 50, 70, 90이면서 급여가 10000이상인 사원들을 구하시오.
select * from employees
where department_id in (50, 70, 90) and salary >= 10000;

--39. 사원테이블에서 부서가 50,70이고 또 부서가 90이면서 급여가  10000 이상인 사원?
select * from employees
where department_id in (50, 70) or department_id = 90 and salary >= 10000;

--40.아래쿼리문에 IN 연산자를 사용 
--select * from hr.employees
--where ( department_id = 50
--OR department_id = 70
--OR department_id = 90 )
--AND salary >= 10000;
select * from employees
where department_id in (50, 70, 90) and salary >= 10000;

--41.IN연산자 사용
--select * from hr.employees
--where department_id = 50
--OR department_id = 70
--OR department_id = 90
--AND salary >= 10000;
select * from employees
where department_id in (50, 70) or department_id = 90 and salary >= 10000;

--42. 사원테이블에서 이름을 사전순서로 출력하시오.(오름차순)
select first_name
from employees
order by first_name;

--43. 사원테이블에서 부서번호 이름 급여 입사일을 출력하는데 부서번호를 오름차순으로 정렬하시오.
select department_id, first_name, salary, hire_date
from employees
order by department_id;

--44. 사원테이블에서 부서번호가 90인 부서의 사원을 출력하는데 사원 이름의 오름차순으로 정렬
select first_name, department_id
from employees
where department_id = 90
order by first_name;

--45. 사원테이블에서 부서번호, 사원번호, 이름, 급여, 입사일을 출력할 때 부서가 50, 70인 부서의 사원을 입사일 순으로 정렬하시오.
select department_id, employee_id, first_name, salary, hire_date
from employees
where department_id in (50, 70)
order by hire_date;

--46. 사원을 입사일 제일 늦은 사원 부터 출력하시오.
select * from employees
order by hire_date desc;

--47. 입사일이 02/08/16년부터 08/01/29년사이의 입사한 사람을 부서와 사번 그리고 이름을 출력하는데 입사일이 늦은 사원 부터 출력하시오.
select department_id, employee_id, first_name, hire_date
from employees
where hire_date between '02/08/16' and '08/01/29'
order by hire_date desc;

--48. 'SA'로 시작하는 직무를 제외한 나머지 사원들 중에 부서번호, 사번, 이름, 입사일을 출력하는데 부서를 내림차순으로 정렬하시오.
select department_id, employee_id, first_name, hire_date
from employees
where job_id not like 'SA%'
order by department_id desc;

--49. 사원을 부서번호, 사번, 이름, 입사일, 직무를 출력할 때 부서번호가 90과 110을 출력할 때 부서를 오름차순으로 하고 부서의 사원도 입사일 기준으로 오름차순으로 정렬하시오.
select department_id, employee_id, first_name, hire_date, job_id
from employees
where department_id in (90, 110)
order by department_id, hire_date;

--50. 사원테이블에서 부서번호,입사일 ,사번, 이름, 직무, 급여, 급여에 커미션을 더한값을 출력하는데 이름을 comm으로 변경하고 부서는 50, 70, 120만 출력하는데 부서는 오름차순, 입사일은 내림차순으로 정렬하시오.
select department_id, hire_date, employee_id, first_name, job_id, salary, (salary + salary * nvl(commission_pct,0)) as comm
from employees
where department_id in (50, 70, 120)
order by department_id, hire_date desc;

--51. 사원테이블에서 사원번호, 성, 급여에 12를 곱한 값을 sal로 출력하고 급여에 12를 곱한 값을 오름차순으로 정렬하시오.
select employee_id, last_name, salary, salary * 12 as sal
from employees
order by sal;

--52. 성과 부서 그리고 급여를 출력하는데 급여가 4000부터 10000사이에 있는 사원만 부서를 내림차순으로 정렬하고 급여는 오름차순으로 정렬 
select last_name, department_id, salary
from employees
where salary between 4000 and 10000
order by department_id desc, salary; 

--53. 성과 급여를 출력할 때 직무가 'MA'포함하고 있는 사원을 제외한 나머지 사원들을 부서는 오름차순, 급여는 내림차순으로 정렬하시오.
select last_name, salary
from employees
where job_id not like '%MA%'
order by department_id, salary desc;