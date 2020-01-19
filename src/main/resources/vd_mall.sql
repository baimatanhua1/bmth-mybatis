-- MySQL Script generated by MySQL Workbench
-- 01/08/20 17:25:34
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema vd_mall
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `vd_mall`;

-- -----------------------------------------------------
-- Schema vd_mall
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vd_mall` DEFAULT CHARACTER SET utf8;
USE `vd_mall`;

-- -----------------------------------------------------
-- Table `vd_mall`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vd_mall`.`users`
(
    `id`        INT          NOT NULL AUTO_INCREMENT,
    `username`  VARCHAR(45)  NOT NULL COMMENT '用户名',
    `password`  VARCHAR(45)  NULL COMMENT '密码',
    `nickname`  VARCHAR(45)  NULL COMMENT '昵称',
    `avatar`    VARCHAR(256) NULL COMMENT '头像',
    `age`       INT          NULL COMMENT '年龄',
    `sex`       TINYINT(4)   NULL COMMENT '性别',
    `telephone` VARCHAR(45)  NULL COMMENT '电话',
    `address` VARCHAR(255)  NULL COMMENT '地址',
    `enable`    TINYINT(4)   NULL DEFAULT 0 COMMENT '状态 0-禁用 1-启用',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIME COMMENT '创建时间',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

INSERT INTO `users` (`username`, `password`, `nickname`, `avatar`, `age`, `sex`, `telephone`, `enable`, `create_time`) VALUES ('bmth', '123456', '白马探花', 'http://avatar', '27', '1', '12345678901', '1', NULL);
-- -----------------------------------------------------
-- Table `vd_mall`.`receive_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vd_mall`.`receive_address`
(
    `address_id`     INT         NOT NULL AUTO_INCREMENT,
    `user_id`        INT         NULL COMMENT '用户id',
    `receive_user`   VARCHAR(45) NULL COMMENT '收件人',
    `phone_number`   VARCHAR(45) NULL COMMENT '收件人电话',
    `province`       VARCHAR(45) NULL COMMENT '省',
    `city`           VARCHAR(45) NULL COMMENT '市',
    `region`         VARCHAR(45) NULL COMMENT '区',
    `detail_address` VARCHAR(45) NULL COMMENT '详细地址',
    `post_code`      VARCHAR(45) NULL COMMENT '邮政编码',
    `is_default`     VARCHAR(45) NULL,
    `create_time`    TIMESTAMP   NULL,
    PRIMARY KEY (`address_id`)
)
    ENGINE = InnoDB
    COMMENT = '收货地址';


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
