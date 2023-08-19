CREATE DATABASE  IF NOT EXISTS `lifelinedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lifelinedb`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: lifelinedb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_Id` int NOT NULL AUTO_INCREMENT,
  `area` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `pincode` int NOT NULL,
  PRIMARY KEY (`address_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Sainagar','Pune','Maharashtra',21645),(2,'Vidyanagar','Karad','Maharashtra',86484),(3,'Deccan','Pune','Maharashtra',644834),(4,'Sambhajinagar','Nagar','Maharashtra',483435),(5,'Shivajinagar','Nagar','Maharashtra',35484),(8,'kothrud','pune','maha',35484),(9,'kothrud','pune','maha',35484),(11,'Gandhinagar','Kolhapur','Maharashtra',59632),(12,'Ulhasnagar','Mumbai','Maharashtra',452124),(13,'KarveNagar','Pune','Maharashtra',485691),(14,'KarveNagar','Pune','Maharashtra',484613),(15,'KarveNagar','Pune','Maharashtra',484613),(16,'KarveNagar','Pune','Maharashtra',484613),(17,'KarveNagar','Pune','Maharashtra',484613),(23,'Kothrud','Pune','Maharashtra',484651),(25,'Jijai Garden','Pune','Maharashtra',411050),(27,'Sainagar','Ravet','Maharashtra',456765),(28,'Sainagar','Ravet','Maharashtra',456765),(30,'dfg','Pune','Maharashtra',411014),(31,'Karvenagar','Pune','Maharashtra',411050),(33,'ShriRam Nagar','Pune','Maharashtra',485691),(36,'KarveNagar','Mumbai','Maharashtra',452124),(37,'Ulhasnagar','Mumbai','Maharashtra',452124),(38,'Ulhasnagar','Mumbai','Maharashtra',452124),(39,'pune','Pone','mah',411);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment_status`
--

DROP TABLE IF EXISTS `appointment_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment_status` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_status`
--

LOCK TABLES `appointment_status` WRITE;
/*!40000 ALTER TABLE `appointment_status` DISABLE KEYS */;
INSERT INTO `appointment_status` VALUES (1,'scheduled'),(2,'completed'),(3,'cancelled'),(4,'cancellation requested');
/*!40000 ALTER TABLE `appointment_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `app_id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `doctor_id` int NOT NULL,
  `patient_id` int NOT NULL,
  `slot` time NOT NULL,
  `prescription` blob,
  `status_id` int NOT NULL,
  PRIMARY KEY (`app_id`),
  KEY `doctor_id_idx` (`doctor_id`),
  KEY `patient_id_idx` (`patient_id`),
  KEY `status_id_idx` (`status_id`),
  CONSTRAINT `doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`doctor_id`),
  CONSTRAINT `patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`),
  CONSTRAINT `status_id` FOREIGN KEY (`status_id`) REFERENCES `appointment_status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (12,'2023-03-01',1,1,'11:30:00',NULL,3),(13,'2023-03-01',1,1,'11:00:00',NULL,3),(14,'2023-03-01',1,2,'10:30:00',NULL,4),(15,'2023-03-02',2,2,'11:30:00',NULL,3),(16,'2023-03-01',2,3,'11:30:00',NULL,1),(19,'2023-03-10',2,3,'15:30:00',NULL,1),(20,'2023-03-06',1,2,'14:00:00',NULL,3),(21,'2023-03-02',2,1,'13:00:00',NULL,1),(22,'2023-03-03',1,1,'15:00:00',NULL,1),(23,'2023-03-01',2,1,'10:30:00',NULL,1),(24,'2023-03-01',2,1,'12:30:00',NULL,3),(25,'2023-03-10',2,2,'17:30:00',NULL,4),(26,'2023-03-12',11,2,'10:30:00',NULL,1),(27,'2023-03-01',1,1,'09:00:00',NULL,1),(28,'2023-03-01',1,1,'09:30:00',NULL,1);
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `doctor_id` int NOT NULL AUTO_INCREMENT,
  `qualification` varchar(45) NOT NULL,
  `specialization` varchar(45) NOT NULL,
  `experience` int NOT NULL,
  `image` blob,
  `imr_no` int NOT NULL,
  `department` varchar(25) NOT NULL,
  `type` varchar(15) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`doctor_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `fkuser_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'MBBS','Homeopathy',7,NULL,33554,'Cardiology',NULL,2),(2,'BDS','Cardiology',4,NULL,22435,'Dentistry',NULL,3),(4,'BAMS','Neurology',2,NULL,11111,'Homeopathy','regular',7),(7,'MD','Cardiologist',0,NULL,71648,'Cardiology','Regular',11),(11,'abcd','xyz',0,NULL,0,'opthalmology','reg',32);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `birthdate` date NOT NULL,
  `blood_group` varchar(3) NOT NULL,
  `diabetes` varchar(3) NOT NULL,
  `blood_pressure` varchar(3) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id_UNIQUE` (`patient_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'1996-08-23','A+','yes','no',4),(2,'1998-05-16','O-','no','yes',5),(3,'2003-06-10','AB-','Yes','No',9),(7,'1998-01-11','B-','No','No',23),(14,'2005-06-22','AB-','No','No',31);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(45) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'What is your nickname ?'),(2,'What is your native place ?'),(3,'What is your favourite movie ? '),(4,'Who is your favourite actor ? '),(5,'What is your favourite color ? ');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reports` (
  `report_id` int NOT NULL AUTO_INCREMENT,
  `mrd` blob,
  `patient_id` int NOT NULL,
  PRIMARY KEY (`report_id`),
  KEY `patient_id_idx` (`patient_id`),
  CONSTRAINT `fkpatient_id` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (1,NULL,2),(2,NULL,1),(3,NULL,1),(4,NULL,1),(5,NULL,2);
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(12) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_id_UNIQUE` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Admin'),(2,'Doctor'),(3,'Patient');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedules` (
  `doctor_id` int NOT NULL,
  `date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  PRIMARY KEY (`doctor_id`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,'2023-03-01','09:00:00','12:00:00'),(1,'2023-03-03','14:00:00','17:00:00'),(1,'2023-03-06','13:30:00','17:30:00'),(2,'2023-03-01','10:00:00','13:00:00'),(2,'2023-03-02','11:00:00','14:00:00'),(2,'2023-03-10','14:00:00','18:00:00'),(11,'2023-03-12','09:00:00','03:00:00');
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(15) NOT NULL,
  `lname` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(50) NOT NULL,
  `contact_no` varchar(10) DEFAULT NULL,
  `gender` varchar(7) NOT NULL,
  `address_id` int NOT NULL,
  `role_id` int NOT NULL,
  `question_id` int NOT NULL,
  `answer` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `contact_no_UNIQUE` (`contact_no`),
  KEY `role_id_idx` (`role_id`),
  KEY `address_id_idx` (`address_id`),
  KEY `question_id_idx` (`question_id`),
  CONSTRAINT `address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `question_id` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Amrendra','Bahubali','admin@gmail.com','ggZ3rTDC5QTv55MRs1VUdW5j8n4lnapfYYb2cs0oHzA=','995699699','male',1,1,1,'Kattappa'),(2,'Vijay','Yadav','vijay@gmail.com','dLakjY3KsKTtWKy5YdWIV5ldNuBNHuWo6qiLdgDQyq0=','1236547898','male',2,2,5,'blue'),(3,'Anuradha','Date','anu@gmail.com','dowRffiGhX9wK0l9sEmWWgkgLkVByKY89pnfriHZv5k=','3846814684','female',3,2,3,'RRR'),(4,'Yuvraj','Bhade','yuvraj@gmail.com','gyiZwbM22V51XPzDj5b+YOUk+vSQYeRln75bYV3GJsg=','6748468465','male',4,3,4,'Anushka Sharma'),(5,'Onkar','Rokade','onkar@gmail.com','lDkHl/tgovX+/3VTS7djjb+JHwKqKjsNlSFonGdk7+A=','3458464868','male',5,3,2,'Nagar'),(7,'Shrey','Kumbhar','jay@gmail.com','H0OiZgm7ZZIEEBEthEyFqeYqfFTAE1zwO25BDaTwoHE=','123456789','male',9,2,3,'bahubali'),(9,'Robert','Anderson','robert@gmail.com','qlno+MTXAicvKhy/ljuAum9izFgXpYt1U9RrFzci7t8=','987456325','Male',12,3,2,'Khandala'),(10,'Mahesh','Vetal','mahesh@gmail.com','w7IfdrclNb1m0wgA0I5mWwvbq/QfiXf4tJKHZyyGEAY=','985632147','Male',13,2,1,'mahi'),(11,'Sourabh','Sawant','sourabh@gmail.com','SnB1PuBxfSHPCnglWqH/PO+LiTIeCXK3aQB04tAQ7pA=','9764341673','Male',14,2,1,'master'),(23,'Gaurav','Deshpande','gaurav@gmail.com','zrB3/TBZSV/BHzarZIgESMURVTvz0hU09hZ0MQMlmiI=','4567876543','Male',28,3,5,'Red'),(27,'Vijay','Kulkarni','vijay9975050075@gmail.com','dLakjY3KsKTtWKy5YdWIV5ldNuBNHuWo6qiLdgDQyq0=','4567898765','Male',33,3,2,'Karad'),(31,'Dummy','Patient','onlinelifelinehospital@gmail.com','wkH//6DwoNk5+Hkk8RL9hJbOkRE/q3Zu3UuJQMiuccE=','1234567874','Female',38,3,1,'dumb'),(32,'Bakul','Joshi','bakul@gmail.com','EY4gbz+V1Ye1N4wyXMhJbAipuiNyD5mr+GfUWjT2w5Y=','4575784512','Female',39,2,5,'Red');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-19 14:31:33
