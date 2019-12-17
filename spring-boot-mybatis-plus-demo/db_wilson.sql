create schema wilson collate utf8_general_ci;

create table teacher
(
    id        varchar(64) null,
    name      varchar(60) null,
    is_delete char        null
);

create table user_base
(
    id          int auto_increment
        primary key,
    username    varchar(45)       null,
    password    varchar(45)       null,
    create_time timestamp         null,
    update_time timestamp         null,
    is_delete   tinyint default 1 not null comment '删除(YES:1-已删除,NO:0-未删除)',
    status      varchar(10)       null comment '状态(ENABLE-启用,DISABLE-禁用)'
);

create table user_detail
(
    id          int                                 not null
        primary key,
    sex         char                                null,
    age         tinyint                             null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    is_delete   char      default '0'               not null,
    user_id     int                                 null
);


