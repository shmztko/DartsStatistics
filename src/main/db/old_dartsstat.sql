-- MySQL dump 10.13  Distrib 5.1.66, for redhat-linux-gnu (x86_64)
--
-- Host: localhost    Database: dartsstat
-- ------------------------------------------------------
-- Server version	5.1.66

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
-- Table structure for table `statistic`
--

DROP TABLE IF EXISTS `statistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_format` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `game_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `score` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `played_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `number_of_players` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `game_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_statistic_user_id` (`user_id`),
  CONSTRAINT `fk_statistic_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistic`
--

LOCK TABLES `statistic` WRITE;
/*!40000 ALTER TABLE `statistic` DISABLE KEYS */;
INSERT INTO `statistic` VALUES (1,'singles','701','119.00','2013-01-02 15:00:00',2,1,0),(2,'singles','701','85.80','2013-01-02 15:00:00',2,1,1),(3,'doubles','701','49.33','2013-01-02 15:00:00',2,1,2),(4,'doubles','701','103.25','2013-01-02 15:00:00',2,1,3),(5,'singles','1101','99.22','2013-01-02 15:00:00',2,1,0),(6,'singles','1101','80.33','2013-01-02 15:00:00',2,1,1),(7,'doubles','STANDARD CRICKET','2.70','2013-01-02 15:00:00',2,1,0),(8,'doubles','STANDARD CRICKET','4.17','2013-01-02 15:00:00',2,1,1),(9,'doubles','STANDARD CRICKET','3.00','2013-01-02 15:00:00',2,1,2),(10,'singles','701','107.83','2013-01-04 15:00:00',2,1,0),(11,'singles','701','84.17','2013-01-04 15:00:00',2,1,1),(12,'singles','701','85.00','2013-01-04 15:00:00',2,1,2),(13,'singles','701','83.14','2013-01-04 15:00:00',2,1,3),(14,'singles','701','64.17','2013-01-04 15:00:00',2,1,4),(15,'singles','701','91.17','2013-01-04 15:00:00',2,1,5),(16,'singles','701','82.14','2013-01-04 15:00:00',2,1,6),(17,'singles','701','88.86','2013-01-04 15:00:00',2,1,7),(18,'singles','701','70.80','2013-01-04 15:00:00',2,1,8),(19,'singles','701','94.33','2013-01-04 15:00:00',2,1,9),(20,'singles','701','95.50','2013-01-04 15:00:00',2,1,10),(21,'singles','701','65.00','2013-01-04 15:00:00',2,1,11),(22,'singles','701','95.83','2013-01-04 15:00:00',2,1,12),(23,'singles','701','72.25','2013-01-04 15:00:00',2,1,13),(24,'singles','701','80.86','2013-01-04 15:00:00',2,1,14),(25,'singles','701','85.67','2013-01-04 15:00:00',2,1,15),(26,'singles','701','99.75','2013-01-04 15:00:00',2,1,16),(27,'singles','701','90.14','2013-01-04 15:00:00',2,1,17),(28,'singles','701','90.71','2013-01-04 15:00:00',2,1,18),(29,'singles','1501','71.60','2013-01-04 15:00:00',1,1,0),(30,'singles','STANDARD CRICKET','3.29','2013-01-04 15:00:00',2,1,0),(31,'singles','STANDARD CRICKET','3.20','2013-01-04 15:00:00',2,1,1),(32,'singles','STANDARD CRICKET','3.50','2013-01-04 15:00:00',2,1,2),(33,'singles','STANDARD CRICKET','2.14','2013-01-04 15:00:00',2,1,3),(34,'singles','STANDARD CRICKET','3.31','2013-01-04 15:00:00',2,1,4),(35,'singles','STANDARD CRICKET','2.67','2013-01-04 15:00:00',2,1,5),(36,'singles','COUNT-UP','765','2013-01-04 15:00:00',1,1,0),(37,'singles','COUNT-UP','825','2013-01-04 15:00:00',1,1,1),(38,'singles','COUNT-UP','780','2013-01-04 15:00:00',1,1,2),(39,'singles','CRICKET COUNT-UP','632','2013-01-04 15:00:00',1,1,0);
/*!40000 ALTER TABLE `statistic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `login_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'???????','st0098@gmail.com','http://card.dartslive.com/t/top.jsp?i=559300205543375&n=2124119876');
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

-- Dump completed on 2013-01-06 13:52:51
