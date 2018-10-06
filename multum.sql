-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: multum
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `aux_compras`
--

DROP TABLE IF EXISTS `aux_compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aux_compras` (
  `IDAux_Compras` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Producto` varchar(15) DEFAULT NULL,
  `NombreProducto` varchar(25) DEFAULT NULL,
  `Descripcion` varchar(25) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Importe` double DEFAULT NULL,
  PRIMARY KEY (`IDAux_Compras`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aux_compras`
--

LOCK TABLES `aux_compras` WRITE;
/*!40000 ALTER TABLE `aux_compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `aux_compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aux_ventas`
--

DROP TABLE IF EXISTS `aux_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aux_ventas` (
  `IdAux` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Producto` varchar(45) NOT NULL,
  `NombreProducto` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Precio` double NOT NULL,
  `CV` int(11) NOT NULL,
  `Importe` double NOT NULL,
  `Descuento` double DEFAULT '0',
  PRIMARY KEY (`IdAux`),
  UNIQUE KEY `Id_Producto_UNIQUE` (`Id_Producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aux_ventas`
--

LOCK TABLES `aux_ventas` WRITE;
/*!40000 ALTER TABLE `aux_ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `aux_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `ID_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `NombreCliente` varchar(25) CHARACTER SET utf8 NOT NULL,
  `ApellidoPaterno` varchar(20) CHARACTER SET utf8 NOT NULL,
  `ApellidoMaterno` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `TelefonoCliente` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Celular` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Telefono2` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `Saldo` double DEFAULT NULL,
  `RFC` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `CP` varchar(10) COLLATE utf8_bin NOT NULL,
  `Ciudad` varchar(45) COLLATE utf8_bin NOT NULL,
  `Colonia` varchar(45) COLLATE utf8_bin NOT NULL,
  `Calle` varchar(45) COLLATE utf8_bin NOT NULL,
  `Numero_Dom` varchar(6) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin PACK_KEYS=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Jose ','Sanchez','Garcia ','4567898765','6567876545','8765567887',48.75,'76556788765678','76678','hgfghjhgfghj','djdjd','edjdejde','444999'),(2,'Paty','Ramirez','Ochoa ','','3434567654','',0,'','56543','Guzma','hjhjh','jhghjh','43432'),(3,'Jose','Sanchez','Miranda','765','654',NULL,516.37,'jhghjhg','5432','Guzman','Zap','Jil','54'),(4,'Cliente General','-----','------','00000','00000','00000',0,'aaaaaa','00000','AAAAA','AAAAA','AAAAA','00'),(5,'Jose Alejandr ','gfd','Ruelas','3411568211','3411234567','',150.9,'','49606','Zapotiltic','Provipoza ','Jilguero ','33'),(6,'Jose','Perez','Gonzales','3418943456','3412345757','',202.9,'','49000','Cd. Guzman ','Centro ','Godinez','75'),(7,'Rosa Maria ','Michel','Nava','','5676566767','',150.9,'','49090','tteydbf','hjhgh','ghjk','324');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `ID_Compra` int(11) NOT NULL,
  `ID_Producto` varchar(15) NOT NULL,
  `NombreProducto` varchar(25) NOT NULL,
  `Descripcion` varchar(25) NOT NULL,
  `Precio` double NOT NULL,
  `CantidadCompra` int(11) NOT NULL,
  `Importe` double NOT NULL,
  PRIMARY KEY (`ID_Compra`,`ID_Producto`),
  KEY `compra_producto_idx` (`ID_Producto`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`ID_Compra`) REFERENCES `detallecompra` (`ID_Compra`),
  CONSTRAINT `compra_producto` FOREIGN KEY (`ID_Producto`) REFERENCES `producto` (`ID_Producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (4,'123','Coca','Refresco de cola',20,1,20),(5,'123','Coca','Refresco de cola',20,1,20),(6,'123','Coca','Refresco de cola',20,1,20),(7,'123','Coca','Refresco de cola',20,2,40),(9,'123','Coca','Refresco de cola',20,1,20),(11,'1234','Coco','Coco seco',12.67,3,38.01),(12,'1234','Coco','Coco seco',12.67,2,25.34),(13,'123','Coca','Refresco de cola',20,1,20),(17,'1234','Coco','Coco seco',12.67,1,12.67),(20,'1234','Coco','Coco seco',12.67,1,12.67),(21,'123','Coca','Refresco de cola',20,1,20),(22,'1234','Coco','Coco seco',12.67,1,12.67),(23,'123','Coca','Refresco de cola',20,1,20),(24,'1234','Coco','Coco seco',12.67,2,25.34),(26,'1234','Coco','Coco seco',12.67,1,12.67),(27,'123','Coca','Refresco de cola',20,1,20),(31,'1234','Coco','Coco seco',12.67,1,12.67),(32,'1234','Coco','Coco seco',12.67,2,25.34),(33,'123','Coca','Refresco de cola',20,2,40),(34,'1234','Coco','Coco seco',12.67,2,25.34),(35,'123','Coca','Refresco de cola',20,2,40),(38,'123','Coca','Refresco de cola',20,3,60),(38,'1234','Coco','Coco seco',12.67,2,25.34),(39,'1234','Coco','Coco seco',12.67,1,12.67),(41,'123','Coca','Refresco de cola',20,2,40),(42,'123','Coca','Refresco de cola',20,1,20);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecompra`
--

DROP TABLE IF EXISTS `detallecompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecompra` (
  `ID_Compra` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int(11) DEFAULT NULL,
  `ID_Proveedor` int(11) DEFAULT NULL,
  `FechaCompra` date DEFAULT NULL,
  `TotalCompra` double DEFAULT NULL,
  PRIMARY KEY (`ID_Compra`),
  KEY `ID_Usuario` (`ID_Usuario`),
  KEY `ID_Proveedor` (`ID_Proveedor`),
  CONSTRAINT `detallecompra_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`),
  CONSTRAINT `detallecompra_ibfk_2` FOREIGN KEY (`ID_Proveedor`) REFERENCES `proveedor` (`ID_Proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecompra`
--

LOCK TABLES `detallecompra` WRITE;
/*!40000 ALTER TABLE `detallecompra` DISABLE KEYS */;
INSERT INTO `detallecompra` VALUES (3,123,10,'2018-05-02',20),(4,123,10,'2018-05-02',20),(5,123,10,'2018-05-02',20),(6,123,10,'2018-05-02',20),(7,123,10,'2018-05-02',40),(8,123,10,'2018-05-02',40),(9,123,10,'2018-05-02',45.34),(10,123,10,'2018-05-02',45.34),(11,123,10,'2018-05-02',38.01),(12,123,10,'2018-05-02',65.34),(13,123,1,'2018-05-03',45.34),(14,123,1,'2018-05-03',45.34),(15,123,10,'2018-05-03',45.34),(16,123,1,'2018-05-03',45.34),(17,123,1,'2018-05-03',32.67),(18,123,1,'2018-05-03',32.67),(19,123,1,'2018-05-03',32.67),(20,123,10,'2018-05-03',52.67),(21,123,10,'2018-05-03',32.67),(22,123,10,'2018-05-03',12.67),(23,123,10,'2018-05-03',32.67),(24,123,10,'2018-05-03',45.34),(25,123,10,'2018-05-03',45.34),(26,123,10,'2018-05-03',32.67),(27,123,10,'2018-05-03',32.67),(28,123,10,'2018-05-03',32.67),(29,123,10,'2018-05-03',32.67),(30,123,10,'2018-05-03',32.67),(31,123,10,'2018-05-03',32.67),(32,123,10,'2018-05-03',45.34),(33,123,10,'2018-05-03',40),(34,123,10,'2018-05-03',25.34),(35,123,1,'2018-05-03',52.67),(36,123,1,'2018-05-03',52.67),(37,123,10,'2018-05-03',52.67),(38,123,10,'2018-05-06',85.34),(39,123,10,'2018-05-13',12.67),(40,123,1,'2018-05-20',0),(41,123,10,'2018-05-20',40),(42,123,1,'2018-05-20',20),(43,123,10,'2018-05-20',20);
/*!40000 ALTER TABLE `detallecompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleventa` (
  `ID_Venta` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Cliente` int(11) DEFAULT NULL,
  `ID_Usuario` int(11) DEFAULT NULL,
  `FechaVenta` date DEFAULT NULL,
  `TotalVenta` double DEFAULT NULL,
  PRIMARY KEY (`ID_Venta`),
  KEY `mm_idx` (`ID_Cliente`),
  KEY `JJ_idx` (`ID_Usuario`),
  CONSTRAINT `JJ` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mm` FOREIGN KEY (`ID_Cliente`) REFERENCES `cliente` (`ID_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventa`
--

LOCK TABLES `detalleventa` WRITE;
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
INSERT INTO `detalleventa` VALUES (7,1,123,'2018-04-30',20),(8,1,123,'2018-04-30',60),(9,1,123,'2018-04-30',80),(10,3,123,'2018-04-30',80),(11,1,123,'2018-04-30',0),(12,2,123,'2018-04-30',40),(13,2,123,'2018-04-30',65.34),(14,3,123,'2018-04-30',25.34),(15,2,123,'2018-04-30',25.34),(16,1,123,'2018-05-01',40),(17,3,123,'2018-05-01',25.34),(18,1,123,'2018-05-01',45.34),(19,3,123,'2018-05-01',60),(20,1,123,'2018-05-01',52.67),(21,2,123,'2018-05-01',32.67),(22,3,123,'2018-05-01',52.67),(23,2,123,'2018-05-01',32.67),(24,3,123,'2018-05-01',58.01),(25,1,123,'2018-05-01',45.34),(26,1,123,'2018-05-01',45.34),(27,2,123,'2018-05-01',52.67),(28,2,123,'2018-05-01',40),(29,2,123,'2018-05-01',40),(30,2,123,'2018-05-01',40),(31,2,123,'2018-05-01',32.67),(32,2,123,'2018-05-01',40),(33,2,123,'2018-05-01',12.67),(34,2,123,'2018-05-01',100),(35,2,123,'2018-05-01',20),(36,3,123,'2018-05-01',20),(37,2,123,'2018-05-01',45.34),(38,2,123,'2018-05-01',45.34),(39,2,123,'2018-05-01',32.67),(40,2,123,'2018-05-01',52.67),(41,2,123,'2018-05-01',32.67),(42,2,123,'2018-05-01',45.34),(43,3,123,'2018-05-03',98.00999999999999),(44,2,123,'2018-05-06',45.34),(45,2,123,'2018-05-07',80),(46,2,123,'2018-05-07',68),(47,2,123,'2018-05-07',24),(48,2,123,'2018-05-07',39),(49,2,123,'2018-05-07',37),(50,2,123,'2018-05-07',22),(51,2,123,'2018-05-07',22),(52,2,123,'2018-05-07',37),(53,2,123,'2018-05-07',44),(54,2,123,'2018-05-07',17),(55,1,123,'2018-05-07',0),(56,1,123,'2018-05-07',22),(57,1,123,'2018-05-07',22),(58,1,123,'2018-05-07',44),(59,1,123,'2018-05-08',37),(60,3,123,'2018-05-08',15),(61,3,123,'2018-05-08',476),(62,1,123,'2018-05-08',10),(63,1,123,'2018-05-08',22),(64,1,123,'2018-05-09',22),(65,1,123,'2018-05-09',37),(66,2,123,'2018-05-09',52),(67,2,123,'2018-05-10',37),(68,2,123,'2018-05-12',52),(69,2,123,'2018-05-18',81),(70,3,123,'2018-05-18',22),(71,3,123,'2018-05-25',103),(72,6,123,'2018-05-29',52);
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago` (
  `ID_Pago` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Cliente` int(11) DEFAULT NULL,
  `ID_Usuario` int(11) DEFAULT NULL,
  `FechaPago` date DEFAULT NULL,
  `Monto` double NOT NULL,
  `SaldoAnterior` double NOT NULL,
  `SaldoActual` double NOT NULL,
  PRIMARY KEY (`ID_Pago`),
  KEY `usuario_idx` (`ID_Usuario`),
  KEY `cliente_idx` (`ID_Cliente`),
  CONSTRAINT `cliente` FOREIGN KEY (`ID_Cliente`) REFERENCES `cliente` (`ID_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (3,2,123,'2005-10-10',20,130.9,110.9),(4,2,123,'2005-10-10',100,110.9,10.900000000000006),(5,3,123,'2005-10-10',12,419.37,407.37),(6,2,123,'2005-10-10',34,10.900000000000006,0),(7,1,123,'2005-10-10',12.125,505,492.875),(8,1,123,'2005-10-10',10.125,492.875,482.75),(9,3,123,'2005-10-10',100,407.37,307.37),(10,1,123,'2005-10-10',400,607.75,207.75),(11,1,123,'2005-10-10',100,207.75,107.75),(12,3,123,'2005-10-10',120,798.37,678.37),(13,1,123,'2005-10-10',10,117.75,107.75),(14,3,123,'2005-10-10',123,678.37,555.37),(15,3,123,'2005-10-10',20,555.37,535.37),(16,3,123,'2005-10-10',100,535.37,435.37),(17,3,123,'2005-10-10',20,535.37,515.37),(18,1,123,'2005-10-10',20,107.75,87.75),(19,3,123,'2005-10-10',10,515.37,505.37),(20,3,123,'2005-10-10',10,505.37,495.37),(21,3,123,'2005-10-10',10,495.37,485.37),(22,3,123,'2005-10-10',10,495.37,485.37),(23,3,123,'2005-10-10',10,485.37,475.37),(24,3,123,'2005-10-10',30,475.37,445.37),(25,3,123,'2005-10-10',10,445.37,435.37),(26,3,123,'2005-10-10',10,435.37,425.37),(27,1,123,'2005-10-10',20,109.75,89.75),(28,1,123,'2005-10-10',100,111.75,11.75),(29,3,123,'2005-10-10',45,447.37,402.37),(30,3,123,'2005-10-10',34,447.37,413.37);
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `ID_Producto` varchar(15) NOT NULL,
  `NombreProducto` varchar(40) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `ExistenciaProducto` int(11) DEFAULT NULL,
  `Categoria` varchar(20) DEFAULT NULL,
  `TipoProducto` varchar(20) DEFAULT NULL,
  `FechaCaducidad` date DEFAULT NULL,
  `PrecioProducto` double NOT NULL,
  `PrecioVenta` double NOT NULL,
  PRIMARY KEY (`ID_Producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('123','Coca','Refresco de cola',66,'Comestibles','Bebida','2010-04-23',20,22),('1234','Coco','Coco seco',78,'Comestibles','Coquito','2015-04-09',12.67,15),('123453333333','hgfd','gfd',23,'Vinos ','Vinos ','2049-06-04',120,25),('123456789363','Clamato ','Producto de jitomate',8,'Comestibles','Com2','2020-04-27',12,15),('12372839365','Salsa Valentina ','Salsa picante ',20,'Comestibles ','Cosa','2030-03-12',20,21),('245435435545','Papas','Papas',23,'Item 2','Item 2','2020-03-12',12,2),('432324345434','Cogfd','fd',4,'Vinos ','Vinos ','2025-07-05',12,11),('434456544567','fdfgd','gfds',0,'Comestible ','Comestible ','2018-01-01',23,23),('907272733445','Modelo Especial ','Cerveza Modelo ',0,'Vinos ','Vinos ','2038-02-06',12,15);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `ID_Proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `NombreProveedor` varchar(40) NOT NULL,
  `TelefonoProveedor` varchar(10) DEFAULT NULL,
  `DireccionProveedor` varchar(60) DEFAULT NULL,
  `EmailProveedor` varchar(40) DEFAULT NULL,
  `Deuda` double DEFAULT NULL,
  PRIMARY KEY (`ID_Proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Juan ','3411943456','Manuel A.','farualex@gmail.com',1359),(2,'Pedro ','3454345654','Mexico','Faru',1299),(10,'Provedor General','3456543454','Mexico','Mexico',0);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(20) NOT NULL,
  `Contrasena` varchar(20) NOT NULL,
  `NombreUsuario` varchar(40) NOT NULL,
  `TelefonoUsuario` varchar(10) NOT NULL,
  `TipoUsuario` varchar(13) NOT NULL,
  `EmailUsuario` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (123,'we','we','we','33333','a','a');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `ID_Venta` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Producto` varchar(15) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Precio` double DEFAULT NULL,
  `CantidadVenta` int(11) DEFAULT NULL,
  `Importe` double NOT NULL,
  `NombreProducto` varchar(45) NOT NULL,
  `Descuento` double DEFAULT '0',
  PRIMARY KEY (`ID_Venta`,`ID_Producto`),
  KEY `venta_producto` (`ID_Producto`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`ID_Venta`) REFERENCES `detalleventa` (`ID_Venta`),
  CONSTRAINT `venta_producto` FOREIGN KEY (`ID_Producto`) REFERENCES `producto` (`ID_Producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (7,'123','Refresco de cola',20,3,60,'Coca',0),(10,'123','Refresco de cola',20,4,80,'Coca',0),(12,'123','Refresco de cola',20,2,40,'Coca',0),(13,'123','Refresco de cola',20,2,40,'Coca',0),(13,'1234','Coco seco',12.67,2,25.34,'Coco',0),(14,'1234','Coco seco',12.67,2,25.34,'Coco',0),(15,'1234','Coco seco',12.67,2,25.34,'Coco',0),(16,'123','Refresco de cola',20,2,40,'Coca',0),(17,'1234','Coco seco',12.67,2,25.34,'Coco',0),(18,'123','Refresco de cola',20,1,20,'Coca',0),(18,'1234','Coco seco',12.67,2,25.34,'Coco',0),(19,'123','Refresco de cola',20,3,60,'Coca',0),(20,'123','Refresco de cola',20,2,40,'Coca',0),(20,'1234','Coco seco',12.67,1,12.67,'Coco',0),(21,'123','Refresco de cola',20,1,20,'Coca',0),(21,'1234','Coco seco',12.67,1,12.67,'Coco',0),(22,'123','Refresco de cola',20,2,40,'Coca',0),(22,'1234','Coco seco',12.67,1,12.67,'Coco',0),(23,'123','Refresco de cola',20,1,20,'Coca',0),(23,'1234','Coco seco',12.67,1,12.67,'Coco',0),(24,'123','Refresco de cola',20,1,20,'Coca',0),(24,'1234','Coco seco',12.67,3,38.01,'Coco',0),(25,'123','Refresco de cola',20,1,20,'Coca',0),(25,'1234','Coco seco',12.67,2,25.34,'Coco',0),(26,'123','Refresco de cola',20,1,20,'Coca',0),(26,'1234','Coco seco',12.67,2,25.34,'Coco',0),(27,'123','Refresco de cola',20,2,40,'Coca',0),(27,'1234','Coco seco',12.67,1,12.67,'Coco',0),(28,'123','Refresco de cola',20,2,40,'Coca',0),(29,'123','Refresco de cola',20,2,40,'Coca',0),(30,'123','Refresco de cola',20,2,40,'Coca',0),(31,'123','Refresco de cola',20,1,20,'Coca',0),(31,'1234','Coco seco',12.67,1,12.67,'Coco',0),(32,'123','Refresco de cola',20,2,40,'Coca',0),(33,'1234','Coco seco',12.67,1,12.67,'Coco',0),(34,'123','Refresco de cola',20,5,100,'Coca',0),(35,'123','Refresco de cola',20,1,20,'Coca',0),(36,'123','Refresco de cola',20,1,20,'Coca',0),(37,'123','Refresco de cola',20,1,20,'Coca',0),(37,'1234','Coco seco',12.67,2,25.34,'Coco',0),(38,'123','Refresco de cola',20,1,20,'Coca',0),(38,'1234','Coco seco',12.67,2,25.34,'Coco',0),(39,'123','Refresco de cola',20,1,20,'Coca',0),(39,'1234','Coco seco',12.67,1,12.67,'Coco',0),(40,'123','Refresco de cola',20,2,40,'Coca',0),(40,'1234','Coco seco',12.67,1,12.67,'Coco',0),(41,'123','Refresco de cola',20,1,20,'Coca',0),(41,'1234','Coco seco',12.67,1,12.67,'Coco',0),(42,'123','Refresco de cola',20,1,20,'Coca',0),(42,'1234','Coco seco',12.67,2,25.34,'Coco',0),(43,'123','Refresco de cola',20,3,60,'Coca',0),(43,'1234','Coco seco',12.67,3,38.01,'Coco',0),(44,'123','Refresco de cola',20,1,20,'Coca',0),(44,'1234','Coco seco',12.67,2,25.34,'Coco',0),(45,'123','Refresco de cola',20,4,80,'Coca',0),(46,'123','Refresco de cola',22,4,68,'Coca',20),(47,'123','Refresco de cola',22,2,24,'Coca',20),(48,'123','Refresco de cola',22,2,39,'Coca',5),(49,'123','Refresco de cola',22,1,22,'Coca',0),(49,'1234','Coco seco',15,1,15,'Coco',0),(50,'123','Refresco de cola',22,1,22,'Coca',0),(51,'123','Refresco de cola',22,1,22,'Coca',0),(52,'123','Refresco de cola',22,1,22,'Coca',0),(52,'1234','Coco seco',15,1,15,'Coco',0),(53,'123','Refresco de cola',22,2,44,'Coca',0),(54,'123','Refresco de cola',22,1,2,'Coca',20),(54,'1234','Coco seco',15,1,15,'Coco',0),(56,'123','Refresco de cola',22,1,22,'Coca',0),(57,'123','Refresco de cola',22,1,22,'Coca',0),(58,'123','Refresco de cola',22,2,44,'Coca',0),(59,'123','Refresco de cola',22,1,22,'Coca',0),(59,'1234','Coco seco',15,1,15,'Coco',0),(60,'1234','Coco seco',15,1,15,'Coco',0),(61,'123','Refresco de cola',22,8,176,'Coca',0),(61,'1234','Coco seco',15,22,300,'Coco',30),(62,'123','Refresco de cola',22,1,10,'Coca',12),(63,'123','Refresco de cola',22,1,22,'Coca',0),(64,'123','Refresco de cola',22,1,22,'Coca',0),(65,'123','Refresco de cola',22,1,22,'Coca',0),(65,'1234','Coco seco',15,1,15,'Coco',0),(66,'123','Refresco de cola',22,1,22,'Coca',0),(66,'1234','Coco seco',15,2,30,'Coco',0),(67,'123','Refresco de cola',22,1,22,'Coca',0),(67,'1234','Coco seco',15,1,15,'Coco',0),(68,'123','Refresco de cola',22,1,22,'Coca',0),(68,'1234','Coco seco',15,2,30,'Coco',0),(69,'123','Refresco de cola',22,3,66,'Coca',0),(69,'1234','Coco seco',15,1,15,'Coco',0),(70,'123','Refresco de cola',22,1,22,'Coca',0),(71,'123','Refresco de cola',22,4,88,'Coca',0),(71,'1234','Coco seco',15,1,15,'Coco',0),(72,'123','Refresco de cola',22,1,22,'Coca',0),(72,'1234','Coco seco',15,2,30,'Coco',0);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-06 12:59:04
