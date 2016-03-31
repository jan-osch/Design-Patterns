package pl.edu.uj;

public class Main {

    public static void main(String[] args) {
        // read command line arguments
        String arg = "";
        DataSorter dataSorter = new DataSorter(ArgumentParser.getNumberReaderByArgument(arg),
                ArgumentParser.getNumberSorterByArgument(arg),
                ArgumentParser.getNumberWriterByArgument(arg));
        dataSorter.sortData();
    }
}
