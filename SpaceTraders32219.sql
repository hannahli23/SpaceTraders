CREATE DATABASE  IF NOT EXISTS `spacetraders` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spacetraders`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: spacetraders
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargo_hold`
--

DROP TABLE IF EXISTS `cargo_hold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo_hold` (
  `cargohold_id` int(11) NOT NULL AUTO_INCREMENT,
  `maxsize` int(3) NOT NULL DEFAULT '0',
  `curr_size` int(11) NOT NULL DEFAULT '0',
  `ship_id` int(12) NOT NULL,
  PRIMARY KEY (`cargohold_id`),
  KEY `ship_id` (`ship_id`),
  CONSTRAINT `cargo_hold_ibfk_1` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`ship_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo_hold`
--

LOCK TABLES `cargo_hold` WRITE;
/*!40000 ALTER TABLE `cargo_hold` DISABLE KEYS */;
INSERT INTO `cargo_hold` VALUES (1,22,0,1);
/*!40000 ALTER TABLE `cargo_hold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo_items`
--

DROP TABLE IF EXISTS `cargo_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo_items` (
  `cargo_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(50) NOT NULL DEFAULT 'item name',
  `curr_amount` int(11) NOT NULL DEFAULT '0',
  `cargohold_id` int(12) NOT NULL,
  PRIMARY KEY (`cargo_item_id`),
  KEY `cargohold_id` (`cargohold_id`),
  CONSTRAINT `cargo_items_ibfk_1` FOREIGN KEY (`cargohold_id`) REFERENCES `cargo_hold` (`cargohold_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo_items`
--

LOCK TABLES `cargo_items` WRITE;
/*!40000 ALTER TABLE `cargo_items` DISABLE KEYS */;
INSERT INTO `cargo_items` VALUES (1,'item name',22,1);
/*!40000 ALTER TABLE `cargo_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT 'UsTest',
  `pass_word` varchar(50) NOT NULL DEFAULT 'Test',
  `player_name` varchar(50) NOT NULL DEFAULT 'Gran',
  `currency` int(12) NOT NULL DEFAULT '100',
  `difficulty` varchar(50) NOT NULL DEFAULT 'BEGINNER',
  `fighter_points` int(12) NOT NULL DEFAULT '0',
  `trader_points` int(12) NOT NULL DEFAULT '0',
  `engineer_points` int(12) NOT NULL DEFAULT '0',
  `pilot_points` int(12) NOT NULL DEFAULT '0',
  `curr_planet` varchar(50) NOT NULL DEFAULT 'WollingHills',
  `curr_job` varchar(50) NOT NULL DEFAULT 'Regular',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'TESTINGTEST','Test','Gran',2000,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(3,'>:DDDDDDDDDDDDDDDDDDDDDDDDDD','Test','Gran',10000,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(4,'OWO','Test','Gran',23241513,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(5,'london','Test','Gran',1500134255,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(6,'london','Test','Gran',1500134255,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(7,'london','Test','Gran',150015,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(8,'london','Test','Gran',150015,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(9,'london','Test','Gran',150015,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(10,'london','Test','Gran',150015,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(11,'london','Test','Gran',150015,'BEGINNER',0,0,0,0,'WollingHills','Regular'),(12,'asldjkrhewfuo2[','Test','Gran',150015,'BEGINNER',0,0,0,0,'WollingHills','Regular');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ship`
--

DROP TABLE IF EXISTS `ship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ship` (
  `ship_id` int(11) NOT NULL AUTO_INCREMENT,
  `ship_name` varchar(50) NOT NULL DEFAULT 'Grancypher',
  `ship_type` varchar(50) NOT NULL DEFAULT 'TESTING',
  `hull_strength` int(3) NOT NULL DEFAULT '0',
  `weapon_slots` int(11) NOT NULL DEFAULT '2',
  `shield_slots` int(11) NOT NULL DEFAULT '2',
  `gadget_slots` int(11) NOT NULL DEFAULT '2',
  `crew_quarters` int(11) NOT NULL DEFAULT '2',
  `travel_range` int(11) NOT NULL DEFAULT '2',
  `escape_pod` varchar(50) NOT NULL DEFAULT 'true',
  `user_id` int(12) NOT NULL,
  PRIMARY KEY (`ship_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `ship_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `person` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ship`
--

LOCK TABLES `ship` WRITE;
/*!40000 ALTER TABLE `ship` DISABLE KEYS */;
INSERT INTO `ship` VALUES (1,'Gransleuth','Bumblebee',0,2,2,2,2,2,'true',1);
/*!40000 ALTER TABLE `ship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'spacetraders'
--
/*!50003 DROP PROCEDURE IF EXISTS `DeletePlayer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeletePlayer`(IN p_user_id INT(12))
BEGIN
		DELETE FROM person
        WHERE user_id = p_user_id;
	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetAllPlayers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllPlayers`()
BEGIN
		SELECT * FROM person;
	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_cargohold` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_cargohold`(
IN p_maxsize INT(12),
IN p_ship_id INT(11)
)
BEGIN
INSERT INTO spacetraders.cargo_hold(maxsize, ship_id) VALUES(p_maxsize, p_ship_id);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_items` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_items`(
IN p_amount INT(12),
IN p_cargohold_id INT(11)
)
BEGIN
INSERT INTO spacetraders.cargo_items(curr_amount, cargohold_id) VALUES(p_amount, p_cargohold_id);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_player` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_player`(
IN p_username VARCHAR(80), 
IN p_currency INT(12)
)
BEGIN
INSERT INTO spacetraders.person(username, currency) VALUES(p_username, p_currency);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_ship` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_ship`(
IN p_shipname VARCHAR(80), 
IN p_shiptype VARCHAR(80),
IN p_user_id INT(11)
)
BEGIN
INSERT INTO spacetraders.ship(ship_name, ship_type, user_id) VALUES(p_shipname, p_shiptype, p_user_id);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `UpdatePlayer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdatePlayer`(IN p_user_id INT(12),
							IN p_username VARCHAR(80))
BEGIN
		UPDATE person
        SET username = p_username
        WHERE user_id = p_user_id;
	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-22 13:13:04
