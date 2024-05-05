package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.BattleAxe;
import static org.junit.Assert.*;

public class BattleAxeTest {
    private BattleAxe battleAxe; 

    @Before
    public void setUp() {
        battleAxe = new BattleAxe();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", battleAxe.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, battleAxe.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialDragonStat = battleAxe.getStat(BadGuys.dragon);
        battleAxe.upgradeItem();
        assertEquals("Dragon stat should increase by 5 after upgrade", initialDragonStat + 5, battleAxe.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        battleAxe.toggleFavorite();
        assertTrue("Battle Axe should be favorited after toggle", battleAxe.isFavorited());
        battleAxe.toggleFavorite();
        assertFalse("Battle Axe should not be favorited after second toggle", battleAxe.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = battleAxe.getHealth();
        battleAxe.useWeapon();
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, battleAxe.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        battleAxe.setHealth(1);
        battleAxe.useWeapon();
        battleAxe.useWeapon();  // This should set the damage of all attacks to 0.
        assertEquals("Health should be 0", 0, battleAxe.getHealth());
        assertEquals("Damage should be 0 when health is 0", 0, battleAxe.getStat(BadGuys.dragon));
    }

    @Test
    public void testWeaponName() {
        assertEquals("Weapon name should be 'Battle Axe'", "Battle Axe", battleAxe.getWeaponName());
    }
}
