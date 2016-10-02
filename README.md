# battle-simulator
This program uses java's object-oriented capabilities to simulate a battle between two armies.

General description:

The first step is to choose how you want each army to be constructed. You can specify only the total number of units you want and let the program choose randomly what types of units to use , or you can customize your army, specifying its name and the number for each type of unit (a unit consists of 50 soldiers).

The second step is to choose a strategy for each army. Again, you can let the program choose
a random strategy, or choose a specific strategy. There are four possible strategies:
- Aggressive: each unit chooses one random target unit from the enemy army according to its
        attack preferences.
- Cooperative aggressive: groups of 5 units of the same type attack the same enemy unit,
        chosen at random by the first in the group according to its attack preferences.
- Defensive: each unit chooses one unit from the same army to defend according to its
        defense preferences; with the defensive strategy, every unit gets an attack bonus,
        but only until its defense target dies and it chooses another target (an enemy to 
        attack or an ally to defend).
- Mixed: each unit randomly either attacks or defends, according to its preferences.

Finally, the last step lets you choose what gets displayed. You can choose to display both
the dead units and the number of soldiers left in each unit after each clash of the armies,
or you can choose to display only the dead units. Either way, the program displays a
notification every time a unit chooses a new target and at the end, declaring a winner.
