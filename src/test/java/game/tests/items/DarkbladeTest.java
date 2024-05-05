package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.Darkblade;
import static org.junit.Assert.*;

public class DarkbladeTest {
    private Darkblade darkblade;

    @Before
    public void setUp() {
        darkblade = new Darkblade();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", darkblade.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, darkblade.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialDamageStat = darkblade.getStat(BadGuys.dragon); 
        darkblade.upgradeItem();
        assertEquals("Damage stat should increase by 5 after upgrade", initialDamageStat + 5, darkblade.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        darkblade.toggleFavorite();
        assertTrue("Darkblade should be favorited after toggle", darkblade.isFavorited());
        darkblade.toggleFavorite();
        assertFalse("Darkblade should not be favorited after second toggle", darkblade.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = darkblade.getHealth();
        darkblade.useWeapon();
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, darkblade.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        darkblade.setHealth(1);
        darkblade.useWeapon();
        darkblade.useWeapon();  // This should set the damage to zero
        assertEquals("Health should be 0", 0, darkblade.getHealth());
        assertEquals("Damage should be 0 when health is 0", 0, darkblade.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Darkblade'", "Darkblade", darkblade.getWeaponName()); 
    }
}
