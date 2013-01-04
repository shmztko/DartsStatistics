CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `card_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;