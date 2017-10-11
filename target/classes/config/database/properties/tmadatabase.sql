
DROP SCHEMA IF EXISTS `tmadatabase`;
CREATE SCHEMA `tmadatabase`;

DROP TABLE IF EXISTS `tmadatabase`.`tmatable`;
CREATE TABLE  `tmadatabase`.`tmatable` (

  `taskID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,

  `taskName` varchar(255) ,
  `taskEndDate` datetime ,
  `description` varchar(255) ,
  `createdBy` varchar(255) ,

  `creationTimeStamp` datetime ,

  PRIMARY KEY (`taskID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARACTER SET utf8mb4;

select * from `tmadatabase`.`tmatable`;

desc `tmadatabase`.`tmatable`;
