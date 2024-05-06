package game.tests.questRewards;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.Character;
import game.items.*;
import game.questItemRewards.AbstractQuestItemReward;
import game.questItemRewards.Quest3ItemReward;

public class Quest3RewardTest {
	@Test
    public void testQuest2ItemReward() {
        Character character = new Character("TestCharacter", 1);
        AbstractQuestItemReward reward = new Quest3ItemReward();
        
        reward.applyReward(1, character);
        assertTrue(character.getUnique() instanceof BootsOfSwiftness);
        
        reward.applyReward(2, character);
        assertTrue(character.getProtectant() instanceof RingOfProtection);
        
        reward.applyReward(3, character);
        assertTrue(character.getUnique() instanceof CloakOfInvisibility);
    }
	
	// Test for invalid choice
	 @Test
	    public void testInvalidChoice() {
	        Character character = new Character("TestCharacter", 1);
	        AbstractQuestItemReward reward = new Quest3ItemReward();	        
	        reward.applyReward(4, character);
	        assertNull(character.getWeapon());
	    }
}
