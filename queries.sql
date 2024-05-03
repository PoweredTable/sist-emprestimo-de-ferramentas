CREATE TABLE ferramentas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) not null,
    marca VARCHAR(255) not null,
    custo NUMERIC not null
);

CREATE TABLE amigos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) not null,
    apelido VARCHAR(100) not null ,
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

INSERT INTO emprestimos (id_ferramenta, id_amigo, data_inicial, data_prazo, data_devolucao)
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

INSERT INTO emprestimos (id_ferramenta, id_amigo, data_inicial, data_prazo, data_devolucao) VALUES
(?, ?, ?, ?, ?);   


--querys

-- retorna os emprestimos
SELECT emprestimos.id as id_emprestimo,ferramentas.id as id_ferramenta,amigos.id as id_amigo,data_inicial,data_devolucao,ferramentas.nome AS nome_ferramenta, 
       amigos.nome AS nome_amigo,apelido FROM emprestimos
JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id
JOIN amigos ON emprestimos.id_amigo = amigos.id
ORDER BY nome_amigo ASC;

--retorna quem tem mais emprestimos
SELECT amigos.id, 
       amigos.nome AS nome_amigo, 
       COUNT(emprestimos.id) AS quantidade_emprestimos
FROM amigos
JOIN emprestimos ON amigos.id = emprestimos.id_amigo
GROUP BY amigos.id
ORDER BY quantidade_emprestimos DESC
LIMIT 1;

--retorna ferramentas
SELECT * FROM ferramentas
ORDER BY nome ASC;

--retorna amigos
SELECT * FROM amigos
ORDER BY nome ASC;

--retorna amigo solicitado verificando se ele tem emprestimo em aberto
SELECT * FROM emprestimos
JOIN amigos ON emprestimos.id_amigo = amigos.id
WHERE emprestimos.id_amigo=1 AND data_devolucao IS NULL;

--retorna os emprestimos devolvidos
SELECT * FROM emprestimos
JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id
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

DROP TABLE ferramentas;
