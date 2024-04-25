package game.items;

import game.*;

public class AmuletOfFire implements IItemStrategy{
	private int skeletons = 66;
	private int ghouls = 68;
	private int zombies = 90;
	private int evilKnight = 126;
	private int dragon = 178;
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
}