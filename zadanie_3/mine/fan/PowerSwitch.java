package mine.fan;

public abstract class PowerSwitch extends StartStopDevice {

    private String name;

    public PowerSwitch(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println(this.name + " is being short-circuted ");
    }

    public void stop() {
        System.out.println(this.name + " is being opened");
    }
}
