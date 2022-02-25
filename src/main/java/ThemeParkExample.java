import java.util.ArrayList;

public class ThemeParkExample {
    public static void main(String[] args) {

        ThemePark kingsIsland = new ThemePark("Kings Island");

        kingsIsland.addCustomer(new Customer("ally", 100));
        kingsIsland.addCustomer(new Customer("emily", 200));

        kingsIsland.addEmployee(new Employee("jackson", "McDonalds"));
        kingsIsland.addEmployee(new Employee("elly", "Diamondback"));
        System.out.println("*\n*");

        kingsIsland.addRides(new Ride("Diamondback"));
        kingsIsland.addRides(new Ride("Pirate's ship"));
        kingsIsland.addRides(new Ride("X"));

        ArrayList<Product> mDproducts  = new ArrayList<>();

        mDproducts.add(new Product(5, "Happy Meal"));
        mDproducts.add(new Product(1.25, "McChicken"));
        kingsIsland.addFacilities(new Facility("McDonalds",mDproducts) );

        ArrayList<Product> bKProducts  = new ArrayList<>();
        bKProducts.add(new Product(8.5, "Whopper"));
        bKProducts.add(new Product(1.25, "ChKing"));
        kingsIsland.addFacilities(new Facility("Burger King", bKProducts));

        System.out.println("rides at " + kingsIsland.getThemeParkName() +": "+ kingsIsland.getRideNames() + "\n*\n*");

        int randomChoice = 0, otherRandomChoice = 0;
        for(int i = 0; i<2;i++)
        {
            //options for customers are to ride, which ride, buy from facilities, which facility
            randomChoice = (int) (Math.random()*2);
            Customer currentCustomer = kingsIsland.customers.get(i);
            if(randomChoice == 0)
            {
                otherRandomChoice = (int) (Math.random()*2);
                System.out.println(kingsIsland.rides.get(otherRandomChoice).riding(currentCustomer));
            }
            else
            {
                otherRandomChoice = (int)(Math.random()*2);
                randomChoice = (int)(Math.random()*2);
                Facility currentFacility = kingsIsland.facilities.get(otherRandomChoice);
                currentFacility.sell(currentCustomer,currentFacility.getProduct(randomChoice));
            }
            System.out.println("*");
        }


        randomChoice = (int) (Math.random()*kingsIsland.employees.size());
        kingsIsland.removeEmployee(randomChoice); // update employees list
        kingsIsland.addEmployee(new Employee("anna", "McDonalds")); // new employee is hired

        System.out.println("current employees: " + kingsIsland.getEmployeeNames()); // get list of current employees
        System.out.println("*");
        System.out.println("total rides: " + kingsIsland.getTotalRides());


    }
}
