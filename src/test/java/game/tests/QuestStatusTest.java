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

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

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
    
}
