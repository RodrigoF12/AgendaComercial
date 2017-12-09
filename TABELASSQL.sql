
CREATE TABLE DadosP (
id_dados int primary key,
nome varchar(50) not null,
sobrenome varchar(50) not null,
nome_social varchar(50),
D_nasc varchar(50), 
idioma varchar(50)
);


CREATE TABLE DadosPr (
id_profi int primary key,
empresa varchar(50),
cargo varchar(50),
id_dados int,
constraint fk_Dprofi foreign key(id_dados)
references DadosP(id_dados),
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Telefone (
id_phone int primary key,
ddi int not null,
ddd int not null, 
c_operadora int, 
numero int not null,
tipo varchar(50),
id_dados int,
constraint fk_phone foreign key(id_dados)
references DadosP(id_dados),
ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Email (
id_mail int primary key,
email varchar(60) not null,
tipo varchar(50),
id_dados int,
constraint fk_mail foreign key(id_dados)
references DadosP(id_dados),
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Endereco (
id_end int primary key,
tipo varchar(5) not null,
logradouro varchar(50) not null,
num varchar(20) not null,
compl varchar(20),
bairro varchar(50) not null,
cidade varchar(50) not null,
uf varchar(4) not null,
pais varchar(50) not null,
cep int not null,
categoria varchar(50),
id_dados int,
constraint fk_end foreign key(id_dados)
references DadosP(id_dados),
ON DELETE CASCADE ON UPDATE CASCADE
);



