package game.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import game.Character;
import game.Quest;
import game.QuestMenu;
import game.QuestStatus;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestStatusTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    Character character = new Character("Test Character", 1);

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent)); 
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    
    // Tests for each quest that verifies that the outcome message is correctly associate to its respective quest
    @Test
    public void testQuestOutcomeMessage1() {
        assertEquals("\nYou defeated the bandits. Although no one was present to witness your"
                + "\ndeeds, you gained a great sense of confidence in your abilities.",
                QuestStatus.questOutcomeMessage("Defeat the Bandits"));
    }
    
    @Test
    public void testQuestOutcomeMessage2() {
        assertEquals("\nYou successfully defended the village against the skeletal invaders. "
                + "\nAll of the citizens gathered to sing praises of your bravery and"
                + "\nthe mayor himself rewarded you for your efforts.",
                QuestStatus.questOutcomeMessage("Defend the Village"));
    }
    
    @Test
    public void testQuestOutcomeMessage3() {
    	assertEquals("\nAfter saving the life of the King, you became a hero to the kingdom, "
	        			+ "\nbut you had no time to rest, for evil still prowls the lands. "
	        			+ "\nYou must continue your journey and prove yourself worthy of the title of hero.",
	        			QuestStatus.questOutcomeMessage("Save the King"));
    }
    
    @Test
    public void testQuestOutcomeMessage4() {
    	assertEquals("\nThe duel with the Evil Knight shook your resolve, yet you stand triumphant! "
    			+ "\nWhat possessed the Knight to turn to darkness eludes you, but deep down "
    			+ "\nyou know the same could happen to you if your not careful.",
	        			QuestStatus.questOutcomeMessage("Defeat the Evil Knight"));
    }
    
    @Test
    public void testQuestOutcomeMessage5() {
    	assertEquals("\nWith the slaying of the great dragon, you have solidified your place in "
    			+ "\nthe history books. Such a victory will be told of for ages. The king, fortunate "
    			+ "\nfor the return of his treasure rewards you with land and enough gold and gems to last forever.",
	        			QuestStatus.questOutcomeMessage("Slay the Dragon"));
    }
    
    // test that view quest status displays completed quests correctly
    @Test
    public void testViewQuestStatus_Completed() {
        character.gainXP(50); 
        character.addGems(50);

        // Create a sample quest and set it as completed
        Quest quest = new Quest("Test Quest", null, 50, 50); 
        quest.setCompleted(true);
        QuestMenu.quests.add(quest);

        String input = "6\n"; 
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        QuestStatus.viewQuestStatus(new Scanner(System.in), character);
        String output = outContent.toString();
        assertTrue(output.contains("Status: Completed"));
        assertTrue(output.contains("Experience Gained: 50"));
        assertTrue(output.contains("Received Gems: 50"));
    }
    
    // test that view quest status displays incomplete quests correctly
    @Test
    public void testViewQuestStatus_Incompleted() {
        // Create a sample quest and set it as incomplete
        Quest quest = new Quest("Test Quest", null, 50, 50); 
        quest.setCompleted(false);
        QuestMenu.quests.add(quest);

        String input = "6\n"; 
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        QuestStatus.viewQuestStatus(new Scanner(System.in), character);
        String output = outContent.toString();
        assertTrue(output.contains("Status: Incomplete"));
    }
    
    
}
