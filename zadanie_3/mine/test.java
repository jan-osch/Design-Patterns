package mine;

public class test {
    public static void main(String[] args) {
        Mine mine = new Mine();
        mine.createFan();
        mine.createFan();
        mine.createFan();
        mine.createFan();
        mine.createFan();

        mine.startFan(0);
        mine.stopFan(0);
        mine.startFan(0);
        mine.stopFan(0);
        mine.startFan(3);
        mine.startFan(2);
        mine.stopFan(3);
        mine.stopFan(2);
        mine.startFan(0);
        mine.stopFan(0);
    }
}
