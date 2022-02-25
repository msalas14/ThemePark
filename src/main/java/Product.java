public class Product {
    private double productPrice = 0;
    private String productName = "";
    public Product(double productPrice, String productName)
    {
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public double getProductPrice()
    {
        return productPrice;
    }
    public String getProductName()
    {
        return productName;
    }
}
