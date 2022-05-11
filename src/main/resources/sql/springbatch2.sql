/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : springbatch2

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/05/2022 16:33:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict`  (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(64) NULL DEFAULT 0 COMMENT '父主键',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典编码',
  `dict_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典值',
  `dict_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典备注',
  `is_deleted` int(2) NULL DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dict
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1`  (
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `price` decimal(10, 2) NOT NULL COMMENT '订单价格',
  `user_id` bigint(20) NOT NULL COMMENT '下单用户id',
  `order_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_1
-- ----------------------------
INSERT INTO `t_order_1` VALUES (731141640210612224, 0.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141640978169856, 2.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641015918592, 4.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641057861632, 6.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641099804672, 8.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641137553408, 10.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641175302144, 12.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641217245184, 14.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641267576832, 16.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641301131264, 18.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641330491392, 20.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641364045824, 22.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641397600256, 24.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641435348992, 26.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641473097728, 28.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641510846464, 30.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641548595200, 32.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641582149632, 34.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641619898368, 36.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641649258496, 38.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641682812928, 40.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641716367360, 42.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641745727488, 44.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641783476224, 46.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641817030656, 48.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641850585088, 50.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641884139520, 52.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641909305344, 54.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641947054080, 56.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141641988997120, 58.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642030940160, 60.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642068688896, 62.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642106437632, 64.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642139992064, 66.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642173546496, 68.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642207100928, 70.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642236461056, 72.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642265821184, 74.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642295181312, 76.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642324541440, 78.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642353901568, 80.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642387456000, 82.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642412621824, 84.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642446176256, 86.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642479730688, 88.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642513285120, 90.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642542645248, 92.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642567811072, 94.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642597171200, 96.00, 9, 'prepare');
INSERT INTO `t_order_1` VALUES (731141642626531328, 98.00, 9, 'prepare');

-- ----------------------------
-- Table structure for t_order_2
-- ----------------------------
DROP TABLE IF EXISTS `t_order_2`;
CREATE TABLE `t_order_2`  (
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `price` decimal(10, 2) NOT NULL COMMENT '订单价格',
  `user_id` bigint(20) NOT NULL COMMENT '下单用户id',
  `order_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_2
-- ----------------------------
INSERT INTO `t_order_2` VALUES (731141640948809729, 1.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141640994947073, 3.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641041084417, 5.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641083027457, 7.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641120776193, 9.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641158524929, 11.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641196273665, 13.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641242411009, 15.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641284354049, 17.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641317908481, 19.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641347268609, 21.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641380823041, 23.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641418571777, 25.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641456320513, 27.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641489874945, 29.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641527623681, 31.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641565372417, 33.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641603121153, 35.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641636675585, 37.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641666035713, 39.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641699590145, 41.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641728950273, 43.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641762504705, 45.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641800253441, 47.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641833807873, 49.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641867362305, 51.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641896722433, 53.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641926082561, 55.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141641963831297, 57.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642009968641, 59.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642051911681, 61.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642085466113, 63.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642123214849, 65.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642156769281, 67.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642190323713, 69.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642219683841, 71.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642253238273, 73.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642282598401, 75.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642311958529, 77.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642341318657, 79.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642370678785, 81.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642400038913, 83.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642429399041, 85.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642462953473, 87.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642496507905, 89.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642525868033, 91.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642555228161, 93.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642584588289, 95.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642613948417, 97.00, 9, 'prepare');
INSERT INTO `t_order_2` VALUES (731141642639114241, 99.00, 9, 'prepare');

SET FOREIGN_KEY_CHECKS = 1;
