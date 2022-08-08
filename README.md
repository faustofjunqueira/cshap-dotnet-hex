> *Faça o teu melhor, na codição que você tem, enquanto você não tem condições melhores, para fazer melhor ainda* - Mario Sergio Cortella

# sp-mercantil-web-api
[DEMO] Estrutura de implementação de sistema com arquitetura hexagonal 

Para ir diretamente para o material de suporte à avaliação e uso, veja o documento [Executando a Aplicação](docs/IT_Executando_Aplicacao.md)

- [sp-mercantil-web-api](#sp-mercantil-web-api)
  - [Introdução](#introdução)
    - [Arquitetura Hexagonal](#arquitetura-hexagonal)
  - [Demostração](#demostração)
  - [Execução](#execução)
  - [Tecnlogias](#tecnlogias)
    - [Requisitos Mínimos](#requisitos-mínimos)
  - [Banco de dados](#banco-de-dados)
    - [Databases](#databases)
    - [Usuários e Acesso](#usuários-e-acesso)
    - [Acessando o banco de dados](#acessando-o-banco-de-dados)

## Introdução

Esse projeto é para fins acadêmicos e, tem como objetivo, apresenta uma estrutura arquitetura hexagonal utilizando o framework ASP.NET Core.

### Arquitetura Hexagonal

Quando vamos desenvolver qualquer software, precisamos elaborar, inicialmente uma desenho arquitetural de nossa solução, dando ênfase em cada ponto da mesma. Desde a Arquitetura de execução, Arquitetura de Componentes, mas tambem a Arquitetura de Software. 

A Arquitetura Hexagonal é uma proposta para voce organizar sua aplicação, quando, principalmente, podemos estar inseridos no mundo de microserviços.

Abaixo, deixo uma referencia para um entendimento maior do modelo arquitetural.
[https://medium.com/tableless/desvendando-a-arquitetura-hexagonal-52c56f8824c](https://medium.com/tableless/desvendando-a-arquitetura-hexagonal-52c56f8824c). Esse artigo foi escrito por Lucas Trindade, em seu blogpost no medium.

## Demostração

Para facilitar a visualização do produto, é interessante apresentar um subconjunto de funcionalidades que a aplicação de demonstração deva atender.

Para melhor descrever os cenários de desenvolvimento e melhorar a implementação dos testes de aceitação, a documentação das RFs (requisitos funcionais), eles serão elaborados seguindo a estratégia do BDD (Behavior Driven Design), para melhorar a compreensão a Dev Media preparou esse artigo: [https://www.devmedia.com.br/desenvolvimento-orientado-por-comportamento-bdd/21127](https://www.devmedia.com.br/desenvolvimento-orientado-por-comportamento-bdd/21127).

Então, vamos para a cenário simulado.

A cidade de São Paulo apresenta um grande número de feiras, para tal, é necessário, existir um controle sobre essas feiras. Logo o sistema deve ter um CRUD para controlar essas feiras. Para visualizar todas as regras de negocio, clique [aqui](./docs/BDD.md) ou vá para o arquivo `docs/BDD.md`.

## Execução

Para executar a aplicação temos dois prismas, um demostração e desenvolvimento. A principal diferença entre eles é o docker-compose, que para desenvolvimento, instancia somente o banco de dados, enquanto para demonstração, irá instanciar o banco, popula-lo, construir a aplicação, verificar a qualidades do código, executar os testes e executar a aplicação, simulando um fluxo de CI/CD.

Para efetuar a execução da aplicação, siga o manual [Executando a Aplicação](./docs/IT_Executando_Aplicacao.md). Agora para seguir a instação para executação de desenvolvimento, então vá para [Desenvolvendo](./docs/IT_Desenvolvimento.md).


## Tecnlogias

As tecnologias adotadas para a execução dessa aplicação foram:

- .NET Core: Para o desenvolvimento da aplicação;
- ASP.NET Core: Framework de desenvolvimento de aplicações web;
- Docker: Para criação do ambiente de execução;
- Docker Compose: Para orquestração das aplicações;
- Node JS: Para desenvolvimento da aplicação de importação.

### Requisitos Mínimos

O sistema o foi desenvolvido em Windows, porem, com o advento do docker, não se limita à esse sistema.
Logo:

- **Docker** `>=20.10.8`
- **Docker Compose**  `1.29.2`
- **.NET Core** `5.0.11` - *Para desenvolvimento*

## Banco de dados

A aplicação utiliza o banco de MySQL na versao `8.0.30`.

Escolha dessa distribuição é em função de ser difundida pelo mundo e ser relacional, conforme solicitado.

A configuração do mysql, pode ser encontrada no [docker-compose.yaml](./docker-compose.yaml) e no arquivo [application.sql](db/application.sql).

### Databases

O sistema conta com a databases: SP_MERCANTIL, utilizado pela aplicação.

### Usuários e Acesso

Para esse exemplo, foram criado 2 usuários, fora o de root do `mysql`. 

| Usuário          | Database     | Propósito                                                  |
|------------------|--------------|------------------------------------------------------------|
| sp_mercantil_app | SP_MERCANTIL | Usado pela aplicação para executar tarefas na Aplicação    |
| sp_mercantil_sel | SP_MERCANTIL | Usado desenvolvedores acessar a base de dados da aplicação |

### Acessando o banco de dados

Para acessar o banco de dados, é necessário aguardar o docker-compose terminanr a sua inicialização e acesso o endereço

```txt
http://localhost:8081

host: db
usuario: sp_mercantil_sel
senha: UaSHtSUntirEftENUREofuzAR
base de dados: SP_MERCANTIL
```

Você acessará o banco de dados através do Adminer.

