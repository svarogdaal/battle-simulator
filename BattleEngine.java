package BattleSimulator;

import java.util.ArrayList;

public class BattleEngine
{
	public static void battle(int x, BasicUnit[][] targetPairs, Army army1, Army army2)
	{
		while (true)
		{
			// removing all "dead" units
			for (int i = 0; i < targetPairs.length; i++)
				if (targetPairs[i][0].getSoldierNumber() == 0)
				{
					army1.removeUnit(targetPairs[i][0]);
					army2.removeUnit(targetPairs[i][0]);
				}
			
			if (army1.getTotalUnits() == 0 && army2.getTotalUnits() == 0)
			{
				System.out.print("\n\tBOTH ARMIES ARE DESTROYED!\n");
				break;
			}
			else if (army1.getTotalUnits() == 0)
			{
				System.out.printf("\n\t%s WINS!\n", army2.getArmyName());
				break;
			}
			else if (army2.getTotalUnits() == 0)
			{
				System.out.printf("\n\t%s WINS!\n", army1.getArmyName());
				break;
			}
				
			// creating updated list of targets
			BasicUnit[][] currentList = new BasicUnit[army1.getTotalUnits() + army2.getTotalUnits()][2];
			
			int counter = 0;
			
			for (int i = 0; i < targetPairs.length; i++)
			{
				if (targetPairs[i][0].getSoldierNumber() != 0)
				{
					currentList[counter][0] = targetPairs[i][0];
					
					if (targetPairs[i][1].getSoldierNumber() !=0)
					{
						currentList[counter][1] = targetPairs[i][1]; // should get it from currentList
						counter++;
					}
					else
					{
						currentList[counter][1] = currentList[counter][0].getRandomTarget(army1, army2);
						targetPairs[i][1] = currentList[counter][1];
						counter++;
					}				
				}		
			}
			
			// checking if at least one unit of either army is set to attack
			boolean checkViable = false;
			
			for (int i = 0; i < currentList.length; i++)
				if (! currentList[i][0].getArmyName().equals(currentList[i][1].getArmyName()))
					checkViable = true;
			
			// if all units of both armies are set to defend, takes 5 random units and sets them to attack
			if (checkViable)
				fight(x, currentList);
			else
			{
				for (int i = 0; i < currentList.length && i < 5; i++)
				{
					int number = (int)(Math.random() * (currentList.length - 1));
					
					if (army1.getArmyName().equals(currentList[number][0].getArmyName()))
					{
						currentList[number][1] = currentList[number][0].getAttackTarget(army2);
						
						int check = currentList[number][0].findUnit(targetPairs);
						if (check != -1)
							targetPairs[check][1] = currentList[number][1];
					}
					else
					{
						currentList[number][1] = currentList[number][0].getAttackTarget(army1);
						
						int check = currentList[number][0].findUnit(targetPairs);
						if (check != -1)
							targetPairs[check][1] = currentList[number][1];
					}
				}
				
				fight(x, currentList);
			}
		}
	}
	
	private static void fight(int x, BasicUnit[][] pairs)
	{
		// ensures there are no leftovers
		for (int i = 0; i < pairs.length; i++)
		{
			pairs[i][0].enemyList.clear();
			pairs[i][0].defenderList.clear();
		}
		
		for (int i = 0; i < pairs.length; i++)
			pairs[i][0].enemyList = pairs[i][0].getCurrentEnemies(pairs);
		
		// attacker enemies = target + own attackers + target's defenders
		for (int i = 0; i < pairs.length; i++)
			if (! pairs[i][0].getArmyName().equals(pairs[i][1].getArmyName()))
			{
				ArrayList<BasicUnit> temp = pairs[i][1].getCurrentDefenders(pairs);
				temp.remove(pairs[i][1]);
				pairs[i][0].enemyList.addAll(temp);
			}
		
		// defender enemies = own enemies + target's enemies
		for (int i = 0; i < pairs.length; i++)
			if (pairs[i][0].getArmyName().equals(pairs[i][1].getArmyName()))
				pairs[i][0].enemyList.addAll(pairs[i][1].enemyList);
			
		for (int i = 0; i < pairs.length; i++)
			if (pairs[i][0].enemyList.size() > 0)
			{
				int extra = pairs[i][0].getSoldierNumber() % pairs[i][0].enemyList.size();
				int fightingNumber = pairs[i][0].getSoldierNumber() / pairs[i][0].enemyList.size();
			
				int damage = (int) Math.round((fightingNumber + extra) * pairs[i][0].getAttack(pairs[i][0].enemyList.get(0))
						* (0.25 + Math.random() * 0.85)); // luck factor: attack varies between 0.25 and 1.10
				pairs[i][0].enemyList.get(0).addDamage(damage);
			
				for (int j = 1; j < pairs[i][0].enemyList.size(); j++)
				{
					int damageOther = (int) Math.round(fightingNumber * pairs[i][0].getAttack(pairs[i][0].enemyList.get(j))
							* (0.25 + Math.random() * 0.85)); // luck factor: attack varies between 0.25 and 1.10
					pairs[i][0].enemyList.get(j).addDamage(damageOther);
				}
			}
		
		if (x == 1)
		{
			System.out.println();
			for (int i = 0; i < pairs.length; i++)
				System.out.printf("%s: %d\n", pairs[i][0].getName(), pairs[i][0].getSoldierNumber());
		}
		
		System.out.println();
		
		for (int i = 0; i < pairs.length; i++)
		{
			pairs[i][0].applyDamage();
			if (pairs[i][0].getSoldierNumber() == 0)
				System.out.printf("\n%s is dead.\n\n", pairs[i][0].getName());
		}
	}
}