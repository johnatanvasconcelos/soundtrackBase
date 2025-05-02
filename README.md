# 🎵 SoundtrackBase

[![Java](https://img.shields.io/badge/Java-17-blue)]()
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green)]()
[![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)]()
[![License](https://img.shields.io/badge/license-MIT-lightgrey)]()

## 📑 Sumário

- [Sobre o Projeto](#-soundtrackbase)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Estrutura de Pacotes](#-estrutura-de-pacotes)
- [Endpoints Expostos](#-endpoints-expostos)
- [Testando a API](#-testando-a-api)
- [Como Executar Localmente](#-como-executar-localmente)
- [Licença](#-licença)

---

## 📑 Sobre o Projeto

SoundtrackBase é um projeto back-end desenvolvido em Java com Spring Boot que expõe uma API REST para o gerenciamento de artistas e suas músicas.

O principal objetivo é consolidar boas práticas no desenvolvimento back-end, como arquitetura em camadas, uso de DTOs, mapeamento com JPA e persistência com Spring Data JPA. 

A aplicação utiliza o PostgreSQL como banco de dados local, promovendo uma estrutura alinhada a projetos reais de produção e seguindo princípios de organização, desacoplamento e escalabilidade.

---


## 📚 Funcionalidades

- ✅ Cadastro de artistas
- ✅ Cadastro de músicas associadas a artistas
- ✅ Consulta de todos os artistas e músicas
- ✅ Exclusão de artistas com deleção em cascata de suas músicas
- ✅ Uso de DTOs e mapeamento bidirecional entre entidade e DTO
- ✅ Validação de dados e tratamento de exceções

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

---

## 🧱 Estrutura de Pacotes

```
br.com.johnatan.soundtrackBase
├── controller
│ └── ArtistController.java
│ └── SongController.java
│
├── dto
│ └── ArtistDTO.java
│ └── SongDTO.java
│
├── mapper
│ └── ArtistMapper.java
│ └── SongMapper.java
│
├── model
│ └── Artist.java
│ └── Song.java
│
├── repository
│ └── ArtistRepository.java
│ └── SongRepository.java
│
├── service
│ └── ArtistService.java
│ └── SongService.java
│
└── SoundtrackBaseApplication.java 
```

---

## 🔗 Endpoints Expostos

### 🎤 Artistas

- `GET /artists` → Lista todos os artistas
- `GET /artists/{id}` → Busca artista por id
- `GET /artists/search?name=Floyd` → Busca artista por nome
- `POST /artists` → Cadastra um novo artista
- `DELETE /artists/{id}` → Remove um artista pelo id (e todas as suas músicas)

### 🎶 Músicas

- `GET /songs` → Lista todas as músicas
- `POST /songs` → Cadastra uma nova música associada a um artista
- `GET /songs/search?nameArtist=Pink` → Busca músicas por nome do artista'
- `GET /songs/search/year?year=1979` → Busca músicas por ano de lançamento
- `GET /artists/{id}/songs` → Busca músicas de um artista pelo id

---

## 🔌 Testando a API

Após iniciar a aplicação (executando `SoundtrackBaseApplication.java`), você pode testar os endpoints via [Postman](https://www.postman.com/) ou qualquer ferramenta similar.

### 🎵 Endpoints de Artistas

- **Criar artista**
   - `POST /artists`
   - Body (JSON):
     ```json
     {
       "name": "Pink Floyd",
       "musicalGenre": "Rock Progressivo",
       "country": "Reino Unido"
     }
     ```
---

### 🎶 Endpoints de Músicas

- **Criar música**
   - `POST /songs`
   - Body (JSON):
     ```json
     {
       "title": "Comfortably Numb",
       "duration": 384,
       "yearLaunch": 1979,
       "artistId": 1
     }
     ```
---

## 🏃🏻‍♂️ Como Executar Localmente

Para executar a aplicação local

1. **Clone o repositório:**
   ```
   git clone https://github.com/seu-usuario/soundtrackbase.git
   cd soundtrackbase
   ```
2. **Abra no IntelliJ / Eclipse**
   - Certifique-se de abrir como um projeto Maven (ou Spring Boot, dependendo do seu ambiente).


3. **Configure o banco de dados (se estiver usando um banco local ou H2):**
   - Eu utilizei o PostgreSQL 
   - Para usar PostgreSQL (ou outro banco como MySQL), crie o banco de dados no seu SGBD (por exemplo, soundtrackbase) e configure o application.properties com suas credenciais:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/soundtrackbase
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ```
4. **Execute a aplicação:**
   - No terminal ou IDE, rode a classe principal:
   ```
   SoundtrackBaseApplication.java
   ```
   - Ou, via Maven:
   ```
   ./mvnw spring-boot:run
   ```
5. **Testar os endpoints:**
   - A API estará disponível em:
   ```
      http://localhost:8080
   ```
   - Você pode usar ferramentas como Postman ou Insomnia para testar os endpoints REST.
   
   