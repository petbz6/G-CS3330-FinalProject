package game.items;

import game.*;
import java.lang.*;

public interface IItemStrategy {
	String printType();
	void toggleFavorite();
	boolean isFavorited();
	void upgradeItem();
	int getHealth();
	void setHealth(int health);
	int getMaxHealth();
	void setMaxHealth(int maxHealth);
	int getStat(BadGuys badguy);
	public void useWeapon();
	public String getWeaponName();

}