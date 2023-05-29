

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- >>>>>>>>>>创建用户表<<<<<<<<<<<
drop table if exists `user_info`;
create table `user_info`  (
  `id` bigint not null comment '用戶id',
  `name` varchar(255) comment '用戶姓名',
  `sex` varchar(255) comment '用戶性別',
  `age` int(8) not null comment '用戶年齡',
  primary key (`id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

-- >>>>>>>>>>创建商品表1<<<<<<<<<<<
drop table if exists `product_00`;
create table `product_00`  (
  `id` bigint not null comment '商品id',
  `name` varchar(255) comment '商品名称',
  `price` int(8) not null comment '商品价格',
  primary key (`id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

-- >>>>>>>>>>创建商品表2<<<<<<<<<<<
drop table if exists `product_01`;
create table `product_01`  (
    `id` bigint not null comment '商品id',
    `name` varchar(255) comment '商品名称',
    `price` int(8) not null comment '商品价格',
    primary key (`id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

-- >>>>>>>>>>创建订单表<<<<<<<<<<<
drop table if exists `order`;
create table `order`  (
  `id` bigint not null comment  '订单号',
  `price` int(8) not null comment '订单总金额',
  `user_id` bigint not null comment '用戶id',
  primary key (`id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

-- >>>>>>>>>>创建订单详情表<<<<<<<<<<<
drop table if exists `order_info`;
create table `order_info`  (
  `id` bigint not null comment  '订单详情号',
  `order_id`  bigint not null comment '订单号',
  `product_name` varchar(255)  comment '商品名称',
  `product_price` int(8) not null comment '商品价格',
  primary key (`id`) using btree,
  index `key_order_id`(`order_id`) using btree
)
engine = InnoDB
character set = utf8
collate = utf8_general_ci
row_format = compact;

