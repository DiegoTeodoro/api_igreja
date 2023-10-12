CREATE TABLE igreja
(
    codigo serial  PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(30),
	numero VARCHAR(20),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	uf char(2),
	codigo_setor BIGINT,
	ativo BOOLEAN NOT NULL,
	
	FOREIGN KEY(codigo_setor) REFERENCES setor(codigo)
  
);
   
INSERT INTO igreja (nome, logradouro, numero, complemento, bairro, cep, cidade, uf, ativo, codigo_setor) values 
('Copacabana', 'Rua Vinte Nove de Outubro', '245', null, 'Copacabana', '38.400-12', 'Uberlândia', 'MG', true, 1);
