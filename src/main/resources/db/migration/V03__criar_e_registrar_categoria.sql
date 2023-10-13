CREATE TABLE categoria
(
    codigo serial  PRIMARY KEY,
    nome VARCHAR(20) NOT NULL
   
);
   
INSERT INTO categoria (nome) values ('Limpeza');
INSERT INTO categoria (nome) values ('Mobilizado');
INSERT INTO categoria (nome) values ('Manutenção');
INSERT INTO categoria (nome) values ('Brigada');