INSERT INTO `authority` (`authority_name`)
VALUES
	('ROLE_USER'),
	('ROLE_ADMIN');

INSERT INTO `user` (`user_id`, `username`, `password`, `nickname`)
VALUES
	(1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin'),
	(2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user'),
	(3, 'test', '$2a$10$X24qvWgNYvXKKA4oaFpFPesEmemuGwj/c8L7sX8LheD.kmZ2X4UTu', 'nickname');

INSERT INTO `user_authority` (`user_id`, `authority_name`)
VALUES
	(1, 'ROLE_USER'),
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER'),
	(3, 'ROLE_USER');
