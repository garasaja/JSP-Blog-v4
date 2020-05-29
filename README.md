#### JSP 모델2 블로그 프로젝트

## 오라클 사용자 생성
```sql
alter session set "_ORACLE_SCRIPT" = true; 

CREATE USER cos IDENTIFiED BY bitc5600;

GRANT CREATE SESSION TO cos;
GRANT CREATE TABLESPACE TO cos;
GRANT CREATE TABLE TO cos;
GRANT SELECT,INSERT,DELETE,UPDATE ON cos.테이블명 TO cos;
ALTER USER cos DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
```

## 테이블
```sql
CREATE TABLE users(
	id number primary key,
    username varchar2(100) not null unique,
    password varchar2(100) not null,
    email varchar2(100) not null,
    address varchar2(100) not null,
    userProfile varchar2(200) ,
    userRole varchar2(20),
    createDate timestamp
) ;

CREATE TABLE board(
	id number primary key,
    userId number,
    title varchar2(100) not null,
    content clob,
    readCount number default 0, --조회수
    createDate timestamp,
    foreign key (userId) references users (id)
);

CREATE TABLE reply(
	id number primary key,
    userId number,
    boardId number,
    content varchar2(300) not null,
    createDate timestamp,
    foreign key (userId) references users (id) on delete set null, --홍길동이란 아이디를 지웠을때 홍길동의 댓글도 지울꺼냐 물어보는 키워드
    foreign key (boardId) references board (id) on delete cascade  --게시판에 댓글이 달렷는데 게시판을 지우면 댓글도 연쇄적으로 지울꺼냐 물어보는 키워드
);
```

## 스퀀스 생성
``` sql
CREATE SEQUENCE USERS_SEQ
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE REPLY_SEQ
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE BOARD_SEQ
START WITH 1 INCREMENT BY 1;
```