CREATE TABLE ferramentas (
    id_ferramentas SERIAL PRIMARY KEY,
    nome VARCHAR(100) not null,
    marca VARCHAR(255) not null,
    custo NUMERIC not null
);

CREATE TABLE amigos (
    id_amigos SERIAL PRIMARY KEY,
    nome VARCHAR(100) not null,
    apelido VARCHAR(100) not null ,
    telefone VARCHAR(20) not null
);

CREATE TABLE emprestimos (
	id_emprestimos SERIAL PRIMARY KEY,
	id_ferramentas INT NOT NULL,
	id_amigos INT NOT NULL,
	data_inicial DATE NOT NULL,
	data_prazo DATE NOT NULL,
	data_devolucao DATE,
	FOREIGN KEY (id_ferramentas) REFERENCES ferramentas(id_ferramentas),
	FOREIGN KEY (id_amigos) REFERENCES amigos(id_amigos)
);

-- Inserindo dados na tabela ferramentas
INSERT INTO ferramentas (nome, marca, custo) VALUES
('Martelo', 'Marca A', 25.00),
('Chave de fenda', 'Marca B', 15.50),
('Serra elétrica', 'Marca C', 120.00);

-- Inserindo dados na tabela amigos
INSERT INTO amigos (nome, apelido, telefone) VALUES
('João Silva', 'Joãozinho', '123456789'),
('Maria Santos', 'Mary', '987654321'),
('Pedro Oliveira', 'Pedrinho', '555555555');

INSERT INTO emprestimos (id_ferramentas, id_amigos, data_inicial, data_prazo, data_devolucao)
VALUES
(1, 1, '2024-04-28', '2024-05-05', '2024-05-05'),  -- Amigo 1 emprestou ferramenta 1
(2, 2, '2024-05-10', '2024-05-15', NULL),           -- Amigo 2 emprestou ferramenta 2
(3, 3, '2024-05-15', '2024-05-20', NULL),           -- Amigo 3 emprestou ferramenta 3
(1, 1, '2024-05-15', '2024-05-20', NULL);           -- Amigo 1 emprestou outra ferramenta 1

-- inserts 

INSERT INTO ferramentas (nome, marca, custo) VALUES
(?, ?, ?);

INSERT INTO amigos (nome, apelido, telefone) VALUES
(?, ?, ?);


--querys

SELECT id_emprestimos,ferramentas.id_ferramentas,amigos.id_amigos,data_inicial,data_devolucao,ferramentas.nome AS nome_ferramenta, 
       amigos.nome AS nome_amigo,apelido FROM emprestimos
JOIN ferramentas ON emprestimos.id_ferramentas = ferramentas.id_ferramentas
JOIN amigos ON emprestimos.id_amigos = amigos.id_amigos
ORDER BY nome_amigo ASC;

SELECT amigos.id_amigos, 
       amigos.nome AS nome_amigo, 
       COUNT(emprestimos.id_emprestimos) AS quantidade_emprestimos
FROM amigos
JOIN emprestimos ON amigos.id_amigos = emprestimos.id_amigos
GROUP BY amigos.id_amigos, amigos.nome
ORDER BY quantidade_emprestimos DESC
LIMIT 1;

SELECT * FROM ferramentas
ORDER BY nome ASC;

SELECT * FROM amigos
ORDER BY nome ASC;

SELECT * FROM emprestimos
JOIN amigos ON emprestimos.id_amigos = amigos.id_amigos
WHERE emprestimos.id_amigos=1 AND data_devolucao IS NULL;

SELECT * FROM emprestimos
JOIN ferramentas ON emprestimos.id_ferramentas = ferramentas.id_ferramentas
WHERE data_devolucao IS NOT NULL;

--updates 

UPDATE ferramentas
SET nome = ?, marca = ?, custo = ?
WHERE id_ferramentas = ?;

UPDATE amigos
SET nome = ?, apelido = ?, telefone = ?
WHERE id_amigos = ?;

UPDATE emprestimo
SET data_devolucao=?
WHERE id_amigos = ?;

--deletes 

DELETE FROM ferramentas
WHERE id_ferramentas = ?;

DELETE FROM amigos
WHERE id_amigos = 1;

DELETE FROM emprestimos
WHERE id_emprestimos = ?;

DROP TABLE emprestimos;
