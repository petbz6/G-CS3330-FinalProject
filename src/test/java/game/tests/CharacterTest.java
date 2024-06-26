package game.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import game.Character;

public class CharacterTest {
	
	private Character character = null;

	//This method will be invoked even before setUp() method and will be executed once
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Running Before All");
	}

	//This method will be executed after all test methods and tearDown() invocations are complete
	//This will be the last method to be executed this test class.
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	//This method will be invoked for each test method
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Running Before Each");
		character = new Character("Test", 1);
	}

	//This method will be executed after the test method execution is complete
	@AfterEach
	void tearDown() throws Exception {
	}
	
	//Test rollStats method
	@Test
	public void testRollStats() {
        character.rollStats();
        //Call rollstats and ensure all rolled stats are within the valid range (drop lowest d6 out of 4 rolls)
        assertTrue(character.getStrength() >= 3 && character.getStrength() <= 18);
        assertTrue(character.getDexterity() >= 3 && character.getDexterity() <= 18);
        assertTrue(character.getConstitution() >= 3 && character.getConstitution() <= 18);
        assertTrue(character.getIntelligence() >= 3 && character.getIntelligence() <= 18);
        assertTrue(character.getWisdom() >= 3 && character.getWisdom() <= 18);
        assertTrue(character.getCharisma() >= 3 && character.getCharisma() <= 18);
    }
	
	//Test xp related methods
	@Test
    public void testGainXP() {
        character.gainXP(100);
        assertEquals(100, character.getExperience());
        character.gainXP(50);
        assertEquals(50, character.getExperience());
        assertEquals(1, character.getLevel()); //Should not level up
        character.gainXP(150); //Enough to level up
        assertEquals(0, character.getExperience());
        assertEquals(2, character.getLevel());
    }
	
	//Test getDifficultyChoice method
	@Test
	public void testGetDifficultyChoice() {
		assertEquals(1, character.getDifficultyChoice());
	}
	
	//Test getName method
	@Test
	public void testGetName() {
		assertEquals("Test", character.getName());
	}
	
	//Test getName method
	@Test
	public void testGetCharacterClass() {
		assertEquals(null, character.getCharacterClass());
	}
	
	//Test setName method
	@Test
	void testSetCharacterClass() {
		character.setCharacterClass("Fighter");
		assertEquals("Fighter", character.getCharacterClass());
	}
	
	//Test setName method
	@Test
	void testSetName() {
		character.setName("Bob");
		assertEquals("Bob", character.getName());
	}
	
	//Test setStrength method
	@Test
	void testSetStrength() {
		character.setStrength(15);
		assertEquals(15, character.getStrength());
	}
	
	//Test setDexterity method
	@Test
	void testSetDexterity() {
		character.setDexterity(15);
		assertEquals(15, character.getDexterity());
	}
	
	//Test setConstitution method
	@Test
	void testSetConstitution() {
		character.setConstitution(15);
		assertEquals(15, character.getConstitution());
	}
	
	//Test setIntelligence method
	@Test
	void testSetIntelligence() {
		character.setIntelligence(15);
		assertEquals(15, character.getIntelligence());
	}
	
	//Test setWisdom method
	@Test
	void testSetWisdom() {
		character.setWisdom(15);
		assertEquals(15, character.getWisdom());
	}
	
	//Test setCharisma method
	@Test
	void testSetCharisma() {
		character.setCharisma(15);
		assertEquals(15, character.getCharisma());
	}
	
}
