package CalendarDate;

public class CalendarDate implements Comparable
{
	//Static Date Methods
	
	//Return the name given a month-number
	public static String monthName(int monthNumber)
	{
            if (monthNumber == 1)
                return "January";
            
            else if (monthNumber == 2)
                return "February";
            
            else if (monthNumber == 3)
                return "March";
            
            else if (monthNumber == 4)
                return "April";
            
            else if (monthNumber == 5)
                return "May";
            
            else if (monthNumber == 6)
                return "June";
            
            else if (monthNumber == 7)
                return "July";
            
            else if (monthNumber == 8)
                return "August";
            
            else if (monthNumber == 9)
                return "September";
            
            else if (monthNumber == 10)
                return "October";
            
            else if (monthNumber == 11)
                return "November";
            
            else if (monthNumber == 12)
                return "December";
            
            else return "The month number is invalid.";
        }
	
	//Return true if the given year-number represents a leap year
	//Return false otherwise
	public static boolean isLeapYear(int yearNumber)
	{
            return (yearNumber%400==0 || yearNumber%4==0 && yearNumber%100==0);
	}
	
	//Return the number of days in a given month of a given year
	//Legitimate return values are 28, 29, 30 or 31
	//Return 0 if the month-number is invalid
	public static int daysInMonth(int monthNumber, int YearNumber)
	{
            int m = monthNumber;
            
            if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12)
                return 31;
            
            else if (m==4 || m==6 || m==9 || m==11)
                return 30;
            
            else if (m==2 && isLeapYear(YearNumber))
                return 29;
            
            else if (m==2 && !isLeapYear(YearNumber))
                return 28;
            
            else return 0;
	}
	
	//Instance Variables
	private int month;
	private int day;
	private int year;
	
	//Initializing constructor
	//Throws a RuntimeException if any parameter is invalid
	public CalendarDate(int month, int day, int year)
	{
            if ( !validDate(month, day, year) )
		throw new RuntimeException("Invalid date number(s)");
            
            this.month = month;
            this.day = day;
            this.year = year;
	}
	
	//Helper method to check whether the given month, day and year
	//	numbers represent a valid date.
	//Return true if valid, false otherwise
	private boolean validDate(int month, int day, int year)
	{
            int m = daysInMonth(month,year);
            
            return (m!=0 && year >= 0 && day <= m && day > 0);
	}
	
	//Accessor methods
	
	//Return the month-number
	public int getMonth()
	{
            return month;
	}
	
	//Return the day-number
	public int getDay()
	{
            return day;
	}
	
	//Return the year-number
	public int getYear()
	{
            return year;
	}
	
	//Return the ordinal number of a date
	//January  1 has ordinal 1
	//January  2 has ordinal 2
	//January 31 has ordinal 31
	//February 1 has ordinal 32
	//December 31 has ordinal 365 in an ordinary year
	//December 31 has ordinal 366 in a leap year
	public int getOrdinal()
	{
            int count=1;
            int ordinal=0;
            
            while (month != count)
            {
                ordinal += daysInMonth(count,year);
                
                count++;
            }
            
            ordinal += day;
            
            return ordinal;
	}
	

	public String toString()
	{
            String m;
            String d;
            String y;
            
            if (month <= 9)
                m = "0" + month;
            
            else m = "" + month;
            
            if (day <= 9)
                d = "0" + day;
            
            else d = "" + day;
            
            if (year <= 9)
                y = "0" + year;            
            
            else if (year%100 <= 9)
                y = "0" + year%100;
            
            else y = "" + year%100;
                        
            return m + "/" + d + "/" + y;
	}
	
	public int compareTo(Object other)
	{
            CalendarDate that = (CalendarDate)other;
            
            if (year < that.getYear())
                return -1;
            
            else if (year == that.getYear())
            {
                if (month < that.getMonth())
                    return -1;
                
                else if (month == that.getMonth())
                {
                    if (day < that.getDay())
                        return -1;
                    
                    else if (day == that.getDay())
                        return 0;
                    
                    else return 1;
                }
                
                else return 1;
            }
            
            else return 1;
	}
	
	public boolean equals(Object other)
	{
            return this.compareTo(other) == 0;
	}
}
