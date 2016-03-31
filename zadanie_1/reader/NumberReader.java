package reader;

import java.io.IOException;
import java.util.List;

public interface NumberReader {
    List<Number> readData(String path) throws IOException;
}
