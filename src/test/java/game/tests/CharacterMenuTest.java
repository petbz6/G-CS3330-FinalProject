package game.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.CharacterMenu;
import game.Character;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CharacterMenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    Character character = new Character("Test Character", 1);

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);

    }
    
    // Test that the quit menu option exits the program
    @Test
    public void testQuitMenu() {
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        CharacterMenu.displayCharacterMenu(scanner, character);

        assertTrue(outContent.toString().contains("Thanks for playing!"));
    }

    
    // test that proper handling for invalid input is added
    @Test
    public void testInvalidOption() {
        String input = "5\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        CharacterMenu.displayCharacterMenu(scanner, character);

        assertTrue(outContent.toString().contains("Invalid option. Please enter a number between 1 and 4."));
    }
    
    


}
