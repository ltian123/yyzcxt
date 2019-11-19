


--服务分类表t_serviceCategory
CREATE TABLE t_serviceCategory
(
  ID         VARCHAR2(36 BYTE)       NOT NULL,
  SC_TITLE      VARCHAR2(100 BYTE),
  SC_TYPE     VARCHAR2(36 BYTE),
  CREATETIME    DATE,
  CREATEUSER  VARCHAR2(36 BYTE),
  ISOPEN    VARCHAR2(36 BYTE),
  PID   VARCHAR2(36 BYTE),
  SORT   NUMBER,
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT SC_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_SERVICECATEGORY" is '服务分类表';
comment on column  "T_SERVICECATEGORY"."ID"  is '主键ID';
comment on column  "T_SERVICECATEGORY"."SC_TITLE"  is '服务分类标题';
comment on column  "T_SERVICECATEGORY"."SC_TYPE"  is '服务类型';
comment on column  "T_SERVICECATEGORY"."CREATETIME"  is '创建时间';
comment on column  "T_SERVICECATEGORY"."CREATEUSER"  is '创建人';
comment on column  "T_SERVICECATEGORY"."ISOPEN"  is '是否开放';
comment on column  "T_SERVICECATEGORY"."PID"  is '父节点ID';
comment on column  "T_SERVICECATEGORY"."SORT"  is '序号';
comment on column  "T_SERVICECATEGORY"."FIELD1"  is '备用1';
comment on column  "T_SERVICECATEGORY"."FIELD2"  is '备用2';
comment on column  "T_SERVICECATEGORY"."FIELD3"  is '备用3';


--服务接口表
--t_serviceInterface
CREATE TABLE t_serviceInterface
(
  ID         VARCHAR2(36 BYTE)       NOT NULL,
  SI_TITLE      VARCHAR2(100 BYTE),
  DESCIBE     VARCHAR2(100 BYTE),
  CREATEUSER   VARCHAR2(36 BYTE),
  ISOPEN  VARCHAR2(36 BYTE),
  SC_ID    VARCHAR2(36 BYTE),
  SI_TOKEN   VARCHAR2(36 BYTE),
  REAL_URL   VARCHAR2(100 BYTE),
  ISLOCALSERVICE      NUMBER,
  SORT      NUMBER,
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT SI_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_SERVICEINTERFACE" is '服务接口表';
comment on column  "T_SERVICEINTERFACE"."ID"  is '主键ID';
comment on column  "T_SERVICEINTERFACE"."SI_TITLE"  is '接口名';
comment on column  "T_SERVICEINTERFACE"."DESCIBE"  is '描述';
comment on column  "T_SERVICEINTERFACE"."CREATEUSER"  is '创建人';
comment on column  "T_SERVICEINTERFACE"."ISOPEN"  is '是否开放';
comment on column  "T_SERVICEINTERFACE"."SC_ID"  is '所属分类ID';
comment on column  "T_SERVICEINTERFACE"."SI_TOKEN"  is '接口token';
comment on column  "T_SERVICEINTERFACE"."REAL_URL"  is '接口实际地址';
comment on column  "T_SERVICEINTERFACE"."ISLOCALSERVICE"  is '是否为本地服务';
comment on column  "T_SERVICEINTERFACE"."SORT"  is '序号';
comment on column  "T_SERVICEINTERFACE"."FIELD1"  is '备用1';
comment on column  "T_SERVICEINTERFACE"."FIELD2"  is '备用2';
comment on column  "T_SERVICEINTERFACE"."FIELD3"  is '备用3';

--应用表
--t_applicationAccess
CREATE TABLE t_applicationAccess
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  APP_FULLNAME      VARCHAR2(100 BYTE),
  APP_SHORTNAME     VARCHAR2(100 BYTE),
  CREATEUSER   VARCHAR2(100 BYTE),
  CREATETIME  DATE,
  ISPASS    VARCHAR2(100 BYTE),
  APP_KEY   VARCHAR2(100 BYTE),
  USER_ID   VARCHAR2(100 BYTE),
  APP_IP      NUMBER,
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT APP_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_APPLICATIONACCESS" is '应用表';
comment on column  "T_APPLICATIONACCESS"."ID"  is '主键ID';
comment on column  "T_APPLICATIONACCESS"."APP_FULLNAME"  is '应用全称';
comment on column  "T_APPLICATIONACCESS"."APP_SHORTNAME"  is '应用简称';
comment on column  "T_APPLICATIONACCESS"."CREATEUSER"  is '创建人';
comment on column  "T_APPLICATIONACCESS"."CREATETIME"  is '申请时间';
comment on column  "T_APPLICATIONACCESS"."ISPASS"  is '是否通过';
comment on column  "T_APPLICATIONACCESS"."APP_KEY"  is '应用授权Key';
comment on column  "T_APPLICATIONACCESS"."USER_ID"  is '应用所属用户';
comment on column  "T_APPLICATIONACCESS"."APP_IP"  is '应用地址ip';
comment on column  "T_APPLICATIONACCESS"."FIELD1"  is '备用1';
comment on column  "T_APPLICATIONACCESS"."FIELD2"  is '备用2';
comment on column  "T_APPLICATIONACCESS"."FIELD3"  is '备用3';


--服务授权应用表
--t_seriverAuthorize

CREATE TABLE t_applicationAccess
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  SI_ID      VARCHAR2(100 BYTE),
  APP_ID     VARCHAR2(100 BYTE),
  CREATEUSER   VARCHAR2(100 BYTE),
  CREATETIME  DATE,
  AUDITTIME    DATE,
  ISPASS   VARCHAR2(100 BYTE),
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT APP_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_APPLICATIONACCESS" is '服务授权应用表';
comment on column  "T_APPLICATIONACCESS"."ID"  is '主键ID';
comment on column  "T_APPLICATIONACCESS"."SI_ID"  is '服务接口ID';
comment on column  "T_APPLICATIONACCESS"."APP_ID"  is '应用ID';
comment on column  "T_APPLICATIONACCESS"."CREATEUSER"  is '创建人';
comment on column  "T_APPLICATIONACCESS"."CREATETIME"  is '申请时间';
comment on column  "T_APPLICATIONACCESS"."AUDITTIME"  is '审核时间';
comment on column  "T_APPLICATIONACCESS"."ISPASS"  is '是否通过';
comment on column  "T_APPLICATIONACCESS"."FIELD1"  is '备用1';
comment on column  "T_APPLICATIONACCESS"."FIELD2"  is '备用2';
comment on column  "T_APPLICATIONACCESS"."FIELD3"  is '备用3';


--监控服务日志表
--t_logMonitoring

CREATE TABLE t_logMonitoring
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  SI_ID      VARCHAR2(100 BYTE),
  SI_TITLE     VARCHAR2(100 BYTE),
  APP_ID   VARCHAR2(100 BYTE),
  APP_TITLE  VARCHAR2(100 BYTE),
  CREATETIME    DATE,
  LM_IP   VARCHAR2(100 BYTE),
  LM_STATE     VARCHAR2(100 BYTE),
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT logMonitoring_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_LOGMONITORING" is '监控服务日志表';
comment on column  "T_LOGMONITORING"."ID"  is '主键ID';
comment on column  "T_LOGMONITORING"."SI_ID"  is '服务接口ID';
comment on column  "T_LOGMONITORING"."SI_TITLE"  is '服务接口名称';
comment on column  "T_LOGMONITORING"."APP_ID"  is '应用ID';
comment on column  "T_LOGMONITORING"."APP_TITLE"  is '应用名称';
comment on column  "T_LOGMONITORING"."CREATETIME"  is '调用时间';
comment on column  "T_LOGMONITORING"."LM_IP"  is '来源IP';
comment on column  "T_LOGMONITORING"."LM_STATE"  is '状态';
comment on column  "T_LOGMONITORING"."FIELD1"  is '备用1';
comment on column  "T_LOGMONITORING"."FIELD2"  is '备用2';
comment on column  "T_LOGMONITORING"."FIELD3"  is '备用3';


--用户表
--t_user

CREATE TABLE t_user
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  USERNAME      VARCHAR2(100 BYTE),
  PASSWORD     VARCHAR2(100 BYTE),
  PHONE   VARCHAR2(100 BYTE),
  CREATEDATE  DATE,
  EMAIL   VARCHAR2(100 BYTE),
  SORT     NUMBER,
  USER_STATE    VARCHAR2(100 BYTE),
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT user_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_USER" is '用户表';
comment on column  "T_USER"."ID"  is '主键ID';
comment on column  "T_USER"."LOGINNAME"  is '登陆名';
comment on column  "T_USER"."PWD"  is '密码';
comment on column  "T_USER"."PHONE"  is '手机';
comment on column  "T_USER"."CREATETIME"  is '创建时间';
comment on column  "T_USER"."EMAIL"  is 'Email';
comment on column  "T_USER"."SORT"  is '序号';
comment on column  "T_USER"."USER_STATE"  is '状态,1为可用，0为禁用';
comment on column  "T_USER"."FIELD1"  is '备用1';
comment on column  "T_USER"."FIELD2"  is '备用2';
comment on column  "T_USER"."FIELD3"  is '备用3';
insert into T_USER (ID, USERNAME, PASSWORD, PHONE, CREATEDATE, EMAIL,  SORT, USER_STATE, FIELD1, FIELD2, FIELD3)
values ('1', 'admin', 'xMpCOKC5I4INzFCab3WEmw==', '13332212347', to_date('26-06-2018 17:05:05', 'dd-mm-yyyy hh24:mi:ss'), '116@qq.com',  1, '1', null, null, null);
--组织表
--t_group

--CREATE TABLE t_group
--(
  --ID         VARCHAR2(100 BYTE)      NOT NULL,
  --NAME      VARCHAR2(100 BYTE),
  --PID     VARCHAR2(100 BYTE),
  --CREATETIME   DATE,
  --SORT  NUMBER,
  --FIELD1      VARCHAR2(100 BYTE),
  --FIELD2       VARCHAR2(100 BYTE),
  --FIELD3    VARCHAR2(100 BYTE),
--CONSTRAINT group_ID PRIMARY KEY ( ID ) ENABLE
--);

--comment on table "T_GROUP" is '组织表';
--comment on column  "T_GROUP"."ID"  is '主键ID';
--comment on column  "T_GROUP"."NAME"  is '组织名';
--comment on column  "T_GROUP"."PID"  is '父ID';
--comment on column  "T_GROUP"."CREATETIME"  is '创建时间';
--comment on column  "T_GROUP"."SORT"  is '序号';
--comment on column  "T_GROUP"."FIELD1"  is '备用1';
--comment on column  "T_GROUP"."FIELD2"  is '备用2';
--comment on column  "T_GROUP"."FIELD3"  is '备用3';

--菜单表
--t_menu

CREATE TABLE t_menu
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  PID    VARCHAR2(100 BYTE)  ,
  NAME      VARCHAR2(100 BYTE),
  URL     VARCHAR2(100 BYTE),
  REMARK  VARCHAR2(100 BYTE),
  MENUICON  VARCHAR2(100 BYTE),
  IS_PARENT_MENU    NUMBER,
  SORT  NUMBER,
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT menu_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_MENU" is '菜单表';
comment on column  "T_MENU"."ID"  is '主键ID';
comment on column  "T_MENU"."PID"  is '父ID';
comment on column  "T_MENU"."NAME"  is '名称';
comment on column  "T_MENU"."URL"  is '菜单地址';
comment on column  "T_MENU"."REMARK"  is '说明';
comment on column  "T_MENU"."MENUICON"  is '样式';
comment on column  "T_MENU"."IS_PARENT_MENU"  is '是否为父菜单，1为目录，0为菜单，2为主目录';
comment on column  "T_MENU"."SORT"  is '序号';
comment on column  "T_MENU"."FIELD1"  is '备用1';
comment on column  "T_MENU"."FIELD2"  is '备用2';
comment on column  "T_MENU"."FIELD3"  is '备用3';

insert into T_MENU (ID, NAME, URL, REMARK, IS_PARENT_MENU, SORT, FIELD1, FIELD2, FIELD3, PID, MENUICON)
values ('1', '菜单', null, null, 2, 1, null, null, null, '0', null);
--角色表
--t_role

CREATE TABLE t_role
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  NAME      VARCHAR2(100 BYTE),
  REMARK  VARCHAR2(100 BYTE),
  SORT  NUMBER,
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT role_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_ROLE" is '角色表';
comment on column  "T_ROLE"."ID"  is '主键ID';
comment on column  "T_ROLE"."NAME"  is '名称';
comment on column  "T_ROLE"."REMARK"  is '说明';
comment on column  "T_ROLE"."SORT"  is '序号';
comment on column  "T_ROLE"."FIELD1"  is '备用1';
comment on column  "T_ROLE"."FIELD2"  is '备用2';
comment on column  "T_ROLE"."FIELD3"  is '备用3';


--数据字典表
--t_kind

CREATE TABLE t_kind
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  NAME      VARCHAR2(100 BYTE),
  EXPLAIN  VARCHAR2(100 BYTE),
  SORT  NUMBER,
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT kind_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_KIND" is '数据字典表';
comment on column  "T_KIND"."ID"  is '主键ID';
comment on column  "T_KIND"."NAME"  is '名称';
comment on column  "T_KIND"."EXPLAIN"  is '说明';
comment on column  "T_KIND"."SORT"  is '序号';
comment on column  "T_KIND"."FIELD1"  is '备用1';
comment on column  "T_KIND"."FIELD2"  is '备用2';
comment on column  "T_KIND"."FIELD3"  is '备用3';



--数据字典详情表
--t_kind_detail
CREATE TABLE t_kind_detail
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  DETAIL_NAME      VARCHAR2(100 BYTE),
  DETAIL_EXPLAIN  VARCHAR2(100 BYTE),
  DEATIL_VALUE  VARCHAR2(100 BYTE),
  KIND_ID  VARCHAR2(100 BYTE),
  SORT  NUMBER,
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT kind_detail_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_KIND_DETAIL" is '数据字典详情表';
comment on column  "T_KIND_DETAIL"."ID"  is '主键ID';
comment on column  "T_KIND_DETAIL"."DETAIL_NAME"  is '名称';
comment on column  "T_KIND_DETAIL"."DETAIL_EXPLAIN"  is '说明';
comment on column  "T_KIND_DETAIL"."DEATIL_VALUE"  is '值';
comment on column  "T_KIND_DETAIL"."KIND_ID"  is '字典ID';
comment on column  "T_KIND_DETAIL"."SORT"  is '序号';
comment on column  "T_KIND_DETAIL"."FIELD1"  is '备用1';
comment on column  "T_KIND_DETAIL"."FIELD2"  is '备用2';
comment on column  "T_KIND_DETAIL"."FIELD3"  is '备用3';


--操作日志表
--t_actlog


CREATE TABLE t_actlog
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  ACT_MODULE      VARCHAR2(100 BYTE),
  ACT_TYPE  VARCHAR2(100 BYTE),
  ACT_CONTENT  VARCHAR2(100 BYTE),
  CREATETIME  DATE,
  ACT_USERID  VARCHAR2(100 BYTE),
  ACT_USERNAME  VARCHAR2(100 BYTE),
  ACT_IP       VARCHAR2(100 BYTE),
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT actlog_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_ACTLOG" is '操作日志表';
comment on column  "T_ACTLOG"."ID"  is '主键ID';
comment on column  "T_ACTLOG"."ACT_MODULE"  is '操作模块';
comment on column  "T_ACTLOG"."ACT_TYPE"  is '操作类型';
comment on column  "T_ACTLOG"."ACT_CONTENT"  is '操作内容';
comment on column  "T_ACTLOG"."CREATETIME"  is '操作时间';
comment on column  "T_ACTLOG"."ACT_USERID"  is '操作人ID';
comment on column  "T_ACTLOG"."ACT_USERNAME"  is '操作人名';
comment on column  "T_ACTLOG"."ACT_IP"  is '操作ip';
comment on column  "T_ACTLOG"."FIELD1"  is '备用1';
comment on column  "T_ACTLOG"."FIELD2"  is '备用2';
comment on column  "T_ACTLOG"."FIELD3"  is '备用3';


--用户角色关系表
--T_USER_ROLE

CREATE TABLE t_user_role
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  USER_ID      VARCHAR2(100 BYTE),
  ROLE_ID  VARCHAR2(100 BYTE),
  SORT  NUMBER,
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT user_role_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_USER_ROLE" is '用户角色关系表';
comment on column  "T_USER_ROLE"."ID"  is '主键ID';
comment on column  "T_USER_ROLE"."USER_ID"  is '用户ID';
comment on column  "T_USER_ROLE"."ROLE_ID"  is '角色ID';
comment on column  "T_USER_ROLE"."SORT"  is '序号';
comment on column  "T_USER_ROLE"."FIELD1"  is '备用1';
comment on column  "T_USER_ROLE"."FIELD2"  is '备用2';
comment on column  "T_USER_ROLE"."FIELD3"  is '备用3';


--角色菜单表
--t_role_menu


CREATE TABLE t_role_menu
(
  ID         VARCHAR2(100 BYTE)      NOT NULL,
  ROLE_ID      VARCHAR2(100 BYTE),
  MENU_ID  VARCHAR2(100 BYTE),
  ADD_AUTH  NUMBER,
  DEL_AUTH NUMBER,
  UPD_AUTH NUMBER,
  SORT  NUMBER,
  FIELD1      VARCHAR2(100 BYTE),
  FIELD2       VARCHAR2(100 BYTE),
  FIELD3    VARCHAR2(100 BYTE),
CONSTRAINT user_menu_ID PRIMARY KEY ( ID ) ENABLE
);

comment on table "T_ROLE_MENU" is '角色菜单表';
comment on column  "T_ROLE_MENU"."ID"  is '主键ID';
comment on column  "T_ROLE_MENU"."ROLE_ID"  is '角色ID';
comment on column  "T_ROLE_MENU"."MENU_ID"  is '菜单ID';
comment on column  "T_ROLE_MENU"."ADD_AUTH"  is '新建按钮功能权限,0为没有权限，1为有权限';
comment on column  "T_ROLE_MENU"."DEL_AUTH"  is '删除按钮功能权限,0为没有权限，1为有权限';
comment on column  "T_ROLE_MENU"."UPD_AUTH"  is '修改按钮功能权限,0为没有权限，1为有权限';
comment on column  "T_ROLE_MENU"."SORT"  is '序号';
comment on column  "T_ROLE_MENU"."FIELD1"  is '备用1';
comment on column  "T_ROLE_MENU"."FIELD2"  is '备用2';
comment on column  "T_ROLE_MENU"."FIELD3"  is '备用3';



commit;






