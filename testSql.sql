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
DROP TABLE IF EXISTS `spacetraders`.`person`;
CREATE TABLE IF NOT EXISTS `spacetraders`.`person` (
	user_id INT(11) NOT NULL,
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
    curr_job VARCHAR(50) NOT NULL DEFAULT 'Regular',
    PRIMARY KEY(user_id)
);

-- -----------------------------------------------------

-- Table `spacetraders`.`ship`

-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacetraders`.`ship`;
CREATE TABLE IF NOT EXISTS `spacetraders`.`ship` (
    ship_name VARCHAR(50) NOT NULL DEFAULT 'Grancypher',
    ship_type VARCHAR(50) NOT NULL DEFAULT 'TESTING',
    hull_strength INT(3) NOT NULL DEFAULT 0,
    weapon_slots INT(11) NOT NULL DEFAULT 2,
    shield_slots INT(11) NOT NULL DEFAULT 2,
    gadget_slots INT(11) NOT NULL DEFAULT 2,
    crew_quarters INT(11) NOT NULL DEFAULT 2,
    travel_range INT(11) NOT NULL DEFAULT 2,
    fuel INT(11) NOT NULL DEFAULT 0,
    escape_pod VARCHAR(50) NOT NULL DEFAULT 'true',
    user_id INT(12) NOT NULL primary key,
    FOREIGN KEY (user_id) REFERENCES spacetraders.person(user_id)
);

-- -----------------------------------------------------

-- Table `spacetraders`.`cargo_hold`

-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacetraders`.`cargo_hold`;
CREATE TABLE IF NOT EXISTS `spacetraders`.`cargo_hold` (
    maxsize INT(3) NOT NULL DEFAULT 0,
    curr_size INT(11) NOT NULL DEFAULT 0,
    user_id INT(12) NOT NULL primary key,
    FOREIGN KEY (user_id) REFERENCES spacetraders.person(user_id)
);

-- -----------------------------------------------------

-- Table `spacetraders`.`cargo_items`

-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacetraders`.`cargo_items`;
CREATE TABLE IF NOT EXISTS `spacetraders`.`cargo_items` (
	item_id INT(12) NOT NULL auto_increment primary key,
	item_name VARCHAR(50) NOT NULL DEFAULT 'item name',
    curr_amount INT(11) NOT NULL DEFAULT 0,
	user_id INT(12) NOT NULL,    
    FOREIGN KEY (user_id) REFERENCES spacetraders.person(user_id)
);



SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;