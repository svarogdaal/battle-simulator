# battle-simulator
This program uses java's object-oriented capabilities to simulate a battle between two armies.

General description:

The first step is to choose how you want each army to be constructed. You can specify only the total number of units you want and let the program choose randomly what types of units to use , or you can customize your army, specifying its name and the number for each type of unit (a unit consists of 50 soldiers).

The second step is to choose a strategy for each army. Again, you can let the program choose a random strategy, or choose a specific strategy. There are four possible strategies:
- Aggressive: each unit chooses one random target unit from the enemy army according to its attack preferences.
- Cooperative aggressive: groups of 5 units of the same type attack the same enemy unit, chosen at random by the first in the group according to its attack preferences.
- Defensive: each unit chooses one unit from the same army to defend according to its defense preferences; with the defensive strategy, every unit gets an attack bonus, but only until its defense target dies and it chooses another target (an enemy to attack or an ally to defend).
- Mixed: each unit randomly either attacks or defends, according to its preferences.

Finally, the last step lets you choose what gets displayed. You can choose to display both the dead units and the number of soldiers left in each unit after each clash of the armies, or you can choose to display only the dead units. Either way, the program displays a notification every time a unit chooses a new target and at the end, declaring a winner.


Details:

- Classes Archers, CavalryArchers, HeavyCavalry, Infantry, LightCavalry, and Spearmen represent the 6 types of units available. Each of them contains only what is specific to that type of unit, namely its attack and defence preferences (from the other types of units), its name, and getters for each of these variables.

- Each of the six unit-type classes extends the abstract class BasicUnit, which contains what is common to all units. Thus, each unit begins with 50 soldiers and has a specific attack for each type of unit, calculated using the preferences stored in each unit class. BasicUnit also contains non-static methods for selecting an attack target or a defense target from an Army object (see below), calculating and applying damage to the current unit, and maintaining ArrayLists for the enemies and defenders of the current unit.

- Class Army contains one ArrayList of each type of unit, plus an ArrayList of type BasicUnit containing the whole army (all the units of every type). It has two constructors, one with only a string parameter (the army name), which lets the user decide how many units of each type to have, and the other with a string parameter (again the army name) and an integer, which randomly generates units of each type, with a total equal to the integer argument received. The class also has non-static methods to remove a unit from the army, to return a random unit of a specific type or to return a random unit of a random type, and to check if units of a specific type are present in the current army.

- Class Strategies contains four static methods, each returning a two-dimensional list of type BasicUnit of the size of the army for which the specific strategy is applied. The first position in each element of the two-dimensional list is a unit from the current army, and the second position is the current unit's target. All methods except the "defensive" method take two army objects as arguments. See the general description for the idea behind each strategy method.

- Class BattleEngine contains two static methods:
    - The "fight" method takes an integer parameter reflecting the user's choice of what to display (see the final step in the general description), and a two-dimensional list of type BasicUnit, which is constructed by adding together the lists given by each army's strategy. For every unit in each army the method first updates its lists of current enemies and defenders, after which it calculates the damage inflicted by each unit to each of its enemies, according to the unit's attack against each particular enemy, the number of current enemies, and a luck factor which varies the attack between 0.25 and 1.10 of its original value; the damage done is then added to each unit's damage instance variable. After this is done, the "fight" method prints the number of soldiers for each unit before applying the damage (if this option is chosen by the user), applies the total damage for each unit, then prints which units are dead (when the number of soldiers is 0).
