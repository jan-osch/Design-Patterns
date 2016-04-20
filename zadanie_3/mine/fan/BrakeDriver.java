package mine.fan;

public class BrakeDriver extends StartStopDevice {

    @Override
    public void start() {
        System.out.println("Brake is being relesed");
    }

    @Override
    public void stop() {
        System.out.println("Brake is being turned on");
    }
}
