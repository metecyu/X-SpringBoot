/*
Navicat SQLite Data Transfer

Source Server         : x_springboot
Source Server Version : 30623
Source Host           : localhost:0

Target Server Type    : SQLite
Target Server Version : 30000
File Encoding         : 65001

Date: 2018-11-08 10:33:51
*/

PRAGMA foreign_keys = OFF;



-- ----------------------------
-- Table structure for "sys_config"
-- ----------------------------

CREATE TABLE "sys_config" (
"id"  integer PRIMARY KEY AUTOINCREMENT,
"key"  varchar(50),
"value"  varchar(2000),
"status"  integer,
"remark"  varchar(500)
)

;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO "sys_config" VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', 0, '云存储配置信息');
COMMIT;

-- ----------------------------
-- Table structure for "sys_log"
-- ----------------------------

CREATE TABLE "sys_log" (
"id"  integer PRIMARY KEY AUTOINCREMENT NOT NULL,
"username"  varchar(50),
"operation"  varchar(50),
"method"  varchar(200),
"params"  varchar(5000),
"time"  integer NOT NULL,
"ip"  varchar(64),
"create_date"  datetime
)

;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "sys_menu"
-- ----------------------------

CREATE TABLE "sys_menu" (
"menu_id"  integer PRIMARY KEY AUTOINCREMENT NOT NULL,
"parent_id"  integer,
"name"  varchar(50),
"url"  varchar(200),
"perms"  varchar(500),
"type"  integer,
"icon"  varchar(50),
"order_num"  integer
)

;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO "sys_menu" VALUES (1, 0, '系统管理', null, null, 0, 'fa fa-cog', 0);
INSERT INTO "sys_menu" VALUES (2, 1, '管理员列表', 'modules/sys/user.html', null, 1, 'fa fa-user', 1);
INSERT INTO "sys_menu" VALUES (3, 1, '角色管理', 'modules/sys/role.html', null, 1, 'fa fa-user-secret', 2);
INSERT INTO "sys_menu" VALUES (4, 1, '菜单管理', 'modules/sys/menu.html', null, 1, 'fa fa-th-list', 3);
INSERT INTO "sys_menu" VALUES (5, 1, 'SQL监控', 'druid/sql.html', null, 1, 'fa fa-bug', 4);
INSERT INTO "sys_menu" VALUES (6, 1, '定时任务', 'modules/job/schedule.html', null, 1, 'fa fa-tasks', 5);
INSERT INTO "sys_menu" VALUES (7, 6, '查看', null, 'sys:schedule:list,sys:schedule:info', 2, null, 0);
INSERT INTO "sys_menu" VALUES (8, 6, '新增', null, 'sys:schedule:save', 2, null, 0);
INSERT INTO "sys_menu" VALUES (9, 6, '修改', null, 'sys:schedule:update', 2, null, 0);
INSERT INTO "sys_menu" VALUES (10, 6, '删除', null, 'sys:schedule:delete', 2, null, 0);
INSERT INTO "sys_menu" VALUES (11, 6, '暂停', null, 'sys:schedule:pause', 2, null, 0);
INSERT INTO "sys_menu" VALUES (12, 6, '恢复', null, 'sys:schedule:resume', 2, null, 0);
INSERT INTO "sys_menu" VALUES (13, 6, '立即执行', null, 'sys:schedule:run', 2, null, 0);
INSERT INTO "sys_menu" VALUES (14, 6, '日志列表', null, 'sys:schedule:log', 2, null, 0);
INSERT INTO "sys_menu" VALUES (15, 2, '查看', null, 'sys:user:list,sys:user:info', 2, null, 0);
INSERT INTO "sys_menu" VALUES (16, 2, '新增', null, 'sys:user:save,sys:role:select', 2, null, 0);
INSERT INTO "sys_menu" VALUES (17, 2, '修改', null, 'sys:user:update,sys:role:select', 2, null, 0);
INSERT INTO "sys_menu" VALUES (18, 2, '删除', null, 'sys:user:delete', 2, null, 0);
INSERT INTO "sys_menu" VALUES (19, 3, '查看', null, 'sys:role:list,sys:role:info', 2, null, 0);
INSERT INTO "sys_menu" VALUES (20, 3, '新增', null, 'sys:role:save,sys:menu:list', 2, null, 0);
INSERT INTO "sys_menu" VALUES (21, 3, '修改', null, 'sys:role:update,sys:menu:list', 2, null, 0);
INSERT INTO "sys_menu" VALUES (22, 3, '删除', null, 'sys:role:delete', 2, null, 0);
INSERT INTO "sys_menu" VALUES (23, 4, '查看', null, 'sys:menu:list,sys:menu:info', 2, null, 0);
INSERT INTO "sys_menu" VALUES (24, 4, '新增', null, 'sys:menu:save,sys:menu:select', 2, null, 0);
INSERT INTO "sys_menu" VALUES (25, 4, '修改', null, 'sys:menu:update,sys:menu:select', 2, null, 0);
INSERT INTO "sys_menu" VALUES (26, 4, '删除', null, 'sys:menu:delete', 2, null, 0);
INSERT INTO "sys_menu" VALUES (27, 1, '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'fa fa-sun-o', 6);
INSERT INTO "sys_menu" VALUES (29, 1, '系统日志', 'modules/sys/log.html', 'sys:log:list', 1, 'fa fa-file-text-o', 7);
INSERT INTO "sys_menu" VALUES (30, 1, '文件上传', 'modules/oss/oss.html', 'sys:oss:all', 1, 'fa fa-file-image-o', 6);
COMMIT;

-- ----------------------------
-- Table structure for "sys_oss"
-- ----------------------------
CREATE TABLE "sys_oss" (
"id"  integer PRIMARY KEY AUTOINCREMENT NOT NULL,
"url"  varchar(200),
"create_date"  datetime
)

;

-- ----------------------------
-- Records of sys_oss
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "sys_role"
-- ----------------------------
CREATE TABLE "sys_role" (
"role_id"  integer PRIMARY KEY AUTOINCREMENT NOT NULL,
"role_name"  varchar(100),
"remark"  varchar(100),
"create_user_id"  integer,
"create_time"  datetime
)

;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "sys_role_menu"
-- ----------------------------

CREATE TABLE "sys_role_menu" (
"id"  integer PRIMARY KEY AUTOINCREMENT NOT NULL,
"role_id"  integer,
"menu_id"  integer
)

;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "sys_user"
-- ----------------------------

CREATE TABLE "sys_user" (
"user_id"  integer PRIMARY KEY AUTOINCREMENT NOT NULL,
"username"  varchar(50) NOT NULL,
"password"  varchar(100),
"salt"  varchar(20),
"email"  varchar(100),
"mobile"  varchar(100),
"status"  integer,
"create_user_id"  integer,
"create_time"  datetime
)

;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO "sys_user" VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'yzcheng90@qq.com', 13888888888, 1, 1, '2018-1-18 11:11:11');
COMMIT;

-- ----------------------------
-- Table structure for "sys_user_role"
-- ----------------------------

CREATE TABLE "sys_user_role" (
"id"  integer PRIMARY KEY AUTOINCREMENT NOT NULL,
"user_id"  integer,
"role_id"  integer
)

;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "sys_user_token"
-- ----------------------------

CREATE TABLE "sys_user_token" (
"user_id"  integer NOT NULL,
"token"  varchar(100) NOT NULL,
"expire_time"  datetime DEFAULT NULL,
"update_time"  datetime DEFAULT NULL,
PRIMARY KEY ("user_id" ASC)
)

;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "tb_user"
-- ----------------------------

CREATE TABLE "tb_user" (
"user_id"  integer PRIMARY KEY AUTOINCREMENT NOT NULL,
"username"  varchar(50) NOT NULL,
"mobile"  varchar(20) NOT NULL,
"password"  varchar(64),
"create_time"  datetime
)

;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO "tb_user" VALUES (1, 'mark', 13612345678, '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');
COMMIT;

-- ----------------------------
-- Auto increment value for "sys_config"
-- ----------------------------
UPDATE sqlite_sequence SET seq = 1 WHERE name = "sys_config";

-- ----------------------------
-- Auto increment value for "sys_menu"
-- ----------------------------
UPDATE sqlite_sequence SET seq = 30 WHERE name = "sys_menu";

-- ----------------------------
-- Auto increment value for "sys_user"
-- ----------------------------
UPDATE sqlite_sequence SET seq = 1 WHERE name = "sys_user";

-- ----------------------------
-- Auto increment value for "tb_user"
-- ----------------------------
UPDATE sqlite_sequence SET seq = 1 WHERE name = "tb_user";
