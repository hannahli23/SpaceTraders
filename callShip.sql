-- -----------------------------------------------------

-- Queries

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetAllShips//

CREATE PROCEDURE GetAllShips()
	BEGIN
		SELECT * FROM ship;
	END //
DELIMITER ;

CALL GetAllShips();

-- -----------------------------------------------------

-- Update

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS UpdateShip//

CREATE PROCEDURE UpdateShip(
IN p_user_id INT(12),
IN p_fuel INT(12),
IN p_ship_name VARCHAR(80))
	BEGIN
		UPDATE ship
        SET ship_name = p_ship_name,
        fuel = p_fuel
        WHERE user_id = p_user_id;
	END //
DELIMITER ;

CALL UpdateShip(1, 20, "TESTINGTEST");

-- -----------------------------------------------------

-- Delete

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS DeleteShip//

CREATE PROCEDURE DeleteShip(IN p_ship_id INT(12))
	BEGIN
		DELETE FROM ship
        WHERE ship_id = p_ship_id;
	END //
DELIMITER ;

-- -----------------------------------------------------

-- Get a ship

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetPlayer//

CREATE PROCEDURE GetPlayer(IN p_user_id INT(12))
	BEGIN
		Select * FROM ship
        WHERE user_id = p_user_id;
	END //
DELIMITER ;