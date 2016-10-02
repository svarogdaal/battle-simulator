package BattleSimulator;

import java.util.ArrayList;

public class Army
{
	private ArrayList<Archers> archersList = new ArrayList<Archers>();
	private ArrayList<CavalryArchers> cavalryArchersList = new ArrayList<CavalryArchers>();
	private ArrayList<HeavyCavalry> heavyCavalryList = new ArrayList<HeavyCavalry>();
	private ArrayList<Infantry> infantryList = new ArrayList<Infantry>();
	private ArrayList<LightCavalry> lightCavalryList = new ArrayList<LightCavalry>();
	private ArrayList<Spearmen> spearmenList = new ArrayList<Spearmen>();
	
	public ArrayList<BasicUnit> wholeArmy = new ArrayList<BasicUnit>();
	
	private int totalUnits;
	private String armyName;
	
	// populates each unit's list with the number of units got from the user
	public Army(String name)
	{
		armyName = name;
		
		System.out.print("Archers: ");
		int archers = InputTester.checkInteger();
		
		for (int i = 0; i < archers; i++)
			archersList.add(new Archers(name));
		
		System.out.print("Cavalry Archers: ");
		int cavalryArchers = InputTester.checkInteger();
		
		for (int i = 0; i < cavalryArchers; i++)
			cavalryArchersList.add(new CavalryArchers(name));
		
		System.out.print("Heavy Cavalry: ");
		int heavyCavalry = InputTester.checkInteger();
		
		for (int i = 0; i < heavyCavalry; i++)
			heavyCavalryList.add(new HeavyCavalry(name));
		
		System.out.print("Infantry: ");
		int infantry = InputTester.checkInteger();
		
		for (int i = 0; i < infantry; i++)
			infantryList.add(new Infantry(name));
		
		System.out.print("Light Cavalry: ");
		int lightCavalry = InputTester.checkInteger();
		
		for (int i = 0; i < lightCavalry; i++)
			lightCavalryList.add(new LightCavalry(name));
		
		System.out.print("Spearmen: ");
		int spearmen = InputTester.checkInteger();
		
		for (int i = 0; i < spearmen; i++)
			spearmenList.add(new Spearmen(name));
		
		constructWholeArmy();
		System.out.println();
	}
	
	public Army(String name, int n)
	{
		armyName = name;
		
		for (int  i = 0; i < n; i++)
		{
			int randomNumber = 1 + (int)(Math.random() * 6);
			
			switch (randomNumber)
			{
				case 1:
					archersList.add(new Archers(name));
					break;
				case 2:
					cavalryArchersList.add(new CavalryArchers(name));
					break;
				case 3:
					heavyCavalryList.add(new HeavyCavalry(name));
					break;
				case 4:
					infantryList.add(new Infantry(name));
					break;
				case 5:
					lightCavalryList.add(new LightCavalry(name));
					break;
				case 6:
					spearmenList.add(new Spearmen(name));
					break;
			}
		}
		
		constructWholeArmy();
	}
	
	public String getArmyName()
	{
		return armyName;
	}
	
	public void constructWholeArmy()
	{
		for (int i = 0; i < archersList.size(); i++)
			wholeArmy.add(archersList.get(i));
		
		for (int i = 0; i < cavalryArchersList.size(); i++)
			wholeArmy.add(cavalryArchersList.get(i));
		
		for (int i = 0; i < heavyCavalryList.size(); i++)
			wholeArmy.add(heavyCavalryList.get(i));
		
		for (int i = 0; i < infantryList.size(); i++)
			wholeArmy.add(infantryList.get(i));
		
		for (int i = 0; i < lightCavalryList.size(); i++)
			wholeArmy.add(lightCavalryList.get(i));
		
		for (int i = 0; i < spearmenList.size(); i++)
			wholeArmy.add(spearmenList.get(i));
	}
	
	public void removeUnit(BasicUnit unit)
	{
		String unitType = unit.getType();
		
		switch (unitType)
		{
			case "Archers":
				archersList.remove(unit);
				break;
			case "Cavalry Archers":
				cavalryArchersList.remove(unit);
				break;
			case "Heavy Cavalry":
				heavyCavalryList.remove(unit);
				break;
			case "Infantry":
				infantryList.remove(unit);
				break;
			case "Light Cavalry":
				lightCavalryList.remove(unit);
				break;
			case "Spearmen":
				spearmenList.remove(unit);
				break;
		}
		
		wholeArmy.clear();
		constructWholeArmy();
	}

	public void printArmy()
	{
		System.out.println(armyName + " Archers: " + archersList.size());
		System.out.println(armyName + " Cavalry Archers: " + cavalryArchersList.size());
		System.out.println(armyName + " Heavy Cavalry: " + heavyCavalryList.size());
		System.out.println(armyName + " Infantry: " + infantryList.size());
		System.out.println(armyName + " Light Cavalry: " + lightCavalryList.size());
		System.out.println(armyName + " Spearmen: " + spearmenList.size());
	}
	
	public BasicUnit getRandomUnit(String name)
	{
		int n;
		
		if (! checkType(name))
		{
			System.out.println("There are no units of that type!");
			return getRandomTypeUnit();
		}
		
		
		switch (name)
		{
			case "Archers":
				n = (int)(Math.random() * archersList.size());
				return archersList.get(n);
			case "Cavalry Archers":
				n = (int)(Math.random() * cavalryArchersList.size());
				return cavalryArchersList.get(n);
			case "Heavy Cavalry":
				n = (int)(Math.random() * heavyCavalryList.size());
				return heavyCavalryList.get(n);
			case "Infantry":
				n = (int)(Math.random() * infantryList.size());
				return infantryList.get(n);
			case "Light Cavalry":
				n = (int)(Math.random() * lightCavalryList.size());
				return lightCavalryList.get(n);
			default:
				n = (int)(Math.random() * spearmenList.size());
				return spearmenList.get(n);
		}
	}
	
	public BasicUnit getRandomTypeUnit()
	{
		ArrayList<BasicUnit> allUnits = new ArrayList<BasicUnit>();
		
		archersList.forEach((unit) -> allUnits.add(unit));
		cavalryArchersList.forEach((unit) -> allUnits.add(unit));
		heavyCavalryList.forEach((unit) -> allUnits.add(unit));
		infantryList.forEach((unit) -> allUnits.add(unit));
		lightCavalryList.forEach((unit) -> allUnits.add(unit));
		spearmenList.forEach((unit) -> allUnits.add(unit));
		
		int randomNumber = (int)(Math.random() * allUnits.size());
		
		return allUnits.get(randomNumber);
	}
	
	public int getTotalUnits()
	{
		totalUnits = wholeArmy.size();
		
		return totalUnits;
	}
	
	// checks whether a specific type is present in the current army
	public boolean checkType(String name)
	{
		boolean check = false;
		
		switch(name)
		{
			case "Archers":
				check = ! archersList.isEmpty();
				break;
			case "Cavalry Archers":
				check = ! cavalryArchersList.isEmpty();
				break;
			case "Heavy Cavalry":
				check = ! heavyCavalryList.isEmpty();
				break;
			case "Infantry":
				check = ! infantryList.isEmpty();
				break;
			case "Light Cavalry":
				check = ! lightCavalryList.isEmpty();
				break;
			case "Spearmen":
				check = ! spearmenList.isEmpty();
				break;
		}
		
		return check;
	}
	
}