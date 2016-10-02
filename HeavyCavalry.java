package BattleSimulator;

public class HeavyCavalry extends BasicUnit
{
	private final String HIGHEST = "Archers";
	private final String HIGH = "Infantry";
	private final String NEUTRAL = "Light Cavalry";
	private final String LOW = "Cavalry Archers";
	private final String LOWEST = "Spearmen";
	private final String DEFEND1 = "Spearmen";
	private final String DEFEND2 = "Light Cavalry";
	private static int userCounter;
	private static int computerCounter;
	private int unitNumber;
	private static String referenceName;
	
	public HeavyCavalry(String name)
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
		return displayArmyName() + " Heavy Cavalry " + unitNumber;
	}
	
	public String getType()
	{
		return "Heavy Cavalry";
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