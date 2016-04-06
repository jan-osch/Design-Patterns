package sorter;

import java.util.Collections;
import java.util.List;

public class InsertionSortNumberSorter implements NumberSorter {

    @Override
    public List<Double> sortData(List<Double> input) {
        int j;
        Double current;
        for (int i = 1; i < input.size(); i++) {
            j = i - 1;
            current = input.get(i);
            while ((j >= 0) && input.get(j).compareTo(current) > 0) {
                Collections.swap(input, j + 1, j);
                j--;
            }
        }
        return input;
    }
}
