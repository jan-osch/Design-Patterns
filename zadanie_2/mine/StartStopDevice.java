package mine;

public abstract class StartStopDevice {
    private boolean running;

    public StartStopDevice() {
        this.running = false;
    }

    abstract void start() throws AlreadyRunning;

    abstract void stop() throws AlreadyStopped;

    public boolean isRunning() {
        return this.running;
    }

    protected void setAsRunning() throws AlreadyRunning {
        if (this.isRunning()) {
            throw new AlreadyRunning();
        }
        this.running = true;
    }

    protected void setAsStopped() throws AlreadyStopped {
        if (!this.isRunning()) {
            throw new AlreadyStopped();
        }
        this.running = false;
    }
}
