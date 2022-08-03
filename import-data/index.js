const parseAllFiles = require('./parse');

const {
    connect, importMarket
} = require('./db');

async function doImport() {
    try {
        const dbConn = await connect();
        const allMarket = await parseAllFiles();
        for (let market of allMarket) {
            await importMarket(dbConn, market);
        }
        console.log("Done!");
        process.exit(0);
    } catch (err) {
        console.error("Error", err)
        process.exit(-1);
    }
}

doImport().then(() => console.log("."));