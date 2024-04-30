package game;

import java.util.Scanner;

// During the character creation process, the player will be prompted to choose a difficulty level (Normal, Medium, Hard)
// Normal = No stat change, Medium = All stats decrease by 2, Hard = All stats decrease by 4
public class DifficultySettings {
    public static int chooseDifficultyLevel(Scanner scanner) {
        System.out.println("\nSelect quest difficulty:");
        System.out.println("1. Normal (No Changes to Stats)");
        System.out.println("2. Medium (-2 All Stats)");
        System.out.println("3. Hard (-4 All Stats)");
        System.out.print("Enter your choice: ");
        return CharacterSelector.getValidChoice(scanner);
    }
    
    public static void adjustStats(Character character, int difficultyChoice) {
        int statAdjustment = 0;
        switch (difficultyChoice) {
            case 1:
                statAdjustment = 0;
                break;
            case 2:
                statAdjustment = -2;
                break;
            case 3:
                statAdjustment = -4;
                break;
        }

        // Apply the stat adjustment to all stats
        character.strength += statAdjustment;
        character.dexterity += statAdjustment;
        character.constitution += statAdjustment;
        character.intelligence += statAdjustment;
        character.wisdom += statAdjustment;
        character.charisma += statAdjustment;
    }
}
