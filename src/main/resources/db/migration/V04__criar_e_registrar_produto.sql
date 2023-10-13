CREATE TABLE produto
(
    codigo serial  PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    preco DECIMAL(10,2),
    imagem VARCHAR(255),
    codigo_categoria BIGINT,
    
    FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)   
);
   
INSERT INTO produto(nome, descricao, preco, imagem, codigo_categoria) VALUES('Agua Mineral PET 500 ML ', 'Agua Mineral 500 ML Fardo 12', 2.50, '', 1);
INSERT INTO produto(nome, descricao, preco, imagem, codigo_categoria) VALUES('Copo descartavel 150 ML ', 'Copo descartavel 150 ML 250 UND' ,130.00, '', 1);
INSERT INTO produto(nome, descricao, preco, imagem, codigo_categoria) VALUES('Luva descartavel ', 'Luva descartavel CX', 12.60, '', 1);