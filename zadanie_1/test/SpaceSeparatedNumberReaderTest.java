package test;

import org.junit.Test;
import reader.SpaceSeparatedNumberReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SpaceSeparatedNumberReaderTest {

    private final String testFile = "/Users/Janusz/Dysk Google/studia/WP/zadanie_1/data/ss_sample1.txt";

    @Test
    public void testWillReadFilesCorrectly() throws IOException {
        SpaceSeparatedNumberReader reader = new SpaceSeparatedNumberReader();
        Double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};

        List<Double> numberList = reader.readData(testFile);

        assertEquals(numberList.size(), 5);
        assertTrue(numberList.containsAll(Arrays.asList(numbers)));
    }
}
