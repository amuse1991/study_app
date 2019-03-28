
-- users insert
insert into users (user_id,password,nickname,phone,point,authority)
  values ('estrella917@naver.com','111','tester','010-6258-1441',10,'user');

-- member_auth insert
insert into member_auth(name,description)
  values ('manager','스터디 매니저');
insert into member_auth(name,description)
  values ('member','스터디 회원');
insert into member_auth(name,description)
  values ('waiting','대기자');
