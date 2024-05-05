package game.items;

import java.util.Random;

import game.*;

public class RingOfProtection implements IItemStrategy {
	private int skeletons = 20;
	private int ghouls = 20;
	private int zombies = 20;
	private int evilKnight = 20;
	private int dragon = 20;
	private boolean isFavorited;
	private int health = 20;
	private int maxHealth = 20;
	private game.ListOfItems type = game.ListOfItems.RingOfProtection;
	private Rarity rarity;
	
    public RingOfProtection() {
        this.rarity = getRandomRarity(); 
        if (this.rarity == Rarity.UNCOMMON) {
        	upgradeItem();
        	// item stats boosted by 5 points
     
        }
        if (this.rarity == Rarity.RARE) {
        	upgradeItem();
        	upgradeItem();
        	
        	//item stats boosted by 10 points
        }
        
        if (this.rarity == Rarity.EPIC) {
        	upgradeItem();
        	upgradeItem();
        	upgradeItem();
        	// item stats boosted by 15 points
        }
        if (this.rarity == Rarity.LEGENDARY) {
        	upgradeItem();
        	upgradeItem();
        	upgradeItem();
        	upgradeItem();
        	
        	// item stats boosted by 20 points 
        }
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
		return 0;// 0 = protection
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
			System.out.println("Your Ring of Protection has ran out of health! Attacks will now have 0 damage.");
		}
		else {
			this.health -= 1;
			System.out.println("Item health after attack: " + this.getHealth());
		}
	}
	public String getWeaponName() {
		return "Ring of Protection";
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
	
}