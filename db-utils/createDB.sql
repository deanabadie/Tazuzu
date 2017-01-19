SET sql_mode = '';	#Remove restriction mode

#------------------Create Tables-----------------------------------

CREATE TABLE `tazuzu`.`activity_type` (
  `activity_type_id` BIGINT NOT NULL AUTO_INCREMENT,
  `measurement_type_id` BIGINT NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`activity_type_id`));

CREATE TABLE `tazuzu`.`activity` (
  `activity_id` BIGINT NOT NULL AUTO_INCREMENT,
  `activity_type_id` BIGINT NULL,
  `num_of_measurements` INT NULL,
  `time_of_creation` TIMESTAMP NULL,
  `time_of_last_edit` TIMESTAMP NULL,
  `last_edited_by` BIGINT NULL,
  PRIMARY KEY (`activity_id`));

CREATE TABLE `tazuzu`.`activity_trans` (
  `activity_id` BIGINT NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  `activity_name` VARCHAR(45) NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`activity_id`, `language`));

CREATE TABLE `tazuzu`.`measurement_type` (
  `measurement_type_id` BIGINT NOT NULL AUTO_INCREMENT,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`measurement_type_id`));

CREATE TABLE `tazuzu`.`measurement_type_trans` (
  `measurement_type_id` BIGINT NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`measurement_type_id`, `language`));

CREATE TABLE `tazuzu`.`student` (
  `student_id` BIGINT NOT NULL AUTO_INCREMENT,
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `gender` CHAR(1) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `group_id` BIGINT NOT NULL,
  `height` DOUBLE NOT NULL,
  `weight` DOUBLE NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`student_id`));

CREATE TABLE `tazuzu`.`student_trans` (
  `student_id` BIGINT NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`student_id`, `language`));

CREATE TABLE `tazuzu`.`teacher` (
  `teacher_id` BIGINT NOT NULL AUTO_INCREMENT,
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `gender` CHAR(1) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `group_id` BIGINT NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`teacher_id`));


CREATE TABLE `tazuzu`.`teacher_trans` (
  `teacher_id` BIGINT NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`teacher_id`, `language`));

CREATE TABLE `tazuzu`.`group` (
  `group_id` BIGINT NOT NULL AUTO_INCREMENT,
  `group_type_id` BIGINT NOT NULL,
  `parent_group_id` BIGINT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`group_id`));

CREATE TABLE `tazuzu`.`group_trans` (
  `group_id` BIGINT NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  `group_name` VARCHAR(45) NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`group_id`, `language`));

CREATE TABLE `tazuzu`.`group_type` (
  `group_type_id` BIGINT NOT NULL AUTO_INCREMENT,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`group_type_id`));

CREATE TABLE `tazuzu`.`group_type_trans` (
  `group_type_id` BIGINT NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  `group_name` VARCHAR(45) NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`group_type_id`, `language`));

CREATE TABLE `tazuzu`.`user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(254) NOT NULL,
  `registration_date` DATETIME NOT NULL,
  `is_activated` TINYINT NOT NULL,
  `is_admin` TINYINT NOT NULL,
  `photo_path` VARCHAR(255) NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT,
  PRIMARY KEY (`user_id`));

CREATE TABLE `tazuzu`.`time_test` (
  `student_id` BIGINT NOT NULL,
  `group_id` BIGINT NOT NULL,
  `activity_id` BIGINT NOT NULL,
  `date_of_test` DATE NOT NULL,
  `result` TIME NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`student_id`, `group_id`, `activity_id`));

CREATE TABLE `tazuzu`.`distance_test` (
  `student_id` BIGINT NOT NULL,
  `group_id` BIGINT NOT NULL,
  `activity_id` BIGINT NOT NULL,
  `date_of_test` DATE NOT NULL,
  `result` DOUBLE NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`student_id`, `group_id`, `activity_id`));

CREATE TABLE `tazuzu`.`quantity_test` (
  `student_id` BIGINT NOT NULL,
  `group_id` BIGINT NOT NULL,
  `activity_id` BIGINT NOT NULL,
  `date_of_test` DATE NOT NULL,
  `result` INT NOT NULL,
  `time_of_creation` TIMESTAMP NOT NULL,
  `time_of_last_edit` TIMESTAMP NOT NULL,
  `last_edited_by` BIGINT NOT NULL,
  PRIMARY KEY (`student_id`, `group_id`, `activity_id`));

#------------------Add Foreign Keys-----------------------------------
SET sql_mode = '';

ALTER TABLE `tazuzu`.`activity_type` 
ADD INDEX `fk_activity_type_tbl_measurement_type_idx` (`measurement_type_id` ASC),
ADD INDEX `fk_activity_type_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`activity_type` 
ADD CONSTRAINT `fk_activity_type_tbl_measurement_type`
  FOREIGN KEY (`measurement_type_id`)
  REFERENCES `tazuzu`.`measurement_type` (`measurement_type_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_activity_type_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`activity` 
ADD INDEX `fk_activity_tbl_activity_type_idx` (`activity_type_id` ASC),
ADD INDEX `fk_activity_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`activity` 
ADD CONSTRAINT `fk_activity_tbl_activity_type`
  FOREIGN KEY (`activity_type_id`)
  REFERENCES `tazuzu`.`activity_type` (`activity_type_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_activity_tbl_activity_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `tazuzu`.`activity_trans` 
ADD INDEX `fk_activity_trans_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`activity_trans` 
ADD CONSTRAINT `fk_activity_trans_tbl_activity_id`
  FOREIGN KEY (`activity_id`)
  REFERENCES `tazuzu`.`activity` (`activity_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_activity_trans_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `tazuzu`.`measurement_type` 
ADD INDEX `fk_measurement_type_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`measurement_type` 
ADD CONSTRAINT `fk_measurement_type_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `tazuzu`.`measurement_type_trans` 
ADD INDEX `fk_measurement_type_trans_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`measurement_type_trans` 
ADD CONSTRAINT `fk_measurement_type_trans_tbl_measurement_type_id`
  FOREIGN KEY (`measurement_type_id`)
  REFERENCES `tazuzu`.`measurement_type` (`measurement_type_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_measurement_type_trans_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`student` 
ADD INDEX `fk_student_tbl_user_id_idx` (`user_id` ASC),
ADD INDEX `fk_student_tbl_group_id_idx` (`group_id` ASC),
ADD INDEX `fk_student_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`student` 
ADD CONSTRAINT `fk_student_tbl_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_student_tbl_group_id`
  FOREIGN KEY (`group_id`)
  REFERENCES `tazuzu`.`group` (`group_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_student_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`student_trans` 
ADD INDEX `fk_student_trans_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`student_trans` 
ADD CONSTRAINT `fk_student_trans_tbl_student_id`
  FOREIGN KEY (`student_id`)
  REFERENCES `tazuzu`.`student` (`student_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_student_trans_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`teacher` 
ADD INDEX `fk_teacher_tbl_user_id_idx` (`user_id` ASC),
ADD INDEX `fk_teacher_tbl_group_id_idx` (`group_id` ASC),
ADD INDEX `fk_teacher_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`teacher` 
ADD CONSTRAINT `fk_teacher_tbl_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_teacher_tbl_group_id`
  FOREIGN KEY (`group_id`)
  REFERENCES `tazuzu`.`group` (`group_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_teacher_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`teacher_trans` 
ADD INDEX `fk_teacher_trans_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`teacher_trans` 
ADD CONSTRAINT `fk_teacher_trans_tbl_teacher_id`
  FOREIGN KEY (`teacher_id`)
  REFERENCES `tazuzu`.`teacher` (`teacher_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_teacher_trans_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `tazuzu`.`group_trans` 
ADD INDEX `fk_group_trans_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`group_trans` 
ADD CONSTRAINT `fk_group_trans_tbl_group_id`
  FOREIGN KEY (`group_id`)
  REFERENCES `tazuzu`.`group` (`group_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_group_trans_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`group` 
ADD INDEX `fk_group_tbl_group_type_id_idx` (`group_type_id` ASC),
ADD INDEX `fk_group_tbl_parent_group_id_idx` (`parent_group_id` ASC),
ADD INDEX `fk_group_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`group` 
ADD CONSTRAINT `fk_group_tbl_group_type_id`
  FOREIGN KEY (`group_type_id`)
  REFERENCES `tazuzu`.`group_type` (`group_type_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_group_tbl_parent_group_id`
  FOREIGN KEY (`parent_group_id`)
  REFERENCES `tazuzu`.`group` (`group_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_group_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`group_type` 
ADD INDEX `fk_group_type_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`group_type` 
ADD CONSTRAINT `fk_group_type_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `tazuzu`.`group_type_trans` 
ADD INDEX `fk_group_type_trans_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`group_type_trans` 
ADD CONSTRAINT `fk_group_type_trans_tbl_group_type_id`
  FOREIGN KEY (`group_type_id`)
  REFERENCES `tazuzu`.`group_type` (`group_type_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_group_type_trans_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
 
ALTER TABLE `tazuzu`.`time_test` 
ADD INDEX `fk_time_test_tbl_group_id_idx` (`group_id` ASC),
ADD INDEX `fk_time_test_tbl_activity_id_idx` (`activity_id` ASC),
ADD INDEX `fk_time_test_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`time_test` 
ADD CONSTRAINT `fk_time_test_tbl_student_id`
  FOREIGN KEY (`student_id`)
  REFERENCES `tazuzu`.`student` (`student_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_time_test_tbl_group_id`
  FOREIGN KEY (`group_id`)
  REFERENCES `tazuzu`.`group` (`group_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_time_test_tbl_activity_id`
  FOREIGN KEY (`activity_id`)
  REFERENCES `tazuzu`.`activity` (`activity_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_time_test_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`distance_test` 
ADD INDEX `fk_distance_test_tbl_group_id_idx` (`group_id` ASC),
ADD INDEX `fk_distance_test_tbl_activity_id_idx` (`activity_id` ASC),
ADD INDEX `fk_distance_test_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`distance_test` 
ADD CONSTRAINT `fk_distance_test_tbl_student_id`
  FOREIGN KEY (`student_id`)
  REFERENCES `tazuzu`.`student` (`student_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_distance_test_tbl_group_id`
  FOREIGN KEY (`group_id`)
  REFERENCES `tazuzu`.`group` (`group_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_distance_test_tbl_activity_id`
  FOREIGN KEY (`activity_id`)
  REFERENCES `tazuzu`.`activity` (`activity_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_distance_test_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`quantity_test` 
ADD INDEX `fk_quantity_test_tbl_group_id_idx` (`group_id` ASC),
ADD INDEX `fk_quantity_test_tbl_activity_id_idx` (`activity_id` ASC),
ADD INDEX `fk_quantity_test_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`quantity_test` 
ADD CONSTRAINT `fk_quantity_test_tbl_student_id`
  FOREIGN KEY (`student_id`)
  REFERENCES `tazuzu`.`student` (`student_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_quantity_test_tbl_group_id`
  FOREIGN KEY (`group_id`)
  REFERENCES `tazuzu`.`group` (`group_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_quantity_test_tbl_activity_id`
  FOREIGN KEY (`activity_id`)
  REFERENCES `tazuzu`.`activity` (`activity_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_quantity_test_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tazuzu`.`user` 
ADD INDEX `fk_user_tbl_last_edited_by_idx` (`last_edited_by` ASC);
ALTER TABLE `tazuzu`.`user` 
ADD CONSTRAINT `fk_user_tbl_last_edited_by`
  FOREIGN KEY (`last_edited_by`)
  REFERENCES `tazuzu`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;