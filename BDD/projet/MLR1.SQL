-- -----------------------------------------------------------------------------
--             Génération d'une base de données pour
--                      Oracle Version 10g
--                        (24/4/2017 15:25:27)
-- -----------------------------------------------------------------------------
--      Nom de la base : MLR1
--      Projet : TP1 EX1
--      Auteur : Heyob Gauthier
--      Date de dernière modification : 24/4/2017 15:23:39
-- -----------------------------------------------------------------------------

DROP TABLE LIVRE CASCADE CONSTRAINTS;

DROP TABLE ARTISTE CASCADE CONSTRAINTS;

DROP TABLE MEDIA CASCADE CONSTRAINTS;

DROP TABLE FILM CASCADE CONSTRAINTS;

DROP TABLE MUSIC CASCADE CONSTRAINTS;

DROP TABLE UTILISATEURS CASCADE CONSTRAINTS;

DROP TABLE STATISTIQUE CASCADE CONSTRAINTS;

DROP TABLE SCROBBLE CASCADE CONSTRAINTS;

DROP TABLE INTERPRETE CASCADE CONSTRAINTS;

DROP TABLE PRODUIT CASCADE CONSTRAINTS;

-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE MLR1;

-- -----------------------------------------------------------------------------
--       TABLE : LIVRE
-- -----------------------------------------------------------------------------

CREATE TABLE LIVRE
   (
    TITRE CHAR(32)  NOT NULL,
    AUTEURS CHAR(32)  NOT NULL,
    GENRE_LITT VARCHAR2(128)  NOT NULL,
    EDITEUR CHAR(32)  NOT NULL,
    ANNEE NUMBER(4)  NOT NULL,
    TYPE CHAR(32)  NOT NULL,
    DATE_AJOUT DATE  NOT NULL
,   CONSTRAINT PK_LIVRE PRIMARY KEY (TITRE, AUTEURS)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : ARTISTE
-- -----------------------------------------------------------------------------

CREATE TABLE ARTISTE
   (
    NOMARTISTE VARCHAR2(128)  NOT NULL,
    NOM CHAR(32)  NULL,
    PRENOM CHAR(32)  NULL,
    DATE_AJOUT DATE  NOT NULL
,   CONSTRAINT PK_ARTISTE PRIMARY KEY (NOMARTISTE)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : MEDIA
-- -----------------------------------------------------------------------------

CREATE TABLE MEDIA
   (
    TITRE CHAR(32)  NOT NULL,
    AUTEURS CHAR(32)  NOT NULL,
    EDITEUR CHAR(32)  NOT NULL,
    ANNEE NUMBER(4)  NOT NULL,
    TYPE CHAR(32)  NOT NULL,
    DATE_AJOUT DATE  NOT NULL
,   CONSTRAINT PK_MEDIA PRIMARY KEY (TITRE, AUTEURS)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : FILM
-- -----------------------------------------------------------------------------

CREATE TABLE FILM
   (
    TITRE CHAR(32)  NOT NULL,
    AUTEURS CHAR(32)  NOT NULL,
    GENRE_FILM VARCHAR2(128)  NOT NULL,
    EDITEUR CHAR(32)  NOT NULL,
    ANNEE NUMBER(4)  NOT NULL,
    TYPE CHAR(32)  NOT NULL,
    DATE_AJOUT DATE  NOT NULL
,   CONSTRAINT PK_FILM PRIMARY KEY (TITRE, AUTEURS)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : MUSIC
-- -----------------------------------------------------------------------------

CREATE TABLE MUSIC
   (
    TITRE CHAR(32)  NOT NULL,
    AUTEURS CHAR(32)  NOT NULL,
    DUREE NUMBER(4)  NOT NULL,
    GENRE_MUSIC VARCHAR2(128)  NOT NULL,
    TITRE_ALBUM CHAR(32)  NOT NULL,
    TYPE_ALBUM CHAR(32)  NOT NULL,
    INTERPRETE CHAR(32)  NOT NULL,
    EDITEUR CHAR(32)  NOT NULL,
    ANNEE NUMBER(4)  NOT NULL,
    TYPE CHAR(32)  NOT NULL,
    DATE_AJOUT DATE  NOT NULL
,   CONSTRAINT PK_MUSIC PRIMARY KEY (TITRE, AUTEURS)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : UTILISATEURS
-- -----------------------------------------------------------------------------

CREATE TABLE UTILISATEURS
   (
    PSEUDO CHAR(32)  NOT NULL,
    PASSWORD CHAR(32)  NOT NULL,
    AGE NUMBER(1)  NOT NULL,
    POSTCODE NUMBER(1)  NOT NULL,
    MAIL CHAR(32)  NOT NULL
,   CONSTRAINT PK_UTILISATEURS PRIMARY KEY (PSEUDO)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : STATISTIQUE
-- -----------------------------------------------------------------------------

CREATE TABLE STATISTIQUE
   (
    TITRE CHAR(32)  NOT NULL,
    AUTEURS CHAR(32)  NOT NULL,
    USER CHAR(32)  NOT NULL,
    DATE_SCROBBLE DATE  NOT NULL
,   CONSTRAINT PK_STATISTIQUE PRIMARY KEY (TITRE, AUTEURS)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : SCROBBLE
-- -----------------------------------------------------------------------------

CREATE TABLE SCROBBLE
   (
    TITRE CHAR(32)  NOT NULL,
    AUTEURS CHAR(32)  NOT NULL,
    PSEUDO CHAR(32)  NOT NULL,
    DATE DATE  NOT NULL
,   CONSTRAINT PK_SCROBBLE PRIMARY KEY (TITRE, AUTEURS, PSEUDO)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE SCROBBLE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_SCROBBLE_MEDIA
     ON SCROBBLE (TITRE ASC, AUTEURS ASC)
    ;

CREATE  INDEX I_FK_SCROBBLE_UTILISATEURS
     ON SCROBBLE (PSEUDO ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : INTERPRETE
-- -----------------------------------------------------------------------------

CREATE TABLE INTERPRETE
   (
    TITRE CHAR(32)  NOT NULL,
    AUTEURS CHAR(32)  NOT NULL,
    NOMARTISTE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_INTERPRETE PRIMARY KEY (TITRE, AUTEURS, NOMARTISTE)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE INTERPRETE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_INTERPRETE_MUSIC
     ON INTERPRETE (TITRE ASC, AUTEURS ASC)
    ;

CREATE  INDEX I_FK_INTERPRETE_ARTISTE
     ON INTERPRETE (NOMARTISTE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : PRODUIT
-- -----------------------------------------------------------------------------

CREATE TABLE PRODUIT
   (
    NOMARTISTE VARCHAR2(128)  NOT NULL,
    TITRE CHAR(32)  NOT NULL,
    AUTEURS CHAR(32)  NOT NULL
,   CONSTRAINT PK_PRODUIT PRIMARY KEY (NOMARTISTE, TITRE, AUTEURS)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE PRODUIT
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_PRODUIT_ARTISTE
     ON PRODUIT (NOMARTISTE ASC)
    ;

CREATE  INDEX I_FK_PRODUIT_MEDIA
     ON PRODUIT (TITRE ASC, AUTEURS ASC)
    ;


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE LIVRE ADD (
     CONSTRAINT FK_LIVRE_MEDIA
          FOREIGN KEY (TITRE, AUTEURS)
               REFERENCES MEDIA (TITRE, AUTEURS))   ;

ALTER TABLE FILM ADD (
     CONSTRAINT FK_FILM_MEDIA
          FOREIGN KEY (TITRE, AUTEURS)
               REFERENCES MEDIA (TITRE, AUTEURS))   ;

ALTER TABLE MUSIC ADD (
     CONSTRAINT FK_MUSIC_MEDIA
          FOREIGN KEY (TITRE, AUTEURS)
               REFERENCES MEDIA (TITRE, AUTEURS))   ;

ALTER TABLE STATISTIQUE ADD (
     CONSTRAINT FK_STATISTIQUE_MEDIA
          FOREIGN KEY (TITRE, AUTEURS)
               REFERENCES MEDIA (TITRE, AUTEURS))   ;

ALTER TABLE SCROBBLE ADD (
     CONSTRAINT FK_SCROBBLE_MEDIA
          FOREIGN KEY (TITRE, AUTEURS)
               REFERENCES MEDIA (TITRE, AUTEURS))   ;

ALTER TABLE SCROBBLE ADD (
     CONSTRAINT FK_SCROBBLE_UTILISATEURS
          FOREIGN KEY (PSEUDO)
               REFERENCES UTILISATEURS (PSEUDO))   ;

ALTER TABLE INTERPRETE ADD (
     CONSTRAINT FK_INTERPRETE_MUSIC
          FOREIGN KEY (TITRE, AUTEURS)
               REFERENCES MUSIC (TITRE, AUTEURS))   ;

ALTER TABLE INTERPRETE ADD (
     CONSTRAINT FK_INTERPRETE_ARTISTE
          FOREIGN KEY (NOMARTISTE)
               REFERENCES ARTISTE (NOMARTISTE))   ;

ALTER TABLE PRODUIT ADD (
     CONSTRAINT FK_PRODUIT_ARTISTE
          FOREIGN KEY (NOMARTISTE)
               REFERENCES ARTISTE (NOMARTISTE))   ;

ALTER TABLE PRODUIT ADD (
     CONSTRAINT FK_PRODUIT_MEDIA
          FOREIGN KEY (TITRE, AUTEURS)
               REFERENCES MEDIA (TITRE, AUTEURS))   ;


-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------