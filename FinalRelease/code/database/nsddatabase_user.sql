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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `is_first_login` bit(1) DEFAULT NULL,
  `user_gender` bit(1) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  `user_location` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (_binary '\0',_binary '',NULL,'20040430','lin0001','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0002','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0003','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0004','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0005','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0006','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0007','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0008','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0009','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0010','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0011','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0012','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0013','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0014','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0015','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0016','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0017','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0018','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0019','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0020','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0021','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0022','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0023','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0024','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0025','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0026','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0027','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0028','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0029','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0030','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0031','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0032','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0033','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0034','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0035','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0036','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0037','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0038','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0039','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0040','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0041','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0042','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0043','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0044','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0045','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0046','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0047','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0048','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0049','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0050','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0051','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0052','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0053','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0054','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0055','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0056','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0057','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0058','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0059','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0060','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0061','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0062','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0063','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0064','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0065','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0066','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0067','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0068','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0069','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0070','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0071','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0072','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0073','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0074','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0075','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0076','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0077','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0078','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0079','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0080','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0081','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0082','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0083','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0084','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0085','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0086','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0087','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0088','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0089','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0090','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0091','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0092','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0093','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0094','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0095','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0096','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0097','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0098','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0099','China','新用户'),(_binary '\0',_binary '',NULL,'20040430','lin0100','China','新用户');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-20 12:03:29
