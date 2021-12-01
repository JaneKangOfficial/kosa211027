--- 1. 프로시저를 이용해서 emp3_7에 직원정보를 입력하세요.
CREATE OR REPLACE PROCEDURE proc_insert
(
    empid in number,        -- in : 밖에서 값을 받아오겠습니다.
    lname in varchar2,
    mail in varchar2,
    hdate in varchar2,
    jid in varchar2
)
is
BEGIN
    -- DML문 (select, insert, update, delete, subquery)
    insert into emp3_7(employee_id, last_name, email, hire_date, job_id)
    values(empid, lname, mail, hdate, jid);
END;
/
exec proc_insert(310, 'Park', 'pmail', sysdate, 'AP');      -- 밖에서 안으로 값을 보냄

select * from emp3_7 where employee_id = 310;

--- 2. jobs_exam을 만들어서 'AD_PRES'를 프로시저에 인자값으로 전달하고 
-- 없으면 jobs에서 insert, 있으면 min_salary는 2000, max_salary는 6000으로 update 하시오.
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