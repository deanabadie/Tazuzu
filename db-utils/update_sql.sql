#------------------------------------------------------------
SET sql_mode = '';

ALTER TABLE `tazuzu`.`user` 
ADD UNIQUE INDEX `username_UNIQUE` (`username` ASC),
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC);

CREATE TABLE `tazuzu`.`test` (
  `test_id` BIGINT NOT NULL,
  `group_id` BIGINT NOT NULL,
  `activity_id` BIGINT NOT NULL,
  `date_of_test` DATE NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`test_id`));

ALTER TABLE `tazuzu`.`time_test` 
DROP FOREIGN KEY `fk_time_test_tbl_activity_id`,
DROP FOREIGN KEY `fk_time_test_tbl_group_id`;
ALTER TABLE `tazuzu`.`time_test` 
DROP COLUMN `date_of_test`,
DROP COLUMN `activity_id`,
CHANGE COLUMN `group_id` `test_id` BIGINT(20) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`student_id`, `test_id`),
ADD INDEX `fk_time_test_tbl_test_id_idx` (`test_id` ASC),
DROP INDEX `fk_time_test_tbl_activity_id_idx` ,
DROP INDEX `fk_time_test_tbl_group_id_idx` ;
ALTER TABLE `tazuzu`.`time_test` 
ADD CONSTRAINT `fk_time_test_tbl_test_id`
  FOREIGN KEY (`test_id`)
  REFERENCES `tazuzu`.`test` (`test_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`quantity_test` 
DROP FOREIGN KEY `fk_quantity_test_tbl_activity_id`,
DROP FOREIGN KEY `fk_quantity_test_tbl_group_id`;
ALTER TABLE `tazuzu`.`quantity_test` 
DROP COLUMN `date_of_test`,
DROP COLUMN `group_id`,
CHANGE COLUMN `activity_id` `test_id` BIGINT(20) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`student_id`, `test_id`),
ADD INDEX `fk_quantity_test_tbl_test_id_idx` (`test_id` ASC),
DROP INDEX `fk_quantity_test_tbl_activity_id_idx` ,
DROP INDEX `fk_quantity_test_tbl_group_id_idx` ;
ALTER TABLE `tazuzu`.`quantity_test` 
ADD CONSTRAINT `fk_quantity_test_tbl_test_id`
  FOREIGN KEY (`test_id`)
  REFERENCES `tazuzu`.`test` (`test_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`distance_test` 
DROP FOREIGN KEY `fk_distance_test_tbl_activity_id`,
DROP FOREIGN KEY `fk_distance_test_tbl_group_id`;
ALTER TABLE `tazuzu`.`distance_test` 
DROP COLUMN `date_of_test`,
DROP COLUMN `group_id`,
CHANGE COLUMN `activity_id` `test_id` BIGINT(20) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`student_id`, `test_id`),
ADD INDEX `fk_distance_test_tbl_test_id_idx` (`test_id` ASC),
DROP INDEX `fk_distance_test_tbl_activity_id_idx` ,
DROP INDEX `fk_distance_test_tbl_group_id_idx` ;
ALTER TABLE `tazuzu`.`distance_test` 
ADD CONSTRAINT `fk_distance_test_tbl_test_id`
  FOREIGN KEY (`test_id`)
  REFERENCES `tazuzu`.`test` (`test_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`user` 
ADD COLUMN `password` VARCHAR(45) NOT NULL AFTER `username`,
ADD COLUMN `first_name` VARCHAR(254) NOT NULL AFTER `password`,
ADD COLUMN `last_name` VARCHAR(254) NOT NULL AFTER `first_name`;

DROP TABLE `tazuzu`.`student_trans`;
DROP TABLE `tazuzu`.`teacher_trans`;

CREATE TABLE `tazuzu`.`user_trans` (
  `user_id` BIGINT NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(254) NOT NULL,
  `last_name` VARCHAR(254) NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `language`),
  INDEX `fk_user_trans_tbl_last_edited_by_idx` (`last_edited_by` ASC),
  CONSTRAINT `fk_user_trans_tbl_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `tazuzu`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
