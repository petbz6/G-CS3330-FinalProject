package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.CowlOfShadows;
import static org.junit.Assert.*;

public class CowlOfShadowsTest {
    private CowlOfShadows cowl;

    @Before
    public void setUp() {
        cowl = new CowlOfShadows();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", cowl.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, cowl.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialStealthEffect = cowl.getStat(BadGuys.dragon); 
        cowl.upgradeItem();
        assertEquals("Stealth effect should increase by 5 after upgrade", initialStealthEffect + 5, cowl.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        cowl.toggleFavorite();
        assertTrue("Cowl should be favorited after toggle", cowl.isFavorited());
        cowl.toggleFavorite();
        assertFalse("Cowl should not be favorited after second toggle", cowl.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = cowl.getHealth();
        cowl.useWeapon();  
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, cowl.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        cowl.setHealth(1);
        cowl.useWeapon();
        cowl.useWeapon();  // this will set the effectiveness to 0
        assertEquals("Health should be 0", 0, cowl.getHealth());
        assertEquals("Effectiveness should be 0 when health is 0", 0, cowl.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Cowl of Shadows'", "Cowl of Shadows", cowl.getWeaponName()); 
    }
}
