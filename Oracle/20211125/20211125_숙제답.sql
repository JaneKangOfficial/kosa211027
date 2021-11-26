-- 20211125_����.sql ��
-- ���� 1)
-- create
create table member1 (      -- ���� ���� create�� ���� �����. => pk �����. => fk �����.
    user_id     varchar2(20)    constraint mem_user_id_nn not null,
    user_pw     varchar2(200)   constraint mem_user_pw_nn not null,
    user_name   varchar2(40)    constraint mem_user_name_nn not null,
    user_birth  timestamp       constraint mem_user_birth_nn not null,
    user_gender varchar2(1)     constraint mem_user_gender_nn not null,
    user_addr   varchar2(200)   constraint mem_user_addr_nn not null,
    user_ph1    varchar2(13)    constraint mem_user_ph1_nn not null,
    user_ph2    varchar2(13),
    user_regist timestamp,
    user_email  varchar2(200),
    join_ok     varchar2(500)
);
desc member1;

-- alter
-- table ����
alter table member1        
add (constraint mem_user_id_pk primary key (user_id),     -- pk �� fk �� ����(constraint pk, constriant fk) ����� �ȵȴ�. 
     constraint mem_user_email_uu unique(user_email));

-- �� ����
alter table member1
modify (user_id constraint mem_user_id_pk primary key,
        user_email constraint mem_user_email_uu unique);
        
alter table member1
modify (user_regist default sysdate);

-- create
drop table board1;
create table board1(
    board_num         number            constraint board_board_num_nn not null,
    user_id           varchar2(20)      constraint board_user_id_nn not null,        -- member1���� �޾ƿ��� user_id : �̸��� �޶� ������ �ڷ����� ���ƾ� �Ѵ�. 
    board_name        varchar2(20)      constraint board_board_name_nn not null,
    board_pass        varchar2(200)     constraint board_board_pass_nn not null,
    board_subject     varchar2(100)     constraint board_board_subject_nn not null,
    board_connent     varchar2(2000),
    board_date        timestamp,
    ip_addr           varchar2(15),
    read_count        number
);
desc board1;

-- alter
-- table ����
alter table board1
add constraint board1_board_num_pk primary key (board_num);

-- �� ����
alter table board1
modify board_num constraint board1_board_num_pk primary key;

-- table ����
alter table board1
add constraint board1_user_id_fk foreign key(user_id) REFERENCES member1(user_id);  -- (user_id) �̸��� ������ ������ ������ �����ϴ�.

-- �� ����
alter table board1
modify user_id constraint board1_user_id_fk REFERENCES member1(user_id);

alter table board1
modify read_count default 0;

-- �������� Ȯ��
select * from user_constraints where table_name = 'MEMBER1';
select * from user_cons_columns where table_name = 'MEMBER1';

select * from user_constraints where table_name = 'BOARD1';
select * from user_cons_columns where table_name = 'BOARD1';

-- insert
desc member1;
insert into member1 (USER_ID, USER_PW, USER_NAME, USER_BIRTH, USER_GENDER, USER_ADDR, USER_PH1, USER_PH2, USER_REGIST, USER_EMAIL, JOIN_OK)
values('highland0', '1234', '�̼���', '1995-05-05', '1', '����', '010-1234-1234', null, default, 'hemail@mail.com', null);

insert into member1 (USER_ID, USER_PW, USER_NAME, USER_BIRTH, USER_GENDER, USER_ADDR, USER_PH1, USER_PH2, USER_REGIST, USER_EMAIL, JOIN_OK)
values('highland1', '1234', 'ȫ�浿', '1990-05-05', '1', '����', '010-1234-4321', null, sysdate, 'hamail@mail.com', null);

insert into member1 (USER_ID, USER_PW, USER_NAME, USER_BIRTH, USER_GENDER, USER_ADDR, USER_PH1, USER_PH2, USER_REGIST, USER_EMAIL, JOIN_OK)
values('highland2', '1234', '�浿ȫ', '1993-05-05', '1', '����', '010-1212-1234', '02-123-1234', '2021-11-26', 'hahamail@mail.com', null);

select * from member1;

desc board1;
insert into board1(BOARD_NUM, USER_ID, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONNENT, BOARD_DATE, IP_ADDR, READ_COUNT )
values((select nvl(max(BOARD_NUM),0) + 1 from board1), 'highland0', '������ƺ�', '1234', '����1', '����1', sysdate, '123-123-123-123', 0);

insert into board1(BOARD_NUM, USER_ID, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONNENT, BOARD_DATE, IP_ADDR, READ_COUNT )
values((select nvl(max(BOARD_NUM),0) + 1 from board1), 'highland1', '�屺', '1234', '����2', '����2', sysdate, '123-123-123-123', 0);

select * from board1;

-- ���� 5) highland0 ȸ���� ȸ�����̵�, ȸ����, �̸���, �Խñ� ��ȣ, �Խñ� ����, raed_count�� ���
select m.user_id, user_name, user_email, board_num, board_subject, read_count
from member1 m, board1 b
where m.user_id = b.user_id and m.user_id = 'highland0';

-- ���� 6) �Խñ��� ������ READ_COUNT�� 1�� ���� �� ���̴�. 
--         update���� ���� �� ������ READ_COUNT 1���� �Ҽ� �ְ� update���� �ۼ��Ͻÿ�.
--         1�� �Խñ��� ���� ��Ű�ÿ�.
update board1           -- �Խñ� �� ������, ��ǰ �� ������
set read_count = read_count + 1
where board_num = 1;

select * from board1 where board_num = 1;

-- ���� 7) �Խñ� 2���� �ش��ϴ� ȸ���� ����Ͻÿ�.
select * from member1
where user_id = (select user_id from board1 where board_num = 2);

-- ���� 8) ��ϵ� �Խñ��� ������ ����Ͻÿ�.
select count(*) from board1;

-- ���� 9) �� ȸ���� �Խñ��� ������ ����Ͻÿ�. (���� �ƴ�)
select user_id, count(*) 
from board1
group by user_id;

-- ���� 10) ȸ���� ���� ����Ͻÿ�.
select count(*) from member1;

-- ���� 11) ���̵� 'highland0'�� ȸ���� ��ȭ��ȣ�� '02-9876-1234', �̸����� 'highland0@nate.com', ��й�ȣ�� '22222'�� �����Ͻÿ�.
update member1      -- ȸ�� ���� ������ 
set user_ph1 = '02-9876-1234', user_email = 'highland0@nate.com', user_pw = '22222'
where user_id = 'highland0';

select * from member1 where user_id = 'highland0';      -- ȸ�� �� ������

-- ���� 12) �Խñ� 1���� ������ '���� ������ �����ҷ�', ������ '������ �����ؼ� \n ���� ����� �� �� �ְ� ����ؾ���'��  �����Ͻÿ�.
update board1
set board_subject = '���� ������ �����ҷ�', board_connent = '������ �����ؼ� \n ���� ����� �� �� �ְ� ����ؾ���'
where board_num = 1;

select * from board1 where board_num = 1;       -- 1�� �Խñ� �� ������ 

-- ���� 13) 1�� �Խñ��� ����� �� ������ \n�� <br /> �� ��µǰ� �Ͻÿ�.
select board_num, user_id, board_subject, read_count, replace (board_connent, '\n', '<br/>') content
from board1
where board_num = 1;

select * from board1;

-- ���� 14)  �Խñ� ������ �ʹ� �� ȭ�鿡 �� ��µǱ� ��ƴ� . ������ ù��° ���� ���� 5���ڸ� ����ϰ� �ڿ��� *�� 5���� ��µǰ� �Ͻÿ�.
select substr(board_subject,1,5) || '*****'
from board1;

-- ���� 15) '�̼���'ȸ���� ���̵� �ؾ���ȴٰ� �Ѵ�. �̸��ϰ� ��ȭ��ȣ�� �̿��ؼ� ���̵� ����ϴ� �� 
-- ���̵�� ��� ����ؼ��� �ȵǰ� ù���ں��� ������, �������� '*'�� ��µǰ� �Ͻÿ�.
select rpad(substr(user_id,1,3), length(user_id), '*')      -- ���̵� ã�� ������
from member1
where user_email = 'highland0@nate.com'
and    user_ph1 = '02-9876-1234';

-- ���� 16) �Խ��� ���̺��� �Խñ��� ���� �� �Խñ��� user_id�� �Խñ� ������ ���� ����Ͻÿ�.
select user_id, cnt
from (  select count(board_subject) cnt, user_id from board1
        group by user_id
        order by cnt desc)
where rownum = 1;

-- ���� 17) ���ݱ����� �۾��� ��� ���� ���� ��Ű�ÿ�.
commit;

-- ���� 18) '�̼���'ȸ���� Ż���Ϸ��� �Ѵ�. �̼��� ȸ���� Ż�� �Ҽ� �ְ� �����Ͻÿ�.
select user_id from member1 where user_name = '�̼���';

delete from board1
where user_id = (select user_id from member1 where user_name = '�̼���');

delete member1
where user_name = '�̼���';

select * from member1 where user_name = '�̼���';
select * from board1 where user_id = 'highland0';

-- ���� 19) '�̼���' ȸ���� Ż���ϴ� ���� �ƴϾ��� �� �� �� ������ �Ͽ��� . ���������� '�̼���'ȸ���� ���� ��� ������(�Խ��� ����) ���� �� �� �ְ� �Ͻÿ�.
rollback;

-- ���� 20) ��highland0���� ȸ���� �α����� �Ͽ� �ڽ��� �� ���� 1�� �Խñ��� �����Ϸ��� �Ѵ�.
-- �ش� �Խù��� ���� �ǰ� �Ͻÿ�.
delete from board1
where user_id = 'highland0' and board_num = 1;
