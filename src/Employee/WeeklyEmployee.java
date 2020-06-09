package Employee;

public class WeeklyEmployee extends ClockedEmployee
{
    public WeeklyEmployee(double payRate)
    {
        super(payRate);
    }
    
    public WeeklyEmployee()
    {}
    
    public double getGrossPay()
    {
        if (getWeeklyHours() <= 40) return getWeeklyHours() * getPayRate();
        
        return 40 * getPayRate() + overtime(getWeeklyHours() - 40);
    }
    
    private double getWeeklyHours()
    {
        double hours = 0;
        
        for (int i=1 ; i < 8 ; i++)
        {
            hours += getHours(i);
        }
        
        return hours;
    }
}