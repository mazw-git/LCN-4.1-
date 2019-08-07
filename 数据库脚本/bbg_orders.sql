/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : bbg_orders

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-07-24 16:54:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_orders
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders`;
CREATE TABLE `tb_orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=871 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_orders
-- ----------------------------
