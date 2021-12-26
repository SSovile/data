USE vlada_db;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_input_check_death_place //
CREATE TRIGGER before_family_tree_input_check_death_place
BEFORE INSERT
ON family_tree FOR EACH ROW
BEGIN 
	IF (new.death_place IS NOT NULL) AND 
    (new.death_place NOT IN ("c.Strilku", "c.Pidkopane", "c.Yariv")) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "error";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_tree_update_check_death_place //
CREATE TRIGGER before_family_tree_update_check_death_place
BEFORE UPDATE
ON family_tree FOR EACH ROW
BEGIN 
	IF (new.death_place IS NOT NULL) AND 
    (new.death_place NOT IN ("c.Strilku", "c.Pidkopane", "c.Yariv")) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "error";
	END IF;
END //