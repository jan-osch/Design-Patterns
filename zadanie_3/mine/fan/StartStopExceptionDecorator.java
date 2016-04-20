package mine.fan;

import mine.exceptions.AlreadyRunning;
import mine.exceptions.AlreadyStopped;

public class StartStopExceptionDecorator extends StartStopDevice {

    private StartStopDevice instance;
    private boolean isRunning;

    public StartStopExceptionDecorator(StartStopDevice instance) {
        this.instance = instance;
        this.isRunning = false;
    }

    @Override
    void start() throws AlreadyRunning {
        if (isRunning) {
            throw new AlreadyRunning();
        }
        this.instance.start();
        this.isRunning = true;
    }

    @Override
    void stop() throws AlreadyStopped {
        if (!isRunning) {
            throw new AlreadyStopped();
        }
        this.instance.stop();
        this.isRunning = false;
    }
}
