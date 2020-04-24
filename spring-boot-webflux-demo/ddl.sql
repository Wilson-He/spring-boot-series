-- 点赞记录表
-- auto-generated definition
create table praise_record
(
    id          bigint auto_increment
        primary key,
    uid         bigint                              not null comment '用户id',
    live_id     bigint                              not null,
    create_time timestamp default CURRENT_TIMESTAMP not null
)
    comment '点赞记录表';