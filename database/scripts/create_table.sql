set global sql_mode = '';

CREATE TABLE `authority` (
    `authority_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user` (
    `user_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL,
    `password` varchar(100) NOT NULL,
    `nickname` varchar(50) NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `user_accountId_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `user_authority` (
  `user_id` bigint(10) NOT NULL,
  `authority_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `completed` bit(1) DEFAULT NULL,
  `completedat` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createat` timestamp NOT NULL DEFAULT current_timestamp(),
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updateat` timestamp DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tone1d1v8ulxlhhkbr66nv1uf` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;