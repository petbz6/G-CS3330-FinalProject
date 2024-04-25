package game.items;

import game.*;
import java.lang.*;

public interface IItemStrategy {
	String printType();
	int usedFor(game.ListOfItems item);
	int getStat(game.BadGuys badguy);
}