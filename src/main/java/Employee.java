public class Employee {
    private String name = "";
    private String status = "";
    private String workplace = "";
    public Employee(String name, String workplace)
    {
        this.name = name;
        status = "hired";
        this.workplace = workplace;
        System.out.println(name + " is "+ status + " at " + workplace);
    }
    public void changeStatus(String newStatus)
    {
        status = newStatus;
        System.out.println(name + " is " + status+ " from " + workplace);
    }
    public String getName()
    {
        return name;
    }
}
