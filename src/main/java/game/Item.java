package game;

public class Item {
	
    private enum Rarity {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }
	private String name;
	private String type;
	private int maxHealth;
	private int health;
	private Rarity rarity;
	

    public Item(String name, String type, Rarity rarity, int maxHealth) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Assuming new items start at max health
    }
	
	@Override
	public String toString() {
	    return "Item{" +
	            "name='" + name + '\'' +
	            ", type='" + type + '\'' +
	            ", rarity='" + rarity + '\'' +
	            ", health=" + health +
	            '}';
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getmaxHealth() {
    	return this.maxHealth;

    }
    public void setmaxHealth(int maxHealth) {
    	this.maxHealth = maxHealth;
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

   
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }


}