-- MySQL dump 10.13  Distrib 8.0.29, for macos12 (x86_64)
--
-- Host: localhost    Database: employee_management_system
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `emp_health_insurance`
--

DROP TABLE IF EXISTS `emp_health_insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_health_insurance` (
  `emp_id` int NOT NULL,
  `health_ins_id` int NOT NULL,
  `health_ins_provider_id` int NOT NULL,
  `health_ins_start_date` datetime DEFAULT NULL,
  `health_ins_plan_name` varchar(255) DEFAULT NULL,
  `health_ins_comp_contribution` decimal(5,2) DEFAULT NULL,
  `health_ins_monthly_fee` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`emp_id`,`health_ins_id`,`health_ins_provider_id`),
  KEY `employees_fk_1_idx` (`emp_id`),
  CONSTRAINT `employees_fk_1` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `emp_health_insurance_health_ins_provider_id` int DEFAULT NULL,
  `emp_health_insurance_health_ins_id` int DEFAULT NULL,
  `emp_health_insurance_emp_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc8aiwm9fkjvhtxs0mljo4cnb8` (`emp_health_insurance_emp_id`,`emp_health_insurance_health_ins_id`,`emp_health_insurance_health_ins_provider_id`),
  CONSTRAINT `FKc8aiwm9fkjvhtxs0mljo4cnb8` FOREIGN KEY (`emp_health_insurance_emp_id`, `emp_health_insurance_health_ins_id`, `emp_health_insurance_health_ins_provider_id`) REFERENCES `emp_health_insurance` (`emp_id`, `health_ins_id`, `health_ins_provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-27 14:46:06
