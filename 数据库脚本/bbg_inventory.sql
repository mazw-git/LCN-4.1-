/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : bbg_inventory

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-07-24 16:53:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_inventory
-- ----------------------------
DROP TABLE IF EXISTS `tb_inventory`;
CREATE TABLE `tb_inventory` (
  `inventoryid` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) DEFAULT NULL,
  `itemnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`inventoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=866 DEFAULT CHARSET=utf8mb4;
