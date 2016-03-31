import reader.NumberReader;
import sorter.NumberSorter;
import writer.NumberWriter;

public class DataSorter {
    private NumberReader numberReader;
    private NumberSorter numberSorter;
    private NumberWriter numberWriter;

    public DataSorter(NumberReader numberReader, NumberSorter numberSorter, NumberWriter numberWriter) {
        this.numberReader = numberReader;
        this.numberSorter = numberSorter;
        this.numberWriter = numberWriter;
    }

    public void sortData() {

    }
}
