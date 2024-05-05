package game.items;

import game.*;

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
    void useWeapon();
    String getWeaponName();
    void setRarity(Rarity rarity);
    Rarity getRarity();
    int usedFor(game.ListOfItems item);
}
