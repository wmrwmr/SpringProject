create sequence seq_board;

create table tbl_board (
    bno number(10,0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    updatedate date default sysdate
);


alter table tbl_board add constraint pk_board
primary key (bno);


insert into tbl_board (bno, title, content, writer) values (seq_board.nextval, '테스트 제목', '테스트 내용', 'user00');

commit;

select * from tbl_board;

select /*+ INDEX_DESC(tbl_board pk_board) */ * from tbl_board where bno > 0;

select * from tbl_board order by bno desc;

select /*+ INDEX_DESC (tbl_board pk_board) */ * from tbl_board;

select /*+ FULL(tbl_board) */ * from tbl_board order by bno desc;

select /*+ INDEX_ASC(tbl_board pk_board) */ * from tbl_board where bno > 0;

select rownum r, bno, title from tbl_board;

select /*+ FULL(tbl_board) */ rownum rn, bno, title from tbl_board where bno > 0 order by bno;

select /*+ INDEX_DESC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board where rownum <= 10;

-- ROWNUM은 반드시 1이 포함되도록 해야 한다.
select /*+INDEX_DESC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board where rownum <=20;

