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

CREATE PROCEDURE UpdateShip(IN p_ship_id INT(12),
							IN p_ship_name VARCHAR(80))
	BEGIN
		UPDATE ship
        SET ship_name= p_ship_name
        WHERE ship_id = p_ship_id;
	END //
DELIMITER ;

CALL UpdateShip(1, "TESTINGTEST");

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
