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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `event_id` int NOT NULL AUTO_INCREMENT,
  `eventtable_id` int DEFAULT NULL,
  `is_important` bit(1) DEFAULT NULL,
  `type` bit(1) DEFAULT NULL,
  `course_code` varchar(255) DEFAULT NULL,
  `event_location` varchar(255) DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `week` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `FKn9qtocru5nui6pghig016qcsj` (`eventtable_id`),
  CONSTRAINT `FKn9qtocru5nui6pghig016qcsj` FOREIGN KEY (`eventtable_id`) REFERENCES `eventtable` (`tableid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,1,_binary '\0',_binary '\0','MU903',' 下院206','世界民族音乐鉴赏','','11111111111111110000'),(2,1,_binary '\0',_binary '\0','SE2321',' 上院213','互联网应用开发技术','','10101010101010100000'),(3,1,_binary '\0',_binary '\0','SE2321',' 上院213','互联网应用开发技术','','10101010101010100000'),(4,1,_binary '\0',_binary '\0','SE2322',' 上院317','高级数据结构','','01010101010101010000'),(5,1,_binary '\0',_binary '\0','SE2322',' 上院317','高级数据结构','','01010101010101010000'),(6,1,_binary '\0',_binary '\0','SE2302',' 上院213','计算机系统基础（2）','','11111111111111110000'),(7,1,_binary '\0',_binary '\0','SE2302',' 上院213','计算机系统基础（2）','','11111111111111110000'),(8,1,_binary '\0',_binary '\0','SE2302',' 上院213','计算机系统基础（2）','','11111111111111110000'),(9,1,_binary '\0',_binary '\0','SE2324',' 不排教室 上院318','计算机科学的数学基础','','11111111111111110000'),(10,1,_binary '\0',_binary '\0','SE2324',' 不排教室 上院318','计算机科学的数学基础','','11111111111111110000'),(11,1,_binary '\0',_binary '\0','SE3330',' 上院112','软件工程原理与实践','','01010101010101010000'),(12,1,_binary '\0',_binary '\0','SE3330',' 上院112','软件工程原理与实践','','01010101010101010000'),(13,1,_binary '\0',_binary '\0','ART1007',' .','美育实践','','11111111111111110000'),(14,1,_binary '\0',_binary '\0','MARX1205',' 中院112','形势与政策','','00100010001000100000'),(15,1,_binary '\0',_binary '\0','PE004C01',' 东区东转篮球场','篮球','','11111111111111110000'),(16,1,_binary '\0',_binary '\0','PHY1253',' 上院315 上院317','大学物理(A类）（3）','','11111111111011110000'),(17,1,_binary '\0',_binary '\0','PHY1253',' 上院315 上院317','大学物理(A类）（3）','','11111111111011110000'),(18,1,_binary '\0',_binary '\0','MARX1204',' 下院312','马克思主义基本原理','','11111111111111110000');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
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
