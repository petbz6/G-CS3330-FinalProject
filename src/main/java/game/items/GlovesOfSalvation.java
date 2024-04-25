package game.items;

import game.*;

public class GlovesOfSalvation implements IItemStrategy {
	private int skeletons = 20;
	private int ghouls = 2;
	private int zombies = 10;
	private int evilKnight = 5;
	private int dragon = 1;
	private game.ListOfItems type = game.ListOfItems.GlovesOfSalvation;
	
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