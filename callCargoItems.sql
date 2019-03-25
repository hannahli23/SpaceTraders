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

CREATE PROCEDURE UpdateCargoItems(IN p_cargo_item_id INT(12),
							IN p_curr_amount VARCHAR(80))
	BEGIN
		UPDATE cargo_items
        SET curr_amount = p_curr_amount
        WHERE cargo_item_id = p_cargo_item_id;
	END //
DELIMITER ;

CALL UpdateCargoItems(1, 20);

-- -----------------------------------------------------

-- Delete

-- -----------------------------------------------------
use spacetraders;
DELIMITER //
DROP PROCEDURE IF EXISTS DeleteCargoItem//

CREATE PROCEDURE DeleteCargoItem(IN p_cargo_item_id INT(12))
	BEGIN
		DELETE FROM cargo_items
        WHERE cargo_item_id = p_cargo_item_id;
	END //
DELIMITER ;

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