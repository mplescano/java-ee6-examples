CREATE DATABASE appstore;

USE appstore;

CREATE USER 'jboss'@'localhost' IDENTIFIED BY 'jboss';

GRANT ALL PRIVILEGES ON appstore TO  'jboss'@'localhost' WITH GRANT OPTION;

CREATE TABLE  `appstore`.`customer` (
                                        `ID` int(10) unsigned NOT NULL auto_increment,
                                        `NAME` varchar(45) NOT NULL,
                                        `COUNTRY` varchar(45) NOT NULL,
                                        PRIMARY KEY  (`ID`)
) ENGINE=InnoDB;
CREATE TABLE  `appstore`.`item` (
                                    `ID` int(10) unsigned NOT NULL auto_increment,
                                    `PRODUCT` varchar(45) default NULL,
                                    `PRICE` int(11) default NULL,
                                    `QUANTITY` int(11) default NULL,
                                    `CUSTOMER_ID` int(10) unsigned NOT NULL,
                                    PRIMARY KEY  (`ID`),
                                    KEY `FK_orders` (`CUSTOMER_ID`),
                                    CONSTRAINT `FK_orders` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;