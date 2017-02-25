DROP TABLE IF EXISTS `demos`;
CREATE TABLE `demos` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
LOCK TABLES `demos` WRITE;
INSERT INTO `demos` VALUES (1,'admin','123'),(2,'root','321'),(3,'dami','abc');
UNLOCK TABLES;