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