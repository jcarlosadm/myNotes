CREATE TABLE meus_contatos
(
    sobrenome VARCHAR(30) NOT NULL DEFAULT 'nobody',
    primeiro_nome VARCHAR(20) NOT NULL DEFAULT 'nobody',
    email VARCHAR(50),
    sexo CHAR(1),
    aniversario DATE,
    profissao VARCHAR(50),
    estado_civil VARCHAR(20),
    interesses VARCHAR(100),
    procura VARCHAR(100)
);
