/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 10.1.26-MariaDB : Database - app_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`app_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `app_db`;

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `message_id` varchar(64) NOT NULL,
  `content` text,
  `product_id` bigint(20) unsigned NOT NULL,
  `social_name` varchar(20) NOT NULL,
  `social_post_id` varchar(64) NOT NULL,
  `comment_by_name` varchar(32) DEFAULT NULL,
  `comment_by_id` varchar(64) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  PRIMARY KEY (`message_id`,`social_name`,`social_post_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `images` */

DROP TABLE IF EXISTS `images`;

CREATE TABLE `images` (
  `id` int(5) unsigned NOT NULL,
  `url` text CHARACTER SET latin1 NOT NULL,
  `product_id` bigint(20) unsigned NOT NULL,
  `amazon_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `images_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(16,2) DEFAULT NULL,
  `desc` text,
  `user_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `social_product` */

DROP TABLE IF EXISTS `social_product`;

CREATE TABLE `social_product` (
  `product_id` bigint(20) unsigned NOT NULL,
  `social_name` varchar(20) CHARACTER SET latin1 NOT NULL,
  `social_post_id` varchar(64) CHARACTER SET latin1 NOT NULL,
  `create_at` datetime DEFAULT NULL,
  PRIMARY KEY (`social_name`,`social_post_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `social_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `social_token` */

DROP TABLE IF EXISTS `social_token`;

CREATE TABLE `social_token` (
  `user_id` bigint(20) unsigned NOT NULL,
  `token` text NOT NULL,
  `social_name` varchar(20) NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`user_id`,`social_name`),
  CONSTRAINT `social_token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(128) CHARACTER SET latin1 DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `first_name` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `last_name` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `phone_number` char(20) CHARACTER SET latin1 DEFAULT NULL,
  `address` text CHARACTER SET latin1,
  `social_id` varchar(32) DEFAULT NULL,
  `social_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
