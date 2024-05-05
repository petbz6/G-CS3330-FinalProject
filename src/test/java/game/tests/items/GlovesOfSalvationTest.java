package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.GlovesOfSalvation;
import static org.junit.Assert.*;

public class GlovesOfSalvationTest {
    private GlovesOfSalvation gloves;

    @Before
    public void setUp() {
        gloves = new GlovesOfSalvation();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", gloves.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, gloves.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialProtectionStat = gloves.getStat(BadGuys.dragon); 
        gloves.upgradeItem();
        assertEquals("Protection stat should increase by 5 after upgrade", initialProtectionStat + 5, gloves.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        gloves.toggleFavorite();
        assertTrue("Gloves should be favorited after toggle", gloves.isFavorited());
        gloves.toggleFavorite();
        assertFalse("Gloves should not be favorited after second toggle", gloves.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = gloves.getHealth();
        gloves.useWeapon(); 
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, gloves.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        gloves.setHealth(1);
        gloves.useWeapon();
        gloves.useWeapon(); 
        assertEquals("Health should be 0", 0, gloves.getHealth());
        assertEquals("Effectiveness should be 0 when health is 0", 0, gloves.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Gloves of Salvation'", "Gloves of Salvation", gloves.getWeaponName()); 
    }
}
