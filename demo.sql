/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/10/29 15:15:32                          */
/*==============================================================*/
use demo;

drop table if exists DEMO_GIFT;

drop table if exists DEMO_GIFT_KEY;

drop table if exists DEMO_USER;

drop table if exists DEMO_USER_GIFT;

/*==============================================================*/
/* Table: DEMO_GIFT                                             */
/*==============================================================*/
create table DEMO_GIFT
(
   id                   int not null auto_increment,
   gift_name            varchar(20) not null ,
   gift_count           int not null,
   start_time           datetime not null,
   end_time             datetime not null,
   description          varchar(200) default null,
   PRIMARY KEY (id),
   UNIQUE KEY (gift_name)
);

/*==============================================================*/
/* Table: DEMO_GIFT_KEY                                         */
/*==============================================================*/
create table DEMO_GIFT_KEY
(
   id                   int not null auto_increment,
   gift_id              int not null,
   gift_key             varchar(32) not null,
   gift_status          char default '0' comment '0:未被抢 1:已被抢',
   foreign key (gift_id) references DEMO_GIFT(id),
   PRIMARY KEY (id),
   UNIQUE KEY (gift_key)
);

/*==============================================================*/
/* Table: DEMO_USER                                             */
/*==============================================================*/
create table DEMO_USER
(
   id                   int not null auto_increment,
   user_name            varchar(20) not null,
   password             varchar(32) not null,
   sex					char comment '0:女,1:男',
   phone                varchar(20),
   role                 char not null comment '0:游戏厂商,1:普通玩家',
   enabled              char not null default '0' comment '1:封禁 0:可用',
   score                int default 0,
   PRIMARY KEY (id),
   UNIQUE KEY (user_name)  
);

/*==============================================================*/
/* Table: DEMO_USER_GIFT                                        */
/*==============================================================*/
create table DEMO_USER_GIFT
(
   id                   int not null auto_increment,
   user_id              int not null,
   gift_id              int not null,
   gift_key             varchar(32),
   foreign key (user_id) references DEMO_USER(id), 
   foreign key (gift_id) references DEMO_GIFT(id),
   PRIMARY KEY (id),
   UNIQUE KEY `user_gift` (user_id,gift_id)
);


