package reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpaceSeparatedNumberReader implements NumberReader {

    @Override
    public List<Number> readData(String path) throws IOException {
        ArrayList<Number> numbers = new ArrayList<>();
        Files.lines(Paths.get(path)).forEach(line -> parseLine(numbers, line));
        return numbers;
    }

    private void parseLine(List list, String line) {
        Arrays.stream(line.split(" "))
                .filter(s -> !s.isEmpty())
                .forEach(s -> list.add(new Float(s)));
    }
}
