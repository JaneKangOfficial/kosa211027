--- ������ 'REP'���Ե� ������ �޿��� �հ� , ���, �ִ�, �ּ�, ��� ���� ���Ͻÿ�.
select sum(salary), trunc(avg(salary),2), max(salary), min(salary), count(*)
from employees
where job_id like '%REP%';

--- 80�� �μ����� Ŀ�̼��� �޴� ����� ���� 
select count(commission_pct)
from employees
where department_id = 80;

--- �μ��� �޿��� ����� ���ϰ� �޿��� ����� ������������ ����Ͻÿ�.
select department_id, trunc(avg(salary),2)
from employees
group by department_id
order by trunc(avg(salary),2) desc;

--- �׷��Լ��� ����� ��� select ���� �� �� �ִ� �÷��� group by���� �ִ� �÷��� �ü� �ִ�.

--- ������ �޿��� 6000�̻��� ������� �μ��� ����� ���ϰ� �μ��� ����� 7000�̻��� �μ��� ����Ͻÿ�. �μ��� ��������
select department_id, trunc(avg(salary),2)
from employees
where salary >= 6000
group by department_id
having avg(salary) >= 7000
order by avg(salary) desc;

--- ������ 'REP'�� �����ϰ� ���� ���� �������� ������ �޿��� �հ谡 13000�̻��� ������ ����Ͻÿ�.�޿��� �հ踦 ������������ ����
select job_id, sum(salary)
from employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000
order by sum(salary);

--����) ������ IT_PROG, ST_CLERK, SA_REP�� ���ԵǾ� ���� ���� ���
select * from employees
where job_id not in ('%IT_PROG%' , '%ST_CLERK%' , '%SA_REP%');

--����) �޿��� 3000���� 5000���̿� ���� ���� ���
select * from employees
where salary not between 3000 and 5000;

--1.��� ���̺��� �μ���ȣ, �����ȣ, �̸� , �Ի����� ����ϴ� �� �μ���ȣ�� 70�� �μ��� ����Ͻÿ�.
select department_id, employee_id, first_name, hire_date
from employees
where department_id = 70;

--2.������̺��� �����ȣ, �μ���ȣ, �̸�, �޿��� ����ϴµ� �Ի����� 02/06/07�� ����鸸 ����Ͻÿ�.
select employee_id, department_id, first_name, salary, hire_date
from employees
where hire_date = to_date('02/06/07');

--3. ��� ���̺��� �μ���ȣ, ��� ��ȣ, �̸�, ������ȣ�� ����ϴµ� �̸��� William �� ����� ����Ͻÿ�.
select department_id, employee_id, first_name, job_id
from employees
where first_name = 'William';

--4. ��� ���̺��� �μ���ȣ �����ȣ �̸� ������ȣ �޿��� ����ϴµ� ���� ��ȣ�� FI_ACCOUNT�� ��� ���� ����Ͻÿ�.
select department_id, employee_id, first_name, job_id, salary
from employees
where job_id = 'FI_ACCOUNT';

--5. ������̺��� ����ϴ� �̸� name���� �μ���ȣ�� did �����ȣ�� eid ������ȣ�� ����� �� �μ���ȣ 50�̻��� �μ��� ���
select first_name as name, department_id as did, employee_id as eid, job_id
from employees
where department_id >= 50;

--6. ��� ���̺��� ����ϴ� �� �޿��� 4000���� 10000���̸� ����Ͻÿ�.
select * from employees
where salary between 4000 and 10000;

--7. ��� ���̺��� ������ FI_ACCOUNT�� �ƴ� ������� ����Ͻÿ�.
select * from employees
where job_id not in ('FI_ACCOUNT');

--8. ������̺��� ����ϴµ� �μ���ȣ�� 50�̰ų�, 70�� ��� ����Ͻÿ�
select * from employees
where department_id in (50, 70);

--9. ������̺��� ����̸��� Daniel���� ū ����� ����Ͻÿ�.
select * from employees
where first_name > 'Daniel';

--10. ��� ���̺��� ����̸��� Daniel���� ũ�� Julia���� ���� ������� ���.
select * from employees
where first_name > 'Daniel' and first_name < 'Julia';
--where first_name between 'Daniel' and 'Julia';

--11. ������̺��� ����� ��  �Ի����� 01/01/13���� 06/01/03����  �Ի��� ����鸸 ����Ͻÿ�.
select * from employees
where hire_date between '01/01/13' and '06/01/03';

--12. ������̺��� �޿��� 10000����  15000������ ����鸸 ����Ͻÿ�.
select * from employees
where salary between 10000 and 15000;

--13. ��� ���̺��� �μ���ȣ��   50�̰ų� 70�̰ų� 90��   ����� ����Ͻÿ�.
select * from employees
where department_id in (50, 70, 90);

--14. ��� ���̺��� ������ȣ��  FI_MGR�̰ų� SA_MAN�̰ų�  MK_MAN�� ����� ����Ͻÿ�.
select * from employees
where job_id in ('FI_MGR', 'SA_MAN', 'MK_MAN');

--15. ������̺��� �����ȣ, ��, �޿�,  ����ȣ�� ����ϴµ� ��簡 100,101,201�� �������  ����Ͻÿ�.
select employee_id, last_name, salary, manager_id
from employees
where manager_id in (100, 101, 201);

--16. ��� ���̺��� �����ȣ, ����ȣ, �μ���ȣ�� ����ϴµ� ���� Hartstein�� Vargas������ ����鸸 ����Ͻÿ�.
select employee_id, manager_id, department_id
from employees
where last_name BETWEEN 'Hartstein' and 'Vargas';

--17. ��� ���̺��� �����ȣ, ����ȣ, �μ���ȣ�� ����ϴµ� ���� Hartstein�� Vargas�� ����� ����Ͻÿ�.
select employee_id, manager_id, department_id
from employees
where last_name in ( 'Hartstein' , 'Vargas');

--18. ��� ���̺��� Ŀ�̼��� null�� ����鸸 ����ϼ���.
select * from employees
where commission_pct is null;

--19. ��� ���̺��� ��, ������ȣ, ��縦 ����ϴ°� ��簡 ���� ����� ����Ͻÿ�.
select last_name, job_id, manager_id
from employees
where manager_id is null;

--20. ��� ���̺��� �μ��� ���� ����� ��� �Ͻÿ�.
select * from employees
where department_id is null;

--21. ������̺��� �̸��� ù���ڰ� 'S'�� ���۵Ǵ� ����� ����Ͻÿ�.
select first_name
from employees
where first_name like 'S%';

--22. ������̺��� �Ի��� �� day�� 6���� ������� ����Ͻÿ�.
select * from employees
where hire_date like '%/06';

--23 ������̺��� 02�⵵�� �Ի��� ������� ����Ͻÿ�.
select * from employees
where hire_date like '02/%';
--select * from hr.employees where to_char(hire_date,'yy') = '02';

--24. ������̺��� ������ȣ�� MA�� �����ϰ� �������Ͻÿ�.
select * from employees
where job_id like '%MA%';

--25. ��� ���̺��� �̸��� �ι�° ���ڰ� 's'�� ������� ����Ͻÿ�.
select first_name
from employees
where first_name like '_s%';

--26. ��� ���̺��� �̸��� ����° ���ڿ� 's'�� �����ϴ� �����
select first_name
from employees
where first_name like '__s%';

--27. ������̺��� �̸��� 's'�� �ڿ��� �ι�°�� ���ԵǾ� �ִ� �����?
select first_name
from employees
where first_name like '%s_';

--28. ��� ���̺��� ������ 'A_'�� �����ϰ� �ִ� �����?
select job_id
from employees
where job_id like '%A\_%' escape '\';

--29.������̺��� �޿��� 10000 �̸��̰� 15000�� �ʰ��ϴ� ���
select salary
from employees
where salary not between 10000 and 15000;

--30. ��� ���̺��� ��� ���� Doran���� Fox���̿� �ִ� ����� ������ ������ ����� ���
select * from employees
where last_name not between 'Doran' and 'Fox';

--31. ��� ���̺��� �μ���ȣ�� 50, 70, 90�μ��� �ƴ� �����?
select * from employees
where department_id not in (50, 70, 90);

--32. ������̺��� ���� ������ ����ϴµ� ������ IT_PROG,ST_CLERK, SA_REP�� �ƴ� ���
select last_name, job_id
from employees
where job_id not in ('IT_PROG', 'ST_CLERK', 'SA_REP');

--33. ������̺� �ִ� commission_pct�� null�� �ƴ� ������� ����Ͻÿ�.
select * from employees
where commission_pct is not null;

--34. ������̺��� ��簡 �ִ� ����鸸 ����Ͻÿ�.
select * from employees
where manager_id is not null;

--35. �μ��� ������ �ִ� �����?
select * from employees
where department_id is not null;

--36. ������ 'SA'�� �����ϴ� �����?
select * from employees
where job_id like '%SA%';

--37. ������ 'SA'�� �����ϰ� ���� ���� �����?
select * from employees
where job_id not like '%SA%';

--38. ������̺��� �μ��� 50, 70, 90�̸鼭 �޿��� 10000�̻��� ������� ���Ͻÿ�.
select * from employees
where department_id in (50, 70, 90) and salary >= 10000;

--39. ������̺��� �μ��� 50,70�̰� �� �μ��� 90�̸鼭 �޿���  10000 �̻��� ���?
select * from employees
where department_id in (50, 70) or department_id = 90 and salary >= 10000;

--40.�Ʒ��������� IN �����ڸ� ��� 
--select * from hr.employees
--where ( department_id = 50
--OR department_id = 70
--OR department_id = 90 )
--AND salary >= 10000;
select * from employees
where department_id in (50, 70, 90) and salary >= 10000;

--41.IN������ ���
--select * from hr.employees
--where department_id = 50
--OR department_id = 70
--OR department_id = 90
--AND salary >= 10000;
select * from employees
where department_id in (50, 70) or department_id = 90 and salary >= 10000;

--42. ������̺��� �̸��� ���������� ����Ͻÿ�.(��������)
select first_name
from employees
order by first_name;

--43. ������̺��� �μ���ȣ �̸� �޿� �Ի����� ����ϴµ� �μ���ȣ�� ������������ �����Ͻÿ�.
select department_id, first_name, salary, hire_date
from employees
order by department_id;

--44. ������̺��� �μ���ȣ�� 90�� �μ��� ����� ����ϴµ� ��� �̸��� ������������ ����
select first_name, department_id
from employees
where department_id = 90
order by first_name;

--45. ������̺��� �μ���ȣ, �����ȣ, �̸�, �޿�, �Ի����� ����� �� �μ��� 50, 70�� �μ��� ����� �Ի��� ������ �����Ͻÿ�.
select department_id, employee_id, first_name, salary, hire_date
from employees
where department_id in (50, 70)
order by hire_date;

--46. ����� �Ի��� ���� ���� ��� ���� ����Ͻÿ�.
select * from employees
order by hire_date desc;

--47. �Ի����� 02/08/16����� 08/01/29������� �Ի��� ����� �μ��� ��� �׸��� �̸��� ����ϴµ� �Ի����� ���� ��� ���� ����Ͻÿ�.
select department_id, employee_id, first_name, hire_date
from employees
where hire_date between '02/08/16' and '08/01/29'
order by hire_date desc;

--48. 'SA'�� �����ϴ� ������ ������ ������ ����� �߿� �μ���ȣ, ���, �̸�, �Ի����� ����ϴµ� �μ��� ������������ �����Ͻÿ�.
select department_id, employee_id, first_name, hire_date
from employees
where job_id not like 'SA%'
order by department_id desc;

--49. ����� �μ���ȣ, ���, �̸�, �Ի���, ������ ����� �� �μ���ȣ�� 90�� 110�� ����� �� �μ��� ������������ �ϰ� �μ��� ����� �Ի��� �������� ������������ �����Ͻÿ�.
select department_id, employee_id, first_name, hire_date, job_id
from employees
where department_id in (90, 110)
order by department_id, hire_date;

--50. ������̺��� �μ���ȣ,�Ի��� ,���, �̸�, ����, �޿�, �޿��� Ŀ�̼��� ���Ѱ��� ����ϴµ� �̸��� comm���� �����ϰ� �μ��� 50, 70, 120�� ����ϴµ� �μ��� ��������, �Ի����� ������������ �����Ͻÿ�.
select department_id, hire_date, employee_id, first_name, job_id, salary, (salary + salary * nvl(commission_pct,0)) as comm
from employees
where department_id in (50, 70, 120)
order by department_id, hire_date desc;

--51. ������̺��� �����ȣ, ��, �޿��� 12�� ���� ���� sal�� ����ϰ� �޿��� 12�� ���� ���� ������������ �����Ͻÿ�.
select employee_id, last_name, salary, salary * 12 as sal
from employees
order by sal;

--52. ���� �μ� �׸��� �޿��� ����ϴµ� �޿��� 4000���� 10000���̿� �ִ� ����� �μ��� ������������ �����ϰ� �޿��� ������������ ���� 
select last_name, department_id, salary
from employees
where salary between 4000 and 10000
order by department_id desc, salary; 

--53. ���� �޿��� ����� �� ������ 'MA'�����ϰ� �ִ� ����� ������ ������ ������� �μ��� ��������, �޿��� ������������ �����Ͻÿ�.
select last_name, salary
from employees
where job_id not like '%MA%'
order by department_id, salary desc;