# Desafio Técnico - Microserviços com Spring Cloud

Este projeto foi desenvolvido como parte de um [desafio técnico da NTT DATA em parceria com a DIO](https://hermes.dio.me/files/assets/727a1238-e5b7-4acb-bd46-1873077c4203.png). Trata-se de um projeto composto por dois microserviços, simulando um sistema de catálogo de produtos e gestão de pedidos. Ambos são chamados pelo cliente por meio de uma API Gateway e mapeados por um Service Discovery (Eureka).

## Conteúdos

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Visão Geral](#visão-geral)
- [Instalação](#instalação)
- [Uso](#uso)
- [Endpoints da API](#endpoints-da-api)

## Tecnologias Utilizadas

    - Java 21
    - Spring Boot
    - Spring Cloud
    - Spring Cloud Eureka
    - Spring Cloud Gateway
    - Spring Cloud OpenFeign
    - Spring Data JPA
    - H2 Database
    - Maven

## Visão Geral

O projeto é composto por dois microserviços principais:
1. **Catalog Microservice**: Gerencia o catálogo de produtos, permitindo adicionar e listar produtos. `porta: 8100`

2. **Order Simulator Microservice**: Simula a criação de pedidos com base nos produtos do catálogo. `porta: 8200`

3. **API Gateway**: Roteia as requisições para os microserviços correspondentes. `porta: 8700`

4. **Service Discovery (Eureka)**: Permite que os microserviços se registrem e descubram uns aos outros. `porta: 8600`

5. **Banco de dados**: Utilizado H2Database para persistência de dados em memória apenas no microserviço 1 (catálogo).

## Instalação

Para executar o projeto, você precisará ter o Java 21 e o Maven instalados em sua máquina.
1. Clone orepositório:
   ```bash
   git clone https://github.com/uvsl1/Desafio-Microservicos-NTT-DATA.git
   ```
2. Compile cada projeto com Maven e execute um por um começando pelo Discovery Service.

## Uso

Após iniciar os microserviços, você pode acessar a API Gateway em `http://localhost:8700` pelo Postman ou outro cliente HTTP.

## Endpoints da API

### Catalog Microservice
- **Adicionar produto**: `POST /produtos`

```json
{
   "nome": "Camiseta Azul",
   "descricao": "Camiseta de algodão azul",
   "preco": 59.90
}
```

- **Listar produtos**: `GET /produtos`

```json
[
   {
      "nome": "Camiseta Azul",
      "descricao": "Camiseta de algodão azul",
      "preco": 59.9,
      "id": 1
   },
   {
      "nome": "Blusa Branca",
      "descricao": "Blusa de frio branca",
      "preco": 89.2,
      "id": 2
   }
]
```

- **Listar produtos**: `GET /produtos/id/{id}`

```json
{
   "nome": "Camiseta Azul",
   "descricao": "Camiseta de algodão azul",
   "preco": 59.9,
   "id": 1
}
```

### Order Simulator Microservice

- **Criar pedido (Request)**: `POST /pedidos/simular` *O pedido é baseado no ID de produtos do catálogo.*

```json
{
   "productsId": [1, 2]
}
```
```json
{
   "productsId": [1, 2, 3]
}
```

- **Criar pedido (Response)**:

```json
{
   "produtos": [
      {
         "nome": "Camiseta Azul",
         "descricao": "Camiseta de algodão azul",
         "preco": 59.9,
         "id": 1
      },
      {
         "nome": "Blusa Branca",
         "descricao": "Blusa de frio branca",
         "preco": 89.2,
         "id": 2
      }
   ],
   "total": 149.1
}
```

