-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: nsddatabase
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `coursetimetable`
--

DROP TABLE IF EXISTS `coursetimetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coursetimetable` (
  `eventtable_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int DEFAULT NULL,
  `time1` varchar(255) DEFAULT NULL,
  `time10` varchar(255) DEFAULT NULL,
  `time11` varchar(255) DEFAULT NULL,
  `time12` varchar(255) DEFAULT NULL,
  `time13` varchar(255) DEFAULT NULL,
  `time14` varchar(255) DEFAULT NULL,
  `time15` varchar(255) DEFAULT NULL,
  `time16` varchar(255) DEFAULT NULL,
  `time17` varchar(255) DEFAULT NULL,
  `time18` varchar(255) DEFAULT NULL,
  `time19` varchar(255) DEFAULT NULL,
  `time2` varchar(255) DEFAULT NULL,
  `time20` varchar(255) DEFAULT NULL,
  `time21` varchar(255) DEFAULT NULL,
  `time22` varchar(255) DEFAULT NULL,
  `time23` varchar(255) DEFAULT NULL,
  `time24` varchar(255) DEFAULT NULL,
  `time25` varchar(255) DEFAULT NULL,
  `time26` varchar(255) DEFAULT NULL,
  `time27` varchar(255) DEFAULT NULL,
  `time28` varchar(255) DEFAULT NULL,
  `time29` varchar(255) DEFAULT NULL,
  `time3` varchar(255) DEFAULT NULL,
  `time30` varchar(255) DEFAULT NULL,
  `time31` varchar(255) DEFAULT NULL,
  `time32` varchar(255) DEFAULT NULL,
  `time33` varchar(255) DEFAULT NULL,
  `time34` varchar(255) DEFAULT NULL,
  `time35` varchar(255) DEFAULT NULL,
  `time36` varchar(255) DEFAULT NULL,
  `time37` varchar(255) DEFAULT NULL,
  `time38` varchar(255) DEFAULT NULL,
  `time39` varchar(255) DEFAULT NULL,
  `time4` varchar(255) DEFAULT NULL,
  `time40` varchar(255) DEFAULT NULL,
  `time5` varchar(255) DEFAULT NULL,
  `time6` varchar(255) DEFAULT NULL,
  `time7` varchar(255) DEFAULT NULL,
  `time8` varchar(255) DEFAULT NULL,
  `time9` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mktpmn99g2eopgfpp27a7gtw4` (`eventtable_id`),
  CONSTRAINT `FKsfxekripuxc6uil5gvce8xn5p` FOREIGN KEY (`eventtable_id`) REFERENCES `eventtable` (`tableid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursetimetable`
--

LOCK TABLES `coursetimetable` WRITE;
/*!40000 ALTER TABLE `coursetimetable` DISABLE KEYS */;
INSERT INTO `coursetimetable` VALUES (1,1,12,'08:00:00','12:45:00','12:55:00','13:40:00','14:00:00','14:45:00','14:55:00','15:40:00','16:00:00','16:45:00','16:55:00','08:45:00','17:40:00','18:00:00','18:45:00','18:55:00','19:40:00','20:00:00','20:45:00','21:00:00','21:45:00','21:55:00','08:55:00','22:40:00','23:00:00','23:00:00','23:00:00','23:00:00','23:00:00','23:00:00','23:00:00','23:00:00','23:00:00','09:40:00','23:00:00','10:00:00','10:45:00','10:55:00','11:40:00','12:00:00');
/*!40000 ALTER TABLE `coursetimetable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-08 20:56:31
