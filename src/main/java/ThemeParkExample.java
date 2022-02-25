import java.util.ArrayList;

public class ThemeParkExample {
    public static void main(String[] args) {

        ThemePark kingsIsland = new ThemePark("Kings Island"); //declare and initialize a new theme park object named kings island

        kingsIsland.addCustomer(new Customer("ally", 100)); //add new customer to the kingsIsland theme park
        kingsIsland.addCustomer(new Customer("emily", 200)); //add new customer to the kingsIsland theme park

        kingsIsland.addEmployee(new Employee("jackson", "McDonalds")); //add new employee to the kingsIsland theme park
        kingsIsland.addEmployee(new Employee("elly", "Diamondback")); //add new employee to the kingsIsland theme park
        System.out.println("*\n*");

        kingsIsland.addRides(new Ride("Diamondback")); //add new ride to the kingsIsland theme park
        kingsIsland.addRides(new Ride("Pirate's ship")); //add new ride to the kingsIsland theme park
        kingsIsland.addRides(new Ride("X")); //add new ride to the kingsIsland theme park

        ArrayList<Product> mDproducts  = new ArrayList<>(); // declare and initialize a products array for a facility

        mDproducts.add(new Product(5, "Happy Meal")); //add new product to its corresponding products arraylist
        mDproducts.add(new Product(1.25, "McChicken")); //add new product to its corresponding products arraylist
        kingsIsland.addFacilities(new Facility("McDonalds",mDproducts) ); //add new facility to the kingsIsland theme park named McDonalds with its corresponding products array list

        ArrayList<Product> bKProducts  = new ArrayList<>(); // declare and initialize a products array for a facility
        bKProducts.add(new Product(8.5, "Whopper")); //add new product to its corresponding products arraylist
        bKProducts.add(new Product(1.25, "ChKing")); //add new product to its corresponding products arraylist
        kingsIsland.addFacilities(new Facility("Burger King", bKProducts)); //add new facility to the kingsIsland theme park named Burger King with its corresponding products array list

        System.out.println("rides at " + kingsIsland.getThemeParkName() +": "+ kingsIsland.getRideNames() + "\n*\n*"); // print the names from the park


        /*
        *   below uses the methods from each class to perform the actions from the instructions
        *   but this is done randomly
        *   you can manually call the methods by calling the theme park object, then the desired array list,
        *   and choose an index from the array list to represent a customer, employee, or ride
        *   after specifying the object you can call the methods
         */
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
        kingsIsland.removeEmployee(randomChoice); // remove employee at randomChoice index
        kingsIsland.addEmployee(new Employee("anna", "McDonalds")); // new employee is hired

        System.out.println("current employees: " + kingsIsland.getEmployeeNames()); // get and print the list (in string form) of current employees from the kingsIsland theme park
        System.out.println("*");
        System.out.println("total rides: " + kingsIsland.getTotalRides()); // get and print the number of rides from the kingsIsland theme park


    }
}
