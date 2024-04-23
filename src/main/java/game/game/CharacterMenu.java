package game;

import java.util.Scanner;

public class CharacterMenu {
    
	// Menu that connects the systems of the program
	// 1. View Character Info: Shows created character name, level and stats
	// 2. Inventory: Displays the current inventory for the character
	// 3. View Quests: Displays available quests
	// 4. Quit: Goes back to main menu
	
    public static void displayCharacterMenu(Scanner scanner, Character character) {
        int choice;
        do {
        	System.out.println("\nCharacter Options");
            System.out.println("\n1. Character");
            System.out.println("2. Inventory");
            System.out.println("3. Quests");
            System.out.println("4. Quit");
            System.out.print("\nEnter your choice: ");
            choice = getValidChoice(scanner, 4);
            
            switch (choice) {
                case 1:
                    CharacterSelector.displayCharacterInfo(character);
                    break;
                case 2:
                    System.out.println("(PLACEHOLDER)");
                    break;
                case 3:
                    QuestMenu.displayQuests(scanner, character);
                    break;
                case 4:
                    // Adjust so it goes back to main menu
                    break;
            }
        } while (choice != 4);
    }
    
    
    // Validates user choice
    // Error handling for invalid input
    private static int getValidChoice(Scanner scanner, int totalChoices) {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > totalChoices) {
                    throw new IllegalArgumentException("Invalid option. Please enter a number between 1 and " + totalChoices + ".");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } 
        }
        return choice;
    }
}
