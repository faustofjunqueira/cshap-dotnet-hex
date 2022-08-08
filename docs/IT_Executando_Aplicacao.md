# Executando a Aplicação - Material para avaliação

Esse é o documento será utilizado como suporte ao avaliador.

## Ponderações iniciais
### Requisitos mínimos

- **Docker** `>=20.10.8`
- **Docker Compose**  `1.29.2`

### Estrutura de pastas do projeto

```txt
./docs            - Documentação do sofware
./import-data     - Aplicação de importação
./SpMercantil     - Aplicação Web
./volumes         - Volumes criado pelo docker compose
/.volumes/db      - Arquivos de inicialização do banco de dados
/.volumes/import  - Arquivos CSV que serão importados para a base
```

### Entregáveis

Após a aplicação executada, será possivel obter:

- Relatório de Cobertura de teste (HTML)
- Acesso aos logs
- Importação de arquivos CSV
- Aplicação com Swagger UI
- Aplicação para acessar o banco de dados

### Itens não entregues

Abaixo apresento os itens que não foram entregue na sua totalidade

- Tratamento de exceptions, por exemplo, criar resposta padrão para os cenários de exception.
- Testes de aceitação, por mais que tenhamos o BDD, não foi implementado os testes de aceitação automatizados
- Teste de Integração, nos testes unitários apresentei como seria a estratégia, tambem, para os testes de integração.
- Baixa cobertura de testes, a proposta foi apresentar o conceito e a tecnica, mas em função do tempo, não desenvolvi muito nesse cenário.

## Executando

1. Execute o docker-compose para subir todas aplicação
> Esse execução pode demorar um tempo demasiado (dependendo da rede e máquina), pois ela testa a aplicação, faz download dos pacotes e ainda sobe todos os serviços. Em caso de produto real, seriam feitos em processos separados de CI/CD. Aqui foi feito unificado para facilitar na avaliação.

```sh
docker-compose up -d
```

2. Acessando a aplicação

```sh
http://localhost:8080/swagger
```

3. Acessando o banco de dados

Acesse http://localhost:8081.

```txt
host: db
usuario: sp_mercantil_sel
senha: UaSHtSUntirEftENUREofuzAR
base de dados: SP_MERCANTIL
```

4. Obtendo os logs da aplicação

```sh
docker-compose logs -f app
```

5. Obtem relatórios

Os relatório ficam na pasta da aplicação, para isso faça uma cópia dos arquivos para fora do docker.

```sh
docker cp sp-mercantil-web-api_app_1:/app/coverage <PATH_DE_DESTINO>
```

Dentro da pasta extraída, voce tera deverá abrir o arquivo `<PATH_DE_DESTINO>/index.html` no seu browser favorito.


## Repositório

Gostaria de apresentar, que o projeto foi desenvolvido seguindo o Gitflow, até com a abertura de PR. Vale olhar o repositório.