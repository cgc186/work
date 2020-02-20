create table mysyslog
(
    id         int auto_increment
        primary key,
    USERNAME   varchar(255) null,
    OPERATION  varchar(255) null,
    TIME       int          null,
    METHOD     varchar(255) null,
    PARAMS     varchar(255) null,
    IP         varchar(255) null,
    CREATETIME date         null
);

create table t_permission
(
    id             int auto_increment
        primary key,
    permissionname varchar(255) null,
    url            varchar(255) null,
    pagename       varchar(255) null,
    editname       varchar(255) null
);

create table t_role
(
    id       int auto_increment
        primary key,
    rolename varchar(255) null,
    remark   varchar(255) null
);

create table t_role_permission
(
    id  int auto_increment
        primary key,
    rid int null,
    pid int null
);

create table t_user
(
    id         int auto_increment
        primary key,
    username   varchar(255) null,
    passwd     varchar(255) null,
    email      varchar(255) null,
    createtime date         null
);

create table t_user_role
(
    id  int auto_increment
        primary key,
    uid int null,
    rid int null
);