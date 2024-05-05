package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.ShortSword;
import static org.junit.Assert.*;

public class ShortSwordTest {
    private ShortSword shortSword;

    @Before
    public void setUp() {
        shortSword = new ShortSword();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", shortSword.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, shortSword.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialDamageStat = shortSword.getStat(BadGuys.dragon);  
        shortSword.upgradeItem();
        assertEquals("Damage stat should increase by 5 after upgrade", initialDamageStat + 5, shortSword.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        shortSword.toggleFavorite();
        assertTrue("Short Sword should be favorited after toggle", shortSword.isFavorited());
        shortSword.toggleFavorite();
        assertFalse("Short Sword should not be favorited after second toggle", shortSword.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = shortSword.getHealth();
        shortSword.useWeapon();  
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, shortSword.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        shortSword.setHealth(1);
        shortSword.useWeapon();
        shortSword.useWeapon();  
        assertEquals("Health should be 0", 0, shortSword.getHealth());
        assertEquals("Damage should be 0 when health is 0", 0, shortSword.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Short Sword'", "Short Sword", shortSword.getWeaponName()); 
    }
}
