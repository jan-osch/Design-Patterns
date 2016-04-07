package writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SpaceSeparatedNumberWriter extends AbstractNumberWriter implements NumberWriter {

    private static final int NUMBER_OF_ELEMENTS_IN_LINE = 10;
    private StringBuilder currentLine;
    private int numbersInCurrentLine;
    private boolean wroteLine;
    private BufferedWriter writer;

    @Override
    public void writeNumbers(List<Double> input, String filePath) throws IOException {
        Path path = openFile(filePath);
        initializeHelpers();
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            this.writer = writer;
            for (Double x : input)
                writeSingleNumber(x);
        }
    }

    private void initializeHelpers() {
        this.currentLine = new StringBuilder();
        this.numbersInCurrentLine = 0;
        this.wroteLine = false;
    }

    private void writeSingleNumber(Double number) throws IOException {
        addNumberToCurrentLine(number);
        this.numbersInCurrentLine++;
        if (this.numbersInCurrentLine == NUMBER_OF_ELEMENTS_IN_LINE) {
            this.numbersInCurrentLine = 0;
            this.writeCurrentLine();
        }
    }

    private void writeCurrentLine() throws IOException {
        if (this.wroteLine) {
            this.writer.newLine();
            this.wroteLine = true;
        }
        this.writer.write(this.currentLine.toString());

    }

    private void addNumberToCurrentLine(Double x) {
        if (this.numbersInCurrentLine > 0) {
            currentLine.append(" ");
        }
        currentLine.append(x);
    }

}
