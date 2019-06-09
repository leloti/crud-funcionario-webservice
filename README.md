# CrudFuncionarioWebService

Este projeto foi desenvolvido utilizando as seguintes tecnologias:
Java 8 (SDK 1.8)
Spring Boot v2.1.4
Spring Data v2.1.4
H2 Database Engine.

O projeto foi desenvolvido para atender aos requisitos solicitados via email.
Foram criados os endpoints:
-> POST /funcionario para cadastrar um novo funcionario.
-> GET /funcionarios para listar todos os funcionários.
-> GET /funcionario/{id} para listar os dados de determinado funcionário.
-> PUT /funcionario/{id} para editar um funcionário.
-> DELETE /funcionario/{id} para deletar um funcionário.


## Development server

Este projeto pode ser executado rodando o comando `java -jar .\target\crud-funcionario-webservice-0.0.1-SNAPSHOT.jar` após acessar o diretório raiz do projeto.
