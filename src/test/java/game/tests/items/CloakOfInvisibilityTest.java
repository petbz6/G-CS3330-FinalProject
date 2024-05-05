package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.CloakOfInvisibility;
import static org.junit.Assert.*;

public class CloakOfInvisibilityTest {
    private CloakOfInvisibility cloak;

    @Before
    public void setUp() {
        cloak = new CloakOfInvisibility();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", cloak.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, cloak.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialStealthEffect = cloak.getStat(BadGuys.dragon);  
        cloak.upgradeItem();
        assertEquals("Stealth effect should increase by 5 after upgrade", initialStealthEffect + 5, cloak.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        cloak.toggleFavorite();
        assertTrue("Cloak should be favorited after toggle", cloak.isFavorited());
        cloak.toggleFavorite();
        assertFalse("Cloak should not be favorited after second toggle", cloak.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = cloak.getHealth();
        cloak.useWeapon();  
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, cloak.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        cloak.setHealth(1);
        cloak.useWeapon();
        cloak.useWeapon();  // this will set the effectiveness to 0
        assertEquals("Health should be 0", 0, cloak.getHealth());
        assertEquals("Effectiveness should be 0 when health is 0", 0, cloak.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Cloak of Invisibility'", "Cloak of Invisibility", cloak.getWeaponName()); 
    }
}
