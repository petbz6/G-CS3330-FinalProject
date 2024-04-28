package game;

import java.util.Scanner;

public class CharacterMenu {
    
    // Menu that connects the systems of the program
    // 1. View Character Info: Shows created character name, level and stats
    // 2. Inventory: Displays the current inventory for the character
    // 3. View Quests: Displays available quests
    // 4. Quit: Goes back to main menu
    
    public static void displayCharacterMenu(Scanner scanner, Character character) {
        boolean quit = false;
        while (!quit) {
            System.out.println("\nCharacter Options");
            System.out.println("\n1. Character");
            System.out.println("2. Inventory");
            System.out.println("3. Quests");
            System.out.println("4. Quit");
            System.out.print("\nEnter your choice: ");
            String input = scanner.nextLine();
            
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        // Display character info without inventory
                        CharacterSelector.displayCharacterInfo(character);
                        break;
                    case 2:
                        character.printInventory();
                        break;
                    case 3:
                        QuestMenu.displayQuests(scanner, character);
                        break;
                    case 4:
                        System.out.println("Thanks for playing!");
                        quit = true; 
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please enter a number between 1 and 4.");
                        break;
                }
                // Handles non-numerical input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
