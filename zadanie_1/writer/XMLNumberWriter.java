package writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class XMLNumberWriter extends AbstractNumberWriter implements NumberWriter {

    private BufferedWriter writer;
    private boolean wroteLine;

    @Override
    public void writeNumbers(List<Double> input, String path) throws IOException {
        Path file = openFile(path);
        this.wroteLine = false;
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file)) {
            this.writer = bufferedWriter;
            for (Double number : input) {
                writeSingleNumber(number);
            }
        }
    }

    private void writeSingleNumber(Double number) throws IOException {
        if (wroteLine) {
            writer.newLine();
            wroteLine = true;
        }
        writer.write(String.format("<value>%1$,.2f</value>", number));
    }
}
