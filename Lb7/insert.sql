use vlada_db;

call vlada_db.clear_db();

call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'F');
call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'M');
call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'F');
call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'M');
call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'M');
call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'F');
call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'M');
call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'F');
call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'F');
call vlada_db.insert_into_family_satellites('s', 's', '1999-12-20', '2021-12-20', 's', 's', '1999-12-20', 'M');

INSERT INTO family_tree(name, surname, birth_date, death_date, birth_place, death_place, credit_card_number, satellites_id, sex, parent_tree_id)
VALUES ("i", "i", "1999-05-06", null, "i", "s.Pidkopane", null, 1, 'M', 2),
	   ("s", "s", null, null, "s", "s.Yariv", null, 2, 'F', 3),
       ("s", "s", null, null, "s", "s.Yariv", null, 3, 'F', null),
       ("s", "s", null, null, "s", "s.Strilku", null, 4, 'F', null),
       ("a", "a", '1999-12-20', '2021-12-20', "a", "s.Strilku", null, 5, 'M', 3);

CALL insert_tree_values_joint("e", "18", "24", "12");
CALL insert_tree_values_joint("w", "56", "78", "13");
CALL insert_tree_values_joint("q", "20", "30", "12");
CALL insert_tree_values_joint("d", "15", "20", "10");
CALL insert_tree_values_joint("o", "42", "35", "33");
CALL insert_tree_values_joint("br", "25", "103", "42");
CALL insert_tree_values_joint("re", "8", "12", "5");
CALL insert_tree_values_joint("iot", "40", "50", "30");
CALL insert_tree_values_joint("b", "322", "400", "200");
CALL insert_tree_values_joint("m", "32", "35", "30");

INSERT INTO family_tree_has_family_values(family_tree_id, family_values_id)
VALUES (2, 3), (1,1), (2,3), (2,3), (3,2), (5,3), (7,4), (6,4), (5,8), (3,4);
