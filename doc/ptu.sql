/*
Navicat MySQL Data Transfer

Source Server         : ptu
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : ptu

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-03-06 17:58:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(8) NOT NULL COMMENT '评论主键',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `create_time` varchar(16) DEFAULT NULL COMMENT '创建时间',
  `user_id` varchar(8) DEFAULT NULL COMMENT '用户id',
  `post_id` varchar(8) DEFAULT NULL COMMENT '业务id（文章或问答）',
  `pid` varchar(8) DEFAULT NULL COMMENT '评论父id(一级评论为空)',
  `reply_user_id` varchar(8) DEFAULT NULL COMMENT '被回复人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('218c2018', '查询成功', '2019021816194419', 'a87ee276', '89a59de3', '25073e10', null);
INSERT INTO `comment` VALUES ('25073e10', '测试查询评论', '2019021214382738', 'c4aceff2', '89a59de3', null, null);
INSERT INTO `comment` VALUES ('32e0136b', '你在说什么', '2019021816410041', '16a3611a', '89a59de3', '25073e10', 'a87ee276');
INSERT INTO `comment` VALUES ('4cf356a5', '测试回复评论', '2019021217263226', 'c4aceff2', '89a59de3', null, null);
INSERT INTO `comment` VALUES ('65aad773', 'fasfzx', '2019022617412441', 'c4aceff2', '4b171b81', null, null);
INSERT INTO `comment` VALUES ('b6914f4b', '这是回复的评论', '2019021217264426', '16a3611a', '89a59de3', '4cf356a5', '');
INSERT INTO `comment` VALUES ('e0b02f10', '第一条评论', '2019021214375737', 'a87ee276', '89a59de3', null, null);

-- ----------------------------
-- Table structure for hot_label
-- ----------------------------
DROP TABLE IF EXISTS `hot_label`;
CREATE TABLE `hot_label` (
  `label_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '标签主键',
  `org_id` int(10) NOT NULL COMMENT '标签所属机构id',
  `label_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签标题',
  `label_hot` int(3) NOT NULL COMMENT '标签热度',
  PRIMARY KEY (`label_id`)
) ENGINE=InnoDB AUTO_INCREMENT=589635 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hot_label
-- ----------------------------
INSERT INTO `hot_label` VALUES ('12312', '3241231', '食堂阿姨', '97');
INSERT INTO `hot_label` VALUES ('23412', '3532421', '宿舍', '70');
INSERT INTO `hot_label` VALUES ('34521', '3453423', '教师', '83');
INSERT INTO `hot_label` VALUES ('132654', '7966547', '运动会', '66');
INSERT INTO `hot_label` VALUES ('234112', '2341112', '学妹', '85');
INSERT INTO `hot_label` VALUES ('589634', '2357453', '学长', '80');

-- ----------------------------
-- Table structure for org_code
-- ----------------------------
DROP TABLE IF EXISTS `org_code`;
CREATE TABLE `org_code` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `org_status` varchar(3) NOT NULL COMMENT '机构代码',
  `org_name` varchar(20) NOT NULL COMMENT '机构名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of org_code
-- ----------------------------
INSERT INTO `org_code` VALUES ('1', '010', '信息工程学院', null);
INSERT INTO `org_code` VALUES ('2', '011', '土木工程学院', null);
INSERT INTO `org_code` VALUES ('3', '012', '机电工程学院', null);
INSERT INTO `org_code` VALUES ('4', '013', '数学学院', null);
INSERT INTO `org_code` VALUES ('5', '014', '管理学院', null);
INSERT INTO `org_code` VALUES ('6', '015', '音乐学院', null);
INSERT INTO `org_code` VALUES ('7', '016', '外国语学院', null);
INSERT INTO `org_code` VALUES ('8', '017', '基础教育学院', null);
INSERT INTO `org_code` VALUES ('9', '018', '医学与药学学院', null);
INSERT INTO `org_code` VALUES ('10', '019', '环境与生物工程学院', null);

-- ----------------------------
-- Table structure for ptu_answer
-- ----------------------------
DROP TABLE IF EXISTS `ptu_answer`;
CREATE TABLE `ptu_answer` (
  `answer_id` varchar(8) NOT NULL COMMENT '问答主键',
  `answer_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问答标题',
  `answer_desc` text NOT NULL COMMENT '问答内容',
  `answer_author` varchar(20) NOT NULL COMMENT '问答作者',
  `answer_date` varchar(16) NOT NULL COMMENT '问答日期',
  `answer_hot` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '60' COMMENT '问答热度',
  `user_id` varchar(8) NOT NULL COMMENT '作者id',
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ptu_answer
-- ----------------------------
INSERT INTO `ptu_answer` VALUES ('4b171b81', '第一条问答', '今天晚上吃什么呢<img src=\"http://localhost:9999/js/layui/images/face/37.gif\" alt=\"[色]\">', 'Xie_东', '2019022517001500', null, 'c4aceff2');

-- ----------------------------
-- Table structure for ptu_news
-- ----------------------------
DROP TABLE IF EXISTS `ptu_news`;
CREATE TABLE `ptu_news` (
  `news_id` varchar(8) NOT NULL,
  `news_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻标题',
  `news_desc` text NOT NULL COMMENT '新闻内容',
  `news_author` varchar(20) NOT NULL COMMENT '新闻作者',
  `news_icon` varchar(255) DEFAULT NULL COMMENT '新闻图片',
  `news_date` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻日期',
  `news_comment` text COMMENT '新闻评论',
  `user_id` varchar(8) NOT NULL COMMENT '作者id',
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ptu_news
-- ----------------------------
INSERT INTO `ptu_news` VALUES ('222gse4t', '今日晚餐', '贾师傅阿斯卡隆发烧了可能性按可分为我就欺负吗啊什么地方暗示可能出现在爱我就放弃奥斯卡你先忙着当前我骗人', 'YangHy', null, '2018111210102320', null, 'a87ee276');
INSERT INTO `ptu_news` VALUES ('235jft67', '明天午餐', '分开静安中心我去开票人在线，。摩擦声请勿喷【公司的可能留下啊，snzxjajpfj奥我就去', '管理员', null, '2018101022103022', null, '16a3611a');
INSERT INTO `ptu_news` VALUES ('24b327ce', '测试标题', '&nbsp; &nbsp;这是第一篇新闻，请多指教<img src=\"http://localhost:8080/js/layui/images/face/1.gif\" alt=\"[嘻嘻]\">', 'Xie_东', null, '2018122115444301', null, 'c4aceff2');
INSERT INTO `ptu_news` VALUES ('604b6864', '今天的天气', '&nbsp; &nbsp; &nbsp;今天的<b><i>天气</i></b>不错<img src=\"http://localhost:8080/js/layui/images/face/1.gif\" alt=\"[嘻嘻]\">，有太阳。加油', 'Xie_东', null, '2019011817062106', null, 'c4aceff2');
INSERT INTO `ptu_news` VALUES ('89a59de3', '今天的天气', '<p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p><p>阿萨德阿萨德</p><p>阿萨德aas</p>', 'Xie_东', null, '2019011817160216', null, 'c4aceff2');
INSERT INTO `ptu_news` VALUES ('93847788', '测是', '<p>阿萨德按时按时阿萨德<img src=\"/uploads/2019011716550255staff.jpg\" alt=\"staff.jpg\"></p><p><img src=\"/uploads/2019011716551055staff.jpg\" alt=\"staff.jpg\"><br></p><p><img src=\"http://localhost:8080/js/layui/images/face/41.gif\" alt=\"[悲伤]\"><br></p>', 'Xie_东', null, '2019011716551655', null, 'c4aceff2');
INSERT INTO `ptu_news` VALUES ('9806065a', '测试图片', '<p>撒打算暗示法许发的人工热啊大师傅是持续而我<img src=\"http://localhost:8080/js/layui/images/face/41.gif\" alt=\"[悲伤]\"><img src=\"http://localhost:8080/js/layui/images/face/43.gif\" alt=\"[黑线]\"></p><p><img src=\"/uploads/2019011716442644staff.jpg\" alt=\"staff.jpg\"><br></p>', 'Xie_东', null, '2019011716442844', null, 'c4aceff2');
INSERT INTO `ptu_news` VALUES ('a438f82b', '第二天', '&nbsp; &nbsp;今天很高心<img src=\"http://localhost:8080/js/layui/images/face/13.gif\" alt=\"[偷笑]\">', 'Xie_东', null, '2018122116001700', null, 'c4aceff2');

-- ----------------------------
-- Table structure for ptu_user
-- ----------------------------
DROP TABLE IF EXISTS `ptu_user`;
CREATE TABLE `ptu_user` (
  `user_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户主键',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `user_pwd` varchar(100) NOT NULL COMMENT '用户密码',
  `user_status` varchar(1) NOT NULL DEFAULT '0' COMMENT '用户身份标识(0：学生，1：教师，2：职工)',
  `org_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户所属机构',
  `user_sex` varchar(1) NOT NULL DEFAULT '0' COMMENT '用户性别(0：男，1：女)',
  `true_name` varchar(20) DEFAULT NULL COMMENT '用户真实姓名',
  `mobile_num` varchar(11) DEFAULT NULL COMMENT '用户手机号码',
  `qq_num` varchar(20) DEFAULT NULL COMMENT '用户qq号',
  `wechat_num` varchar(20) DEFAULT NULL COMMENT '用户微信号',
  `nick_name` varchar(20) NOT NULL COMMENT '昵称',
  `motto` varchar(255) DEFAULT NULL COMMENT '座右铭',
  `org_status` varchar(3) DEFAULT NULL COMMENT '所属机构代码',
  `head_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ptu_user
-- ----------------------------
INSERT INTO `ptu_user` VALUES ('0f42adbc', 'as', 'as', '0', 'as', '0', null, null, null, null, '', null, null, '/uploads/2019030515463646staff.jpg');
INSERT INTO `ptu_user` VALUES ('16a3611a', 'admin', 'e1fc568a83a02acde70e7adc23291857', '0', '管理员', '0', null, null, null, null, '管理员', null, '000', '/uploads/2019030515342434lss.jpg');
INSERT INTO `ptu_user` VALUES ('20132370', 'wbxhyy', 'workinghard', '2', '土木工程学院', '1', null, null, null, null, '', null, '011', '/uploads/2019030515463646staff.jpg');
INSERT INTO `ptu_user` VALUES ('3dd22bb6', 'zz', 'zz', '0', 'zz', '1', null, null, null, null, '', null, null, '/uploads/2019030515463646staff.jpg');
INSERT INTO `ptu_user` VALUES ('53d9f180', 'sa', 'aaa', '0', 'sa', '0', null, null, null, null, '', null, null, '/uploads/2019030515463646staff.jpg');
INSERT INTO `ptu_user` VALUES ('819382d7', 'xiedong1', 'buzhidao', '2', '环环境与生物工程学院', '0', null, null, null, null, '', null, '019', '/uploads/2019030515463646staff.jpg');
INSERT INTO `ptu_user` VALUES ('94384870', 'qq', 'qq', '0', 'qq', '0', null, null, null, null, '', null, null, '/uploads/2019030515463646staff.jpg');
INSERT INTO `ptu_user` VALUES ('96d8eccc', 'bb', 'bb', '0', 'bb', '0', null, null, null, null, '', null, null, '/uploads/2019030515463646staff.jpg');
INSERT INTO `ptu_user` VALUES ('a87ee276', 'yhy', '831b8d4127752404509858bc6cf3599e', '0', '信息工程学院', '1', null, null, null, null, 'YangHy', null, '010', '/uploads/2019030515463646staff.jpg');
INSERT INTO `ptu_user` VALUES ('c3d7dbca', 'aa', 'aa', '0', 'aa', '0', null, null, null, null, '', null, null, '/uploads/2019030515463646staff.jpg');
INSERT INTO `ptu_user` VALUES ('c4aceff2', 'dtdhehe', '21af044c0851fee08c491df31d672f54', '0', '信息工程学院', '0', '', '', '', 'xd474786105', 'Xie_东', '有你东哥在，世界充满爱!', '010', '/uploads/2019030515342434lss.jpg');
