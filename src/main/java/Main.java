import Controller.Lottery;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Lottery myLottery = new Lottery();
        myLottery.start();
    }
}
