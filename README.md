# CS3330 Final Project - Dungeons & Dragons Game

## Group Members:
- Isaac Rider
- Kyle Young
- Andrew Hamilton
- Pierce Terry

## Description:
This project consists of a Dungeon & Dragons game that allows the user to go on an adventure filled with combat, rewards, progression, and more. After running the program, the user can select the option to create a character. The user can then select their class (Fighter, Wizard or Rogue) each with their own strengths and weaknesses, their preferred difficulty level (Normal, Medium or Hard) which reflects how powerful their character will be, and then give their character a name. Upon successful creation of a character, the user will be prompted with a menu with four options (Character, Inventory, Quests and Quit). The Character option will display information pertaining to the character, including name, class, level, stats, etc. The Inventory option will display the characters current items and gems. The Quest option will open a menu and allow for the user to go quests, and the Quit option will quit the game. More information regarding the components/features of the program can be found below. 

## How to Run/Compile Program
1. Open Eclipse
2. Click File - Import - Projects from Git - Clone URL - Paste the Github Repository URL - Finish
3. Open the Main File of the project
4. Click the green arrow button to run the program
5. User Input is required at various stages of the program, so please provide input according to the prompts provided

### Character
The character system starts with the Create a Character option in the main menu. The user must then choose from three classes: Fighter, Wizard and Rogue. Each class has their own strengths and weaknesses, with their stats being adjusted accordingly. For instance, the Fighter class adds two to the strength and constitution stats, but subtracts two from the wisdom stat. The user will then be prompted to select a difficulty level from the options Normal (stats are unchanged), Medium (all stats decreased by 2) and Hard (all stats decreased by 4). And finally, the user will give their character a name. The character's stats will then be generated through a roll feature which simulates the rolling of a six-sided die (The class specific and difficulty level stat adjustments are added/subtracted from this initial roll). Then in the character menu, the Character option will display information pertaining to character, and update accordingly as the user progresses through the game. 

### Inventory
The inventory system allows for the user to gain unique armor and weapons from completing quests, along with a gem currency that enables the user to upgrade equipment. Each item has its own capabilities against enemies, so a shortsword and inferno staff will do different levels of damage and overall perform differently. Furthermore, using weapons in combat will wear down its health with each attack, and upon reaching 0 health, the weapon will deal no damage, requiring the user to repair the item. Furthermore, within the inventory option itself, the user is able to add or remove items from their inventory, favorite specific items, upgrade items using the gem currency and perform the repair function. 

### Combat
The combat system simulates turn-based combat between the player character and enemies. Combat occurs in quests, with each quest having its own unique scenario. For instance, the first quest consists of the character, armed only with their fists as they have not earned any rewards yet, fighting bandits. The player has the option to either fight and attempt to win and complete the quest, or run away and fail the quest. 

### Quests
The quest system allows for the user to go on unique adventures, filled with action, danger and rewards. Quests can be acessed by choosing the Quest option in the character menu. In order to instill progression, quests are locked until the player completes the previous ones, i.e. quest 2 cannot be completed until quest 1 is completed. After selecting a quest, combat will ensue, and the player will have to make choices in order to win and complete the quest. Once a quest is successfully completed, the player will be granted rewards, including experience points which contribute to increasing the players level, gems which allow the player to upgrade items in their inventory, and a choice from three equipment rewards, which upon selection is added to inventory. Furthermore, a View Quest Status option is available in the quest menu, which will display information related to each quest, including how much experience gained, how many gems gained, the equipment reward selected and a brief statement describing the outcome of completing the quest. 

## Dependencies
- java.util.ArrayList;
- java.util.Arrays;
- java.util.List;
- java.util.Random;
- java.util.Scanner;
- java.util.Comparator;

## Group Member Feature
Andrew (Character System):
- Main Menu
- Character Classes
- Roll Stats
- Character Name
- Display Character Information

Isaac (Combat System):
- Character Turn
- Enemy Turn
- 3
- 4
- 5

Kyle (Inventory System):
- Manage Inventory (Add, Remove, Swap Items)
- Organize Inventory
- Item Enhancement (gem upgrades)
- Item Durability and Repairs
- Item Stats and Quality

Pierce (Quest System):
- Difficulty Setting
- Quest Progression
- View Quest Status
- Quest Rewards
- Leveling
