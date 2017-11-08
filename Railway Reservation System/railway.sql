-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: railway
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `ticket_no` int(11) NOT NULL,
  `pno` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticket_no`),
  KEY `pno` (`pno`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`pno`) REFERENCES `p_info` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (301,201),(302,202);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_info`
--

DROP TABLE IF EXISTS `book_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_info` (
  `ticketno` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticketno`),
  KEY `pid` (`pid`),
  CONSTRAINT `book_info_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `passenger_info` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_info`
--

LOCK TABLES `book_info` WRITE;
/*!40000 ALTER TABLE `book_info` DISABLE KEYS */;
INSERT INTO `book_info` VALUES (1,501),(2,502),(20,502),(21,502),(18,503),(4,504),(13,505),(6,506),(9,520),(17,520),(16,540),(7,560),(12,560),(8,600),(11,620),(10,650);
/*!40000 ALTER TABLE `book_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_information`
--

DROP TABLE IF EXISTS `book_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_information` (
  `t_no` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_no`),
  UNIQUE KEY `pid` (`pid`),
  CONSTRAINT `book_information_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `passenger_info` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_information`
--

LOCK TABLES `book_information` WRITE;
/*!40000 ALTER TABLE `book_information` DISABLE KEYS */;
INSERT INTO `book_information` VALUES (1,501),(10,652);
/*!40000 ALTER TABLE `book_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_information1`
--

DROP TABLE IF EXISTS `book_information1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_information1` (
  `t_no` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_no`),
  UNIQUE KEY `pid` (`pid`),
  CONSTRAINT `book_information1_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `passenger_info1` (`pid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_information1`
--

LOCK TABLES `book_information1` WRITE;
/*!40000 ALTER TABLE `book_information1` DISABLE KEYS */;
INSERT INTO `book_information1` VALUES (1,501),(8,502),(9,503),(10,504),(22,520);
/*!40000 ALTER TABLE `book_information1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `ticket_no` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `pname` varchar(20) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ticket_no`),
  KEY `tid` (`tid`),
  KEY `fid` (`fid`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `tdetails` (`tid`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`fid`) REFERENCES `fare` (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (201,1,101,'kunal',20,'male');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `display`
--

DROP TABLE IF EXISTS `display`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `display` (
  `ticket_no` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticket_no`),
  UNIQUE KEY `pid` (`pid`),
  CONSTRAINT `display_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `p_info` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `display`
--

LOCK TABLES `display` WRITE;
/*!40000 ALTER TABLE `display` DISABLE KEYS */;
INSERT INTO `display` VALUES (301,201),(302,202);
/*!40000 ALTER TABLE `display` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `display1`
--

DROP TABLE IF EXISTS `display1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `display1` (
  `ticket_no` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticket_no`),
  KEY `pid` (`pid`),
  CONSTRAINT `display1_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `p_info` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `display1`
--

LOCK TABLES `display1` WRITE;
/*!40000 ALTER TABLE `display1` DISABLE KEYS */;
INSERT INTO `display1` VALUES (301,201),(302,202);
/*!40000 ALTER TABLE `display1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fare`
--

DROP TABLE IF EXISTS `fare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fare` (
  `fid` int(11) NOT NULL,
  `trid` int(11) DEFAULT NULL,
  `slclass` varchar(10) DEFAULT NULL,
  `fsclass` varchar(10) DEFAULT NULL,
  `2_tierac` varchar(10) DEFAULT NULL,
  `3_tierac` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `trid` (`trid`),
  CONSTRAINT `fare_ibfk_1` FOREIGN KEY (`trid`) REFERENCES `tdetails` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fare`
--

LOCK TABLES `fare` WRITE;
/*!40000 ALTER TABLE `fare` DISABLE KEYS */;
INSERT INTO `fare` VALUES (101,1,'rs. 800','rs. 3500','rs. 2800','rs. 2200'),(102,2,'rs. 800','rs. 3500','rs. 2800','rs. 2200');
/*!40000 ALTER TABLE `fare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fare_info`
--

DROP TABLE IF EXISTS `fare_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fare_info` (
  `fid` int(11) NOT NULL,
  `tid` int(11) DEFAULT NULL,
  `class` varchar(10) DEFAULT NULL,
  `fare` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `tid` (`tid`),
  CONSTRAINT `fare_info_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `tdetails` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fare_info`
--

LOCK TABLES `fare_info` WRITE;
/*!40000 ALTER TABLE `fare_info` DISABLE KEYS */;
INSERT INTO `fare_info` VALUES (101,1,'sleeper','rs 1500'),(102,1,'firstac','rs 3500'),(103,1,'2tierac','rs 3000'),(104,1,'3tierac','rs 2500');
/*!40000 ALTER TABLE `fare_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `p_info`
--

DROP TABLE IF EXISTS `p_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `p_info` (
  `pid` int(11) NOT NULL,
  `pname` varchar(20) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `fid` (`fid`),
  KEY `tid` (`tid`),
  CONSTRAINT `p_info_ibfk_1` FOREIGN KEY (`fid`) REFERENCES `fare_info` (`fid`),
  CONSTRAINT `p_info_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `tdetails` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `p_info`
--

LOCK TABLES `p_info` WRITE;
/*!40000 ALTER TABLE `p_info` DISABLE KEYS */;
INSERT INTO `p_info` VALUES (201,'ash','548569',21,'m',101,1),(202,'brock','djgk',21,'m',101,1);
/*!40000 ALTER TABLE `p_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger_info`
--

DROP TABLE IF EXISTS `passenger_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger_info` (
  `pid` int(11) NOT NULL,
  `pname` varchar(20) DEFAULT NULL,
  `phone` int(12) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `sno` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `sno` (`sno`),
  CONSTRAINT `passenger_info_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `train_info` (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger_info`
--

LOCK TABLES `passenger_info` WRITE;
/*!40000 ALTER TABLE `passenger_info` DISABLE KEYS */;
INSERT INTO `passenger_info` VALUES (501,'ash',95749363,21,'male',1),(502,'brock',95749364,21,'male',1),(503,'tyson',95749365,21,'male',2),(504,'thaichi',95749366,21,'male',4),(505,'richie',98574839,21,'male',14),(506,'dawn',98573466,21,'female',10),(507,'gingka',96757594,21,'male',16),(510,'prithvi',96847494,22,'male',4),(520,'lalwani',95847474,20,'male',14),(540,'kunal',96847494,21,'male',2),(560,'kunal',98584948,21,'male',10),(600,'harshit',97868576,21,'male',10),(620,'may',98763426,21,'female',4),(650,'cheren',98765465,21,'male',2),(652,'rahul',98675467,21,'male',10),(670,'kunal',98768765,21,'male',10);
/*!40000 ALTER TABLE `passenger_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger_info1`
--

DROP TABLE IF EXISTS `passenger_info1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger_info1` (
  `pid` int(11) NOT NULL,
  `pname` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `age` int(3) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `sno` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `phone` (`phone`),
  KEY `sno` (`sno`),
  CONSTRAINT `passenger_info1_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `train_info` (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger_info1`
--

LOCK TABLES `passenger_info1` WRITE;
/*!40000 ALTER TABLE `passenger_info1` DISABLE KEYS */;
INSERT INTO `passenger_info1` VALUES (501,'ash','9867587564',21,'male',1),(502,'brock','9857685774',21,'male',2),(503,'may','9857685764',21,'female',6),(504,'max','9857685765',18,'male',6),(520,'kunal','8797696769',21,'male',1);
/*!40000 ALTER TABLE `passenger_info1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tdetails`
--

DROP TABLE IF EXISTS `tdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdetails` (
  `tid` int(11) NOT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `torigin` varchar(20) DEFAULT NULL,
  `tdest` varchar(20) DEFAULT NULL,
  `depart` varchar(10) DEFAULT NULL,
  `arrive` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tdetails`
--

LOCK TABLES `tdetails` WRITE;
/*!40000 ALTER TABLE `tdetails` DISABLE KEYS */;
INSERT INTO `tdetails` VALUES (1,'rajdhani','delhi','mumbai','9 pm','10 am'),(2,'rajdhani','mumbai','delhi','10 am','9 pm');
/*!40000 ALTER TABLE `tdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_info`
--

DROP TABLE IF EXISTS `train_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_info` (
  `sno` int(11) NOT NULL,
  `tno` int(11) DEFAULT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `sourcestn` varchar(20) DEFAULT NULL,
  `deststn` varchar(20) DEFAULT NULL,
  `depart` varchar(10) DEFAULT NULL,
  `arrive` varchar(10) DEFAULT NULL,
  `class` varchar(10) DEFAULT NULL,
  `fare_in_rs` int(11) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_info`
--

LOCK TABLES `train_info` WRITE;
/*!40000 ALTER TABLE `train_info` DISABLE KEYS */;
INSERT INTO `train_info` VALUES (1,101,'rajdhani','delhi','mumbai','4 pm','10 am','firstac',3500),(2,101,'rajdhani','delhi','mumbai','4 pm','10 am','sleeper',1500),(3,101,'rajdhani','delhi','mumbai','4 pm','10 am','2tierac',3000),(4,101,'rajdhani','delhi','mumbai','4 pm','10 am','3tierac',2500),(5,102,'shatabdi','delhi','ajmer','7 am','2 pm','firstac',2000),(6,102,'shatabdi','delhi','ajmer','7 am','2 pm','sleeper',800),(7,102,'shatabdi','delhi','ajmer','7 am','2 pm','2tierac',1500),(8,102,'shatabdi','delhi','ajmer','7 am','2 pm','3tierac',1200),(9,103,'rajdhani','delhi','banglore','7 am','11 pm','firstac',5000),(10,103,'rajdhani','delhi','banglore','7 am','11 pm','sleeper',2500),(11,103,'rajdhani','delhi','banglore','7 am','11 pm','2tierac',4000),(12,103,'rajdhani','delhi','banglore','7 am','11 pm','3tierac',3200),(13,104,'shatabdi','delhi','amritsar','4 pm','9 pm','firstac',1500),(14,104,'shatabdi','delhi','amritsar','4 pm','9 pm','sleeper',500),(15,104,'shatabdi','delhi','amritsar','4 pm','9 pm','2tierac',1200),(16,104,'shatabdi','delhi','amritsar','4 pm','9 pm','3tierac',1000);
/*!40000 ALTER TABLE `train_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-01 13:21:29
