package Employee;

public class DailyEmployee extends ClockedEmployee
{
    public DailyEmployee(double payRate)
    {
        super(payRate);
    }
    
    public DailyEmployee()
    {}
    
    public double getGrossPay()
    {
        double weeklyCheck = 0;
        
        for (int i=1 ; i < 8 ; i++)
        {
            weeklyCheck += dailyCheck(i);
        }
        
        return weeklyCheck;
    }
    
    private double dailyCheck(int day)
    {
        if (getHours(day) <= 9) return getHours(day) * getPayRate();
        
        return 9 * getPayRate() + overtime(getHours(day) - 9);
    }
}
