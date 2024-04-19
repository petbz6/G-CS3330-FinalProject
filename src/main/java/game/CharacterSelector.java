package game;

import java.util.Scanner;

//Define a class to handle the selection of a character
public class CharacterSelector {
    public static void main(String[] args) {
    	
    	//Use scanner to read user input
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        //Read user input
        while (true) {
        	//Call displayMenu
            displayMenu();
            //Handle user input
            choice = getValidChoice(scanner);
            if (choice >= 1 && choice <= 3) {
                break;
            }
        }
        
        //Call createCharacter and create a new player character
        Character playerCharacter = createCharacter(scanner, choice);
        
        //Close the scanner
        scanner.close();

        //Call displayCharacterInfo to display all the character info
        displayCharacterInfo(playerCharacter);
        
        //Venture forth
        //xxxxx
    }
    
    //Create method to prompt the user to select a character class
    private static void displayMenu() {
        System.out.println("\nChoose your character class:");
        System.out.println("1. Fighter");
        System.out.println("2. Wizard");
        System.out.println("3. Rogue");
        System.out.print("Enter your choice: ");
    }

    //Create a method to read user input and handle exceptions
    private static int getValidChoice(Scanner scanner) {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    throw new IllegalArgumentException("Invalid option. Please enter 1, 2, or 3.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return choice;
    }

    //Create method to create character and prompt user to enter name
    private static Character createCharacter(Scanner scanner, int choice) {
        System.out.print("Enter character name: ");
        String name = scanner.nextLine().trim();
        //Handle empty name
        while (name.isEmpty()) {
            System.out.print("Character name cannot be empty. Please enter a valid name: ");
            name = scanner.nextLine().trim();
        }

        //Create a character based on user choice
        Character playerCharacter = null;
        switch (choice) {
            case 1:
                playerCharacter = new Character(name);
                playerCharacter.characterClass = "Fighter";
                break;
            case 2:
                playerCharacter = new Character(name);
                playerCharacter.characterClass = "Wizard";
                break;
            case 3:
                playerCharacter = new Character(name);
                playerCharacter.characterClass = "Rogue";
                break;
        }
        return playerCharacter;
    }

    //Create method to display all character info to the user
    private static void displayCharacterInfo(Character character) {
        System.out.println("\nCharacter created:");
        System.out.println("Name: " + character.name);
        System.out.println("Class: " + character.characterClass);
        System.out.println("Strength: " + character.getStrength());
        System.out.println("Dexterity: " + character.getDexterity());
        System.out.println("Constitution: " + character.getConstitution());
        System.out.println("Intelligence: " + character.getIntelligence());
        System.out.println("Wisdom: " + character.getWisdom());
        System.out.println("Charisma: " + character.getCharisma());
    }
}
