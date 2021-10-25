INSERT INTO `authority` (`authority_name`)
VALUES
	('ROLE_USER'),
	('ROLE_ADMIN');

INSERT INTO `product` (`product_id`, `product_name`, `product_cost`, `product_image`)
VALUES
	(1, '건어물세트', 2000, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/000016/1591602198item_700X700_toJPEGBot.jpg'),
	(2, '버터감자', 1000, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/000019/1591605374item_700X700_toJPEGBot.jpg'),
	(3, '짜빠구리', 3200, 'http://d25d5hdteapulp.cloudfront.net/OKSM_YHM026/000022/7YqA6rmA67KU67KF7Kec67mg6rWs66as.jpg'),
	(4, '버터오지어', 4500, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/900011/item_300X300_toJPEGBot.jpg'),
	(5, '살얼음파인애플', 2100, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/900102/item_300X300_toJPEGBot.jpg'),
	(6, '수세소시지', 1000, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/900018/item_300X300_toJPEGBot.jpg'),
	(7, '모듬소세지', 1900, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/900019/item_300X300_toJPEGBot.jpg'),
	(8, '30cm마약돈까스', 4100, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/900098/item_300X300_toJPEGBot.jpg'),
	(9, '양념감자튀김', 4700, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/900097/item_300X300_toJPEGBot.jpg'),
	(10, '양념순살', 2350, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/900033/item_300X300_toJPEGBot.jpg'),
	(11, '콜라', 3400, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/900053/1581936336item_300X300_toJPEGBot.jpg'),
	(12, '사이다', 1650, 'https://s3.ap-northeast-2.amazonaws.com/images.orderhae.com/OK_YHM002/900054/1581936340item_300X300_toJPEGBot.jpg');


INSERT INTO `user` (`user_id`, `username`, `password`, `nickname`, `activated`)
VALUES
	(1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 1),
	(2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 1),
	(3, 'test', '$2a$10$X24qvWgNYvXKKA4oaFpFPesEmemuGwj/c8L7sX8LheD.kmZ2X4UTu', 'nickname', 1);

INSERT INTO `user_authority` (`user_id`, `authority_name`)
VALUES
	(1, 'ROLE_USER'),
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER'),
	(3, 'ROLE_USER');
