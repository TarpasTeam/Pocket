/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : studentcard

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-12-08 20:23:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for advertising
-- ----------------------------
DROP TABLE IF EXISTS `advertising`;
CREATE TABLE `advertising` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `picture` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of advertising
-- ----------------------------

-- ----------------------------
-- Table structure for blacklist
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `id` int(5) NOT NULL DEFAULT '0',
  `userid` int(5) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `IDcard` varchar(18) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid` (`userid`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `IDcard` (`IDcard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `regionId` int(11) NOT NULL,
  `picture` varchar(255) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  `isPopular` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `regionId` (`regionId`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`regionId`) REFERENCES `region` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '西安', '2', 'abc', '\0', '');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) NOT NULL,
  `user_head` varchar(100) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  `scenic_id` int(5) NOT NULL,
  `comment` varchar(100) NOT NULL,
  `comment_time` time NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `comment_scenic_id` (`scenic_id`),
  KEY `comment_user_id` (`user_id`),
  CONSTRAINT `comment_scenic_id` FOREIGN KEY (`scenic_id`) REFERENCES `scenic_spot` (`scenic_id`),
  CONSTRAINT `comment_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for cooperation
-- ----------------------------
DROP TABLE IF EXISTS `cooperation`;
CREATE TABLE `cooperation` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) NOT NULL,
  `content` varchar(200) NOT NULL,
  `username` varchar(5) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(20) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cooperation
-- ----------------------------
INSERT INTO `cooperation` VALUES ('1', '第三方验证合作', '口袋学生证提供学生身份验证服务接口', '杨承林', '15667020671', 'ycl_xupt@163.com', '\0');
INSERT INTO `cooperation` VALUES ('2', '第三方合作', 'ssssssssssssssssssss', '啦啦啦', '13666666666', '444@qq.com', '\0');
INSERT INTO `cooperation` VALUES ('3', '第三方验证合作', 'ssssssssssssssssssssssssssaaa', 'lll', '13666666666', '44@qq.com', '\0');

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES ('2', '西北', '\0');

-- ----------------------------
-- Table structure for scenic_class
-- ----------------------------
DROP TABLE IF EXISTS `scenic_class`;
CREATE TABLE `scenic_class` (
  `scenic_class_id` int(5) NOT NULL AUTO_INCREMENT,
  `scenic_clss_name` varchar(30) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`scenic_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scenic_class
-- ----------------------------
INSERT INTO `scenic_class` VALUES ('1', '景点1', '\0');

-- ----------------------------
-- Table structure for scenic_class_detial
-- ----------------------------
DROP TABLE IF EXISTS `scenic_class_detial`;
CREATE TABLE `scenic_class_detial` (
  `scenic_class_detial_id` int(5) NOT NULL AUTO_INCREMENT,
  `scenic_class_detial_name` varchar(30) NOT NULL,
  `scenic_class_id` int(5) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`scenic_class_detial_id`),
  KEY `scenic_class_id` (`scenic_class_id`),
  CONSTRAINT `scenic_class_id` FOREIGN KEY (`scenic_class_id`) REFERENCES `scenic_class` (`scenic_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scenic_class_detial
-- ----------------------------
INSERT INTO `scenic_class_detial` VALUES ('1', '游乐园', '1', '\0');

-- ----------------------------
-- Table structure for scenic_order
-- ----------------------------
DROP TABLE IF EXISTS `scenic_order`;
CREATE TABLE `scenic_order` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `state` int(1) NOT NULL,
  `scenic_id` int(5) NOT NULL,
  `ticket_id` int(5) NOT NULL,
  `user_id` int(5) NOT NULL,
  `scenic_name` varchar(30) NOT NULL,
  `ticket_name` varchar(30) NOT NULL,
  `ticket_price` int(3) NOT NULL,
  `scenic_head` varchar(100) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `scenic_id` (`scenic_id`) USING BTREE,
  KEY `ticket_id` (`ticket_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `scen_id` FOREIGN KEY (`scenic_id`) REFERENCES `scenic_spot` (`scenic_id`),
  CONSTRAINT `ticket_id` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scenic_order
-- ----------------------------

-- ----------------------------
-- Table structure for scenic_spot
-- ----------------------------
DROP TABLE IF EXISTS `scenic_spot`;
CREATE TABLE `scenic_spot` (
  `scenic_id` int(5) NOT NULL AUTO_INCREMENT,
  `scenic_name` varchar(30) NOT NULL,
  `head` varchar(100) NOT NULL,
  `detail_image` varchar(100) NOT NULL,
  `intro` varchar(100) NOT NULL,
  `price` int(6) NOT NULL,
  `address` varchar(50) NOT NULL,
  `detail_address` varchar(50) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `grade` float(8,0) DEFAULT NULL,
  `heat` bigint(8) DEFAULT NULL,
  `city_id` int(11) NOT NULL,
  `scenic_class_detial_id` int(5) NOT NULL,
  `isPopular` bit(1) NOT NULL DEFAULT b'0',
  `picture` varchar(255) DEFAULT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`scenic_id`),
  KEY `city_id` (`city_id`),
  KEY `scenic_class_detial_id` (`scenic_class_detial_id`),
  CONSTRAINT `city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `scenic_class_detial_id` FOREIGN KEY (`scenic_class_detial_id`) REFERENCES `scenic_class_detial` (`scenic_class_detial_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scenic_spot
-- ----------------------------
INSERT INTO `scenic_spot` VALUES ('2', '乐华', 'abc', 'abc\'', 'abc', '10', 'abc', 'abc', '123456', '12', '44', '1', '1', '', 'abc', '\0');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `school` varchar(10) NOT NULL,
  `connection` varchar(30) NOT NULL,
  `information` varchar(100) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `schoolname` varchar(10) NOT NULL,
  `name` varchar(5) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `nation` varchar(10) NOT NULL,
  `birthday` time NOT NULL,
  `IDcard` varchar(18) NOT NULL,
  `academy` varchar(20) NOT NULL,
  `major` varchar(10) NOT NULL,
  `stu_class` varchar(10) NOT NULL,
  `sno` varchar(20) NOT NULL,
  `photo` varchar(100) NOT NULL,
  `origin` varchar(6) NOT NULL,
  `enrollment_date` time NOT NULL,
  `graduate_date` time NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDcard` (`IDcard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `ticket_id` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `price` int(3) NOT NULL,
  `intro` varchar(100) NOT NULL,
  `count_num` int(5) NOT NULL,
  `scenic_id` int(5) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`ticket_id`),
  KEY `scenic_id` (`scenic_id`),
  CONSTRAINT `scenic_id` FOREIGN KEY (`scenic_id`) REFERENCES `scenic_spot` (`scenic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(5) NOT NULL AUTO_INCREMENT,
  `school` varchar(10) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nickname` varchar(10) NOT NULL,
  `head` varchar(100) NOT NULL,
  `isDeleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
