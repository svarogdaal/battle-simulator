package BattleSimulator;

public class Spearmen extends BasicUnit
{
	private final String HIGHEST = "Heavy Cavalry";
	private final String HIGH = "Light Cavalry";
	private final String NEUTRAL = "Cavalry Archers";
	private final String LOW = "Infantry";
	private final String LOWEST = "Archers";
	private final String DEFEND1 = "Archers";
	private final String DEFEND2 = "Cavalry Archers";
	private static int userCounter;
	private static int computerCounter;
	private int unitNumber;
	private static String referenceName;
	
	public Spearmen(String name)
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
		return displayArmyName() + " Spearmen " + unitNumber;
	}
	
	public String getType()
	{
		return "Spearmen";
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