--1. ANSI-JOIN�� ����ؼ� �����ȣ, �̸�, �μ���ȣ, ��ġ�� ����ϴµ� ��簡 149�� ����鸸 ����Ͻÿ�.
select employee_id, first_name, e.department_id, location_id
from employees e join departments d
on e.department_id = d.department_id
where e.manager_id = 149;

--2. ������ 4��°���� 6��°���� PRO�� �ִٸ� it_program���� ���
--                                 ACC�� �ִٸ� finance_account
--                                 �������� business�� ����Ͻÿ�.
select job_id, 
        case substr(job_id,4,3) when 'PRO' then 'it_program'
                                when 'ACC' then 'finance_account'
                                else 'business' end
from employees;

--3. ������ REP�� ���ԵǾ� �ִ� ������� ��� �޿��� �ּұ޿�, �ִ�޿�, �޿��� �հ踦 ���Ͻÿ�.
select trunc(avg(salary),2), min(salary), max(salary), sum(salary)
from employees
where job_id like '%REP%';

--5.  �μ��� �ִ� �޿��� 10000�̻��� �μ��� ����Ͻÿ�.
select department_id, max(salary)
from employees
group by department_id
having max(salary) > 10000;

--6. ������ 'SA'�����ϰ� ���� ���� ������� ������ �޿��� �հ谡 
--10000�� �ʰ��ϴ� ������ �޿��� �հ踦 ����Ͻÿ�.
--���� �޿��� �հ踦 ������������ �����Ͽ� ���
select job_id, sum(salary)
from employees
where job_id not like '%SA%'
group by job_id
having sum(salary) > 10000
order by sum(salary) desc;

--7. �μ��� 20�̰ų� 50�� �μ��� �����ȣ�� �μ���ȣ �� �μ��� 
--�׸��� ��ġ������ ����Ͻÿ�.
select employee_id, e.department_id, department_name, location_id
from employees e, departments d
where e.department_id = d.department_id and e.department_id in (20, 50);

--8. Matos��� ���� ������ �ִ� ����� �ִ�.
--�� ����� �μ������� �����ȣ �׸��� ���� ����Ͻÿ�.
select d.department_id, department_name, employee_id, last_name
from employees e, departments d
where e.department_id = d.department_id and last_name like '%Matos%';

--9. Matos��� ���� ������ �ִ� ����� King��� ���� 
--      ���� ����� �ִ�.
--�� ����� �μ������� �����ȣ �׸��� ���� ����Ͻÿ�.
select d.department_id, department_name, employee_id, last_name
from employees e, departments d
where last_name in ('Matos', 'King');

--10. King��� ���� ������ �ִ� ����� �ִ�.
--�� ����� �μ������� �����ȣ �׸��� ���� ����Ͻÿ�.
--ANSI-JOIN�� ����� ��
select d.department_id, department_name, employee_id, last_name
from employees e join departments d
on e.department_id = d.department_id
where last_name like '%King%';

--12. �μ����̺��� �μ���ȣ�� �μ��� �׸��� �����ڵ�� 
--      �������� ����ϴµ� �����ڵ尡 1400�� ������ ���
select department_id, department_name, location_id
from departments
where location_id = 1400;

--14. ������ ������ ����� �� �μ������� �� �μ��� �ּҸ� ����Ͻÿ�.
select employee_id, last_name, e.department_id, department_name, location_id
from departments d, employees e
where d.department_id = e.department_id;

--15. ���������� ����� �� �� ������ �μ������� �� ���� ���������� ����Ͻÿ�. �μ���ȣ, �μ���, ������ȣ, ��������
select e.employee_id, first_name, d.department_id, department_name, j.job_id, job_title
from employees e, departments d, jobs j
where e.department_id = d.department_id and e.job_id = j.job_id;

--16. ��������� �μ������� ����� �� ����� ���� �μ��� ����ϵ� 200�� �μ����� 260�μ��� �����ϰ� ����Ͻÿ�.
select employee_id, last_name, e.department_id, department_name
from employees e, departments d
where e.department_id(+) = d.department_id and e.department_id not in (200, 260);

select employee_id, last_name, e.department_id, department_name
from employees e right outer join departments d
on e.department_id = d.department_id 
where e.department_id not in (200, 260);

--17. ��������� �μ������� ����� �� ����� ���� �μ��� ����ϵ� �����ȣ�� Ȧ���� �� �� ����Ͻÿ�.
select employee_id, e.department_id, department_name
from employees e right outer join departments d
on e.department_id = d.department_id
where mod(employee_id, 2) = 1;

--18. ������ ���������� ���������� ����ϴ� ���������� ���� ������ ����Ͻÿ�. job_history�� �̿�
select e.employee_id, j.job_id
from employees e, job_history j
where e.employee_id(+) = j.employee_id;

--19. ������ 4��°���� 6��°���� PRO�� �ִٸ� it_program���� ���
--                                 ACC�� �ִٸ� finance_account
--                                 �������� business�� ����Ͻÿ�.
select job_id, 
        case substr(job_id,4,3) when 'PRO' then 'it_program'
                                when 'ACC' then 'finance_account'
                                else 'business' end
from employees;

--20. �޿��� 15000 �̻��̸� �ӿ����� ���
--             10000 �̻��̸� ����
--             7000  �̻��̸� ����
--             5000�̻��̸� �븮
--             �������� ������� ����Ͻÿ�.
select salary,
        case when salary >= 15000 then '�ӿ�'
             when salary >= 10000 then '����'
             when salary >= 7000 then '����'
             when salary >= 5000 then '�븮'
             else '���' end as ��å
from employees; 

--21. �μ��� �޿��� ����� 5000�̻��� �μ��� ����Ͻÿ�.
select department_id, trunc(avg(salary))
from employees
group by department_id
having avg(salary) > 5000;

--22. �޿��� 10000�̻��� ������� �μ��� �޿� ����� 16000�̻��� �μ��� ����Ͻÿ�
select department_id, trunc(avg(salary))
from employees
where salary >= 10000
group by department_id
having avg(salary) >= 16000;

--23. �Ի����� 2005�⵵  ������ �Ի��� ����� �� �μ��� �ִ�޿��� 8000�̻��� �μ��� �ִ� �޿��� ����Ͻÿ�.
select department_id, max(salary)
from employees
where to_char(hire_date, 'yyyy') < '2005'
group by department_id
having max(salary) >= 8000;

--24. �μ��� �ִ� �޿��� 10000�̻��� �μ��� ����Ͻÿ�.
select department_id, max(salary)
from employees
group by department_id
having max(salary) >= 10000;

--25. ������ 'REP'�����ϰ� ���� ���� ������� ������ �޿��� �հ谡 3000�� �ʰ��ϴ� ������ �޿��� �հ踦 ����Ͻÿ�.
--���� �޿��� �հ踦 ������������ �����Ͽ� ���
select job_id, sum(salary)
from employees
where job_id not like '%REP%'
group by job_id
having sum(salary) > 3000
order by sum(salary) desc;

--26.  ������ 25-10-2020������ �ٹ��ϼ��� ����Ͻÿ�. ������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select e.employee_id, e.department_id, hire_date, (to_date('25-10-2020','dd-mm-yyyy') - start_date) as �ٹ��ϼ�
from employees e, job_history j;

--27. '01-01-2005'�� �Ի��� ����� ����Ͻÿ�. ������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select e.employee_id, e.department_id, hire_date, (sysdate - start_date) as �ٹ��ϼ�
from employees e, job_history h
where hire_date = to_date('01-01-2005', 'mm-dd-yyyy');

--28. ����(�޿�*12) : �޿��� Ŀ�̼Ǳ��� ���Եȴ�. ������ ����� ���Ͻÿ�. ������ȣ, �μ���ȣ, �޿�, ���
select employee_id, department_id, salary, (salary + salary * nvl(commission_pct,0)) * 12 as year_sal
from employees;

--29.  'IT_PROG' �̸� �޿���  1.10*salary
--      'ST_CLERK' �̸� �޿���  1.15*salary
--      'SA_REP' �̸�  �޿��� 1.20*salary
--       ������ ������ salary �� �޿��� �����ϰ� heading name��      "REVISED_SALARY"�� �ǰ� �Ͻÿ�.
--case�� decode�� ��� ����Ͻÿ�.
select salary,
        case job_id when 'IT_PROG' then 1.10 * salary
                    when 'ST_CLERK' then 1.15 * salary
                    when 'SA_REP' then 1.20 * salary
                    else salary end as REVISED_SALARY
from employees;

select salary,
        decode( job_id , 'IT_PROG' , 1.10 * salary
                    , 'ST_CLERK' , 1.15 * salary
                    , 'SA_REP' , 1.20 * salary
                    , salary ) as REVISED_SALARY
from employees;

--30 Ŀ�̼��� ������ �޿��� ����� ���Ͻÿ�. Ŀ�̼��� ���� ���� ������ ����
select avg((salary + salary * nvl(commission_pct,0)))
from employees;

--31. ���μ��� Ŀ�̼��� ������ �޿��� �հ踦 ���Ͻÿ�.
select department_id, sum((salary + salary * nvl(commission_pct,0)))
from employees
group by department_id;

--32. �� �μ��� �������� 5�� �̻��� �μ��� ����Ͻÿ�. (join�ƴ�)
select department_id, count(*)
from employees
group by department_id
having count(*) >= 5;

--33. �� �μ��� �ִ� ����� ������ �޿��� ����� ���Ͻÿ�.
select department_id, job_id, avg(salary)
from employees
group by department_id, job_id;

--34. �����ȣ, �̸� , �޿�, �Ի��� , �μ���ȣ, �μ���, ������ȣ, �������� ����� �� ������� �ʴ� ������ ����ϰ� ����� ���� ������ ����Ͻÿ�.
select employee_id, first_name, salary, hire_date, d.department_id, department_name, j.job_id, job_title
from employees e, departments d, jobs j
where e.department_id = d.department_id and e.job_id = j.job_id;

select employee_id, first_name, salary, hire_date, d.department_id, department_name, j.job_id, job_title
from employees e full outer join departments d on e.department_id = d.department_id
full outer join jobs j on e.job_id = j.job_id;

--35. ������̺��� ������ MAN�� �����ϰ� �޿��� 10000�̻��� 
--����� �����ȣ�� ���� ���� �׸��� �޿��� ����Ͻÿ�.
select employee_id, last_name, job_id, salary
from employees
where job_id like '%MAN%' and salary >= 10000;

--36. ������ SA_REP�� AD_PRES �̸鼭 �޿��� 15000�� �ʰ��ϴ� ����� ����Ͻÿ�.
--��, ��, ����, �޿��� ��� or�� and�� ���
select last_name, job_id, salary
from employees
where (job_id = 'SA_REP' or job_id = 'AD_PRES') and salary > 15000;

--37. �� ������ in�����ڸ� ����Ͻÿ�.
select last_name, job_id, salary
from employees
where job_id in ('SA_REP' ,'AD_PRES')  and salary > 15000;

--38. �μ��� ������������ �����ϰ� �Ի��ϵ� ������������ ����
--�μ���ȣ , �޿�, �Ի���, ��
select department_id, salary, hire_date, last_name
from employees
order by department_id desc, hire_date desc;

--39. �μ��� ������������ �����ϰ� �Ի����� ������������ �����Ͽ� ���
--�μ���ȣ , �޿�, �Ի���, ��
select department_id, salary, hire_date, last_name
from employees
order by department_id desc, hire_date;

--40. �μ��� ������������ �����ϰ� �Ի����� ������������ �����Ͽ� �޿��� ������������ �����Ͽ� ���
--�μ���ȣ ,  �Ի���, �޿�, ��
select department_id, salary, hire_date, last_name
from employees
order by department_id desc, hire_date, salary desc;