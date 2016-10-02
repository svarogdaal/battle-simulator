package BattleSimulator;

public class Strategies
{
	// each method pairs up units according to preferences in given ways
	public static BasicUnit[][] aggressive(Army army1, Army army2)
	{
		BasicUnit[][] targetPairs = new BasicUnit[army1.getTotalUnits()][2];
		
		for (int i = 0; i < army1.getTotalUnits(); i++)
		{
			targetPairs[i][0] = army1.wholeArmy.get(i);
			targetPairs[i][1] = targetPairs[i][0].getAttackTarget(army2);
		}
		
		return targetPairs;
	}
	
	public static BasicUnit[][] defensive(Army army1)
	{
		BasicUnit[][] targetPairs = new BasicUnit[army1.getTotalUnits()][2];
		
		for (int i = 0; i < army1.getTotalUnits(); i++)
		{
			targetPairs[i][0] = army1.wholeArmy.get(i);
			targetPairs[i][1] = targetPairs[i][0].getDefenseTarget(army1);
			targetPairs[i][0].setBasicAttack(0.65);
		}
		
		return targetPairs;
	}
	
	public static BasicUnit[][] mixed(Army army1, Army army2)
	{
		BasicUnit[][] targetPairs = new BasicUnit[army1.getTotalUnits()][2];
		
		for (int i = 0; i < army1.getTotalUnits(); i++)
		{
			int number = 1 + (int)(Math.random() * 2);
			targetPairs[i][0] = army1.wholeArmy.get(i);
			
			if (number == 1)
				targetPairs[i][1] = targetPairs[i][0].getAttackTarget(army2);
			else
				targetPairs[i][1] = targetPairs[i][0].getDefenseTarget(army1);
		}
		
		return targetPairs;
	}
	
	public static BasicUnit[][] cooperativeAggressive(Army army1, Army army2)
	{
		BasicUnit[][] targetPairs = new BasicUnit[army1.getTotalUnits()][2];
		
		targetPairs[0][0] = army1.wholeArmy.get(0);
		targetPairs[0][1] = targetPairs[0][0].getAttackTarget(army2);
		String currentType = targetPairs[0][0].getType();
		int max = 1;
		
		for (int i = 1; i < army1.getTotalUnits(); i++)
		{
			targetPairs[i][0] = army1.wholeArmy.get(i);
			
			
			if (army1.wholeArmy.get(i).getType().equals(currentType) && max < 5)
			{
				targetPairs[i][0] = army1.wholeArmy.get(i);
				targetPairs[i][1] = targetPairs[i - 1][1];
				max++;
				System.out.printf("%35s   attacks   %-28s\n", targetPairs[i][0].getName(), targetPairs[i][1].getName());
			}
			else
			{
				currentType = army1.wholeArmy.get(i).getType();
				targetPairs[i][0] = army1.wholeArmy.get(i);
				targetPairs[i][1] = targetPairs[i][0].getAttackTarget(army2);
				max = 1;
			}
		}
		
		return targetPairs;
	}
}