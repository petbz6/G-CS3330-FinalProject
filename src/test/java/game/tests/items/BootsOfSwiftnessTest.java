package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.BootsOfSwiftness;
import static org.junit.Assert.*;

public class BootsOfSwiftnessTest {
    private BootsOfSwiftness boots;

    @Before
    public void setUp() {
        boots = new BootsOfSwiftness();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", boots.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, boots.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialDragonStat = boots.getStat(BadGuys.dragon);
        boots.upgradeItem();
        assertEquals("Dragon stat should increase by 5 after upgrade", initialDragonStat + 5, boots.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        boots.toggleFavorite();
        assertTrue("Boots should be favorited after toggle", boots.isFavorited());
        boots.toggleFavorite();
        assertFalse("Boots should not be favorited after second toggle", boots.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = boots.getHealth();
        boots.useWeapon();
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, boots.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        boots.setHealth(1);
        boots.useWeapon();
        boots.useWeapon();  // This should set the damage of all attacks to 0.
        assertEquals("Health should be 0", 0, boots.getHealth());
        assertEquals("Damage should be 0 when health is 0", 0, boots.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Boots of Swiftness'", "Boots of Swiftness", boots.getWeaponName()); 
    }
}
