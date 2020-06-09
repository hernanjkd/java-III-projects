package Employee;

import java.util.*;

public class Client
{
    public static void main(String[]args)
    {
        Employee employee;
        
        int amountOfEmployees = 13;
        Employee[] list = new Employee[amountOfEmployees];
                
        Random gen = new Random();
   
        for (int i=0 ; i < amountOfEmployees ; i++)
        {
            double clockedPay = gen.nextInt(15) + 7;        
            double salariedPay = gen.nextInt(660) + 450;  
            int schedule = gen.nextInt(3) + 1;
            
            switch(schedule)
            {
                case 1 : employee = new SalariedEmployee(salariedPay);break;
                case 2 : employee = new WeeklyEmployee(clockedPay);break;
                default : employee = new DailyEmployee(clockedPay);break;
            }
            
            if (employee instanceof ClockedEmployee)
            {
                ClockedEmployee worker = (ClockedEmployee)employee;
                
                for (int day=1 ; day < 8 ; day++)
                {
                    worker.addHours(gen.nextInt(12));
                } 
            }
            
            list[i] = employee;
        }
       
        for (Employee person : Employee.sort(list)) System.out.println(person);
    }
}