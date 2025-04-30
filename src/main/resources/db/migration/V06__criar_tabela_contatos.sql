create table contato
(
    codigo serial primary key,
    codigo_pessoa integer not null,
    nome varchar(50) not null,
    email varchar(100) not null,
    telefone varchar(20) not null,
    foreign key (codigo_pessoa) references pessoa(codigo)
);

insert into contato
(codigo, codigo_pessoa, nome, email, telefone)
values
    (1,1,'Marcos Henrique', 'marcos@algamoney.com', '00 0000-0000');