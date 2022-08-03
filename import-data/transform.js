const Validator = require('jsonschema').Validator;

const marketSchema = {
    "$schema": "https://json-schema.org/draft/2020-12/schema",
    "$id": "https://https://github.com/faustofjunqueira/sp-mercantil-web-api/product.schema.json",
    "title": "Market",
    "description": "Market description",
    "type": "object",
    "properties": {
        "ID": {
            "description": "Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo",
            "type": "string",
            "minLength": 1,
            "maxLength": 8
        },
        "LONG": {
            "description": "Longitude da localização do estabelecimento no território do Município, conforme MDC",
            "type": "string",
            "minLength": 1,
            "maxLength": 10
        },
        "LAT": {
            "description": "Latitude da localização do estabelecimento no território do Município, conforme MDC",
            "type": "string",
            "minLength": 1,
            "maxLength": 10
        },
        "SETCENS": {
            "description": "Setor censitário conforme IBGE",
            "type": "string",
            "minLength": 1,
            "maxLength": 15
        },
        "AREAP": {
            "description": "Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010",
            "type": "string",
            "minLength": 1,
            "maxLength": 13
        },
        "CODDIST": {
            "description": "Código do Distrito Municipal conforme IBGE",
            "type": "string",
            "minLength": 1,
            "maxLength": 9
        },
        "DISTRITO": {
            "description": "Nome do Distrito Municipal",
            "type": "string",
            "minLength": 1,
            "maxLength": 18
        },
        "CODSUBPREF": {
            "description": "Código de cada uma das 31 Subprefeituras (2003 a 2012)",
            "type": "string",
            "minLength": 1,
            "maxLength": 2
        },
        "SUBPREFE": {
            "description": "Nome da Subprefeitura (31 de 2003 até 2012)",
            "type": "string",
            "minLength": 1,
            "maxLength": 25
        },
        "REGIAO5": {
            "description": "Região conforme divisão do Município em 5 áreas",
            "type": "string",
            "minLength": 1,
            "maxLength": 6
        },
        "REGIAO8": {
            "description": "Região conforme divisão do Município em 8 áreas",
            "type": "string",
            "minLength": 1,
            "maxLength": 7
        },
        "NOME_FEIRA": {
            "description": "Denominação da feira livre atribuída pela Supervisão de Abastecimento",
            "type": "string",
            "minLength": 1,
            "maxLength": 30
        },
        "REGISTRO": {
            "description": "Número do registro da feira livre na PMSP",
            "type": "string",
            "minLength": 1,
            "maxLength": 6
        },
        "LOGRADOURO": {
            "description": "Nome do logradouro onde se localiza a feira livre",
            "type": "string",
            "minLength": 1,
            "maxLength": 34
        },
        "NUMERO": {
            "description": "Um número do logradouro onde se localiza a feira livre",
            "type": "string"
        },
        "BAIRRO": {
            "description": "Bairro de localização da feira livre",
            "type": "string",
            "maxLength": 20
        },
        "REFERENCIA": {
            "description": "Ponto de referência da localização da feira livre",
            "type": "string",
            "maxLength": 35
        }
    },
    "required": ["ID", "LONG", "LAT", "SETCENS", "AREAP", "CODDIST", "DISTRITO", "CODSUBPREF", "SUBPREFE", "REGIAO5", "REGIAO8", "NOME_FEIRA", "REGISTRO", "LOGRADOURO", "NUMERO", "BAIRRO", "REFERENCIA"]
}

function latLongToNumber(txt) {
    const pattern = /^(\-)?(\d\d)(\d+)/;
    const result = pattern.exec(txt);
    if(!result) {
        throw "Can not possible convert lat long";
    }
    const [,negSignal, integer, decimal] = result;
    return Number(`${negSignal}${integer}.${decimal}`);
}

module.exports = function row2market(row) {
    var v = new Validator();
    const validateResult = v.validate(row, marketSchema);
    if(!validateResult.valid) {
        console.error(validateResult);
        throw "Invalid row";
    }
    // transform 
    row['LONG'] = latLongToNumber(row['LONG']);
    row['LAT'] = latLongToNumber(row['LAT']);
    return row;
}
