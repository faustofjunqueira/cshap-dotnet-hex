# Desenvolvendo 

A aplicação foi construído sobre os pilares do Quarkus.

## Requisitos mínimos

- **Docker** `>=20.10.8`
- **Docker Compose**  `1.29.2`
- **.NET Core** `5.0.11` - *Para desenvolvimento*
- 
## Estrutura de pastas do projeto

```txt
./docs            - Documentação do sofware
./import-data     - Aplicação de importação
./SpMercantil     - Aplicação Web
./volumes         - Volumes criado pelo docker compose
/.volumes/db      - Arquivos de inicialização do banco de dados
/.volumes/import  - Arquivos CSV que serão importados para a base
```


## Iniciando o ambiente

1. Vá para o diretório de desenvolvimento

```sh
cd ./SpMercantil
``` 

1. Inicie o docker compose para termos acesso ao banco de dados e Adminer, para acessar o banco de dados.

```sh
docker-compose up -d
```

3. Para executar os testes da aplicação, invoque o maven

```sh
cd Test
dotnet test
```

4. Para executar a aplicação, em desenvolvimento, faça

```sh
cd Application
dotnet run
```

Pronto, ao finalizar a inicialização, abra o browser e vá para `https://localhost:5001/swagger`