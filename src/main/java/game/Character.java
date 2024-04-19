package game;

import java.util.Arrays;
import java.util.Random;

//Create character class with classic DnD stat attributes
public class Character {
    protected String name;
    protected String characterClass;
    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;

    //Create character instance
    public Character(String name) {
        this.name = name;
        rollStats();
    }

    //Create method to roll for stats in a classic DnD fashion (roll a six sided die 4 times and drop the lowest roll)
    private void rollStats() {
        Random random = new Random();
        int[] rolls = new int[6]; //Array to store the total rolls

        //Generate a roll for each stat
        for (int i = 0; i < 6; i++) {
            int[] statRolls = new int[4]; //Array to store the 4 dice rolls
            //Roll 4 times for each stat
            for (int j = 0; j < 4; j++) {
                statRolls[j] = random.nextInt(6) + 1; //Simulate rolling a 6-sided die
            }
            //Sort the stat rolls in ascending order
            Arrays.sort(statRolls);
            //Sum the highest 3 rolls (drop the lowest)
            int total = 0;
            for (int j = 1; j < 4; j++) {
                total += statRolls[j];
            }
            rolls[i] = total; //Store the total roll for the stat
        }

        //Assign each roll to the corresponding stat
        strength = rolls[0];
        dexterity = rolls[1];
        constitution = rolls[2];
        intelligence = rolls[3];
        wisdom = rolls[4];
        charisma = rolls[5];
    }

	//Getter methods for stats
	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getConstitution() {
		return constitution;
	}
 
	public int getIntelligence() {
		return intelligence;
	}
 
	public int getWisdom() {
		return wisdom;
	}
 
	public int getCharisma() {
		return charisma;
	}
}
