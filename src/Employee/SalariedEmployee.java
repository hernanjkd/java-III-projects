package Employee;

public class SalariedEmployee extends Employee
{
    public SalariedEmployee(double payRate)
    {
        super(payRate);
    }
    
    public double getGrossPay()
    {
        return getPayRate();
    }
}
