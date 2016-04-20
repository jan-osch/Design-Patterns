package mine.fan;

public class OilPompDriver extends StartStopDevice {

    static int numberOfOilPompDrivers = 0;
    private final int orderNumber;

    public OilPompDriver() {
        this.orderNumber = numberOfOilPompDrivers++;
    }

    public void start() {
        System.out.println("Starting the oil pomp number: " + this.orderNumber);
    }

    public void stop() {
        System.out.println("Stopping the oil pomp number: " + this.orderNumber);
    }
}
