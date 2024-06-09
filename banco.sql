CREATE DATABASE IF NOT EXISTS sistema_de_emprestimo_de_ferramenta;
USE sistema_de_emprestimo_de_ferramenta;

drop table if exists ferramentas;
drop table if exists amigos;
drop table if exists emprestimos;

CREATE TABLE ferramentas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) not null,
    marca VARCHAR(255) not null,
    custo NUMERIC not null
);

CREATE TABLE amigos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) not null,
    apelido VARCHAR(100),
    telefone VARCHAR(20) not null
);

CREATE TABLE emprestimos (
	id SERIAL PRIMARY KEY,
	id_ferramenta INT NOT NULL,
	id_amigo INT NOT NULL,
	data_inicial DATE NOT NULL,
	data_prazo DATE NOT NULL,
	data_devolucao DATE,
	FOREIGN KEY (id_ferramenta) REFERENCES ferramentas(id),
	FOREIGN KEY (id_amigo) REFERENCES amigos(id)
);

