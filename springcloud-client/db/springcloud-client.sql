/*
 Navicat MySQL Data Transfer

 Source Server         : localhost本机
 Source Server Type    : MySQL
 Source Server Version : 50555
 Source Host           : 127.0.0.1:3306
 Source Schema         : springcloud-client

 Target Server Type    : MySQL
 Target Server Version : 50555
 File Encoding         : 65001

 Date: 28/06/2020 12:57:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, '1', '1', '2020-06-28');

SET FOREIGN_KEY_CHECKS = 1;
