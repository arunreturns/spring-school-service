var NEW_SERVICE = "Student"

var MAIN_PATH = "./";
var COPY_SERVICE = "Teacher"
var shell = require('shelljs');

var ncp = require('ncp').ncp;
var recursive = require('recursive-readdir');
ncp.limit = 16;
const exec = require('child_process').exec;
ncp(MAIN_PATH + COPY_SERVICE.toLowerCase(), MAIN_PATH + NEW_SERVICE.toLowerCase(), function (err) {
    if (err) {
        return console.error(err);
    }


    recursive(MAIN_PATH + NEW_SERVICE.toLowerCase(), function (err, files) {
        if (err) {
            throw err;
        }
        // Files is an array of filename
        console.log(files);
        files.map((file) => {
            console.log("Working on file", file);
            console.log("Renaming " + COPY_SERVICE + " to " + NEW_SERVICE);
            var sedCmd = 'sed -i -e "s/' + COPY_SERVICE + '/' + NEW_SERVICE + '/g" ' +
                '-e "s/' + COPY_SERVICE.toLowerCase() + '/' + NEW_SERVICE.toLowerCase() + '/g" ' +
                '-e "s/' + COPY_SERVICE.toUpperCase() + '/' + NEW_SERVICE.toUpperCase() + '/g" ' + file;

            console.log("SED CMD", sedCmd);
            exec(sedCmd, function (error, stdout, stderr) {
                if (stderr) {
                    console.log(stderr);
                    return;
                }
                console.log("OUTPUT: ", stdout);
                var newFile = file.replace(COPY_SERVICE, NEW_SERVICE)
                shell.mv(file, newFile);
            });

        })
    });
});
