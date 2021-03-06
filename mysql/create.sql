SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mi6` ;
CREATE SCHEMA IF NOT EXISTS `mi6` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mi6` ;

-- -----------------------------------------------------
-- Table `ip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ip` ;

CREATE  TABLE IF NOT EXISTS `ip` (
  `ip` VARCHAR(16) NOT NULL ,
  `agent` VARCHAR(200) NOT NULL ,
  `domain` VARCHAR(255) NOT NULL ,
  `Processed` TINYINT NOT NULL DEFAULT 0 ,
  `Hits` BIGINT NOT NULL DEFAULT 0 ,
  `Request` TINYINT NOT NULL DEFAULT 0 ,
  `RequestSource` VARCHAR(16) NULL ,
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
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `continent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `continent` ;

CREATE  TABLE IF NOT EXISTS `continent` (
  `continentID` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`continentID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `country` ;

CREATE  TABLE IF NOT EXISTS `country` (
  `countryID` INT NOT NULL AUTO_INCREMENT ,
  `continentID` INT NOT NULL ,
  `Name` VARCHAR(45) NOT NULL ,
  `Code` VARCHAR(2) NOT NULL ,
  `Flag` TEXT NULL ,
  PRIMARY KEY (`countryID`) ,
  INDEX `fk_country_continent_idx` (`continentID` ASC) ,
  CONSTRAINT `fk_country_continent`
    FOREIGN KEY (`continentID` )
    REFERENCES `continent` (`continentID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `city` ;

CREATE  TABLE IF NOT EXISTS `city` (
  `city` INT NOT NULL ,
  `countryID` INT NOT NULL ,
  `Name` VARCHAR(200) NOT NULL ,
  `Population` BIGINT NULL ,
  `Area` INT NULL ,
  PRIMARY KEY (`city`) ,
  INDEX `fk_city_country_idx` (`countryID` ASC) ,
  CONSTRAINT `fk_city_country`
    FOREIGN KEY (`countryID` )
    REFERENCES `country` (`countryID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_mask`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ip_mask` ;

CREATE  TABLE IF NOT EXISTS `ip_mask` (
  `ip_mask` VARCHAR(16) NOT NULL ,
  `countryID` INT NOT NULL ,
  `Company` VARCHAR(200) NULL ,
  `Hits` BIGINT NULL ,
  PRIMARY KEY (`ip_mask`) ,
  INDEX `fk_ip_mask_country_idx` (`countryID` ASC) ,
  CONSTRAINT `fk_ip_mask_country`
    FOREIGN KEY (`countryID` )
    REFERENCES `country` (`countryID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `partner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `partner` ;

CREATE  TABLE IF NOT EXISTS `partner` (
  `partnerID` INT NOT NULL AUTO_INCREMENT ,
  `Url` VARCHAR(255) NOT NULL ,
  `User` VARCHAR(45) NOT NULL ,
  `Pass` VARCHAR(45) NOT NULL ,
  `Schema` VARCHAR(45) NOT NULL ,
  `Table` VARCHAR(45) NOT NULL ,
  `Type` VARCHAR(45) NOT NULL ,
  `DateCreated` TIMESTAMP NULL ,
  `_dateModified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`partnerID`) )
ENGINE = InnoDB;

USE `mi6` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
