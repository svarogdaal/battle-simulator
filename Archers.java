package BattleSimulator;

public class Archers extends BasicUnit
{
	private final String HIGHEST = "Spearmen";
	private final String HIGH = "Cavalry Archers";
	private final String NEUTRAL = "Infantry";
	private final String LOW = "Light Cavalry";
	private final String LOWEST = "Heavy Cavalry";
	private final String DEFEND1 = "Heavy Cavalry";
	private final String DEFEND2 = "Infantry";
	private static int userCounter;
	private static int computerCounter;
	private int unitNumber;
	private static String referenceName;
	
	public Archers(String name)
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
		return displayArmyName() + " Archers " + unitNumber;
	}
	
	public String getType()
	{
		return "Archers";
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