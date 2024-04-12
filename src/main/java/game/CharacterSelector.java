package game;

import java.util.Scanner;

//Define a class to handle the selection of a character
public class CharacterSelector {
	public static void main(String[] args) {
		
		//Use scanner to read user input
		Scanner scanner = new Scanner(System.in);

	    //Prompt the user to select a character class
	    System.out.println("Choose your character class:");
	    System.out.println("1. Fighter");
	    System.out.println("2. Wizard");
	    System.out.println("3. Rogue");
	    System.out.print("Enter your choice: ");

	    //Read user input
	    int choice = scanner.nextInt();
	    scanner.nextLine(); //Deal with newline
	    scanner.close();

	    //Create a character based on user choice and prompt the user to enter a character name
	    Character playerCharacter;
	    switch (choice) {
	        case 1:
	            System.out.print("Enter character name: ");
	            playerCharacter = new Fighter(scanner.nextLine());
	            break;
	        case 2:
	            System.out.print("Enter character name: ");
	            playerCharacter = new Wizard(scanner.nextLine());
	            break;
	        case 3:
	            System.out.print("Enter character name: ");
	            playerCharacter = new Rogue(scanner.nextLine());
	            break;
	        default:
	            System.out.println("Invalid choice. Defaulting to Fighter.");
	            playerCharacter = new Fighter("Default Fighter");
	            break;
	    }

	    //Display selected character's stats as well as chosen character name
	    System.out.println("\nCharacter created:");
	    System.out.println("Name: " + playerCharacter.name);
	    System.out.println("Strength: " + playerCharacter.getStrength());
	    System.out.println("Dexterity: " + playerCharacter.getDexterity());
	    System.out.println("Constitution: " + playerCharacter.getConstitution());
	    System.out.println("Intelligence: " + playerCharacter.getIntelligence());
	    System.out.println("Wisdom: " + playerCharacter.getWisdom());
	    System.out.println("Charisma: " + playerCharacter.getCharisma());
	}
}