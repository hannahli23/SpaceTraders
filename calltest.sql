-- -----------------------------------------------------

-- Testing table

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS insert_player//
CREATE PROCEDURE insert_player(
IN p_username VARCHAR(80), 
IN p_currency INT(12)
)
BEGIN
INSERT INTO spacetraders.person(username, currency) VALUES(p_username, p_currency);
END //
DELIMITER ;

use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS insert_ship//
CREATE PROCEDURE insert_ship(
IN p_shipname VARCHAR(80), 
IN p_shiptype VARCHAR(80),
IN p_user_id INT(11)
)
BEGIN
INSERT INTO spacetraders.ship(ship_name, ship_type, user_id) VALUES(p_shipname, p_shiptype, p_user_id);
END //
DELIMITER ;

use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS insert_cargohold//
CREATE PROCEDURE insert_cargohold(
IN p_maxsize INT(12),
IN p_ship_id INT(11)
)
BEGIN
INSERT INTO spacetraders.cargo_hold(maxsize, ship_id) VALUES(p_maxsize, p_ship_id);
END //
DELIMITER ;

use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS insert_items//
CREATE PROCEDURE insert_items(
IN p_name VARCHAR(80),
IN p_cargohold_id INT(11)
)
BEGIN
INSERT INTO spacetraders.cargo_items(item_name, cargohold_id) VALUES(p_name, p_cargohold_id);
END //
DELIMITER ;



CALL insert_player('Hannah', 2000);
CALL insert_ship('Gransleuth', 'Bumblebee', 1);
CALL insert_cargohold(22, 1);
CALL insert_items("Berries", 1);


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

-- Delete

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