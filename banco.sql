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
SELECT emprestimos.id as id_emprestimo,ferramentas.id as id_ferramenta,amigos.id as id_amigo,data_inicial,data_prazo,data_devolucao,ferramentas.nome AS nome_ferramenta, 
       amigos.nome AS nome_amigo,apelido FROM emprestimos
JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id
JOIN amigos ON emprestimos.id_amigo = amigos.id
ORDER BY data_prazo ASC;

SELECT *, ferramentas.nome as nome_ferramenta FROM emprestimos
JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id
JOIN amigos ON emprestimos.id_amigo = amigos.id
ORDER BY data_prazo ASC;

-- retorna os vencidos
SELECT emprestimos.id as id_emprestimo,
       ferramentas.id as id_ferramenta,
       amigos.id as id_amigo,
       data_inicial,
       data_prazo,
       data_devolucao,
       ferramentas.nome AS nome_ferramenta, 
       amigos.nome AS nome_amigo,
       apelido 
FROM emprestimos
JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id
JOIN amigos ON emprestimos.id_amigo = amigos.id
WHERE data_prazo < CURRENT_DATE AND data_devolucao IS NULL
ORDER BY data_prazo ASC;


SELECT * FROM emprestimos;

--retorna quem tem mais emprestimos
SELECT id, nome , apelido
FROM amigos
JOIN (
    SELECT id_amigo, COUNT(*) AS total_emprestimos
    FROM emprestimos
    GROUP BY id_amigo
) AS contagem_emprestimos ON amigos.id = contagem_emprestimos.id_amigo
ORDER BY contagem_emprestimos.total_emprestimos DESC
LIMIT 1;

--retorna ferramentas
SELECT * FROM ferramentas
ORDER BY nome ASC;

--retorna amigos
SELECT * FROM amigos
ORDER BY nome ASC;

--retorna amigo solicitado verificando se ele tem emprestimo em aberto
SELECT * FROM emprestimos
WHERE emprestimos.id_amigo=? AND data_devolucao IS NULL;

--retorna os emprestimos devolvidos
SELECT emprestimos.id as id_emprestimo,
       ferramentas.id as id_ferramenta,
       amigos.id as id_amigo,
       data_inicial,
       data_prazo,
       data_devolucao,
       ferramentas.nome AS nome_ferramenta, 
       amigos.nome AS nome_amigo,
       apelido  
FROM emprestimos
JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id
WHERE data_devolucao IS NOT NULL;

-- retorna se a ferramenta nao foi devolvida
SELECT id_ferramenta FROM emprestimos
WHERE id_ferramenta = ? AND data_devolucao IS NULL;

-- retorna apenas ferramentas não ativas
SELECT f.* FROM emprestimos e
RIGHT JOIN ferramentas f ON e.id_ferramenta = f.id
WHERE data_devolucao IS NOT NULL OR id_ferramenta IS NULL;

-- buscar maior utilizador
SELECT a.*, COUNT(e.id_amigo) AS quantidade_amigos 
FROM amigos a
JOIN emprestimos e ON e.id_amigo = a.id
GROUP BY a.id
ORDER BY quantidade_amigos DESC
LIMIT 1;

-- buscar amigo por nome
SELECT * FROM amigos
WHERE UPPER(nome) LIKE UPPER('%carlos%');



--updates 

UPDATE ferramentas
SET nome = ?, marca = ?, custo = ?
WHERE id_ferramentas = ?;

UPDATE amigos
SET nome = ?, apelido = ?, telefone = ?
WHERE id = ?;

UPDATE emprestimo
SET data_devolucao=?
WHERE id = ?;



--deletes 

DELETE FROM ferramentas
WHERE id = ?;

DELETE FROM amigos
WHERE id = 1;

DELETE FROM emprestimos
WHERE id = ?;

DROP TABLE ferramentas;
