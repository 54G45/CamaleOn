DROP DATABASE IF EXISTS dbbitshow;
CREATE DATABASE dbbitshow;
USE dbbitshow;

SET SQL_SAFE_UPDATES = 0;

create table usuario(
	id int not null auto_increment primary key,
    usuario varchar(50) not null,
    e_mail varchar(100) unique not null, 
    telefone varchar(15) not null,
    senha varchar(50) not null
);

create table produto(
	id int not null auto_increment primary key,
    nome varchar(50) not null,
    descricao text not null,
    categoria varchar(45) not null,
    preco varchar(50) not null,
    idusuario int
    -- nome, descrição, categoria, preço
);



create table carrinho(
	id int not null auto_increment primary key,
    idproduto int,
    idusuario int
);

create table categoria(
	id int not null auto_increment primary key,
    nome varchar(45)
);





select*from usuario;
select*from produto;
select*from carrinho;
insert into carrinho values(null, 1, 2);

select produto.* from produto left join carrinho on carrinho.idproduto = produto.id where carrinho.idusuario = 1;


















