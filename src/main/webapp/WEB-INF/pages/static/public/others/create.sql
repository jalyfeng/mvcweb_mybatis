CREATE DATABASE mybatis;

USE mybatis;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(40) NOT NULL COMMENT '用户名',
  `password` varchar(40) NOT NULL COMMENT '密码',
  `email` varchar(40) DEFAULT NULL COMMENT '邮件',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` char(2) NOT NULL COMMENT '性别',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8