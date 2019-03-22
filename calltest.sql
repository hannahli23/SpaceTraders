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
IN p_amount INT(12),
IN p_cargohold_id INT(11)
)
BEGIN
INSERT INTO spacetraders.cargo_items(curr_amount, cargohold_id) VALUES(p_amount, p_cargohold_id);
END //
DELIMITER ;



CALL insert_player('Hannah', 2000);
CALL insert_ship('Gransleuth', 'Bumblebee', 1);
CALL insert_cargohold(22, 1);
CALL insert_items(22, 1);


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

CALL GetAllPlayers()