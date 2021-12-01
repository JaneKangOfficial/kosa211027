--- 1. ���ν����� �̿��ؼ� emp3_7�� ���������� �Է��ϼ���.
CREATE OR REPLACE PROCEDURE proc_insert
(
    empid in number,        -- in : �ۿ��� ���� �޾ƿ��ڽ��ϴ�.
    lname in varchar2,
    mail in varchar2,
    hdate in varchar2,
    jid in varchar2
)
is
BEGIN
    -- DML�� (select, insert, update, delete, subquery)
    insert into emp3_7(employee_id, last_name, email, hire_date, job_id)
    values(empid, lname, mail, hdate, jid);
END;
/
exec proc_insert(310, 'Park', 'pmail', sysdate, 'AP');      -- �ۿ��� ������ ���� ����

select * from emp3_7 where employee_id = 310;

--- 2. jobs_exam�� ���� 'AD_PRES'�� ���ν����� ���ڰ����� �����ϰ� 
-- ������ jobs���� insert, ������ min_salary�� 2000, max_salary�� 6000���� update �Ͻÿ�.
-- EXEC my_new_job_proc('AD_PRES', 2000, 6000);
CREATE TABLE jobs_exam
as
select * from jobs where 1 = 2;

delete from jobs_exam;

CREATE OR REPLACE PROCEDURE my_new_job_proc
(
    jid in varchar2,
    minsal number,
    maxsal number
)
is
    cnt number;
BEGIN
    select count(*) into cnt from jobs_exam where job_id = jid;
    if cnt = 0 then
        insert into jobs_exam
        select * from jobs where job_id = jid;
    else
        update jobs_exam
        set min_salary = minsal, max_salary = maxsal
        where job_id = jid;
    end if;
END;
/
EXEC my_new_job_proc('AD_PRES', 2000, 6000);

select * from jobs_exam where job_id = 'AD_PRES';