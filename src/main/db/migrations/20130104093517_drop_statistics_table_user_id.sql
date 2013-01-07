ALTER TABLE `statistics` DROP FOREIGN KEY `fk_statistics_user_id`;
ALTER TABLE `statistics` DROP INDEX `index_statistics_user_id`;
ALTER TABLE `statistics` DROP COLUMN `user_id`;