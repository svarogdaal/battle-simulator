package BattleSimulator;

public class Infantry extends BasicUnit
{
	private final String HIGHEST = "Light Cavalry";
	private final String HIGH = "Spearmen";
	private final String NEUTRAL = "Archers";
	private final String LOW = "Heavy Cavalry";
	private final String LOWEST = "Cavalry Archers";
	private final String DEFEND1 = "Cavalry Archers";
	private final String DEFEND2 = "Heavy Cavalry";
	private static int userCounter;
	private static int computerCounter;
	private int unitNumber;
	private static String referenceName;
	
	public Infantry(String name)
	{
		super(name);

		if (userCounter == 0)
			referenceName = name;
		
		if (name.equals(referenceName))
		{
				userCounter++;
				unitNumber = userCounter;
		}
		else
		{
			computerCounter++;
			unitNumber = computerCounter;
		}
	}
	
	public String getName()
	{
		return displayArmyName() + " Infantry " + unitNumber;
	}
	
	public String getType()
	{
		return "Infantry";
	}
	
	public String getHighest()
	{
		return HIGHEST;
	}
	
	public String getHigh()
	{
		return HIGH;
	}
	
	public String getNeutral()
	{
		return NEUTRAL;
	}
	
	public String getLow()
	{
		return LOW;
	}
	
	public String getLowest()
	{
		return LOWEST;
	}
	
	public String getDefend1()
	{
		return DEFEND1;
	}
	
	public String getDefend2()
	{
		return DEFEND2;
	}
}