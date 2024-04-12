package game;

//Define a base Character class with classic dnd stats that can be extended later
public class Character {
	protected String name;
	protected int strength;
	protected int dexterity;
	protected int constitution;
	protected int intelligence;
	protected int wisdom;
	protected int charisma;
 

	public Character(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
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

//Define subclasses for character class that represent actual playable classes in dnd
class Fighter extends Character {
	public Fighter(String name) {
		super(name, 16, 9, 15, 13, 11, 14); //Stat values for a fighter
	}
}

class Wizard extends Character {
	public Wizard(String name) {
		super(name, 9, 11, 13, 17, 16, 15); //Stat values for a wizard
	}
}

class Rogue extends Character {
	public Rogue(String name) {
		super(name, 10, 17, 14, 14, 12, 16); //Stat values for a rogue
	}
}
