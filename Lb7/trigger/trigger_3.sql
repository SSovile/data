USE vlada_db;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_input_check_birth_date //
CREATE TRIGGER before_family_tree_input_check_birth_date
BEFORE INSERT
ON family_tree FOR EACH ROW
BEGIN 
	IF (new.birth_date IS NOT NULL) AND (new.birth_date > CURDATE()) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "error";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_tree_update_check_birth_date //
CREATE TRIGGER before_family_tree_update_check_birth_date
BEFORE UPDATE
ON family_tree FOR EACH ROW
BEGIN 
	IF (new.birth_date IS NOT NULL) AND (new.birth_date > CURDATE()) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "error";
	END IF;
END //