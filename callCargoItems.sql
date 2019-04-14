-- -----------------------------------------------------

-- Queries

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetAllCargoItems//

CREATE PROCEDURE GetAllCargoItems()
	BEGIN
		SELECT * FROM cargo_items;
	END //
DELIMITER ;

CALL GetAllCargoItems();

-- -----------------------------------------------------

-- Update

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS UpdateCargoItems//

CREATE PROCEDURE UpdateCargoItems(
IN p_item_name VARCHAR(80),
IN p_user_id INT(12),
IN p_curr_amount VARCHAR(80))
	BEGIN
		CALL DeleteCargoItem(p_user_id);
        CALL insert_items(p_item_name, p_curr_amount, p_user_id);
	END //
DELIMITER ;

CALL UpdateCargoItems(1, 20);

-- -----------------------------------------------------

-- Delete

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS DeleteCargoItem//

CREATE PROCEDURE DeleteCargoItem(IN p_user_id INT(11))
	BEGIN
		DELETE FROM cargo_items
        WHERE user_id = p_user_id;
	END //
DELIMITER ;

CALL DeleteCargoItem(5);
-- -----------------------------------------------------

-- Select one cargohold

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetCargoItem//

CREATE PROCEDURE GetCargoItem(IN p_cargo_item_id INT(12))
	BEGIN
		Select * FROM cargo_items
        WHERE cargo_item_id = p_cargo_item_id;
	END //
DELIMITER ;

CALL GetCargoItem(1);

-- -----------------------------------------------------

-- Get items

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS GetCargoItems//

CREATE PROCEDURE GetCargoItems(IN p_user_id INT(12))
	BEGIN
		Select * FROM cargo_items
        WHERE user_id = p_user_id;
	END //
DELIMITER ;

CALL GetCargoItems(1)