-- MySQL dump 10.13  Distrib 5.5.14, for Win32 (x86)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.5.14

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
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acceso` (
  `cod_men` int(11) NOT NULL,
  `cod_tra` int(11) NOT NULL DEFAULT '0',
  `cod_univ` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`cod_men`,`cod_tra`,`cod_univ`),
  KEY `cod_men` (`cod_men`),
  KEY `cod_univ` (`cod_univ`),
  KEY `cod_tra` (`cod_tra`),
  CONSTRAINT `cod_men` FOREIGN KEY (`cod_men`) REFERENCES `menu` (`cod_men`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cod_tra` FOREIGN KEY (`cod_tra`) REFERENCES `trabajador` (`cod_tra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cod_univ` FOREIGN KEY (`cod_univ`) REFERENCES `universitario` (`cod_univ`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
INSERT INTO `acceso` VALUES (1,1,1),(2,1,1),(3,2,1),(4,3,1),(5,3,1);
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorizacion`
--

DROP TABLE IF EXISTS `categorizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorizacion` (
  `cod_cate` int(11) NOT NULL AUTO_INCREMENT,
  `num_solicitud` int(11) DEFAULT NULL,
  `monto_entrega` double DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_cate`),
  KEY `num_solicitud` (`num_solicitud`),
  CONSTRAINT `num_solicitud` FOREIGN KEY (`num_solicitud`) REFERENCES `solicitud_ae` (`num_solicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorizacion`
--

LOCK TABLES `categorizacion` WRITE;
/*!40000 ALTER TABLE `categorizacion` DISABLE KEYS */;
INSERT INTO `categorizacion` VALUES (1,1,4879.54,NULL,'aprobado'),(2,1,4576.98,NULL,'RECHAZADO'),(3,2,84899.8,NULL,'rechazado'),(4,1,5488.4,NULL,'pendiente'),(5,2,54896.9,NULL,'aprobado'),(10,1,0,'asdasd','APROBADO');
/*!40000 ALTER TABLE `categorizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `constancia`
--

DROP TABLE IF EXISTS `constancia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `constancia` (
  `cod_con` int(11) NOT NULL AUTO_INCREMENT,
  `cod_cate` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_con`),
  KEY `cod_cate` (`cod_cate`),
  CONSTRAINT `cod_cate` FOREIGN KEY (`cod_cate`) REFERENCES `categorizacion` (`cod_cate`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `constancia`
--

LOCK TABLES `constancia` WRITE;
/*!40000 ALTER TABLE `constancia` DISABLE KEYS */;
/*!40000 ALTER TABLE `constancia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_solicitud`
--

DROP TABLE IF EXISTS `detalle_solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_solicitud` (
  `idDetalle_Solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `num_Solicitud` int(11) DEFAULT NULL,
  `cod_req_anx` int(11) DEFAULT NULL,
  `imagen` text,
  PRIMARY KEY (`idDetalle_Solicitud`),
  KEY `detalle_solicitud` (`num_Solicitud`),
  KEY `detalle_requisito` (`cod_req_anx`),
  CONSTRAINT `detalle_requisito` FOREIGN KEY (`cod_req_anx`) REFERENCES `requisito` (`cod_req_anx`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `detalle_solicitud` FOREIGN KEY (`num_Solicitud`) REFERENCES `solicitud_ae` (`num_solicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_solicitud`
--

LOCK TABLES `detalle_solicitud` WRITE;
/*!40000 ALTER TABLE `detalle_solicitud` DISABLE KEYS */;
INSERT INTO `detalle_solicitud` VALUES (1,1,1,'hola'),(2,1,2,'hola');
/*!40000 ALTER TABLE `detalle_solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_tipo_anexo`
--

DROP TABLE IF EXISTS `detalle_tipo_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_tipo_anexo` (
  `cod_tip_sol` int(11) NOT NULL AUTO_INCREMENT,
  `cod_req_anx` int(11) NOT NULL,
  PRIMARY KEY (`cod_tip_sol`,`cod_req_anx`),
  KEY `cod_tip_sol` (`cod_tip_sol`),
  KEY `cod_req_anx` (`cod_req_anx`),
  CONSTRAINT `cod_req_anx` FOREIGN KEY (`cod_req_anx`) REFERENCES `requisito` (`cod_req_anx`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cod_tip_sol` FOREIGN KEY (`cod_tip_sol`) REFERENCES `tipo_solicitud` (`cod_tip_sol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_tipo_anexo`
--

LOCK TABLES `detalle_tipo_anexo` WRITE;
/*!40000 ALTER TABLE `detalle_tipo_anexo` DISABLE KEYS */;
INSERT INTO `detalle_tipo_anexo` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(2,1),(2,2),(2,4),(2,5),(2,6),(2,7),(3,1),(3,2),(3,4),(3,5),(3,8),(3,9),(4,1),(4,2),(4,4),(4,5),(4,7),(4,10),(5,1),(5,2),(5,4),(5,5),(5,11),(5,12),(6,1),(6,2),(6,4),(6,5),(6,13),(7,1),(7,2),(7,4),(7,5),(7,14);
/*!40000 ALTER TABLE `detalle_tipo_anexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `cod_men` int(11) NOT NULL,
  `des_men` varchar(50) DEFAULT NULL,
  `url_men` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_men`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Categorizacion por fechas','categorizacionPorFecha.jsp'),(2,'Solicitudes Aprobadas por fechas','solicitudPorFecha.jsp'),(3,'Registro de Solicitud','ModuloRegistroSolicitud'),(4,'Registrar Categorizacion','generarCategorizacion'),(5,'Listar Categorizacion x Solicitud','listarCategorizaciones.jsp');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisito`
--

DROP TABLE IF EXISTS `requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requisito` (
  `cod_req_anx` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `tipo` char(1) DEFAULT NULL,
  PRIMARY KEY (`cod_req_anx`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisito`
--

LOCK TABLES `requisito` WRITE;
/*!40000 ALTER TABLE `requisito` DISABLE KEYS */;
INSERT INTO `requisito` VALUES (1,'SOLICITUD AL RECTOR',NULL),(2,'RECIBO DE PAGO',NULL),(3,'RECETAS-FACTURAS',NULL),(4,'CONSTANCIA DE MATRICULA',NULL),(5,'COPIA DE DNI',NULL),(6,'PARTIDA DE NACIMIENTO DEL NIÑO',NULL),(7,'PARTIDA DE NACIMIENTO DEL ESTUDIANTE',NULL),(8,'RECETA DEL MÉDICO OFTALMOLÓGICO',NULL),(9,'PROFORMA DE 2 ÓPTICAS',NULL),(10,'PARTIDA DE DEFUNCIÓN',NULL),(11,'TRÍPTICO O INVITACIÓN DEL EVENTO',NULL),(12,'COPIA DE PONENCIA',NULL),(13,'DOCUMENTO DE FACULTAD',NULL),(14,'RECIBO DE GARANTÍA',NULL);
/*!40000 ALTER TABLE `requisito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud_ae`
--

DROP TABLE IF EXISTS `solicitud_ae`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud_ae` (
  `num_solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `cod_tip_sol` int(11) DEFAULT NULL,
  `cod_univ` int(11) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cod_tra` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_solicitud`),
  KEY `cod_tip_sol` (`cod_tip_sol`),
  KEY `cod_univ` (`cod_univ`),
  KEY `cod_tra` (`cod_tra`),
  CONSTRAINT `solicitud_ae_ibfk_1` FOREIGN KEY (`cod_tip_sol`) REFERENCES `tipo_solicitud` (`cod_tip_sol`),
  CONSTRAINT `solicitud_ae_ibfk_2` FOREIGN KEY (`cod_univ`) REFERENCES `universitario` (`cod_univ`),
  CONSTRAINT `solicitud_ae_ibfk_3` FOREIGN KEY (`cod_tra`) REFERENCES `trabajador` (`cod_tra`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud_ae`
--

LOCK TABLES `solicitud_ae` WRITE;
/*!40000 ALTER TABLE `solicitud_ae` DISABLE KEYS */;
INSERT INTO `solicitud_ae` VALUES (1,NULL,1,1,'aprobado',1),(2,NULL,1,1,'pendiente',2);
/*!40000 ALTER TABLE `solicitud_ae` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_solicitud`
--

DROP TABLE IF EXISTS `tipo_solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_solicitud` (
  `cod_tip_sol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_tip_sol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_solicitud`
--

LOCK TABLES `tipo_solicitud` WRITE;
/*!40000 ALTER TABLE `tipo_solicitud` DISABLE KEYS */;
INSERT INTO `tipo_solicitud` VALUES (1,'APOYO POR SALUD'),(2,'APOYO POR MATERNIDAD'),(3,'APOYO OFTALMOLOGICO'),(4,'APOYO POR DEFUNCIÓN'),(5,'BECA DE ESTÍMULO'),(6,'ALTO RENDIMIENTO ACADÉMICO'),(7,'PRESTAMO');
/*!40000 ALTER TABLE `tipo_solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajador` (
  `cod_tra` int(11) NOT NULL,
  `nom_tra` varchar(45) DEFAULT NULL,
  `ape_tra` varchar(45) DEFAULT NULL,
  `sexo_tra` varchar(45) DEFAULT NULL,
  `fec_nac` date DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `tipo_tra` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_tra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` VALUES (1,'cesar','oliart',NULL,NULL,NULL,NULL,'admin','123',NULL),(2,'andres','mogollon',NULL,NULL,NULL,NULL,'tesoreria','123',NULL),(3,'jesus','tapia',NULL,NULL,NULL,NULL,'secretaria','123',NULL);
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `universitario`
--

DROP TABLE IF EXISTS `universitario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `universitario` (
  `cod_univ` int(11) NOT NULL AUTO_INCREMENT,
  `nom_univ` varchar(45) DEFAULT NULL,
  `ape_univ` varchar(45) DEFAULT NULL,
  `sexo_univ` varchar(45) DEFAULT NULL,
  `fec_nac` date DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_univ`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `universitario`
--

LOCK TABLES `universitario` WRITE;
/*!40000 ALTER TABLE `universitario` DISABLE KEYS */;
INSERT INTO `universitario` VALUES (1,'cesar','cesar','',NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `universitario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-01-08  3:21:03
