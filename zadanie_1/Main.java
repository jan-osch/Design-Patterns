import reader.NumberReader;
import sorter.NumberSorter;
import writer.NumberWriter;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        NumberReader reader = ArgumentParser.getNumberReaderByArgument(args[0]);
        NumberSorter sorter = ArgumentParser.getNumberSorterByArgument(args[1]);
        NumberWriter writer = ArgumentParser.getNumberWriterByArgument(args[2]);
        DataSorter dataSorter = new DataSorter(reader, sorter, writer);
        try {
            dataSorter.sortData(args[3], args[4]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
