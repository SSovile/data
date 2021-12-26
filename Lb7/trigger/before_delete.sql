USE vlada_db;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_family_satellites_delete //
CREATE TRIGGER before_family_family_satellites_delete
BEFORE DELETE
ON family_satellites FOR EACH ROW
BEGIN 
	IF  old.id IN (SELECT id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You cant delete it";
	END IF;
END //

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_delete //
CREATE TRIGGER before_family_tree_delete
BEFORE DELETE
ON family_tree FOR EACH ROW
BEGIN 
	IF  old.id IN (SELECT family_tree_id FROM family_tree_has_family_values) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You cant delete it";
	END IF;
    
    IF  old.id IN (SELECT parent_tree_id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You cant delete it";
	END IF;
END //

DELIMITER //
DROP TRIGGER IF EXISTS before_family_values_delete //
CREATE TRIGGER before_family_values_delete
BEFORE DELETE
ON family_values FOR EACH ROW
BEGIN 
	IF  old.id IN (SELECT family_values_id FROM family_tree_has_family_values) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You can't delete it";
	END IF;
END //

DROP TRIGGER IF EXISTS before_sex_delete //
CREATE TRIGGER before_sex_delete
BEFORE DELETE
ON sex FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "error";
END //