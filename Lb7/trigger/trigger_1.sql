Use vlada_db;

DELIMITER //
CREATE TRIGGER AfterDeleteSatellitesMax6Row
AFTER DELETE
ON family_satellites FOR EACH ROW
BEGIN
IF(SELECT COUNT(*) FROM family_satellites)>6
THEN SIGNAL SQLSTATE'4500'
SET MESSAGE_TEXT = 'Delete error Max cardinality';
END IF;
END//
DELIMITER ;
