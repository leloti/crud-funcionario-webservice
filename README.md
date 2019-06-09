# CrudFuncionarioWebService

Este projeto foi desenvolvido utilizando as seguintes tecnologias:
- Java 8 (SDK 1.8)
- Maven 3.5.4
- Spring Boot v2.1.4
- Spring Data v2.1.4
- H2 Database

O projeto foi desenvolvido para atender aos requisitos solicitados via email.

## Banco de dados

O banco de dados é criado em memória é inicializando toda vez que o projeto é executado. A cada inicialização são criados 100 novos registros aleatórios na tabela de FUNCIONARIOS.
A tabela contém os campos:
- id Integer (PK)
- nome String
- sobrenome String
- email String
- numeroPis String

Pode ser alterada a quantidade de funcionários gerados alterando o arquivo "Aplicacao.java" na linha 34. 

## Web Service

O webservice foi desenvolvido utilizando o Spring Boot, e contém os endpoints:
- POST /funcionario para cadastrar um novo funcionario.
- GET /funcionarios para listar todos os funcionários.
- GET /funcionario/{id} para listar os dados de determinado funcionário.
- PUT /funcionario/{id} para editar um funcionário.
- DELETE /funcionario/{id} para deletar um funcionário.

Caso ocorra algum erro na execução do endpoint, o mesmo retornará com o Status HTTP 400 (Bad Request) ou HTTP 404 (Not Found) e uma mensagem de erro informando o motivo.
Em caso de sucesso, será retornado o Status HTTP 200 e objeto solicitado:
- POST /funcionario: Retorna um objeto de funcionário com os dados do funcionário cadastrado.
- GET /funcionarios: Retorna uma lista com todos os funcionários cadastrados.
- GET /funcionario/{id}: Retorna um objeto de funcionário com os dados do funcionário pesquisado.
- PUT /funcionario/{id}: Retorna um objeto de funcionário com os dados do funcionário alterado.
- DELETE /funcionario/{id}: não possui retorno.

## Arquitetura

A arquitetura utilizada para este projeto seguindo o padrão:

```Request > Service > BusinessObject (BO) > DTO to Entity ou Entity to DTO > Repositorio > Database```

- Service: Classe tem a finalidade de receber os request com os parâmetros e encaminhar ao BusinessObject.
- BusinessObject (BO): Classe que contém as regras de negócio, validações e chamadas ao repositório.
- Data Transfer Object (DTO): Objeto de manipulação de dados de entrada e retorno em tempo de execução. Este objeto é originado inicialmente a partir da entidade, mas pode receber novos campos. 
- Repositório: Classe de acesso ao banco de dados. Nele são criados os métodos necessários para cadastrar, consultar, editar e deletar registros do banco de dados. 

## Development server

O projeto pode ser executado por linha de comando,  rodando o comando `java -jar .\target\crud-funcionario-webservice-0.0.1-SNAPSHOT.jar` após acessar o diretório raiz do projeto.

