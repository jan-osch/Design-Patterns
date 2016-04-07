package mine;

public class OilPompDriver extends StartStopDevice {

    static int numberOfOilPompDrivers = 0;
    private final int orderNumber;

    public OilPompDriver() {
        this.orderNumber = numberOfOilPompDrivers++;
    }

    public void start() throws AlreadyRunning {
        System.out.println("Starting the oil pomp number: " + this.orderNumber);
        this.setAsRunning();
    }

    public void stop() throws AlreadyStopped {
        System.out.println("Stopping the oil pomp number: " + this.orderNumber);
        this.setAsStopped();
    }
}
