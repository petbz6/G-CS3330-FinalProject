package game.items;

import java.util.Random;

import game.*;

public class CloakOfInvisibility implements IItemStrategy {
	private int skeletons = 0;
	private int ghouls = 0;
	private int zombies = 0;
	private int evilKnight = 0;
	private int dragon = 0;
	private boolean isFavorited;
	private int health = 20;
	private int maxHealth = 20;
	private game.ListOfItems type = game.ListOfItems.CloakOfInvisibility;
	private Rarity rarity;
	
    public CloakOfInvisibility() {
        this.rarity = getRandomRarity(); 
    }

    private Rarity getRandomRarity() {
        Random random = new Random();

        Rarity[] skewedRarities = {
            Rarity.COMMON, Rarity.COMMON, Rarity.COMMON, Rarity.COMMON, Rarity.COMMON,
            Rarity.UNCOMMON, Rarity.UNCOMMON, Rarity.UNCOMMON,
            Rarity.RARE, Rarity.RARE,
            Rarity.EPIC,
            Rarity.LEGENDARY
        };
        return skewedRarities[random.nextInt(skewedRarities.length)];
    }
	
	
	public String printType() {
		return type.name();
	}
	
	public int getStat(game.BadGuys badguy) {
        switch (badguy) {
	        case skeletons:
	            return skeletons;
	        case ghouls:
	            return ghouls;
	        case zombies:
	            return zombies;
	        case evilKnight:
	            return evilKnight;
	        case dragon:
	            return dragon;
	        default:
	            System.out.println("Invalid badguy!");
	            return -1;
        }
	}
	
	public int usedFor(game.ListOfItems item) {
		return 2;// 0 = unique
	}
	
	public void toggleFavorite() {
		this.isFavorited = !this.isFavorited;
	}
	
	public boolean isFavorited() {
		return this.isFavorited;
	}

	public void upgradeItem() {
		this.dragon += 5;
		this.evilKnight += 5;
		this.ghouls += 5;
		this.skeletons += 5;
		this.zombies += 5;
	}
	
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMaxHealth() {
		return this.maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public void useWeapon() {
		if (this.health == 0) {
			//set each attack to 0
			this.dragon = 0;
			this.evilKnight = 0;
			this.ghouls = 0;
			this.skeletons = 0;
			this.zombies = 0;
			System.out.println("Your Cloak of Invisibility has ran out of health! Attacks will now have 0 damage.");
		}
		else {
			this.health -= 1;
			System.out.println("Item health after attack: " + this.getHealth());
		}
	}
	public String getWeaponName() {
		return "Cloak of Invisibility";
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
	
}