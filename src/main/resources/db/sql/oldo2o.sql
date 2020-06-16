create table `tb_area`(
	`area_id` int(2) NOT NULL AUTO_INCREMENT,
	`area_name` VARCHAR(200) NOT NULL,
	`priority` int(2) NOT NULL DEFAULT '0',
	`create_time` datetime default null,
	`last_edit_time` datetime default null,
	primary key (`area_id`),
	unique key `UK_AREA` (`area_name`)
)ENGINE=INNODB AUTO_INCREMENT=1 default CHARSET=utf8mb4;

create table `tb_person_info`(
	`user_id` int(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(32) default null,
	`profile_img` VARCHAR(1024) default null,
	`email` VARCHAR(1024) default null,
	`gender` VARCHAR(2) DEFAULT null,
	`enable_status` int(2) not null default '0' comment '0:禁止使用本商城',
	`user_type` int(2) not null DEFAULT '1' COMMENT '1-顾客，2-店家，3-超级管理员',
	`create_time` datetime default null,
	`last_edit_time` datetime default null,
	primary key(`user_id`)
)ENGINE=INNODB AUTO_INCREMENT=1 default CHARSET=utf8mb4;

create table `tb_wechat_auth`(
	`wechat_auth_id` int(10) not null auto_increment,
	`user_id` int(10) not null,
	`open_id` VARCHAR(768) not null,
	`create_time` datetime default null,
	primary key(`wechat_auth_id`),
	constraint `fk_wechatauth_profile` foreign key (`user_id`) references `tb_person_info`(`user_id`)
)ENGINE=INNODB row_format=dynamic AUTO_INCREMENT=1 default CHARSET=utf8mb4;

alter table tb_wechat_auth add unique index(open_id);

create table `tb_local_auth`(
	`local_auth_id` int(10) not null auto_increment,
	`user_id` int(10) not null,
	`username` VARCHAR(128) not null,
	`password` VARCHAR(128) not null,
	`create_time` datetime default null,
	`last_edit_time` datetime DEFAULT null,
	primary key(`local_auth_id`),
	UNIQUE KEY `uk_local_profile` (`username`),
	CONSTRAINT `fk_localauth_profile` foreign key (`user_id`) references `tb_person_info`(`user_id`)
)ENGINE=INNODB AUTO_INCREMENT=1 default CHARSET=utf8mb4;

create table `tb_head_line`(
	`line_id` int(100) not null auto_increment,
	`line_name` VARCHAR(1000) default null,
	`line_link` VARCHAR(2000) not null,
	`line_img` VARCHAR(2000) not null,
	`priority` int(2) default null,
	`enable_status` int(2) not null default '0',
	`create_time` datetime default null,
	`last_edit_time` datetime default null,
	primary key (`line_id`)
)ENGINE=INNODB  AUTO_INCREMENT=1 default CHARSET=utf8mb4;

create table `tb_shop_category`(
	`shop_category_id` int(11) not null auto_increment,
	`shop_category_name` VARCHAR(100) not null DEFAULT '',
	`shop_category_desc` VARCHAR(1000) default '',
	`shop_category_img` VARCHAR(2000) default null,
	`priority` int(2) not null default '0',
	`create_time` datetime default null,
	`last_edit_time` datetime default null,
	`parent_id` int(11) default null,
	primary key (`shop_category_id`),
	constraint `fk_shop_category_self` foreign key (`parent_id`) REFERENCES `tb_shop_category` (`shop_category_id`)

)ENGINE=INNODB  AUTO_INCREMENT=1 default CHARSET=utf8mb4;

create table `tb_shop`(
	`shop_id` int(10) not null auto_increment,
	`owner_id`int(10) not null comment '店铺创建人',
	`area_id` int(5) default null,
	`shop_category_id` int(11) default null,
	`shop_name` VARCHAR(256) not null,
	`shop_desc` VARCHAR(1024) default null,
	`shop_addr` VARCHAR(200) default null,
	`phone` VARCHAR(128) default null,
	`shop_img` VARCHAR(1024) default null,
	`priority` int(3) default '0',
	`create_time` datetime default null,
	`last_edit_time` datetime default null,
	`enable_status` int(2) not null default '0',
	`advice` varchar(255) default null,
	primary key(`shop_id`),
	constraint `fk_shop_area` foreign key(`area_id`) REFERENCES `tb_area` (`area_id`),
	constraint `fk_shop_profile` foreign key(`owner_id`) REFERENCES `tb_person_info` (`user_id`),
	constraint `fk_shop_shopcate` foreign key(`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`)

)ENGINE=INNODB  AUTO_INCREMENT=1 default CHARSET=utf8mb4;

create table `tb_product_category`(
	`product_category_id` int(11) not null auto_increment,
	`product_category_name` VARCHAR(100) not null,
	`priority` int(2) default '0',
	`create_time` datetime default null,
	`shop_id` int(20) not null default '0',
	primary key (`product_category_id`),
	constraint `fk_procate_shop` foreign key (`shop_id`) REFERENCES `tb_shop`(`shop_id`)
)ENGINE=INNODB  AUTO_INCREMENT=1 default CHARSET=utf8mb4;

create table `tb_product`(
	`product_id` int(100) not null auto_increment,
	`product_name` VARCHAR(100) not null,
	`product_desc` VARCHAR(2000) default null,
	`img_addr` VARCHAR(2000) DEFAULT '',
	`normal_price` VARCHAR(100) default null,
	`promotion_price` varchar(100) default null,
	`priority` int(2) not null default '0',
	`create_time` datetime default null,
	`last_edit_time` datetime default null,
	`enable_status` int(2) not null default '0',
	`product_category_id` int(11) default null,
	`shop_id` int(20) not null default '0',
	primary key(`product_id`),
	CONSTRAINT `fk_product_procate` foreign key(`product_category_id`) REFERENCES `tb_product_category`(`product_category_id`),
	CONSTRAINT `fk_product_shop` foreign key(`shop_id`) REFERENCES `tb_shop`(`shop_id`)

)ENGINE=INNODB  AUTO_INCREMENT=1 default CHARSET=utf8mb4;

create table `tb_product_img`(
	`product_img_id` int(20) not null auto_increment,
	`img_addr` VARCHAR(2000) not null,
	`img_desc` VARCHAR(2000) default null,
	`priority` int(2) default '0',
	`create_time` datetime default null,
	`product_id` int(20) default null,
	primary key (`product_img_id`),
	constraint `fk_proimg_product` foreign key (`product_id`) REFERENCES `tb_product`(`product_id`)
)ENGINE=INNODB  AUTO_INCREMENT=1 default CHARSET=utf8mb4;