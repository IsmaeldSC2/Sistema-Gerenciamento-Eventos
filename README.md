# Sistema de Gerenciamento de Eventos

 

## 📌 Descrição

Sistema web desenvolvido em Java utilizando o Spark Framework e MongoDB como banco de dados NoSQL.  
A aplicação permite o gerenciamento de usuários, eventos e inscrições, implementando operações de cadastro, listagem, atualização, remoção e consultas.

---

## 🚀 Tecnologias Utilizadas

- Java
- Spark Framework
- MongoDB
- Maven
- Git/GitHub

---

## ⚙️ Funcionalidades

### 👤 Usuários
- Cadastrar usuário
- Listar usuários
- Atualizar usuário
- Remover usuário

### 📅 Eventos
- Cadastrar evento
- Listar eventos

### 📝 Inscrições
- Realizar inscrição em evento
- Atualizar status da inscrição (PENDENTE, CONFIRMADA, CANCELADA)
- Listar inscrições pendentes
- Listar participantes por evento
- Contar inscritos por evento

---

## 🏗️ Arquitetura

O projeto foi organizado em camadas:

- **Model:** Representa as entidades do sistema (Usuario, Evento, Inscricao).
- **DAO:** Responsável pela comunicação com o MongoDB.
- **App:** Define as rotas HTTP utilizando o Spark Framework.

Essa organização facilita a manutenção e separação de responsabilidades.

---

## 💾 Banco de Dados

O sistema utiliza MongoDB local, com as seguintes coleções:

- `usuarios`
- `eventos`
- `inscricoes`

---

## ▶️ Como Executar
# Sistema de Gerenciamento de Eventos

Autor: Ismael dos Santos Costa  

## 📌 Descrição

Sistema web desenvolvido em Java utilizando o Spark Framework e MongoDB como banco de dados NoSQL.  
A aplicação permite o gerenciamento de usuários, eventos e inscrições, implementando operações de cadastro, listagem, atualização, remoção e consultas.

---

## 🚀 Tecnologias Utilizadas

- Java
- Spark Framework
- MongoDB
- Maven
- Git/GitHub

---

## ⚙️ Funcionalidades

### 👤 Usuários
- Cadastrar usuário
- Listar usuários
- Atualizar usuário
- Remover usuário

### 📅 Eventos
- Cadastrar evento
- Listar eventos

### 📝 Inscrições
- Realizar inscrição em evento
- Atualizar status da inscrição (PENDENTE, CONFIRMADA, CANCELADA)
- Listar inscrições pendentes
- Listar participantes por evento
- Contar inscritos por evento

---

## 🏗️ Arquitetura

O projeto foi organizado em camadas:

- **Model:** Representa as entidades do sistema (Usuario, Evento, Inscricao).
- **DAO:** Responsável pela comunicação com o MongoDB.
- **App:** Define as rotas HTTP utilizando o Spark Framework.

Essa organização facilita a manutenção e separação de responsabilidades.

---

## 💾 Banco de Dados

O sistema utiliza MongoDB local, com as seguintes coleções:

- `usuarios`
- `eventos`
- `inscricoes`

---

## ▶️ Como Executar

1. Instalar e iniciar o MongoDB localmente.
2. Clonar o repositório:
3. Abrir o projeto em uma IDE (IntelliJ recomendado).
4. Executar a classe `App.java`.
5. Acessar no navegador: http://localhost4567


---

## 📚 Conceitos Aplicados

- CRUD (Create, Read, Update, Delete)
- Arquitetura cliente-servidor
- Persistência com banco NoSQL
- Organização em camadas
- Manipulação de rotas HTTP

1. Instalar e iniciar o MongoDB localmente.
2. Clonar o repositório:
