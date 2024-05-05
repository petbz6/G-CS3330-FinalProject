package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.RingOfProtection;
import static org.junit.Assert.*;

public class RingOfProtectionTest {
    private RingOfProtection ring;

    @Before
    public void setUp() {
        ring = new RingOfProtection();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", ring.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, ring.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialProtectionStat = ring.getStat(BadGuys.dragon);  
        ring.upgradeItem();
        assertEquals("Protection stat should increase by 5 after upgrade", initialProtectionStat + 5, ring.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        ring.toggleFavorite();
        assertTrue("Ring should be favorited after toggle", ring.isFavorited());
        ring.toggleFavorite();
        assertFalse("Ring should not be favorited after second toggle", ring.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = ring.getHealth();
        ring.useWeapon(); 
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, ring.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        ring.setHealth(1);
        ring.useWeapon();
        ring.useWeapon();  
        assertEquals("Health should be 0", 0, ring.getHealth());
        assertEquals("Protection should be 0 when health is 0", 0, ring.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Ring of Protection'", "Ring of Protection", ring.getWeaponName());
    }
}
