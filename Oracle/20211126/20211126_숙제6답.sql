-- ERD
-- �ڽ� ���� - �� �ĺ����� (����)
-- on delete set null

-- �θ� �ڽ� ���� - �ĺ� ���� (�Ǽ�)
-- on delete cascade (�������� �ʾƵ� �ĺ������ϼ� �ִ�.)

-- �ڽ� ���� �� �θ� ����
-- on delete cascade ������ �ȵȴ�.

-- create
-- ����
create table teacher(
    teach_no    number          not null,
    teach_name  varchar2(10)    not null,
    teach_tel   varchar2(11)    not null,
    teach_email varchar2(30)    not null,
    teach_addr  varchar2(255)   not null,
    teach_carr  varchar2(1000),     -- ������
    teach_viol  varchar2(1000),     -- ���Ի���
    teach_certi varchar2(1000)      -- �ڰ���
);

-- ����
create table subject (
    subj_no     number              not null,
    subj_name   varchar2(100)       not null,
    subj_cnt    varchar2(1000),
    subj_group  number              not null,
    subj_day    number              not null,
    subj_time   number              not null
);

-- ���������
create table employment (
    employment_no   number          not null,
    emp_no          number          not null,
    employment_sign varchar2(1000)  not null,
    employment_sal  number          not null,
    employment_posi varchar2(10)    not null,
    employment_date timestamp       not null
);

-- ������
create table leceval (
    leceval_no        number      not null,
    emp_no            number      not null,
    lec_no            number      not null,
    leceval_substfy   number      not null,
    leceval_relate    number      not null,
    leceval_lecstfy   number      not null,
    leceval_etc       number
);

-- ����ä����
create table leccontract(
    lec_no      number         not null,
    teach_no    number,
    subj_no     number,
    lec_date    timestamp      not null,
    lec_pay     number         not null,
    lec_sign    varchar2(1000) not null,
    lec_unit    number
);

-- ����ä�����
create table jobintv(
    jobintv_no      number  not null,
    emp_no          number  not null,
    jobintv_lang    number  not null,
    jobintv_serv    number  not null,
    jobintv_task    number  not null,
    jobintv_social  number  not null,
    jobintv_solve   number  not null
);

-- ���
create table employee (
    emp_no       number           not null,
    dept_no      number,
    emp_name     varchar2(10)     not null,
    emp_tel      varchar2(11)     not null,
    emp_email    varchar2(30)     not null,
    emp_addr     varchar2(225)    not null,
    emp_date     timestamp,
    emp_carr     varchar2(1000),
    emp_certi    varchar2(1000)
);

-- �⼮��
create table attend(
    attend_no        number      not null,
    emp_no           number      not null,
    lec_no           number      not null,
    attend_date      timestamp   not null,
    attend_time      number      not null,
    compl_date       timestamp   not null
);

-- �μ�
create table department(
    dept_no     number          not null,
    dept_name   varchar2(100)   not null,
    dept_tel    varchar2(11)    not null,
    dept_addr   varchar2(255)   not null
);
---------------------------------------------------------------------

-- alter
-- primary key
-- ����
alter table teacher
add constraint teacher_teach_no_pk primary key (teach_no);

-- ����
alter table subject
add constraint subject_subj_no_pk primary key (subj_no);

-- ���������
alter table employment
add constraint emp_mnt_no_emp_no_pk primary key (employment_no, emp_no);    -- ����Ű

-- ������
alter table leceval
add constraint leceval_lece_no_emp_no_lec_no_pk primary key (leceval_no, emp_no, lec_no);    -- ����Ű

-- ����ä����
alter table leccontract
add constraint leccontract_lec_no_pk primary key (lec_no);

-- ����ä�����
alter table jobintv
add constraint jobintv_no_emp_no_pk primary key (jobintv_no, emp_no);    -- ����Ű

-- ���
alter table employee
add constraint employee_emp_no_pk primary key (emp_no);

-- �⼮��
alter table attend
add constraint attend_no_emp_no_lec_no_pk primary key(attend_no, emp_no, lec_no);    -- ����Ű

-- �μ�
alter table department
add constraint dept_no_pk primary key (dept_no);

---------------------------------------------------------------------

-- foreign key
alter table employment
add constraint employment_emp_no_fk foreign key (emp_no)
    REFERENCES employee(emp_no) on delete cascade;
    
alter table leceval
add (constraint leceval_emp_no_fk foreign key(emp_no)
        REFERENCES employee(emp_no) on delete cascade,
    constraint leceval_lec_no_fk foreign key(lec_no)
        references leccontract(lec_no) on delete cascade);

alter table leccontract
add (constraint leccontract_teach_no_fk foreign key(teach_no)
        references teacher(teach_no) on delete set null,
    constraint leccontract_subj_no_fk foreign key (subj_no)
        references subject(subj_no) on delete set null);

alter table jobintv
add (constraint jobintv_emp_no_fk foreign key(emp_no)
        references employee(emp_no) on delete set null);
        
alter table employee
add constraint employee_dept_no_fk foreign key(dept_no)
        references department(dept_no) on delete set null;
        
alter table attend        
add (constraint attend_emp_no_fk foreign key(emp_no)
        references employee(emp_no) on delete cascade,
    constraint attend_lec_no_fk foreign key(lec_no)
        references leccontract(lec_no) on delete cascade);
