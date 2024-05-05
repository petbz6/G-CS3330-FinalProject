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
    protected int level;
    protected int experience;
    protected int difficultyChoice;
    protected int gems;
    protected int HP;
    protected int fistDamage = 2;
    
    private game.items.IItemStrategy weapon = null;
    private game.items.IItemStrategy protection = null;
    private game.items.IItemStrategy unique = null;


    //Create character instance
    public Character(String name, int difficultyChoice) {
        this.name = name;
        this.difficultyChoice = difficultyChoice;
        rollStats();
        
        this.level = 1;
        this.experience = 0;
    }

    //Create method to roll for stats in a classic DnD fashion (roll a six sided die 4 times and drop the lowest roll)
    public void rollStats() {
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

	//Getter methods for character stats
    	public String getName() {
		return name;
	}
    
	public String getCharacterClass() {
		return characterClass;
	}

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
	
	//Setter methods for character stats
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
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
    
    public int getDifficultyChoice() {
        return difficultyChoice;
    }

    public boolean addWeapon(game.items.IItemStrategy weapon) {
    	this.weapon = weapon;
		return true;
    }
    public boolean removeWeapon(game.items.IItemStrategy weapon) {
    	if(weapon == this.weapon && this.weapon != null) {
    		this.weapon = null;
        	return true;
    	}
    	return false;
    }
    
    public IItemStrategy getWeapon() {
    	return this.weapon;
    }
    
    public int getDamage(BadGuys badguy) {
    	return this.weapon.getStat(badguy);
    }
    
    public boolean addProtectant(IItemStrategy protection) {
    	this.protection = protection;
		return true;
    }
    public boolean removeProtectant(IItemStrategy item) {
    	if(item == this.protection && this.protection != null) {
    		this.protection = null;
        	return true;
    	}
    	return false;
    }
    
    public IItemStrategy getProtectant() {
    	return this.protection;
    }

    public int getProtectionAmount(BadGuys badguy) {
    	return this.weapon.getStat(badguy);
    }
    
    public boolean addUnique(IItemStrategy unique) {
    	this.unique = unique;
		return true;
    }
    public boolean removeUnique(IItemStrategy unique) {
    	if(unique == this.unique && this.unique != null) {
    		this.unique = null;
        	return true;
    	}
    	return false;
    }
    
    public IItemStrategy getUnique() {
    	return this.unique;
    }

    public int getUniqueAmount(BadGuys badguy) {
    	return this.unique.getStat(badguy);
    }
    
    public void printInventory() {
        if (weapon != null) {
            System.out.println("\nWeapon: " + weapon.printType());
        }
        if (protection != null) {
            System.out.println("Protection: " + protection.printType());
        }
        if (unique != null) {
            System.out.println("Unique: " + unique.printType());
        }
        if (weapon == null && protection == null && unique == null) {
            System.out.println("\nInventory Empty");
        }
        
        // Display gems
        System.out.println("Gems: " + gems);
    }

	public void repairItem(IItemStrategy item) {
		if (item.getHealth() < item.getMaxHealth()) {
			item.setHealth(item.getMaxHealth());
		}
		else {
			System.out.println("Item is currently at its max health");
		}
	}
	public void upgradeItemHealth(IItemStrategy item) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Would you like to pay 50 gems to upgrade your item's health by 5 points? (yes/no)");

	    String input = scanner.nextLine().trim().toLowerCase();

	    if ("yes".equals(input)) {
	        if (this.gems >= 50) { // if character has 50 or more gems
	            item.setMaxHealth(item.getMaxHealth() + 5); // add 5 to items max health
	            this.gems -= 50; // Deduct the gems.
	            item.setHealth(item.getMaxHealth()); 
	            System.out.println("Item health has been upgraded to " + item.getMaxHealth());
	        } else {
	            System.out.println("You do not have enough gems to upgrade the item.");
	        }
	    } else {
	        System.out.println("Upgrade cancelled.");
	    }
	    scanner.close(); 
	}
	
	public void addGems(int gems) {
	       this.gems += gems;
	}
	
    public int getHP() {
    	return this.HP;
    }
    
    public void setHP(int HP) {
    	this.HP = HP;
    }
    
    public int getFistDamage() {
    	return this.fistDamage;
    }
    
    public void setFistDamage(int fistDamage) {
    	this.fistDamage = fistDamage;
    }
		
}
