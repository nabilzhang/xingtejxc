# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: xintejxc
# ------------------------------------------------------
# Server version 5.1.47-community

#
# Source for table xt_area
#

DROP TABLE IF EXISTS `xt_area`;
CREATE TABLE `xt_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_area
#

INSERT INTO `xt_area` VALUES (1,'汉川',0,0);
INSERT INTO `xt_area` VALUES (3,'仙女山街道',1,0);
INSERT INTO `xt_area` VALUES (4,'武昌',1,0);
INSERT INTO `xt_area` VALUES (5,'ss',4,0);

#
# Source for table xt_customer
#

DROP TABLE IF EXISTS `xt_customer`;
CREATE TABLE `xt_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customernumber` char(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `postcode` varchar(7) DEFAULT NULL,
  `areacode` varchar(4) DEFAULT NULL,
  `areaid` int(11) DEFAULT '0',
  `telephone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `salesmanid` int(11) DEFAULT '0',
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_customer
#

INSERT INTO `xt_customer` VALUES (1,'0120080002','张弼','华科','11','11',1,'12','12',0,0);
INSERT INTO `xt_customer` VALUES (2,'0120080001','mingway','hust','11','11',1,'15871469142','02787443636',1,0);
INSERT INTO `xt_customer` VALUES (3,'','可乐','','','啊',3,'','',1,0);

#
# Source for table xt_delivery
#

DROP TABLE IF EXISTS `xt_delivery`;
CREATE TABLE `xt_delivery` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `deliverynumber` char(14) DEFAULT NULL,
  `sellid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_delivery
#


#
# Source for table xt_deliveryorder
#

DROP TABLE IF EXISTS `xt_deliveryorder`;
CREATE TABLE `xt_deliveryorder` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `deliverynumber` char(14) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL,
  `salesmanid` int(11) DEFAULT NULL,
  `deliverydate` timestamp NULL DEFAULT NULL,
  `deliveryaddress` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_deliveryorder
#


#
# Source for table xt_department
#

DROP TABLE IF EXISTS `xt_department`;
CREATE TABLE `xt_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_department
#

INSERT INTO `xt_department` VALUES (1,'销售部','主要负责销售',0);
INSERT INTO `xt_department` VALUES (4,'营销','当然负责营销咯',0);

#
# Source for table xt_instoreitem
#

DROP TABLE IF EXISTS `xt_instoreitem`;
CREATE TABLE `xt_instoreitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instoreid` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `units` varchar(10) DEFAULT NULL,
  `inprice` decimal(10,4) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_instoreitem
#


#
# Source for table xt_instoreorder
#

DROP TABLE IF EXISTS `xt_instoreorder`;
CREATE TABLE `xt_instoreorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instorenumber` varchar(14) DEFAULT NULL,
  `salesmanid` int(11) DEFAULT NULL,
  `instoretype` int(11) NOT NULL DEFAULT '0',
  `indate` timestamp NULL DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_instoreorder
#

INSERT INTO `xt_instoreorder` VALUES (2,'11',1,1,'2011-02-02',1);

#
# Source for table xt_limit
#

DROP TABLE IF EXISTS `xt_limit`;
CREATE TABLE `xt_limit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `code` int(11) DEFAULT '1',
  `decription` varchar(50) DEFAULT NULL,
  `usergroupid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_limit
#

INSERT INTO `xt_limit` VALUES (1,'采购管理',1,'采购管理相关操作',1,0);
INSERT INTO `xt_limit` VALUES (2,'销售管理',1,'负责销售管理相关操作',1,0);
INSERT INTO `xt_limit` VALUES (3,'库存管理',1,'库存管理相关操作',1,0);
INSERT INTO `xt_limit` VALUES (4,'配送管理',1,'配送管理相关操作',1,0);
INSERT INTO `xt_limit` VALUES (5,'基础信息',1,'基础信息维护',1,0);
INSERT INTO `xt_limit` VALUES (6,'用户管理',1,'用户管理相关操作',1,0);

#
# Source for table xt_outstoreitem
#

DROP TABLE IF EXISTS `xt_outstoreitem`;
CREATE TABLE `xt_outstoreitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `outstoreid` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `units` varchar(10) DEFAULT NULL,
  `outprice` decimal(10,4) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_outstoreitem
#


#
# Source for table xt_outstoreorder
#

DROP TABLE IF EXISTS `xt_outstoreorder`;
CREATE TABLE `xt_outstoreorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `outstorenumber` varchar(14) DEFAULT NULL,
  `storeroomkeeperid` int(11) DEFAULT NULL,
  `outstoretype` int(11) DEFAULT NULL,
  `outdate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_outstoreorder
#

INSERT INTO `xt_outstoreorder` VALUES (1,'22',1,1,'2011-02-02',1);

#
# Source for table xt_personnel
#

DROP TABLE IF EXISTS `xt_personnel`;
CREATE TABLE `xt_personnel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `postid` int(11) DEFAULT '0',
  `degree` varchar(10) DEFAULT NULL,
  `workexperience` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_personnel
#

INSERT INTO `xt_personnel` VALUES (1,'张弼',1,'本科','华中科技大学',0);
INSERT INTO `xt_personnel` VALUES (2,'mingway',1,'本科','hust',0);

#
# Source for table xt_post
#

DROP TABLE IF EXISTS `xt_post`;
CREATE TABLE `xt_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_post
#

INSERT INTO `xt_post` VALUES (1,1,'业务员','负责日常业务',0);
INSERT INTO `xt_post` VALUES (2,1,'爱爱爱','还',0);

#
# Source for table xt_procatalog
#

DROP TABLE IF EXISTS `xt_procatalog`;
CREATE TABLE `xt_procatalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catalognumber` varchar(14) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_procatalog
#

INSERT INTO `xt_procatalog` VALUES (2,'js','酒水类饮品',0,0);
INSERT INTO `xt_procatalog` VALUES (3,'cs','茶类饮品',0,0);
INSERT INTO `xt_procatalog` VALUES (4,'ts','碳酸饮料',0,0);
INSERT INTO `xt_procatalog` VALUES (5,'cf','咖啡饮料',0,0);
INSERT INTO `xt_procatalog` VALUES (6,'ks','矿泉水',0,0);
INSERT INTO `xt_procatalog` VALUES (7,'ng','牛奶果汁',0,0);
INSERT INTO `xt_procatalog` VALUES (8,'j4','啊',0,0);
INSERT INTO `xt_procatalog` VALUES (9,'啊啊','啊',3,0);

#
# Source for table xt_product
#

DROP TABLE IF EXISTS `xt_product`;
CREATE TABLE `xt_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productnumber` char(14) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `units` varchar(6) DEFAULT NULL,
  `supplierid` int(11) DEFAULT NULL,
  `areaid` int(11) DEFAULT NULL,
  `catalogid` int(11) DEFAULT NULL,
  `inprice` decimal(10,4) DEFAULT NULL,
  `saleprice` decimal(10,4) DEFAULT NULL,
  `lowprice` decimal(10,4) DEFAULT NULL,
  `store` int(11) DEFAULT '0',
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_product
#

INSERT INTO `xt_product` VALUES (1,'js00001','小枝江白酒','瓶',1,0,2,3,5,4,0,0);
INSERT INTO `xt_product` VALUES (3,'js00002','大枝江白酒','瓶',1,0,2,3,5,4,0,0);
INSERT INTO `xt_product` VALUES (4,'js00003','枝江','瓶',1,0,2,4,6,5,0,0);
INSERT INTO `xt_product` VALUES (5,'js00004','白酒','瓶',1,0,2,8,10,9,0,0);
INSERT INTO `xt_product` VALUES (6,'11111','白酒','瓶',1,0,8,6,4,7,0,0);

#
# Source for table xt_purchaseitem
#

DROP TABLE IF EXISTS `xt_purchaseitem`;
CREATE TABLE `xt_purchaseitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purchaseid` int(11) DEFAULT '0',
  `productid` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `units` char(10) DEFAULT NULL,
  `purchaseprice` decimal(10,2) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_purchaseitem
#

INSERT INTO `xt_purchaseitem` VALUES (1,1,1,2,'2',3,1);
INSERT INTO `xt_purchaseitem` VALUES (2,41,5,1,'e',4,0);

#
# Source for table xt_purchaseorder
#

DROP TABLE IF EXISTS `xt_purchaseorder`;
CREATE TABLE `xt_purchaseorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purchasenumber` char(14) DEFAULT NULL,
  `supplierid` int(11) DEFAULT NULL,
  `salesmanid` int(11) DEFAULT NULL,
  `purchasedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_purchaseorder
#

INSERT INTO `xt_purchaseorder` VALUES (32,'20110615001',2,1,'2011-06-17 13:26:57',0);
INSERT INTO `xt_purchaseorder` VALUES (33,'20110615002',2,1,'2011-06-17 13:33:52',0);
INSERT INTO `xt_purchaseorder` VALUES (34,'20110616001',2,1,'2011-06-17 13:38:23',0);
INSERT INTO `xt_purchaseorder` VALUES (35,'20110616002',2,1,'2011-06-17 13:42:20',0);
INSERT INTO `xt_purchaseorder` VALUES (36,'20110617001',2,1,'2011-06-17 13:44:20',0);
INSERT INTO `xt_purchaseorder` VALUES (37,'20110618001',2,1,'2011-06-17 13:47:15',0);
INSERT INTO `xt_purchaseorder` VALUES (38,'11111',1,1,'2011-06-19 09:29:43',0);
INSERT INTO `xt_purchaseorder` VALUES (39,'111',1,1,'2011-06-22 17:40:09',0);
INSERT INTO `xt_purchaseorder` VALUES (40,'a',1,2,'2011-07-23 20:59:41',0);
INSERT INTO `xt_purchaseorder` VALUES (41,'fafaf',1,1,'2011-12-10 16:42:10',0);

#
# Source for table xt_sellitem
#

DROP TABLE IF EXISTS `xt_sellitem`;
CREATE TABLE `xt_sellitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sellid` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `units` char(10) DEFAULT NULL,
  `sellprice` decimal(10,2) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_sellitem
#

INSERT INTO `xt_sellitem` VALUES (1,1,1,10,'瓶',4,1);
INSERT INTO `xt_sellitem` VALUES (2,1,1,20,'瓶',5,1);
INSERT INTO `xt_sellitem` VALUES (3,1,2,10,'瓶',5,1);
INSERT INTO `xt_sellitem` VALUES (4,2,2,3,'瓶',4,1);
INSERT INTO `xt_sellitem` VALUES (5,2,3,23,'瓶',4,1);
INSERT INTO `xt_sellitem` VALUES (6,3,4,22,'瓶',4,1);

#
# Source for table xt_sellorder
#

DROP TABLE IF EXISTS `xt_sellorder`;
CREATE TABLE `xt_sellorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sellnumber` char(14) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL,
  `salesmanid` int(11) DEFAULT NULL,
  `selldate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_sellorder
#

INSERT INTO `xt_sellorder` VALUES (1,'20110618122',1,1,'2011-02-02',1);
INSERT INTO `xt_sellorder` VALUES (2,'20110618123',2,2,'2011-03-03',1);
INSERT INTO `xt_sellorder` VALUES (3,'20110618124',2,2,'2011-04-04',1);
INSERT INTO `xt_sellorder` VALUES (4,'20110618125',2,2,'2011-05-05',1);
INSERT INTO `xt_sellorder` VALUES (5,'20110618126',1,1,'2011-06-06',1);
INSERT INTO `xt_sellorder` VALUES (6,'20110618127',2,2,'2011-03-05',1);
INSERT INTO `xt_sellorder` VALUES (7,'20110618128',1,1,'2011-04-06',1);
INSERT INTO `xt_sellorder` VALUES (8,'20110618129',1,1,'2011-05-07',1);
INSERT INTO `xt_sellorder` VALUES (9,'20110618130',2,2,'2011-04-12',1);
INSERT INTO `xt_sellorder` VALUES (10,'20110618131',2,2,'2011-03-14',1);

#
# Source for table xt_supplier
#

DROP TABLE IF EXISTS `xt_supplier`;
CREATE TABLE `xt_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `suppliernumber` char(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `postcode` varchar(7) DEFAULT NULL,
  `areacode` varchar(4) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `remark` mediumtext,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_supplier
#

INSERT INTO `xt_supplier` VALUES (1,'1','小枝江酒厂','1',NULL,'1','1','1','1',NULL,0);
INSERT INTO `xt_supplier` VALUES (2,'2','百事可乐公司','2','222222','2','2','2','2',NULL,0);

#
# Source for table xt_user
#

DROP TABLE IF EXISTS `xt_user`;
CREATE TABLE `xt_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `personnelid` int(11) DEFAULT NULL,
  `groupid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_user
#

INSERT INTO `xt_user` VALUES (11,'admin','admin888',1,1,0);
INSERT INTO `xt_user` VALUES (12,'admin001','admin888',1,1,0);
INSERT INTO `xt_user` VALUES (14,'admin002','admin888',1,1,0);

#
# Source for table xt_usergroup
#

DROP TABLE IF EXISTS `xt_usergroup`;
CREATE TABLE `xt_usergroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `decription` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Dumping data for table xt_usergroup
#

INSERT INTO `xt_usergroup` VALUES (1,'超级管理员','具有系统所有功能',0);

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
