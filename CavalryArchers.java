package BattleSimulator;

public class CavalryArchers extends BasicUnit
{
	private final String HIGHEST = "Infantry";
	private final String HIGH = "Heavy Cavalry";
	private final String NEUTRAL = "Spearmen";
	private final String LOW = "Archers";
	private final String LOWEST = "Light Cavalry";
	private final String DEFEND1 = "Light Cavalry";
	private final String DEFEND2 = "Archers";
	private static int userCounter;
	private static int computerCounter;
	private int unitNumber;
	private static String referenceName;
	
	public CavalryArchers(String name)
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
		return displayArmyName() + " Cavalry Archers " + unitNumber;
	}
	
	public String getType()
	{
		return "Cavalry Archers";
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