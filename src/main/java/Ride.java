public class Ride {
    private String rideName = "";
    public Ride(String rideName)
    {
        this.rideName = rideName;
    }
    public String getRideName()
    {
        return rideName;
    }
    public String riding(Customer rider)
    {
        rider.setStatus(true);
        return rider.getName() + " is riding the " + rideName;
    }
    public void notRiding(Customer rider)
    {
        rider.setStatus(false);
    }
}
