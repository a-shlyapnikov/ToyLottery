package Controller;

import Model.LotteryLot;
import Model.Toy;

import java.io.IOException;

public class Lottery {
    public Lottery() {
    }
    public void start() throws IOException {

        LotteryReel myLotteryReel = new LotteryReel();

        myLotteryReel.addLotteryLot(new LotteryLot(1,new Toy("ball"),3));
        myLotteryReel.addLotteryLot(new LotteryLot(2,new Toy("monkey"),5));
        myLotteryReel.addLotteryLot(new LotteryLot(3,new Toy("car"),7));

        myLotteryReel.spinLotteryWheel();

    }

}
