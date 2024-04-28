package game;

import game.items.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inventory {
    private List<IItemStrategy> items;
    private IItemStrategy equippedWeapon;
    private IItemStrategy equippedArmor;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(IItemStrategy item) {
        items.add(item);
    }

    public void removeItem(IItemStrategy item) {
        items.remove(item);
        // If the removed item is equipped, unequip it
        if (item.equals(equippedWeapon)) {
            equippedWeapon = null;
        }
        if (item.equals(equippedArmor)) {
            equippedArmor = null;
        }
    }

    public void equipWeapon(IItemStrategy weapon) {
        if (items.contains(weapon)) {
            equippedWeapon = weapon;
        }
    }

    public void unequipWeapon() {
        equippedWeapon = null;
    }

    public void equipArmor(IItemStrategy armor) {
        if (items.contains(armor)) {
            equippedArmor = armor;
        }
    }

    public void unequipArmor() {
        equippedArmor = null;
    }

    public void sortInventoryByType() {
        items.sort(Comparator.comparing(IItemStrategy::printType));
    }

    public IItemStrategy getEquippedWeapon() {
        return equippedWeapon;
    }

    public IItemStrategy getEquippedArmor() {
        return equippedArmor;
    }

    // Method to toggle an item's favorite status
    public void toggleFavorite(IItemStrategy item) {
        if (items.contains(item)) {
            item.toggleFavorite();
        }
    }

    // Display the inventory items
    public void printInventory() {
        for (IItemStrategy item : items) {
            String favoritedString = item.isFavorited() ? " (Favorited)" : "";
            System.out.println(item.printType() + favoritedString);
        }
    }
}
