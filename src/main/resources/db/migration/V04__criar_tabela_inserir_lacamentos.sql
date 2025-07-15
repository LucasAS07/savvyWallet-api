create table lancamento(
                           codigo serial primary key,
                           descricao varchar(50) not null,
                           data_vencimento date not null,
                           data_pagamento date,
                           valor decimal(10,2) not null,
                           observacao varchar(100),
                           tipo varchar(20) not null,
                           codigo_categoria integer not null,
                           codigo_pessoa integer not null,
                           foreign key (codigo_categoria) references categoria(codigo),
                           foreign key (codigo_pessoa) references pessoa(codigo)
);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Salário mensal', '2025-07-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Bahamas', '2025-07-10', '2025-07-10', 100.32, null, 'DESPESA', 2, 2);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Top Club', '2025-07-10', null, 120, null, 'RECEITA', 3, 3);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('CEMIG', '2025-07-10', '2025-07-10', 110.44, 'Geração', 'RECEITA', 3, 4);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('DMAE', '2025-07-10', null, 200.30, null, 'DESPESA', 3, 5);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Extra', '2025-07-10', '2025-07-10', 1010.32, null, 'RECEITA', 4, 6);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Bahamas', '2025-07-10', null, 500, null, 'RECEITA', 1, 7);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Top Club', '2025-07-10', '2025-07-10', 400.32, null, 'DESPESA', 4, 8);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Despachante', '2025-07-10', null, 123.64, 'Multas', 'DESPESA', 3, 9);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Pneus', '2025-07-10', '2025-07-10', 665.33, null, 'RECEITA', 5, 10);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Café', '2025-07-10', null, 8.32, null, 'DESPESA', 1, 5);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Eletrônicos', '2025-07-10', '2025-07-10', 2100.32, null, 'DESPESA', 5, 4);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Instrumentos', '2025-07-10', null, 1040.32, null, 'DESPESA', 4, 3);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Café', '2025-07-10', '2025-07-10', 4.32, null, 'DESPESA', 4, 2);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) 
VALUES ('Lanche', '2025-07-10', null, 10.20, null, 'DESPESA', 4, 1);

