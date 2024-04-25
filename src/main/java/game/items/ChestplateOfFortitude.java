package game.items;

import game.*;

public class ChestplateOfFortitude implements IItemStrategy {
	private int skeletons = 25;
	private int ghouls = 29;
	private int zombies = 27;
	private int evilKnight = 23;
	private int dragon = 29;
	private game.ListOfItems type = game.ListOfItems.ChestplateOfFortitude;
	
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