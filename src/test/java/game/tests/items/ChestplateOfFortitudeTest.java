package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.ChestplateOfFortitude;
import static org.junit.Assert.*;

public class ChestplateOfFortitudeTest {
    private ChestplateOfFortitude chestplate;

    @Before
    public void setUp() {
        chestplate = new ChestplateOfFortitude();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", chestplate.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, chestplate.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialDragonStat = chestplate.getStat(BadGuys.dragon);
        chestplate.upgradeItem();
        assertEquals("Dragon stat should increase by 5 after upgrade", initialDragonStat + 5, chestplate.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        chestplate.toggleFavorite();
        assertTrue("Chestplate should be favorited after toggle", chestplate.isFavorited());
        chestplate.toggleFavorite();
        assertFalse("Chestplate should not be favorited after second toggle", chestplate.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = chestplate.getHealth();
        chestplate.useWeapon();  
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, chestplate.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        chestplate.setHealth(1);
        chestplate.useWeapon();
        chestplate.useWeapon();  //this should set the effectiveness to 0
        assertEquals("Health should be 0", 0, chestplate.getHealth());
        assertEquals("Effectiveness should be 0 when health is 0", 0, chestplate.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Chestplate of Fortitude'", "Chestplate of Fortitude", chestplate.getWeaponName()); 
    }
}
