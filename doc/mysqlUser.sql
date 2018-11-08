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
