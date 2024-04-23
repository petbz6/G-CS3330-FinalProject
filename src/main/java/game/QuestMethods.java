package game;

import java.util.Scanner;

public class QuestMethods {
	
	public int quest1(Scanner scanner, Character character) {
		System.out.println("You enter the room");
		if(character.characterClass == "Fighter") {
			System.out.println("You are a fighter in a dark room.");
		}
		if(character.characterClass == "Wizard") {
			System.out.println("You are a wizard in a dark room");
		}
		if(character.characterClass == "Rogue") {
			System.out.println("You are a rogue in a dark room");
		}
		character.setHP(20);
		System.out.println("Once upon a time, in the kingdom of Crazies"
				+ ", there was a king named Bob the Just. His reign was marked by prosperity and peace, \n"
				+ "as he ruled with fairness and compassion, earning the love and respect of his subjects. \n"
				+ "However, not all were content under his rule."
				+ "");
		character.setHP(character.getHP() - 2);
		for(int i = 0; i < 3; i++) {
			int option;
	        do {
	        	if(i == 1) {
	        	System.out.println("You hear bandits hiding!\n"
	    				+ "They swing a bat at you!");
	        	}
	        	else {
	        		System.out.println("You hear bandits hiding!\n"
		    				+ "They swing a bat at you again!");
	        	}
	        	System.out.print("You have your fists. What would you like to do?\n"
						+ "1. Swing your fist.\n"
						+ "2. Ask this question: \" Why are you hitting me!!\"\n"
						+ "3. Run!\n"
						+ "Select your option: ");
	            while (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next();
	            }
	            option = scanner.nextInt();
	            
	            scanner.nextLine(); 
	            if (option < 1 || option > 3) {
	                System.out.println("Invalid option. Please enter a number between 1 and 3");
	            }
	        } while (option < 1 || option > 3);
	        
	        if(option == 2 || option == 3) {
	        	System.out.println("The bandits hit you and you die!");
	        	return 0;
	        }
		}
		System.out.println("You knocked out the last bandit!!");
		System.out.println("You won!");
		return 1;
	}
	
	public int quest2(Scanner scanner, Character character) {
		System.out.println("You enter the room");
		if(character.characterClass == "Fighter") {
			System.out.println("You are a fighter in a village.");
		}
		if(character.characterClass == "Wizard") {
			System.out.println("You are a wizard in a village");
		}
		if(character.characterClass == "Rogue") {
			System.out.println("You are a rogue in a village");
		}
		int skeletons = 40;
		character.setHP(20);
		System.out.println("The Skeletons are invading the village!!");
		for(int i = 0; i < 2; i++) {
			int option;
	        do {
	        	if(i == 0) {
	        	System.out.println("The skeletons come out and try to attack you!\n"
	        			+ "What will you do??");
	        	}
	        	else {
	        		System.out.println("You hear more skeletons hiding!\n"
		    				+ "They try to hit you!");
	        	}
	        	System.out.print("You have your (" + character.getWeapon() + "). What would you like to do?\n"
						+ "1. Swing your (" + character.getWeapon() + ").\n"
						+ "2. Swing your fist.\n"
						+ "3. Run!\n"
						+ "Select your option: ");
	            while (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next();
	            }
	            option = scanner.nextInt();
	            
	            scanner.nextLine(); 
	            if (option < 1 || option > 3) {
	                System.out.println("Invalid option. Please enter a number between 1 and 3");
	            }
	        } while (option < 1 || option > 3);
	        
	        if(option == 3) {
	        	System.out.println("The skeletons hit you and you die!");
	        	return 0;
	        }
	        skeletons = skeletons - character.getDamage(BadGuys.skeletons);
	        System.out.println(skeletons);
		}
		System.out.println("You knocked out the last bandit!!");
		System.out.println("You won!");
		return 1;
	}
}
