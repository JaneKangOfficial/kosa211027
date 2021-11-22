select * from employees;

--- 대문자를 소문자로, 소문자를 대문자로 변환
select email, lower(email), initcap(email), first_name, upper(first_name), lower(first_name),
        length(first_name), lengthb(first_name), length('홍길동'), lengthb('홍길동'), '홍길동'
from employees;

-- 1. 이름이 'steven'인 사람을 출력하시오.
select * from employees where lower(first_name) = 'steven';

-- 2. 성이 KING인 직원을 출력하시오.
select * from employees where upper(last_name) = 'KING';

-- 첫글자만 대문자로 변환 : INITCAP
-- 단일행 함수 : 행 하나당 변환
select * from employees where last_name = INITCAP('KING');

-- 3. 이름의 글자의 갯수가 5인 사원들을 출력하시오.
select * from employees where length(first_name) = 5;

-- 4. 급여가 5자리 이상인 사원을 구하시오.
select * from employees where salary >= 10000;
select * from employees where length(salary) >= 5;

-- indexOf() : 자바, 문자열에서 원하는 문자가 있는 위치 번호 str.indexOf('a')
--             원하는 문자가 없는 경우 : -1 출력
-- instr() : 데이터베이스의 index는 1번부터 시작한다.
--           원하는 문자가 없는 경우 : 0 출력
-- 5. 이름에 's'를 가진 사원들 중 이름에 몇번째에 있는지 출력하시오.
select first_name, instr(first_name, 's') from employees;

-- 6. 이름에 's'가 3번째에 있는 사원들을 출력하시오.
select * from employees where instr(first_name, 's') = 3;

--java : 
--String str = "I love the java";
----            013456789012345
--System.out.println(str.subString(7));
-- substr
-- 7. 이름, 성, 급여, 직무를 출력할 때 이메일은 3번째 글자부터 출력하시오.
select first_name, last_name, salary, job_id, email, substr(email,3) from employees;

-- 8. 이메일에 's'부터 출력하고, 급여, 입사일, 이름, 성을 출력하시오.
select email, substr(email, instr(email,'S')), salary, hire_date, first_name, last_name from employees;

-- 
-- String str = "I love the java";
--               012345667890123
-- System.out.println(str.subString(7, 7 + 3));
-- 9. 이름, 급여, 직무, 부서를 출력할 때 이메일은 3번째부터 4글자를 출력하시오.
select first_name, salary, job_id, department_id, email, substr(email, 3, 4) from employees;

-- 10. 이메일에 3번째부터 4글자에 'ARTS'가 있는 사원을 출력하시오.
select * from employees where subStr(email, 3, 4) = 'ARTS';

-- 11. 이메일에 's'가 5번째에 있는 사원을 출력하시오.
select * from employees where instr(lower(email), 's') = 5;

--- lower, upper, length, lengthb, initcap, substr, instr

-- 파이썬 : print("나의 나이는 %10d이다." %30);
--          나의 나이는           30이다.
select salary, rpad(salary, 10, '*'), lpad(salary, 10, '*')
from employees;

-- 아이디 찾기 highland0 : high*****
-- 12. 이메일에서 앞에서 2글자를 출력하고 나머지는 오른쪽에 *로 채워서 출력하시오.
-- rpad(값, 크기, 글자)
select email, rpad(substr(email,1,2), length(email), '*')
from employees;

-- 13. 입사일이 03/06/17 전화번호가 515.123.4567인 사원의 이메일을 앞에서 3글자만 출력하고 나머지는 *로 출력하시오.
select email, rpad(substr(email,1,3), length(email), '*')
from employees
where hire_date = '03/06/17' and phone_number = '515.123.4567';

-- java : str.replace("I", "You");
-- 14. 직무에 _AS가 있다면 abc로 변경하시오.
select job_id, replace(job_id, '_AS', 'abc')
from employees
where job_id like '%_AS%';

-- java : str.trim()
select '  홍 길동  ', trim('  홍 길동  '), rtrim('  홍 길동  '), ltrim('  홍 길동  ')
from dual;
-- 15. 이메일에 'A'가 처음과 끝에 있다면 이메일에서 삭제하여 출력하시오.
select email, trim('A' from email), trim(email)
from employees;

-- 파이썬 : str = 'abcdefg'
--                0123456
--                7654321-
-- print(str[4:7])
-- print(str[-3:])
-- 16. 이메일에서 뒤에서 한글자를 가지고 오고 또 이메일에서 뒤에서 2번째부터 2글자를 가지고 오며, 이메일에서 뒤에서 3번째부터 2글자만 출력하시오.
select email, substr(email, -1, 1), substr(email, -2, 2), substr(email, -3, 2)
from employees;

-- 17. 010-7146-1970, 010-****-1970, 02-314-1970, 02-***-1970
select rpad(
        substr('010-7146-1970', 1, instr('010-7146-1970', '-')),
        length(substr('010-7146-1970', 1, instr('010-7146-1970', '-', -1) -1)), '*')
        || substr('010-7146-1970', -5, 5)
from dual;

-- 18. 이름, 입사일, 부서번호, 급여, 연봉을 출력하시오.
select first_name, hire_date, department_id, salary, salary * 12 as 연봉
from employees;

-- 19. 이름, 입사일, 부서번호, 급여, 연봉을 출력할 때 연봉에는 커미션이 포함되어야 한다.
select first_name, hire_date, department_id, commission_pct, salary, (salary + salary * commission_pct) * 12
from employees;

-- null 이면 0으로 출력
select commission_pct, nvl(commission_pct,0)
from employees;

-- 20. 커미션이 null이라면 커미션을 0으로 대입하여 이름, 부서, 입사일, 직무, 급여, 커미션, 연봉을 출력하시오.
select first_name, department_id, hire_date, job_id, salary, commission_pct, 
        ((salary + salary * nvl(commission_pct, 0)) * 12)
from employees;

select nvl(commission_pct, 100)
from employees;

--- 숫자함수
--- round() : 반올림
--- trunc() : 절삭
--- moc() : 나머지

-- 21. 반올림하시오.
-- 5부터 반올림된다.
-- 0은 default, 안 적어도 된다.
-- -1은 10단위 출력, 1단위는 0으로 출력
-- -2는 100단위 출력, 1단위, 10단위는 0으로 출력
select ROUND(15.19345, 3), ROUND(15.19355, 3), 
        round(145.5554, 2), round(145.5554, 1), round(145.5554, 0),
        round(145.4554, 0), round(145.5554, -1), round(145.5554, -2)
from dual;

-- 22. 절삭하시오.
select trunc(15.19345, 3), trunc(15.19355, 3), 
        trunc(145.5554, 2), trunc(145.5554, 1), trunc(145.5554, 0),
        trunc(145.4554, 0), trunc(145.5554, -1), trunc(145.5554, -2)
from dual;

-- 23. 입사일로부터 오늘 날짜까지 며칠이 지났는지 일로 출력하시오.
-- 입사일, 이름, 성, 직무 출력
select sysdate from dual;
select hire_date, first_name, last_name, job_id, trunc(sysdate - hire_date, 0) as day
from employees;

-- 24. 입사일, 이름, 성, 직무를 출력할 때 입사일로부터 몇 주가 지났는지 출력하시오.
select hire_date, first_name, last_name, job_id, round((sysdate - hire_date) / 7) as week
from employees;

-- 25. 사원번호, 입사일, 이름, 성, 직무를 출력할 때 입사일로부터 몇 년차인지 출력하시오.
select employee_id, hire_date, first_name, last_name, job_id, round((sysdate - hire_date) / 365) as year
from employees;

-- 26. 연차가 17년 이상인 사원을 출력하시오.
select employee_id, trunc((sysdate - hire_date) / 365) as year
from employees
where trunc((sysdate - hire_date) / 365) >= 17;

-- 10/3 : 10%3 : mod(10,3)
select mod(10,3) from dual;

-- 27. 이름, 성, 입사일, 급여를 출력할 때 급여를 400으로 나눈 나머지를 출력하시오.
select first_name, last_name, hire_date, salary, mod(salary, 400)
from employees;

-- 28. 급여를 500으로 나눈 나머지가 400이상인 사원들을 출력하시오.
select mod(salary, 500) from employees
where mod(salary, 500) >= 400;

-- 10을 3으로 나눈 몫은 int i = 10; int j = 3; result = i / j;
--              double d = 10; double d1 = 3; int result = (int)(d / d1);
select trunc(10 / 3)
from dual;

--- 날짜 함수
-- 29. 오늘 날짜부터 다음 금요일은 며칠입니까?
select next_day(sysdate, '금'), next_day(sysdate, '금요일')
from dual;

-- 30. 이름, 성, 직무, 입사일을 출력할 때 입사일로부터 다음 목요일이 언제였는지 출력하시오.
select first_name, last_name, job_id, hire_date, next_day(hire_date, '목')
from employees;

-- 오늘부터 3개월 후는 며칠입니까?
select add_months(sysdate, 5)
from dual;

-- 31. Neena가 입사하고 3개월 후가 정직원이 되는 날이다. 정직원이 되는 날이 언제인지, 이름, 성, 입사일, 직무, 사원번호와 같이 출력하시오.
select first_name, last_name, hire_date, job_id, employee_id, add_months(hire_date, 3)
from employees
where first_name = 'Neena';

-- 32. 입사한 이후 다음 목요일이 '01/01/18'인 사원을 구하시오.
select * from employees
where next_day(hire_date, '목') = '01/01/18';

-- 이번 달의 마지막 날을 출력
select last_day(sysdate) from dual;

-- 33. 윤달에 입사한 사원을 출력하시오.
select hire_date, last_day(hire_date)
from employees;

select * from employees
where last_day(hire_date) like '%/02/29';

-- 34. 입사일로부터 현재까지 몇달이 지났습니까? 이름, 성, 직무, 입사일
select first_name, last_name, job_id, hire_date, trunc(months_between(sysdate, hire_date)) from employees;

select * from job_history;
-- 35. 각 사원이 직무를 담당한 달은 몇달인지 출력하시오.
select employee_id, job_id, start_date, end_date, round(months_between(end_date, start_date)) from job_history;

-- 36. 입사한지 200개월이 지난 사원들을 출력하시오.
select * from employees
where round(months_between(sysdate, hire_date)) >= 200;

--- 숫자 함수, 문자 함수, 날짜 함수
-- 변환 함수
-- 날짜 변환 함수 2021-05-14  11:10:35 (date)
-- 20     21      05      14      11      10      35
-- 세기    년      월       일      시      분       초
-- 21/05/14 : 2021/05/14 : 49년도까지가 현재 세기를 가져옴
-- 50/05/14 : 1950/05/14 : 50년부터 99년까지는 이전 세기를 가져옴
-- 2050/05/14

-- '21-01-15' : 년월일
select sysdate - to_date('21-01-15','')
from dual;

-- '01-15-2021' : 월일년
select sysdate - to_date('01/15/2021','mm/dd/yyyy')
from dual;

-- 37. 03/06/17 이후에 입사한 사람은?
select * from employees where hire_date > '03/06/17';  -- 자동형변환
select * from employees where hire_date > to_date('03/06/17','yy-mm-dd');

-- 38. 17/06/03 (d/m/y) 이후에 입사한 사람은?
select * from employees where hire_date > to_date('17/06/03','dd/mm/yy');

-- 06/17/03 (m/d/y) 이후에 입사한 사람은?
select * from employees where hire_date > to_date('06/17/03', 'mm-dd-yy');

-- 39. 문자 변환 함수 : 날짜를 문자로 변환
--              날짜              문자
--             RR-MM-DD     =>  'yyyy-mm-dd'
--             RR-MM-DD     =>  'dd-mm-yy'
--             RR-MM-DD     =>  'mm-dd-yy'
select sysdate, to_char(sysdate, 'yy-mm-dd'), to_date(sysdate, 'dd-mm-yy'), to_char(sysdate, 'yyyy-mm-dd'),
         to_char(sysdate, 'YYYY-MM-DD HH:MI:SS.SSSSS AM'),
         to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS.SSSSS AM'),
         to_char(sysdate, 'YYYY-MON-DD HH:MI:SS.SSSSS AM')
from dual;

-- 날짜를 문자열로 변경하여 날짜 비교   -- 사전 순서 : 정확하지 않다.
-- 40. '25-04-2003' 보다 늦게 입사한 사람을 출력하시오.
select * from employees where to_char(hire_date, 'dd-mm-yyyy') > '25-04-2003';  -- 잘못된 비교 방법

-- 문자열을 날짜로 변경하여 날짜 비교  -- to_date 사용해서 변환하기!
select * from employees where hire_date > to_date('25-04-2003','dd-mm-yyyy');

-- 숫자를 문자열로
--- 1,234,567 => W1,234,567, $1,234,567, $1,234,567-
select to_char(1234567.890, '99,999,999'),   -- 자리수가 모자르면 오류발생
        to_char(1234567.890, '9,999,999.0000'),
        to_char(1234567.890, '$9,999,999.00'),
        to_char(1234567.890, 'L9,999,999.00'),   -- Local
        to_char(-1234567.890, 'L9,999,999.00MI')    -- 1,234,567.89-
from dual;

-- 41. 이름, 성, 직무, 부서, 급여를 세자리씩 ,를 찍고 $가 출력되게 하시오.
select first_name, last_name, job_id, department_id, salary, 
        to_char(salary, '$99,999,999MI'), 
        to_char(-salary, '$99,999,999MI')   -- 회계 파트에서 많이 사용 ( -는 뒤에)
from employees;

-- 42. janette 또는 JANETTE 또는 jaNette의 값을 전달 받았다. 이름이 'Janette'인 사원을 출력하시오.
select * from employees
where first_name = initcap('jaNette');

select * from employees
where lower(first_name) = lower('janette');

select * from employees
where lower(first_name) = 'janette' OR upper(first_name) = 'JANETTE' OR lower(first_name) = lower('jaNette');

--- 표현식 : java => switch(변수) ~ case 조건 : 연산식; break; default : 연산식;
---         CASE 변수 ~ WHEN 조건 ~ THEN 연산식 ELSE 연산식 END

-- 43. job_id가   'IT_PROG'이라면 급여를 10% 상승,
--                'ST_CLERK' 이라면 급여를 15% 상승,
--                'SA_REP' 이라면 급여를 20% 상승, 그 이외는 급여
-- 성, 이름, 급여도 같이 출력
select last_name, first_name, salary, job_id,
        case job_id when 'it_prog' then salary + salary * 0.1
                    when 'st_clerk' then salary + salary * 0.15
                    when 'sa_rep' then salary + salary * 0.2
                    else salary end as sal
from employees;

select last_name, first_name, salary, job_id,
        case when job_id = 'it_prog' then salary + salary * 0.1
             when job_id =  'st_clerk' then salary + salary * 0.15
             when job_id =  'sa_rep' then salary + salary * 0.2
             else salary end as sal
from employees;

--- 44. 성, 이름, 직무, 급여, 급여에 따른 직책을 출력하세요.
--  급여가 3000이하 사원, 5000이하 주임 7000 이하 대리, 9000이하 과장, 11000이하 차장, 13000이하 부장 그 이상 임원
select last_name, first_name, job_id, salary,
        case when salary <= 3000 then '사원'      -- decode로 변경 불가
             when salary <= 5000 then '주임'
             when salary <= 7000 then '대리'
             when salary <= 9000 then '과장'
             when salary <= 11000 then '차장'
             when salary <= 13000 then '부장'
             else '임원' end as 직책
from employees;

-- 45. 급여에 따른 세금, 이름, 성, 급여, 직무, 세금을 출력하시오.
--      급여를 2000으로 나눈 몫이 0이면 급여의 0%, 1이면 급여의 9%, 2면 급여의 20%, 3이면 급여의 30%,
--                              4이면 급여의 40%, 5이면 급여의 42%, 6이면 급여의 44%, 이외 급여의 45%
select last_name, first_name, salary, job_id, 
        case trunc(salary / 2000) when 0 then salary * 0
                                  when 1 then salary * 0.09
                                  when 2 then salary * 0.2
                                  when 3 then salary * 0.3
                                  when 4 then salary * 0.4
                                  when 5 then salary * 0.42
                                  when 6 then salary * 0.44
                                  else salary * 0.45 end as 세금
from employees;

-- decode
select last_name, first_name, salary, job_id,
        decode( job_id , 'it_prog' , salary + salary * 0.1
                       , 'st_clerk' , salary + salary * 0.15
                       , 'sa_rep' , salary + salary * 0.2
                       , salary ) as sal
from employees;

select last_name, first_name, salary, job_id, 
        decode ( trunc(salary / 2000) , 0 , salary * 0
                                      , 1 , salary * 0.09
                                      , 2 , salary * 0.2
                                      , 3 , salary * 0.3
                                      , 4 , salary * 0.4
                                      , 5 , salary * 0.42
                                      , 6 , salary * 0.44
                                      , salary * 0.45 ) as 세금
from employees;