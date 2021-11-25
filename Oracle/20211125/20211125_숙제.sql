--���� 1) ȸ�� ���̺��� ����ÿ�. �� �÷��� ���� ������ �ο� �Ͻÿ�.
--Table MEMBER
--================================
--USER_ID     	NOT NULL 	VARCHAR2(20)  
--USER_PW     	NOT NULL 	VARCHAR2(200) 
--USER_NAME   	NOT NULL 	VARCHAR2(40)  
--USER_BIRTH  	NOT NULL 	TIMESTAMP 
--USER_GENDER 	NOT NULL 	VARCHAR2(1)   
--USER_ADDR   	NOT NULL 	VARCHAR2(200) 
--USER_PH1    	NOT NULL 	VARCHAR2(13)  
--USER_PH2             			VARCHAR2(13)  
--USER_REGIST          		TIMESTAMP  
--USER_EMAIL           		VARCHAR2(200) 
--JOIN_OK              			VARCHAR2(500)
--
--USER_ID     : primary key (MEMBER_USER_ID_PK)
--USER_EMAIL : unique (member_USER_EMAIL_UU)
--USER_REGIST  : ����Ʈ ���� sysdate

create table MEMBER (
    user_id     varchar2(20)    not null,
    user_pw     varchar2(200)   not null,
    user_name   varchar2(40)    not null,
    user_birth  timestamp       not null,
    user_gender varchar2(1)     not null,
    user_addr   varchar2(200)   not null,
    user_ph1    varchar2(13)    not null,
    user_ph2    varchar2(13),
    user_regist timestamp       DEFAULT sysdate,
    user_email  varchar2(200),
    join_ok     varchar2(500),
    constraint MEMBER_USER_ID_PK primary key(user_id),
    constraint MEMBER_USER_EMAIL_UU UNIQUE(user_email)
);
desc member;

--����2) �Խ��� ���̺��� ����� �� �÷��� ���������� �ο� �Ͻÿ�.
--Table BOARD
--====================================
--BOARD_NUM     	NOT NULL 	NUMBER         
--USER_ID       	NOT NULL 	VARCHAR2(20)   
--BOARD_NAME    	NOT NULL 	VARCHAR2(20)    --- �� ���� 
--BOARD_PASS    	NOT NULL 	VARCHAR2(200)  
--BOARD_SUBJECT 	NOT NULL 	VARCHAR2(100)  -- ����
--BOARD_CONTENT          		VARCHAR2(2000) -- ����
--BOARD_DATE             		TIMESTAMP   
--IP_ADDR                		VARCHAR2(15)   
--READ_COUNT             		NUMBER      
--
--BOARD_NUM : primary key (BOARD_BOARD_NUM_PK)
--USER_ID : foreign key (BOARD_USER_ID_FK)
--READ_COUNT ; ����Ʈ ���� 0

create table BOARD (
    BOARD_NUM         NUMBER         not null,
    USER_ID           varchar2(20)   not null,
    BOARD_NAME        varchar2(20)   not null,
    BOARD_PASS        VARCHAR2(200)  not null,
    BOARD_SUBJECT     varchar2(100)  not null,
    BOARD_CONTENT     varchar2(2000),
    BOARD_DATE        TIMESTAMP,
    IP_ADDR           varchar2(15),
    READ_COUNT        NUMBER         DEFAULT 0,
    constraint BOARD_BOARD_NUM_PK primary key(BOARD_NUM),
    constraint BOARD_USER_ID_FK foreign key(USER_ID) REFERENCES MEMBER (USER_ID)
);
desc BOARD;

--���� 3) ȸ�����̺� �Ʒ� ������ �����Ͽ� 5���� �����͸� �����ÿ�.
--insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
--values('highland0','111111','�̼���','1999-12-12','1','����','010-1234-1234',null,default,null);

insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('highland0','111111','�̼���','1999-12-12','1','����','010-1234-1234',null,default,null);

insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('hi','111111','ȫ�浿','1909-10-10','2','���','010-1234-5678',null,default,'aemail');

insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('ha','111111','�̼���','2009-09-09','2','��õ','010-1212-3434',null,default,'bemail');

insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('han','111111','������','2005-05-05','2','�λ�','010-1111-1234',null,default,'cemail');

insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('land','111111','�̼���','2021-11-25','1','����','010-2222-1234',null,default,null);

select * from member;

--����4)�Խ��� ���̺� �����͸� �Ʒ� ���� ���� 6�� �̻��� �ִµ� �� ȸ������ �ּ� �Ѱ� �̻� �Խñ��� ��ϵǰ� �Ͻÿ�.
--insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
--values(1, 'highland0', '����� �ƺ�', '1111','����', '����', '192.168.3.117');

insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(1, 'highland0', '����� �ƺ�', '1111','����', '����', '192.168.3.117');

insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(2, 'hi', 'ȫ', '1111','����2', '����2', '192.168.3.123');

insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(3, 'ha', '��', '1111','����3', '����3', '192.168.3.456');

insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(4, 'han', '��', '1111','����4', '����4', '192.168.3.789');

insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(5, 'highland0', '��', '1111','����5', '����5', '192.168.1.123');

insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(6, 'land', '��', '1111','����6', '����6', '192.168.2.123');

select * from board;

--����5) highland0ȸ���� ȸ�����̵�, ȸ����, �̸���, �Խñ� ��ȣ, �Խñ� ����, READ_COUNT�� ����Ͻÿ�.
select m.user_id, user_name, user_email, board_num, board_subject, read_count
from member m, board b
where m.user_id = b.user_id and m.user_id = 'highland0';
desc member;
desc board;

--����6) �Խñ��� ������ READ_COUNT�� 1�� ���� �� ���̴�. 
--         update���� ���� �� ������ READ_COUNT 1���� �Ҽ� �ְ� update���� �ۼ��Ͻÿ�.
--         1�� �Խñ��� ���� ��Ű�ÿ�.
update board
set read_count = read_count + 1
where board_num = 1;

select * from board;

--���� 7) �Խñ� 2���� �ش��ϴ� ȸ���� ����Ͻÿ�.
select * from board where board_num = 2;

--���� 8) ��ϵ� �Խñ��� ������ ����Ͻÿ�.
select count(*) from board;

--���� 9) �� ȸ���� �Խñ��� ������ ����Ͻÿ�. (���� �ƴ�)
select user_id, count(*) 
from board
group by user_id;

--���� 10) ȸ���� ���� ����Ͻÿ�.
select count(*) from member;

--���� 11) ���̵� 'highland0'�� ȸ���� ��ȭ��ȣ�� '02-9876-1234', �̸����� 'highland0@nate.com', ��й�ȣ�� '22222'�� �����Ͻÿ�.
update member
set user_ph1 = '02-9876-1234', user_email = 'highland0@nate.com', user_pw = '22222'
where user_id = 'highland0';

select * from member;

--���� 12) �Խñ� 1���� ������ '���� ������ �����ҷ�', ������ '������ �����ؼ� \n ���� ����� �� �� �ְ� ����ؾ���'��  �����Ͻÿ�.
update board
set board_subject = '���� ������ �����ҷ�', board_content = '������ �����ؼ� \n ���� ����� �� �� �ְ� ����ؾ���'
where board_num = 1;

select * from board;

--���� 13) 1�� �Խñ��� ����� �� ������ \n�� <br /> �� ��µǰ� �Ͻÿ�.
select replace (board_content, '\n', '<br/>')
from board
where board_num = 1;

select * from board;

--���� 14)  �Խñ� ������ �ʹ� �� ȭ�鿡 �� ��µǱ� ��ƴ� . ������ ù��° ���� ���� 5���ڸ� ����ϰ� �ڿ��� *�� 5���� ��µǰ� �Ͻÿ�.
select rpad(substr(board_subject,1,5), 10, '*')
from board;

--���� 15) '�̼���'ȸ���� ���̵� �ؾ���ȴٰ� �Ѵ�. �̸��ϰ� ��ȭ��ȣ�� �̿��ؼ� ���̵� ����ϴ� �� ���̵�� ��� ����ؼ��� �ȵǰ� ù���ں��� ������ �������� '*'�� ��µǰ� �Ͻÿ�.
select rpad(substr(user_id,1,3), length(user_id), '*')
from member
where user_email =  (select user_email from member where user_name = '�̼���')
and    user_ph1 = (select user_ph1 from member where user_name = '�̼���');

--���� 16) �Խ��� ���̺��� �Խñ��� ���� �� �Խñ��� user_id�� �Խñ� ������ ���� ����Ͻÿ�.
select count(board_subject), user_id
from board
group by user_id;

select *
from(select count(board_subject), user_id
     from board
     group by user_id
     order by count(board_subject) desc)
where rownum <= 1;

--���� 17) ���ݱ����� �۾��� ��� ���� ���� ��Ű�ÿ�.
commit;

--���� 18) '�̼���'ȸ���� Ż���Ϸ��� �Ѵ�. �̼��� ȸ���� Ż�� �Ҽ� �ְ� �����Ͻÿ�.
delete from board
where user_id = 'highland0';

delete from member
where user_name = (select user_name from member where user_id = 'highland0');

--���� 19) '�̼���' ȸ���� Ż���ϴ� ���� �ƴϾ��� �� �� �� ������ �Ͽ��� . ���������� '�̼���'ȸ���� ���� ��� ������(�Խ��� ����) ���� �� �� �ְ� �Ͻÿ�.
rollback;

--���� 20) ��highland0���� ȸ���� �α����� �Ͽ� �ڽ��� �� ���� 1�� �Խñ��� �����Ϸ��� �Ѵ�.
--�ش� �Խù��� ���� �ǰ� �Ͻÿ�.
delete from board
where user_id = 'highland0' and board_num = 1;

select rownum, user_id, board_subject
from ( select user_id, board_subject from board where user_id = 'highland0')
where rownum = 1;

delete from ( select user_id, board_subject from board where user_id = 'highland0')
where rownum = 1;