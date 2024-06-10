CREATE DATABASE IF NOT EXISTS sistema_de_emprestimo_de_ferramenta;
USE sistema_de_emprestimo_de_ferramenta;

drop table if exists ferramentas;
drop table if exists amigos;
drop table if exists emprestimos;

CREATE TABLE ferramentas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    marca VARCHAR(255) NOT NULL,
    custo DOUBLE NOT NULL
);

CREATE TABLE amigos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    apelido VARCHAR(100),
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_ferramenta INT NOT NULL,
    id_amigo INT NOT NULL,
    data_inicial DATE NOT NULL,
    data_prazo DATE NOT NULL,
    data_devolucao DATE,
    FOREIGN KEY (id_ferramenta) REFERENCES ferramentas(id),
    FOREIGN KEY (id_amigo) REFERENCES amigos(id)
);

