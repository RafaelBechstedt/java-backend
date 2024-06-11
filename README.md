# Agrix - Sistema de Gestão e Monitoramento de Fazendas

![Java](https://img.shields.io/badge/Java-17-brightgreen) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.1-brightgreen) ![MySQL](https://img.shields.io/badge/MySQL-blue) ![Docker](https://img.shields.io/badge/Docker-Blue)

Desenvolvi uma API REST em Java, utilizando o ecossistema Spring. Esta API utiliza Spring Data JPA para persistência em um banco de dados MySQL. A aplicação também está Dockerizada, facilitando a implantação e execução em diferentes ambientes.

## Database

### Esquema do Banco de Dados

O modelo de dados inclui as seguintes tabelas:

- **farm**: representa uma fazenda.
- **crop**: representa uma plantação e mantém um relacionamento 'many-to-one' com a tabela 'farm'.
- **fertilizer**: representa um fertilizante e mantém um relacionamento 'many-to-many' com a tabela 'crop' através da tabela **crop_fertilizer**.

![Tabelas](images/agrix-tabelas-fase-b.png)

## Instalação

### Executando a aplicação com Docker
- Certifique-se de  que o Docker está instalado na sua máquina.
- Construa a imagem Docker no seu terminal a partir do diretório do projeto:
```bash
docker compose up -d
```

### Instalando as dependências do projeto
- Para instalar as dependências do projeto, execute o seguinte comando:
```bash
mvn install -DskipTests
```

### Exemplos de Request e Response
<details>
  <summary>🔍 Exemplo de formato de request e response para a rota POST '/farms' para criar uma fazenda.</summary><br />
Request:
  
```json
{
  "name": "Capão Farm",
  "size": "5"
}
```
Response:

Status: 201 Created
```json
{
  "id": 1,
  "name": "Capão Farm",
  "size": 5.0
}
```
</details>
<details>
  <summary>🔍 Exemplo de formato de request e response para a rota GET '/farms' para retornar todas as fazendas.</summary><br />
Response:
Status: 200 OK
  
```json
[
  {
    "id": 1,
    "name": "RS Farm",
    "size": 5.0
  },
  {
    "id": 2,
    "name": "Imbé Farm",
    "size": 6.3
  }
]
```
</details>
<details>
  <summary>🔍 Exemplo de formato de request e response para a rota POST '/fertilizers' para criar um fertilizante.</summary><br />
Request:
  
```json
{
  "name": "NPK",
  "brand": "My Brand npk",
  "composition": "nitrogen, phosphorus and potassium."
}
```
Response:

Status: 201 Created

```json
{
  "id": 1,
  "name": "NPK",
  "brand": "My Brand npk",
  "composition": "nitrogen, phosphorus and potassium."
}
```
</details>

## Rodando Testes

Para executar todos os teste, utilize o seguinte comando:

```bash
mvn test
```

### Teste Específico

Para executar um teste específico, utilize o comando abaixo, substituindo 'TestClassName' pelo nome da classe de teste desejada:

```bash
mvn test -Dtest=TestClassName
```

## Análise de Código Estática

Utilizei Checkstyle para análise de código estática. Para executar o Checkstyle manualmente no projeto, execute o seguinte comando:

```bash
mvn checkstyle:check
```
