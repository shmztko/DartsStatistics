CREATE TABLE `statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `game_order` int(11) DEFAULT NULL,
  `played_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `score` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `game_format` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `number_of_players` int(11) DEFAULT NULL,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  PRIMARY KEY (`id`),
  KEY `index_statistics_user_id` (`user_id`),
  CONSTRAINT `fk_statistics_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;