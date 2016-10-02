package BattleSimulator;

public class LightCavalry extends BasicUnit
{
	private final String HIGHEST = "Cavalry Archers";
	private final String HIGH = "Archers";
	private final String NEUTRAL = "Heavy Cavalry";
	private final String LOW = "Spearmen";
	private final String LOWEST = "Infantry";
	private final String DEFEND1 = "Infantry";
	private final String DEFEND2 = "Spearmen";
	private static int userCounter;
	private static int computerCounter;
	private int unitNumber;
	private static String referenceName;
	
	public LightCavalry(String name)
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
		return displayArmyName() + " Light Cavalry " + unitNumber;
	}
	
	public String getType()
	{
		return "Light Cavalry";
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