package test;

import org.junit.Test;
import reader.XMLNumberReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class XMLNumberReaderTest {

    private final String testFile = "/Users/Janusz/Dysk Google/studia/WP/zadanie_1/data/xml_sample1.txt";

    @Test
    public void testWillReadFilesCorrectly() throws IOException {
        XMLNumberReader reader = new XMLNumberReader();
        Double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};

        List<Double> numberList = reader.readData(testFile);

        assertEquals(numberList.size(), 5);
        assertTrue(numberList.containsAll(Arrays.asList(numbers)));
    }
}
