-- MySQL Workbench Forward Engineering

-- new version

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';



-- -----------------------------------------------------

-- Schema spacetraders

-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `spacetraders` DEFAULT CHARACTER SET utf8 ;

USE `spacetraders` ;

-- -----------------------------------------------------

-- Table `spacetraders`.`person`

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacetraders`.`person` (
	user_id INT(11) NOT NULL AUTO_INCREMENT primary key,
    username  NVARCHAR(50)  NOT NULL DEFAULT 'UsTest',
    pass_word VARCHAR(50) NOT NULL DEFAULT 'Test',
    player_name VARCHAR(50) NOT NULL DEFAULT 'Gran',
    currency INT(12) NOT NULL DEFAULT 100,
    difficulty VARCHAR(50) NOT NULL DEFAULT 'BEGINNER',
    fighter_points INT(12) NOT NULL DEFAULT 0,
    trader_points INT(12) NOT NULL DEFAULT 0,
    engineer_points INT(12) NOT NULL DEFAULT 0,
    pilot_points INT(12) NOT NULL DEFAULT 0,
    curr_planet VARCHAR(50) NOT NULL DEFAULT 'WollingHills',
    curr_job VARCHAR(50) NOT NULL DEFAULT 'Regular'
);

-- -----------------------------------------------------

-- Table `spacetraders`.`ship`

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacetraders`.`ship` (
	ship_id INT(11) NOT NULL AUTO_INCREMENT primary key,
    ship_name VARCHAR(50) NOT NULL DEFAULT 'Grancypher',
    ship_type VARCHAR(50) NOT NULL DEFAULT 'TESTING',
    hull_strength INT(3) NOT NULL DEFAULT 0,
    weapon_slots INT(11) NOT NULL DEFAULT 2,
    shield_slots INT(11) NOT NULL DEFAULT 2,
    gadget_slots INT(11) NOT NULL DEFAULT 2,
    crew_quarters INT(11) NOT NULL DEFAULT 2,
    travel_range INT(11) NOT NULL DEFAULT 2,
    escape_pod VARCHAR(50) NOT NULL DEFAULT 'true',
    FOREIGN KEY(user_id) REFERENCES spacetraders.person(user_id)
);

-- -----------------------------------------------------

-- Table `spacetraders`.`cargo_hold`

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacetraders`.`cargo_hold` (
	cargohold_id INT(11) NOT NULL AUTO_INCREMENT primary key,
    maxsize INT(3) NOT NULL DEFAULT 0,
    curr_size INT(11) NOT NULL DEFAULT 0,
    FOREIGN KEY(ship_id) REFERENCES ship(ship_id)
);

-- -----------------------------------------------------

-- Table `spacetraders`.`cargo_items`

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacetraders`.`cargo_items` (
	cargo_item_id INT(11) NOT NULL AUTO_INCREMENT primary key,
	item_name VARCHAR(50) NOT NULL DEFAULT 'true',
    curr_amount INT(11) NOT NULL DEFAULT 0,
    FOREIGN KEY(cargohold_id) REFERENCES cargo_hold(cargohold_id)
);

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

DELIMITER //
DROP PROCEDURE IF EXISTS insert_ship//
CREATE PROCEDURE insert_ship(
IN p_shipname VARCHAR(80), 
IN p_shiptype VARCHAR(80)
)
BEGIN
INSERT INTO spacetraders.ship(ship_name, ship_type) VALUES(p_shipname, p_shiptype);
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE IF EXISTS insert_cargohold//
CREATE PROCEDURE insert_cargohold(
IN p_maxsize INT(12)
)
BEGIN
INSERT INTO spacetraders.cargo_hold(maxsize) VALUES(p_maxsize);
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE IF EXISTS insert_items//
CREATE PROCEDURE insert_items(
IN p_amount INT(12)
)
BEGIN
INSERT INTO spacetraders.cargo_itmems(curr_size) VALUES(p_amount);
END //
DELIMITER ;



CALL insert_player('Hannah', 2000);
CALL insert_ship('Gransleuth', 'Bumblebee');
CALL insert_cargohold(22);
CALL insert_items(22);



SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;