package SolveExpression;

import java.util.Scanner;

public class Token
{
	private String symbol;
	
	public Token(String symbol)
	{
		this.symbol = symbol;
	}
	
	public Token(double number)
	{
		this.symbol = "" + number;
	}
	
	public double doubleValue()
	{
		Scanner scan = new Scanner( this.symbol );
		if (!scan.hasNextDouble())
			throw new RuntimeException("Token is not an Integer");
		return scan.nextDouble();
	}
	
	public String toString()
	{
		return this.symbol;
	}
	
	public boolean isLeftParen()
	{
		return this.symbol.equals("(");
	}
	
	public boolean isRightParen()
	{
		return this.symbol.equals(")");
	}
	
	public boolean isPlus()
	{
		return this.symbol.equals("+");
	}
	
	public boolean isMinus()
	{
		return this.symbol.equals("-");
	}
	
	public boolean isTimes()
	{
		return this.symbol.equals("*");
	}
	
	public boolean isDivide()
	{
		return this.symbol.equals("/");
	}
	
	public boolean isPower()
	{
		return this.symbol.equals("^");
	}

	public boolean isOperator()
	{
		return this.isPlus()  || this.isMinus() ||
                       this.isTimes() || this.isDivide() ||
                       this.isPower();
	}
	
	public boolean isOperand()
	{
		return !this.isLeftParen() && 
                       !this.isRightParen() &&
		       !this.isOperator();
	}
	
	public int priority()
	{
		if (this.isPower()) return 3;
		
                if (this.isTimes() || this.isDivide()) return 2;
		
                if (this.isPlus() || this.isMinus()) return 1;
		
                return 0;
	}
}