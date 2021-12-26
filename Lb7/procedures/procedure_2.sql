USE vlada_db;

DROP PROCEDURE IF EXISTS insert_tree_values_joint;

DELIMITER //
CREATE PROCEDURE insert_tree_values_joint(family_tree_id INT, family_values_id INT)
BEGIN
    IF (EXISTS(SELECT * FROM family_tree WHERE id = family_tree_id) AND
        EXISTS(SELECT * FROM family_values WHERE id = family_values_id)) THEN
        INSERT INTO family_tree_has_family_values
        VALUES (family_tree_id, family_values_id);
    end if;
END //
DELIMITER ;