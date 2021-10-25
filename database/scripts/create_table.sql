set global sql_mode = '';

CREATE TABLE `authority` (
    `authority_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `ordertable` (
  `orderId` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '유저아이디',
  `productid` bigint(10) NOT NULL,
  `productname` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '제품이름',
  `productstandard` int(11) NOT NULL DEFAULT 0 COMMENT '제품단가',
  `productcount` int(11) NOT NULL DEFAULT 0 COMMENT '제품갯수',
  `productcost` int(11) NOT NULL DEFAULT 0 COMMENT '가격',
  `createdate` datetime NOT NULL DEFAULT current_timestamp() COMMENT '등록일',
  `deletedate` datetime COMMENT '삭제일',
  `payment` int(2) DEFAULT 0 COMMENT '결제전:0,결제완료:1',
  `payid` bigint(10) DEFAULT NULL COMMENT '결제아이디',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `paytable` (
  `payid` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '유저아이디',
  `cost` int(11) NOT NULL DEFAULT 0 COMMENT '가격',
  `paygubun` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '제품이름',
  `createdate` datetime NOT NULL DEFAULT current_timestamp() COMMENT '등록일',
  `deletedate` datetime COMMENT '삭제일',
  PRIMARY KEY (`payid`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `product` (
                           `product_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '고유번호',
                           `product_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '제품이름',
                           `product_cost` int(11) unsigned NOT NULL DEFAULT 0 COMMENT '제품가격',
                           `product_image` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '제품 이미지',
                           PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user` (
                        `user_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
                        `username` varchar(50) NOT NULL,
                        `password` varchar(100) NOT NULL,
                        `nickname` varchar(50) NOT NULL,
                        `activated` tinyint(4) DEFAULT NULL,
                        PRIMARY KEY (`user_id`),
                        UNIQUE KEY `user_accountId_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `user_authority` (
                                  `user_id` bigint(10) NOT NULL,
                                  `authority_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


