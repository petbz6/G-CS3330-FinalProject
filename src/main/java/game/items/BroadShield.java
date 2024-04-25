package game.items;

import game.*;

public class BroadShield implements IItemStrategy {
	private int skeletons = 10;
	private int ghouls = 0;
	private int zombies = 20;
	private int evilKnight = 15;
	private int dragon = 5;
	private game.ListOfItems type = game.ListOfItems.BroadShield;
	
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
}
