# Requisitos Funcionais

Nesse documento estão descritos, todas as regras de negócio da solução

- [Requisitos Funcionais](#requisitos-funcionais)
  - [RF01 - Cadastro de uma nova feira](#rf01---cadastro-de-uma-nova-feira)
    - [Tabela I - Dados do domínio da API do `/market` feira](#tabela-i---dados-do-domínio-da-api-do-market-feira)
    - [Cenário I Cliente cadastra uma feira com sucesso](#cenário-i-cliente-cadastra-uma-feira-com-sucesso)
    - [Cenário II Cliente que faz cadastro de nova feira com registro já existente](#cenário-ii-cliente-que-faz-cadastro-de-nova-feira-com-registro-já-existente)
    - [Cenário III Cliente faz cadastro com informação de tipo do dados diferente do permitido](#cenário-iii-cliente-faz-cadastro-com-informação-de-tipo-do-dados-diferente-do-permitido)
    - [Cenário IV Cliente faz cadastro faltando campo](#cenário-iv-cliente-faz-cadastro-faltando-campo)
  - [RF02 - Exclusão de feiras pelo código de registro.](#rf02---exclusão-de-feiras-pelo-código-de-registro)
    - [Cenário V Cliente faz a exclusão da feira através do registro](#cenário-v-cliente-faz-a-exclusão-da-feira-através-do-registro)
    - [Cenário VI Cliente faz a exclusão da feira através do registro não cadastrado na base](#cenário-vi-cliente-faz-a-exclusão-da-feira-através-do-registro-não-cadastrado-na-base)
  - [RF03 - Alteração de feiras](#rf03---alteração-de-feiras)
    - [Cenário VII Cliente atualiza uma feira com sucesso](#cenário-vii-cliente-atualiza-uma-feira-com-sucesso)
    - [Cenário VIII Cliente altera uma feira que não foi cadastrada](#cenário-viii-cliente-altera-uma-feira-que-não-foi-cadastrada)
    - [Cenário IX Cliente altera com informação de tipo do dados diferente do permitido](#cenário-ix-cliente-altera-com-informação-de-tipo-do-dados-diferente-do-permitido)
    - [Cenário X Cliente altera o campo registro](#cenário-x-cliente-altera-o-campo-registro)
  - [RF04 - Filtro de Feiras](#rf04---filtro-de-feiras)
    - [Cenário XI Cliente busca informações sem nenhum campo de filtro](#cenário-xi-cliente-busca-informações-sem-nenhum-campo-de-filtro)
    - [Cenário XII Cliente busca informações com filtro de neighborhood e com resultado](#cenário-xii-cliente-busca-informações-com-filtro-de-neighborhood-e-com-resultado)
    - [Cenário XIII Cliente busca informações com filtro e após a última pagina](#cenário-xiii-cliente-busca-informações-com-filtro-e-após-a-última-pagina)

## RF01 - Cadastro de uma nova feira

Como um cliente operador autorizado com a permissão CRIAR_FEIRA, eu gostaria de cadastrar uma feira.

Em uma API, para que seja possível localizar e controlar todas as feiras na cidades de São Paulo,

e os dados devem ser validados, conforme a tabela abaixo.

### Tabela I - Dados do domínio da API do `/market` feira

| Variável     | Nome da variável                                | Descrição da variável                                                                | Fonte       | Tipo   | Tamanho |
| ------------ | ----------------------------------------------- | ------------------------------------------------------------------------------------ | ----------- | ------ | ------- |
| id           | Identificador                                   | Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo          | SMDU/Deinfo | string | 08      |
| longitude         | Longitude                                       | Longitude da localização do estabelecimento no território do Município, conforme MDC | SMDU/Deinfo | double | n/a     |
| latitude          | Latitude                                        | Latitude da localização do estabelecimento no território do Município, conforme MDC  | SMDU/Deinfo | double | n/a     |
| setcens      | Setor censitário                                | Setor censitário conforme IBGE                                                       | IBGE        | string | 15      |
| areap        | Área de ponderação                              | Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010           | IBGE        | string | 13      |
| coddist      | Código do distrito conforme IBGE                | Código do Distrito Municipal conforme IBGE                                           | IBGE        | string | 09      |
| district     | Distrito municipal                              | Nome do Distrito Municipal                                                           | SMDU/Deinfo | string | 18      |
| codsubpref   | Código da Subprefeitura                         | Código de cada uma das 31 Subprefeituras (2003 a 2012)                               | SMDU/Deinfo | string | 02      |
| subpref      | Subprefeitura                                   | Nome da Subprefeitura (31 de 2003 até 2012)                                          | SMDU/Deinfo | string | 25      |
| region5      | Região conforme divisão do Município em 5 áreas | Região conforme divisão do Município em 5 áreas                                      | SMDU/Deinfo | string | 06      |
| region8      | Região conforme divisão do Município em 8 áreas | Região conforme divisão do Município em 8 áreas                                      | SMDU/Deinfo | string | 07      |
| name         | Nome da feira livre                             | Denominação da feira livre atribuída pela Supervisão de Abastecimento                | SMSP/AB     | string | 30      |
| register     | Registro da feira livre                         | Número do registro da feira livre na PMSP                                            | SMSP/AB     | string | 6       |
| street       | Logradouro                                      | Nome do logradouro onde se localiza a feira livre                                    | SMSP/AB     | string | 34      |
| addrNumber   | Número                                          | Um número do logradouro onde se localiza a feira livre                               | SMSP/AB     | string | 5       |
| neighborhood | Bairro                                          | Bairro de localização da feira livre                                                 | SMSP/AB     | string | 20      |
| reference    | Ponto de referência                             | Ponto de referência da localização da feira livre                                    | SMSP/AB     | string | 24      |

### Cenário I Cliente cadastra uma feira com sucesso

**Dado** um cliente autenticado e autorizado com permissão de CRIAR_FEIRA

**Quando** Enviar para a API `POST /market` com o seguinte body

```json
{
  "id": "1",
  "longitude": -46.548146,
  "latitude": -23.568390,
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
  "longitude": -46.548146,
  "latitude": -23.568390,
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
  "longitude": "-46.548146", // <- Campo com o valor impróprio
  "latitude": -23.568390,
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

### Cenário IV Cliente faz cadastro faltando campo

**Dado** um cliente autenticado e autorizado com permissão de CRIAR_FEIRA

**Quando** envia para a API `POST /market` com o seguinte body

```json
{
  "id": "1",
  "longitude": "-46.548146", // <- Campo com o valor impróprio
  "latitude": -23.568390,
  "setcens": "355030885000019",
  "areap": "3550308005040",
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
  "message": "coddist is mandatory"
}
```

## RF02 - Exclusão de feiras pelo código de registro.

Como um cliente operador autorizado com a permissão EXCLUIR_FEIRA, eu gostaria de remover uma feira através de seu código de registro.

Em uma API, para que seja possível manter integra e atualizado as informações das feiras na cidades de São Paulo.

### Cenário V Cliente faz a exclusão da feira através do registro

**Dado** um cliente autenticado com a permissão EXCLUIR_FEIRA 
**E** feira com registro `7216-8` cadastrada na base de dados
**Quando** envia para a API `DELETE /market/7216-8`
**Então** a requisição deve retornar status code `200`

### Cenário VI Cliente faz a exclusão da feira através do registro não cadastrado na base

**Dado** um cliente autenticado com a permissão EXCLUIR_FEIRA 
**E** feira com registro `7216-8` **NÃO** cadastrada na base de dados
**Quando** envia para a API `DELETE /market/7216-8`
**Então** a requisição deve retornar status code `404`

## RF03 - Alteração de feiras

Como um cliente operador autorizado com a permissão ALTERAR_FEIRA, eu gostaria de alterar as informações de uma feira através de seu código de registro.

Em uma API, para que seja possível manter integra e atualizado as informações das feiras na cidades de São Paulo. Ressalta-se que não é permitido alterar o código de registro da feira.

A validação dos campos devem seguir a [Tabela I - Dados do domínio da API do `/market` feira](#tabela-i---dados-do-domínio-da-api-do-market-feira).

O único campo que não pode ser alterado é o campo de `register`.


### Cenário VII Cliente atualiza uma feira com sucesso

**Dado** um cliente autenticado e autorizado com permissão de ALTERAR_FEIRA

**E** com feira com registro `7216-8` cadastrada na base de dados

**Quando** Enviar para a API `PUT /market/7216-8` com o seguinte body

```json
{
  "street": "RUA TESTE 1"
}
```
**Então** a requisição deve retornar status code `200` com body
```json
{
  "id": "1",
  "longitude": -46.548146,
  "latitude": -23.568390,
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
  "street": "RUA TESTE 1",
  "addrNumber": "45",
  "neighborhood": "VILA FORMOSA",
  "reference": "PRAÃA  MARECHAL LEIT+O BANDEIRA"
}
```

### Cenário VIII Cliente altera uma feira que não foi cadastrada

**Dado** um cliente autenticado e autorizado com permissão de ALTERAR_FEIRA

**E** feira com registro `7216-8` **NÃO** esta cadastrada no banco de dados

**Quando** Enviar para a API `PUT /market/7216-8` com o seguinte body

```json
{
  "street": "RUA TESTE 1"
}
```

**Então** a requisição deve retornar status code `404`

### Cenário IX Cliente altera com informação de tipo do dados diferente do permitido

**Dado** um cliente autenticado e autorizado com permissão de ALTERAR_FEIRA

**Quando** envia para a API `PUT /market/7216-8` com o seguinte body

```json
{
  "longitude": "-46.548146", // <- Campo com o valor impróprio
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

### Cenário X Cliente altera o campo registro

**Dado** um cliente autenticado e autorizado com permissão de ALTERAR_FEIRA

**Quando** envia para a API `PUT /market/7216-8` com o seguinte body

```json
{
  "register": "7216-8"
}
```

**Então** a API vai ignorar o campo register
**E** a requisição deve retornar status code `200` com o seguinte body

```json
{
  "id": "1",
  "longitude": -46.548146,
  "latitude": -23.568390,
  "setcens": "355030885000019",
  "areap": "3550308005040",
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

## RF04 - Filtro de Feiras

Como um cliente operador autorizado com a permissão CONSULTAR_FEIRA, eu gostaria de buscar as informações de uma feira através do filtro abaixo.

| Variavel     | Tipo   | Tamanho | Descrição                                                             |
| ------------ | ------ | ------- | --------------------------------------------------------------------- |
| district     | string | 18      | Nome do Distrito Municipal                                            |
| region5      | string | 06      | Região conforme divisão do Município em 5 áreas                       |
| name         | string | 30      | Denominação da feira livre atribuída pela Supervisão de Abastecimento |
| neighborhood | string | 20      | Bairro de localização da feira livre                                  |

Em uma API, para que seja possível visualizar as informações das feiras na cidades de São Paulo. 

A Api deve retornar o resultado em formato paginado, com no máximo 10 elementos na pagina e tambem apresentar o valor total de registro que se aplicam no critério de filtro.

### Cenário XI Cliente busca informações sem nenhum campo de filtro

**Dado** um cliente autenticado e autorizado com permissão de CONSULTAR_FEIRA

**Quando** envia para a API `GET /market`
**Então** a requisição deve retornar status code `400` com o seguinte body

```json
{
  "code": "002",
  "type": "validation",
  "message": "No filter fields"
}
```

### Cenário XII Cliente busca informações com filtro de neighborhood e com resultado

**Dado** um cliente autenticado e autorizado com permissão de CONSULTAR_FEIRA

**Quando** envia para a API `GET /market?neighborhood=VILA FORMOSA`

**Então** a requisição deve retornar status code `200` com o seguinte body

```json
{
    "total": 25,
    "nextPage": "/market?neighborhood=VILA FORMOSA&offset=10&size=10",
    "data": [ {
        "id": "1",
        "longitude": -46.548146,
        "latitude": -23.568390,
        "setcens": "355030885000019",
        "areap": "3550308005040",
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
        ...
    ]
}
```

### Cenário XIII Cliente busca informações com filtro e após a última pagina

**Dado** um cliente autenticado e autorizado com permissão de CONSULTAR_FEIRA

**Quando** envia para a API `GET /market?neighborhood=VILA FORMOSA&offset=25`

**Então** a requisição deve retornar status code `200` com o seguinte body

```json
{
    "total": 25,
    "data": []
}
```