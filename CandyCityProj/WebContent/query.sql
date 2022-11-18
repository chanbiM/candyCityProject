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
DROP TABLE member;
DROP SEQUENCE join_member_seq;

insert into member values('chanbi','임찬비',NULL, 'F', 'cksql0713', join_member_seq.nextval, 10, 0, 0, 'O', '2022/11/18', NULL);
delete member;

select * from member;
update member set post_num=0 where id='chanbi';

--의상
CREATE TABLE costume(
    costume_code VARCHAR2(20), -- cos-head-0000
    costume_name VARCHAR2(50) NOT NULL,
    price NUMBER(10) NOT NULL,
    parts VARCHAR2(10),
    CONSTRAINT costume_code_PK PRIMARY KEY(costume_code),
    CONSTRAINT costume_parts_CK CHECK(parts IN('head', 'body', 'shoes'))
);
DROP TABLE costume;
DROP TABLE costume CASCADE CONSTRAINTS;
--캐릭터
CREATE TABLE character(
    id VARCHAR2(20),
    head VARCHAR2(20),
    body VARCHAR2(20),
    shoes VARCHAR2(20),
    CONSTRAINT character_id_PK PRIMARY KEY(id),
    CONSTRAINT character_id_FK FOREIGN KEY(id) REFERENCES member(id),
    CONSTRAINT character_head_FK FOREIGN KEY(head) REFERENCES costume(costume_code),
    CONSTRAINT character_body_FK FOREIGN KEY(body) REFERENCES costume(costume_code),
    CONSTRAINT character_shoes_FK FOREIGN KEY(shoes) REFERENCES costume(costume_code)
);
DROP TABLE character CASCADE CONSTRAINTS;
-- 보유 의상
CREATE TABLE holding_costume (
    id VARCHAR2(20),
    costume_code VARCHAR2(20),
    CONSTRAINT holding_costume_id_FK FOREIGN KEY(id) REFERENCES member(id),
    CONSTRAINT holding_costume_code_FK FOREIGN KEY(costume_code) REFERENCES costume(costume_code)
);
DROP TABLE holding_costume CASCADE CONSTRAINTS;

--게시글
CREATE SEQUENCE post_seq;
CREATE TABLE post(
    post_code VARCHAR2(20), --
    id VARCHAR2(20), --쓴사람
    write_date DATE NOT NULL,
    title VARCHAR2(30) NOT NULL,
    contents VARCHAR2(500) NOT NULL,
    comment_o CHAR(1),
    update_date DATE,
    post_type CHAR(1),
    CONSTRAINT post_code_PK PRIMARY KEY(post_code),
    CONSTRAINT post_id_FK FOREIGN KEY(id) REFERENCES member(id),
    CONSTRAINT post_comment_o_CK CHECK(comment_o IN('O', NULL)),
    CONSTRAINT post_type_CK CHECK(post_type IN('S', 'B'))
);

delete post;
select * from post;

--타인이 볼떄
select * from post where id='chanbi' AND (title like '%더럽%' OR contents like '%더럽%') AND post_type='B' order by 1 desc;

select * from post where id='chanbi' AND (title like '%더럽%' OR contents like '%더럽%') order by 1 desc;

insert into post values('post-'||post_seq.nextval,'chanbi',SYSDATE,'더럽게 안되네','퉤!','O','','B');

select * from post;

DROP TABLE post CASCADE CONSTRAINTS;
DROP TABLE post;
DROP SEQUENCE post_seq;

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

--오늘 방문자
CREATE SEQUENCE vist_today_seq;
CREATE TABLE vist_today (
    vist_num NUMBER(8),
    id VARCHAR2(20),
    today DATE NOT NULL,
    CONSTRAINT vist_today_vist_num_PK PRIMARY KEY(vist_num),
    CONSTRAINT vist_today_id_FK FOREIGN KEY(id) REFERENCES member(id)
);
DROP TABLE vist_today CASCADE CONSTRAINTS;

--관리자 공지사항 (이벤트, 공지사항)
CREATE TABLE manager_notice (
    notice_code VARCHAR2(20),
    id VARCHAR2(20),
    type CHAR(1), --이벤트 E, 공지사항 N
    title VARCHAR2(30) NOT NULL,
    contents VARCHAR2(500) NOT NULL,
    CONSTRAINT manager_notice_code_PK PRIMARY KEY(notice_code),
    CONSTRAINT manager_notice_id_FK FOREIGN KEY(id) REFERENCES member(id),
    CONSTRAINT manager_notice_type_CK CHECK(type IN('E', 'N'))
);

DROP TABLE manager_notice CASCADE CONSTRAINTS;

--우편함(보면 지워지게)
CREATE TABLE mail(
    mail_code VARCHAR2(20),
    id VARCHAR2(20),
    contents VARCHAR2(500) NOT NULL,
    CONSTRAINT mail_code_PK PRIMARY KEY(mail_code),
    CONSTRAINT mail_id_FK FOREIGN KEY(id) REFERENCES member(id)
);

DROP TABLE mail CASCADE CONSTRAINTS;
--신고

--문의

-- 랭킹(뷰)  
select ROWNUM, a.*
from (SELECT id, name, post_num, RANK()OVER (order by post_num desc) rk
		FROM member
		ORDER BY rk asc) a
where ROWNUM <= 4;


SELECT id, name, post_num, RANK()OVER (order by post_num desc)
		FROM member
		ORDER BY RANK()OVER (order by post_num desc) desc;
		
update member set post_num=post_num+1 where id='chanbi';

SELECT id, name, post_num, RANK () OVER(order by post_num desc) alias(rk) FROM member where rk >= 4 ORDER BY rk;


--대표 게시글
select table.* from table where condition order by table.col1
    
select ROWNUM, a.*
from (SELECT post_code, id, write_date, title, contents, comment_o, update_date, post_type
		FROM post
		where id='chanbi'
		ORDER BY post_code desc) a
where ROWNUM <= 1;

select * from post where id='chanbi' ORDER BY post_code desc;
