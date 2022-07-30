<h3>Faça o teu melhor, na codição que você tem, enquanto você não tem condições melhores, para fazer melhor ainda - Mario Sergio Cortella</h3>

---

# sp-mercantil-web-api
[DEMO] Estrutura de implementação de sistema com arquitetura hexagonal 

- [sp-mercantil-web-api](#sp-mercantil-web-api)
  - [Introdução](#introdução)
    - [Quarkus](#quarkus)
    - [Arquitetura Hexagonal](#arquitetura-hexagonal)
  - [Sobre a demostração](#sobre-a-demostração)

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

A cidade de São Paulo apresenta um grande número de feiras, para tal, é necessário, existir um controle sobre essas feiras. Logo o sistema deve ter um CRUD para controlar essas feiras. Para visualizar todas as regras de negocio, clique [aqui](./BDD.md) ou vá para o arquivo `BDD.md`.


