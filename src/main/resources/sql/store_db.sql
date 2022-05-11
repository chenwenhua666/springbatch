/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : store_db

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/05/2022 16:33:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for store_info
-- ----------------------------
DROP TABLE IF EXISTS `store_info`;
CREATE TABLE `store_info`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `store_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺名称',
  `reputation` int(11) NULL DEFAULT NULL COMMENT '信誉等级',
  `region_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺所在地',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store_info
-- ----------------------------
INSERT INTO `store_info` VALUES (1, 'XX零食店', 4, '110100');
INSERT INTO `store_info` VALUES (2, 'XX饮品店', 3, '410100');

-- ----------------------------
-- Table structure for t_region
-- ----------------------------
DROP TABLE IF EXISTS `t_region`;
CREATE TABLE `t_region`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `region_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地理区域编码',
  `region_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地理区域名称',
  `level` tinyint(1) NULL DEFAULT NULL COMMENT '地理区域级别(省、市、县)',
  `parent_region_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级地理区域编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_region
-- ----------------------------
INSERT INTO `t_region` VALUES (1, '110000', '北京', 0, NULL);
INSERT INTO `t_region` VALUES (2, '410000', '河南省', 0, NULL);
INSERT INTO `t_region` VALUES (3, '110100', '北京市', 1, '110000');
INSERT INTO `t_region` VALUES (4, '410100', '郑州市', 1, '410000');

SET FOREIGN_KEY_CHECKS = 1;
