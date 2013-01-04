CREATE TABLE `awards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `record_id` int(11) DEFAULT NULL,
  `award_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `award_count` int(11) DEFAULT NULL,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  PRIMARY KEY (`id`),
  KEY `index_awards_record_id` (`record_id`),
  CONSTRAINT `fk_awards_record_id` FOREIGN KEY (`record_id`) REFERENCES `records` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;