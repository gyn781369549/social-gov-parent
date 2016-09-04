/*
Navicat MySQL Data Transfer

Source Server         : 社区数据库
Source Server Version : 50626
Source Host           : 124.232.163.80:3308
Source Database       : nmonline

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-09-04 09:37:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for social_area
-- ----------------------------
DROP TABLE IF EXISTS `social_area`;
CREATE TABLE `social_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='行政区域的描述';

-- ----------------------------
-- Records of social_area
-- ----------------------------
INSERT INTO `social_area` VALUES ('1', '长沙社区', null, null, '1', null, null, null, null);
INSERT INTO `social_area` VALUES ('2', '撒和社区', null, null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for social_course
-- ----------------------------
DROP TABLE IF EXISTS `social_course`;
CREATE TABLE `social_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) DEFAULT NULL,
  `course_type` int(11) DEFAULT '1',
  `course_class` int(11) DEFAULT '1',
  `bumen_id` int(11) DEFAULT NULL,
  `abbr_pic` varchar(150) DEFAULT NULL,
  `course_brief` varchar(2000) DEFAULT NULL,
  `attach_path` varchar(150) DEFAULT NULL,
  `attach_type` int(11) DEFAULT NULL,
  `status` int(11) unsigned DEFAULT '0',
  `pub_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of social_course
-- ----------------------------
INSERT INTO `social_course` VALUES ('4', '课程1111111', '1', '1', '2', 'course/upload/1471528575097.jpg', '课程1111111课程1111111课程1111111课程1111111课程1111111课程1111111课程1111111课程1111111课程1111111课程1111111课程1111111', 'course/upload/1471529711515.doc', '1', '1', '2016-08-31 22:32:31');
INSERT INTO `social_course` VALUES ('5', 'pdf课程', '1', '1', '2', 'course/upload/1471531999641.jpg', 'pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程', 'course/upload/1471532020908.pdf', '3', '0', '2016-08-18 22:53:45');
INSERT INTO `social_course` VALUES ('6', 'pdf课程', '1', '1', '2', 'course/upload/1471531999641.jpg', 'pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程pdf课程', 'course/upload/1471532020908.pdf', '3', '1', '2016-08-18 22:55:18');
INSERT INTO `social_course` VALUES ('7', '柘城檽', '1', '1', '2', 'course/upload/1471532217511.jpg', '柘城檽柘城檽柘城檽柘城檽柘城檽柘城檽柘城檽柘城檽柘城檽柘城檽', 'course/upload/1471532232783.pdf', '3', '0', '2016-08-18 22:57:22');
INSERT INTO `social_course` VALUES ('8', '圧圧厅厅', '1', '1', '2', 'course/upload/1471532401597.jpg', '圧圧厅厅圧圧厅厅圧圧厅厅圧圧厅厅圧圧厅厅圧圧厅厅圧圧厅厅', 'course/upload/1471532414382.pdf', '3', '0', '2016-08-31 22:34:37');
INSERT INTO `social_course` VALUES ('9', '12345', '1', '1', '2', '', '12345566', 'course/upload/1472652009898.ppt', '1', '1', '2016-08-31 22:00:35');
INSERT INTO `social_course` VALUES ('10', '发表1', '1', '1', '2', '', '发表1发表1发表1发表1发表1发表1', 'course/upload/1472652960434.doc', '1', '0', '2016-08-31 22:16:07');
INSERT INTO `social_course` VALUES ('11', '发表1', '1', '1', '2', '', '发表1发表1发表1发表1发表1发表1', 'course/upload/1472652960434.doc', '1', '0', '2016-08-31 22:16:15');
INSERT INTO `social_course` VALUES ('12', '发表1', '1', '1', '2', '', '发表1发表1发表1发表1发表1发表1', 'course/upload/1472652960434.doc', '1', '0', '2016-08-31 22:16:22');
INSERT INTO `social_course` VALUES ('13', '234444444444444444444444444', '2', '1', '2', '', '夺仍人人 遥胅', 'course/upload/1472653092673.MP4', '2', '1', '2016-08-31 22:18:16');

-- ----------------------------
-- Table structure for social_course_attach
-- ----------------------------
DROP TABLE IF EXISTS `social_course_attach`;
CREATE TABLE `social_course_attach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `attach_path` varchar(150) DEFAULT NULL,
  `attach_kind` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of social_course_attach
-- ----------------------------
INSERT INTO `social_course_attach` VALUES ('11', '4', 'course/upload/1471529711515.html', null, '2016-08-18 22:15:20');
INSERT INTO `social_course_attach` VALUES ('12', '8', 'course/upload/pdf/1471532414382_0.png', null, '2016-08-18 23:00:34');
INSERT INTO `social_course_attach` VALUES ('13', '8', 'course/upload/pdf/1471532414382_1.png', null, '2016-08-18 23:00:35');
INSERT INTO `social_course_attach` VALUES ('14', '8', 'course/upload/pdf/1471532414382_2.png', null, '2016-08-18 23:00:35');
INSERT INTO `social_course_attach` VALUES ('15', '8', 'course/upload/pdf/1471532414382_3.png', null, '2016-08-18 23:00:36');
INSERT INTO `social_course_attach` VALUES ('16', '8', 'course/upload/pdf/1471532414382_4.png', null, '2016-08-18 23:00:37');
INSERT INTO `social_course_attach` VALUES ('17', '9', 'course/upload/ppt/1472652009898_1.jpeg', null, '2016-08-31 22:01:13');
INSERT INTO `social_course_attach` VALUES ('18', '9', 'course/upload/ppt/1472652009898_2.jpeg', null, '2016-08-31 22:01:13');
INSERT INTO `social_course_attach` VALUES ('19', '12', 'course/upload/1472652960434.html', null, '2016-08-31 22:16:25');
INSERT INTO `social_course_attach` VALUES ('20', '11', 'course/upload/1472652960434.html', null, '2016-08-31 22:16:25');
INSERT INTO `social_course_attach` VALUES ('21', '10', 'course/upload/1472652960434.html', null, '2016-08-31 22:16:25');

-- ----------------------------
-- Table structure for social_course_browse
-- ----------------------------
DROP TABLE IF EXISTS `social_course_browse`;
CREATE TABLE `social_course_browse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT '1',
  `browse_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of social_course_browse
-- ----------------------------
INSERT INTO `social_course_browse` VALUES ('1', '8', '1', '2016-08-31 20:58:57');
INSERT INTO `social_course_browse` VALUES ('2', '8', '1', '2016-08-31 21:36:02');
INSERT INTO `social_course_browse` VALUES ('3', '8', '1', '2016-08-31 21:37:15');
INSERT INTO `social_course_browse` VALUES ('4', '8', '1', '2016-08-31 21:39:01');
INSERT INTO `social_course_browse` VALUES ('5', '8', '1', '2016-08-31 21:40:13');
INSERT INTO `social_course_browse` VALUES ('6', '8', '1', '2016-08-31 21:53:20');

-- ----------------------------
-- Table structure for social_course_comment
-- ----------------------------
DROP TABLE IF EXISTS `social_course_comment`;
CREATE TABLE `social_course_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT '1',
  `comment_text` varchar(300) DEFAULT NULL,
  `comment_time` datetime DEFAULT NULL,
  `reply_text` varchar(300) DEFAULT NULL,
  `show_flag` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `reply_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of social_course_comment
-- ----------------------------
INSERT INTO `social_course_comment` VALUES ('1', '8', '1', '看看我的留言', '2016-08-31 20:59:18', '查看回忆', '0', '1', '2016-08-31 21:00:39');
INSERT INTO `social_course_comment` VALUES ('2', '8', '1', '12344444444444', '2016-08-31 21:53:52', null, '0', '0', null);

-- ----------------------------
-- Table structure for social_dept
-- ----------------------------
DROP TABLE IF EXISTS `social_dept`;
CREATE TABLE `social_dept` (
  `name` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `connecter` varchar(50) DEFAULT NULL,
  `conphone` varchar(50) DEFAULT NULL,
  `lphone` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `smallnote` varchar(50) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `smalladdress` varchar(50) DEFAULT NULL,
  `classtype` varchar(50) DEFAULT NULL,
  `otherdelFlag` varchar(50) DEFAULT NULL,
  `otherclasstype` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leader` varchar(50) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of social_dept
-- ----------------------------
INSERT INTO `social_dept` VALUES ('宣传部', '宣传部', null, null, null, null, null, null, null, '0', null, null, null, null, '1', null, null, null, null, '2016-08-07 11:30:17');
INSERT INTO `social_dept` VALUES ('市宣部', '市宣部', null, null, null, null, null, null, null, '0', null, null, null, null, '2', null, null, null, null, '2016-08-07 13:30:22');

-- ----------------------------
-- Table structure for social_grid_info
-- ----------------------------
DROP TABLE IF EXISTS `social_grid_info`;
CREATE TABLE `social_grid_info` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '网格信息id',
  `area_id` int(5) DEFAULT NULL COMMENT '行政区id',
  `grid_num` varchar(50) DEFAULT NULL COMMENT '网格编号',
  `grid_name` varchar(30) DEFAULT NULL COMMENT '网格名称',
  `grid_type` tinyint(4) DEFAULT NULL COMMENT '网格类型',
  `grid_area` double DEFAULT NULL COMMENT '网格面积',
  `grid_households` int(10) DEFAULT NULL COMMENT '网格户数',
  `grid_address` varchar(80) DEFAULT NULL COMMENT '网格地址',
  `grid_describe` varchar(200) DEFAULT NULL COMMENT '网格描述',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=713 DEFAULT CHARSET=utf8 COMMENT='网格信息';

-- ----------------------------
-- Records of social_grid_info
-- ----------------------------
INSERT INTO `social_grid_info` VALUES ('1', '1', null, '天心区网格', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for social_interaction_befriend
-- ----------------------------
DROP TABLE IF EXISTS `social_interaction_befriend`;
CREATE TABLE `social_interaction_befriend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `area_id` int(11) NOT NULL COMMENT '社区id',
  `checkk` int(11) DEFAULT '0' COMMENT '审核是否通过0待审核&1审核通过 &2被驳回 默认0',
  `display_phone` int(11) DEFAULT '0' COMMENT '是否显示联系方式 0不显示 1显示',
  `phone` varchar(64) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `link_time` varchar(64) DEFAULT NULL COMMENT '联系时间范围',
  `time` date DEFAULT NULL COMMENT '申请时间（年月日）',
  `content` varchar(255) DEFAULT NULL COMMENT '帮助内容简介',
  `is_charged` int(11) DEFAULT '0' COMMENT '是否收费 0免费&1收费 默认0',
  `charged` varchar(64) DEFAULT NULL COMMENT '收费说明',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `feature` int(11) DEFAULT '0' COMMENT '组织特性0公益&1 默认0',
  `come` int(11) DEFAULT '0' COMMENT '  状态 0求助&1帮助 默认0',
  `code` varchar(64) DEFAULT NULL COMMENT ' 组织机构代码默认0',
  `log` varchar(64) DEFAULT NULL COMMENT '经度 ',
  `lat` varchar(64) DEFAULT NULL COMMENT ' 纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='邻帮_帮助信息表';

-- ----------------------------
-- Records of social_interaction_befriend
-- ----------------------------
INSERT INTO `social_interaction_befriend` VALUES ('1', '86', '1', '0', '0', '10086', '北京', '1-9', '2016-08-31', '内容', '0', '1小时99元', null, '0', '0', 'qere1', 'jingdu', 'weidu');

-- ----------------------------
-- Table structure for social_interaction_comment
-- ----------------------------
DROP TABLE IF EXISTS `social_interaction_comment`;
CREATE TABLE `social_interaction_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sib_id` int(11) NOT NULL COMMENT '邻帮_帮助信息表id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `checkk` int(11) DEFAULT '0' COMMENT '审核是否通过0待审核&1审核通过 &2被驳回默认0',
  `time` datetime DEFAULT NULL COMMENT '申请时间（年月日时分秒）',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `star` int(11) DEFAULT '0' COMMENT '评级 满意度1-5星星 默认0',
  `source` int(11) DEFAULT '0' COMMENT '0邻帮_帮助信息表1社区公示表2意见箱3',
  `is_reply` int(11) DEFAULT '0' COMMENT '0未回复1已回复',
  `screen` int(11) DEFAULT '0' COMMENT '是否屏蔽   0未屏蔽&1屏蔽 默认0',
  `type` int(11) DEFAULT '0' COMMENT '问题种类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='帮助信息评论表';

-- ----------------------------
-- Records of social_interaction_comment
-- ----------------------------
INSERT INTO `social_interaction_comment` VALUES ('1', '111', '86', '0', '2017-08-30 18:42:13', '平了', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for social_interaction_focus
-- ----------------------------
DROP TABLE IF EXISTS `social_interaction_focus`;
CREATE TABLE `social_interaction_focus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_id` int(11) NOT NULL COMMENT '社区id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `content` text COMMENT '正文',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `start_time` date DEFAULT NULL COMMENT '有效期起',
  `stop_time` date DEFAULT NULL COMMENT '有效期止',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `type` int(11) DEFAULT NULL COMMENT '类型 1社区公示 0 活动信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='社区公示表（social_ interaction_focus）';

-- ----------------------------
-- Records of social_interaction_focus
-- ----------------------------
INSERT INTO `social_interaction_focus` VALUES ('1', '1', '86', null, null, null, null, null, null, null);
INSERT INTO `social_interaction_focus` VALUES ('2', '1', '86', null, null, null, null, null, null, null);
INSERT INTO `social_interaction_focus` VALUES ('3', '1', '86', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for social_interaction_good
-- ----------------------------
DROP TABLE IF EXISTS `social_interaction_good`;
CREATE TABLE `social_interaction_good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `social_ interaction_comment_id` int(11) NOT NULL COMMENT '评论id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `good` int(11) DEFAULT '0' COMMENT '0没用1有用',
  `c_heck` int(11) DEFAULT '0' COMMENT '区分来源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='6.统计有用没用表（social_ interaction_good）';

-- ----------------------------
-- Records of social_interaction_good
-- ----------------------------

-- ----------------------------
-- Table structure for social_interaction_msg
-- ----------------------------
DROP TABLE IF EXISTS `social_interaction_msg`;
CREATE TABLE `social_interaction_msg` (
  `id` int(11) DEFAULT NULL COMMENT '消息id',
  `from` int(11) DEFAULT NULL COMMENT '消息来源——用户id',
  `to` int(11) DEFAULT NULL COMMENT '消息目标——用户id',
  `message` varchar(1000) DEFAULT NULL COMMENT '消息内容',
  `time` datetime DEFAULT NULL COMMENT '发送消息时间',
  `read_time` datetime DEFAULT NULL COMMENT '读取消息时间',
  `status` char(2) DEFAULT NULL COMMENT '消息状态：0：未读；1：已读；2：忽略',
  `msg_type` char(2) DEFAULT NULL COMMENT '消息类型：0；私信；2：系统消息；以此类推'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of social_interaction_msg
-- ----------------------------

-- ----------------------------
-- Table structure for social_interaction_parliament
-- ----------------------------
DROP TABLE IF EXISTS `social_interaction_parliament`;
CREATE TABLE `social_interaction_parliament` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_id` int(11) NOT NULL COMMENT '社区id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  PRIMARY KEY (`id`),
  UNIQUE KEY `area_id` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='居民议事会表';

-- ----------------------------
-- Records of social_interaction_parliament
-- ----------------------------
INSERT INTO `social_interaction_parliament` VALUES ('1', '1', '1', '2016-08-31 15:30:25', '议事会名');

-- ----------------------------
-- Table structure for social_interaction_person
-- ----------------------------
DROP TABLE IF EXISTS `social_interaction_person`;
CREATE TABLE `social_interaction_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parliament_id` int(11) NOT NULL COMMENT '居民议事会表id',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `content` varchar(255) DEFAULT NULL COMMENT '简要说明',
  `type` varchar(25) DEFAULT NULL COMMENT '职位类型',
  `phone` varchar(25) DEFAULT NULL COMMENT '联系电话',
  `name` varchar(25) DEFAULT NULL COMMENT '会员姓名',
  `pic` varchar(25) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='议员表';

-- ----------------------------
-- Records of social_interaction_person
-- ----------------------------
INSERT INTO `social_interaction_person` VALUES ('1', '1', '2016-08-31 17:24:25', '1', '1', '1', 'qwer', null);
INSERT INTO `social_interaction_person` VALUES ('2', '1', '2016-09-01 17:35:35', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for social_member
-- ----------------------------
DROP TABLE IF EXISTS `social_member`;
CREATE TABLE `social_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `verify` tinyint(4) DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL,
  `id_card_front_path` varchar(200) DEFAULT NULL,
  `id_card_back_path` varchar(200) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `rejection` varchar(500) DEFAULT NULL,
  `head_img` varchar(200) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `nick_name` varchar(100) DEFAULT NULL,
  `device_type` tinyint(20) DEFAULT NULL,
  `device_token` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_social_member_user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='社区管家注册用户';

-- ----------------------------
-- Records of social_member
-- ----------------------------
INSERT INTO `social_member` VALUES ('86', 'zzzzzz', null, '1111', null, null, null, null, null, null, null, null, '1', '2', null, null, '1111', null, null);
INSERT INTO `social_member` VALUES ('87', 'yyyyy', null, '2222', null, null, null, null, null, null, null, null, '1', '2', null, null, '1111', null, null);

-- ----------------------------
-- Table structure for social_member_area
-- ----------------------------
DROP TABLE IF EXISTS `social_member_area`;
CREATE TABLE `social_member_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `area_id` int(11) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of social_member_area
-- ----------------------------
INSERT INTO `social_member_area` VALUES ('124', '86', '1', '2016-08-29 16:54:16');

-- ----------------------------
-- Table structure for social_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `social_sys_user`;
CREATE TABLE `social_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN_NAME` varchar(20) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `MOBILE` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `SEX` char(1) DEFAULT NULL,
  `QQ` varchar(20) DEFAULT NULL,
  `TEL` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(200) DEFAULT NULL,
  `ROLE_ID` int(11) DEFAULT NULL,
  `COMMUNITY_ID` int(11) DEFAULT NULL,
  `NET_ID` int(11) DEFAULT NULL,
  `DEPT_ID` int(11) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `user_type` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户的管理';

-- ----------------------------
-- Records of social_sys_user
-- ----------------------------
INSERT INTO `social_sys_user` VALUES ('1', 'xiaojun', '晓君', null, null, null, null, null, null, null, '1', '1', null, null, null, null, null, null, null, null);
