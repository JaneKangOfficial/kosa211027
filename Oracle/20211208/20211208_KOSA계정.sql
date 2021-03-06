/*

고객번호	고객이름	고객연락처	대여번호	대여일     	대여총금액	영화번호    	대여금액
    1	홍길동	    2	    a1  	2021.12.08	    1000	    m01	    1000
    1	홍길동	    2	    a2  	2021.12.09	    1000	    m01	    1000
    2	이순신	    3	    a3  	2021.12.09	    2000	    m01	    1000
                                                                m02	    1000
    1	홍길동	    2	    a4	    2021.12.10	    3000	    m02	    1000
                                                                m03	    1000
                                                                m04	    1000
                                
고객번호	고객이름	고객연락처	대여번호	대여일	    대여총금액		-- 고객대여
    1	홍길동     	2	    a4	    2021.12.10	    3000		
							
대여번호	영화번호	대여금액		-- 대여리스트			
    a4	    m02	    1000					
            m03 	1000					
            m04 	1000					
							
고객번호	고객이름	고객연락처	대여번호	대여일	    대여총금액		-- 고객대여
    1	홍길동	    2       	a1	2021.12.08	4000		
                                a2	2021.12.09	5000		
                                a3	2021.12.09	5000		
							
고객번호	고객이름	고객연락처		-- 고객			
							
고객번호	대여번호	대여일	    대여총금액		-- 대여		
    1	    a1	2021.12.08	4000				
            a2	2021.12.09	5000				
            a3	2021.12.09	5000				


-- 개념설계 -------------------------------------------------------------------------
1. 명사도출
    1) 명사도출
    2) 개념이 불분명한 명사 제거
    3) 엔티티타입 특성 및 속성값 제거
    4) 포괄적인 업무프로세스 해당 명사 제거
    5) 중복되는 명사 제거
    6) 누락된 엔티티타입 유추
    7) 최종 엔티티타입 후보
2. 엔티티타입 정의서
    1) 데이터 모델의 모든 속성을 나열한다.
    2) 모든 속성 중에 뒤부터 2~4자 정도를 분리해본다.
    3) 공통으로 발생하는 접미어를 분리하여 하나로 만든다.
    4) 분리된 접미어를 비슷한 것끼리 묶어 이름을 부여한다.
    5) 각 데이터별로 데이터 타입과 길이를 지정한다.
    6) 각 엔티티타입의 속성에 도메인을 할당한다.    
3. 관계 정의서
4. 개념설계 ERD
5. 속성 정의서
6. 식별자 정의서
7. 도메인 정의서

-- 시나리오
    사용자 요구사항
    1) 회원등록 및 주문
     - 인터넷에서 도서를 구입하려면 반드시 이 회사의 회원으로 등록해야 구매가 가능하다.
     - 인터넷의 회원등록정보에는 회원번호, 주민등록번호, 주소, 전화번호, 전자메일ID, 휴대폰번호, 결재방법이 있다.
     - 인터넷을 통해 등록한 회원은 구매할 도서목록을 선택하고 인터넷 주문서 양식에 주문 내용을 입력하여 주문한다.
     - 주문서 양식에는 주문목록에 대한 상세정보와 주문일자, 배송지 주소, 배송지 전화번호, 배송방법, 결재방법이 있다.
     - 주문목록에 대한 상세 정보로는 구매가격, 개수가 있다.
     - 등록된 회원에게는 도서를 구매하는 실적에 따라 구매 포인트를 부여하여 다음 구매 시 혜택을 보게 한다.
     - 포인트 부여 기준은 구매가의 1%로 한다. 회원이 책을 구매하기 위해 체크하였으나 당장 구매하지 않고 다른 시간에도 구매가 가능해야 한다.
    
    2) 출판사 거래
     - 출판사와는 별도의 계약을 맺고 있으며 계약을 맺지 않은 출판사와는 거래를 하지 않는다.
     - 한 번 계약을 맺었다가 해지할 수 있으며, 다시 계약을 맺을 수도 있다. 이때 이전 계약상태에 대한 정보도 필요하다. 계약의 갱신은 여러번 가능하다.
     - 계약서에는 계약번호, 사업자번호, 출판사명, 계약일자, 최저가 비율이 포함된다.
     - 출판사별로 원가에 대한 최저가 비율을 지정하여 비율에 의해 산정된 최저 금액 이하로는 도서를 판매할 수 없다.
     - 계약 수정에 의해 최저가 비율이 변경 가능하다.
     - 출판사 정보는 사업자번호, 출판사명, 출판사 전화번호, 출판사 주소, 거래은행코드, 계좌번호를 관리한다.
     - 출판사에서 도서를 공급 받으면 도서를 목록별로 분류하여 창고에 등록하고, 재고현황을 관리한다.
     - 관리하고자 하는 도서의 정보는 도서번호, 도서명, 도서구분, 저자, 출판사, 발행일자, 정가, 적용 할인율이다. 적용 할인율은 출판사별 최저가 비율을 초과할 수 없다.
     - 출판사에서 신간 서적을 발간하면 공급받아서 인터넷에 신간 광고를 한다.
     - 신간의 기준은 발생일로부터 3개월 이내의 서적이다.
     - 인터넷에 접수되는 도서주문을 받아 재고 현황을 파악하고, 만약 재고가 남아있지 않을 경우는 책을 출간한 출판사에 연락하여 공급받는다.
     - 출판사에는 매달 도서과 매각되는 현황을 보고서로 출력하여 송부한다.
    
    3) 배송 관리
     - 주문된 도서는 택배를 이용하여 직접 배송하는 방법과 지하철을 이용하는 간접 배송 방법을 이용한다.
     - 주문이 발생한 단위로 배송이 이루어지며 주문된 개별 도서별로는 배송되지 않는다.
     - 배송 요청서에는 배송 일시와 배송지 주소, 배송지 전화번호와 직접 배송인지 위탁 배송인지를 구분하는 내용이 있다.
     - 직접 배송을 위해 택배업체를 미리 등록하여 가능한 택배업체에 용역을 맡긴다.
     - 배송업체 정보는 사업자번호, 사업자명, 배송업체 전화번호, 배송업체 주소가 있다.
     - 지하철 배송을 위해 잡지를 파는 상점(이하 지하철 상점이라 함)을 미리 등록하여 책을 구매한 회원들이 찾아갈 수 있도록 한다.
     - 관리하고자 하는 지하철 상점 정보로는 사업자번호, 사업자명, 지하철 상점 전화번호, 지하철역, 역내위치가 있다.
     - 배송업체의 배송일자가 굥휴일일 경우, 특별 배송 조건에 따라 용역비를 추가한다. 예를 들어, 택배 업체의 기본 용역비가
        건당 2000원인데, 1월 1일에 배송을 할 경우 용역비 30%를 추가하여 2600원으로 계산한다.
     - 한 달간의 배송 실적에 따라 매달 30일에 배송 용역비를 정산한다. 정산방법에 따라 일괄정산하거나 분납할 수 있다. 최고 3회까지 분납이 가능하다.
     
1. 명사도출
    회원, 도서, 체크도서, 공급도서, 계약업체, 출판사, 배송, 배송업체, 정산

2. 엔티티타입 정의서
    엔티티타입명          엔티티타입 설명                    동의어 유의어     엔티티타입 구분        관련속성
        회원          도서구매와 구매실적에 따라 부여되는                                        회원번호, 주민등록번호, 주소, 전화번호,
                        구매 포인트를 위해 사용된다.                                          전자메일ID, 휴대폰번호, 결재방법
        도서          판매 및 재고현황을 위해 사용된다.
        체크도서        구매하기 위해 체크한 도서
        공급도서                                            계약도서
        계약업체        계약, 상태, 갱신, 수정을 위해 사용된다.                                        계약번호, 사업자번호, 출판사명, 계약일자, 최저가 비율
        출판사         계약서, 출판사별 최저가 비율 지정,                                        출판사 전화번호, 출판사 주소, 거래은행 코드, 계좌번호
                        재고현황을 위해 사용된다.                                              
        배송           직접 배송, 간접 배송을 위해 사용된다.                                       배송일시, 배송지 주소, 배송지 전화번호, 배송방법
        배송업체        직접배송을 위해 미리 등록하는 업체                                           사업자번호, 사업자명, 배송업체 전화번호, 배송업체 주소
        정산           한달간의 실적 정산을 위해 사용된다.                                           기본 용역비, 추가 용역비, 정산방법

3. 관계 정의서
    출판사   하나의 출판사는 한번 이상 계약업체로 등록한다.         필수     계약업체      -- 출판사가 계약서를 쓴다.
            하나의 계약업체는 하나의 출판사와 계약한다.           선택 
            
    계약업체  하나의 계약업체는 하나 이상의 도서를 계약한다.        필수      계약도서     
            하나의 계약도서는 하나의 계약업체에 등록된다.         필수              
            
    도서    하나의 도서는 한번 이상 공급 도서가 등록된다.           필수      계약도서
           하나의 계약도서는 하나의 도서를 등록한다.               선택
           
    도서    하나의 도서는 한번 이상 등록한다.                     필수      체크도서
            하나의 체크도서에는 한번 이상 등록된다.               선택
           
    회원    하나의 회원은 한번이상 체크도서를 등록한다.             필수      체크도서       
           하나의 체크도서에는 하나의 회원에 의해 등록된다.         선택
           
    회원    하나의 회원은 하나 이상의 도서를 구매한다.              선택       도서
            하나의 도서는 한명 이상으로부터 구매된다.              선택
            
    회원    하나의 회원은 한번이상 배송한다.                      필수       배송
            하나의 배송은 한명의 회원에 의해 배송된다.             선택
            
    배송업체   하나의 배송업체는 한번 이상 배송한다.               필수       배송
             하나의 배송은 한 배송업체에 의해 배송된다.           선택
             
    배송     하나의 배송은 한번 정산한다.                       필수        정산         
            하나의 정산은 하나의 배송에 의해 정산된다.            선택
            
4. 개념설계 ERD

5. 식별자 정의서
    엔티티             주식별자                  보조식별자               외래식별자
    출판사             사업자번호              출판사 전화번호
    계약서             계약번호                                         사업자번호
    계약도서         계약번호, 도서번호                                 계약번호, 도서번호
    도서               도서번호
    회원             회원번호, 주문번호                                   이메일
    배송               배송번호                                   회원번호, 주문번호, 배송업체번호
    배송업체          배송업체번호                                                    

6. 속성 정의서
-- 전이 속성은 명시하지 않는다. FK는 적지 않는다. => 충돌된다.

    엔티티타입명          속성                        내용
        출판사           사업자번호                각 출판사의 고유번호
                        출판사명                 각 출판사 이름
                        출판사주소                각 출판사가 위치한 장소의 주소
                        출판사 전화번호            각 출판사별 연락 가능한 전화번호
                        거래은행코드              거래에 사용되는 은행코드
                        계좌번호                 정산에 필요한 계좌번호
                        
        계약업체         계약번호                   계약서의 고유번호 
                        계약일자                  계약 시작과 마감 날짜
                        최저가 비율                최저가 비율
                        계약상태코드               계약 상태 확인을 위한 코드
                        
        계약도서    
        도서             도서번호                   각 도서별 고유번호
                        도서명                     각 도서의 이름
                        수량                      도서별 필요한 수량
                        공급단가                   도서별 공급에 사용할 단가
                        저자                      각 도서의 저자
                        
        회원             회원번호                  각 회원 고유번호
                        회원주소                  각 회원이 위치한 장소의 주소
                        이메일                    각 회원의 이메일 주소
                        
        배송             배송번호                  배송에 필요한 고유번호
                        배송일자                  배송 시작과 배송완료 날짜
                        배송결과코드               배송 결과 확인을 위한 코드
                        
        배송업체         배송업체 사업자번호          각 배송업체의 사업자 번호
                        배송업체명                 각 배송업체의 이름
                        전화번호                   연락 가능한 전화번호

7. 도메인 정의서 (도메인 타입에 이름을 붙여준다)
    도메인 구분              도메인 이름          도메인 타입              비고
        번호                 번호               NUMBER(20)
                            전화번호            VARCHAR(30)
                            
        이름                 특정이름             VARCHAR(50)
                                                
        주소                  주소               VARCHAR(255)
                            이메일               VARCHAR(40)
    
        날짜                 날짜                   DATE     
                            
        숫자                  수량               INTEGER                        
        
        코드                  코드               VARCHAR(15)
        
-- 논리설계 -------------------------------------------------------------------------
1. 맵핑룰
        엔티티명  =>    테이블명
        속성     =>    컬럼
        식별자   =>    부식별자
        관계     =>    외래키
2. 정규화
3. 논리설계 ERD


-- 물리설계 -------------------------------------------------------------------------
1. 테이블 정의서

    엔티티타입명                                 계약업체
    테이블명                                  CONTRACTOR
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       contract_number       계약번호          일련번호    NUMBER      20       NOT NULL      PK
        2       contract_date         계약일자           일시      DATE
        3       min_price_pct         최저가 비율        비율      NUMBER       2,2
        4       constract_state       계약상태 코드       상태      CHAR         1
        5       business_number       사업자번호        일련번호    NUMBER       20                    FK
    
    엔티티타입명                                 계약도서
    테이블명                                   CON_BOOK
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       contract_number       계약번호          일련번호    NUMBER      20       NOT NULL      FK
        2       book_number           도서번호          일련번호    NUMBER      20       NOT NULL      FK
       
    엔티티타입명                                 주문
    테이블명                                   ORDER
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       order_num             주문번호          일련번호    NUMBER      20       NOT NULL      PK
        2       member_num            회원번호          일련번호    NUMBER      20       NOT NULL      PK
        3       shipping_addr         배송지            주소       VARCHAR     255
        4       total_price           총금액            금액       INTEGER
    
    엔티티타입명                                 회원
    테이블명                                   MEMBER
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       member_num            회원번호          일련번호    NUMBER      20       NOT NULL      PK
        2       email                 이메일            이메일     VARCHAR2    40
        3       member_addr           회원주소          주소       VARCHAR2    255
        
    엔티티타입명                                 도서
    테이블명                                    BOOK
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       book_number           도서번호          일련번호    NUMBER      20       NOT NULL      PK
        2       book_name             도서명            이름       VARCHAR     50
        3       book_qty              수량             숫자        INTEGER
        4       book_price            공급단가          금액        INTEGER
        5       author                저자             이름        VARCHAR     50
        
    엔티티타입명                                 주문리스트
    테이블명                                    ORDER_LIST
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       book_number           도서번호          일련번호    NUMBER      20       NOT NULL      FK
        2       order_num             주문번호          일련번호    NUMBER      20       NOT NULL      FK
        3       member_num            회원번호          일련번호    NUMBER      20       NOT NULL      FK
        4       order_qty             주문수량          수량       NUMBER
        5       order_price           주문금액          금액       INTEGER     
    
    엔티티타입명                                 배송
    테이블명                                    SHIPPING
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       shipping_number       배송번호          일련번호    NUMBER      20       NOT NULL      PK
        2       shipping_business_num 배송업체사업자번호  일련번호    NUMBER      20       NOT NULL      FK
        3       member_num            회원번호          일련번호    NUMBER      20       NOT NULL      FK
        4       shipping_date         배송일자          일시       DATE
        5       result_code           배송결과코드       식별코드    VARCHAR2    15   
        6       book_number           도서번호          일련번호    NUMBER      20       
    
    엔티티타입명                                 출판사
    테이블명                                    PUBLISHER
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       business_number       사업자번호        일련번호    NUMBER      20       NOT NULL      PK
        2       publisher_name        출판사명          이름       VARCHAR     50      
        3       publisher_addr        출판사 주소        주소       VARCHAR    255
        4       publisher_phone       출판사 전화번호     전화번호   VARCHAR     30
        5       bank_code             거래은행 코드       식별코드   VARCHAR2    15   
        6       account_num           계좌번호          일련번호    NUMBER      20
    
    엔티티타입명                                 정산
    테이블명                                    CALCULATE
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       settlement_num        정산번호         일련번호     NUMBER      20       NOT NULL      PK
        2       shipping_number       배송번호         일련번호     NUMBER      20       NOT NULL      FK
        3       settlement_day        정산날짜          일시       DATE                 NOT NULL  
        4       amount                정산금액          금액       INTEGER
    
    엔티티타입명                                 배송업체
    테이블명                                    SHIPPING_COMPANY
        번호     컬럼명                 속성명           도메인     데이터타입     길이      NULL여부      KEY
        1       shipping_business_num 배송업체사업자번호 일련번호     NUMBER      20       NOT NULL      PK
        2       shipping_com_name     배송업체명        이름        VARCHAR     50
        3       shipping_com_phone    배송업체연락처     전화번호     VARCHAR     30

---------------------------------------------------------------------------
create.sql
create table shipping_company(
    shipping_business_num       number(20)
    shipping_com_name           varchar2(50)
    shipping_com_phone          varchar2(30)    
);    

create table shipping(    
    shipping_number             number(20)
    shipping_date               date
    result_code                 varchar2(15)
);

create table calculate(
    settlement_num          number(20)
    shipping_number         number(20)
    settlement_day          date
    amount                  integer
);

create table member(
    member_num          number(20)
    book_number         number(20)
    member_addr         number(20)
    email               varchar2(40)
);

create table order_list(
    order_qty           number
    order_price         integer
);

create table order(
    order_num           number(20)
    member_num          number(20)
    shipping_addr       varchar2(255)
    total_price         integer
);

create table book(
    book_number         number(20)
    book_name           varchar2(50)
    book_qty            integer
    book_price          integer
    quthor              varchar2(50)
);

create table 계약도서(
    
);

create table contractor (
    contract_number     number(20)
    contract_date       date
    min_price_pct       number(2,2)
    constract_state     char(1)
    business_number     number(20)
);

create table publisher(
    business_number     number(20)
    publisher_name      varchar2(50)
    publisher_addr      varchar2(255)
    publisher_phone     varchar2(30)
    bank_code           varchar2(15)
    account_num         number(20)
);

---------------------------------------------------------------------------

PrimaryKey.sql
alter table CONTRACTOR
add constraint con_cnum_pk primary key (contract_number);

alter table ORDER
add constraint order_member_num_pk primary key(order_num, member_num);

alter table BOOK
add constraint book_num_pk primary key(book_number);

alter table SHIPPING
add constraint ship_num_pk primary key(shipping_number);

alter table PUBLISHER
add constraint busi_num_pk primary key(business_number);
 
alter table CALCULATE
add constraint cal_set_num_pk primary key(settlement_num);   
   
alter table SHIPPING_COMPANY
add constraint shi_busi_num_pk primary key(shipping_business_num);    
       
---------------------------------------------------------------------------        
ForeignKey.sql
alter table CONTRACTOR
add constraint busi_num_fk foreign key(business_number)
    references PUBLISHER(business_number); 

alter table CON_BOOK
add (
    constraint con_num_fk foreign key(contract_number)
		references CONTRACTOR(contract_number),
	constraint book_num_fk foreign key(book_number)
		references BOOK(book_number)
    ); 

alter table ORDER_LIST
add (
    constraint order_num_fk foreign key(order_num)
		references ORDER(order_num),
	constraint book_num_fk foreign key(book_number)
		references BOOK(book_number),
	constraint mem_num_fk foreign key(member_num)
		references MEMBER(member_num)
    ); 

alter table SHIPPING
add (
    constraint sh_bu_num_fk foreign key(shipping_business_num)
		references SHIPPING_COMPANY(shipping_business_num),
	constraint mem_num_fk foreign key(member_num)
		references MEMBER(member_num)
    ); 

alter table CALCULATE
add constraint shi_num_fk foreign key(shipping_number)
    references SHIPPING(shipping_number);  
            
*/
