/*
 Navicat Premium Data Transfer

 Source Server         : 本地测试
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : hrm

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 23/03/2020 14:33:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 id 部门编号',
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门详情',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_del` int(11) NULL DEFAULT 0 COMMENT '是否删除，1：已删除，0：未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '人事部', '人事部门', '2020-03-12 13:22:07', 0);
INSERT INTO `dept` VALUES (2, '财务部', '财务部门', '2020-03-12 13:22:55', 0);
INSERT INTO `dept` VALUES (3, '市场部', '市场部门', '2020-03-12 13:24:52', 0);
INSERT INTO `dept` VALUES (4, '技术部', '技术部门', '2020-03-12 13:27:36', 0);
INSERT INTO `dept` VALUES (5, '开发部', '开发部门', '2020-03-12 20:33:03', 0);
INSERT INTO `dept` VALUES (6, '礼仪部', '礼仪部门', '2020-03-13 16:18:30', 0);
INSERT INTO `dept` VALUES (7, '前端部', '前端部门', '2020-03-13 18:04:31', 0);
INSERT INTO `dept` VALUES (8, 'Java开发部', 'Java开发部门', '2020-03-13 18:04:53', 0);
INSERT INTO `dept` VALUES (9, 'Python开发部', 'Python开发部门', '2020-03-13 18:05:17', 1);

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id 主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件保存路径',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_del` int(11) NULL DEFAULT 0 COMMENT '是否删除，1：已删除，0：未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES (1, 'vue开发文档', '15846858122881.jpg', 'F:\\upload\\15846858122881.jpg', 'vue开发文档', '管理员', '2020-03-20 14:30:40', 0);
INSERT INTO `document` VALUES (2, 'Java开发文档', '158469284174210.png', 'F:\\upload\\158469284174210.png', 'Java开发文档', '管理员', '2020-03-20 16:27:37', 0);
INSERT INTO `document` VALUES (3, 'Python开发文档', '15847088335821.jpg', 'F:\\upload\\15847088335821.jpg', 'Python开发文档', '管理员', '2020-03-20 20:54:14', 0);
INSERT INTO `document` VALUES (4, 'C++开发文档', '158470897309938套餐.png', 'F:\\upload\\158470897309938套餐.png', 'C++开发文档', '系统管理员', '2020-03-20 20:56:34', 0);
INSERT INTO `document` VALUES (5, 'layui开发文档', '158486189501538套餐.png', 'F:\\upload\\158486189501538套餐.png', 'layui开发文档', '系统管理员', '2020-03-22 15:24:55', 0);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工id，主键',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `sex` int(11) NULL DEFAULT 1 COMMENT '性别，1：男，2：女',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `position_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `record` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `card_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `is_del` int(11) NULL DEFAULT 0 COMMENT '是否删除，1：已删除，0：未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '员工一号', 1, '18337281449', '123456@qq.com', '财务主管', '大学本科', '410922123456', '财务部', '河南省濮阳市', '2020-03-15 22:21:44', 0);
INSERT INTO `employee` VALUES (2, '员工二号', 1, '13167403470', '1825764549@qq.com', '普通职员', '大学本科', '410922123456', '人事部', '广州', '2020-03-17 15:20:40', 0);
INSERT INTO `employee` VALUES (3, '员工三号', 1, '13026644411', 'tom@163.com', '技术总监', '大学本科', '2122520', '技术部', '北京市昌平区', '2020-03-17 15:33:17', 0);
INSERT INTO `employee` VALUES (4, '员工四号', 1, '15652968855', '563931768@qq.com', '前端vue开发', '佛山武馆', '41092212311', '前端部', '广东省佛山市', '2020-03-17 15:35:49', 0);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `notice_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告名称',
  `notice_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `notice_creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_del` int(11) NULL DEFAULT 0 COMMENT '是否删除，1：已删除，0：未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '欢迎大家', '欢迎大家到来', '尚晓帅', '2020-03-17 18:00:56', 0);
INSERT INTO `notice` VALUES (2, '感谢大家', '感谢大家到来', '管理员', '2020-03-18 16:18:38', 0);
INSERT INTO `notice` VALUES (3, '今日公告', '今日公告aa', '管理员', '2020-03-18 16:19:05', 0);
INSERT INTO `notice` VALUES (4, '网页改版', '网页改版aa', '管理员', '2020-03-18 16:19:34', 0);
INSERT INTO `notice` VALUES (5, '每日公告', '每日公告aa', '管理员', '2020-03-18 16:20:00', 0);
INSERT INTO `notice` VALUES (6, '焦点访谈', '焦点访谈aa', '系统管理员', '2020-03-18 19:54:47', 0);

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id 主键',
  `position_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_del` int(11) NULL DEFAULT 0 COMMENT '是否删除：1：已删除，0：未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '普通职员', '一名普通人员', '2020-03-14 15:43:27', 0);
INSERT INTO `position` VALUES (2, '财务主管', '一名财务主管', '2020-03-14 15:43:51', 0);
INSERT INTO `position` VALUES (3, '技术总监', '一名技术总监', '2020-03-14 15:44:10', 0);
INSERT INTO `position` VALUES (4, '运维主管', '一名运维主管', '2020-03-14 15:47:45', 0);
INSERT INTO `position` VALUES (5, '人事经理', '人事部门经理', '2020-03-14 15:48:15', 1);
INSERT INTO `position` VALUES (6, '实施主管', '实施部门主管', '2020-03-15 19:01:58', 1);
INSERT INTO `position` VALUES (7, '公司老板', '一名普通老板', '2020-03-15 19:03:12', 0);
INSERT INTO `position` VALUES (8, '前端vue开发', 'vue开发人员', '2020-03-15 19:03:47', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆密码',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色Id，1：管理员，2：普通用户',
  `state` int(11) NULL DEFAULT 2 COMMENT '状态，1：已审核 2：未审核',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_del` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '是否删除，1：已删除，0：未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '系统管理员', 'admin_123', '123456', 1, 1, '2020-03-05 12:56:17', 0);
INSERT INTO `user` VALUES (2, '尚晓帅', 'shangxiaoshuai', '123123', 1, 1, '2020-03-06 11:07:18', 0);
INSERT INTO `user` VALUES (3, '测试', 'admin_test', '122123', 2, 1, '2020-03-11 16:51:50', 0);
INSERT INTO `user` VALUES (4, '测试一号', 'test_one', '123456', 2, 2, '2020-03-13 21:44:31', 0);
INSERT INTO `user` VALUES (5, '测试二号', 'test_tow', '123123', 2, 2, '2020-03-13 22:05:22', 0);

SET FOREIGN_KEY_CHECKS = 1;
