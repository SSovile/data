USE vlada_db;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_satellites_input //
CREATE TRIGGER before_family_satellites_input
BEFORE INSERT 
ON family_satellites FOR EACH ROW
BEGIN 
	IF new.sex NOT IN (SELECT sex FROM sex) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "No such sex found for family_satellites.sex";
	END IF;
END //

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_has_family_values_input //
CREATE TRIGGER before_family_tree_has_family_values_input
BEFORE INSERT 
ON family_tree_has_family_values FOR EACH ROW
BEGIN 
	IF new.family_values_id NOT IN (SELECT id FROM family_values) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cant found id in family_values.id
        for family_tree_has_family_values.family_values_id";
	END IF;
    
    IF new.family_tree_id NOT IN (SELECT id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cant found id in family_tree.id
        for family_tree_has_family_values.family_tree_id";
	END IF;
END //

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_input //
CREATE TRIGGER before_family_tree_input
BEFORE INSERT 
ON family_tree FOR EACH ROW
BEGIN 
	IF new.sex NOT IN (SELECT sex FROM sex) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cant found in sex.sex for family_satellites.sex";
	END IF;
    
    IF new.satellites_id NOT IN (SELECT id FROM family_satellites) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cant found id in family_satellites.id
        for family_tree.satellites_id";
	END IF;
    
    IF (new.parent_tree_id IS NOT NULL) AND (new.parent_tree_id NOT IN (SELECT id FROM family_tree)) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cant found id in family_tree.id
        for family_tree.parent_tree_id";
	END IF;
END //

DELIMITER //
DROP TRIGGER IF EXISTS before_sex_input //
CREATE TRIGGER before_sex_input
BEFORE INSERT 
ON sex FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "error";
END //