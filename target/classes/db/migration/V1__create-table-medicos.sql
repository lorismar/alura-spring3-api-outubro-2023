create table medicos(
    id int not null AUTO_INCREMENT,
    nome varchar(200) not null,
    email varchar(200) not null,
    crm varchar(200) not null,
    especialidade varchar(200) not null,
    logradouro varchar(200) not null,
    bairro varchar(200) not null,
    cep varchar(9) not null,
    complemento varchar(200) not null,
    numero varchar(20) not null,
    uf char(2) not null,
    cidade varchar(200) not null,
    primary key(id)
) ENGINE=InnoDB AUTO_INCREMENT=952 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

