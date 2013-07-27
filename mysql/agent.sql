USE `ahughes_mi6`;

DROP TABLE IF EXISTS `ip`;
CREATE  TABLE IF NOT EXISTS `ip` (
  `ip` VARCHAR(16) NOT NULL ,
  `agent` VARCHAR(200) NOT NULL ,
  `domain` VARCHAR(255) NOT NULL ,
  `ip_mask` VARCHAR(16) NULL ,
  `Processed` TINYINT NOT NULL DEFAULT 0 ,
  `Hostname` VARCHAR(255) NULL ,
  `City` VARCHAR(128) NULL ,
  `Region` VARCHAR(128) NULL ,
  `Country` VARCHAR(64) NULL ,
  `CountryCode` VARCHAR(2) NULL ,
  `Latitude` DOUBLE NULL ,
  `Longitude` DOUBLE NULL ,
  `PostCode` VARCHAR(30) NULL ,
  `TimeZone` VARCHAR(8) NULL ,
  `DateCreated` TIMESTAMP NULL ,
  `_dateModified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`ip`, `agent`, `domain`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
