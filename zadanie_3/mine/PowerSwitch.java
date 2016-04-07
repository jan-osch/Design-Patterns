package mine;

public abstract class PowerSwitch extends StartStopDevice {

    private String name;

    public PowerSwitch(String name) {
        this.name = name;
    }

    public void start() throws AlreadyRunning {
        System.out.println(this.name + " is being short-circuted ");
        this.setAsRunning();
    }

    public void stop() throws AlreadyStopped {
        System.out.println(this.name + " is being opened");
        this.setAsStopped();
    }
}
