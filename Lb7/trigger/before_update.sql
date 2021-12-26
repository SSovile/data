USE vlada_db;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_satellites_update //
CREATE TRIGGER before_family_satellites_update
BEFORE UPDATE
ON family_satellites FOR EACH ROW
BEGIN 
	IF new.sex != old.sex THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "error";
	END IF;
END //

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_has_family_values_update //
CREATE TRIGGER before_family_tree_has_family_values_update
BEFORE UPDATE
ON family_tree_has_family_values FOR EACH ROW
BEGIN 
	IF new.family_values_id NOT IN (SELECT id FROM family_values) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cant found id in family_values.id
        for family_tree_has_family_values.family_value_id";
	END IF;
    
    IF new.family_tree_id NOT IN (SELECT id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cant found id in family_tree.id
        for family_tree_has_family_value.family_tree_id";
	END IF;
END //

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_update //
CREATE TRIGGER before_family_tree_update
BEFORE UPDATE
ON family_tree FOR EACH ROW
BEGIN 
	IF new.sex != old.sex THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "error";
	END IF;
    
    IF new.satellites_id NOT IN (SELECT id FROM family_satellites) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cant found id in family_satellites.id
        for family_tree.satellites_id";
	END IF;
    
    IF (old.parent_tree_id IS NULL) AND (new.parent_tree_id NOT IN (SELECT id FROM family_tree)) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Cant dound id in family_tree.id
        for family_tree.parent_tree_id";
	END IF;
    
    IF (old.parent_tree_id IS NOT NULL) AND (new.parent_tree_id != old.parent_tree_id) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "error";
	END IF;
END //

DROP TRIGGER IF EXISTS before_sex_update //
CREATE TRIGGER before_sex_update
BEFORE UPDATE
ON sex FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "error";
END //