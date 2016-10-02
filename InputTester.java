package BattleSimulator;

import java.util.Scanner;

public class InputTester
{
	private static Scanner input = new Scanner(System.in);
	
	public static int checkInteger()
	{
		while (true)
		{	
			String x = input.next();
			
			try
			{
				if (Integer.parseInt(x) >= 0)
					return Integer.parseInt(x);
				else
					System.out.print("\nNumber must be >= 0. Try again: ");
			}
			catch (NumberFormatException e)
			{
				System.out.print("\n" + x + " is not an integer! Try again: ");
			}
		}
	}
	
	public static int checkInteger(int n)
	{
		while (true)
		{	
			String x = input.next();
			
			try
			{
				if (Integer.parseInt(x) > 0 && Integer.parseInt(x) <= n)
					return Integer.parseInt(x);
				else
					System.out.printf("\nNumber must be > 0 and <= %d. Try again: ", n);
			}
			catch (NumberFormatException e)
			{
				System.out.print("\n" + x + " is not an integer! Try again: ");
			}
		}
	}
	
	public static String unchecked()
	{
		String x = input.next();
		return x;
	}
}