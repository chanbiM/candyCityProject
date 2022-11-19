--회원
CREATE SEQUENCE join_member_seq;
CREATE TABLE member(
    id VARCHAR2(20),
    name VARCHAR2(20),
    introduce VARCHAR2(80),
    gender CHAR(1),
    pwd VARCHAR2(20) NOT NULL,
    join_num NUMBER(30) NOT NULL,
    candy NUMBER(10),
    post_num NUMBER(10),
    comment_num NUMBER(15),
    manager CHAR(1),
    join_date DATE NOT NULL,
    login_date DATE,
    CONSTRAINT member_id_PK PRIMARY KEY(id),
    CONSTRAINT member_manager_CK CHECK(manager IN('O', 'X')),
    CONSTRAINT member_gender_CK CHECK(gender IN('F', 'M', 'E'))
);


insert into member values('chanbi','임찬비',NULL, 'F', 'cksql0713', join_member_seq.nextval, 10, 0, 0, 'O', '2022/11/18', NULL);

--게시글
CREATE SEQUENCE post_seq;
CREATE TABLE post(
    post_code VARCHAR2(20), --
    id VARCHAR2(20), --쓴사람
    write_date DATE NOT NULL,
    title VARCHAR2(500) NOT NULL,
    contents VARCHAR2(1000) NOT NULL,
    comment_o CHAR(1),
    update_date DATE,
    post_type CHAR(1),
    CONSTRAINT post_code_PK PRIMARY KEY(post_code),
    CONSTRAINT post_id_FK FOREIGN KEY(id) REFERENCES member(id),
    CONSTRAINT post_comment_o_CK CHECK(comment_o IN('O', NULL)),
    CONSTRAINT post_type_CK CHECK(post_type IN('S', 'B'))
);
alter table post modify(title VARCHAR2(500));
alter table post modify(contents VARCHAR2(1000));

--관리자 공지사항 (이벤트, 공지사항)
CREATE SEQUENCE notice_seq;
CREATE TABLE manager_notice (
    notice_code VARCHAR2(20),
    id VARCHAR2(20),
    type CHAR(1), --이벤트 E, 공지사항 N, 당첨자 R
    title VARCHAR2(500) NOT NULL,
    contents VARCHAR2(1000) NOT NULL,
    end_o CHAR(1),
    write_date DATE NOT NULL,
    CONSTRAINT manager_notice_code_PK PRIMARY KEY(notice_code),
    CONSTRAINT manager_notice_id_FK FOREIGN KEY(id) REFERENCES member(id),
    CONSTRAINT manager_notice_type_CK CHECK(type IN('E', 'N', 'R'))
);

--의상
CREATE TABLE costume(
    costume_code VARCHAR2(20), -- cos-head-0000
    costume_name VARCHAR2(200) NOT NULL,
    price NUMBER(10) NOT NULL,
    parts VARCHAR2(10) NOT NULL,
    name VARCHAR2(200) NOT NULL,
    CONSTRAINT costume_code_PK PRIMARY KEY(costume_code)
);
CREATE SEQUENCE costume_seq;

--눈
insert into costume values('cos-'||costume_seq.nextval, '아잉눈', '2', 'eyes', 'aingnun.png');
insert into costume values('cos-'||costume_seq.nextval, '화난눈', '2', 'eyes', 'angryEyes.png');
insert into costume values('cos-'||costume_seq.nextval, '울먹눈', '2', 'eyes', 'cryeyes.png');

--머리
insert into costume values('cos-'||costume_seq.nextval, '나는야 분홍머리', '4', 'head', 'pinkHair.png');
insert into costume values('cos-'||costume_seq.nextval, '엘레강스 모자', '4', 'head', 'EleganceHat.png');
insert into costume values('cos-'||costume_seq.nextval, '신사 모자', '4', 'head', 'gentlemanHat.png');

--몸
insert into costume values('cos-'||costume_seq.nextval, '엘레강스 옷', '5', 'body', 'bluebody.png');
insert into costume values('cos-'||costume_seq.nextval, '모에 분홍 옷', '5', 'body', 'pinkClothes.png');
insert into costume values('cos-'||costume_seq.nextval, '멋쟁이 양복', '5', 'body', 'suit.png');

--신발
insert into costume values('cos-'||costume_seq.nextval, '무쇠 반짝 구두', '1', 'shoes', 'sparklyShoes.png');
insert into costume values('cos-'||costume_seq.nextval, '오! 참 나이스한 신발', '2', 'shoes', 'niceShoes.png');

select * from costume;

--캐릭터
CREATE TABLE character(
    id VARCHAR2(20),
    head VARCHAR2(20),
    eyes VARCHAR2(20),
    body VARCHAR2(20),
    shoes VARCHAR2(20),
    CONSTRAINT character_id_PK PRIMARY KEY(id),
    CONSTRAINT character_id_FK FOREIGN KEY(id) REFERENCES member(id),
    CONSTRAINT character_head_FK FOREIGN KEY(head) REFERENCES costume(costume_code),
    CONSTRAINT character_eyes_FK FOREIGN KEY(eyes) REFERENCES costume(costume_code),
    CONSTRAINT character_body_FK FOREIGN KEY(body) REFERENCES costume(costume_code),
    CONSTRAINT character_shoes_FK FOREIGN KEY(shoes) REFERENCES costume(costume_code)
);
insert into character values('chanbi',NULL,NULL,NULL,NULL);
select * from character;

update character set eyes='cos-1',head='cos-5',body='cos-7', shoes='cos-11' where id='chanbi';



-- 보유 의상
CREATE TABLE holding_costume (
    id VARCHAR2(20),
    costume_code VARCHAR2(20),
    CONSTRAINT holding_costume_id_FK FOREIGN KEY(id) REFERENCES member(id),
    CONSTRAINT holding_costume_code_FK FOREIGN KEY(costume_code) REFERENCES costume(costume_code)
);
DROP TABLE holding_costume CASCADE CONSTRAINTS;

select * from costume;
insert into holding_costume values('chanbi', 'cos-1');
insert into holding_costume values('chanbi', 'cos-5');
insert into holding_costume values('chanbi', 'cos-11');
insert into holding_costume values('chanbi', 'cos-7');

--댓글
CREATE TABLE post_comment(
    comment_code VARCHAR2(20),
    post_code VARCHAR2(20),
    id VARCHAR2(20), --쓴사람
    write_date DATE NOT NULL,
    contents VARCHAR2(500) NOT NULL,
    CONSTRAINT comment_code_PK PRIMARY KEY(comment_code),
    CONSTRAINT comment_post_FK FOREIGN KEY(post_code) REFERENCES post(post_code),
    CONSTRAINT comment_id_FK FOREIGN KEY(id) REFERENCES member(id)
);
DROP TABLE post_comment CASCADE CONSTRAINTS;


select * from manager_notice;
update member set end_o='O' where notice_code='chanbi';


select * from holding_costume where id='chanbi';
select * from costume;

--의상 확인하기
select c.* from costume c, (select * from holding_costume where id='chanbi') h where c.costume_code = h.costume_code;

--의상 상점
select c.*
from costume c
left join (select costume_code from holding_costume where id='chanbi') h  
on h.costume_code=c.costume_code
where h.costume_code is NULL
order by costume_name;
