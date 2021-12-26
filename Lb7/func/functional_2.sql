USE vlada_db;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER //
DROP FUNCTION IF EXISTS sex_retrieval //
CREATE FUNCTION sex_retrieval(
	sex CHAR(1)
)
RETURNS VARCHAR(10)
BEGIN
    return(SELECT sex_full FROM sex WHERE sex.sex=sex);
END//