USE vlada_db;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER //
DROP FUNCTION IF EXISTS family_values_maximum_price //
CREATE FUNCTION family_values_maximum_price()
RETURNS DECIMAL(10,2) 
BEGIN
    return(SELECT MAX(price) FROM family_values);
END//