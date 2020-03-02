-- Users
create table users
(
  id             integer not null ,
  user_name      varchar(50),
  first_name     varchar(255),
  last_name      varchar(255),
  status         varchar(20),
  created_by     integer,
  created_at     date,
  updated_at     date
);

alter table users add CONSTRAINT pk_Users PRIMARY KEY (id);

CREATE SEQUENCE USERS_SEQ
  MINVALUE 1000
  MAXVALUE 999999999999
  START WITH 1050
  INCREMENT BY 50;
