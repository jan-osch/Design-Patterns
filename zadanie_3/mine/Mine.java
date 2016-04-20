package mine;

import mine.fan.Fan;

import java.util.ArrayList;
import java.util.List;

public class Mine {
    private List<Fan> fansList;

    public Mine() {
        this.fansList = new ArrayList<>();
    }

    public void createFan() {
        this.fansList.add(new Fan());
    }

    public void startFan(int orderNumber) {
        Fan fan = this.fansList.get(orderNumber);
        try {
            fan.startFirstOilPompDriver();
            fan.startSecondOilPompDriver();
            fan.releaseTheBrakes();
            fan.turnOnMainPowerSwitch();
            fan.turnOnExcitationPowerSwitch();
            fan.turnOffExcitationPowerSwitch();
            if (fan.isRunning()) {
                System.out.println("Fan " + orderNumber + " now running\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopFan(int orderNumber) {
        Fan fan = this.fansList.get(orderNumber);
        try {
            fan.turnOffMainPowerSwitch();
            fan.turnOnTheBreak();
            fan.turnOffTheFirstOilPompDriver();
            fan.turnOffTheSecondOilPompDriver();
            if (!fan.isRunning()) {
                System.out.println("Fan " + orderNumber + " now stopped\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
