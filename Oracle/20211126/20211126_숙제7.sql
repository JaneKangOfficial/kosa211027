drop table member2;
drop table publisher;
drop table book;
drop table contract_company;
drop table supply_book;
drop table chk_book;
drop table order1;
drop table order_list;

-- create
create table member2 (
    member_no       varchar2(15)    not null,
    member_name     varchar2(20)    not null,
    member_id       varchar2(12)    not null,
    member_phone    varchar2(30)    not null,
    member_email    varchar2(40),
    member_mobile   varchar2(30),
    pay_method      varchar2(16)
);

create table publisher (
    pub_co_num     varchar2(15)    not null,
    pub_name        varchar2(20)    not null,
    pub_addr        varchar2(50)    not null,
    pub_phone       varchar2(30)    not null,
    bank_no         varchar2(7)     not null,
    account_num     varchar2(16)    not null
);

create table book (
    book_no     number           not null,
    book_name   varchar2(20),
    book_ck     number(6,3),
    book_qty    number
);

create table contract_company (
    cont_number     number      not null,
    cont_status     number      not null,
    min_pct         number(6,3) not null,
    cont_date       date        not null,
    pub_co_num      varchar2(15)
);

create table supply_book (
    book_no         number      not null,
    cont_number     number      not null,
    book_reg        date        not null
);

create table chk_book (
    chk_no      number          not null,
    member_no   varchar2(15)    not null,
    book_no     number(6,3)     not null,
    reg_date    date            not null
);

create table order1 (
    order_no        number          not null,
    del_addr        varchar2(50)    not null,
    del_phone       varchar2(30)    not null,
    order_date      date            not null,
    del_code        number(6,3)     not null,
    payment         number(6,3)     not null,
    tot_payment     number,
    member_no       varchar2(15),
    qty             number  
);

create table order_list(
    order_no    number  not null,
    order_qty   number  not null,
    book_no     number  not null
);

----------------------------------------------------

-- pk
alter table member2
add constraint member_member_no_pk primary key(member_no);

alter table publisher
add constraint pub_co_num_pk primary key (pub_co_num);

alter table book
add constraint book_book_no_pk primary key (book_no);

alter table contract_company
add constraint concom_cont_number_pk primary key(cont_number);

alter table supply_book
add constraint supply_book_no_cont_number_pk primary key (book_no, cont_number);

alter table chk_book
add constraint chk_no_member_no_book_no_pk primary key (chk_no, member_no, book_no);

alter table order1
add constraint order_no_pk primary key (order_no);

alter table order_list
add constraint list_order_no_book_no_pk primary key(order_no, book_no);

----------------------------------------------------

-- fk
alter table contract_company
add constraint concom_pub_co_num_fk foreign key (pub_co_num)
        references publisher(pub_co_num) on delete set null;
        
alter table supply_book
add (constraint supply_book_book_no_fk foreign key (book_no)
        references book(book_no) on delete cascade,
     constraint supply_book_cont_num_fk foreign key (cont_number)
        references contract_company(cont_number) on delete cascade);

alter table chk_book
add (constraint chk_member_no_fk foreign key (member_no)
        references member2(member_no) on delete cascade,
     constraint chk_book_no_fk foreign key(book_no)
        references book(book_no) on delete cascade);

alter table order1
add constraint order_momber_no_fk foreign key (member_no)
        references member2(member_no) on delete set null;
        
alter table order_list
add (constraint list_order_no_fk foreign key (order_no)
        references order1(order_no) on delete cascade,
     constraint list_book_no_fk foreign key (book_no)
        references book(book_no) on delete cascade);