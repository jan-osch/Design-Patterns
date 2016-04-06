package writer;

import java.io.IOException;
import java.util.List;

public interface NumberWriter {
    void writeNumbers(List<Double> input, String path) throws IOException;
}
