/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : springbatch1

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/05/2022 16:32:59
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
INSERT INTO `t_order_1` VALUES (731141234961154048, 0.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141235657408512, 2.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141235695157248, 4.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141235732905984, 6.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141235779043328, 8.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141235816792064, 10.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141235850346496, 12.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141235888095232, 14.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141235934232576, 16.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141235971981312, 18.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236009730048, 20.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236039090176, 22.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236072644608, 24.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236106199040, 26.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236143947776, 28.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236177502208, 30.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236215250944, 32.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236244611072, 34.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236278165504, 36.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236307525632, 38.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236341080064, 40.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236374634496, 42.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236412383232, 44.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236450131968, 46.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236487880704, 48.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236521435136, 50.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236554989568, 52.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236588544000, 54.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236626292736, 56.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236659847168, 58.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236693401600, 60.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236726956032, 62.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236768899072, 64.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236798259200, 66.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236831813632, 68.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236861173760, 70.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236898922496, 72.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236932476928, 74.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236961837056, 76.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141236987002880, 78.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237016363008, 80.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237049917440, 82.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237083471872, 84.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237117026304, 86.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237150580736, 88.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237184135168, 90.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237226078208, 92.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237255438336, 94.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237293187072, 96.00, 8, 'finish');
INSERT INTO `t_order_1` VALUES (731141237330935808, 98.00, 8, 'finish');

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
INSERT INTO `t_order_2` VALUES (731141235632242689, 1.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141235678380033, 3.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141235716128769, 5.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141235753877505, 7.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141235795820545, 9.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141235833569281, 11.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141235867123713, 13.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141235909066753, 15.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141235951009793, 17.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141235988758529, 19.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236022312961, 21.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236055867393, 23.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236089421825, 25.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236127170561, 27.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236160724993, 29.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236194279425, 31.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236227833857, 33.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236261388289, 35.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236294942721, 37.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236324302849, 39.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236357857281, 41.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236391411713, 43.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236433354753, 45.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236466909185, 47.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236504657921, 49.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236538212353, 51.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236571766785, 53.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236609515521, 55.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236643069953, 57.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236676624385, 59.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236710178817, 61.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236747927553, 63.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236785676289, 65.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236815036417, 67.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236848590849, 69.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236882145281, 71.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236915699713, 73.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236949254145, 75.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141236978614273, 77.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237003780097, 79.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237033140225, 81.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237066694657, 83.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237104443393, 85.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237137997825, 87.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237167357953, 89.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237209300993, 91.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237242855425, 93.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237272215553, 95.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237309964289, 97.00, 8, 'finish');
INSERT INTO `t_order_2` VALUES (731141237347713025, 99.00, 8, 'finish');

SET FOREIGN_KEY_CHECKS = 1;
