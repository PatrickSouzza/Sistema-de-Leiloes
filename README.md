# Sistema de Leilões 

Projeto acadêmico para Linguagem de Programação ll

## Documentação do Swagger

http://localhost:8080/swagger-ui/index.html#/

## Stack

* Java
* SpringBoot
* H2

## Como rodar

```shell script
mvn spring-boot:run
```

## Em caso de erros

```shell script
mvn clean
```

# ROTAS E REQUEST BODY


-------------------------------------------------------------------------

# USUÁRIO
### Listar todos os usuários
* ## <span style="color: blue;">GET</span>

### Endpoint: `localhost:8080/usuario`

-------------------------------------------------------------------------


### Listar usuário por ID
* ## <span style="color: BLUE;">GET</span>
### Endpoint: `localhost:8080/usuario/{id}`

-------------------------------------------------------------------------


### Criar um novo usuário
* ## <span style="color: GREEN;">POST</span>
### Endpoint: `localhost:8080/usuario`
```json
{
  "nome": "Patrick Gabriel de Souza",
  "cpf": "47799443348"
}
```
-------------------------------------------------------------------------


### Atualizar usuário
* ## <span style="color: yellow;">PUT</span>
### Endpoint: `localhost:8080/usuario/{id}`
```json
{
  "nome": "Patrick de Souza",
  "cpf": "47799443322"
}
```

### Deletar usuário
* ## <span style="color: RED;">DELETE</span>
### Endpoint: `localhost:8080/usuario/{id}`

-------------------------------------------------------------------------


# ENTIDADE FINANCEIRA
### Listar todas as entidade financeira

* ## <span style="color: BLUE;">GET</span>
### Endpoint: `localhost:8080/entidade`

-------------------------------------------------------------------------


### Listar entidade financeira por ID
* ## <span style="color: BLUE;">GET</span>
### Endpoint: `localhost:8080/entidade/{id}`

-------------------------------------------------------------------------


### Criar uma nova entidade financeira
* ## <span style="color: GREEN;">POST</span>

### Endpoint: `localhost:8080/entidade`

```json
{
  "nomeEntidade": "Santander",
  "cnpj": "00.000.000/0301-91"
}
```
-------------------------------------------------------------------------


### Atualizar entidade financeira
* * ## <span style="color: yellow;">PUT</span>

### Endpoint: `localhost:8080/entidade/{id}`
```json
{
  "nomeEntidade": "Santander",
  "cnpj": "00.000.000/0301-91"
}
```

-------------------------------------------------------------------------


### Deletar entidade financeira
* ## <span style="color: RED;">DELETE</span>

### Endpoint: `localhost:8080/entidade/{id}`

-------------------------------------------------------------------------


# LEILÃO
### Listar todos os leilões
* ## <span style="color: BLUE;">GET</span>

### Endpoint: `localhost:8080/leilao`

-------------------------------------------------------------------------


### Listar leilões por ID
* ## <span style="color: BLUE;">GET</span>

### Endpoint: `localhost:8080/leilao/{id}`

-------------------------------------------------------------------------

### Listar leilões ordenados por data de ocorrência
* ## <span style="color: BLUE;">GET</span>

### Endpoint: `localhost:8080/leilao/orderByDate`

### true para crescente / false para decrescente

-------------------------------------------------------------------------

### Criar novos leilões
* ## <span style="color: GREEN;">POST</span>
### Endpoint: `localhost:8080/leilao`
```json
{
  "nome": "Leilão de Eletrônicos",
  "entidadesFinanceiras": [
    {"id": 1}
  ],
  "dataInicio": "2024-10-01T10:00:00Z",
  "dataFim": "2027-10-10T18:00:00Z",
  "local": {
    "numero": 69,
    "rua": "Rua dos Encanadores",
    "cidade": "São José dos Campos",
    "estado": "SP"
  }
}
```
-------------------------------------------------------------------------



### Atualizar leilões
* ## <span style="color: yellow;">PUT</span>

### Endpoint: `localhost:8080/leilao/{id}`
```json
{
  "nome": "Leilão de Veiculos",
  "entidadesFinanceiras": [
    {"id": 1}
  ],
  "dataInicio": "2024-10-01T10:00:00Z",
  "dataFim": "2027-10-10T18:00:00Z",
  "local": {
    "numero": 15,
    "rua": "Rua dos Encanadores",
    "cidade": "São José dos Campos",
    "estado": "SP"
  }
}
```
-------------------------------------------------------------------------


### Deletar leilões
* ## <span style="color: RED;">DELETE</span>

### Endpoint: `localhost:8080/leilao/{id}`

-------------------------------------------------------------------------



# VEICULOS
### Listar todos os veiculos
* ## <span style="color: BLUE;">GET</span>


### Endpoint: `localhost:8080/veiculos`

-------------------------------------------------------------------------


### Listar veiculos por ID
* ## <span style="color: BLUE;">GET</span>


### Endpoint: `localhost:8080/veiculos/{id}`

-------------------------------------------------------------------------

### Criar um novo veiculo
* ## <span style="color: GREEN;">POST</span>

### Endpoint: `localhost:8080/veiculos`
```json
{
  "nomeProduto": "Corola 2022",
  "marca": "Toyota",
  "modelo": "Corola",
  "conservacao": "Ótimo",
  "cambio": "Automatico",
  "anoFabricacao": 2022,
  "quilometragem": 50000,
  "motor": "V8",
  "lanceInicial": 30000,
  "leilao": {"id": 1}
}
```
-------------------------------------------------------------------------


### Atualizar veiculos
* ## <span style="color: yellow;">PUT</span>

### Endpoint: `localhost:8080/veiculos/{id}`
```json
{
  "nomeProduto": "Corola 2023",
  "marca": "Toyota",
  "modelo": "Corola",
  "conservacao": "Ótimo",
  "cambio": "Automatico",
  "anoFabricacao": 2023,
  "quilometragem": 50000,
  "motor": "V8",
  "lanceInicial": 30000,
  "leilao": {"id": 1}
}
```
-------------------------------------------------------------------------


### Deletar veiculos
* ## <span style="color: RED;">DELETE</span>

### Endpoint: `localhost:8080/veiculos/{id}`

-------------------------------------------------------------------------


### Desassociar De Leilao
* ## <span style="color: YELLOW;">PUT</span>

### Endpoint: `localhost:8080/veiculos/{id}/leilao`
```json
{
  "id": 2
}
```

-------------------------------------------------------------------------

# REST - DISPOSITIVOS
### Listar todos os dispositivos
* ## <span style="color: BLUE;">GET</span>

### Endpoint: `localhost:8080/informatica`

-------------------------------------------------------------------------


### Listar dispositivos por ID
* ## <span style="color: BLUE;">GET</span>

### Endpoint: `localhost:8080/informatica/{id}`

-------------------------------------------------------------------------

### Criar um novo dispositivo
* ## <span style="color: GREEN;">POST</span>
### Endpoint: `localhost:8080/informatica`
```json
{
  "nomeProduto": "Iphone 13",
  "marca": "Apple",
  "modelo": "Iphone 13",
  "conservacao": "Ótimo",
  "especificacoesTecnicas": "IOS 18, 4GB RAM, saúde da bateria 90% ",
  "lanceInicial": 1000,
  "leilao": {"id": 1}
}
```
-------------------------------------------------------------------------

### Atualizar dispositivos
* ## <span style="color: yellow;">PUT</span>
### Endpoint: `localhost:8080/informatica/{id}`
```json
{
  "nomeProduto": "Iphone 15",
  "marca": "Apple",
  "modelo": "Iphone 15",
  "conservacao": "Novo",
  "especificacoesTecnicas": "IOS 18, 6GB RAM, saúde da bateria 100% ",
  "lanceInicial": 2000,
  "leilao": {"id": 1}
}
```
-------------------------------------------------------------------------

### Deletar dispositivos
* ## <span style="color: RED;">DELETE</span>
### Endpoint: `localhost:8080/informatica/{id}`

-------------------------------------------------------------------------

### Desassociar De Leilao

* ## <span style="color: GREEN;">POST</span>
### Endpoint: `localhost:8080/informatica/{id}/leilao`
```json
{
  "id": 2
}
```

-------------------------------------------------------------------------

### Novo Lance

* ## <span style="color: GREEN;">POST</span>
### Endpoint: `localhost:8080/lances`
```json
{
  "usuario": {
    "id": 1
  },
  "veiculo": {
    "id": 1
  },
  "valor": 31000.00
}
```

```json
{
  "usuario": {
    "id": 1
  },
  "informatica": {
    "id": 1
  },
  "valor": 5000.00
}

```
# Metodos de busca

* ## <span style="color: blue;">GET</span>

### Lances de um usuário
### Endpoint: `localhost:8080/usuario/{id}/lances` 

------------------------------------------------------------------
### Todos produtos de um leilão e total de produtos
### Endpoint: `localhost:8080/leilao/{leilaoId}/produtos` 

-----------------------------------------------------------------
### Todos detalhes de um leilão
### Endpoint: `localhost:8080/leilao/{id}/detalhes`

-----------------------------------------------------------------
### Filtro de veiculos o lance inicial (min < R$ < max), palavras chave
### Endpoint: `localhost:8080/leilao/veiculos`

-----------------------------------------------------------------
### Filtro de informatica o lance inicial (min < R$ < max), palavras chave
### Endpoint: `localhost:8080/leilao/informaticas` 

-----------------------------------------------------------------

### Todos os lances de um veiculo
### Endpoint: `localhost:8080/lances/veiculo/{veiculoId}`

-----------------------------------------------------------------
### Todos os lances de um dispositivo de informatica
### Endpoint: `localhost:8080/lances/informatica/{informaticaId}`

-----------------------------------------------------------------

# Exportar para .DET
### Endpoint: `localhost:8080/leilao/{leilaoId}/exportar`



