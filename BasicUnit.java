package BattleSimulator;

import java.util.ArrayList;

public abstract class BasicUnit
{
	private int soldierNumber = 50;
	private double basicAttack = 0.5;
	private double attack;
	private String armyName;
	private int damageTaken;
	public ArrayList<BasicUnit> enemyList = new ArrayList<BasicUnit>();
	public ArrayList<BasicUnit> defenderList = new ArrayList<BasicUnit>();
	
	public BasicUnit(String name)
	{
		armyName = name;
	}
	
	public String getArmyName()
	{
		return armyName;
	}
	
	public String displayArmyName()
	{
		return "*" + armyName + "*";
	}
	
	// ensuring getters for attack and defense preferences
	public abstract String getHighest();
	
	public abstract String getHigh();
	
	public abstract String getNeutral();
	
	public abstract String getLow();
	
	public abstract String getLowest();
	
	public abstract String getDefend1();
	
	public abstract String getDefend2();
	
	public abstract String getName();
	
	public abstract String getType();
	
	public int getSoldierNumber()
	{
		return soldierNumber;
	}
	
	public void setSoldierNumber(int n)
	{
		soldierNumber = n;
	}
	
	public void addDamage(int n)
	{
		damageTaken += n;
	}
	
	public void applyDamage()
	{
		setSoldierNumber(getSoldierNumber() - damageTaken);
		
		if (getSoldierNumber() < 0)
			setSoldierNumber(0);
		
		damageTaken = 0;
	}
	
	public void setBasicAttack(double n)
	{
		basicAttack = n;
	}
	
	// attack depends on the types of units involved
	public double getAttack(BasicUnit unit)
	{
		if (unit.getType().equals(getHighest()))
		{
			attack = basicAttack + 0.25;
			return attack;
		}
		else if (unit.getType().equals(getHigh()))
		{
			attack = basicAttack + 0.15;
			return attack;
		}
		else if (unit.getType().equals(getLow()))
		{
			attack = basicAttack - 0.1;
			return attack;
		}
		else if (unit.getType().equals(getLowest()))
		{
			attack = basicAttack - 0.2;
			return attack;
		}
		else
			return basicAttack;
	}
	
	public BasicUnit getAttackTarget(Army army)
	{
		BasicUnit target;
		
		this.setBasicAttack(0.5);
		
		if (army.checkType(getHighest()))
			target = army.getRandomUnit(getHighest());
		else if (army.checkType(getHigh()))
			target = army.getRandomUnit(getHigh());
		else if (army.checkType(getType()) || army.checkType(getNeutral()))
		{
			if (army.checkType(getType()) && ! army.checkType(getNeutral()))
				target = army.getRandomUnit(getType());
			else if (! army.checkType(getType()) && army.checkType(getNeutral()))
				target = army.getRandomUnit(getNeutral());
			else
			{
				int random = 1 + (int)(Math.random() * 2);
				
				if (random == 1)
					target = army.getRandomUnit(getType());
				else
					target = army.getRandomUnit(getNeutral());
			}
		}
		else
			target = army.getRandomTypeUnit();
		
		System.out.printf("%35s   attacks   %-28s\n", this.getName(), target.getName());
		return target;
	}
	
	public BasicUnit getDefenseTarget(Army army)
	{
		BasicUnit target;
		
		this.setBasicAttack(0.5);
		
		if (army.checkType(getDefend1()))
			target = army.getRandomUnit(getDefend1());
		else if (army.checkType(getDefend2()))
			target = army.getRandomUnit(getDefend2());
		else
			target = army.getRandomTypeUnit();
		
		System.out.printf("%35s   defends   %-28s\n", this.getName(), target.getName());
		return target;
	}
	
	public BasicUnit getRandomTarget(Army army1, Army army2)
	{
		int number = 1 + (int)(Math.random() * 2);
		BasicUnit armyTest;
		BasicUnit target;
		
		armyTest = army1.getRandomTypeUnit();
		
		if (this.getArmyName().equals(armyTest.getArmyName()))
		{
			if (number == 1)
				target = this.getAttackTarget(army2);
			else
				target = this.getDefenseTarget(army1);
		}
		else
		{
			if (number == 1)
				target = this.getAttackTarget(army1);
			else
				target = this.getDefenseTarget(army2);
		}
		
		return target;
	}
	
	public int findUnit(BasicUnit[][] pairs)
	{
		for (int i = 0; i < pairs.length; i++)
			if (this.getName().equals(pairs[i][0].getName()))
				return i;
		
		return -1;
	}
	
	public ArrayList<BasicUnit> getCurrentEnemies(BasicUnit[][] targets)
	{
		for (int i = 0; i < targets.length; i++)
		{
			if (targets[i][0].getName().equals(this.getName()) &&
					! targets[i][0].getArmyName().equals(targets[i][1].getArmyName()))
				enemyList.add(targets[i][1]);
			if (targets[i][1].getName().equals(this.getName()) &&
					! targets[i][0].getArmyName().equals(targets[i][1].getArmyName()))
				enemyList.add(targets[i][0]);
		}
		
		return enemyList;
	}
	
	public ArrayList<BasicUnit> getCurrentDefenders(BasicUnit[][] targets)
	{
		for (int i = 0; i < targets.length; i++)
			if (targets[i][1].getName().equals(this.getName())
					&& targets[i][0].getArmyName().equals(this.getArmyName()))
				defenderList.add(targets[i][0]);
		
		return defenderList;
	}
}