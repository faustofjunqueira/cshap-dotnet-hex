var { v4: uuidV4 } = require('uuid');
var mysql = require('mysql2');

function connect() {
    const connection = mysql.createConnection({
        host: process.env['DB_HOST'] || "localhost",
        port: Number(process.env['DB_PORT']) || 3306,
        user: process.env['DB_USER'] || "sp_mercantil_us",
        password: process.env['DB_PWD'] || "minhasenha",
        database: process.env['DB_DATABASE'] || 'SP_MERCANTIL'
    });

    return new Promise((res, rej) => {
        connection.connect(function (err) {
            if (err) {
                console.log("aqui!");
                return rej(err);
            }
            console.log("Connected!");
            res(connection);
        });
    });
}


function insertMarket(conn, market) {
    return new Promise((res, rej) => {
        conn.execute(
            'insert into market(pkId, id, longitude, latitude, setcens, areap, coddist, district, codsubpref, subpref, region5, region8, name, register, street, addrNumber, neighborhood, reference, createdAt, deletedAt, updatedAt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)',
            [uuidV4(),
            market.ID,
            market.LONG,
            market.LAT,
            market.SETCENS,
            market.AREAP,
            market.CODDIST,
            market.DISTRITO,
            market.CODSUBPREF,
            market.SUBPREFE,
            market.REGIAO5,
            market.REGIAO8,
            market.NOME_FEIRA,
            market.REGISTRO,
            market.LOGRADOURO,
            market.NUMERO,
            market.BAIRRO,
            market.REFERENCIA,
            new Date(),
                null,
            new Date()
            ],
            function (err, results, fields) {
                if (err) {
                    return rej(err);
                }
                res();
            }
        );

    });
}

function updateMarket(conn, market) {
    return new Promise((res, rej) => {
        conn.execute(
            'update market set id=?, longitude=?, latitude=?, setcens=?, areap=?, coddist=?, district=?, codsubpref=?, subpref=?, region5=?, region8=?, name=?, street=?, addrNumber=?, neighborhood=?, reference=?, updatedAt=? where register = ?',
            [
                market.ID,
                market.LONG,
                market.LAT,
                market.SETCENS,
                market.AREAP,
                market.CODDIST,
                market.DISTRITO,
                market.CODSUBPREF,
                market.SUBPREFE,
                market.REGIAO5,
                market.REGIAO8,
                market.NOME_FEIRA,
                market.LOGRADOURO,
                market.NUMERO,
                market.BAIRRO,
                market.REFERENCIA,
                new Date(),
                market.REGISTRO,
            ],
            function (err, results, fields) {
                if (err) {
                    return rej(err);
                }
                res();
            }
        );
    });
}

function getMarketByRegister(conn, register) {
    return new Promise((res, rej) => {
        conn.execute(
            'select * from market where register = ?',
            [register],
            function (err, results, fields) {
                if (err) {
                    return rej(err);
                }
                res(results);
            }
        );
    });
}

async function importMarket(conn, market) {
    const marketSaved = await getMarketByRegister(conn, market.REGISTRO);
    if (marketSaved && marketSaved.length) {
        await updateMarket(conn, market);
    } else {
        await insertMarket(conn, market);
    }
}


module.exports = {
    connect,
    importMarket
};


