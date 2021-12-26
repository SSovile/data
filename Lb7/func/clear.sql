USE vlada_db;

SET SQL_SAFE_UPDATES = 0;

DELIMITER //
DROP PROCEDURE IF EXISTS clear_db //
CREATE PROCEDURE clear_db()
BEGIN
    DELETE FROM family_tree_has_family_values;
	DELETE FROM family_tree;
	DELETE FROM family_satellites;
	DELETE FROM family_values;

	ALTER TABLE family_tree AUTO_INCREMENT = 1;
	ALTER TABLE family_satellites AUTO_INCREMENT = 1;
	ALTER TABLE family_values AUTO_INCREMENT = 1;
	ALTER TABLE family_tree_has_family_values AUTO_INCREMENT = 1;
END //