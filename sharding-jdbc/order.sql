create database order_0;
create database order_1;
use order_0;
# use order_1;

drop table if exists order_info;
create table order_info
(
    id          bigint                              not null
        primary key,
    user_id     bigint                              not null comment '用户id',
    username    varchar(50)                         not null comment '用户名',
    note        varchar(300)                        not null default '' comment '备注',
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    comment '订单表';

drop table if exists order_info_0;
create table order_info_0
(
    id          bigint                              not null
        primary key,
    user_id     bigint                              not null comment '用户id',
    username    varchar(50)                         not null comment '用户名',
    note        varchar(300)                        not null default '' comment '备注',
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    comment '订单表';

drop table if exists order_info_1;
create table order_info_1
(
    id          bigint                              not null
        primary key,
    user_id     bigint                              not null comment '用户id',
    username    varchar(50)                         not null comment '用户名',
    note        varchar(300)                        not null default '' comment '备注',
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    comment '订单表';
