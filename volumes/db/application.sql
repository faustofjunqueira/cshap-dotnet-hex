
-- 8WJlclJ$42mN*QbCED&N51!ZY

-- Base de dados da aplicação
CREATE DATABASE SP_MERCANTIL;

-- Criando usuário para a aplicação
CREATE USER 'sp_mercantil_app'@'%' IDENTIFIED BY 'laNtatEPIlentAtRUCKOdi';
-- Criando usuário para consultar o banco de dados
CREATE USER 'sp_mercantil_sel'@'%' IDENTIFIED BY 'UaSHtSUntirEftENUREofuzAR';

-- Concedendo permissão ao usuário de aplicação
GRANT CREATE ON SP_MERCANTIL.* TO 'sp_mercantil_app'@'%';
GRANT DELETE ON SP_MERCANTIL.* TO 'sp_mercantil_app'@'%';
GRANT INSERT ON SP_MERCANTIL.* TO 'sp_mercantil_app'@'%';
GRANT SELECT ON SP_MERCANTIL.* TO 'sp_mercantil_app'@'%';
GRANT UPDATE ON SP_MERCANTIL.* TO 'sp_mercantil_app'@'%';

-- Concedendo permissão ao usuário de consulto
GRANT SELECT ON SP_MERCANTIL.* TO 'sp_mercantil_sel'@'%';


USE SP_MERCANTIL;

create table market
(
    pkId         varchar(36)  not null primary key,
    addrNumber   varchar(255) null,
    areap        varchar(255) null,
    coddist      varchar(255) null,
    codsubpref   varchar(255) null,
    district     varchar(255) null,
    id           varchar(255) null,
    latitude     double       null,
    longitude    double       null,
    name         varchar(255) null,
    neighborhood varchar(255) null,
    reference    varchar(255) null,
    region5      varchar(255) null,
    region8      varchar(255) null,
    register     varchar(255) null,
    setcens      varchar(255) null,
    street       varchar(255) null,
    subpref      varchar(255) null,
    createdAt    datetime(6)  null,
    deletedAt    datetime(6)  null,
    updatedAt    datetime(6)  null,
    constraint UK_cllak6kuno06rhim6ktj16xwj
        unique (id),
    constraint UK_j4b9kqj8dd136jxgsne0fjga9
        unique (register)
);

-- Created index
CREATE INDEX IDX_MKT_REGISTER ON market(register);