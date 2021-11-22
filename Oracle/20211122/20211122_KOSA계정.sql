select * from employees;

--- �빮�ڸ� �ҹ��ڷ�, �ҹ��ڸ� �빮�ڷ� ��ȯ
select email, lower(email), initcap(email), first_name, upper(first_name), lower(first_name),
        length(first_name), lengthb(first_name), length('ȫ�浿'), lengthb('ȫ�浿'), 'ȫ�浿'
from employees;

-- 1. �̸��� 'steven'�� ����� ����Ͻÿ�.
select * from employees where lower(first_name) = 'steven';

-- 2. ���� KING�� ������ ����Ͻÿ�.
select * from employees where upper(last_name) = 'KING';

-- ù���ڸ� �빮�ڷ� ��ȯ : INITCAP
-- ������ �Լ� : �� �ϳ��� ��ȯ
select * from employees where last_name = INITCAP('KING');

-- 3. �̸��� ������ ������ 5�� ������� ����Ͻÿ�.
select * from employees where length(first_name) = 5;

-- 4. �޿��� 5�ڸ� �̻��� ����� ���Ͻÿ�.
select * from employees where salary >= 10000;
select * from employees where length(salary) >= 5;

-- indexOf() : �ڹ�, ���ڿ����� ���ϴ� ���ڰ� �ִ� ��ġ ��ȣ str.indexOf('a')
--             ���ϴ� ���ڰ� ���� ��� : -1 ���
-- instr() : �����ͺ��̽��� index�� 1������ �����Ѵ�.
--           ���ϴ� ���ڰ� ���� ��� : 0 ���
-- 5. �̸��� 's'�� ���� ����� �� �̸��� ���°�� �ִ��� ����Ͻÿ�.
select first_name, instr(first_name, 's') from employees;

-- 6. �̸��� 's'�� 3��°�� �ִ� ������� ����Ͻÿ�.
select * from employees where instr(first_name, 's') = 3;

--java : 
--String str = "I love the java";
----            013456789012345
--System.out.println(str.subString(7));
-- substr
-- 7. �̸�, ��, �޿�, ������ ����� �� �̸����� 3��° ���ں��� ����Ͻÿ�.
select first_name, last_name, salary, job_id, email, substr(email,3) from employees;

-- 8. �̸��Ͽ� 's'���� ����ϰ�, �޿�, �Ի���, �̸�, ���� ����Ͻÿ�.
select email, substr(email, instr(email,'S')), salary, hire_date, first_name, last_name from employees;

-- 
-- String str = "I love the java";
--               012345667890123
-- System.out.println(str.subString(7, 7 + 3));
-- 9. �̸�, �޿�, ����, �μ��� ����� �� �̸����� 3��°���� 4���ڸ� ����Ͻÿ�.
select first_name, salary, job_id, department_id, email, substr(email, 3, 4) from employees;

-- 10. �̸��Ͽ� 3��°���� 4���ڿ� 'ARTS'�� �ִ� ����� ����Ͻÿ�.
select * from employees where subStr(email, 3, 4) = 'ARTS';

-- 11. �̸��Ͽ� 's'�� 5��°�� �ִ� ����� ����Ͻÿ�.
select * from employees where instr(lower(email), 's') = 5;

--- lower, upper, length, lengthb, initcap, substr, instr

-- ���̽� : print("���� ���̴� %10d�̴�." %30);
--          ���� ���̴�           30�̴�.
select salary, rpad(salary, 10, '*'), lpad(salary, 10, '*')
from employees;

-- ���̵� ã�� highland0 : high*****
-- 12. �̸��Ͽ��� �տ��� 2���ڸ� ����ϰ� �������� �����ʿ� *�� ä���� ����Ͻÿ�.
-- rpad(��, ũ��, ����)
select email, rpad(substr(email,1,2), length(email), '*')
from employees;

-- 13. �Ի����� 03/06/17 ��ȭ��ȣ�� 515.123.4567�� ����� �̸����� �տ��� 3���ڸ� ����ϰ� �������� *�� ����Ͻÿ�.
select email, rpad(substr(email,1,3), length(email), '*')
from employees
where hire_date = '03/06/17' and phone_number = '515.123.4567';

-- java : str.replace("I", "You");
-- 14. ������ _AS�� �ִٸ� abc�� �����Ͻÿ�.
select job_id, replace(job_id, '_AS', 'abc')
from employees
where job_id like '%_AS%';

-- java : str.trim()
select '  ȫ �浿  ', trim('  ȫ �浿  '), rtrim('  ȫ �浿  '), ltrim('  ȫ �浿  ')
from dual;
-- 15. �̸��Ͽ� 'A'�� ó���� ���� �ִٸ� �̸��Ͽ��� �����Ͽ� ����Ͻÿ�.
select email, trim('A' from email), trim(email)
from employees;

-- ���̽� : str = 'abcdefg'
--                0123456
--                7654321-
-- print(str[4:7])
-- print(str[-3:])
-- 16. �̸��Ͽ��� �ڿ��� �ѱ��ڸ� ������ ���� �� �̸��Ͽ��� �ڿ��� 2��°���� 2���ڸ� ������ ����, �̸��Ͽ��� �ڿ��� 3��°���� 2���ڸ� ����Ͻÿ�.
select email, substr(email, -1, 1), substr(email, -2, 2), substr(email, -3, 2)
from employees;

-- 17. 010-7146-1970, 010-****-1970, 02-314-1970, 02-***-1970
select rpad(
        substr('010-7146-1970', 1, instr('010-7146-1970', '-')),
        length(substr('010-7146-1970', 1, instr('010-7146-1970', '-', -1) -1)), '*')
        || substr('010-7146-1970', -5, 5)
from dual;

-- 18. �̸�, �Ի���, �μ���ȣ, �޿�, ������ ����Ͻÿ�.
select first_name, hire_date, department_id, salary, salary * 12 as ����
from employees;

-- 19. �̸�, �Ի���, �μ���ȣ, �޿�, ������ ����� �� �������� Ŀ�̼��� ���ԵǾ�� �Ѵ�.
select first_name, hire_date, department_id, commission_pct, salary, (salary + salary * commission_pct) * 12
from employees;

-- null �̸� 0���� ���
select commission_pct, nvl(commission_pct,0)
from employees;

-- 20. Ŀ�̼��� null�̶�� Ŀ�̼��� 0���� �����Ͽ� �̸�, �μ�, �Ի���, ����, �޿�, Ŀ�̼�, ������ ����Ͻÿ�.
select first_name, department_id, hire_date, job_id, salary, commission_pct, 
        ((salary + salary * nvl(commission_pct, 0)) * 12)
from employees;

select nvl(commission_pct, 100)
from employees;

--- �����Լ�
--- round() : �ݿø�
--- trunc() : ����
--- moc() : ������

-- 21. �ݿø��Ͻÿ�.
-- 5���� �ݿø��ȴ�.
-- 0�� default, �� ��� �ȴ�.
-- -1�� 10���� ���, 1������ 0���� ���
-- -2�� 100���� ���, 1����, 10������ 0���� ���
select ROUND(15.19345, 3), ROUND(15.19355, 3), 
        round(145.5554, 2), round(145.5554, 1), round(145.5554, 0),
        round(145.4554, 0), round(145.5554, -1), round(145.5554, -2)
from dual;

-- 22. �����Ͻÿ�.
select trunc(15.19345, 3), trunc(15.19355, 3), 
        trunc(145.5554, 2), trunc(145.5554, 1), trunc(145.5554, 0),
        trunc(145.4554, 0), trunc(145.5554, -1), trunc(145.5554, -2)
from dual;

-- 23. �Ի��Ϸκ��� ���� ��¥���� ��ĥ�� �������� �Ϸ� ����Ͻÿ�.
-- �Ի���, �̸�, ��, ���� ���
select sysdate from dual;
select hire_date, first_name, last_name, job_id, trunc(sysdate - hire_date, 0) as day
from employees;

-- 24. �Ի���, �̸�, ��, ������ ����� �� �Ի��Ϸκ��� �� �ְ� �������� ����Ͻÿ�.
select hire_date, first_name, last_name, job_id, round((sysdate - hire_date) / 7) as week
from employees;

-- 25. �����ȣ, �Ի���, �̸�, ��, ������ ����� �� �Ի��Ϸκ��� �� �������� ����Ͻÿ�.
select employee_id, hire_date, first_name, last_name, job_id, round((sysdate - hire_date) / 365) as year
from employees;

-- 26. ������ 17�� �̻��� ����� ����Ͻÿ�.
select employee_id, trunc((sysdate - hire_date) / 365) as year
from employees
where trunc((sysdate - hire_date) / 365) >= 17;

-- 10/3 : 10%3 : mod(10,3)
select mod(10,3) from dual;

-- 27. �̸�, ��, �Ի���, �޿��� ����� �� �޿��� 400���� ���� �������� ����Ͻÿ�.
select first_name, last_name, hire_date, salary, mod(salary, 400)
from employees;

-- 28. �޿��� 500���� ���� �������� 400�̻��� ������� ����Ͻÿ�.
select mod(salary, 500) from employees
where mod(salary, 500) >= 400;

-- 10�� 3���� ���� ���� int i = 10; int j = 3; result = i / j;
--              double d = 10; double d1 = 3; int result = (int)(d / d1);
select trunc(10 / 3)
from dual;

--- ��¥ �Լ�
-- 29. ���� ��¥���� ���� �ݿ����� ��ĥ�Դϱ�?
select next_day(sysdate, '��'), next_day(sysdate, '�ݿ���')
from dual;

-- 30. �̸�, ��, ����, �Ի����� ����� �� �Ի��Ϸκ��� ���� ������� ���������� ����Ͻÿ�.
select first_name, last_name, job_id, hire_date, next_day(hire_date, '��')
from employees;

-- ���ú��� 3���� �Ĵ� ��ĥ�Դϱ�?
select add_months(sysdate, 5)
from dual;

-- 31. Neena�� �Ի��ϰ� 3���� �İ� �������� �Ǵ� ���̴�. �������� �Ǵ� ���� ��������, �̸�, ��, �Ի���, ����, �����ȣ�� ���� ����Ͻÿ�.
select first_name, last_name, hire_date, job_id, employee_id, add_months(hire_date, 3)
from employees
where first_name = 'Neena';

-- 32. �Ի��� ���� ���� ������� '01/01/18'�� ����� ���Ͻÿ�.
select * from employees
where next_day(hire_date, '��') = '01/01/18';

-- �̹� ���� ������ ���� ���
select last_day(sysdate) from dual;

-- 33. ���޿� �Ի��� ����� ����Ͻÿ�.
select hire_date, last_day(hire_date)
from employees;

select * from employees
where last_day(hire_date) like '%/02/29';

-- 34. �Ի��Ϸκ��� ������� ����� �������ϱ�? �̸�, ��, ����, �Ի���
select first_name, last_name, job_id, hire_date, trunc(months_between(sysdate, hire_date)) from employees;

select * from job_history;
-- 35. �� ����� ������ ����� ���� ������� ����Ͻÿ�.
select employee_id, job_id, start_date, end_date, round(months_between(end_date, start_date)) from job_history;

-- 36. �Ի����� 200������ ���� ������� ����Ͻÿ�.
select * from employees
where round(months_between(sysdate, hire_date)) >= 200;

--- ���� �Լ�, ���� �Լ�, ��¥ �Լ�
-- ��ȯ �Լ�
-- ��¥ ��ȯ �Լ� 2021-05-14  11:10:35 (date)
-- 20     21      05      14      11      10      35
-- ����    ��      ��       ��      ��      ��       ��
-- 21/05/14 : 2021/05/14 : 49�⵵������ ���� ���⸦ ������
-- 50/05/14 : 1950/05/14 : 50����� 99������� ���� ���⸦ ������
-- 2050/05/14

-- '21-01-15' : �����
select sysdate - to_date('21-01-15','')
from dual;

-- '01-15-2021' : ���ϳ�
select sysdate - to_date('01/15/2021','mm/dd/yyyy')
from dual;

-- 37. 03/06/17 ���Ŀ� �Ի��� �����?
select * from employees where hire_date > '03/06/17';  -- �ڵ�����ȯ
select * from employees where hire_date > to_date('03/06/17','yy-mm-dd');

-- 38. 17/06/03 (d/m/y) ���Ŀ� �Ի��� �����?
select * from employees where hire_date > to_date('17/06/03','dd/mm/yy');

-- 06/17/03 (m/d/y) ���Ŀ� �Ի��� �����?
select * from employees where hire_date > to_date('06/17/03', 'mm-dd-yy');

-- 39. ���� ��ȯ �Լ� : ��¥�� ���ڷ� ��ȯ
--              ��¥              ����
--             RR-MM-DD     =>  'yyyy-mm-dd'
--             RR-MM-DD     =>  'dd-mm-yy'
--             RR-MM-DD     =>  'mm-dd-yy'
select sysdate, to_char(sysdate, 'yy-mm-dd'), to_date(sysdate, 'dd-mm-yy'), to_char(sysdate, 'yyyy-mm-dd'),
         to_char(sysdate, 'YYYY-MM-DD HH:MI:SS.SSSSS AM'),
         to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS.SSSSS AM'),
         to_char(sysdate, 'YYYY-MON-DD HH:MI:SS.SSSSS AM')
from dual;

-- ��¥�� ���ڿ��� �����Ͽ� ��¥ ��   -- ���� ���� : ��Ȯ���� �ʴ�.
-- 40. '25-04-2003' ���� �ʰ� �Ի��� ����� ����Ͻÿ�.
select * from employees where to_char(hire_date, 'dd-mm-yyyy') > '25-04-2003';  -- �߸��� �� ���

-- ���ڿ��� ��¥�� �����Ͽ� ��¥ ��  -- to_date ����ؼ� ��ȯ�ϱ�!
select * from employees where hire_date > to_date('25-04-2003','dd-mm-yyyy');

-- ���ڸ� ���ڿ���
--- 1,234,567 => W1,234,567, $1,234,567, $1,234,567-
select to_char(1234567.890, '99,999,999'),   -- �ڸ����� ���ڸ��� �����߻�
        to_char(1234567.890, '9,999,999.0000'),
        to_char(1234567.890, '$9,999,999.00'),
        to_char(1234567.890, 'L9,999,999.00'),   -- Local
        to_char(-1234567.890, 'L9,999,999.00MI')    -- 1,234,567.89-
from dual;

-- 41. �̸�, ��, ����, �μ�, �޿��� ���ڸ��� ,�� ��� $�� ��µǰ� �Ͻÿ�.
select first_name, last_name, job_id, department_id, salary, 
        to_char(salary, '$99,999,999MI'), 
        to_char(-salary, '$99,999,999MI')   -- ȸ�� ��Ʈ���� ���� ��� ( -�� �ڿ�)
from employees;

-- 42. janette �Ǵ� JANETTE �Ǵ� jaNette�� ���� ���� �޾Ҵ�. �̸��� 'Janette'�� ����� ����Ͻÿ�.
select * from employees
where first_name = initcap('jaNette');

select * from employees
where lower(first_name) = lower('janette');

select * from employees
where lower(first_name) = 'janette' OR upper(first_name) = 'JANETTE' OR lower(first_name) = lower('jaNette');

--- ǥ���� : java => switch(����) ~ case ���� : �����; break; default : �����;
---         CASE ���� ~ WHEN ���� ~ THEN ����� ELSE ����� END

-- 43. job_id��   'IT_PROG'�̶�� �޿��� 10% ���,
--                'ST_CLERK' �̶�� �޿��� 15% ���,
--                'SA_REP' �̶�� �޿��� 20% ���, �� �ܴ̿� �޿�
-- ��, �̸�, �޿��� ���� ���
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

--- 44. ��, �̸�, ����, �޿�, �޿��� ���� ��å�� ����ϼ���.
--  �޿��� 3000���� ���, 5000���� ���� 7000 ���� �븮, 9000���� ����, 11000���� ����, 13000���� ���� �� �̻� �ӿ�
select last_name, first_name, job_id, salary,
        case when salary <= 3000 then '���'      -- decode�� ���� �Ұ�
             when salary <= 5000 then '����'
             when salary <= 7000 then '�븮'
             when salary <= 9000 then '����'
             when salary <= 11000 then '����'
             when salary <= 13000 then '����'
             else '�ӿ�' end as ��å
from employees;

-- 45. �޿��� ���� ����, �̸�, ��, �޿�, ����, ������ ����Ͻÿ�.
--      �޿��� 2000���� ���� ���� 0�̸� �޿��� 0%, 1�̸� �޿��� 9%, 2�� �޿��� 20%, 3�̸� �޿��� 30%,
--                              4�̸� �޿��� 40%, 5�̸� �޿��� 42%, 6�̸� �޿��� 44%, �̿� �޿��� 45%
select last_name, first_name, salary, job_id, 
        case trunc(salary / 2000) when 0 then salary * 0
                                  when 1 then salary * 0.09
                                  when 2 then salary * 0.2
                                  when 3 then salary * 0.3
                                  when 4 then salary * 0.4
                                  when 5 then salary * 0.42
                                  when 6 then salary * 0.44
                                  else salary * 0.45 end as ����
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
                                      , salary * 0.45 ) as ����
from employees;