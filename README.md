# <a name="product-ms"></a>product-ms

Microsserviço de produtos criado para o desafio técnico Compasso UOL

Índice
=================
<!--ts-->
   * [Sobre](#product-ms)
   * [Tecnologias utilizadas](#tecnologias)
   * [Endpoints](#endpoints)
   * [Rodando o Projeto](#rodandoo)
      * [Diretamente com a JRE via terminal](#jre)
      * [Utilizando o docker](#docker)      
<!--te-->

### <a name="tecnologias"></a>Tecnologias utilizadas

As seguintes ferramentas foram usadas na construção do projeto:

- Java 11
- Spring Boot 2.4.3
- Maven
- Docker
- H2 Database (Para fins de desenvolvimento)

### <a name="endpoints"></a>Endpoints

| Verbo HTTP  |  Resource path    |           Descrição           |
|-------------|:-----------------:|------------------------------:|
| POST        |  /products        |   Criação de um produto       |
| PUT         |  /products/{id}   |   Atualização de um produto   |
| GET         |  /products/{id}   |   Busca de um produto por ID  |
| GET         |  /products        |   Lista de produtos           |
| GET         |  /products/search |   Lista de produtos filtrados |
| DELETE      |  /products/{id}   |   Deleção de um produto       |


### <a name="rodando"></a>Rodando o Projeto

#### <a name="jre"></a>Diretamente com a JRE via terminal


```bash
# Clone este repositório
$ git clone https://github.com/CassioLeodegario/product-ms

# Acesse a pasta do projeto no terminal/cmd
$ cd product-ms

# execute o comando mvnw clean package
$ ./mvnw clean package

# Acesse a pasta target
$ cd target

# Execute a aplicação com a JRE
$ java -jar product-ms-0.0.1-SNAPSHOT.jar

# O servidor inciará na porta:9999 - acesse http://localhost:9999
```

#### <a name="docker"></a>Utilizando o docker


```bash
# Clone este repositório
$ git clone https://github.com/CassioLeodegario/product-ms

# Acesse a pasta do projeto no terminal/cmd
$ cd product-ms

# Gere a imagem docker do projeto
$ docker build -t product-ms:v1 .

# Suba o container docker com a imagem gerada
$ docker run -p 9999:9999 --name product-ms product-ms:v1

# O servidor inciará na porta:9999 - acesse http://localhost:9999
```
