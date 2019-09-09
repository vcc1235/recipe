/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : recipe

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 23/08/2019 22:52:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `food_id` char(32) NOT NULL,
  `food_name` char(255) NOT NULL COMMENT '菜名',
  `food_img` text NOT NULL COMMENT '菜图片',
  `food_dec` char(255) NOT NULL COMMENT '菜描述',
  `food_list` varchar(255) NOT NULL COMMENT '材料列表',
  `foot_num` int(11) DEFAULT NULL COMMENT '浏览量',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `tb_status` char(50) DEFAULT '正常' COMMENT '状态：正常，正常；删除，删除；',
  `food_step` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for meal
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal` (
  `meal_id` int(6) NOT NULL AUTO_INCREMENT,
  `meal_name` varchar(255) NOT NULL COMMENT '菜单名',
  `meal_type` varchar(255) NOT NULL COMMENT '菜单',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `tb_status` char(50) DEFAULT '正常' COMMENT '状态：正常，正常；删除，删除；',
  PRIMARY KEY (`meal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for step
-- ----------------------------
DROP TABLE IF EXISTS `step`;
CREATE TABLE `step` (
  `step_id` int(11) NOT NULL AUTO_INCREMENT,
  `step_step` int(255) NOT NULL COMMENT '步骤',
  `step_name` varchar(255) NOT NULL COMMENT '步骤标题',
  `step_img` text NOT NULL COMMENT '步骤图片',
  `foot_id` char(11) NOT NULL COMMENT '菜的id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `tb_status` char(50) DEFAULT '正常' COMMENT '状态：正常，正常；删除，删除；',
  PRIMARY KEY (`step_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
