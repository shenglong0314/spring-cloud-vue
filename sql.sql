/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.27 : Database - vue_elementui
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vue_elementui` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vue_elementui`;

/*Table structure for table `button` */

DROP TABLE IF EXISTS `button`;

CREATE TABLE `button` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `rrid` bigint(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `button` */

insert  into `button`(`id`,`name`,`value`,`rrid`) values (1,'add','1',2),(2,'edit','1',2),(3,'delete','1',2),(4,'update','1',2),(5,'title','用户管理',2),(6,'icon','table',2),(7,'icon','example',1),(8,'title','系统管理',1),(9,'title','权限管理',3),(10,'icon','tree',3),(11,'title','角色管理',13),(12,'icon','peoples',13),(13,'add','1',13),(14,'edit','1',13),(15,'delete','1',13),(16,'update','1',13),(17,'search','1',13),(18,'select','1',2),(19,'title','路由管理',14),(20,'icon','table',14),(21,'add','1',14);

/*Table structure for table `meta` */

DROP TABLE IF EXISTS `meta`;

CREATE TABLE `meta` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `add` tinyint(1) DEFAULT '0',
  `delete` tinyint(1) DEFAULT '0',
  `edit` tinyint(1) DEFAULT '0',
  `select` tinyint(1) DEFAULT '0',
  `title` varchar(200) DEFAULT NULL,
  `icon` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `meta` */

insert  into `meta`(`id`,`add`,`delete`,`edit`,`select`,`title`,`icon`) values (1,1,1,1,1,'系统管理','example'),(2,1,1,1,1,'用户管理','table'),(3,1,1,1,1,'权限管理','tree'),(4,1,1,1,1,'Form','form'),(5,0,1,1,1,'用户管理','table'),(6,1,1,1,1,'角色管理','peoples');

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

insert  into `roles`(`id`,`name`) values (1,'admin'),(2,'user');

/*Table structure for table `roles_router` */

DROP TABLE IF EXISTS `roles_router`;

CREATE TABLE `roles_router` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rolesid` bigint(20) DEFAULT NULL,
  `routerid` bigint(20) DEFAULT NULL,
  `metaid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `roles_router` */

insert  into `roles_router`(`id`,`rolesid`,`routerid`,`metaid`) values (1,1,1,1),(2,1,2,2),(3,1,3,3),(5,1,5,4),(6,1,6,0),(7,2,1,1),(8,2,2,5),(9,2,3,3),(10,2,5,4),(11,2,6,0),(12,2,4,NULL),(13,1,7,6),(14,1,8,NULL);

/*Table structure for table `router` */

DROP TABLE IF EXISTS `router`;

CREATE TABLE `router` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `path` varchar(200) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `parentid` bigint(50) DEFAULT NULL,
  `metaid` bigint(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `router` */

insert  into `router`(`id`,`path`,`name`,`parentid`,`metaid`) values (1,'/example','Example',0,1),(2,'table','Table',1,2),(3,'tree','Tree',1,3),(4,'/form',NULL,0,NULL),(5,'index','Form',4,4),(6,'*',NULL,NULL,NULL),(7,'roles','Roles',NULL,NULL),(8,'router','Router',NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'admin','admin'),(2,'user','user'),(47,'das','das'),(48,'dsa','dsa'),(54,'das','dsa'),(55,'das','das'),(56,'das','das'),(57,'da','da'),(58,'fds','fds'),(59,'fds','fds'),(60,'fds','fsd'),(61,'gfd','hfg'),(62,'jhg','jhg');

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `userid` bigint(50) DEFAULT NULL,
  `rolesid` bigint(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_roles` */

insert  into `user_roles`(`id`,`userid`,`rolesid`) values (1,1,1),(2,2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
