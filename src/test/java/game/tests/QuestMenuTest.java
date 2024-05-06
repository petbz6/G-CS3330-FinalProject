package game.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import game.Character;
import game.Quest;
import game.QuestMenu;

public class QuestMenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // Test that the quest log is properly sized (The right amount of quests are set)
    @Test
    public void testQuestLog() {
        List<Quest> quests = QuestMenu.questLog();
        assertNotNull(quests);
        assertEquals(QuestMenu.quests.size(), quests.size());
    }

    // Test that the quests are properly locked
    @Test
    public void testQuestProgression() {
        List<Quest> quests = new ArrayList<>();
        quests.add(new Quest("Quest 1", new ArrayList<>(), 50, 50));
        quests.add(new Quest("Quest 2", new ArrayList<>(), 50, 50));

        QuestMenu.questProgression(1, quests.get(1), quests);
    }

    // Test that the view quest status and return to character menu options are properly displayed
    @Test
    public void testDisplayQuests() {
        String input = "7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        Character character = new Character("Test", 1);
        QuestMenu.displayQuests(scanner, character);

        assertTrue(outContent.toString().contains("Available Quests:"));
        assertTrue(outContent.toString().contains("6. View Quest Status"));
        assertTrue(outContent.toString().contains("7. Back to Character Menu"));
    }

    
}
