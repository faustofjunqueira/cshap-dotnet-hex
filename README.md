# sp-mercantil-web-api
[DEMO] Estrutura de implementação de sistema com arquitetura hexagonal 

- [sp-mercantil-web-api](#sp-mercantil-web-api)
  - [Introdução](#introdução)
    - [Quarkus](#quarkus)
    - [Arquitetura Hexagonal](#arquitetura-hexagonal)
  - [Sobre a demostração](#sobre-a-demostração)
    - [RF01 - Cadastro de uma nova feira](#rf01---cadastro-de-uma-nova-feira)
    - [RF02 - Exclusão de feiras pelo código de registro.](#rf02---exclusão-de-feiras-pelo-código-de-registro)
    - [RF03 - Alteração de feiras](#rf03---alteração-de-feiras)
    - [RF04 - Filtro de Feiras](#rf04---filtro-de-feiras)

## Introdução

Esse projeto é para fins acadêmicos e, tem como objetivo, apresenta uma estrutura arquitetura hexagonal utilizando o framework [Quarkus](https://quarkus.io/).

### Quarkus

O Quarkus é, atualmente, a prova que a comunidade Java ainda continua em constante evolução frente às novas necessidades e cenários apresentados pelo mercado.

No site oficial da plataforma, [https://quarkus.io/](https://quarkus.io/), temos uma mostra de como ele é altamente competitivo, quando comparado com outras plataformas.

### Arquitetura Hexagonal

Quando vamos desenvolver qualquer software, precisamos elaborar, inicialmente uma desenho arquitetural de nossa solução, dando ênfase em cada ponto da mesma. Desde a Arquitetura de execução, Arquitetura de Componentes, mas tambem a Arquitetura de Software. 

A Arquitetura Hexagonal é uma proposta para voce organizar sua aplicação, quando, principalmente, podemos estar inseridos no mundo de microserviços.

Abaixo, deixo uma referencia para um entendimento maior do modelo arquitetural.
[https://medium.com/tableless/desvendando-a-arquitetura-hexagonal-52c56f8824c](https://medium.com/tableless/desvendando-a-arquitetura-hexagonal-52c56f8824c). Esse artigo foi escrito por Lucas Trindade, em seu blogpost no medium.

## Sobre a demostração

Para facilitar a visualização do produto, é interessante apresentar um subconjunto de funcionalidades que a aplicação de demonstração deva atender.

Para melhor descrever os cenários de desenvolvimento e melhorar a implementação dos testes de aceitação, a documentação das RFs (requisitos funcionais), eles serão elaborados seguindo a estratégia do BDD (Behavior Driven Design), para melhorar a compreensão a Dev Media preparou esse artigo: [https://www.devmedia.com.br/desenvolvimento-orientado-por-comportamento-bdd/21127](https://www.devmedia.com.br/desenvolvimento-orientado-por-comportamento-bdd/21127).

Então, vamos para a cenário simulado.

A cidade de São Paulo apresenta um grande número de feiras, para tal, é necessário, existir um controle sobre essas feiras. Logo o sistema deve ter um CRUD para controlar essas feiras:

### RF01 - Cadastro de uma nova feira

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


**Story:** Cliente que faz cadastro de novas feiras.
Como um cliente operador, eu gostaria de cadastrar uma feira
em uma API, para que seja possível localizar e controlar todas as feiras na cidades de São Paulo

**Scenario:** Cliente cadastra uma feira com sucesso
**Given** um cliente autenticado e autorizado com permissão de CRIAR_FEIRA
**When** Enviar para a API `POST /market` com o seguinte body
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

### RF02 - Exclusão de feiras pelo código de registro.
### RF03 - Alteração de feiras
### RF04 - Filtro de Feiras
