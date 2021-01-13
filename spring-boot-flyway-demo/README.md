

# Flyway简介

# Flyway中的迁移(migrations)模式
 Flyway对数据库的所有更改都称为 `migrations(迁移)` 。 `migrations(迁移)` 分为版本控制(Versioned)迁移与可重复(Repeatable)的迁移两种，
 而版本控制又分为`regular(常规)`和`undo(撤销)`两种形式。  
 - 版本控制迁移：具有版本号、描述和校验和，且版本是唯一的。描述用于简单记录迁移的内容，校验和用于检测意外更改。  
   版本控制迁移通常用于以下用途：
   - 创建|更新|删除：表、索引、外键、枚举、UDT…  
   - 数据更新  
   常规版本控制例子：
   ```
   CREATE TABLE car (
       id INT NOT NULL PRIMARY KEY,
       license_plate VARCHAR NOT NULL,
       color VARCHAR NOT NULL
   );
   ALTER TABLE owner ADD driver_license_id VARCHAR;
   INSERT INTO brand (name) VALUES ('DeLorean');
   ```
   撤消(undo)迁移与常规版本迁移相反，但形式上看也是版本迁移的一种，具有相同版本的版本迁移影响。针对上例中的撤销迁移例子如下：  
   ```
   DELETE FROM brand WHERE name='DeLorean';
   ALTER TABLE owner DROP driver_license_id;
   DROP TABLE car;
   ```
 - 可重复迁移：只有描述、校验和(`checksum`)，没有版本号。可重复迁移不止执行一次，每次`校验和(checksum)`发生变更时就会被执行。 
   可重复迁移主要有以下两种用途：
   -（重新）创建视图/存储过程/函数/包/…
   - 批量插入参照数据

在一次迁移运行中，在所有版本迁移执行之后，可重复迁移在最后执行。可重复迁移按照它们描述的顺序执行。  

Flyway迁移的命名模式如下：  
![flyway-mole](https://img-blog.csdnimg.cn/20210113143311791.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3oyODEyNjMwOA==,size_16,color_FFFFFF,t_70)

- 前缀：`V`指版本控制， `U`用于撤消和 `R`用于可重复迁移（可配置）  
- 版本：带点或下划线的版本可根据需要分隔任意多个部分（不适用于可重复的迁移）  
- 分隔符：两个下划线`__`（可配置）  
- 描述：下划线或空格分隔单词  

Flaway的版本命名十分灵活，以下版本都是有效的迭代版本：
- 1
- 001
- 5.2
- 1.2.3.4.5.6.7.8.9
- 205.68
- 20130115113556
- 2013.1.15.11.35.56
- 2013.01.15.11.35.56

## Flyway历史记录表`flyway_history_schema`
Flyway通过创建表`flyway_history_schema`来记录迁移，表中的主要字段如下：  

|   字段名   |   描述   |
|   ------     |   ------    |
|   installed_rank   | 执行排名，值越低优先级越高，即版本越低越先执行  |
|   version          | 执行的版本 |
|   description      | 版本描述   |
|   type             | 脚本类型   |
|   script           | 脚本文件名 |
|   checksum         | 校验和，用于检测是由有更改    |
|   installed_by     | 脚本执行人员 |
|   installed_on     | 执行时间     |
|   execution_time   | 执行脚本所耗时间 |
|   success          | 是否执行成功(0-失败，1成功) |

# Spring Boot集成示例  

0.添加所需依赖
```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- spring-boot-dependencies已包含了flyway的版本设置 -->
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
```

1.`application.yml`配置数据库连接与sql脚本所在目录(不配则默认为`classpath:db/migration`)  
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/spring_boot_series?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=GMT
    username: root
    password: tiger
    driver-class-name: com.mysql.cj.jdbc.Driver
  # 自动读取spring.datasource配置进行迁移操作
  flyway:
    locations: classpath:db
```

2.添加初始化sql文件 `V1.0__Base_DDL.sql` 到配置目录下(前缀须以大写`V`为前缀，可通过`sql-migration-prefix`配置更改)  
```
CREATE SCHEMA IF NOT EXISTS `spring_boot_series` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `spring_boot_series`;

-- -----------------------------------------------------
-- Table `spring_boot_series`.`user_base`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `spring_boot_series`.`user_base`
(
    `id`          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nickname`    VARCHAR(45)     NOT NULL DEFAULT '' COMMENT '昵称',
    `status`      VARCHAR(45)     NOT NULL,
    `sex`         TINYINT         NULL COMMENT '性别(MALE:1-男性,FEMALE:0-女性)',
    `mobile`      VARCHAR(13)     NOT NULL DEFAULT '' COMMENT '手机号码',
    `email`       VARCHAR(100)    NOT NULL DEFAULT '' COMMENT '邮箱',
    `birthday`    BIGINT          NOT NULL DEFAULT 0 COMMENT '生日',
    `create_time` DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `spring_boot_series`.`user_auth`
(
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `uid`           BIGINT          NOT NULL,
    `identity_type` TINYINT         NOT NULL,
    `identifier`    VARCHAR(50)     NOT NULL DEFAULT '',
    `certificate`   VARCHAR(30)     NOT NULL DEFAULT '',
    `create_time`   TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`   TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `idx_uid_certificate` (`uid` ASC, `certificate` ASC),
    INDEX `idx_type_identity` (`identity_type` ASC, `identifier` ASC)
)
    ENGINE = InnoDB
    COMMENT = '用户授权表';
```
  
3.添加版本文件  
`V1.0.1__Modify_user_birthday.sql`:
```
alter table user_base modify birthday datetime null comment '生日';
```
`V1.0.2__Modify_user_birthday.sql`:
```
alter table user_base modify birthday timestamp null comment '生日';
alter table user_base add login_time timestamp null;
```

4.启动SpringBoot应用，以下为数据库为空SpringBoot应用运行时的执行输出
![flyway-migration](https://img-blog.csdnimg.cn/20210113135458323.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3oyODEyNjMwOA==,size_16,color_FFFFFF,t_70)
由于配置连接的数据库里没有任何表，所以SpringBoot应用运行时flyway会根据脚本进行数据库的初始化，执行的顺序会根据脚本版本号由低到高按顺序执行(`1.0 -> 1.0.1 -> 1.0.2`)，每执行完一个版本脚本都会向记录表`flyway_history_schema`插入一条数据。
若添加了新的版本脚本，应用启动时flyway会根据脚本文件版本到记录表`flyway_history_schema`查询是否有对应的版本脚本被执行了，如果没有相应的版本脚本记录才会执行脚本。


# 参考
[官网文档](https://flywaydb.org/documentation/concepts/migrations#overview)
[示例地址](https://github.com/Wilson-He/spring-boot-series/tree/master/spring-boot-flyway-demo)
