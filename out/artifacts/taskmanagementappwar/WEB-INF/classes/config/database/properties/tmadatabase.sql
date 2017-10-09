
DROP SCHEMA IF EXISTS `tmadatabase`;
CREATE SCHEMA `tmadatabase`;

DROP TABLE IF EXISTS `tmadatabase`.`tmatable`;
CREATE TABLE  `tmadatabase`.`tmatable` (

  `taskID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,

  `taskName` varchar(255) NOT NULL,
  `taskEndDate` datetime NOT NULL,
  `description` varchar(255) NOT NULL,
  `createdBy` varchar(255) NOT NULL,

  `creationTimeStamp` datetime NOT NULL,

  PRIMARY KEY (`taskID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARACTER SET utf8mb4;

select * from `tmadatabase`.`tmatable`;

desc `tmadatabase`.`tmatable`;
