package game.items;

import game.*;

public class AmuletOfFire implements IItemStrategy{
	private int skeletons = 66;
	private int ghouls = 68;
	private int zombies = 90;
	private int evilKnight = 126;
	private int dragon = 178;
	private boolean isFavorited;
	private int health = 20;
	private int maxHealth = 20;
	private game.ListOfItems type = game.ListOfItems.AmuletOfFire;
	
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
		return 1;// 1 = weapon
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
	
}