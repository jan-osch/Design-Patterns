import reader.NumberReader;
import reader.SpaceSeparatedNumberReader;
import reader.XMLNumberReader;
import sorter.InsertionSortNumberSorter;
import sorter.MergeSortNumberSorter;
import sorter.NumberSorter;
import writer.NumberWriter;
import writer.SpaceSeparatedNumberWriter;
import writer.XMLNumberWriter;

import java.util.Objects;

public class ArgumentParser {

    public static NumberWriter getNumberWriterByArgument(String argument) {
        if (Objects.equals(argument, "xml")) {
            return new XMLNumberWriter();
        } else if (Objects.equals(argument, "ss")) {
            return new SpaceSeparatedNumberWriter();
        }
        throw new RuntimeException("Invalid params");
    }

    public static NumberSorter getNumberSorterByArgument(String argument) {
        if (Objects.equals(argument, "is")) {
            return new InsertionSortNumberSorter();
        } else if (Objects.equals(argument, "ms")) {
            return new MergeSortNumberSorter();
        }
        throw new RuntimeException("Invalid params");
    }

    public static NumberReader getNumberReaderByArgument(String argument) {
        if (Objects.equals(argument, "xml")) {
            return new XMLNumberReader();
        } else if (Objects.equals(argument, "ms")) {
            return new SpaceSeparatedNumberReader();
        }
        throw new RuntimeException("Invalid params");
    }
}
