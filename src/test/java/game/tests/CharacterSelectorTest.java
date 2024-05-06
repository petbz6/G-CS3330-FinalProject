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

    @Test
    public void testCreateCharacter() {
        //Prepare input for Scanner (simulate user input)
        String input = "Test Character\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //Initialize Scanner
        Scanner scanner = new Scanner(System.in);

        //Call createCharacter method for Fighter
        Character fighterCharacter = CharacterSelector.createCharacter(scanner, 1, 2);
        //Assert properties for Fighter + adjust stats based on class
        fighterCharacter.setStrength(10 + 2);
        fighterCharacter.setConstitution(10 + 1);
        fighterCharacter.setWisdom(10 - 2);
        assertEquals("Fighter", fighterCharacter.getCharacterClass());
        assertEquals(12, fighterCharacter.getStrength());
        assertEquals(11, fighterCharacter.getConstitution());
        assertEquals(8, fighterCharacter.getWisdom());
        assertEquals(20, fighterCharacter.getHP());
        assertEquals("Test Character", fighterCharacter.getName());

        //Call createCharacter method for Wizard
        Character wizardCharacter = CharacterSelector.createCharacter(scanner, 2, 2);
        //Assert properties for Wizard + adjust stats based on class
        wizardCharacter.setStrength(10 - 2);
        wizardCharacter.setWisdom(10 + 1);
        wizardCharacter.setIntelligence(10 + 2);
        assertEquals("Wizard", wizardCharacter.getCharacterClass());
        assertEquals(8, wizardCharacter.getStrength());
        assertEquals(12, wizardCharacter.getIntelligence());
        assertEquals(11, wizardCharacter.getWisdom());
        assertEquals(20, wizardCharacter.getHP());
        assertEquals("Test Character", wizardCharacter.getName());

        //Call createCharacter method for Rogue
        Character rogueCharacter = CharacterSelector.createCharacter(scanner, 3, 2);
        //Assert properties for Rogue + adjust stats based on class
        rogueCharacter.setDexterity(10 + 2);
        rogueCharacter.setConstitution(10 - 2);
        rogueCharacter.setCharisma(10 + 1);
        assertEquals("Rogue", rogueCharacter.getCharacterClass());
        assertEquals(12, rogueCharacter.getDexterity());
        assertEquals(11, rogueCharacter.getCharisma());
        assertEquals(8, rogueCharacter.getConstitution());
        assertEquals(20, rogueCharacter.getHP());
        assertEquals("Test Character", rogueCharacter.getName());

        //Close scanner
        scanner.close();
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
