SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `spring_boot_series` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `spring_boot_series` ;

-- -----------------------------------------------------
-- Table `spring_boot_series`.`user_base`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring_boot_series`.`user_base` ;

CREATE TABLE IF NOT EXISTS `spring_boot_series`.`user_base` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL DEFAULT '' COMMENT '昵称',
  `status` VARCHAR(45) NOT NULL,
  `sex` TINYINT NULL COMMENT '性别(MALE:1-男性,FEMALE:0-女性)',
  `mobile` VARCHAR(13) NOT NULL DEFAULT '' COMMENT '手机号码',
  `email` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '邮箱',
  `birthday` BIGINT NOT NULL DEFAULT 0 COMMENT '生日',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spring_boot_series`.`user_auth`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring_boot_series`.`user_auth` ;

CREATE TABLE IF NOT EXISTS `spring_boot_series`.`user_auth` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `uid` BIGINT NOT NULL,
  `identity_type` TINYINT NOT NULL,
  `identifier` VARCHAR(50) NOT NULL DEFAULT '',
  `certificate` VARCHAR(30) NOT NULL DEFAULT '',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `idx_uid_certificate` (`uid` ASC, `certificate` ASC),
  INDEX `idx_type_identity` (`identity_type` ASC, `identifier` ASC))
ENGINE = InnoDB
COMMENT = '用户授权表';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
