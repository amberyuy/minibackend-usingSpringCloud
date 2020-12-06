
-- 课程表
CREATE TABLE IF NOT EXISTS `imooc_homepage_sc`.`homepage_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增 id',
  `course_name` varchar(128) NOT NULL DEFAULT '' COMMENT '课程名称',
  `course_type` varchar(128) NOT NULL DEFAULT '' COMMENT '课程类型',
  `course_icon` varchar(128) NOT NULL DEFAULT '' COMMENT '课程图标',
  `course_intro` varchar(128) NOT NULL DEFAULT '' COMMENT '课程介绍',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_course_name` (`course_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程表';
