
-- 8WJlclJ$42mN*QbCED&N51!ZY

-- Base de dados da aplicação
CREATE DATABASE SP_MERCANTIL;

-- Criando usuário para a aplicação
CREATE USER 'sp_mercantil_app'@'%' IDENTIFIED BY 'd97e$6y8*5K63VJM7KhT!ySjR$';
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

-- KEYCLOAK

-- Base de dados do keycloak
CREATE DATABASE KEYCLOAK;
-- Criando usuário para o keycloak
CREATE USER 'keycloak_app'@'%' IDENTIFIED BY '8WJlclJ$42mN*QbCED&N51!ZY';
-- Concedendo permissão ao usuário
GRANT ALL PRIVILEGES ON KEYCLOAK.* TO 'keycloak_app'@'%';
