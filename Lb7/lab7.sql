CREATE DATABASE IF NOT EXISTS vlada_db;
USE vlada_db;

DROP TABLE IF EXISTS family_satellites;
DROP TABLE IF EXISTS sex;
DROP TABLE IF EXISTS family_tree;
DROP TABLE IF EXISTS family_values;
DROP TABLE IF EXISTS family_tree_has_family_values;

CREATE TABLE family_satellites (
	id INT AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    birth_date DATE,
    death_date DATE,
    birth_place VARCHAR(60),
    death_place VARCHAR(60),
    marriage_date DATE,
    sex CHAR(1),
    
    CONSTRAINT pk_family_satellites PRIMARY KEY (id)
);

CREATE TABLE sex (
	sex CHAR(1),
    sex_full VARCHAR(10),
    
    CONSTRAINT pk_sex PRIMARY KEY (sex)
);

INSERT INTO sex(sex, sex_full) VALUES ('M', "MALE"),('F', 'FEMALE');

CREATE TABLE family_tree (
    id INT AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    birth_date DATE,
    death_date DATE,
    birth_place VARCHAR(60),
    death_place VARCHAR(60),
    credit_card_number VARCHAR(19),
    satellites_id INT UNIQUE,
    sex CHAR(1) NOT NULL,
    parent_tree_id INT,
    
    CONSTRAINT pk_family_tree PRIMARY KEY (id)
);

CREATE TABLE family_values (
	id INT AUTO_INCREMENT,
    name VARCHAR(100),
    price DECIMAL(10,2) UNSIGNED,
    max_cost DECIMAL(10,2) UNSIGNED,
    min_cost DECIMAL(10,2) UNSIGNED,
    
    CONSTRAINT family_values_pk PRIMARY KEY (id)
);

CREATE TABLE family_tree_has_family_values(
	family_tree_id INT,
    family_values_id INT,
    
    CONSTRAINT family_tree_has_family_values_pk PRIMARY KEY (family_tree_id, family_values_id)
);