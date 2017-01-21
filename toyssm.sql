/*
Navicat MySQL Data Transfer

Source Server         : toy
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : toyssm

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-08-06 14:23:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for toy_admin
-- ----------------------------
DROP TABLE IF EXISTS `toy_admin`;
CREATE TABLE `toy_admin` (
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of toy_admin
-- ----------------------------
INSERT INTO `toy_admin` VALUES ('toy', 'tytyty', '1');

-- ----------------------------
-- Table structure for toy_user
-- ----------------------------
DROP TABLE IF EXISTS `toy_user`;
CREATE TABLE `toy_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of toy_user
-- ----------------------------
INSERT INTO `toy_user` VALUES ('1', 'toy', '20', '2016-08-02', '1059813686@qq.com', '1', '管理员');
INSERT INTO `toy_user` VALUES ('2', 'qwe', '21', '2016-08-03', '1111', '1', '1');
INSERT INTO `toy_user` VALUES ('3', 'asd', '22', '2016-08-03', '2222', '2', '2');
INSERT INTO `toy_user` VALUES ('4', 'zxc', '22', null, 'ty2145621@163.com', '1', null);
INSERT INTO `toy_user` VALUES ('5', 'rty', '23', null, '1059813686@qq.com', '1', null);
