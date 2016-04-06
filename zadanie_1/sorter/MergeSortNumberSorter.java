package sorter;

import java.util.Collections;
import java.util.List;

public class MergeSortNumberSorter implements NumberSorter {
    @Override
    public List<Double> sortData(List<Double> input) {
        Collections.sort(input);
        return input;
    }
}
