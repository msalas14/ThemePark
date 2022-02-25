import java.util.ArrayList;

public class ThemePark {
    ArrayList<Customer> customers;
    ArrayList<Employee> employees;
    ArrayList<Ride> rides;
    ArrayList<Facility> facilities;
    private String themeParkName = "";
    public ThemePark(String themeParkName)
    {
        this.themeParkName = themeParkName;
        customers = new ArrayList<>();
        employees = new ArrayList<>();
        rides = new ArrayList<>();
        facilities = new ArrayList<>();
    }
    public String getThemeParkName()
    {
        return themeParkName;
    }
    public void addCustomer(Customer newCustomer)
    {
        customers.add(newCustomer);
    }
    public void addEmployee(Employee newEmployee)
    {
        employees.add(newEmployee);
    }
    public void removeEmployee(int index)
    {
        employees.get(index).changeStatus("fired");
        employees.remove(index);
    }
    public void addRides(Ride newRide)
    {
        rides.add(newRide);
    }
    public void addFacilities(Facility newFacility)
    {
        facilities.add(newFacility);
    }
    public String getRideNames()
    {
        String ridesStr = "";
        for(int i = 0; i<rides.size(); i++)
        {
            ridesStr+= rides.get(i).getRideName();
            if(i<rides.size()-1)
            {
                ridesStr += ", ";
            }
        }
        return ridesStr;
    }
    public String getEmployeeNames()
    {
        String emStr = "";
        for(int i = 0; i<employees.size(); i++)
        {
            emStr+= employees.get(i).getName();
            if(i<employees.size()-1)
            {
                 emStr+= ", ";
            }
        }
        return emStr;
    }
    public int getTotalRides()
    {
        return rides.size();
    }

}
