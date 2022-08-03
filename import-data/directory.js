const fs = require('fs');
const path = require('path');

const dirName = path.resolve(process.env['IMPORT_DIR'] || (__dirname + '/data'));


function loadAllCsvfiles(baseDir) {
    console.log("Directory: ", baseDir);
    return new Promise((resolve, reject) => {
        fs.readdir(baseDir, (err, filenames) => {
            if (err) {
                reject(err);
                return;
            }
            resolve(filenames.filter(f => path.extname(f) == '.csv').map(f => path.resolve(baseDir, f)));
        });
    })
}

module.exports = () => loadAllCsvfiles(dirName);