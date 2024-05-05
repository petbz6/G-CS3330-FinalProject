package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.AmuletOfFire;
import static org.junit.Assert.*;


public class AmuletOfFireTest {
	 private AmuletOfFire amulet;

    @Before
    public void setUp() {
        amulet = new AmuletOfFire();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", amulet.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, amulet.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialDragonStat = amulet.getStat(BadGuys.dragon);
        amulet.upgradeItem();
        assertEquals("Dragon stat should increase by 5 after upgrade", initialDragonStat + 5, amulet.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        amulet.toggleFavorite();
        assertTrue("Amulet should be favorited after toggle", amulet.isFavorited());
        amulet.toggleFavorite();
        assertFalse("Amulet should not be favorited after second toggle", amulet.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = amulet.getHealth();
        amulet.useWeapon();
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, amulet.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        amulet.setHealth(1);
        amulet.useWeapon();
        amulet.useWeapon();  // This should set the damage of all attacks to 0.
        assertEquals("Health should be 0", 0, amulet.getHealth());
        assertEquals("Damage should be 0 when health is 0", 0, amulet.getStat(BadGuys.dragon));
    }

    @Test
    public void testWeaponName() {
        assertEquals("Weapon name should be 'Amulet of Fire'", "Amulet of Fire", amulet.getWeaponName());
    }
}
