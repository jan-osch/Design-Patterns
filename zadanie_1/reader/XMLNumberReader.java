package reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLNumberReader implements NumberReader {
    private Pattern pattern = Pattern.compile("<value>([0-9.,]*)<\\/value>");

    @Override
    public List<Double> readData(String path) throws IOException {
        ArrayList<Double> numbers = new ArrayList<>();
        Files.lines(new File(path).toPath()).forEach((line) -> this.addParsedNumber(numbers, this.parseLine(line)));
        return numbers;
    }

    private void addParsedNumber(List<Double> numbers, Optional<Double> number) {
        if (number.isPresent()) {
            numbers.add(number.get());
        }
    }

    private Optional<Double> parseLine(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return Optional.of(new Double(matcher.group(1)));
        }
        return Optional.empty();
    }
}
