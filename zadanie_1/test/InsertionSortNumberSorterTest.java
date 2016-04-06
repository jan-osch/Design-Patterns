package test;

import org.junit.Before;
import org.junit.Test;
import sorter.InsertionSortNumberSorter;
import sorter.NumberSorter;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class InsertionSortNumberSorterTest {

    private NumberSorter instance;

    @Before
    public void initSorter() {
        instance = new InsertionSortNumberSorter();
    }

    @Test
    public void testWillSortCorrectlyEmptyData() {
        Double[] input = {};

        List<Double> sorted = instance.sortData(Arrays.asList(input));

        assertTrue(sorted.equals(Arrays.asList(input)));
    }

    @Test
    public void testWillOutputSortedDataUnchanged() {
        Double[] input = {1.0, 2.0, 3.0, 4.0};

        List<Double> sorted = instance.sortData(Arrays.asList(input));

        assertTrue(sorted.equals(Arrays.asList(input)));
    }

    @Test
    public void testWillSortSimpleCaseOfData() {
        Double[] input = {4.0, 2.0, 3.0, 1.0};
        Double[] expected = {1.0, 2.0, 3.0, 4.0};

        List<Double> sorted = instance.sortData(Arrays.asList(input));

        assertTrue(sorted.equals(Arrays.asList(expected)));
    }
}
