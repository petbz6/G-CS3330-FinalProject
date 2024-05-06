package game.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Character;
import game.DifficultySettings;

public class DifficultySettingsTest {

    private static final ByteArrayInputStream Normal = new ByteArrayInputStream("1".getBytes());
    private static final ByteArrayInputStream Medium = new ByteArrayInputStream("2".getBytes());
    private static final ByteArrayInputStream Hard = new ByteArrayInputStream("3".getBytes());
    private static final Scanner scanner = new Scanner(Normal);
    private static final Scanner scannerMedium = new Scanner(Medium);
    private static final Scanner scannerHard = new Scanner(Hard);

    @BeforeAll
    static void setUpBeforeAll() {
        System.setIn(Normal);
    }
    
    // Tests normal difficulty selection
    @Test
    void testChooseDifficultyLevel_Normal() {
        assertEquals(1, DifficultySettings.chooseDifficultyLevel(scanner), "Normal difficulty level");
    }
    
    // Tests medium difficulty selection
    @Test
    void testChooseDifficultyLevel_Medium() {
        assertEquals(2, DifficultySettings.chooseDifficultyLevel(scannerMedium), "Medium difficulty level");
    }
    
    // Tests hard difficulty selection
    @Test
    void testChooseDifficultyLevel_Hard() {
        assertEquals(3, DifficultySettings.chooseDifficultyLevel(scannerHard), "Hard difficulty level");
    }
    
    // Test to ensure normal stat adjustment is applied
    @Test
    void testAdjustStatsNormal() {
        Character character = new Character("Normal Character", 1);
        character.setStrength(10);
        character.setDexterity(10);
        character.setConstitution(10);
        character.setIntelligence(10);
        character.setWisdom(10);
        character.setCharisma(10);

        DifficultySettings.adjustStats(character, 1);

        assertEquals(10, character.getStrength(), "Strength unchanged in Normal difficulty");
        assertEquals(10, character.getDexterity(), "Dexterity unchanged in Normal difficulty");
        assertEquals(10, character.getConstitution(), "Constitution unchanged in Normal difficulty");
        assertEquals(10, character.getIntelligence(), "Intelligence unchanged in Normal difficulty");
        assertEquals(10, character.getWisdom(), "Wisdom unchanged in Normal difficulty");
        assertEquals(10, character.getCharisma(), "Charisma unchanged in Normal difficulty");
    }
    
    // Test to ensure medium stat adjustment is applied
    @Test
    void testAdjustStatsMedium() {
        Character character = new Character("Medium Character", 3);
        character.setStrength(10);
        character.setDexterity(10);
        character.setConstitution(10);
        character.setIntelligence(10);
        character.setWisdom(10);
        character.setCharisma(10);

        DifficultySettings.adjustStats(character, 2);

        assertEquals(8, character.getStrength(), "Strength decreased by 2 in Medium difficulty");
        assertEquals(8, character.getDexterity(), "Dexterity decreased by 2 in Medium difficulty");
        assertEquals(8, character.getConstitution(), "Constitution decreased by 2 in Medium difficulty");
        assertEquals(8, character.getIntelligence(), "Intelligence decreased by 2 in Medium difficulty");
        assertEquals(8, character.getWisdom(), "Wisdom decreased by 2 in Medium difficulty");
        assertEquals(8, character.getCharisma(), "Charisma decreased by 2 in Medium difficulty");
    }
    
    // Test to ensure hard stat adjustment is applied
    @Test
    void testAdjustStatsHard() {
        Character character = new Character("Hard Character", 3);
        character.setStrength(10);
        character.setDexterity(10);
        character.setConstitution(10);
        character.setIntelligence(10);
        character.setWisdom(10);
        character.setCharisma(10);

        DifficultySettings.adjustStats(character, 3);

        assertEquals(6, character.getStrength(), "Strength decreased by 4 in Hard difficulty");
        assertEquals(6, character.getDexterity(), "Dexterity decreased by 4 in Hard difficulty");
        assertEquals(6, character.getConstitution(), "Constitution decreased by 4 in Hard difficulty");
        assertEquals(6, character.getIntelligence(), "Intelligence decreased by 4 in Hard difficulty");
        assertEquals(6, character.getWisdom(), "Wisdom decreased by 4 in Hard difficulty");
        assertEquals(6, character.getCharisma(), "Charisma decreased by 4 in Hard difficulty");
    }
}
