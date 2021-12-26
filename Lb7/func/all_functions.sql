USE vlada_db;

SELECT * FROM family_values
WHERE price > family_values_maximum_price();

SELECT name, surname, birth_date, death_date, birth_place, death_place, 
    marriage_date, sex_retrieval(sex) FROM family_satellites