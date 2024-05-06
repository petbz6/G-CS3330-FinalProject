package game.tests.questRewards;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import game.Character;
import game.items.*;
import game.questItemRewards.*; 
public class Quest1RewardTest {
	@Test
    public void testQuest1ItemReward() {
        Character character = new Character("TestCharacter", 1);
        AbstractQuestItemReward reward = new Quest1ItemReward();
        
        reward.applyReward(1, character);
        assertTrue(character.getWeapon() instanceof ShortSword);
        
        reward.applyReward(2, character);
        assertTrue(character.getWeapon() instanceof BattleAxe);
        
        reward.applyReward(3, character);
        assertTrue(character.getWeapon() instanceof Warhammer);
    }
	
	// Test for invalid choice
	 @Test
	    public void testInvalidChoice() {
	        Character character = new Character("TestCharacter", 1);
	        AbstractQuestItemReward reward = new Quest1ItemReward();	        
	        reward.applyReward(4, character);
	        assertNull(character.getWeapon());
	    }
}
