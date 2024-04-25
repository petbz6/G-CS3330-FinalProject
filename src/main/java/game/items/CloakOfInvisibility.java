package game.items;

import game.*;

public class CloakOfInvisibility implements IItemStrategy {
	private int skeletons = 0;
	private int ghouls = 0;
	private int zombies = 0;
	private int evilKnight = 0;
	private int dragon = 0;
	private game.ListOfItems type = game.ListOfItems.CloakOfInvisibility;
	
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
}