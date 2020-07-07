# Projeto Candidaturas

O objetivo deste projeto tem apenas para avaliar o grau de conhecimento, domínio e desenvolvimento do candidato em questão. O projeto Candidaturas é um projeto simples e prático proposto pela empresa FourSales, que busca conhecer um pouco mais das aptidões técnicas através deste. 


## Construído com

* 	[Maven](https://maven.apache.org/) - Gerenciador de Dependências
* 	[JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit - Versão 8
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework utilizado facilitar e agilizar as Aplicações Springs
* 	[H2](http://www.h2database.com/html/download.html) - Banco de Dados Relacional, **está incluso no JDK**
* 	[git](https://git-scm.com/) - Sistema de Controle de Versões, Open-Source
* 	[Lombok](https://projectlombok.org/) - Projeto usado para agilizar o desenvolvimento tirando a necessidade de escrever getters, setters ou equals
* 	[Swagger](https://swagger.io/) - Framework Open-Source utilizado em larga escala para ajudar desenvolvedores a elaborar o design, a construção, a documentação, e o consumo RESTful Web services

## Ferramenta Externa Usada

* [Postman](https://www.getpostman.com/) - Ambiente de Desenvolvimento de Testes e Documentação
* [Astah Community](https://astah.net/products/astah-community/) - Ambiente de Desenvolmento de Diagramas UML

## To-Do

- [x] REST API (CRUD)
- [ ] JUnit (Test)
- [ ] Mockito (Test)
- [x] Swagger
- [x] UML
- [ ] Security (Basic Authentication)
- [ ] Docker



## Executando o projeto localmente

- Faça o download the zip or clone o Git repositório
- Descompacte o arquivo zip (caso você tenha realizado o download)
- Abra o prompt de comando ou o Terminal/Shell e mude o diretório através do comando (cd) para a pasta que contenha o arquivo **pom.xml**
- Abra o Eclipse / STS / IntelliJ / outros
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you descompacte o arquivo zip
   - Selecione o projeto
- Por fim, para executar: 
	- Selecione o Spring Boot Application em *Run as* 

Alternativamente se pode usar o  [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) no terminal como a seguir:

```shell
mvn spring-boot:run
```

### URLs

	Usuário

|  URL |  Method | 
|----------|--------------|
|`http://localhost:8080/api/v1/usuarios`	|GET
|`http://localhost:8080/api/v1/usuarios`	|POST
|`http://localhost:8080/api/v1/usuarios/{id}`	|PUT                       
|`http://localhost:8080/api/v1/usuarios/{id}`   | DELETE |
|`http://localhost:8080/api/v1/usuarios/{id}`   | GET |

##
	Cartão de Crédito

|  URL |  Method | 
|----------|--------------|
|`http://localhost:8080/api/v1/cartoes`	|GET
|`http://localhost:8080/api/v1/cartoes`	|POST
|`http://localhost:8080/api/v1/cartoes/{id}`	|PUT                       
|`http://localhost:8080/api/v1/cartoes/{id}`   | DELETE |
|`http://localhost:8080/api/v1/cartoes/{id}`   | GET |

##
	Candidato

|  URL |  Method | 
|----------|--------------|
|`http://localhost:8080/api/v1/candidatos`	|GET
|`http://localhost:8080/api/v1/candidatos`	|POST
|`http://localhost:8080/api/v1/candidatos/{id}`	|PUT                       
|`http://localhost:8080/api/v1/candidatos/{id}`   | DELETE |
|`http://localhost:8080/api/v1/candidatos/{id}`   | GET |


## Documentation

* [Postman Collection](https://www.getpostman.com/collections/18aa0b386ab87381d9e9) - online, formato json
* [Postman Collection](https://github.com/gilton/candidaturas/tree/master/postman) - offline, formato txt
* [Diagrama de Caso de Uso](https://github.com/gilton/candidaturas/blob/master/diagrams/UseCase0.png) - abstração versão 02.01
* [Diagrama de Classe](https://github.com/gilton/candidaturas/blob/master/diagrams/classDiagram.png) - abstração versão 02.00
* [Swagger](http://localhost:8080/swagger-ui.html) - `http://localhost:8080/swagger-ui.html`- Documentação e Testes 




