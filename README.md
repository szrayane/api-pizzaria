# API de Pizzaria

Este é um projeto de uma API de Pizzaria desenvolvida em Java utilizando Spring Boot.

## Descrição

A API de Pizzaria fornece endpoints para gerenciar clientes e pedidos de uma pizzaria. Atualmente, os recursos disponíveis são:

- Cadastro, atualização, exclusão e listagem de clientes.
- Cadastro, atualização, exclusão e listagem de pedidos.

## Tecnologias Utilizadas
<div align="left">
<img src="https://raw.githubusercontent.com/tandpfun/skill-icons/main/icons/Java-Dark.svg" width=80"/>
<img src="https://raw.githubusercontent.com/tandpfun/skill-icons/main/icons/Maven-Dark.svg" width="80"/>
  <img src="https://raw.githubusercontent.com/tandpfun/skill-icons/main/icons/MySQL-Dark.svg" width="80"/>
</div>

## Modelo Entidade-Relacionamento (MER)
<img src="https://lh3.googleusercontent.com/drive-storage/AJQWtBNTRdRHfGnCrmArtZ4Lty0movPmHAEAtaWAixUdGYYoY1KImT4YLhVw70FRMUs-5mUthiY2wIfNgrv9BaTFAaAK6L9eO4cvs6KDsvR-I7jo6kY=w1920-h911">


## Configuração do Ambiente

1. Certifique-se de ter o Java JDK 11 instalado em seu sistema.
2. Instale o MySQL Server e crie um banco de dados chamado `pizzaria`.
3. Clone este repositório para o seu ambiente local.
4. Configure as propriedades do banco de dados no arquivo `application.properties`.
5. Execute a aplicação utilizando a sua IDE preferida ou utilizando o comando `mvn spring-boot:run`.

## Uso

Após a execução da aplicação, você pode acessar os endpoints utilizando um cliente HTTP ou uma ferramenta como o Postman.

### Endpoints de Cliente

- `GET /cliente/mostrar`: Retorna todos os clientes cadastrados.
- `POST /cliente/salvar`: Cadastra um novo cliente.
- `PUT /cliente/atualizar{id}`: Atualiza os dados de um cliente existente.
- `DELETE /cliente/deletar{id}`: Exclui um cliente.

### Endpoints de Pedido

- `GET /pedido/mostrar`: Retorna todos os pedidos cadastrados.
- `POST /pedido/salvar`: Cadastra um novo pedido.
- `PUT /pedido/atualizar{id}`: Atualiza os dados de um pedido existente.
- `DELETE /pedido/deletar{id}`: Exclui um pedido.

