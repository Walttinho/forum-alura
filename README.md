Fórum Alura API Rest - Programa ONE - Parceria Oracle & Alura
------------------------------------------------------------
Este é o projeto Forum Alura, terceiro challenge da formação ONE | Fase 3 - Especialização Back-End.

O objetivo deste desafio foi proporcionar uma API Rest desenvolvida com o Spring Boot como backend de um fórum e discussão, o  projeto gerencia tópicos permitindo a criação, listagem, atualização e exclusão de usuários, cursos e tópicos, seguindo as melhores práticas do modelo REST *** incluindo um CRUD completo, paginação, autenticação via JWT e validações de dados.
A persistencia dos dados na API é feita em um banco de dados MySQL por meio de Spring Data JPA.
Os processos de autenticação e autentificação para garantir a segurança dos dados foram feitos com o Spring Security usando a libreria auth0 para o processo de geração de tokens com o padrão JWT.

⚜️ Funcionalidades
------------------------------------------------------------
Tópicos
Criar um novo tópico: Permite aos usuários criar novos tópicos.
Listar todos os tópicos: Recupera e exibe todos os tópicos criados com paginação (10 registros por página), ordenados pela data de criação em ordem ascendente, incluindo informações sobre o autor e o curso.
Mostrar um tópico específico: Exibe os detalhes de um tópico específico.
Atualizar um tópico: Permite a atualização das informações de um tópico.
Eliminar um tópico: Inativa um tópico no banco de dados.
Usuários
Registrar um novo usuário: Permite o registro de novos usuários.
Listar todos os usuários: Recupera e exibe todos os usuários cadastrados.
Mostrar um usuário específico: Exibe os detalhes de um usuário específico.
Atualizar um usuário: Permite a atualização das informações de um usuário.
Eliminar um usuário: Remove um usuário do sistema.
Cursos
Registrar um novo curso: Permite o registro de novos cursos.
Listar todos os cursos: Recupera e exibe todos os cursos cadastrados.
Mostrar um curso específico: Exibe os detalhes de um curso específico.
Atualizar um curso: Permite a atualização das informações de um curso.
Eliminar um curso: Remove um curso do sistema.

📌 Certifique-se de ter os seguintes programas, arquivos e versões:
------------------------------------------------------------
* Java JDK: versão: 17 em diante -Download the Latest Java LTS Free
* Maven: versão 4 em diante
* Spring Boot: versão 3 em diante - https://start.spring.io/
* MySQL: versão 8 em diante
* IDE (Ambiente de desenvolvimento integrado) IntelliJ IDEA- opcional -

📌 Configuração e dependências para adicionar ao criar o projecto com Spring Initializr:
-------------------------------------------------------

* Java (versão 17 em diante) 
* Maven (Initializr utiliza a versão 4)
* Spring Boot
* Projeto em JAR

* Lombok
* Spring Web
* Spring Boot DevTools
* Spring Data JPA
* Flyway Migration
* MySQL Driver
* Validation
* Spring Security

⚜️ Diagrama Proposto para o Banco de Dados
---------------------------------------------
![diagramabancodados.jpg](src%2Fmain%2Fresources%2Fdiagramabancodados.jpg)

