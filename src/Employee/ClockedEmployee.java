package Employee;

import java.util.ArrayList;

public abstract class ClockedEmployee extends Employee
{
    private static final double MINIMUM_WAGE = 6.79;
    private ArrayList<Double> timeCard;
    
    public ClockedEmployee(double payRate)
    {
        super(payRate);
        
        timeCard = new ArrayList<Double>();
    }
    
    public ClockedEmployee()
    {
        super(MINIMUM_WAGE);
    }
    
    public abstract double getGrossPay();
    
    public double getHours(int day)
    {
        if (day < 1 || day > 7) throw new RuntimeException("Invalid day entered!");
        
        return timeCard.get(day - 1);
    }
    
    public void addHours(double hrs)
    {
        if (timeCard.size() > 7) throw new RuntimeException("You can't add anymore hours!");
            
        timeCard.add(hrs);
    }
    
    /**
     * super.toString() + ...
     */
    public String toString()
    {
        String category = (this instanceof WeeklyEmployee ? "WEEKLY" : "DAILY ");
        
        String schedule = "";
        
        for (int i=0 ; i < timeCard.size() ; i++)
            schedule += timeCard.get(i)+" ";
        
        return getIdNumber()+"  "+category+"     "+currency.format(getGrossPay())+"   "+schedule;
    }
    
    public double overtime(double hours)
    {
        return hours * 1.5 * getPayRate();
    }
}