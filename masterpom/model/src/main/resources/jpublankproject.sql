DROP DATABASE IF EXISTS `JAVA-Project` ;
CREATE DATABASE IF NOT EXISTS `JAVA-Project` ;

USE `JAVA-Project` ;

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ID_Level_3numbers`(IN fileLevel Varchar(25))
BEGIN
	SELECT left(right(fileLevel, 7), 3) ;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertLevel`(IN levelN int(3))
BEGIN
	INSERT INTO level (ID_level, level) VALUES (NULL, levelN);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertMap`(
	IN levelN int(3),
    IN posX int(2),
    IN posY int(2),
    IN ID_Sprite int(2))
BEGIN
	
	INSERT INTO `map` (`ID_level`, `coordY`, `coordX`, `ID_sprite`) VALUES ((SELECT ID_level FROM level WHERE level.level = levelN), posY, posX, ID_sprite) ;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `MapByID_X_Y`(IN level int(3), IN x int(2), IN y int(2))
BEGIN
	SELECT sprite FROM map NATURAL JOIN sprite WHERE (level = ID_level) && (x = coordX) && (y = coordY) ;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `select_ID_Sprite`(IN quoi varChar(25))
BEGIN
	SELECT ID_sprite FROM Sprite WHERE sprite = quoi ;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `selectLevel`(IN levelNumber int(3))
BEGIN
	SELECT ID_level FROM level WHERE levelNumber = level ;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `selectMapExist`(IN levelN int(3))
BEGIN
	SELECT ID_level FROM map WHERE levelN = ID_level GROUP BY ID_level ;
END $$

DELIMITER ;

#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

DROP Table IF EXISTS Map;
DROP Table IF EXISTS Score;
DROP Table IF EXISTS Level;
DROP Table IF EXISTS Player;
DROP Table IF EXISTS Sprite;

#------------------------------------------------------------
# Table: Level
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Level(
        ID_level int (11) Auto_increment  NOT NULL ,
        level    Int NOT NULL ,
        PRIMARY KEY (ID_level )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Sprite
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Sprite(
        ID_sprite int (11) Auto_increment  NOT NULL ,
        sprite    Varchar (25) NOT NULL ,
        PRIMARY KEY (ID_sprite )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Map
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Map(
        coordX    Int NOT NULL ,
        coordY    Int NOT NULL ,
        ID_level  Int NOT NULL ,
        ID_sprite Int NOT NULL ,
        PRIMARY KEY (coordX ,coordY ,ID_level )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Score
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Score(
        ID_Score  int (11) Auto_increment  NOT NULL ,
        score     Int NOT NULL ,
        ID_level  Int NOT NULL ,
        ID_player Int NOT NULL ,
        PRIMARY KEY (ID_Score ,ID_level ,ID_player )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Player
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Player(
        ID_player int (11) Auto_increment  NOT NULL ,
        player    Varchar (25) NOT NULL ,
        PRIMARY KEY (ID_player )
)ENGINE=InnoDB;

ALTER TABLE Map ADD CONSTRAINT FK_Map_ID_level FOREIGN KEY (ID_level) REFERENCES Level(ID_level);
ALTER TABLE Map ADD CONSTRAINT FK_Map_ID_sprite FOREIGN KEY (ID_sprite) REFERENCES Sprite(ID_sprite);
ALTER TABLE Score ADD CONSTRAINT FK_Score_ID_level FOREIGN KEY (ID_level) REFERENCES Level(ID_level);
ALTER TABLE Score ADD CONSTRAINT FK_Score_ID_player FOREIGN KEY (ID_player) REFERENCES Player(ID_player);

#------------------------------------------------------------
# INSERT VALUES
#------------------------------------------------------------

INSERT INTO sprite (sprite) VALUES 
		("H-Bone"),
		("V-Bone"),
        ("Bone"),
        ("Gate-Close"),
        ("Crystal-Ball"),
        ("Bloc"),
        ("Grave"),
        ("Purse"),
        ("Flacon"),
        ("Candlestick"),
        ("Chalice"),
        ("Idol"),
        ("Player"),
        ("Monster-1"),
        ("Monster-2"),
        ("Monster-3"),
        ("Monster-4");
