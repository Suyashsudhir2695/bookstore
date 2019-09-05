-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `type` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','password','administrator'),('gh','123','administrator'),('Rajaram','12345','Standard'),('student','123','standard');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(75) DEFAULT NULL,
  `author` varchar(75) DEFAULT NULL,
  `publisher` varchar(75) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `image` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'The Kite Runner','Khaled Hosseini','Bloomsburry',499,2003,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(2,'The Alchemist','Paulo Coelho','HarperCollins',499,1998,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(3,'To Kill a Mockingbird','Harper Lee','J.B. Lippincott',399,1960,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(5,'Who Will Cry When You Die?','Robin Sharma','Jaico Publishing House',175,2006,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(6,'Wings of Fire','A.P.J Abdul Kalam','Universities Press',350,1999,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(7,'The Monk Who Sold His Ferrari','Robin Sharma','Jaico Publishing House',199,2003,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(8,'One Indian Girl','Chetan Bhagat','Rupa Publications India',176,2016,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(9,'Sherlock Holmes','Arthur Conan Doyle','Amazing Reads',350,2015,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(11,'Steve Jobs','Walter Issacson','Brown Book Group',550,2015,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(12,'Swami Vivekanand','Swami Vivekanand','Pigeon Books',91,2015,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(13,'Elon Musk','Ashlee Vance','Virgin Books ',699,2015,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(14,'Indias Most Fearless: True Stories of Modern Military Heroes','Shiv Aroor','Panguin Random House India',250,2017,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(15,'The Story of My Life','Helen Keller','General Press',145,2017,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(16,'The Theory Of Everything','Stephen Hawking','Jaico Publishing House ',199,2006,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(17,'My Journey','A.P.J Abdul Kalam','Rupa Publications India ',195,2013,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(18,'Albert Einstein: A Biography','Alice Calaprice','Jaico Publishing House',299,2012,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(19,'Playing It My Way','Sachin Tendulkar','Hodder & Stoughton',499,2015,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(20,'13 Reasons Why','Jay Asher','Razorbill',375,2017,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(21,'Milk And Honey','Rupi Kaur','Simon & Schuster',499,2015,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(22,'Five Point Someone','Chetan Bhagat','Rupa Publications India',176,2004,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(23,'The Immortals of Meluha','Amish','Westland',165,2010,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(27,'Suyash','Sudhir','Anmol',599,2019,'https://images.pexels.com/photos/590493/pexels-photo-590493.jpeg'),(28,'Suyash Sudhir','Auth','Pub',12,1965,'https://www.gutenberg.org/cache/epub/60191/pg60191.cover.medium.jpg');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `productid` int(11) NOT NULL,
  `producname` varchar(100) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `image` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`,`username`,`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issue` (
  `issueId` int(11) NOT NULL,
  `membership_no` int(11) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  `issueDate` date DEFAULT NULL,
  PRIMARY KEY (`issueId`),
  KEY `membership_no` (`membership_no`),
  KEY `bookId` (`bookId`),
  CONSTRAINT `issue_ibfk_1` FOREIGN KEY (`membership_no`) REFERENCES `membership` (`membership_no`),
  CONSTRAINT `issue_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `membership` (
  `membership_no` int(11) NOT NULL,
  `stud_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`membership_no`),
  KEY `stud_id` (`stud_id`),
  CONSTRAINT `membership_ibfk_1` FOREIGN KEY (`stud_id`) REFERENCES `student` (`stud_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership`
--

LOCK TABLES `membership` WRITE;
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
INSERT INTO `membership` VALUES (401,201),(402,202),(403,203),(404,204),(405,205),(406,206),(407,207),(408,208),(409,209),(410,210);
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER'),(2,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `stud_id` int(11) NOT NULL,
  `stud_name` varchar(45) DEFAULT NULL,
  `sem` int(11) DEFAULT NULL,
  `dept` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`stud_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (201,'Shay',5,'Computer Science'),(202,'Edward',3,'Computer Science'),(203,'Jacob',7,'Computer Science'),(204,'Bayek',7,'Mechanical'),(205,'Franklin',5,'Electrical'),(206,'Ezio',7,'Mechanical'),(207,'Eve',7,'Civil'),(208,'Micheal',3,'Civil'),(209,'Trevor',7,'Aeronautical'),(210,'Steve',5,'Aeronautical');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `wallet` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'poi','$2a$10$XotCUE3VHp7CvenqWhGeOeNsFE/jdLLg0/7cfUe/YCV0Pc38QUSKS','Bangalore','1234','1000.0'),(2,'suyash','$2a$10$ITx5y4KHWXmbywVLHPrX5.YJoGHMRMuAWm9Hjdf7.T.z0kuu1mBAC','Bangalore','1234','500.00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-05 10:12:15
