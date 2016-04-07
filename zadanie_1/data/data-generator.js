var fs = require('fs');

var style,
    elements,
    elementsInLine,
    fileName;

if (process.argv.length == 5) {
    style = 'ss';
    elements = parseInt(process.argv[2]);
    elementsInLine = parseInt(process.argv[3]);
    fileName = process.argv[4];
} else {
    style = 'xml';
    elements = parseInt(process.argv[2]);
    fileName = process.argv[3];
}

function generateRandomNumber(upperLimit) {
    return Math.floor(Math.random() * upperLimit);
}

var writeStream = fs.createWriteStream(fileName);

var elementsSoFar = 0;
var wroteElement = false;

var finishLine = function () {
    writeStream.write('\n');
    wroteElement = false;
    elementsSoFar = 0;
};

if (style === 'ss') {
    while (elements > 0) {
        elements--;
        elementsSoFar++;
        if (wroteElement) {
            writeStream.write(' ');
        }
        writeStream.write(generateRandomNumber(elements).toString());
        wroteElement = true;
        if (elementsSoFar == elementsInLine) {
            finishLine();
        }
    }
} else if (style === 'xml') {
    while (elements > 0) {
        elements--;
        writeStream.write('<value>' + generateRandomNumber(elements).toString() + '</value>\n');
    }
}

writeStream.end();
