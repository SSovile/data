CREATE SCHEMA IF NOT EXISTS `Watchs` DEFAULT CHARACTER SET utf8 ;
USE `Watchs` ;

DROP TABLE IF EXISTS `user_information`;
DROP TABLE IF EXISTS `position`;
DROP TABLE IF EXISTS `SmartWatch`;
DROP TABLE IF EXISTS `Customer`;
DROP TABLE IF EXISTS `settings`;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `home_address`;
DROP TABLE IF EXISTS `city`;
DROP TABLE IF EXISTS `street`;

CREATE TABLE IF NOT EXISTS `Watchs`.`User` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `nickname` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `watchs`.`customer` (
                                                   `id` INT NOT NULL AUTO_INCREMENT,
                                                   `firstname` VARCHAR(45) NOT NULL,
    `lastname` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `Watchs`.`SmartWatch` (
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

CREATE TABLE IF NOT EXISTS `Watchs`.`position` (
                                                   `id` INT NOT NULL,
                                                   `length` VARCHAR(45) NOT NULL,
    `width` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `watchs`.`user_information` (
                                                           `position_id` INT NOT NULL,
                                                           `palpittion` FLOAT UNSIGNED NOT NULL,
                                                           INDEX `fk_user_information_position1_idx` (`position_id` ASC) VISIBLE,
    CONSTRAINT `fk_user_information_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `watch`.`position` (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `Watchs`.`city` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Watchs`.`street` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Watchs`.`home_address` (
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

CREATE TABLE IF NOT EXISTS `Watchs`.`settings` (
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




