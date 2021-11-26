-- 20211125_숙제.sql 답
-- 문제 1)
-- create
create table member1 (      -- 파일 따로 create만 먼저 만든다. => pk 만든다. => fk 만든다.
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
-- table 레벨
alter table member1        
add (constraint mem_user_id_pk primary key (user_id),     -- pk 와 fk 는 같이(constraint pk, constriant fk) 만들면 안된다. 
     constraint mem_user_email_uu unique(user_email));

-- 열 레벨
alter table member1
modify (user_id constraint mem_user_id_pk primary key,
        user_email constraint mem_user_email_uu unique);
        
alter table member1
modify (user_regist default sysdate);

-- create
drop table board1;
create table board1(
    board_num         number            constraint board_board_num_nn not null,
    user_id           varchar2(20)      constraint board_user_id_nn not null,        -- member1에서 받아오는 user_id : 이름은 달라도 되지만 자료형은 같아야 한다. 
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
-- table 레벨
alter table board1
add constraint board1_board_num_pk primary key (board_num);

-- 열 레벨
alter table board1
modify board_num constraint board1_board_num_pk primary key;

-- table 레벨
alter table board1
add constraint board1_user_id_fk foreign key(user_id) REFERENCES member1(user_id);  -- (user_id) 이름이 같으면 참조명 생략이 가능하다.

-- 열 레벨
alter table board1
modify user_id constraint board1_user_id_fk REFERENCES member1(user_id);

alter table board1
modify read_count default 0;

-- 제약조건 확인
select * from user_constraints where table_name = 'MEMBER1';
select * from user_cons_columns where table_name = 'MEMBER1';

select * from user_constraints where table_name = 'BOARD1';
select * from user_cons_columns where table_name = 'BOARD1';

-- insert
desc member1;
insert into member1 (USER_ID, USER_PW, USER_NAME, USER_BIRTH, USER_GENDER, USER_ADDR, USER_PH1, USER_PH2, USER_REGIST, USER_EMAIL, JOIN_OK)
values('highland0', '1234', '이숭무', '1995-05-05', '1', '성남', '010-1234-1234', null, default, 'hemail@mail.com', null);

insert into member1 (USER_ID, USER_PW, USER_NAME, USER_BIRTH, USER_GENDER, USER_ADDR, USER_PH1, USER_PH2, USER_REGIST, USER_EMAIL, JOIN_OK)
values('highland1', '1234', '홍길동', '1990-05-05', '1', '성남', '010-1234-4321', null, sysdate, 'hamail@mail.com', null);

insert into member1 (USER_ID, USER_PW, USER_NAME, USER_BIRTH, USER_GENDER, USER_ADDR, USER_PH1, USER_PH2, USER_REGIST, USER_EMAIL, JOIN_OK)
values('highland2', '1234', '길동홍', '1993-05-05', '1', '성남', '010-1212-1234', '02-123-1234', '2021-11-26', 'hahamail@mail.com', null);

select * from member1;

desc board1;
insert into board1(BOARD_NUM, USER_ID, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONNENT, BOARD_DATE, IP_ADDR, READ_COUNT )
values((select nvl(max(BOARD_NUM),0) + 1 from board1), 'highland0', '상장범아빠', '1234', '제목1', '내용1', sysdate, '123-123-123-123', 0);

insert into board1(BOARD_NUM, USER_ID, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONNENT, BOARD_DATE, IP_ADDR, READ_COUNT )
values((select nvl(max(BOARD_NUM),0) + 1 from board1), 'highland1', '장군', '1234', '제목2', '내용2', sysdate, '123-123-123-123', 0);

select * from board1;

-- 문제 5) highland0 회원의 회원아이디, 회원명, 이메일, 게시글 번호, 게시글 제목, raed_count를 출력
select m.user_id, user_name, user_email, board_num, board_subject, read_count
from member1 m, board1 b
where m.user_id = b.user_id and m.user_id = 'highland0';

-- 문제 6) 게시글을 읽으면 READ_COUNT가 1씩 증가 할 것이다. 
--         update문을 실행 할 때마다 READ_COUNT 1증가 할수 있게 update문을 작성하시오.
--         1번 게시글을 증가 시키시오.
update board1           -- 게시글 상세 페이지, 제품 상세 페이지
set read_count = read_count + 1
where board_num = 1;

select * from board1 where board_num = 1;

-- 문제 7) 게시글 2번에 해당하는 회원을 출력하시오.
select * from member1
where user_id = (select user_id from board1 where board_num = 2);

-- 문제 8) 등록된 게시글의 개수를 출력하시오.
select count(*) from board1;

-- 문제 9) 각 회원의 게시글의 갯수를 출력하시오. (조인 아님)
select user_id, count(*) 
from board1
group by user_id;

-- 문제 10) 회원의 수를 출력하시오.
select count(*) from member1;

-- 문제 11) 아이디가 'highland0'인 회원의 전화번호를 '02-9876-1234', 이메일을 'highland0@nate.com', 비밀번호를 '22222'로 변경하시오.
update member1      -- 회원 수정 페이지 
set user_ph1 = '02-9876-1234', user_email = 'highland0@nate.com', user_pw = '22222'
where user_id = 'highland0';

select * from member1 where user_id = 'highland0';      -- 회원 상세 페이지

-- 문제 12) 게시글 1번의 제목을 '나는 열심히 공부할래', 내용을 '열심히 공부해서 \n 빨리 취업이 될 수 있게 노력해야지'로  수정하시오.
update board1
set board_subject = '나는 열심히 공부할래', board_connent = '열심히 공부해서 \n 빨리 취업이 될 수 있게 노력해야지'
where board_num = 1;

select * from board1 where board_num = 1;       -- 1번 게시글 상세 페이지 

-- 문제 13) 1번 게시글을 출력할 때 내용의 \n을 <br /> 로 출력되게 하시오.
select board_num, user_id, board_subject, read_count, replace (board_connent, '\n', '<br/>') content
from board1
where board_num = 1;

select * from board1;

-- 문제 14)  게시글 제목이 너무 길어서 화면에 다 출력되기 어렵다 . 제목을 첫번째 글자 부터 5글자를 출력하고 뒤에는 *를 5개가 출력되게 하시오.
select substr(board_subject,1,5) || '*****'
from board1;

-- 문제 15) '이숭무'회원이 아이디를 잊어버렸다고 한다. 이메일과 전화번호를 이용해서 아이디를 출력하는 데 
-- 아이디는 모두 출력해서는 안되고 첫글자부터 세글자, 나머지는 '*'로 출력되게 하시오.
select rpad(substr(user_id,1,3), length(user_id), '*')      -- 아이디 찾기 페이지
from member1
where user_email = 'highland0@nate.com'
and    user_ph1 = '02-9876-1234';

-- 문제 16) 게시판 테이블에서 게시글을 많이 쓴 게시글의 user_id를 게시글 갯수와 같이 출력하시오.
select user_id, cnt
from (  select count(board_subject) cnt, user_id from board1
        group by user_id
        order by cnt desc)
where rownum = 1;

-- 문제 17) 지금까지의 작업을 모두 정상 종료 시키시오.
commit;

-- 문제 18) '이숭무'회원이 탈퇴하려고 한다. 이숭무 회원이 탈퇴 할수 있게 삭제하시오.
select user_id from member1 where user_name = '이숭무';

delete from board1
where user_id = (select user_id from member1 where user_name = '이숭무');

delete member1
where user_name = '이숭무';

select * from member1 where user_name = '이숭무';
select * from board1 where user_id = 'highland0';

-- 문제 19) '이숭무' 회원이 탈퇴하는 것이 아니었는 데 잘 못 삭제를 하였다 . 정상적으로 '이숭무'회원에 대한 모든 내용이(게시판 포함) 존재 할 수 있게 하시오.
rollback;

-- 문제 20) ‘highland0’인 회원이 로그인을 하여 자신이 쓴 글인 1번 게시글을 삭제하려고 한다.
-- 해당 게시물이 삭제 되게 하시오.
delete from board1
where user_id = 'highland0' and board_num = 1;
