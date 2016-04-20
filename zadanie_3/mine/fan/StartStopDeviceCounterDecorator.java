package mine.fan;

public class StartStopDeviceCounterDecorator extends StartStopDevice {

    private StartStopDevice instance;
    private int callCounter;

    public StartStopDeviceCounterDecorator(StartStopDevice instance) {
        this.instance = instance;
        this.callCounter = 0;
    }

    @Override
    void start() {
        this.incrementCallCounterAndPrintInfoAboutCalls();
        this.instance.start();
    }

    private void incrementCallCounterAndPrintInfoAboutCalls() {
        this.callCounter++;
        System.out.format("Device state change counter: %d ", this.callCounter);
    }

    @Override
    void stop() {
        this.incrementCallCounterAndPrintInfoAboutCalls();
        this.instance.stop();
    }
}
