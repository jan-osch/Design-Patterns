import reader.NumberReader;
import sorter.NumberSorter;
import writer.NumberWriter;

import java.io.IOException;
import java.util.List;

public class DataSorter {
    private NumberReader numberReader;
    private NumberSorter numberSorter;
    private NumberWriter numberWriter;

    public DataSorter(NumberReader numberReader, NumberSorter numberSorter, NumberWriter numberWriter) {
        this.numberReader = numberReader;
        this.numberSorter = numberSorter;
        this.numberWriter = numberWriter;
    }

    public void sortData(String fromPath, String toPath) throws IOException {
        List<Double> doubleList = this.numberReader.readData(fromPath);
        List<Double> sortedData = this.numberSorter.sortData(doubleList);
        this.numberWriter.writeNumbers(sortedData, toPath);
    }
}
