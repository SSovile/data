USE vlada_db;

DELIMITER //
DROP PROCEDURE IF EXISTS insert_into_family_satellites //
CREATE PROCEDURE `insert_into_family_satellites` (
    IN name VARCHAR(45),
    IN surname VARCHAR(45),
    IN birth_date DATE,
    IN death_date DATE,
    IN birth_place VARCHAR(60),
    IN death_place VARCHAR(60),
    IN marriage_date DATE,
    IN sex CHAR(1))
BEGIN
	INSERT INTO family_satellites(name, surname, birth_date, death_date, birth_place, death_place, marriage_date, sex) 
    VALUES(name, surname, birth_date, death_date, birth_place, death_place, marriage_date, sex);
END //