package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.InfernoStaff;
import static org.junit.Assert.*;

public class InfernoStaffTest {
    private InfernoStaff infernoStaff;

    @Before
    public void setUp() {
        infernoStaff = new InfernoStaff();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", infernoStaff.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, infernoStaff.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialFireDamageStat = infernoStaff.getStat(BadGuys.dragon);  
        infernoStaff.upgradeItem();
        assertEquals("Fire damage stat should increase by 5 after upgrade", initialFireDamageStat + 5, infernoStaff.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        infernoStaff.toggleFavorite();
        assertTrue("Inferno Staff should be favorited after toggle", infernoStaff.isFavorited());
        infernoStaff.toggleFavorite();
        assertFalse("Inferno Staff should not be favorited after second toggle", infernoStaff.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = infernoStaff.getHealth();
        infernoStaff.useWeapon(); 
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, infernoStaff.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        infernoStaff.setHealth(1);
        infernoStaff.useWeapon();
        infernoStaff.useWeapon();  
        assertEquals("Health should be 0", 0, infernoStaff.getHealth());
        assertEquals("Effectiveness should be 0 when health is 0", 0, infernoStaff.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Inferno Staff'", "Inferno Staff", infernoStaff.getWeaponName()); 
    }
}
