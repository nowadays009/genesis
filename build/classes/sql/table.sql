
--[board]--

CREATE TABLE GenesisBoard(
	b_id number,							--게시판 PRIMARY KEY	
	writer varchar2(20),					--작성자
	title varchar2(50),						--제목
	content varchar2(4000),					--내용
	pwd varchar2(10),						--비밀번호
	count number,							--조회수
	ip varchar2(50),						--아이피
	reg_date varchar2(20),					--등록일
	mod_date varchar2(20),					--수정일
	re_group number,						--답변형 게시판을 위한 group
	re_step number,							--답변형 게시판을 위한 step
	re_level number,						--답변형 게시판을 위한 level(들여쓰기를 위함)
	CONSTRAINT pk_b_id PRIMARY KEY(b_id)
);

--게시판 seq_bid 시퀀스 생성 --

CREATE SEQUENCE seq_b_id		--시퀀스 이름
START WITH 1					--시퀀스 초기값
INCREMENT BY 1					--시퀀스 증가값





--[member]--

create table Member(
	id varchar2(20) not null primary key,
	pw1 varchar2(20) not null,
	pw2 varchar2(20) not null,
	name varchar2(50) not null,
	address varchar2(200) not null,
	email varchar2(50) not null,
	rank varchar2(20) not null
);


--기타--
drop table GenesisBoard;
purge recyclebin;

delete from genesisboard

drop sequence seq_bid;
