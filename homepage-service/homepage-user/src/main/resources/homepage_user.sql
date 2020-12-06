-- 数据库
CREATE DATABASE imooc_homepage_sc;

-- 用户信息表
CREATE TABLE IF NOT EXISTS `imooc_homepage_sc`.`homepage_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增 id',
  `username` varchar(128) NOT NULL DEFAULT '' COMMENT '用户名',
  `email` varchar(128) NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户信息表';

-- 用户课程表
CREATE TABLE IF NOT EXISTS `imooc_homepage_sc`.`homepage_user_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增 id',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户 id',
  `course_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '课程 id',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_user_course` (`user_id`, `course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户课程表';
