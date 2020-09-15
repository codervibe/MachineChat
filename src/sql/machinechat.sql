/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.5
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3308
 Source Schema         : machinechat

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 08/08/2020 19:41:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES ('你好', '你好，主人');
INSERT INTO `chat` VALUES ('你是谁', '我是你的机器助手，我叫Gideon，中文名叫作吉迪恩，你可以叫我吉迪恩或Gideon');
INSERT INTO `chat` VALUES ('你能干什么', '我能陪你聊天啊，其他的你还没交我呢');
INSERT INTO `chat` VALUES ('你是男是女', '主人，机器人是没有性别的。不过我现在是一个女性的声音， 暂时没有办法更改声音的性别');
INSERT INTO `chat` VALUES ('Gideon', '我一直都在，主人');
INSERT INTO `chat` VALUES ('吉迪恩', '我一直都在，主人');
INSERT INTO `chat` VALUES ('天气', '好的正在为您查询 天气.....');
INSERT INTO `chat` VALUES ('打个招呼吧', '你好');

SET FOREIGN_KEY_CHECKS = 1;
