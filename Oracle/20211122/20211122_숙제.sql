--문자함수
--Lower, Upper, initcap, concat, substr
--/* 참고
--select last_name, lower(last_name) , hire_date
--from hr.employees
--where lower(last_name) = 'grant';
--*/

--문제) 성이 모두 소문자인 grant와 모두 대문자인 'GRANT'로 직원테이블에서
--해당 사원을 찾으려 한다.  (Grant) 
select last_name
from employees
where last_name = initcap('grant') or ast_name = initcap('GRANT');

--문제) 'GranT'로 입력했을때 사원테이블에서 성이 'Grant'인 사원을 찾으시오.
select last_name
from employees
where last_name = initcap('GranT');

--문제) 성은 모두 대문자로 변환하고 이름 모두 소문자로 변환하여
--성과 이름을 붙여 출력할 때 ' 나는 GRANT douglas 입니다'로 
--출력되게 하시오.
select '나는 ' || upper(last_name)||' '|| lower(first_name) || ' 입니다.'
from employees;

-- concat
--문제) 성과 이름을 붙여 출력
select concat(last_name, first_name)
from employees;

--문제) 성은 모두 대문자로 변환하고 이름 모두 소문자로 변환하여
--성과 이름을 붙여 출력할 때 ' 나는 GRANT douglas 입니다'로 
--출력되게 하시오. concat을 이용
select concat('나는 ' || upper(last_name), lower(first_name)||' 입니다.')
from employees;

--/* 참고 시작
--오라클과 비교
--String str = "abcdefghi";
--String result = str.subString(2, 6); //cdef
--String result = str.subString(2); //cdefghi
--참고 끝 */ 

--문제) 성이 Davies에서 av만 출력하시오.
select last_name, substr(last_name,2,2)
from employees
where last_name = 'Davies';

--문제) 성이 두번째 글자부터 모두 출력하시오.
select last_name, substr(last_name, 2)
from employees;

--문제) 성의 마지막 글자에서 두글자만 가져오시오
select last_name, substr(last_name, -2, 2)
from employees;

--문제) 성의 뒤에 on으로 끝나는 사람을 찾으시오.
select last_name
from employees
where substr(last_name,-2,2) = 'on';

select last_name
from employees
where last_name like '%on';

--문제) 성의 뒤에 세번째 글자가 so인 사람을 출력하시오.
select last_name, substr(last_name, -3, 2)
from employees
where substr(last_name, -3, 2) = 'so';

select last_name
from employees
where last_name like '%so_';

--문제) 직원 정보를 출력하는데 이메일은 왼쪽에서 3글자만 출력하시오.
--직원번호, 성, 급여, 직무, 이메일
select employee_id, last_name, salary, job_id, email, substr(email, 1, 3)
from employees;

-- 29. 직원 정보를 출력하는데 이메일은 오른쪽에서 3글자만 출력하시오.
-- 직원번호, 성, 급여, 직무, 이메일
select employee_id, last_name, salary, job_id, substr(email, -3)
from employees;

--문제) 직원 정보를 출력하는데 이메일은 오른쪽에서 3글자만 출력하고 나머지는 ‘-’로 출력
--직원번호, 성, 급여, 직무, 이메일
select employee_id, last_name, salary, job_id, email, lpad(substr(email,-3), length(email), '-')
from employees;

--/* 참고 시작
--String str ="abcdefg";
--int i = str.indexOf("f");  //5
--참고 끝 */

--문제) o가 있는 성중 o가 몇번째에 있는 위치인지 출력하시오. --- 아래 참조하기
--직원번호, 성, 성의 위치, 직무
select employee_id, last_name, instr(last_name, 'o'), job_id
from employees;

--문제) oc가 있는 성중 oc가 몇번째에 있는 위치인지 출력하시오. -- 아래 참조하기 
--직원번호, 성, 성의 위치, 직무
select employee_id, last_name, instr(last_name, 'oc'), job_id
from employees;

--/* 참고 시작
--instr(last_name,'oc') : 원하는 문자가 없으면 0을 반환
--instr('abcde' , 'a') : 1
--자바에서 "abcdef".indexOf("a") : 0
--참고 끝 */

--문제) 직무에 RE가 있는 경우 RE부터 3글자만 출력하시오.
--직원번호, 성,  직무, 가공된 직무
select employee_id, last_name, job_id, substr(job_id, instr(job_id, 'RE'), 3)
from employees
where job_id like '%RE%';

--문제) 직원번호, 성, 입사일 , 급여, 급여를 10칸에 출력하고 나머지 공간 앞에 * 표시가 되게 하자.
select employee_id, last_name, hire_date, salary, lpad(salary, 10, '*')
from employees;

--문제) 직원번호, 성, 입사일 , 급여, 급여를 10칸에 출력하고 나머지 공간 뒤에 * 표시가 되게 하자.
select employee_id, last_name, hire_date, salary, rpad(salary, 10, '*')
from employees;

--문제) 직원번호, 성, 입사일, 직무를 출력하는데 직무에 RE가 있다면 RE를 AB로 변경하여 출력
select employee_id, last_name, hire_date, job_id, replace(job_id, 'RE','AB')
from employees
where job_id like '%RE%';

--/* 참고 시작
--select trim(' ab cd ef ') 
--from dual;
--
--select trim(' ' from ' ab cd ef ') 
--from dual;
--
--select trim('a' from 'abada')
--from dual;
--
--select round(45.923, 2), round(45.924, 2), round(45.925, 2),
--       round(45.926, 2)
--from dual;
--
--select trunc(45.923, 2), trunc(45.924, 2), trunc(45.925, 2),
--       trunc(45.926, 2)
--from dual;
--
--select  round(45.925, 2),round(45.925, 1), round(45.925),
--	round(45.925, -1), round(45.925, -2)
--from dual;
--
--select  trunc(45.925, 2), trunc(45.925, 1), trunc(45.925),
--	trunc(45.925, -1), trunc(45.925, -2)
--from dual;
--
--select mod(10,3)
--from dual;
--참고 끝 */

--문제) 직원번호, 연락처, 커미션, 부서번호,급여
--급여를 3000으로 나누었을 때의 나머지를 출력하시오.
select employee_id, phone_number, commission_pct, department_id, salary, mod(salary, 3000)
from employees;

--문제) 2002년도부터 입사한 직원들을 출력하시오.
select * from employees
where hire_date >= to_date('2002','yyyy');

select * from employees 
where to_char(hire_date,'yyyy') >= '2002';

--문제) 올해는 오늘까지 몇주가 지났는지 확인하시오.
select trunc((sysdate - to_date('2021-01-01')) / 7) 
from dual; 

--문제) 직원마다 몇년 근무했지를 출력하시오.
--직원번호, 성, 연락처,부서, 근무년수
select employee_id, last_name, phone_number, department_id, trunc((sysdate - hire_date) / 365) as 근무년수
from employees;

--문제) 근속년수 18년 이상인 사원들만 출력하시오.
select trunc((sysdate - hire_date) / 365) from employees
where trunc((sysdate - hire_date) / 365) >= 18;

--문제) 예시 : 게시판리스트에서 제목을 5글자****인 것 처럼 
--직원의 성을 3글자만 출력 뒤에 *을 세번찍어서 출력하시오.
--직원번호, 입사일, 성
select employee_id, hire_date, rpad(substr(last_name,1,3), 6, '*')
from employees;

--문제) 홍길동은 몇글자입니까? -- 영문 ‘abc’와 비교
select '홍길동', length('홍길동')
from dual;

--문제)"홍길동 \n"으로 되어 있는 것을 html에서 행 바꿈이되도록
--     "홍길동 <br>"변경하시오.
select replace('홍길동\n', '\n', '<br>')
from dual;

--문제) 입사일이 'YYYY-MM-DD'인 날짜를 31-05-2019 16:24:30 오전
--인 형태로 출력하자.
select to_char(hire_date, 'dd-mm-yyyy HH24:MM:SS AM') from employees;

--문제) 숫자(3333333)를 3자리마다 쉼표를 찍어서 출력
select to_char(3333333, '999,999,999') from dual;

--문제) 직원테이블에서 급여를 W33,333,333식으로 출력하시오.
select salary, to_char(salary, 'L99,999,999')
from employees;

--문제) 직원의 2018-10-25까지의 근무일수를 계산하시오.
--직원번호, 부서번호, 입사일, 근무일수
select employee_id, department_id, hire_date, trunc(to_date('2018-10-25','yyyy-mm-dd') - hire_date) as 근무일수
from employees;

--문제) 직원의 25-10-2018까지의 근무일수를 계산하시오.
--직원번호, 부서번호, 입사일, 근무일수
select employee_id, department_id, hire_date, trunc(to_date('25-10-2018','dd-mm-yyyy') - hire_date) as 근무일수
from employees;

--문제) 직원의 10-25-2018까지의 근무일수를 계산하시오.
--직원번호, 부서번호, 입사일, 근무일수
select employee_id, department_id, hire_date, trunc(to_date('10-25-2018','mm-dd-yyyy') - hire_date) as 근무일수
from employees;

--문제) '10-25-2002'에 입사한 사원을 출력하시오.
--직원번호, 부서번호, 입사일, 근무일수
select employee_id, department_id, hire_date
from employees
where hire_date = to_date('10-25-2002','mm-dd-yyyy');

--문제) 연말정산을 하려고 합니다.
--      연봉(급여*12) : 급여는 커미션까지 포함된다.
--직원의 연봉을 구하시오.
-- 직원번호, 부서번호, 급여, 연봉
select employee_id, department_id, salary, (salary + salary * nvl(commission_pct,0)) * 12 as 연봉
from employees;

select employee_id, department_id, salary, 
        salary *( 1 + nvl(commission_pct,0)) * 12 yearsal
from employees;

--문제) 부서가 90이거나 30인 부서의 직원의 연봉을 구하시오
--직원번호, 부서번호, 급여, 연봉
select employee_id, department_id, salary, salary * 12 as 연봉
from employees
where department_id = 90 or department_id = 30;

select employee_id, department_id, salary, salary * 12 
from employees
where department_id in (90,30);

--문제) 직원 번호와 성과 급여 그리고 연봉을 출력하시오.
select employee_id, last_name, salary, salary * 12 as 연봉
from employees;

-- 표현식
--문제) 급여가 10000이상이면 "이사급입니다"
--             7000이상이면 "부장급입니다"
--             5000이상이면 "과장급입니다"
--             나머지는 사원으로 출력하시오.
--      성과 급여를 같이 출력한다.
--case
select last_name, salary,
        case when salary >= 10000 then '이사급입니다'
             when salary >= 7000 then '부장급입니다'
             when salary >= 5000 then '과장급입니다'
            else '사원입니다' end
from employees;

--문제) 급여를 2000으로 나눈 값의 몫이 
--       0이면 0.00
--       1이면 0.09
--       2이면 0.20
--       3이면 0.30
--       4이면 0.40
--       5이면 0.42
--       6이면 0.44
--             0.45 만큼 세금이 부여된다.
--부여되는 세금을 출력하시오.
--성과 급여도 같이 출력하시오.(단, 부서가 80인 사원만)
select last_name, salary,
    case mod(salary, 2000) when 0 then salary * 0.00
                           when 1 then salary * 0.09
                           when 2 then salary * 0.20
                           when 3 then salary * 0.30
                           when 4 then salary * 0.40
                           when 5 then salary * 0.42
                           when 6 then salary * 0.44
                           else salary * 0.45 end as 세금
from employees
where department_id = 80;

--문제) 직원 전체에서 입사일이 제일빠른 사람과 최근에 입사한 
--사원을 출력하시오.
select min(hire_date), max(hire_date) from employees;

--- 급여의 1000단위를 반올림하여 출력하시오.
select salary, round(salary, 4)
from employees;

--- 사원번호가 짝수인 사원만 출력하시오
select employee_id from employees
where mod(employee_id, 2) = 0;

-- 사원번호가 홀수인 사원을 출력하시오.
select employee_id from employees
where mod(employee_id, 2) = 1;

--- 사원의 급여가 3000에서 6000 사이의 사원을 출력하시오,
select salary from employees
where salary between 3000 and 6000;

--- 사원의 급여가 3000에서 6000 사이의 급여를 받지 못하는 사원을 출력하시오,
select salary from employees
where salary not between 3000 and 6000;

--- 사원들이 입사한지 몇 주가 되었는 출력하시오.
select hire_date, round((sysdate - hire_date) / 7)
from employees;

--- 사원들 중 1000주가 지난 사원들만 출력하시오.
select hire_date, round((sysdate - hire_date) / 7)
from employees
where round((sysdate - hire_date) / 7) >= 1000;

--- 사원들이 입사한지 몇년이 되었는지 출력하시오.
select hire_date, round((sysdate - hire_date) / 365)
from employees;

--- email에서 첫음부터 2글자, 2번째부터 2글짜 , 3번째 부터 2글자를 출력하시오.
select email, substr(email, 1, 2), substr(email, 2, 2),substr(email, 3, 2)
from employees;

-- 10-25-2003보다 나중에 들어온 사원을 출력하시오.
select hire_date from employees
where hire_date > to_date('10-25-2003','mm-dd-yyyy');

-- 사원들이 커미션을 포함하는 연봉을 구하시오.
select salary, commission_pct, (salary + salary * nvl(commission_pct,0)) * 12 as 연봉
from employees;

--- 50, 60, 90인 부서가 아닌 사원들을 구하시오
select department_id from employees
where department_id not in (50, 60, 90);

--날짜가 10-20-2003보다 먼저 입사한 사원을 모두 출력하시오.
--이때 Steven의 입사일은 10-20-2003입니다
select hire_date from employees
where hire_date < to_date('10-20-2003', 'mm-dd-yyyy');

---- 사원이름, 급여, 연봉 을 구하시오. 커미션이 없는 경우 커미션을 0으로 한다.
--연봉이 높은 사람 부터 출력하시오.
select first_name, salary, (salary + salary * nvl(commission_pct, 0)) * 12 as 연봉
from employees
order by 연봉 desc;

--- 위 예제에서 부서가 60이거나 90인 사원만 출력하시오
select department_id, first_name, salary, (salary + salary * nvl(commission_pct, 0)) * 12 as 연봉
from employees
where department_id in (60, 90)
order by 연봉 desc;