package game;

public class Item {
	
	private String name;
	private String type;
	private String rarity;
	private int maxHealth;
	private int health;
	

	public static void main(String[] args) {
		
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
	 // Getter and setter for name
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
    
    // Getter and setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and setter for rarity
    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    // Getter for health - setter not provided since health should probably only be modified through specific methods like repair
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }


}