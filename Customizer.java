package BattleSimulator;

public class Customizer
{
	public static Army customizeArmy(String name, int n)
	{
		if (n == 1)
		{
			System.out.print("\nSet total number of units: ");
			int number = InputTester.checkInteger();
			return setRandomArmy(name, number);
		}
		else
		{
			System.out.print("\nSet army name: ");
			String customName = InputTester.unchecked();
			System.out.println();
			
			return setCustomArmy(customName);
		}
	}
	
	public static BasicUnit[][] customizeStrategy(int n, Army army1, Army army2)
	{
		if (n == 1)
		{
			int number = 1 + (int)(Math.random() * 4);
			
			switch (number)
			{
				case 1:
					return Strategies.aggressive(army1, army2);
				case 2:
					return Strategies.cooperativeAggressive(army1, army2);
				case 3:
					return Strategies.defensive(army1);
				default:
					return Strategies.mixed(army1, army2);
			}
		}
		else if (n == 2)
			return Strategies.aggressive(army1, army2);
		else if (n == 3)
			return Strategies.cooperativeAggressive(army1, army2);
		else if (n == 4)
			return Strategies.defensive(army1);
		else
			return Strategies.mixed(army1, army2);
	}
	
	public static Army setRandomArmy(String name, int n)
	{
		return new Army(name, n);
	}
	
	public static Army setCustomArmy(String name)
	{
		System.out.printf("Input units for *%s* army...\n\n", name);
		return new Army(name);
	}
}