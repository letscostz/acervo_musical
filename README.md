# 🎵 Acervo Musical

<div align="center">

**Sistema web para cadastro e organização de músicas**

Desenvolvido como Projeto Individual de Programação Web.

<br>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge\&logo=springboot\&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge\&logo=javascript\&logoColor=black)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge\&logo=html5\&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge\&logo=css3\&logoColor=white)
![H2](https://img.shields.io/badge/H2-Database-blue?style=for-the-badge)

</div>

---

## 📖 Sobre o projeto

O **Acervo Musical** é uma aplicação web desenvolvida para cadastro e organização de músicas.

O sistema permite registrar informações como **título, artista, gênero, data de lançamento, duração, álbum, versão e características da música**.

A aplicação integra um **Front-end desenvolvido com HTML, CSS e JavaScript Vanilla** a uma **API REST desenvolvida em Java com Spring Boot**, utilizando `JdbcTemplate` para persistência dos dados no banco **H2**.

---

## ✨ Funcionalidades

* 🎵 Cadastro de músicas
* 📋 Listagem das músicas cadastradas
* 🎼 Carregamento dinâmico dos gêneros
* ✅ Validação dos dados no Front-end
* ⏱️ Conversão da duração entre `mm:ss` e segundos
* ☑️ Seleção de características da música
* 🔄 Atualização automática da lista após o cadastro
* 🌐 Comunicação entre Front-end e Back-end através de API REST

---

## 🛠️ Tecnologias

| Área               | Tecnologias                     |
| ------------------ | ------------------------------- |
| **Front-end**      | HTML5, CSS3, JavaScript Vanilla |
| **Back-end**       | Java, Spring Boot, JdbcTemplate |
| **Banco de dados** | H2 Database                     |
| **Comunicação**    | API REST, Fetch API             |

---

## 🖥️ Interface

A aplicação possui duas áreas principais:

### ➕ Cadastro de música

Formulário para inserção das informações da música, incluindo campos de texto, data, radio buttons, checkboxes e seleção de gênero.

### 🎶 Músicas cadastradas

Exibe dinamicamente as músicas armazenadas no banco de dados, apresentando suas principais informações e características.

> 💡 *Você pode adicionar aqui um print da aplicação para deixar o README ainda mais visual.*

---

## 🔌 API REST

### URL base

```text
http://localhost:8080
```

### Endpoints

| Método | Endpoint           | Descrição                            |
| :----: | ------------------ | ------------------------------------ |
|  `GET` | `/musicas`         | Retorna todas as músicas cadastradas |
| `POST` | `/musicas`         | Cadastra uma nova música             |
|  `GET` | `/musicas/generos` | Retorna os gêneros disponíveis       |

---

### 🎵 POST `/musicas`

Exemplo de requisição:

```json
{
    "titulo": "Sinais",
    "artista": "Luan Santana",
    "fkGenero": 4,
    "lancamento": "2010-07-01",
    "duracao": 225,
    "album": "O Nosso Tempo é Agora",
    "versao": "Estúdio",
    "explicita": false,
    "cover": false,
    "remix": false,
    "trilha": false
}
```

---

### 📋 GET `/musicas`

Retorna as músicas cadastradas:

```json
[
    {
        "id": 1,
        "titulo": "Sinais",
        "artista": "Luan Santana",
        "genero": "Sertanejo",
        "lancamento": "2010-07-01",
        "duracao": 225,
        "album": "O Nosso Tempo é Agora",
        "versao": "Estúdio",
        "explicita": false,
        "cover": false,
        "remix": false,
        "trilha": false
    }
]
```

---

### 🎼 GET `/musicas/generos`

Retorna os gêneros utilizados no cadastro:

```json
[
    {
        "id": 1,
        "nome": "Pop"
    },
    {
        "id": 2,
        "nome": "Rock"
    },
    {
        "id": 3,
        "nome": "Sertanejo"
    }
]
```

---

## 🗄️ Banco de dados

O projeto utiliza o **H2 Database em memória**.

### Tabelas

**`musica`**

Armazena as informações das músicas cadastradas.

**`genero`**

Armazena os gêneros disponíveis para seleção.

As tabelas possuem um relacionamento por meio da chave estrangeira:

```text
musica.fk_genero → genero.id
```

---

## 🔄 Integração

A comunicação entre o Front-end e o Back-end é realizada através da **Fetch API**.

```text
┌───────────────┐
│   Front-end   │
│ HTML / CSS /  │
│ JavaScript    │
└───────┬───────┘
        │
        │ fetch()
        ▼
┌───────────────┐
│   API REST    │
│ Spring Boot   │
└───────┬───────┘
        │
        │ JdbcTemplate
        ▼
┌───────────────┐
│      H2       │
│    Database   │
└───────────────┘
```

O Back-end possui configuração de **CORS**, permitindo que o Front-end, executado através do Live Server, realize requisições para a API.

---

## ✅ Validações

As validações são realizadas no Front-end antes do envio dos dados.

### Campos obrigatórios

São verificados:

* Título
* Artista
* Gênero
* Álbum
* Versão

### Duração

A duração deve:

* seguir o formato `mm:ss`;
* ser maior que 0 segundos;
* possuir menos de 20 minutos;
* possuir segundos entre `00` e `59`.

### Data de lançamento

A data deve:

* ser preenchida;
* ser igual ou anterior à data atual;
* ser igual ou posterior a `01/01/1990`.

---

## 📂 Estrutura do projeto

```text
acervo_musical/
│
├── backend/
│   └── acervo_musical/
│       ├── src/
│       ├── pom.xml
│       └── ...
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   ├── script.js
│   └── img/
│
└── README.md
```

---

## ▶️ Como executar

### 1. Back-end

Abra a pasta do Back-end em uma IDE compatível com Java e Spring Boot.

Execute a aplicação.

A API estará disponível em:

```text
http://localhost:8080
```

### 2. Front-end

Abra a pasta `frontend` no **Visual Studio Code**.

Utilize a extensão **Live Server** para executar o arquivo:

```text
index.html
```

Com o Back-end em execução, o Front-end poderá realizar as requisições para a API.

---

## 🎯 Objetivo acadêmico

Este projeto foi desenvolvido para aplicar, na prática, conceitos de:

* Desenvolvimento Web;
* JavaScript Vanilla;
* API REST;
* Spring Boot;
* `JdbcTemplate`;
* Banco de dados relacional;
* Persistência de dados;
* Validação de informações;
* Integração entre Front-end e Back-end.

---

<div align="center">

### 🎵 Acervo Musical

**Projeto Individual de Programação Web**

Desenvolvido por **Letícia Costa Nascimento**

</div>
