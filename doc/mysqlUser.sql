-- 教师
CREATE TABLE `t_term` (
`termid` bigint NOT NULL AUTO_INCREMENT,
year  integer,
  month integer,
  termtype integer,
  createTime  time,
  updateTime time,
  iseff  integer,
PRIMARY KEY (`termid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='期数表';


-- 教师
CREATE TABLE `t_teacherPrice` (
`teacherId` bigint NOT NULL AUTO_INCREMENT,
`teacherName` varchar(100),
`unitprice`    integer,
`sumprice`  integer,
`iscompany` integer,
`companyname` varchar(100),
`sfz` varchar(100),
`bankname` varchar(100),
`bankno` varchar(100),
`memo`   varchar(100),
`createTime` datetime,
`updateTime` datetime,
`iseff`  int,
PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师';



-- 班级表
CREATE TABLE `t_class` (
 `classid` bigint NOT NULL AUTO_INCREMENT,
  classname  integer comment '班级名称',
  classtype integer comment '11:AF, 12:CF, 21:免费短训,22:收费短训',
  createTime  time,
  updateTime time,
  iseff  integer,
PRIMARY KEY (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级表';

CREATE TABLE `t_monthteacher` (
 `monthteacherid` bigint NOT NULL AUTO_INCREMENT,
  termid  integer comment '期数编号',
  teacherId integer comment '11:AF, 12:CF, 21:免费短训,22:收费短训',
  unitprice  DECIMAL(8,2),
  sumhour integer,
  sumprice  DECIMAL(8,2),
  createTime  time,
  updateTime time,
  iseff  integer,
PRIMARY KEY (`monthteacherid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级表';

CREATE TABLE `t_monthclass` (
 `monthclassid` bigint NOT NULL AUTO_INCREMENT,
  termid  integer comment '期数编号',
  classid integer comment '班级编号',
  createTime  time,
  updateTime time,
  iseff  integer,
PRIMARY KEY (`monthclassid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='月度班级表';


CREATE TABLE `t_monthteacherclass` (
 `mtmcId` bigint NOT NULL AUTO_INCREMENT,
  monthteacherid  integer comment '月度教师课时主表id',
  classid integer comment '班级编号',
  classhour  integer,
  PRIMARY KEY (`mtmcId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='月度班级表';
