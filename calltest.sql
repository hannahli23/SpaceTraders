-- -----------------------------------------------------

-- Testing table

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS insert_player//
CREATE PROCEDURE insert_player(
IN p_player_name VARCHAR(80), 
IN p_currency INT(12),
IN p_difficulty VARCHAR(80), 
IN p_fp INT(12),
IN p_tp INT(12),
IN p_ep INT(12),
IN p_pp INT(12),
IN p_curr_planet VARCHAR(80)
)
BEGIN
INSERT INTO spacetraders.person(player_name,
currency, difficulty, fighter_points, trader_points, engineer_points, pilot_points,
curr_planet) 
VALUES(p_player_name, p_currency, p_difficulty, p_fp, p_tp,
p_ep, p_pp, p_curr_planet);
END //
DELIMITER ;

use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS insert_ship//
CREATE PROCEDURE insert_ship(
IN p_shipname VARCHAR(80), 
IN p_shiptype VARCHAR(80),
IN p_hs INT(11),
IN p_ws INT(11),
IN p_ss INT(11),
IN p_gs INT(11),
IN p_cq INT(11),
IN p_tr INT(11),
IN p_escape VARCHAR(80),
IN p_user_id INT(11)
)
BEGIN
INSERT INTO spacetraders.ship(ship_name, ship_type, hull_strength,
weapon_slots, shield_slots, gadget_slots, 
crew_quarters, travel_range, escape_pod, user_id) 
VALUES(p_shipname, p_shiptype, 
p_hs, p_ws, p_ss, p_gs, p_cq, p_tr, 
p_escape, p_user_id);
END //
DELIMITER ;

use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS insert_cargohold//
CREATE PROCEDURE insert_cargohold(
IN p_maxsize INT(12),
IN p_curr_size INT(11),
IN p_user_id INT(11)
)
BEGIN
INSERT INTO spacetraders.cargo_hold(maxsize, curr_size, user_id) VALUES(p_maxsize, p_curr_size, p_user_id);
END //
DELIMITER ;

use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS insert_items//
CREATE PROCEDURE insert_items(
IN p_name VARCHAR(80),
IN p_user_id INT(11)
)
BEGIN
INSERT INTO spacetraders.cargo_items(item_name, user_id) VALUES(p_name, p_user_id);
END //
DELIMITER ;



CALL insert_player('Hannah', 2000, 'Easy', 1, 1, 1, 1, 'Test');

CALL insert_player('Olivia', 2000);
CALL insert_ship('Gransleuth', 'Bumblebee', 1, 2, 3, 4, 5, 6, 'false', 1);
CALL insert_ship('Gransleuth', 'Bumblebee', 2);
CALL insert_cargohold(22, 2, 1);
CALL insert_cargohold(22, 2);
CALL insert_items("Berries", 1);
CALL insert_items("Candy", 1);
CALL insert_items("Water", 1);
CALL insert_items("Fur", 1);
CALL insert_items("Firearms", 1);


CALL insert_items("Berries", 2);
CALL insert_items("Candy", 2);
CALL insert_items("Water", 2);
CALL insert_items("Fur", 2);
CALL insert_items("Firearms", 2);
CALL insert_items("WATER", 2);
-- -----------------------------------------------------

-- Queries

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetAllPlayers//

CREATE PROCEDURE GetAllPlayers()
	BEGIN
		SELECT * FROM person;
	END //
DELIMITER ;

CALL GetAllPlayers();

-- -----------------------------------------------------

-- Update

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS UpdatePlayer//

CREATE PROCEDURE UpdatePlayer(IN p_user_id INT(12),
							IN p_username VARCHAR(80))
	BEGIN
		UPDATE person
        SET username = p_username
        WHERE user_id = p_user_id;
	END //
DELIMITER ;

CALL UpdatePlayer(1, "TESTINGTEST");

-- -----------------------------------------------------

-- Delete

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS DeletePlayer//

CREATE PROCEDURE DeletePlayer(IN p_user_id INT(12))
	BEGIN
		DELETE FROM person
        WHERE user_id = pGetCargoHoldGetCargoHold_user_id;
	END //
DELIMITER ;

-- -----------------------------------------------------

-- Get a player

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetPlayer//

CREATE PROCEDURE GetPlayer(IN p_user_id INT(12))
	BEGIN
		Select * FROM person
        WHERE user_id = p_user_id;
	END //
DELIMITER ;

CALL GetPlayer(1);