CREATE TABLE categoria(
                          CODIGO SERIAL PRIMARY KEY,
                          NOME VARCHAR(50) NOT NULL
);

INSERT INTO categoria
(NOME)
VALUES
    ('Lazer'),
    ('Alimentação'),
    ('Supermecado'),
    ('Farmacia'),
    ('Outros');