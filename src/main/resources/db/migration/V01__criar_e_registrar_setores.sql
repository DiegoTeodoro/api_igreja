CREATE TABLE setor
(
    codigo bigint,
    nome character varying(2) NOT NULL,
    PRIMARY KEY (codigo)
);
   
INSERT INTO setor(codigo, nome) values(1, '01');
INSERT INTO setor(codigo, nome) values(2, '02');
INSERT INTO setor(codigo, nome) values(3, '03');
INSERT INTO setor(codigo, nome) values(4, '04');
INSERT INTO setor(codigo, nome) values(5, '05');