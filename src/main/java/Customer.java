public class Customer {
    private String name = "";
    private double balance = 0;
    private boolean status = false;
    public Customer(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
    }
    public String getName()
    {
        return name;
    }
    public double getBalance()
    {
        return balance;
    }
    public void purchase(double price)
    {
        balance-=price;
    }
    public String toString()
    {
        return name + "'s balance: " + balance;
    }
    public void setStatus(boolean status)
    {
        this.status = status;
    }
}
