-- -----------------------------------------------------

-- Queries

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetAllCargoHold//

CREATE PROCEDURE GetAllCargoHold()
	BEGIN
		SELECT * FROM cargo_hold;
	END //
DELIMITER ;

CALL GetAllCargoHold();

-- -----------------------------------------------------

-- Update

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS UpdateCargoHold//

CREATE PROCEDURE UpdateCargoHold(
IN p_user_id INT(12),
IN p_curr_size VARCHAR(80)
)
	BEGIN
		UPDATE cargo_hold
        SET curr_size = p_curr_size
        WHERE user_id = p_user_id;
	END //
DELIMITER ;

CALL UpdateCargoHold(5, 45);

-- -----------------------------------------------------

-- Delete

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS DeleteCargoHold//

CREATE PROCEDURE DeleteCargoHold(IN p_user_id INT(12))
	BEGIN
		DELETE FROM cargo_hold
        WHERE user_id = p_user_id;
	END //
DELIMITER ;

-- -----------------------------------------------------

-- Select one cargohold

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetCargoHold//

CREATE PROCEDURE GetCargoHold(IN p_cargohold_id INT(12))
	BEGIN
		Select * FROM cargo_hold
        WHERE cargohold_id = p_cargohold_id;
	END //
DELIMITER ;

CALL GetCargoHold(1);

-- -----------------------------------------------------

-- Get a cargohold

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetACargoHold//

CREATE PROCEDURE GetACargoHold(IN p_user_id INT(12))
	BEGIN
		Select * FROM cargo_hold
        WHERE user_id = p_user_id;
	END //
DELIMITER ;

CALL GetACargoHold(1)