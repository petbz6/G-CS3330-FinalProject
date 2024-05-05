package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.GreatSwordOfDestruction;
import static org.junit.Assert.*;

public class GreatSwordOfDestructionTest {
    private GreatSwordOfDestruction greatSword;

    @Before
    public void setUp() {
        greatSword = new GreatSwordOfDestruction();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", greatSword.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, greatSword.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialDamageStat = greatSword.getStat(BadGuys.dragon); 
        greatSword.upgradeItem();
        assertEquals("Damage stat should increase by 5 after upgrade", initialDamageStat + 5, greatSword.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        greatSword.toggleFavorite();
        assertTrue("Great Sword should be favorited after toggle", greatSword.isFavorited());
        greatSword.toggleFavorite();
        assertFalse("Great Sword should not be favorited after second toggle", greatSword.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = greatSword.getHealth();
        greatSword.useWeapon();
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, greatSword.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        greatSword.setHealth(1);
        greatSword.useWeapon();
        greatSword.useWeapon(); 
        assertEquals("Health should be 0", 0, greatSword.getHealth());
        assertEquals("Damage should be 0 when health is 0", 0, greatSword.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Great Sword of Destruction'", "Great Sword of Destruction", greatSword.getWeaponName());
    }
}
