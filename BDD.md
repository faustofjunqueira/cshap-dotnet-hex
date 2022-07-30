# Requisitos Funcionais

Nesse documento estão descritos, todas as regras de negócio da solução

- [Requisitos Funcionais](#requisitos-funcionais)
  - [RF01 - Cadastro de uma nova feira](#rf01---cadastro-de-uma-nova-feira)
    - [Cenário I Cliente cadastra uma feira com sucesso](#cenário-i-cliente-cadastra-uma-feira-com-sucesso)
    - [Cenário II Cliente que faz cadastro de nova feira com registro já existente](#cenário-ii-cliente-que-faz-cadastro-de-nova-feira-com-registro-já-existente)
    - [Cenário III Cliente faz cadastro com informação de tipo do dados diferente do permitido](#cenário-iii-cliente-faz-cadastro-com-informação-de-tipo-do-dados-diferente-do-permitido)
  - [RF02 - Exclusão de feiras pelo código de registro.](#rf02---exclusão-de-feiras-pelo-código-de-registro)
  - [RF03 - Alteração de feiras](#rf03---alteração-de-feiras)
  - [RF04 - Filtro de Feiras](#rf04---filtro-de-feiras)

## RF01 - Cadastro de uma nova feira

Como um cliente operador autorizado com a permissão CRIAR_FEIRA, eu gostaria de cadastrar uma feira.

Em uma API, para que seja possível localizar e controlar todas as feiras na cidades de São Paulo,

e os dados devem ser validados, conforme a tabela abaixo.

Dados do domínio da API do `/market` feira:

| Variável | Nome da variável | Descrição da variável | Fonte | Tipo | Tamanho |
|----------|------------------|-----------------------|-------|------|---------|
| id | Identificador | Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo | SMDU/Deinfo | string | 08 |
| long | Longitude | Longitude da localização do estabelecimento no território do Município, conforme MDC | SMDU/Deinfo | double | n/a |
| lat | Latitude | Latitude da localização do estabelecimento no território do Município, conforme MDC | SMDU/Deinfo | double | n/a |
| setcens | Setor censitário | Setor censitário conforme IBGE | IBGE | string | 15 |
| areap | Área de ponderação | Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010 | IBGE | string | 13 |
| coddist | Código do distrito conforme IBGE | Código do Distrito Municipal conforme IBGE | IBGE | string | 09 |
| district | Distrito municipal | Nome do Distrito Municipal | SMDU/Deinfo | string | 18 |
| codsubpref | Código da Subprefeitura | Código de cada uma das 31 Subprefeituras (2003 a 2012) | SMDU/Deinfo | string | 02 |
| subpref | Subprefeitura | Nome da Subprefeitura (31 de 2003 até 2012) | SMDU/Deinfo | string | 25 |
| region5 | Região conforme divisão do Município em 5 áreas | Região conforme divisão do Município em 5 áreas | SMDU/Deinfo | string | 06 |
| region8 | Região conforme divisão do Município em 8 áreas | Região conforme divisão do Município em 8 áreas | SMDU/Deinfo | string | 07 |
| name | Nome da feira livre | Denominação da feira livre atribuída pela Supervisão de Abastecimento | SMSP/AB | string | 30 |
| register | Registro da feira livre | Número do registro da feira livre na PMSP | SMSP/AB | string | 6 |
| street | Logradouro | Nome do logradouro onde se localiza a feira livre | SMSP/AB | string | 34 |
| addrNumber | Número | Um número do logradouro onde se localiza a feira livre | SMSP/AB | string | 5 |
| neighborhood | Bairro | Bairro de localização da feira livre | SMSP/AB | string | 20 |
| reference | Ponto de referência | Ponto de referência da localização da feira livre | SMSP/AB | string | 24 |


### Cenário I Cliente cadastra uma feira com sucesso

**Dado** um cliente autenticado e autorizado com permissão de CRIAR_FEIRA

**Quando** Enviar para a API `POST /market` com o seguinte body

```json
{
  "id": "1",
  "long": -46.548146,
  "lat": -23.568390,
  "setcens": "355030885000019",
  "areap": "3550308005040",
  "coddist": "87",
  "district": "VILA FORMOSA",
  "codsubpref": "26",
  "subpref": "ARICANDUVA",
  "region5": "Leste",
  "region8": "Leste 1",
  "name": "PRAÃA LE+O X",
  "register": "7216-8",
  "street": "RUA CODAJ-S",
  "addrNumber": "45",
  "neighborhood": "VILA FORMOSA",
  "reference": "PRAÃA  MARECHAL LEIT+O BANDEIRA"
}
```
**Então** a requisição deve retornar status code `201` com body
```json
{
  "register": "7216-8",
}
```

### Cenário II Cliente que faz cadastro de nova feira com registro já existente

**Dado** um cliente autenticado e autorizado com permissão de CRIAR_FEIRA

**E** com feira já cadastrada com registro `7216-8`

**Quando** Enviar para a API `POST /market` com o seguinte body

```json
{
  "id": "1",
  "long": -46.548146,
  "lat": -23.568390,
  "setcens": "355030885000019",
  "areap": "3550308005040",
  "coddist": "87",
  "district": "VILA FORMOSA",
  "codsubpref": "26",
  "subpref": "ARICANDUVA",
  "region5": "Leste",
  "region8": "Leste 1",
  "name": "PRAÃA LE+O X",
  "register": "7216-8",
  "street": "RUA CODAJ-S",
  "addrNumber": "45",
  "neighborhood": "VILA FORMOSA",
  "reference": "PRAÃA  MARECHAL LEIT+O BANDEIRA"
}
```

**Então** a requisição deve retornar status code `400` com body

```json
{
  "code": "001",
  "type": "business",
  "message": "Register already found"
}
```

### Cenário III Cliente faz cadastro com informação de tipo do dados diferente do permitido

**Dado** um cliente autenticado e autorizado com permissão de CRIAR_FEIRA

**Quando** envia para a API `POST /market` com o seguinte body

```json
{
  "id": "1",
  "long": "-46.548146", // <- Campo com o valor impróprio
  "lat": -23.568390,
  "setcens": "355030885000019",
  "areap": "3550308005040",
  "coddist": "87",
  "district": "VILA FORMOSA",
  "codsubpref": "26",
  "subpref": "ARICANDUVA",
  "region5": "Leste",
  "region8": "Leste 1",
  "name": "PRAÃA LE+O X",
  "register": "7216-8",
  "street": "RUA CODAJ-S",
  "addrNumber": "45",
  "neighborhood": "VILA FORMOSA",
  "reference": "PRAÃA  MARECHAL LEIT+O BANDEIRA"
}
```

**Então** a requisição deve retornar status code `400` com o seguinte body

```json
{
  "code": "000",
  "type": "validation",
  "message": "long is not double"
}
```



## RF02 - Exclusão de feiras pelo código de registro.
## RF03 - Alteração de feiras
## RF04 - Filtro de Feiras
