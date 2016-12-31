-- MySQL Script generated by MySQL Workbench
-- Tue May 17 17:40:32 2016
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema zms_server
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema zms_server
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zms_server` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `zms_server` ;

-- -----------------------------------------------------
-- Table `zms_server`.`domain`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`domain` (
  `domain_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(512) NOT NULL,
  `description` VARCHAR(4096) NOT NULL DEFAULT '',
  `org` VARCHAR(1024) NOT NULL DEFAULT '',
  `uuid` VARCHAR(128) NOT NULL DEFAULT '',
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  `audit_enabled` TINYINT(1) NOT NULL DEFAULT 0,
  `ypm_id` INT UNSIGNED NOT NULL DEFAULT 0,
  `account` VARCHAR(128) NOT NULL DEFAULT '',
  `modified` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `created` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`domain_id`),
  UNIQUE INDEX `uq_name` (`name` ASC),
  INDEX `idx_modified` (`modified` ASC),
  INDEX `idx_account` (`account` ASC),
  INDEX `idx_ypmid` (`ypm_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`role` (
  `role_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `domain_id` INT UNSIGNED NOT NULL,
  `name` VARCHAR(512) NOT NULL,
  `trust` VARCHAR(512) NOT NULL DEFAULT '',
  `modified` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `created` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `uq_domain_role` (`domain_id` ASC, `name` ASC),
  CONSTRAINT `fk_role_domain`
    FOREIGN KEY (`domain_id`)
    REFERENCES `zms_server`.`domain` (`domain_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`principal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`principal` (
  `principal_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(512) NOT NULL,
  PRIMARY KEY (`principal_id`),
  UNIQUE INDEX `uq_name` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`policy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`policy` (
  `policy_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `domain_id` INT UNSIGNED NOT NULL,
  `name` VARCHAR(512) NOT NULL,
  `modified` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `created` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`policy_id`),
  INDEX `fk_policy_domain_idx` (`domain_id` ASC),
  UNIQUE INDEX `uq_domain_policy` (`name` ASC, `domain_id` ASC),
  CONSTRAINT `fk_policy_domain`
    FOREIGN KEY (`domain_id`)
    REFERENCES `zms_server`.`domain` (`domain_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`assertion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`assertion` (
  `assertion_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `policy_id` INT UNSIGNED NOT NULL,
  `role` VARCHAR(512) NOT NULL,
  `resource` VARCHAR(1024) NOT NULL,
  `action` VARCHAR(128) NOT NULL,
  `effect` VARCHAR(16) NOT NULL DEFAULT 'ALLOW',
  PRIMARY KEY (`assertion_id`),
  INDEX `fk_assertion_policy_idx` (`policy_id` ASC),
  INDEX `idx_role` (`role` ASC),
  INDEX `idx_resource` (`resource` ASC),
  INDEX `idx_action` (`action` ASC),
  INDEX `idx_effect` (`effect` ASC),
  CONSTRAINT `fk_policy_assertion_policy`
    FOREIGN KEY (`policy_id`)
    REFERENCES `zms_server`.`policy` (`policy_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`service` (
  `service_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `domain_id` INT UNSIGNED NOT NULL,
  `name` VARCHAR(512) NOT NULL,
  `provider_endpoint` VARCHAR(512) NOT NULL DEFAULT '',
  `executable` VARCHAR(256) NOT NULL DEFAULT '',
  `svc_user` VARCHAR(256) NOT NULL DEFAULT '',
  `svc_group` VARCHAR(256) NOT NULL DEFAULT '',
  `modified` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `created` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`service_id`),
  INDEX `fk_service_domain_idx` (`domain_id` ASC),
  UNIQUE INDEX `uq_domain_service` (`name` ASC, `domain_id` ASC),
  CONSTRAINT `fk_service_domain`
    FOREIGN KEY (`domain_id`)
    REFERENCES `zms_server`.`domain` (`domain_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`public_key`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`public_key` (
  `service_id` INT UNSIGNED NOT NULL,
  `key_id` VARCHAR(128) NOT NULL,
  `key_value` TEXT(65535) NOT NULL,
  PRIMARY KEY (`service_id`, `key_id`),
  CONSTRAINT `fk_service_public_key_service`
    FOREIGN KEY (`service_id`)
    REFERENCES `zms_server`.`service` (`service_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`host`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`host` (
  `host_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(512) NOT NULL,
  PRIMARY KEY (`host_id`),
  UNIQUE INDEX `uq_name` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`service_host`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`service_host` (
  `service_id` INT UNSIGNED NOT NULL,
  `host_id` INT UNSIGNED NOT NULL,
  INDEX `idx_host` (`host_id` ASC, `service_id` ASC),
  PRIMARY KEY (`service_id`, `host_id`),
  CONSTRAINT `fk_service_host_host`
    FOREIGN KEY (`host_id`)
    REFERENCES `zms_server`.`host` (`host_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_host_service`
    FOREIGN KEY (`service_id`)
    REFERENCES `zms_server`.`service` (`service_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`entity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`entity` (
  `name` VARCHAR(256) NOT NULL,
  `domain_id` INT UNSIGNED NOT NULL,
  `value` TEXT(65536) NOT NULL,
  `modified` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `created` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`name`, `domain_id`),
  CONSTRAINT `fk_entity_domain`
    FOREIGN KEY (`domain_id`)
    REFERENCES `zms_server`.`domain` (`domain_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`role_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`role_member` (
  `role_id` INT UNSIGNED NOT NULL,
  `principal_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`role_id`, `principal_id`),
  INDEX `idx_principal` (`principal_id` ASC, `role_id` ASC),
  CONSTRAINT `fk_role_member_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `zms_server`.`role` (`role_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_member_principal`
    FOREIGN KEY (`principal_id`)
    REFERENCES `zms_server`.`principal` (`principal_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`domain_template`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`domain_template` (
  `domain_id` INT UNSIGNED NOT NULL,
  `template` VARCHAR(64) NOT NULL,
  UNIQUE INDEX `uq_domain_template` (`template` ASC, `domain_id` ASC),
  PRIMARY KEY (`domain_id`, `template`),
  CONSTRAINT `fk_domain_template_domain`
    FOREIGN KEY (`domain_id`)
    REFERENCES `zms_server`.`domain` (`domain_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zms_server`.`role_audit_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zms_server`.`role_audit_log` (
  `role_id` INT UNSIGNED NOT NULL,
  `admin` VARCHAR(512) NOT NULL,
  `member` VARCHAR(512) NOT NULL,
  `created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `action` VARCHAR(32) NOT NULL,
  `audit_ref` VARCHAR(512) NOT NULL,
  INDEX `fk_role_audit_log_role_id_idx` (`role_id` ASC),
  CONSTRAINT `fk_role_audit_log_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `zms_server`.`role` (`role_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
