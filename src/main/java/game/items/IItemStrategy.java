package game.items;

import game.*;
import java.lang.*;

public interface IItemStrategy {
	int getDamage(game.BadGuys badguy);
	ListOfItems printType();
	void toggleFavorite();
	boolean isFavorited();
	void upgradeItem();

}