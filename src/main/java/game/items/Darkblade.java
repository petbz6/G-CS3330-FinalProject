package game.items;

import game.*;

public class Darkblade implements IItemStrategy{
	private int skeletons = 50;
	private int ghouls = 50;
	private int zombies = 1000;
	private int evilKnight = 100;
	private int dragon = 100;
	private game.ListOfItems type = game.ListOfItems.Darkblade;
	
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