package mine.fan;

import mine.exceptions.InvalidSequence;

public class Fan {
    private StartStopDevice firstOilPompDriver;
    private StartStopDevice secondOilPompDriver;
    private StartStopDevice brakeDriver;
    private StartStopDevice excitationPowerSwitch;
    private StartStopDevice mainPowerSwitch;
    private int sequenceState;
    private int numberOfStates;

    public Fan() {
        this.sequenceState = 0;
        this.numberOfStates = 10;
        this.firstOilPompDriver = FanPartsFactory.getNewOilPompDriver();
        this.secondOilPompDriver = FanPartsFactory.getNewOilPompDriver();
        this.excitationPowerSwitch = FanPartsFactory.getExcitationPowerSwitch();
        this.mainPowerSwitch = FanPartsFactory.getMainPowerSwitch();
        this.brakeDriver = FanPartsFactory.getNewBrakeDriver();
    }

    public int getSequenceState() {
        return sequenceState % this.numberOfStates;
    }

    public void startFirstOilPompDriver() throws InvalidSequence {
        this.checkSequenceStateAndIncrement(0, 1);
        this.firstOilPompDriver.start();
    }

    public void startSecondOilPompDriver() throws InvalidSequence {
        this.checkSequenceStateAndIncrement(0, 1);
        this.secondOilPompDriver.start();
    }

    public void releaseTheBrakes() throws InvalidSequence {
        this.checkSequenceStateAndIncrement(2);
        this.brakeDriver.start();
    }

    public void turnOnMainPowerSwitch() throws InvalidSequence {
        this.checkSequenceStateAndIncrement(3);
        this.mainPowerSwitch.start();
    }

    public void turnOnExcitationPowerSwitch() throws InvalidSequence {
        this.checkSequenceStateAndIncrement(4);
        this.excitationPowerSwitch.start();
    }

    public void turnOffExcitationPowerSwitch() throws InvalidSequence {
        this.checkSequenceStateAndIncrement(5);
        this.excitationPowerSwitch.stop();
    }

    public boolean isRunning() {
        return this.getSequenceState() == 6;
    }

    public boolean isStopped() {
        return this.getSequenceState() == 10;
    }

    public void turnOffMainPowerSwitch() throws InvalidSequence {
        this.checkSequenceStateAndIncrement(6);
        this.mainPowerSwitch.stop();
    }

    public void turnOnTheBreak() throws InvalidSequence {
        this.checkSequenceStateAndIncrement(7);
        this.brakeDriver.stop();
    }

    public void turnOffTheFirstOilPompDriver() throws InvalidSequence {
        this.checkSequenceStateAndIncrement(8, 9);
        this.firstOilPompDriver.stop();
    }

    public void turnOffTheSecondOilPompDriver() throws InvalidSequence {
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
