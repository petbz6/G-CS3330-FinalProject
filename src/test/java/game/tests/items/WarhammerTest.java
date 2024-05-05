package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.Warhammer;
import static org.junit.Assert.*;

public class WarhammerTest {
    private Warhammer warhammer;

    @Before
    public void setUp() {
        warhammer = new Warhammer();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", warhammer.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, warhammer.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialImpactStat = warhammer.getStat(BadGuys.dragon);  
        warhammer.upgradeItem();
        assertEquals("Impact stat should increase by 5 after upgrade", initialImpactStat + 5, warhammer.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        warhammer.toggleFavorite();
        assertTrue("Warhammer should be favorited after toggle", warhammer.isFavorited());
        warhammer.toggleFavorite();
        assertFalse("Warhammer should not be favorited after second toggle", warhammer.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = warhammer.getHealth();
        warhammer.useWeapon();  
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, warhammer.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        warhammer.setHealth(1);
        warhammer.useWeapon();
        warhammer.useWeapon();  
        assertEquals("Health should be 0", 0, warhammer.getHealth());
        assertEquals("Effectiveness should be 0 when health is 0", 0, warhammer.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Warhammer'", "Warhammer", warhammer.getWeaponName()); 
    }
}
