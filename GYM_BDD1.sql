--
-- File generated with SQLiteStudio v3.2.1 on jeu. juin 11 14:51:28 2020
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Abonnement
CREATE TABLE Abonnement (idAbonnement INTEGER PRIMARY KEY AUTOINCREMENT, Date_Debut DATE, Date_Fin DATE, Nombre_Mois INTEGER, Type VARCHAR, idCondidat INTEGER REFERENCES Condidat (idCondidat));

-- Table: Condidat
CREATE TABLE Condidat (idCondidat INTEGER PRIMARY KEY, Nom_Prenom VARCHAR (8, 20), Age INTEGER (0, 3), Tele INTEGER (10, 11), idProg VARCHAR REFERENCES Programme (idProgramme));

-- Table: Exercice
CREATE TABLE Exercice (idExercice INTEGER PRIMARY KEY AUTOINCREMENT, Nom_Exo VARCHAR, Nombre_Repetition INTEGER, Nombre_Series INTEGER, idProgramme VARCHAR REFERENCES Programme (idProgramme));

-- Table: Login
CREATE TABLE Login (idUser VARCHAR (17, 17) PRIMARY KEY, User VARCHAR (5, 20), Password VARCHAR (5, 20));

-- Table: Programme
CREATE TABLE Programme (idProgramme INTEGER PRIMARY KEY AUTOINCREMENT, Nom_Programme VARCHAR, Nombre_Exo INTEGER);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
