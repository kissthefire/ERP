/*
Navicat MySQL Data Transfer

Source Server         : master
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : erp

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-05-12 00:06:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cpck
-- ----------------------------
DROP TABLE IF EXISTS `cpck`;
CREATE TABLE `cpck` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FCPXH` varchar(50) DEFAULT NULL,
  `FTXM` varchar(100) DEFAULT NULL,
  `FCKRQ` date DEFAULT NULL,
  `FCPDJ` double(10,2) DEFAULT NULL,
  `FCKSL` int(11) DEFAULT NULL,
  `FCZRY` varchar(20) DEFAULT NULL,
  `FBZ` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cpck
-- ----------------------------

-- ----------------------------
-- Table structure for cprk
-- ----------------------------
DROP TABLE IF EXISTS `cprk`;
CREATE TABLE `cprk` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FCPXH` varchar(50) DEFAULT NULL,
  `FTXM` varchar(100) DEFAULT NULL,
  `FRKRQ` date DEFAULT NULL,
  `FCPDJ` double(10,2) DEFAULT NULL,
  `FRKSL` int(11) DEFAULT NULL,
  `FCZRY` varchar(20) DEFAULT NULL,
  `FBZ` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cprk
-- ----------------------------
INSERT INTO `cprk` VALUES ('1', 'aa', 'sd', '2020-05-02', '1200.01', '10', '张三', '好的');
INSERT INTO `cprk` VALUES ('2', '1231', '12313', '2020-12-11', '12.01', '2', '234', '备注');
INSERT INTO `cprk` VALUES ('3', '1231', '12313', '2020-12-11', '12.01', '2', '234', '备注');

-- ----------------------------
-- Table structure for mlrfx
-- ----------------------------
DROP TABLE IF EXISTS `mlrfx`;
CREATE TABLE `mlrfx` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FXSBM` varchar(20) DEFAULT NULL,
  `FKHXM` varchar(20) DEFAULT NULL,
  `FKHDH` varchar(20) DEFAULT NULL,
  `FXSRQ` date DEFAULT NULL,
  `FXSJG` double(10,2) DEFAULT NULL,
  `FCBJG` double(10,2) DEFAULT NULL,
  `FQTFY` double(10,2) DEFAULT NULL,
  `FLR` double(10,2) DEFAULT NULL,
  `FBZ` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mlrfx
-- ----------------------------

-- ----------------------------
-- Table structure for xsmx
-- ----------------------------
DROP TABLE IF EXISTS `xsmx`;
CREATE TABLE `xsmx` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FXSBM` varchar(20) DEFAULT NULL,
  `FNAME` varchar(20) DEFAULT NULL,
  `FADDR` varchar(100) DEFAULT NULL,
  `FPHONE` varchar(20) DEFAULT NULL,
  `FCPXH` varchar(50) DEFAULT NULL,
  `FTXM` varchar(100) DEFAULT NULL,
  `FXSJE` double(10,2) DEFAULT NULL,
  `FSKFS` varchar(100) DEFAULT NULL,
  `FXSRQ` date DEFAULT NULL,
  `FXSRY` varchar(20) DEFAULT NULL,
  `FAZRY` varchar(20) DEFAULT NULL,
  `FSFSG` varchar(2) DEFAULT NULL,
  `FBZ` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xsmx
-- ----------------------------

-- ----------------------------
-- Table structure for ygxz
-- ----------------------------
DROP TABLE IF EXISTS `ygxz`;
CREATE TABLE `ygxz` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FXM` varchar(20) DEFAULT NULL,
  `FJBGZ` double(10,2) DEFAULT NULL,
  `FZJTC` double(10,2) DEFAULT NULL,
  `FRSQTC` double(10,2) DEFAULT NULL,
  `FQTTC` double(10,2) DEFAULT NULL,
  `FZJAZF` double(10,2) DEFAULT NULL,
  `FRSQAZF` double(10,2) DEFAULT NULL,
  `FQTAZF` double(10,2) DEFAULT NULL,
  `FFJXZ` double(10,2) DEFAULT NULL,
  `FFXRQ` date DEFAULT NULL,
  `FBZ` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ygxz
-- ----------------------------
