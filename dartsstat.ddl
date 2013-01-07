/**********************************/
/* テーブル名: users */
/**********************************/
CREATE TABLE users(
		id                            		INT(10)		 NOT NULL AUTO_INCREMENT COMMENT 'id',
		card_name                     		VARCHAR(255)		 NULL  COMMENT 'card_name',
		login_url                     		VARCHAR(255)		 NULL  COMMENT 'login_url',
		email                         		VARCHAR(255)		 NULL  COMMENT 'email',
		created_at                    		DATETIME		 NULL  COMMENT 'created_at',
		update_at                     		DATETIME		 NULL  COMMENT 'update_at'
) COMMENT='users';

/**********************************/
/* テーブル名: records */
/**********************************/
CREATE TABLE records(
		id                            		INT(11)		 NOT NULL AUTO_INCREMENT COMMENT 'id',
		played_at                     		DATE		 NULL  COMMENT 'played_at',
		user_id                       		INT(11)		 NULL  COMMENT 'user_id',
		created_at                    		DATETIME		 NULL  COMMENT 'created_at',
		updated_at                    		DATETIME		 NULL  COMMENT 'updated_at'
) COMMENT='records';

/**********************************/
/* テーブル名: statistics */
/**********************************/
CREATE TABLE statistics(
		id                            		INT(11)		 NOT NULL AUTO_INCREMENT COMMENT 'id',
		record_id                     		INT(11)		 NULL  COMMENT 'record_id',
		score                         		VARCHAR(255)		 NULL  COMMENT 'score',
		game_name                     		VARCHAR(255)		 NULL  COMMENT 'game_name',
		game_format                   		VARCHAR(255)		 NULL  COMMENT 'game_format',
		number_of_players             		INT(11)		 NULL  COMMENT 'number_of_players',
		created_at                    		DATETIME		 NULL  COMMENT 'created_at',
		updated_at                    		DATETIME		 NULL  COMMENT 'updated_at'
) COMMENT='statistics';

/**********************************/
/* テーブル名: awards */
/**********************************/
CREATE TABLE awards(
		id                            		INT(11)		 NOT NULL AUTO_INCREMENT COMMENT 'id',
		award_name                    		VARCHAR(255)		 NULL  COMMENT 'award_name',
		award_count                   		INT(11)		 NULL  COMMENT 'award_count',
		record_id                     		INT(11)		 NULL  COMMENT 'record_id',
		created_at                    		DATETIME		 NULL  COMMENT 'created_at',
		updated_at                    		DATETIME		 NULL  COMMENT 'updated_at'
) COMMENT='awards';


ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (id);

ALTER TABLE records ADD CONSTRAINT IDX_records_PK PRIMARY KEY (id);
ALTER TABLE records ADD CONSTRAINT IDX_records_FK0 FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE statistics ADD CONSTRAINT IDX_statistics_PK PRIMARY KEY (id);
ALTER TABLE statistics ADD CONSTRAINT IDX_statistics_FK0 FOREIGN KEY (record_id) REFERENCES records (id);
CREATE INDEX index_statistic_user_id ON statistics (user_id);

ALTER TABLE awards ADD CONSTRAINT IDX_awards_PK PRIMARY KEY (id);
ALTER TABLE awards ADD CONSTRAINT IDX_awards_FK0 FOREIGN KEY (record_id) REFERENCES records (id);

