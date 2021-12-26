-- task1
SELECT model, type, price
FROM printer
WHERE price < 300
ORDER BY type desc;

-- task2 
SELECT name
FROM battles
WHERE name NOT LIKE '%c' AND name LIKE '% %' AND name NOT LIKE '% % %';

-- task3
SELECT ships.name, classes.country
FROM ships
LEFT JOIN classes
ON ships.class = classes.class;

-- task4
SELECT distinct maker
FROM product
WHERE type = 'PC' AND NOT maker = SOME(
	SELECT maker FROM product
	WHERE type = 'Laptop');
    
-- task5
SELECT name, launched, displacement
FROM ships
INNER JOIN classes
ON ships.class = classes.class
WHERE ships.launched IS NOT NULL AND classes.displacement > 35000;

-- task6
SELECT
	CONCAT('Code: ', code) AS Code,
    CONCAT('Model: ', model) AS Model,
    CONCAT('Speed: ', speed) AS Speed,
    CONCAT('Ram: ', ram) AS Ram,
    CONCAT('Hd: ', hd) AS Hd,
    CONCAT('Cd: ', cd) AS cd
FROM pc;

-- task7
SELECT * FROM
	(SELECT battle, country, COUNT(*) AS 'Number of Ships' FROM (ships
		INNER JOIN classes
		ON ships.class = classes.class)
	INNER JOIN
		(outcomes
		INNER JOIN battles
		ON outcomes.battle = battles.name)
	ON outcomes.ship = ships.name
	GROUP BY battle, country
	HAVING COUNT(*) > 1) as battles_all_countries
GROUP BY battle;

-- task8 
SELECT maker, AVG(screen) FROM laptop
INNER JOIN product
ON product.model = laptop.model
GROUP BY maker;

-- task9
SELECT *
FROM ships
INNER JOIN classes
ON ships.class = classes.class
WHERE (numGuns = 9) 
	+ (bore = 16)
    + (displacement = 46000)
    + (type = 'bb')
    + (country = 'Japan')
    + (launched = 1916)
    + (classes.class = 'Revenge')
    >= 3;
    
-- task 10
SELECT class
FROM (SELECT classes.class, name as ship
	FROM ships
	INNER JOIN classes
	ON classes.class = ships.class
	UNION
	SELECT class, ship
	FROM outcomes
	INNER JOIN classes
	ON outcomes.ship = classes.class) as classes_all_ships
GROUP BY class
HAVING COUNT(*) = 1;

