package game.tests.items;
import org.junit.Before;
import org.junit.Test;

import game.BadGuys;
import game.items.HelmOfJustice;
import static org.junit.Assert.*;

public class HelmOfJusticeTest {
    private HelmOfJustice helm;

    @Before
    public void setUp() {
        helm = new HelmOfJustice();
    }

    @Test
    public void testRarityAssignment() {
        assertNotNull("Rarity should not be null", helm.getRarity());
    }

    @Test
    public void testInitialHealth() {
        assertEquals("Initial health should be 20", 20, helm.getHealth());
    }

    @Test
    public void testUpgradeEffectOnStats() {
        int initialEffectivenessStat = helm.getStat(BadGuys.dragon); 
        helm.upgradeItem();
        assertEquals("Effectiveness stat should increase by 5 after upgrade", initialEffectivenessStat + 5, helm.getStat(BadGuys.dragon));
    }

    @Test
    public void testToggleFavorite() {
        helm.toggleFavorite();
        assertTrue("Helm should be favorited after toggle", helm.isFavorited());
        helm.toggleFavorite();
        assertFalse("Helm should not be favorited after second toggle", helm.isFavorited());
    }

    @Test
    public void testWeaponUseDecreasesHealth() {
        int initialHealth = helm.getHealth();
        helm.useWeapon();  
        assertEquals("Health should decrease by 1 after using weapon", initialHealth - 1, helm.getHealth());
    }

    @Test
    public void testWeaponUseAtZeroHealth() {
        helm.setHealth(1);
        helm.useWeapon();
        helm.useWeapon();  
        assertEquals("Health should be 0", 0, helm.getHealth());
        assertEquals("Effectiveness should be 0 when health is 0", 0, helm.getStat(BadGuys.dragon));
    }

    @Test
    public void testItemName() {
        assertEquals("Item name should be 'Helm of Justice'", "Helm of Justice", helm.getWeaponName()); 
    }
}
