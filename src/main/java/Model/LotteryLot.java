package Model;

public class LotteryLot {
    private int id;
    private Toy toy;
    private int quantity;
    private double luck;


    public LotteryLot(int id, Toy toy, int quantity) {
        this.id = id;
        this.toy = toy;
        this.quantity = quantity;
    }

    public LotteryLot() {
        this.setLuck(1.0);
    }

    public void decreaseQuantity(){
        this.setQuantity(this.getQuantity() - 1);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }
}
