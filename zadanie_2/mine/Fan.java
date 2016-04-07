package mine;

public class Fan {
    static int numberOfFans = 0;
    private int orderNumber;
    private OilPompDriver firstOilPompDriver;
    private OilPompDriver secondOilPompDriver;
    private BrakeDriver brakeDriver;
    private ExcitationPowerSwitch excitationPowerSwitch;
    private MainPowerSwitch mainPowerSwtich;
    private int sequenceState;
    private int numberOfStates;

    public Fan() {
        this.orderNumber = numberOfFans++;
        this.sequenceState = 0;
        this.numberOfStates = 10;
        this.firstOilPompDriver = new OilPompDriver();
        this.secondOilPompDriver = new OilPompDriver();
        this.excitationPowerSwitch = new ExcitationPowerSwitch();
        this.mainPowerSwtich = new MainPowerSwitch();
        this.brakeDriver = new BrakeDriver();
    }

    public int getSequenceState() {
        return sequenceState % this.numberOfStates;
    }

    public void startFirstOilPompDriver() throws InvalidSequence, AlreadyRunning {
        this.checkSequenceStateAndIncrement(0, 1);
        this.firstOilPompDriver.start();
    }

    public void startSecondOilPompDriver() throws InvalidSequence, AlreadyRunning {
        this.checkSequenceStateAndIncrement(0, 1);
        this.secondOilPompDriver.start();
    }

    public void releaseTheBrakes() throws InvalidSequence, AlreadyRunning {
        this.checkSequenceStateAndIncrement(2);
        this.brakeDriver.start();
    }

    public void turnOnMainPowerSwitch() throws InvalidSequence, AlreadyRunning {
        this.checkSequenceStateAndIncrement(3);
        this.mainPowerSwtich.start();
    }

    public void turnOnExcitationPowerSwitch() throws InvalidSequence, AlreadyRunning {
        this.checkSequenceStateAndIncrement(4);
        this.excitationPowerSwitch.start();
    }

    public void turnOffExcitationPowerSwitch() throws InvalidSequence, AlreadyStopped {
        this.checkSequenceStateAndIncrement(5);
        this.excitationPowerSwitch.stop();
    }

    public boolean isRunning() {
        return this.getSequenceState() == 6;
    }

    public boolean isStopped() {
        return this.getSequenceState() == 10;
    }

    public void turnOffMainPowerSwitch() throws AlreadyStopped, InvalidSequence {
        this.checkSequenceStateAndIncrement(6);
        this.mainPowerSwtich.stop();
    }

    public void turnOnTheBreak() throws AlreadyStopped, InvalidSequence {
        this.checkSequenceStateAndIncrement(7);
        this.brakeDriver.stop();
    }

    public void turnOffTheFirstOilPompDriver() throws AlreadyStopped, InvalidSequence {
        this.checkSequenceStateAndIncrement(8, 9);
        this.firstOilPompDriver.stop();
    }

    public void turnOffTheSecondOilPompDriver() throws InvalidSequence, AlreadyStopped {
        this.checkSequenceStateAndIncrement(8, 9);
        this.secondOilPompDriver.stop();
    }

    private void checkSequenceStateAndIncrement(int... validPreviousStates) throws InvalidSequence {
        for (int previousState : validPreviousStates) {
            if (previousState == this.getSequenceState()) {
                this.sequenceState++;
                return;
            }
        }
        throw new InvalidSequence();
    }
}
