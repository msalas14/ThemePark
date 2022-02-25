import java.util.ArrayList;

public class ThemePark {
    ArrayList<Customer> customers; // declares a customer array list to store the customers of the theme park
    ArrayList<Employee> employees; // declares an employee array list to store the employees of the theme park
    ArrayList<Ride> rides; // declares a ride array list to store the rides of the theme park
    ArrayList<Facility> facilities; // declares a facility array list to store the facilities of the theme park
    private String themeParkName = ""; // declare and initialize the name of the theme park to an empty string
    public ThemePark(String themeParkName) //constructor of the theme park
    {
        this.themeParkName = themeParkName; //the theme park name from this object is set to the theme park name from the parameter of the constructor
        customers = new ArrayList<>(); //customers array list is initialized
        employees = new ArrayList<>(); //employees array list is initialized
        rides = new ArrayList<>(); //rides array list is initialized
        facilities = new ArrayList<>(); //facilities array list is initialized
    }
    public String getThemeParkName()
    {
        return themeParkName; //return the name of the theme park
    }
    public void addCustomer(Customer newCustomer)
    {
        customers.add(newCustomer); //add a new customer to the themepark customers array list
    }
    public void addEmployee(Employee newEmployee)
    {
        employees.add(newEmployee); //add a new employee to the themepark employees array list
    }
    public void removeEmployee(int index)
    {
        employees.get(index).changeStatus("fired"); //"fire" the employee from a certain index of the employees list by changing the status
        employees.remove(index); //remove the employee from the theme park's employees array list
    }
    public void addRides(Ride newRide)
    {
        rides.add(newRide); //add a new ride to the themepark rides array list
    }
    public void addFacilities(Facility newFacility)
    {
        facilities.add(newFacility); //add a new facility to the themepark facilities array list
    }
    public String getRideNames()
    {
        String ridesStr = ""; //declare the string that will contain the names of the rides to return
        for(int i = 0; i<rides.size(); i++) // go through all the rides in the theme park's array list
        {
            ridesStr+= rides.get(i).getRideName(); //add each ride's name to the rides string
            if(i<rides.size()-1) // execute content for every element of the rides list except for the last ride
            {
                ridesStr += ", "; //seperate the ride's names with a comma
            }
        }
        return ridesStr; // return the string that contains the names of the rides
    }
    public String getEmployeeNames()
    {
        String emStr = ""; //declare the string that will contain the names of the employees to return
        for(int i = 0; i<employees.size(); i++)  // go through all the employees in the theme park's array list
        {
            emStr+= employees.get(i).getName(); //add each employee's name to the employees string
            if(i<employees.size()-1) // execute content for every element of the employees list except for the last employee
            {
                 emStr+= ", "; //seperate the employee's names with a comma
            }
        }
        return emStr; // return the string that contains the names of the employees
    }
    public int getTotalRides()
    {
        return rides.size(); //return the number of rides in this theme park which is the size of the rides array list
    }

}
