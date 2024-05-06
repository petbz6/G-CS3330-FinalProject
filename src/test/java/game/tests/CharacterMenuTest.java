package game.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Character;
import game.CharacterSelector;
import game.CharacterMenu;
import game.QuestMenu;

public class CharacterMenuTest {

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
    void testDisplayCharacterMenu_ViewCharacterInfo() {
        // Simulate user input for viewing character info
        String input = "1\n"; // Provide input for option 1
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect standard output to capture printed messages
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Character character = new Character("Test Character", 1);
        character.setStrength(10);
        character.setDexterity(12);
        character.setConstitution(14);
        character.setIntelligence(8);
        character.setWisdom(10);
        character.setCharisma(11);
        character.setHP(25);

        CharacterMenu.displayCharacterMenu(new Scanner(in), character);

        String expectedOutput = "\nCharacter Options\n" +
                                "\n1. Character\n" +
                                "2. Inventory\n" +
                                "3. Quests\n" +
                                "4. Quit\n" +
                                "\nEnter your choice: \n\n" +
                                "Character Information: \n" +
                                "Name: Test Character\n" +
                                "Class: None\n" +
                                "Level: 1\n" +
                                "Gems: 0\n" +
                                "Difficulty: None\n" +
                                "\nStats: \n" +
                                "Strength: 10\n" +
                                "Dexterity: 12\n" +
                                "Constitution: 14\n" +
                                "Intelligence: 8\n" +
                                "Wisdom: 10\n" +
                                "Charisma: 11\n" +
                                "Inventory: Empty\n";

        assertEquals(expectedOutput, outContent.toString(),
                     "Character information should be displayed");
    }



    // Add more tests for other menu options as needed
}
