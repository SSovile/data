-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Watch
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Watch
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Watch` DEFAULT CHARACTER SET utf8 ;
USE `Watch` ;

-- -----------------------------------------------------
-- Table `Watch`.`number_of_phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`number_of_phone` (
  `idnumber_of_phone` INT NOT NULL AUTO_INCREMENT,
  `number` CHAR(12) NOT NULL,
  PRIMARY KEY (`idnumber_of_phone`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `number_of_phone_idnumber_of_phone` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_User_number_of_phone1_idx` (`number_of_phone_idnumber_of_phone` ASC) VISIBLE,
  CONSTRAINT `fk_User_number_of_phone1`
    FOREIGN KEY (`number_of_phone_idnumber_of_phone`)
    REFERENCES `Watch`.`number_of_phone` (`idnumber_of_phone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`Customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `number_of_phone_idnumber_of_phone` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Customer_number_of_phone1_idx` (`number_of_phone_idnumber_of_phone` ASC) VISIBLE,
  CONSTRAINT `fk_Customer_number_of_phone1`
    FOREIGN KEY (`number_of_phone_idnumber_of_phone`)
    REFERENCES `Watch`.`number_of_phone` (`idnumber_of_phone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`SmartWatch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`SmartWatch` (
  `id` INT NOT NULL,
  `model` VARCHAR(45) NULL,
  `Customer_id` INT NOT NULL,
  `charge` INT UNSIGNED NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_SmartWatch_Customer1_idx` (`Customer_id` ASC) VISIBLE,
  INDEX `fk_SmartWatch_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_SmartWatch_Customer1`
    FOREIGN KEY (`Customer_id`)
    REFERENCES `Watch`.`Customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SmartWatch_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `Watch`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`position` (
  `id` INT NOT NULL,
  `length` VARCHAR(45) NOT NULL,
  `width` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`user_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`user_information` (
  `SmartWatch_id` INT NOT NULL,
  `position_id` INT NOT NULL,
  `palpittion` FLOAT UNSIGNED NOT NULL,
  PRIMARY KEY (`SmartWatch_id`),
  INDEX `fk_user_information_position1_idx` (`position_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_information_SmartWatch`
    FOREIGN KEY (`SmartWatch_id`)
    REFERENCES `Watch`.`SmartWatch` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_information_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `Watch`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`street`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`street` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`home_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`home_address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city_id` INT NOT NULL,
  `number` INT NOT NULL,
  `street_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_home_address_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_home_address_street1_idx` (`street_id` ASC) VISIBLE,
  CONSTRAINT `fk_home_address_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `Watch`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_home_address_street1`
    FOREIGN KEY (`street_id`)
    REFERENCES `Watch`.`street` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`settings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`settings` (
  `User_id` INT NOT NULL,
  `home_address_id` INT NOT NULL,
  PRIMARY KEY (`User_id`),
  INDEX `fk_settings_home_address1_idx` (`home_address_id` ASC) VISIBLE,
  CONSTRAINT `fk_settings_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `Watch`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_settings_home_address1`
    FOREIGN KEY (`home_address_id`)
    REFERENCES `Watch`.`home_address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`number_of_phone_has_settings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`number_of_phone_has_settings` (
  `number_of_phone_idnumber_of_phone` INT NOT NULL,
  `settings_User_id` INT NOT NULL,
  PRIMARY KEY (`number_of_phone_idnumber_of_phone`, `settings_User_id`),
  INDEX `fk_number_of_phone_has_settings_settings1_idx` (`settings_User_id` ASC) VISIBLE,
  INDEX `fk_number_of_phone_has_settings_number_of_phone1_idx` (`number_of_phone_idnumber_of_phone` ASC) VISIBLE,
  CONSTRAINT `fk_number_of_phone_has_settings_number_of_phone1`
    FOREIGN KEY (`number_of_phone_idnumber_of_phone`)
    REFERENCES `Watch`.`number_of_phone` (`idnumber_of_phone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_number_of_phone_has_settings_settings1`
    FOREIGN KEY (`settings_User_id`)
    REFERENCES `Watch`.`settings` (`User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`producer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`producer` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Watch`.`producer_has_SmartWatch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Watch`.`producer_has_SmartWatch` (
  `producer_id` INT NOT NULL,
  `SmartWatch_id` INT NOT NULL,
  PRIMARY KEY (`producer_id`, `SmartWatch_id`),
  INDEX `fk_producer_has_SmartWatch_SmartWatch1_idx` (`SmartWatch_id` ASC) VISIBLE,
  INDEX `fk_producer_has_SmartWatch_producer1_idx` (`producer_id` ASC) VISIBLE,
  CONSTRAINT `fk_producer_has_SmartWatch_producer1`
    FOREIGN KEY (`producer_id`)
    REFERENCES `Watch`.`producer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producer_has_SmartWatch_SmartWatch1`
    FOREIGN KEY (`SmartWatch_id`)
    REFERENCES `Watch`.`SmartWatch` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
