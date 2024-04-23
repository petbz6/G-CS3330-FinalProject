package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import game.items.*;

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
    // Attributes for character leveling/experience 
    protected int level;
    protected int experience;
    protected int gems;
    protected int HP;
    
    private game.items.IItemStrategy weapon;
    private game.items.IItemStrategy protection;


    //Create character instance
    public Character(String name) {
        this.name = name;
        rollStats();
        
        this.level = 1;
        this.experience = 0;
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
	
	public int getLevel() {
        return level;
    }
	
	public int getExperience() {
		return experience;
	}
	
	// Increases character experience and checks for level up condition
	public void gainXP(int xpReward) {
		experience += xpReward;
	    if (experience >= getXPRequired()) {
	    	levelUp();
	    	}
	}
	// Handles occurrence when the character levels up
    private void levelUp() {
        level++;
        experience -= getXPRequired();
        System.out.println("You leveled up to level " + level + "!");
    }
    
    // Calculates the experience points required for the next level
    private int getXPRequired() {
        return level * 50; 
    }

    public boolean addWeapon(game.items.IItemStrategy weapon) {
    	this.weapon = weapon;
		return true;
    }
    public boolean removeWeapon(Item item) {
    	this.weapon = null;
    	return true;
    }
    
    public ListOfItems getWeapon() {
    	return this.weapon.printType();
    }
    
    public int getProtectionAmount(game.BadGuys badguy) {
    	return this.weapon.getDamage(badguy);
    }
    
    public boolean addProtectant(game.items.IItemStrategy weapon) {
    	this.weapon = weapon;
		return true;
    }
    public boolean removeProtectant(Item item) {
    	this.weapon = null;
    	return true;
    }
    
    public ListOfItems getProtectant() {
    	return this.weapon.printType();
    }
    
    public int getDamage(game.BadGuys badguy) {
    	return this.weapon.getDamage(badguy);
    }
    public void printInventory() {
        System.out.println("Weapon: " + this.getWeapon());
        System.out.println("Protection: " + this.getProtectant());
    }
	public void repairItem(Item item) {
		if (item.getHealth() < item.getmaxHealth()) {
			item.setHealth(item.getmaxHealth());
		}
		else {
			System.out.println("Item is currently at its max health");
		}
	}
	public void upgradeItemHealth(Item item) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Would you like to pay 50 gems to upgrade your item's health by 50? (yes/no)");

	    String input = scanner.nextLine().trim().toLowerCase();

	    if ("yes".equals(input)) {
	        if (this.gems >= 50) { // if character has 50 or more gems
	            item.setmaxHealth(item.getmaxHealth() + 50); // add 50 to items max health
	            this.gems -= 50; // Deduct the gems.
	            item.setHealth(item.getmaxHealth()); 
	            System.out.println("Item health has been upgraded to " + item.getmaxHealth());
	        } else {
	            System.out.println("You do not have enough gems to upgrade the item.");
	        }
	    } else {
	        System.out.println("Upgrade cancelled.");
	    }
	    scanner.close(); 
	}

    public int getHP() {
    	return this.HP;
    }
    
    public void setHP(int HP) {
    	this.HP = HP;
    }
		
}
