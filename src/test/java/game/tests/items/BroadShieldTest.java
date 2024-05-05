package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.BroadShield;
import static org.junit.Assert.*;

public class BroadShieldTest {
    private BroadShield broadShield;

    @Before
    public void setUp() {
        broadShield = new BroadShield();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", broadShield.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, broadShield.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialDragonStat = broadShield.getStat(BadGuys.dragon);
        broadShield.upgradeItem();
        assertEquals("Dragon stat should increase by 5 after upgrade", initialDragonStat + 5, broadShield.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        broadShield.toggleFavorite();
        assertTrue("BroadShield should be favorited after toggle", broadShield.isFavorited());
        broadShield.toggleFavorite();
        assertFalse("BroadShield should not be favorited after second toggle", broadShield.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = broadShield.getHealth();
        broadShield.useWeapon();
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, broadShield.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        broadShield.setHealth(1);
        broadShield.useWeapon();
        broadShield.useWeapon();  // This should set the damage of all attacks to 0.
        assertEquals("Health should be 0", 0, broadShield.getHealth());
        assertEquals("Damage should be 0 when health is 0", 0, broadShield.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'BroadShield'", "BroadShield", broadShield.getWeaponName()); 
    }
}
