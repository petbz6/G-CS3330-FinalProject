package game.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import game.Character;
import game.CharacterSelector;

public class CharacterSelectorTest {

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
    public void testDisplayCharacterInfo() {
        Character character = new Character("Test Character", 2);
        
        character.setCharacterClass("Fighter");
        character.setStrength(10);
        character.setDexterity(12);
        character.setConstitution(14);
        character.setIntelligence(8);
        character.setWisdom(10);
        character.setCharisma(11);
        character.setHP(25);
        
        String expectedOutput = "\nCharacter Information: \n" +
                                "Name: Test Character\n" +
                                "Class: Fighter\n" +
                                "Level: 1\n" +
                                "Gems: 0\n" +
                                "Difficulty: Medium\n" +
                                "\nStats: \n" +
                                "Strength: 10\n" +
                                "Dexterity: 12\n" +
                                "Constitution: 14\n" +
                                "Intelligence: 8\n" +
                                "Wisdom: 10\n" +
                                "Charisma: 11\n" +
                                "Inventory: Empty\n";
        
        System.out.print(expectedOutput);
        
        assertEquals(expectedOutput, outContent.toString());
    }
	
}
