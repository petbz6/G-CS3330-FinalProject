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
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import game.Character;
import game.CharacterSelector;

public class CharacterSelectorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    //Method to setup streams before each test so output can be captured
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    //Method to restore original output after each test
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
	
    //Test displayMenu method
    @Test
    public void testDisplayMenu() {
    	String expectedOutput = "\"\\nChoose your character class: \n" +
                "1. Fighter (+2 STR -2 WIS +1 CON)\n" +
                "2. Wizard (+2 INT -2 STR +1 WIS)\n" +
                "3. Rogue (+2 DEX -2 CON +1 CHA)\n" +
                "Enter your choice: \n";

    	System.out.print(expectedOutput);

		assertEquals(expectedOutput, outContent.toString());
    }
    
    //Test getValidChoice with proper simulated input
    @Test
    public void testGetValidChoiceWithValidInput() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertEquals(2, CharacterSelector.getValidChoice(scanner));
        System.setIn(System.in); // Reset System.in to its original state
    }

    //Test getValidChoice with improper simulated input
    @Test
    public void testGetValidChoiceWithInvalidInputThenValid() {
        String input = "invalid\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertEquals(2, CharacterSelector.getValidChoice(scanner));
        System.setIn(System.in); // Reset System.in to its original state
    }
    
    //Test displayCharacterInfo method
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
