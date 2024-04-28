package game;

import java.util.Scanner;

//Define a class to create a main menu
public class MainMenu {
    
    public static void main(String[] args) {
        
        //Use scanner to read user input
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        //Read user input
        while (true) {
            //Prompt the user to select a character class
            System.out.println("Welcome to the DnD Game!");
            System.out.println("1. Create Character");
            System.out.println("2. Overview");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    throw new IllegalArgumentException("Invalid option. Please enter 1, 2, or 3.");
                }
                break; //Exit the loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        switch (choice) {
            case 1:
                CharacterSelector.main(args);
                break;
            case 2:
                System.out.print("You will create either a fighter, wizard, or rogue, each with unique stats."
                        + "\nThen you will choose a quest and defeat various encounters and be rewarded with loot."
                        + "\nThis loot can be equipped to improve your stats and make future quests easier.\n");
                System.out.print("\nLet's begin by making a character!\n");
                CharacterSelector.main(args);
                break;
            case 3:
                System.out.print("Goodbye!");
                System.exit(0);
        }
        
        //Close the scanner
        scanner.close();
        
        
    }
}
