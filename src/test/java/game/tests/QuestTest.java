package game.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Quest;

public class QuestTest {
    private Quest quest;
    private List<String> newItemReward;

    @BeforeEach
    void setUp() {
        // Create a new Quest instance
        quest = new Quest("Test Quest", new ArrayList<>(), 100, 5);

        // Create a new list of item rewards
        newItemReward = new ArrayList<>();
        newItemReward.add("Test Weapon");
    }

    @Test
    void testQuestConstructor() {
        assertEquals("Test Quest", quest.getQuestName());
        assertEquals(new ArrayList<>(), quest.getItemReward());
        assertEquals(100, quest.getXpReward());
        assertEquals(5, quest.getGemReward());
        assertEquals("", quest.getSelectedReward());
        assertFalse(quest.isCompleted());
    }

    @Test
    void testSetItemReward() {
        quest.setItemReward(newItemReward);
        assertEquals(newItemReward, quest.getItemReward());
    }
    
    @Test
    void testSetXpReward() {
    	quest.setXpReward(50);
        assertEquals(50, quest.getXpReward());
    }
    
    
    @Test
    void testSetGemReward() {
    	quest.setGemReward(50);
    	assertEquals(50, quest.getGemReward());
    }
    
    @Test
    void testSetQuestName() {
    	assertEquals("Test Quest", quest.getQuestName());
    }
    
    @Test
    void testSetCompleted() {
        // Initially the quest is marked as incompleted
        assertFalse(quest.isCompleted());
        // Marks the quest as completed
        quest.setCompleted(true);
        assertTrue(quest.isCompleted());
    }

}
