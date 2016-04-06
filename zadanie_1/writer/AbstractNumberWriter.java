package writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AbstractNumberWriter {
    protected Path openFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path))
            Files.createFile(path);
        return path;
    }
}
