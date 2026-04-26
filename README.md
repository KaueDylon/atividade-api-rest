# 📚 API de Biblioteca

Uma API REST simples para gerenciamento de uma biblioteca, permitindo controlar **usuários**, **livros** e **empréstimos**.

---

## 🚀 Objetivo

O projeto tem como objetivo simular o funcionamento básico de uma biblioteca:

- Cadastro de usuários  
- Cadastro de livros  
- Controle de empréstimos e devoluções  

---

## 🧩 Entidades

### 👤 Usuário

| Campo | Tipo |
|------|------|
| id | Long |
| nome | String |
| email | String |

---

### 📖 Livro

| Campo | Tipo |
|------|------|
| id | Long |
| titulo | String |
| autor | String |
| isbn | String |
| disponivel | Boolean |

---

### 🔄 Empréstimo

| Campo | Tipo |
|------|------|
| id | Long |
| usuario | Usuario |
| livro | Livro |
| dataEmprestimo | LocalDate |
| dataDevolucao | LocalDate |

---

### 🔗 Relacionamentos das Entidades

| Origem | Relação | Destino |
|--------|--------|--------|
| Usuario | 1:N | Emprestimo |
| Livro | 1:N | Emprestimo |

---

## 📘 Endpoints

### 👤 Usuários

| Método | Endpoint | Entrada | Retorno | Descrição |
|--------|---------|--------|---------|----------|
| GET | `/api/usuarios` | — | [{<br>&nbsp;&nbsp;"email": "aluno.teste@gmail.com",<br>&nbsp;&nbsp;"id": 1,<br>&nbsp;&nbsp;"nome": "Aluno Teste"<br>}] | Lista todos os usuários |
| GET | `/api/usuarios/{id}` | — |  [{<br>&nbsp;&nbsp;"email": "aluno.teste3@gmail.com",<br>&nbsp;&nbsp;"id": 3,<br>&nbsp;&nbsp;"nome": "Aluno 3 Teste"<br>}]  | Busca usuário por ID |
| PUT | `/api/usuarios` | [{<br>&nbsp;&nbsp;"email": "aluno.teste3@gmail.com",<br>&nbsp;&nbsp;"id": 3,<br>&nbsp;&nbsp;"nome": "Aluno Teste Editado"<br>}] | [{<br>&nbsp;&nbsp;"email": "aluno.teste3@gmail.com",<br>&nbsp;&nbsp;"id": 3,<br>&nbsp;&nbsp;"nome": "Aluno Teste Editado"<br>}] | Atualiza usuário |

### 📖 Livros

| Método | Endpoint | Entrada | Retorno | Descrição |
|--------|---------|--------|---------|----------|
| GET | `/api/livros` | — | [{<br>&nbsp;&nbsp;"id": 1,<br>&nbsp;&nbsp;"titulo": "teste Livro",<br>&nbsp;&nbsp;"autor": "2312",<br>&nbsp;&nbsp;"isbn": "31231",<br>&nbsp;&nbsp;"disponivel": true<br>}] | Lista todos os livros |
| POST | `/api/livros` | {<br>&nbsp;&nbsp;"titulo": "teste Livro",<br>&nbsp;&nbsp;"autor": "2312",<br>&nbsp;&nbsp;"isbn": "31231"<br>} | {<br>&nbsp;&nbsp;"id": 1,<br>&nbsp;&nbsp;"titulo": "teste Livro",<br>&nbsp;&nbsp;"autor": "2312",<br>&nbsp;&nbsp;"isbn": "31231",<br>&nbsp;&nbsp;"disponivel": true<br>} | Cadastra novo livro |

### 🔄 Empréstimos

| Método | Endpoint | Entrada | Retorno | Descrição |
|--------|---------|--------|---------|----------|
| GET | `/api/emprestimos` | — | [{<br>&nbsp;&nbsp;"id": 3,<br>&nbsp;&nbsp;"dataEmprestimo": "2026-04-25",<br>&nbsp;&nbsp;"dataDevolucao": null,<br>&nbsp;&nbsp;"livro": {<br>&nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"titulo": "teste Livro",<br>&nbsp;&nbsp;&nbsp;&nbsp;"autor": "2312",<br>&nbsp;&nbsp;&nbsp;&nbsp;"isbn": "31231",<br>&nbsp;&nbsp;&nbsp;&nbsp;"disponivel": false<br>&nbsp;&nbsp;},<br>&nbsp;&nbsp;"usuario": {<br>&nbsp;&nbsp;&nbsp;&nbsp;"id": 2,<br>&nbsp;&nbsp;&nbsp;&nbsp;"nome": "Fulano",<br>&nbsp;&nbsp;&nbsp;&nbsp;"email": "FulanoTeste@gmail.com"<br>&nbsp;&nbsp;}<br>}] | Lista todos os empréstimos |
| POST | `/api/emprestimos` | {<br>&nbsp;&nbsp;"usuarioId": 2,<br>&nbsp;&nbsp;"livroId": 1<br>} | {<br>&nbsp;&nbsp;"id": 3,<br>&nbsp;&nbsp;"dataEmprestimo": "2026-04-25",<br>&nbsp;&nbsp;"dataDevolucao": null,<br>&nbsp;&nbsp;"livro": {<br>&nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"titulo": "teste Livro",<br>&nbsp;&nbsp;&nbsp;&nbsp;"autor": "2312",<br>&nbsp;&nbsp;&nbsp;&nbsp;"isbn": "31231",<br>&nbsp;&nbsp;&nbsp;&nbsp;"disponivel": false<br>&nbsp;&nbsp;},<br>&nbsp;&nbsp;"usuario": {<br>&nbsp;&nbsp;&nbsp;&nbsp;"id": 2,<br>&nbsp;&nbsp;&nbsp;&nbsp;"nome": "Fulano",<br>&nbsp;&nbsp;&nbsp;&nbsp;"email": "FulanoTeste@gmail.com"<br>&nbsp;&nbsp;}<br>} | Realiza empréstimo |
| PATCH | `/api/emprestimos/{id}/devolver` | {<br>&nbsp;&nbsp;"usuarioId": 2,<br>&nbsp;&nbsp;"livroId": 1<br>} | {<br>&nbsp;&nbsp;"id": 3,<br>&nbsp;&nbsp;"dataEmprestimo": "2026-04-25",<br>&nbsp;&nbsp;"dataDevolucao": "2026-04-30",<br>&nbsp;&nbsp;"livro": {<br>&nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"titulo": "teste Livro",<br>&nbsp;&nbsp;&nbsp;&nbsp;"disponivel": true<br>&nbsp;&nbsp;}<br>} | Registra devolução |
