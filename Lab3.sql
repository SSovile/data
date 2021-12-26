CREATE SCHEMA IF NOT EXISTS `Watch` DEFAULT CHARACTER SET utf8 ;
USE `Watch` ;

DROP TABLE IF EXISTS `user_information`;
DROP TABLE IF EXISTS `position`;

DROP TABLE IF  EXISTS `producer_has_SmartWatch`;

DROP TABLE IF EXISTS `SmartWatch`;
DROP TABLE IF EXISTS `Customer`;

DROP TABLE IF  EXISTS `number_of_phone_has_settings`;

DROP TABLE IF EXISTS `settings`;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `number_of_phone`;
DROP TABLE IF EXISTS `home_address`;
DROP TABLE IF EXISTS `city`;
DROP TABLE IF EXISTS `street`;
DROP TABLE IF  EXISTS `producer`;


CREATE TABLE IF NOT EXISTS `Watch`.`number_of_phone` (
  `idnumber_of_phone` INT NOT NULL AUTO_INCREMENT,
  `number` CHAR(12) NOT NULL,
  PRIMARY KEY (`idnumber_of_phone`))
ENGINE = InnoDB;

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

CREATE TABLE IF NOT EXISTS `Watch`.`position` (
  `id` INT NOT NULL,
  `length` VARCHAR(45) NOT NULL,
  `width` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

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

CREATE TABLE IF NOT EXISTS `Watch`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Watch`.`street` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

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

CREATE TABLE IF NOT EXISTS `Watch`.`producer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

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

INSERT INTO `producer` (`name`, `brand`, `email` ) VALUES ('Steve', 'G-schock', 'email');
INSERT INTO `producer` (`name`, `brand`, `email`) VALUES ('Alex', 'G-Apple', 'eqemail');
INSERT INTO `producer` (`name`, `brand`, `email`) VALUES ('Fernand', 'Apple', 'esemail');
INSERT INTO `producer` (`name`, `brand`, `email`) VALUES ('Nick', 'Samsung', 'eaemail');

INSERT INTO `street` (`name`) VALUES ('Habrusevucha');
INSERT INTO `street` (`name`) VALUES ('Haburger');
INSERT INTO `street` (`name`) VALUES ('OO');
INSERT INTO `street` (`name`) VALUES ('Lesi');

INSERT INTO `city` (`name`) VALUES ('Stryi');
INSERT INTO `city` (`name`) VALUES ('LVIV');
INSERT INTO `city` (`name`) VALUES ('LVIV');
INSERT INTO `city` (`name`) VALUES ('Morschun');

INSERT INTO `home_address` (`city_id`,`number`, `street_id`) VALUES ((select id from city WHERE name = 'Stryi'),'12', (select id from street WHERE name = 'Habrusevucha'));
INSERT INTO `home_address` (`city_id`,`number`, `street_id`) VALUES ((select id from city WHERE name = 'LVIV'),'22', (select id from street WHERE name = 'Haburger'));
INSERT INTO `home_address` (`city_id`,`number`, `street_id`) VALUES ((select id from city WHERE name = 'LVIV'),'44', (select id from street WHERE name = 'OO'));
INSERT INTO `home_address` (`city_id`,`number`, `street_id`) VALUES ((select id from city WHERE name = 'Morschun'),'21', (select id from street WHERE name = 'Lesi'));

INSERT INTO `number_of_phone` (`number`) VALUES ('0988887636');
INSERT INTO `number_of_phone` (`number`) VALUES ('0638887136');
INSERT INTO `number_of_phone` (`number`) VALUES ('0988887636');
INSERT INTO `number_of_phone` (`number`) VALUES ('0288887632');

INSERT INTO `USER` (`nickname`) VALUES ('al');
INSERT INTO `USER` (`nickname`) VALUES ('Dl');
INSERT INTO `USER` (`nickname`) VALUES ('Ml');
INSERT INTO `USER` (`nickname`) VALUES ('Kl');

INSERT INTO `CUSTOMER` (`firstname`, `lastname`, `email`) VALUES ('D', 'P', 'den70007');
INSERT INTO `CUSTOMER` (`firstname`, `lastname`, `email`) VALUES ('M', 'P', 'mykhailopolnyi30');
INSERT INTO `CUSTOMER` (`firstname`, `lastname`, `email`) VALUES ('V', 'T', 'vladarium');
INSERT INTO `CUSTOMER` (`firstname`, `lastname`, `email`) VALUES ('Z', 'V', 'VIRUS');

INSERT INTO `SmartWatch` (`model`, `charge`) VALUES ('SPORT', '5800');
INSERT INTO `SmartWatch` (`model`, `charge`) VALUES ('Series 10', '12000');
INSERT INTO `SmartWatch` (`model`, `charge`) VALUES ('Series 12 ', '10000');
INSERT INTO `SmartWatch` (`model`, `charge`) VALUES ('Series 1 ', '100');

INSERT INTO `position` (`length`, `width`)	VALUES ('41.40338', '89.4093');
INSERT INTO `position` (`length`, `width`)	VALUES ('40.40338', '79.4093');
INSERT INTO `position` (`length`, `width`)	VALUES ('33.40338', '102.4093');
INSERT INTO `position` (`length`, `width`)	VALUES ('23.40338', '97.4093');

INSERT INTO `user_information` (`palpitation`) VALUES ('0.1');
INSERT INTO `user_information` (`palpitation`) VALUES ('1.12');
INSERT INTO `user_information` (`palpitation`) VALUES ('120.2');
INSERT INTO `user_information` (`palpitation`) VALUES ('220.12');
