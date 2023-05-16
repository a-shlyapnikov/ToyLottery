package Controller;

import Model.LotteryLot;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LotteryReel {
    public ArrayList<LotteryLot> lotteryLot;

    public LotteryReel() throws IOException {
        this.lotteryLot = new ArrayList<>();
        File myFile = new File("LotteryReel.csv");
        FileWriter csvFile = new FileWriter(myFile);
        csvFile.close();
    }

    public void addLotteryLot(LotteryLot lotteryLot) throws IOException {

        this.lotteryLot.add(lotteryLot);

        CSVWriter writer = new CSVWriter(new FileWriter("LotteryReel.csv", true));
        String [] record = {Integer.toString(lotteryLot.getId()), lotteryLot.getToy().getName(),
                Integer.toString(lotteryLot.getQuantity()), Double.toString(lotteryLot.getLuck())};
        writer.writeNext(record);
        writer.close();
    }

    public void setLotLuck(){
        double size = 0.0;
        for (int i = 0; i < this.lotteryLot.size(); i++) {
            size = size + this.lotteryLot.get(i).getQuantity();
        }
        for (int i = 0; i < this.lotteryLot.size(); i++) {
            this.lotteryLot.get(i).setLuck(this.lotteryLot.get(i).getQuantity() / size);
        }
    }

    public void spinLotteryWheel() throws IOException {
        LotteryLot winLot = new LotteryLot();
        setLotLuck();
        Random random = new Random();
        double probability = random.nextDouble(1.0);
        for (int i = 0; i < this.lotteryLot.size(); i++) {
            if (probability < this.lotteryLot.get(i).getLuck()) {
                winLot.setId(this.lotteryLot.get(i).getId());
                winLot.setToy(this.lotteryLot.get(i).getToy());
                winLot.setQuantity(this.lotteryLot.get(i).getQuantity());
                winLot.setLuck(this.lotteryLot.get(i).getLuck());
                break;
            }
        }
        if (winLot.getLuck() == 1) {
            double myLuck = 0.0;
            for (int i = 0; i < this.lotteryLot.size(); i++) {
                if (this.lotteryLot.get(i).getLuck() > myLuck) {
                    myLuck = this.lotteryLot.get(i).getLuck();
                    winLot.setId(this.lotteryLot.get(i).getId());
                    winLot.setToy(this.lotteryLot.get(i).getToy());
                    winLot.setQuantity(this.lotteryLot.get(i).getQuantity());
                    winLot.setLuck(this.lotteryLot.get(i).getLuck());
                }
            }
        }
        for (int i = 0; i < this.lotteryLot.size(); i++) {
            if (winLot.getId() == this.lotteryLot.get(i).getId()) {
                this.lotteryLot.get(i).decreaseQuantity();
            }
        }
        CSVWriter writer = new CSVWriter(new FileWriter("LotteryReel.csv"));
        String [] record;
        for (int i = 0; i < this.lotteryLot.size(); i++) {
            record = new String[]{Integer.toString(this.lotteryLot.get(i).getId()), this.lotteryLot.get(i).getToy().getName(), Integer.toString(this.lotteryLot.get(i).getQuantity()), Double.toString(this.lotteryLot.get(i).getLuck())};
            writer.writeNext(record);
        }
        writer.close();
        CSVWriter winWriter = new CSVWriter(new FileWriter("WinLot.csv"));
        String [] winRecord = {winLot.getToy().getName()};
        winWriter.writeNext(winRecord);
        winWriter.close();
    }
}
