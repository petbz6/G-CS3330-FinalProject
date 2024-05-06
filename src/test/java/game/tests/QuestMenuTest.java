package game.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import game.Character;
import game.Quest;
import game.QuestMenu;

public class QuestMenuTest {
	
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
	
	

}
 