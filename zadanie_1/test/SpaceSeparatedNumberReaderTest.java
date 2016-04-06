package test;

import org.junit.Test;
import reader.SpaceSeparatedNumberReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SpaceSeparatedNumberReaderTest {

    @Test
    public void testWillReadFilesCorrectly() throws IOException {
        SpaceSeparatedNumberReader reader = new SpaceSeparatedNumberReader();
        Number[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};

        List<Number> numberList = reader.readData("/Users/Janusz/Dysk Google/studia/WP/zadanie_1/test/ss_sample1.txt");

        assertEquals(numberList.size(), 5);
        assertTrue(numberList.containsAll(Arrays.asList(numbers)));
    }
}
