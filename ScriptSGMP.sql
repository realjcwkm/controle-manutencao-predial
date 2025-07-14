CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `ativos`
--

DROP TABLE IF EXISTS `ativos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ativos` (
  `id_ativos` int NOT NULL AUTO_INCREMENT,
  `modelo_ativo` varchar(45) NOT NULL,
  `ultima_manutencao` date DEFAULT NULL,
  `data_instalacao` date DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `local_id_local` int NOT NULL,
  `tipo_ativo_id_tipo_ativo` int NOT NULL,
  `periodicidade_id_periodicidade` int NOT NULL,
  PRIMARY KEY (`id_ativos`),
  KEY `fk_ativos_local1_idx` (`local_id_local`),
  KEY `fk_ativos_tipo_ativo1_idx` (`tipo_ativo_id_tipo_ativo`),
  KEY `fk_ativos_periodicidade1_idx` (`periodicidade_id_periodicidade`),
  CONSTRAINT `fk_ativos_local1` FOREIGN KEY (`local_id_local`) REFERENCES `local` (`id_local`),
  CONSTRAINT `fk_ativos_periodicidade1` FOREIGN KEY (`periodicidade_id_periodicidade`) REFERENCES `periodicidade` (`id_periodicidade`),
  CONSTRAINT `fk_ativos_tipo_ativo1` FOREIGN KEY (`tipo_ativo_id_tipo_ativo`) REFERENCES `tipo_ativo` (`id_tipo_ativo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ativos`
--

LOCK TABLES `ativos` WRITE;
/*!40000 ALTER TABLE `ativos` DISABLE KEYS */;
/*!40000 ALTER TABLE `ativos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `id_local` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_local`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'área interna'),(2,'área externa');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `id_log` int NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `tipo_log_id_tipo_log` int NOT NULL,
  `usuario_id_usuario` int NOT NULL,
  `ordem_servico_id_ordem_servico` int DEFAULT NULL,
  `manutencao_id_manutencao` int DEFAULT NULL,
  PRIMARY KEY (`id_log`),
  KEY `fk_log_tipo_log1_idx` (`tipo_log_id_tipo_log`),
  KEY `fk_log_usuario1_idx` (`usuario_id_usuario`),
  KEY `fk_log_ordem_servico1_idx` (`ordem_servico_id_ordem_servico`),
  KEY `fk_log_manutencao1_idx` (`manutencao_id_manutencao`),
  CONSTRAINT `fk_log_manutencao1` FOREIGN KEY (`manutencao_id_manutencao`) REFERENCES `manutencao` (`id_manutencao`),
  CONSTRAINT `fk_log_ordem_servico1` FOREIGN KEY (`ordem_servico_id_ordem_servico`) REFERENCES `ordem_servico` (`id_ordem_servico`),
  CONSTRAINT `fk_log_tipo_log1` FOREIGN KEY (`tipo_log_id_tipo_log`) REFERENCES `tipo_log` (`id_tipo_log`),
  CONSTRAINT `fk_log_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manutencao`
--

DROP TABLE IF EXISTS `manutencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manutencao` (
  `id_manutencao` int NOT NULL AUTO_INCREMENT,
  `tipo_manutencao` enum('Preditiva','Preventiva','Corretiva') NOT NULL,
  `ordem_servico_id_ordem_servico` int NOT NULL,
  `local_id_local` int NOT NULL,
  `periodicidade_id_periodicidade` int NOT NULL,
  PRIMARY KEY (`id_manutencao`),
  KEY `fk_manutencao_ordem_servico1_idx` (`ordem_servico_id_ordem_servico`),
  KEY `fk_manutencao_local1_idx` (`local_id_local`),
  KEY `fk_manutencao_periodicidade1_idx` (`periodicidade_id_periodicidade`),
  CONSTRAINT `fk_manutencao_local1` FOREIGN KEY (`local_id_local`) REFERENCES `local` (`id_local`),
  CONSTRAINT `fk_manutencao_ordem_servico1` FOREIGN KEY (`ordem_servico_id_ordem_servico`) REFERENCES `ordem_servico` (`id_ordem_servico`),
  CONSTRAINT `fk_manutencao_periodicidade1` FOREIGN KEY (`periodicidade_id_periodicidade`) REFERENCES `periodicidade` (`id_periodicidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manutencao`
--

LOCK TABLES `manutencao` WRITE;
/*!40000 ALTER TABLE `manutencao` DISABLE KEYS */;
/*!40000 ALTER TABLE `manutencao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordem_servico`
--

DROP TABLE IF EXISTS `ordem_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordem_servico` (
  `id_ordem_servico` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `tecnico` int NOT NULL,
  `prazo` date NOT NULL,
  `urgencia` enum('baixa','média','alta') NOT NULL,
  `status` varchar(45) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `local_id_local` int NOT NULL,
  PRIMARY KEY (`id_ordem_servico`),
  KEY `tecnico_idx` (`tecnico`),
  KEY `fk_ordem_servico_local1_idx` (`local_id_local`),
  CONSTRAINT `fk_ordem_servico_local1` FOREIGN KEY (`local_id_local`) REFERENCES `local` (`id_local`),
  CONSTRAINT `tecnico` FOREIGN KEY (`tecnico`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_servico`
--

LOCK TABLES `ordem_servico` WRITE;
/*!40000 ALTER TABLE `ordem_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordem_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodicidade`
--

DROP TABLE IF EXISTS `periodicidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodicidade` (
  `id_periodicidade` int NOT NULL AUTO_INCREMENT,
  `tipo_periodicidade` varchar(45) NOT NULL,
  PRIMARY KEY (`id_periodicidade`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodicidade`
--

LOCK TABLES `periodicidade` WRITE;
/*!40000 ALTER TABLE `periodicidade` DISABLE KEYS */;
INSERT INTO `periodicidade` VALUES (1,'diária'),(2,'semanal'),(3,'mensal'),(4,'bimestral'),(5,'semestral'),(6,'anual');
/*!40000 ALTER TABLE `periodicidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_ativo`
--

DROP TABLE IF EXISTS `tipo_ativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_ativo` (
  `id_tipo_ativo` int NOT NULL AUTO_INCREMENT,
  `nome_tipo_ativo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_ativo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_ativo`
--

LOCK TABLES `tipo_ativo` WRITE;
/*!40000 ALTER TABLE `tipo_ativo` DISABLE KEYS */;
INSERT INTO `tipo_ativo` VALUES (1,'equipamento'),(2,'infraestrutura'),(3,'instalação');
/*!40000 ALTER TABLE `tipo_ativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_log`
--

DROP TABLE IF EXISTS `tipo_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_log` (
  `id_tipo_log` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_log`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_log`
--

LOCK TABLES `tipo_log` WRITE;
/*!40000 ALTER TABLE `tipo_log` DISABLE KEYS */;
INSERT INTO `tipo_log` VALUES (1,'insert');
/*!40000 ALTER TABLE `tipo_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int NOT NULL AUTO_INCREMENT,
  `tipo_usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'visitante');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(60) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `tipo` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `tipo_idx` (`tipo`),
  CONSTRAINT `tipo` FOREIGN KEY (`tipo`) REFERENCES `tipo_usuario` (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'admin','admin','admin',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-13 17:04:16
