package game.tests.questItemRewards;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.Character;
import game.items.*;
import game.questItemRewards.AbstractQuestItemReward;
import game.questItemRewards.Quest4ItemReward;

public class Quest4ItemRewardTest {
	@Test
    public void testQuest4ItemReward() {
        Character character = new Character("TestCharacter", 1);
        AbstractQuestItemReward reward = new Quest4ItemReward();
        
        reward.applyReward(1, character);
        assertTrue(character.getProtectant() instanceof ChestplateOfFortitude);
        
        reward.applyReward(2, character);
        assertTrue(character.getUnique() instanceof CowlOfShadows);
        
        reward.applyReward(3, character);
        assertTrue(character.getWeapon() instanceof Darkblade);
    }
	
	// Test for invalid choice
	 @Test
	    public void testInvalidChoice() {
	        Character character = new Character("TestCharacter", 1);
	        AbstractQuestItemReward reward = new Quest4ItemReward();	        
	        reward.applyReward(4, character);
	        assertNull(character.getWeapon());
	    }
}
