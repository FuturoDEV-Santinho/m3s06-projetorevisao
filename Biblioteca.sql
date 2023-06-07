
/* ************************* */
/* Criação de Banco de dados */
/* ************************* */
CREATE DATABASE biblioteca;


/* ****************** */
/* Criação de Tabelas */
/* ****************** */
CREATE TABLE autor (
  autor_id bigserial PRIMARY KEY,
  nome varchar(15) NOT NULL,
  sobrenome varchar(30) NOT NULL,
  nascimento timestamp
);

CREATE TABLE livro (
  livro_id bigserial PRIMARY KEY,
  titulo varchar(100) NOT NULL,
  subtitulo varchar(255),
  categoria varchar(20) NOT NULL,
  classificacao_etaria integer NOT NULL,
  numero_paginas integer NOT NULL,
  autor_id bigint NOT NULL REFERENCES autor(autor_id),
  editora varchar(20) NOT NULL,
  quantidade_disponivel integer NOT NULL DEFAULT 0
);

CREATE TABLE usuario (
  usuario_id bigserial PRIMARY KEY,
  nome varchar(255) NOT NULL,
  nascimento timestamp NOT NULL,
  cpf varchar(15) NOT NULL,
  email varchar(255) NOT NULL
);

CREATE TABLE emprestimo (
  emprestimo_id bigserial PRIMARY KEY,
  data_emprestimo timestamp NOT NULL,
  usuario_id bigint NOT NULL,
  quantidade_livros integer NOT NULL,
  data_devolucao timestamp NOT NULL,
  valor_multa numeric(19, 2) NOT NULL,
  CONSTRAINT emprestimo_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);

CREATE TABLE emprestimo_livro (
  emprestimo_livro_id bigserial PRIMARY KEY,
  emprestimo_id bigint NOT NULL REFERENCES emprestimo(emprestimo_id),
  livro_id bigint NOT NULL REFERENCES livro(livro_id)
);
