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
-- Table structure for table `eventtime`
--

DROP TABLE IF EXISTS `eventtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventtime` (
  `date` int DEFAULT NULL,
  `endtime_number` int DEFAULT NULL,
  `event_id` int DEFAULT NULL,
  `eventtime_id` int NOT NULL AUTO_INCREMENT,
  `starttime_number` int DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eventtime_id`),
  KEY `FKfbt049ghmjsv7cu80area2vgk` (`event_id`),
  CONSTRAINT `FKfbt049ghmjsv7cu80area2vgk` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventtime`
--

LOCK TABLES `eventtime` WRITE;
/*!40000 ALTER TABLE `eventtime` DISABLE KEYS */;
INSERT INTO `eventtime` VALUES (0,9,1,1,8,'16:45:00','14:55:00'),(3,3,2,2,2,'10:45:00','08:55:00'),(3,3,2,3,2,'10:45:00','08:55:00'),(3,3,3,4,2,'10:45:00','08:55:00'),(3,3,3,5,2,'10:45:00','08:55:00'),(3,3,4,6,2,'10:45:00','08:55:00'),(3,3,4,7,2,'10:45:00','08:55:00'),(3,3,5,8,2,'10:45:00','08:55:00'),(3,3,5,9,2,'10:45:00','08:55:00'),(0,3,6,10,2,'10:45:00','08:55:00'),(0,3,6,11,2,'10:45:00','08:55:00'),(0,3,6,12,2,'10:45:00','08:55:00'),(0,3,7,13,2,'10:45:00','08:55:00'),(0,3,7,14,2,'10:45:00','08:55:00'),(0,3,7,15,2,'10:45:00','08:55:00'),(0,3,8,16,2,'10:45:00','08:55:00'),(0,3,8,17,2,'10:45:00','08:55:00'),(0,3,8,18,2,'10:45:00','08:55:00'),(0,7,9,19,6,'14:45:00','12:55:00'),(0,7,9,20,6,'14:45:00','12:55:00'),(0,7,10,21,6,'14:45:00','12:55:00'),(0,7,10,22,6,'14:45:00','12:55:00'),(3,1,11,23,0,'08:45:00',NULL),(3,1,11,24,0,'08:45:00',NULL),(3,1,12,25,0,'08:45:00',NULL),(3,1,12,26,0,'08:45:00',NULL),(5,5,13,27,4,'12:45:00','10:55:00'),(2,9,14,28,8,'16:45:00','14:55:00'),(1,9,15,29,8,'16:45:00','14:55:00'),(4,9,16,30,8,'16:45:00','14:55:00'),(4,9,16,31,8,'16:45:00','14:55:00'),(4,9,17,32,8,'16:45:00','14:55:00'),(4,9,17,33,8,'16:45:00','14:55:00'),(4,7,18,34,5,'14:45:00','12:00:00');
/*!40000 ALTER TABLE `eventtime` ENABLE KEYS */;
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
