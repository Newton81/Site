CREATE DATABASE `cadastro` /*!40100 DEFAULT CHARACTER SET latin1 */;
CREATE TABLE `cadastro11` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `ano` int(11) NOT NULL,
  `producao` float NOT NULL,
  `produtividade` float NOT NULL,
  `valorSaca` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
CREATE TABLE `cadastro15` (
  `custId` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `sd` varchar(255) NOT NULL,
  `msg` varchar(255) NOT NULL,
  `selectedname` varchar(255) NOT NULL,
  PRIMARY KEY (`custId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `cadastro4` (
  `usuarioID` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`usuarioID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
CREATE TABLE `cadastro5` (
  `usuarioID` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `msg` varchar(255) NOT NULL,
  PRIMARY KEY (`usuarioID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
CREATE TABLE `cadastro7` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `modelo` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `ano` int(11) NOT NULL,
  `marca` varchar(255) NOT NULL,
  `cor` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
CREATE TABLE `cadastro8` (
  `custId` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `msg` varchar(255) NOT NULL,
  `selectedname` varchar(255) NOT NULL,
  `sd` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  PRIMARY KEY (`custId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `cadastro9` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `periodo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `pessoa` (
  `usuarioid` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `prod_foto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usuarioid`)
) ENGINE=MyISAM AUTO_INCREMENT=8777 DEFAULT CHARSET=latin1;
CREATE TABLE `pessoamsg` (
  `usuarioid` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usuarioid`)
) ENGINE=MyISAM AUTO_INCREMENT=81 DEFAULT CHARSET=latin1;
CREATE TABLE `usuario` (
  `DTYPE` varchar(31) NOT NULL,
  `usuarioid` varchar(255) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `usuarioPS_usuarioid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usuarioid`),
  KEY `FK_efe0qj1spm8j5l4kkcrmieopi` (`usuarioPS_usuarioid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
CREATE TABLE `usuariomsg` (
  `usuarioid` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usuarioid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

