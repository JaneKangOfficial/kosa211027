--�����Լ�
--Lower, Upper, initcap, concat, substr
--/* ����
--select last_name, lower(last_name) , hire_date
--from hr.employees
--where lower(last_name) = 'grant';
--*/

--����) ���� ��� �ҹ����� grant�� ��� �빮���� 'GRANT'�� �������̺���
--�ش� ����� ã���� �Ѵ�.  (Grant) 
select last_name
from employees
where last_name = initcap('grant') or ast_name = initcap('GRANT');

--����) 'GranT'�� �Է������� ������̺��� ���� 'Grant'�� ����� ã���ÿ�.
select last_name
from employees
where last_name = initcap('GranT');

--����) ���� ��� �빮�ڷ� ��ȯ�ϰ� �̸� ��� �ҹ��ڷ� ��ȯ�Ͽ�
--���� �̸��� �ٿ� ����� �� ' ���� GRANT douglas �Դϴ�'�� 
--��µǰ� �Ͻÿ�.
select '���� ' || upper(last_name)||' '|| lower(first_name) || ' �Դϴ�.'
from employees;

-- concat
--����) ���� �̸��� �ٿ� ���
select concat(last_name, first_name)
from employees;

--����) ���� ��� �빮�ڷ� ��ȯ�ϰ� �̸� ��� �ҹ��ڷ� ��ȯ�Ͽ�
--���� �̸��� �ٿ� ����� �� ' ���� GRANT douglas �Դϴ�'�� 
--��µǰ� �Ͻÿ�. concat�� �̿�
select concat('���� ' || upper(last_name), lower(first_name)||' �Դϴ�.')
from employees;

--/* ���� ����
--����Ŭ�� ��
--String str = "abcdefghi";
--String result = str.subString(2, 6); //cdef
--String result = str.subString(2); //cdefghi
--���� �� */ 

--����) ���� Davies���� av�� ����Ͻÿ�.
select last_name, substr(last_name,2,2)
from employees
where last_name = 'Davies';

--����) ���� �ι�° ���ں��� ��� ����Ͻÿ�.
select last_name, substr(last_name, 2)
from employees;

--����) ���� ������ ���ڿ��� �α��ڸ� �������ÿ�
select last_name, substr(last_name, -2, 2)
from employees;

--����) ���� �ڿ� on���� ������ ����� ã���ÿ�.
select last_name
from employees
where substr(last_name,-2,2) = 'on';

select last_name
from employees
where last_name like '%on';

--����) ���� �ڿ� ����° ���ڰ� so�� ����� ����Ͻÿ�.
select last_name, substr(last_name, -3, 2)
from employees
where substr(last_name, -3, 2) = 'so';

select last_name
from employees
where last_name like '%so_';

--����) ���� ������ ����ϴµ� �̸����� ���ʿ��� 3���ڸ� ����Ͻÿ�.
--������ȣ, ��, �޿�, ����, �̸���
select employee_id, last_name, salary, job_id, email, substr(email, 1, 3)
from employees;

-- 29. ���� ������ ����ϴµ� �̸����� �����ʿ��� 3���ڸ� ����Ͻÿ�.
-- ������ȣ, ��, �޿�, ����, �̸���
select employee_id, last_name, salary, job_id, substr(email, -3)
from employees;

--����) ���� ������ ����ϴµ� �̸����� �����ʿ��� 3���ڸ� ����ϰ� �������� ��-���� ���
--������ȣ, ��, �޿�, ����, �̸���
select employee_id, last_name, salary, job_id, email, lpad(substr(email,-3), length(email), '-')
from employees;

--/* ���� ����
--String str ="abcdefg";
--int i = str.indexOf("f");  //5
--���� �� */

--����) o�� �ִ� ���� o�� ���°�� �ִ� ��ġ���� ����Ͻÿ�. --- �Ʒ� �����ϱ�
--������ȣ, ��, ���� ��ġ, ����
select employee_id, last_name, instr(last_name, 'o'), job_id
from employees;

--����) oc�� �ִ� ���� oc�� ���°�� �ִ� ��ġ���� ����Ͻÿ�. -- �Ʒ� �����ϱ� 
--������ȣ, ��, ���� ��ġ, ����
select employee_id, last_name, instr(last_name, 'oc'), job_id
from employees;

--/* ���� ����
--instr(last_name,'oc') : ���ϴ� ���ڰ� ������ 0�� ��ȯ
--instr('abcde' , 'a') : 1
--�ڹٿ��� "abcdef".indexOf("a") : 0
--���� �� */

--����) ������ RE�� �ִ� ��� RE���� 3���ڸ� ����Ͻÿ�.
--������ȣ, ��,  ����, ������ ����
select employee_id, last_name, job_id, substr(job_id, instr(job_id, 'RE'), 3)
from employees
where job_id like '%RE%';

--����) ������ȣ, ��, �Ի��� , �޿�, �޿��� 10ĭ�� ����ϰ� ������ ���� �տ� * ǥ�ð� �ǰ� ����.
select employee_id, last_name, hire_date, salary, lpad(salary, 10, '*')
from employees;

--����) ������ȣ, ��, �Ի��� , �޿�, �޿��� 10ĭ�� ����ϰ� ������ ���� �ڿ� * ǥ�ð� �ǰ� ����.
select employee_id, last_name, hire_date, salary, rpad(salary, 10, '*')
from employees;

--����) ������ȣ, ��, �Ի���, ������ ����ϴµ� ������ RE�� �ִٸ� RE�� AB�� �����Ͽ� ���
select employee_id, last_name, hire_date, job_id, replace(job_id, 'RE','AB')
from employees
where job_id like '%RE%';

--/* ���� ����
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
--���� �� */

--����) ������ȣ, ����ó, Ŀ�̼�, �μ���ȣ,�޿�
--�޿��� 3000���� �������� ���� �������� ����Ͻÿ�.
select employee_id, phone_number, commission_pct, department_id, salary, mod(salary, 3000)
from employees;

--����) 2002�⵵���� �Ի��� �������� ����Ͻÿ�.
select * from employees
where hire_date >= to_date('2002','yyyy');

select * from employees 
where to_char(hire_date,'yyyy') >= '2002';

--����) ���ش� ���ñ��� ���ְ� �������� Ȯ���Ͻÿ�.
select trunc((sysdate - to_date('2021-01-01')) / 7) 
from dual; 

--����) �������� ��� �ٹ������� ����Ͻÿ�.
--������ȣ, ��, ����ó,�μ�, �ٹ����
select employee_id, last_name, phone_number, department_id, trunc((sysdate - hire_date) / 365) as �ٹ����
from employees;

--����) �ټӳ�� 18�� �̻��� ����鸸 ����Ͻÿ�.
select trunc((sysdate - hire_date) / 365) from employees
where trunc((sysdate - hire_date) / 365) >= 18;

--����) ���� : �Խ��Ǹ���Ʈ���� ������ 5����****�� �� ó�� 
--������ ���� 3���ڸ� ��� �ڿ� *�� ������ ����Ͻÿ�.
--������ȣ, �Ի���, ��
select employee_id, hire_date, rpad(substr(last_name,1,3), 6, '*')
from employees;

--����) ȫ�浿�� ������Դϱ�? -- ���� ��abc���� ��
select 'ȫ�浿', length('ȫ�浿')
from dual;

--����)"ȫ�浿 \n"���� �Ǿ� �ִ� ���� html���� �� �ٲ��̵ǵ���
--     "ȫ�浿 <br>"�����Ͻÿ�.
select replace('ȫ�浿\n', '\n', '<br>')
from dual;

--����) �Ի����� 'YYYY-MM-DD'�� ��¥�� 31-05-2019 16:24:30 ����
--�� ���·� �������.
select to_char(hire_date, 'dd-mm-yyyy HH24:MM:SS AM') from employees;

--����) ����(3333333)�� 3�ڸ����� ��ǥ�� �� ���
select to_char(3333333, '999,999,999') from dual;

--����) �������̺��� �޿��� W33,333,333������ ����Ͻÿ�.
select salary, to_char(salary, 'L99,999,999')
from employees;

--����) ������ 2018-10-25������ �ٹ��ϼ��� ����Ͻÿ�.
--������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select employee_id, department_id, hire_date, trunc(to_date('2018-10-25','yyyy-mm-dd') - hire_date) as �ٹ��ϼ�
from employees;

--����) ������ 25-10-2018������ �ٹ��ϼ��� ����Ͻÿ�.
--������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select employee_id, department_id, hire_date, trunc(to_date('25-10-2018','dd-mm-yyyy') - hire_date) as �ٹ��ϼ�
from employees;

--����) ������ 10-25-2018������ �ٹ��ϼ��� ����Ͻÿ�.
--������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select employee_id, department_id, hire_date, trunc(to_date('10-25-2018','mm-dd-yyyy') - hire_date) as �ٹ��ϼ�
from employees;

--����) '10-25-2002'�� �Ի��� ����� ����Ͻÿ�.
--������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select employee_id, department_id, hire_date
from employees
where hire_date = to_date('10-25-2002','mm-dd-yyyy');

--����) ���������� �Ϸ��� �մϴ�.
--      ����(�޿�*12) : �޿��� Ŀ�̼Ǳ��� ���Եȴ�.
--������ ������ ���Ͻÿ�.
-- ������ȣ, �μ���ȣ, �޿�, ����
select employee_id, department_id, salary, (salary + salary * nvl(commission_pct,0)) * 12 as ����
from employees;

select employee_id, department_id, salary, 
        salary *( 1 + nvl(commission_pct,0)) * 12 yearsal
from employees;

--����) �μ��� 90�̰ų� 30�� �μ��� ������ ������ ���Ͻÿ�
--������ȣ, �μ���ȣ, �޿�, ����
select employee_id, department_id, salary, salary * 12 as ����
from employees
where department_id = 90 or department_id = 30;

select employee_id, department_id, salary, salary * 12 
from employees
where department_id in (90,30);

--����) ���� ��ȣ�� ���� �޿� �׸��� ������ ����Ͻÿ�.
select employee_id, last_name, salary, salary * 12 as ����
from employees;

-- ǥ����
--����) �޿��� 10000�̻��̸� "�̻���Դϴ�"
--             7000�̻��̸� "������Դϴ�"
--             5000�̻��̸� "������Դϴ�"
--             �������� ������� ����Ͻÿ�.
--      ���� �޿��� ���� ����Ѵ�.
--case
select last_name, salary,
        case when salary >= 10000 then '�̻���Դϴ�'
             when salary >= 7000 then '������Դϴ�'
             when salary >= 5000 then '������Դϴ�'
            else '����Դϴ�' end
from employees;

--����) �޿��� 2000���� ���� ���� ���� 
--       0�̸� 0.00
--       1�̸� 0.09
--       2�̸� 0.20
--       3�̸� 0.30
--       4�̸� 0.40
--       5�̸� 0.42
--       6�̸� 0.44
--             0.45 ��ŭ ������ �ο��ȴ�.
--�ο��Ǵ� ������ ����Ͻÿ�.
--���� �޿��� ���� ����Ͻÿ�.(��, �μ��� 80�� �����)
select last_name, salary,
    case mod(salary, 2000) when 0 then salary * 0.00
                           when 1 then salary * 0.09
                           when 2 then salary * 0.20
                           when 3 then salary * 0.30
                           when 4 then salary * 0.40
                           when 5 then salary * 0.42
                           when 6 then salary * 0.44
                           else salary * 0.45 end as ����
from employees
where department_id = 80;

--����) ���� ��ü���� �Ի����� ���Ϻ��� ����� �ֱٿ� �Ի��� 
--����� ����Ͻÿ�.
select min(hire_date), max(hire_date) from employees;

--- �޿��� 1000������ �ݿø��Ͽ� ����Ͻÿ�.
select salary, round(salary, 4)
from employees;

--- �����ȣ�� ¦���� ����� ����Ͻÿ�
select employee_id from employees
where mod(employee_id, 2) = 0;

-- �����ȣ�� Ȧ���� ����� ����Ͻÿ�.
select employee_id from employees
where mod(employee_id, 2) = 1;

--- ����� �޿��� 3000���� 6000 ������ ����� ����Ͻÿ�,
select salary from employees
where salary between 3000 and 6000;

--- ����� �޿��� 3000���� 6000 ������ �޿��� ���� ���ϴ� ����� ����Ͻÿ�,
select salary from employees
where salary not between 3000 and 6000;

--- ������� �Ի����� �� �ְ� �Ǿ��� ����Ͻÿ�.
select hire_date, round((sysdate - hire_date) / 7)
from employees;

--- ����� �� 1000�ְ� ���� ����鸸 ����Ͻÿ�.
select hire_date, round((sysdate - hire_date) / 7)
from employees
where round((sysdate - hire_date) / 7) >= 1000;

--- ������� �Ի����� ����� �Ǿ����� ����Ͻÿ�.
select hire_date, round((sysdate - hire_date) / 365)
from employees;

--- email���� ù������ 2����, 2��°���� 2��¥ , 3��° ���� 2���ڸ� ����Ͻÿ�.
select email, substr(email, 1, 2), substr(email, 2, 2),substr(email, 3, 2)
from employees;

-- 10-25-2003���� ���߿� ���� ����� ����Ͻÿ�.
select hire_date from employees
where hire_date > to_date('10-25-2003','mm-dd-yyyy');

-- ������� Ŀ�̼��� �����ϴ� ������ ���Ͻÿ�.
select salary, commission_pct, (salary + salary * nvl(commission_pct,0)) * 12 as ����
from employees;

--- 50, 60, 90�� �μ��� �ƴ� ������� ���Ͻÿ�
select department_id from employees
where department_id not in (50, 60, 90);

--��¥�� 10-20-2003���� ���� �Ի��� ����� ��� ����Ͻÿ�.
--�̶� Steven�� �Ի����� 10-20-2003�Դϴ�
select hire_date from employees
where hire_date < to_date('10-20-2003', 'mm-dd-yyyy');

---- ����̸�, �޿�, ���� �� ���Ͻÿ�. Ŀ�̼��� ���� ��� Ŀ�̼��� 0���� �Ѵ�.
--������ ���� ��� ���� ����Ͻÿ�.
select first_name, salary, (salary + salary * nvl(commission_pct, 0)) * 12 as ����
from employees
order by ���� desc;

--- �� �������� �μ��� 60�̰ų� 90�� ����� ����Ͻÿ�
select department_id, first_name, salary, (salary + salary * nvl(commission_pct, 0)) * 12 as ����
from employees
where department_id in (60, 90)
order by ���� desc;