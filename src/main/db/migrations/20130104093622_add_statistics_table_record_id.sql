ALTER TABLE `statistics` ADD COLUMN `record_id` int(11) DEFAULT NULL AFTER `id`;
ALTER TABLE `statistics` ADD INDEX `index_statistics_record_id` (`record_id`);
ALTER TABLE `statistics` ADD CONSTRAINT `fk_statistics_record_id` FOREIGN KEY (`record_id`) REFERENCES `records` (`id`);