-- -----------------------------------------------------------------------------
--             G?n?ration d'une base de donn?es pour
--                      Oracle Version 10g
--                        (22/3/2017 10:49:35)
-- -----------------------------------------------------------------------------
--      Nom de la base : MLR3
--      Projet : Accueil Win'Design version 16
--      Auteur : Heyob Gauthier
--      Date de derni?re modification : 22/3/2017 10:46:38
-- -----------------------------------------------------------------------------

DROP TABLE AUTEUR CASCADE CONSTRAINTS;

DROP TABLE MUSICALE CASCADE CONSTRAINTS;

DROP TABLE EXEMPLAIRE CASCADE CONSTRAINTS;

DROP TABLE LITTERAIRE CASCADE CONSTRAINTS;

DROP TABLE THEME CASCADE CONSTRAINTS;

DROP TABLE OEUVRE CASCADE CONSTRAINTS;

DROP TABLE ECRIT CASCADE CONSTRAINTS;

-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE MLR3;

-- -----------------------------------------------------------------------------
--       TABLE : AUTEUR
-- -----------------------------------------------------------------------------

CREATE TABLE AUTEUR
   (
    ID_AUTEUR CHAR(6)  NOT NULL,
    NOM_AUT VARCHAR2(30)  NULL,
    PR_NOM_AUT VARCHAR2(30)  NULL
,   CONSTRAINT PK_AUTEUR PRIMARY KEY (ID_AUTEUR)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : MUSICALE
-- -----------------------------------------------------------------------------

CREATE TABLE MUSICALE
   (
    NB_DISQUES CHAR(6)  NOT NULL,
    ID_OEUVRE CHAR(6)  NOT NULL
,   CONSTRAINT PK_MUSICALE PRIMARY KEY (NB_DISQUES)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE MUSICALE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_MUSICALE_OEUVRE
     ON MUSICALE (ID_OEUVRE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : EXEMPLAIRE
-- -----------------------------------------------------------------------------

CREATE TABLE EXEMPLAIRE
   (
    ID_OEUVRE CHAR(6)  NOT NULL,
    NO_EXEMPLAIRE CHAR(6)  NOT NULL,
    DATE_ACHAT DATE  NULL
,   CONSTRAINT PK_EXEMPLAIRE PRIMARY KEY (ID_OEUVRE, NO_EXEMPLAIRE)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE EXEMPLAIRE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_EXEMPLAIRE_OEUVRE
     ON EXEMPLAIRE (ID_OEUVRE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : LITT?RAIRE
-- -----------------------------------------------------------------------------

CREATE TABLE LITTERAIRE
   (
    NB_PAGES CHAR(6)  NOT NULL,
    ID_OEUVRE CHAR(6)  NOT NULL
,   CONSTRAINT PK_LITTERAIRE PRIMARY KEY (NB_PAGES)
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE LITT?RAIRE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_LITTERAIRE_OEUVRE
     ON LITTERAIRE (ID_OEUVRE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : TH?ME
-- -----------------------------------------------------------------------------

CREATE TABLE THEME
   (
  CONSTRAINT PK_THEME PRIMARY KEY (THEME),
  THEME CHAR(6)  NOT NULL
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : OEUVRE
-- -----------------------------------------------------------------------------

CREATE TABLE OEUVRE
   (
    ID_OEUVRE CHAR(6)  NOT NULL,
    THEME CHAR(6)  NOT NULL,
    TITRE VARCHAR2(30)  NULL,
    DATE_PARUTION DATE  NULL
,   CONSTRAINT PK_OEUVRE PRIMARY KEY (ID_OEUVRE)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE OEUVRE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_OEUVRE_THEME
     ON OEUVRE (THEME ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : ECRIT
-- -----------------------------------------------------------------------------

CREATE TABLE ECRIT
   (
    ID_OEUVRE CHAR(6)  NOT NULL,
    ID_AUTEUR CHAR(6)  NOT NULL
,   CONSTRAINT PK_ECRIT PRIMARY KEY (ID_OEUVRE, ID_AUTEUR)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE ECRIT
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_ECRIT_OEUVRE
     ON ECRIT (ID_OEUVRE ASC)
    ;

CREATE  INDEX I_FK_ECRIT_AUTEUR
     ON ECRIT (ID_AUTEUR ASC)
    ;


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE MUSICALE ADD (
     CONSTRAINT FK_MUSICALE_OEUVRE
          FOREIGN KEY (ID_OEUVRE)
               REFERENCES OEUVRE (ID_OEUVRE))   ;

ALTER TABLE EXEMPLAIRE ADD (
     CONSTRAINT FK_EXEMPLAIRE_OEUVRE
          FOREIGN KEY (ID_OEUVRE)
               REFERENCES OEUVRE (ID_OEUVRE))   ;

ALTER TABLE LITTERAIRE ADD (
     CONSTRAINT FK_LITTERAIRE_OEUVRE
          FOREIGN KEY (ID_OEUVRE)
               REFERENCES OEUVRE (ID_OEUVRE))   ;

ALTER TABLE OEUVRE ADD (
     CONSTRAINT FK_OEUVRE_THEME
          FOREIGN KEY (THEME)
               REFERENCES THEME (THEME))   ;

ALTER TABLE ECRIT ADD (
     CONSTRAINT FK_ECRIT_OEUVRE
          FOREIGN KEY (ID_OEUVRE)
               REFERENCES OEUVRE (ID_OEUVRE))   ;

ALTER TABLE ECRIT ADD (
     CONSTRAINT FK_ECRIT_AUTEUR
          FOREIGN KEY (ID_AUTEUR)
               REFERENCES AUTEUR (ID_AUTEUR))   ;


-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------