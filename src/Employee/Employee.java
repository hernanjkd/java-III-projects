package Employee;

import java.text.NumberFormat;

public abstract class Employee implements Comparable
{
    private static int count = 1;
    public static NumberFormat currency = NumberFormat.getCurrencyInstance();
    
    private String idNumber;
    private double payRate;
    
    public Employee(double payRate)
    {
        this.payRate = payRate;
      
        idNumber = 1000 + count + "";
        count++;
    }
    
    public String getIdNumber()
    {
        return idNumber;
    }
    
    public double getPayRate()
    {
        return payRate;
    }
    
    /**
     * Also could have done it: 
     * String cat = getClass().getName();
     * cat = cat.substring(0,cat.indexOf("Emp")).toUpperCase();
     */
    public String toString()
    {        
        return idNumber+"  SALARIED   "+currency.format(getGrossPay());
    }
    
    public abstract double getGrossPay();
    
    public int compareTo(Object other)
    {
        Employee that = (Employee)other;
        
        if (this.getGrossPay() == that.getGrossPay()) 
            return (that.getIdNumber().compareTo(this.getIdNumber()));
        
        if (this.getGrossPay() < that.getGrossPay()) return -1;
        
        return 1;
    }
    
    public static Employee[] sort(Employee[] list)
    {
        Employee[] newList = new Employee[list.length];
        
        for (int i=0 ; i < list.length ; i++)
            newList[index(list,i)] = list[i];
         
        return newList;
    }
    
    private static int index(Employee[] list, int i)
    {
        int biggerThan = 0;
        
        for (int n=0 ; n < list.length ; n++)
            if (list[i].compareTo(list[n]) >= 0) biggerThan++;
        
        return list.length - biggerThan;
    }
}