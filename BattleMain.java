// Author: Silviu Velica
// Date: September 2016
// Description:
// 	This program simulates a battle between two armies. For a detailed description
// 	of how it works, see the README file in the master branch.

package BattleSimulator;

public class BattleMain
{
	public static void main(String[] args)
	{
		System.out.println("\nFirst army should be constructed with:\n");
		System.out.println("\t1. Random units.");
		System.out.println("\t2. Custom units.");
		int n = InputTester.checkInteger(2);
		
		Army firstArmy = Customizer.customizeArmy("User", n);
		
		System.out.println();
		firstArmy.printArmy();
		System.out.println();
		
		System.out.println("\nSecond army should be constructed with:\n");
		System.out.println("\t1.Random units.");
		System.out.println("\t2.Custom units.");
		n = InputTester.checkInteger(2);
		
		Army secondArmy = Customizer.customizeArmy("Computer", n);
		
		System.out.println();
		secondArmy.printArmy();
		System.out.println();
		
		if (firstArmy.getTotalUnits() == 0 || secondArmy.getTotalUnits() == 0)
		{
			System.out.println("Each army must have at least one unit!");
			System.exit(0);
		}
		
		BasicUnit[][] targetPairs = new BasicUnit[firstArmy.getTotalUnits() 
		                                      + secondArmy.getTotalUnits()][2];
		
		System.out.printf("\nChoose strategy for %s:\n\n",
				firstArmy.getArmyName());
		System.out.println("\t1. Random strategy.");
		System.out.println("\t2. Aggressive strategy.");
		System.out.println("\t3. Cooperative aggressive strategy.");
		System.out.println("\t4. Defensive strategy.");
		System.out.println("\t5. Mixed strategy.");
		n = InputTester.checkInteger(5);
		
		BasicUnit[][] firstArmyStrategy = Customizer.customizeStrategy(n, firstArmy, secondArmy);
		
		System.out.printf("\nChoose strategy for %s:\n\n",
				secondArmy.getArmyName());
		System.out.println("\t1. Random strategy.");
		System.out.println("\t2. Aggressive strategy.");
		System.out.println("\t3. Cooperative aggressive strategy.");
		System.out.println("\t4. Defensive strategy.");
		System.out.println("\t5. Mixed strategy.");
		n = InputTester.checkInteger(5);
		
		BasicUnit[][] secondArmyStrategy = Customizer.customizeStrategy(n, secondArmy, firstArmy);
		
		// after the strategies are chosen, the complete list of pairs is created
		for (int i = 0; i < firstArmy.getTotalUnits(); i++)
			targetPairs[i] = firstArmyStrategy[i];
		
		for (int i = firstArmy.getTotalUnits(); i < targetPairs.length; i++)
			targetPairs[i] = secondArmyStrategy[i - firstArmy.getTotalUnits()];
		
		System.out.println("\nChoose what to display:\n");
		System.out.println("\t1. Number of soldiers for each unit as the battle progresses.");
		System.out.println("\t2. Only the dead units.");
		n = InputTester.checkInteger(2);
		
		BattleEngine.battle(n, targetPairs, firstArmy, secondArmy);
	}
}
