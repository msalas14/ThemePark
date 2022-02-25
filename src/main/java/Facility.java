import java.util.ArrayList;

public class Facility {
    private String facilityName = "";
    private ArrayList<Product> products = new ArrayList<>();
    public Facility(String facilityName, ArrayList<Product> products)
    {
        this.facilityName = facilityName;
        this.products = products;
    }
    public void sell(Customer customer, Product product) {
        System.out.println(customer);//prior balance is printed
        customer.purchase(product.productPrice);
        System.out.println(customer.getName() + " bought " + product.productName + " from " + facilityName);
        System.out.println(customer);//after balance is printed
    }
    public Product getProduct(int index)
    {
        return products.get(index);
    }
}

