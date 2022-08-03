# Desenvolvendo com Java / Quarkus / Docker

A aplicação foi construído sobre os pilares do Quarkus.

## Requisitos mínimos

- **Docker** `>=20.10.8`
- **Docker Compose**  `1.29.2`
- **Java** `>=11.0.12` - *Para desenvolvimento*
- **Maven** `>=3.8.4` - *Para desenvolvimento*

## Estrutura de pastas do projeto

```txt
./docs            - Documentação do sofware
./import-data     - Aplicação de importação
./spmercantil     - Aplicação Web
./volumes         - Volumes criado pelo docker compose
/.volumes/db      - Arquivos de inicialização do banco de dados
/.volumes/import  - Arquivos CSV que serão importados para a base
```


## Iniciando o ambiente

1. Vá para o diretório de desenvolvimento

```sh
cd ./spmercantil
``` 

1. Inicie o docker compose para termos acesso ao banco de dados e Adminer, para acessar o banco de dados.

```sh
docker-compose up -d
```

3. Para executar os testes da aplicação, invoque o maven

```sh
mvn test
```

No diretório `./target/jacoco-report` terá o report da cobertura de testes da aplicação

4. Para executar a aplicação, em desenvolvimento, faça

```sh
mvn quarkus:dev
```

Pronto, ao finalizar a inicialização, abra o browser e vá para `http://localhost:8080`