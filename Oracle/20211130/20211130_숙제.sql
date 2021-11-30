--- 1. ���ν����� �̿��ؼ� emp3_7�� ���������� �Է��ϼ���.
CREATE OR REPLACE PROCEDURE exam1
(
    empid in number,
    lname in varchar2,
    mail in varchar2,
    hdate in varchar2,
    jid in varchar2
)
is
BEGIN
    insert into emp3_7(employee_id, last_name, email, hire_date, job_id)
    values(empid, lname, mail, hdate, jid);
    DBMS_OUTPUT.PUT_LINE(empid|| ' ' || lname|| ' ' || mail|| ' ' || hdate|| ' ' || jid);
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT|| ' ��');
END;
/
exec exam1 (500, 'ha', 'a@mail.com', '2021-11-11', '����');
select * from emp3_7;


--- 2. jobs_exam�� ���� 'AD_PRES'�� ���ν����� ���ڰ����� �����ϰ� 
-- ������ jobs���� insert, ������ min_salary�� 2000, max_salary�� 6000���� update �Ͻÿ�.
-- EXEC my_new_job_proc('AD_PRES', 2000, 6000);
create table jobs_exam
as
select * from jobs;

select * from jobs_exam;

-- merge ���
CREATE OR REPLACE PROCEDURE my_new_job_proc
(
    jid in varchar2,
    minsal in number,
    maxsal in number
)
is
BEGIN
    merge into jobs_exam a
        using (select * from jobs where job_id = jid) b
        on (a.job_id = b.job_id)
    WHEN MATCHED THEN
        UPDATE SET min_salary = minsal, max_salary = maxsal
    WHEN NOT MATCHED THEN
        INSERT (a.min_salary, a.max_salary)
        VALUES (b.min_salary, b.max_salary);
END;
/
exec my_new_job_proc('AD_PRES', 2000, 6000);
select * from jobs_exam;