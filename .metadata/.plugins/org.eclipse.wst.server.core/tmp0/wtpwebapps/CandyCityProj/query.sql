--회원
CREATE SEQUENCE join_member_seq;
CREATE TABLE member(
    id VARCHAR2(20),
    name VARCHAR2(20),
    gender CHAR(1),
    pwd VARCHAR2(20) NOT NULL,
    join_num NUMBER(30) NOT NULL,
    candy NUMBER(10),
    post_num NUMBER(10),
    comment_num NUMBER(15),
    manager CHAR(1),
    CONSTRAINT member_id_PK PRIMARY KEY(id),
    CONSTRAINT member_manager_CK CHECK(manager IN('O', 'X')),
    CONSTRAINT member_gender_CK CHECK(gender IN('F', 'M', 'E'))
);
DROP TABLE member;
DROP SEQUENCE join_member_seq;

insert into member(id, name, gender, pwd, join_num, candy, post_num, comment_num, manager) values('chanbi','임찬비','F', 'cksql0713', join_member_seq.nextval, 10, 0, 0, 'O');

select * from member;

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

-- 보유 의상
CREATE TABLE holding_costume (
    id VARCHAR2(20),
    costume_code VARCHAR2(20),
    CONSTRAINT holding_costume_id_FK FOREIGN KEY(id) REFERENCES member(id),
    CONSTRAINT holding_costume_code_FK FOREIGN KEY(costume_code) REFERENCES costume(costume_code)
);

--게시글
CREATE TABLE post(
    post_code VARCHAR2(20),
    id VARCHAR2(20), --쓴사람
    write_date DATE NOT NULL,
    title VARCHAR2(30) NOT NULL,
    contents VARCHAR2(500) NOT NULL,
    CONSTRAINT post_code_PK PRIMARY KEY(post_code),
    CONSTRAINT post_id_FK FOREIGN KEY(id) REFERENCES member(id)
);

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

--오늘 방문자
CREATE SEQUENCE vist_today_seq;
CREATE TABLE vist_today (
    vist_num NUMBER(8),
    id VARCHAR2(20),
    today DATE NOT NULL,
    CONSTRAINT vist_today_vist_num_PK PRIMARY KEY(vist_num),
    CONSTRAINT vist_today_id_FK FOREIGN KEY(id) REFERENCES member(id)
);

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

--우편함(보면 지워지게)
CREATE TABLE mail(
    mail_code VARCHAR2(20),
    id VARCHAR2(20),
    contents VARCHAR2(500) NOT NULL,
    CONSTRAINT mail_code_PK PRIMARY KEY(mail_code),
    CONSTRAINT mail_id_FK FOREIGN KEY(id) REFERENCES member(id)
);


--신고

--문의

-- 랭킹(뷰)

SELECT ROWNUM, m.name, m.post_num
    FROM (SELECT m.name, m.post_num
                FROM member m
                ORDER BY m.post_num DESC) m
    WHERE ROWNUM >= 3;

    
    
    
    