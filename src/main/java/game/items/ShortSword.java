package game.items;

import game.*;

public class ShortSword implements IItemStrategy {
	private int skeletons = 20;
	private int ghouls = 16;
	private int zombies = 25;
	private int evilKnight = 12;
	private int dragon = 10;
	private game.ListOfItems type = game.ListOfItems.ShortSword;
	
	public String printType() {
		return type.name();
	}
	
	public int usedFor(game.ListOfItems item) {
		return 1;// 1 = weapon
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
}
