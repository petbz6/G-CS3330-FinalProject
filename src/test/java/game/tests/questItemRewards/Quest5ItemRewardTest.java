package game.tests.questItemRewards;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.Character;
import game.items.*;
import game.questItemRewards.AbstractQuestItemReward;
import game.questItemRewards.Quest5ItemReward;

public class Quest5ItemRewardTest {
	@Test
    public void testQuest4ItemReward() {
        Character character = new Character("TestCharacter", 1);
        AbstractQuestItemReward reward = new Quest5ItemReward();
        
        reward.applyReward(1, character);
        assertTrue(character.getUnique() instanceof AmuletOfFire);
        
        reward.applyReward(2, character);
        assertTrue(character.getWeapon() instanceof InfernoStaff);
        
        reward.applyReward(3, character);
        assertTrue(character.getWeapon() instanceof GreatSwordOfDestruction);
    }
	
	// Test for invalid choice
	 @Test
	    public void testInvalidChoice() {
	        Character character = new Character("TestCharacter", 1);
	        AbstractQuestItemReward reward = new Quest5ItemReward();	        
	        reward.applyReward(4, character);
	        assertNull(character.getWeapon());
	    }
}
