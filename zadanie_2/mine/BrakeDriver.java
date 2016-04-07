package mine;

public class BrakeDriver extends StartStopDevice {

    @Override
    public void start() throws AlreadyRunning {
        System.out.println("Brake is being relesed");
        this.setAsRunning();
    }

    @Override
    public void stop() throws AlreadyStopped {
        System.out.println("Brake is being turned on");
        this.setAsStopped();
    }
}
