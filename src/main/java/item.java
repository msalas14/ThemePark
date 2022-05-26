public class item {
    private String name;
    private double price;
    private int amnt, smth;
    public item(String name, double price, int amnt, int smth)
    {
        this.name = name;
        this.price = price;
        this.amnt = amnt;
        this.smth = smth;
    }
    public String toString()
    {
        return "\'" + name + "\'," + price + "," + amnt + "," + smth;
    }
}
