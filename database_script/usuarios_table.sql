CREATE DATABASE test;
USE test;

CREATE TABLE usuarios(
   id_user int(11) NOT NULL AUTO_INCREMENT,
   username VARCHAR(30) NOT NULL,
   password VARCHAR(30) NOT NULL,
   PRIMARY KEY(id_user)
);