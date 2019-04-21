/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : sportmeeting

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2019-04-21 21:05:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `log_type` enum('NOMAL','ABNOMAL') DEFAULT 'NOMAL' COMMENT '日志类型：nomal正常   abnomal异常',
  `user_id` bigint(20) DEFAULT '0' COMMENT '操作者ID',
  `username` varchar(20) DEFAULT '' COMMENT '操作者',
  `operation` varchar(64) DEFAULT '' COMMENT '操作内容',
  `method_name` varchar(500) DEFAULT '' COMMENT '操作方法名',
  `request_method` enum('OPTIONS','HEAD','DELETE','PATCH','PUT','GET','POST') DEFAULT 'OPTIONS' COMMENT '请求方式',
  `request_param` varchar(500) DEFAULT '' COMMENT '请求参数',
  `remote_ip` varchar(32) DEFAULT '127.0.0.1' COMMENT '远端IP',
  `request_uri` varchar(1000) DEFAULT '' COMMENT '请求uri',
  `exception_code` varchar(32) DEFAULT '500' COMMENT '异常CODE',
  `exception_msg` varchar(5000) DEFAULT 'e' COMMENT '异常信息',
  `time_consuming` int(11) DEFAULT '0' COMMENT '请求耗时(毫秒）',
  `user_agent` varchar(300) DEFAULT '' COMMENT '请求者信息',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted_at` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sport`
-- ----------------------------
DROP TABLE IF EXISTS `t_sport`;
CREATE TABLE `t_sport` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '运动会名称（例如2019年第一届运动会）',
  `start_at` timestamp NULL DEFAULT NULL,
  `end_at` timestamp NULL DEFAULT NULL,
  `remark` text,
  `sport_items` varchar(1024) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sport
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sport_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_sport_item`;
CREATE TABLE `t_sport_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(64) DEFAULT NULL COMMENT '比赛项目名称',
  `item_max_user_num` int(11) DEFAULT '10' COMMENT '限报名人数',
  `item_desc` text COMMENT '项目描述',
  `record` int(11) DEFAULT NULL COMMENT '目前记录',
  `real_record` varchar(64) DEFAULT NULL,
  `record_at` date DEFAULT NULL COMMENT '记录创建时间',
  `record_sport_id` bigint(20) DEFAULT NULL COMMENT '记录对应的运动会信息',
  `record_sport_name` varchar(255) DEFAULT NULL,
  `record_name` varchar(64) DEFAULT NULL COMMENT '记录保持者名称',
  `created_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sport_item
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sport_item_join`
-- ----------------------------
DROP TABLE IF EXISTS `t_sport_item_join`;
CREATE TABLE `t_sport_item_join` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `sport_id` bigint(20) DEFAULT NULL,
  `sport_name` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL COMMENT '评分',
  `real_score` varchar(64) DEFAULT NULL COMMENT '真正的成绩',
  `created_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sport_item_join
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('admin','user') DEFAULT 'user',
  `img` varchar(255) DEFAULT NULL COMMENT '大头贴位置',
  `create_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '刘宏飞', '男', '18309225600', '18309225600@163.com', 'E10ADC3949BA59ABBE56E057F20F883E', 'admin', '/static/assets/img/B131ED23-D908-4E0B-86AF-1FF8D7B28996.jpg', '2019-04-07 16:13:36', null);
