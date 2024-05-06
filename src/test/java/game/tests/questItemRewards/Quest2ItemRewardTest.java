package game.tests.questItemRewards;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.Character;
import game.items.*;
import game.questItemRewards.AbstractQuestItemReward;
import game.questItemRewards.Quest2ItemReward;

public class Quest2ItemRewardTest {
	@Test
    public void testQuest2ItemReward() {
        Character character = new Character("TestCharacter", 1);
        AbstractQuestItemReward reward = new Quest2ItemReward();
        
        reward.applyReward(1, character);
        assertTrue(character.getProtectant() instanceof BroadShield);
        
        reward.applyReward(2, character);
        assertTrue(character.getProtectant() instanceof HelmOfJustice);
        
        reward.applyReward(3, character);
        assertTrue(character.getProtectant() instanceof GlovesOfSalvation);
    }
	
	// Test for invalid choice
	 @Test
	    public void testInvalidChoice() {
	        Character character = new Character("TestCharacter", 1);
	        AbstractQuestItemReward reward = new Quest2ItemReward();	        
	        reward.applyReward(4, character);
	        assertNull(character.getWeapon());
	    }
}
