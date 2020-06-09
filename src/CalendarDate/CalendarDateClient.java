package CalendarDate;

import java.util.Scanner;
import javax.swing.JOptionPane;
public class CalendarDateClient
{
	public static void main(String[] args)
	{
		CalendarDate today = enterDate("today's date, ex: 9 7 2008");		
		System.out.println("Today is " + today);
		
		CalendarDate birth = enterDate("your birth date");
		System.out.println("Your birth date is " + birth);
		
		CalendarDate anniversary = new CalendarDate(birth.getMonth(), birth.getDay(), today.getYear());					 
		if (anniversary.equals(today))
			System.out.println("Happy Birthday");
		else if (anniversary.compareTo(today) < 0)
			System.out.println("Your birthday has already gone");
		else
			System.out.println("Your birthday hasn't come yet");
			
		//Display the following information for the birth date
		// (1)ordinal number (2)whether the birth date is in a leap year
		//For example, provide output such as
		//	You were born on day 109 of a leap year OR
		//	You were born on day 109 of a non-leap year
                String out = "You were born on day "+birth.getOrdinal();
                
                if (CalendarDate.isLeapYear(birth.getYear()))
                    out += " of a leap year";
                
                else out += " of a non-leap year";
                
                System.out.println(out);
	}
	
	private static CalendarDate enterDate(String prompt)
	{
            String input = JOptionPane.showInputDialog(prompt);
            
            Scanner scan = new Scanner(input);
            
            int month = scan.nextInt();
            int day = scan.nextInt();
            int year = scan.nextInt();
            
            return new CalendarDate(month,day,year);
            
            //I didn't know if the date should be entered with spaces in between
            //ex: 9 7 2008, or with slashes ex: 9/7/2008. If it was to be entered 
            //with slashes, I would have done a substring up to the slash, and
            //would have gotten the month number, then I would do the same for
            //the day, and the year. I know how to do this. If this is the case 
            //where the date should be entered with slashes or any other way, 
            //let me know and I will change it.
	}
}