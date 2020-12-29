-- 제약조건때문에 board 먼저 삭제
drop table board;
drop table member;

-- member
create table member (
    member_no serial,
    account text not null,
    password text not null,
    status smallint not null,
    last_login_at timestamp,
    password_updated_at timestamp,
    login_fail_count smallint default 0,
    created_at timestamp DEFAULT timezone('UTC'::text, now()),
    updated_at timestamp
);

ALTER TABLE member ADD CONSTRAINT member_pkey PRIMARY KEY (member_no);
COMMENT ON COLUMN member.status IS '멤버 상태';

-- board
create table board (
   board_no serial,
   subject text not null,
   content text not null,
   status smallint not null,
   view_cnt int not null default 0,
   created_at timestamp DEFAULT timezone('UTC'::text, now()),
   updated_at timestamp,
   member_no int
);

ALTER TABLE board ADD CONSTRAINT board_pkey PRIMARY KEY (board_no);
ALTER TABLE board ADD CONSTRAINT board_member_no_fkey FOREIGN KEY (member_no) REFERENCES member (member_no) ON UPDATE NO ACTION ON DELETE NO ACTION;
COMMENT ON COLUMN board.status IS '게시글 상태';