alter table user_base
    modify birthday timestamp null comment '生日';
alter table user_base
    add login_time timestamp null;

