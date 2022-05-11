/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : product_db_2

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/05/2022 16:34:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product_descript_1
-- ----------------------------
DROP TABLE IF EXISTS `product_descript_1`;
CREATE TABLE `product_descript_1`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `product_info_id` bigint(20) NULL DEFAULT NULL COMMENT '所属商品id',
  `descript` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述',
  `store_info_id` bigint(20) NULL DEFAULT NULL COMMENT '所属店铺id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_2`(`product_info_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_descript_1
-- ----------------------------

-- ----------------------------
-- Table structure for product_descript_2
-- ----------------------------
DROP TABLE IF EXISTS `product_descript_2`;
CREATE TABLE `product_descript_2`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `product_info_id` bigint(20) NULL DEFAULT NULL COMMENT '所属商品id',
  `descript` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述',
  `store_info_id` bigint(20) NULL DEFAULT NULL COMMENT '所属店铺id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_2`(`product_info_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_descript_2
-- ----------------------------

-- ----------------------------
-- Table structure for product_info_1
-- ----------------------------
DROP TABLE IF EXISTS `product_info_1`;
CREATE TABLE `product_info_1`  (
  `product_info_id` bigint(20) NOT NULL COMMENT 'id',
  `store_info_id` bigint(20) NULL DEFAULT NULL COMMENT '所属店铺id',
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `spec` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规\r\n格',
  `region_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产地',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '商品价格',
  `image_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`product_info_id`) USING BTREE,
  INDEX `FK_Reference_1`(`store_info_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info_1
-- ----------------------------

-- ----------------------------
-- Table structure for product_info_2
-- ----------------------------
DROP TABLE IF EXISTS `product_info_2`;
CREATE TABLE `product_info_2`  (
  `product_info_id` bigint(20) NOT NULL COMMENT 'id',
  `store_info_id` bigint(20) NULL DEFAULT NULL COMMENT '所属店铺id',
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `spec` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规\r\n格',
  `region_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产地',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '商品价格',
  `image_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`product_info_id`) USING BTREE,
  INDEX `FK_Reference_1`(`store_info_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info_2
-- ----------------------------

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
