const fs = require('fs');
const csv = require('fast-csv');
const loadFiles = require('./directory');
const row2market = require('./transform');

function parseFile(filename) {
    return new Promise((resolve,reject) => {

        const allRows = [];

        fs.createReadStream(filename)
            .pipe(csv.parse({ headers: true }))
            .on('error', error => {
                reject(error)
            })
            .on('data', row => {
                row2market(row);
                allRows.push(row)
            })
            .on('end', rowCount => {
                console.log(`Parsed ${filename}: ${rowCount} rows`);
                resolve(allRows);
            });
    })
}

async function parseAllFiles() {
    const allFiles = await loadFiles();
    if (!allFiles.length) {
        console.log("No files found");
        return;
    }
    let allRows = [];
    for(let f of allFiles) {
        const rows = await parseFile(f);
        allRows = [...allRows, ...rows];
    }
    return allRows;
}

module.exports = parseAllFiles;