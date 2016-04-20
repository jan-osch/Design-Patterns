package mine.fan;

public class FanPartsFactory {

    public static StartStopDevice getNewOilPompDriver() {
        return new StartStopExceptionDecorator(new StartStopDeviceCounterDecorator(new OilPompDriver()));
    }

    public static StartStopDevice getExcitationPowerSwitch() {
        return new StartStopExceptionDecorator(new StartStopDeviceCounterDecorator(new ExcitationPowerSwitch()));
    }

    public static StartStopDevice getMainPowerSwitch() {
        return new StartStopExceptionDecorator(new StartStopDeviceCounterDecorator(new MainPowerSwitch()));
    }


    public static StartStopDevice getNewBrakeDriver() {
        return new StartStopExceptionDecorator(new StartStopDeviceCounterDecorator(new BrakeDriver()));
    }
}
