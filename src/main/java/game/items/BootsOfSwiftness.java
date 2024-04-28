package game.items;

import game.*;

public class BootsOfSwiftness implements IItemStrategy {
	private int skeletons = 1;
	private int ghouls = 1;
	private int zombies = 1;
	private int evilKnight = 1;
	private int dragon = 1;
	private boolean isFavorited;
	private int health = 20;
	private int maxHealth = 20;
	private game.ListOfItems type = game.ListOfItems.BootsOfSwiftness;
	
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
		return 2;// 2 = unique
	}
}