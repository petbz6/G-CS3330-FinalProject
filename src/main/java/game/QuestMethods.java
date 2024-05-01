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
		int skeleton;
		character.setHP(20);
		System.out.println("The Skeletons are invading the village!! You see them attacking and tormenting the villagers! You have to save them!!\n"
				+ "They are going to die if you don't! You might get a prize from the mayor if you do!!\n"
				+ "There are 5 skeletons and each one has an unknown amount of HP. You must defeat each one to win the quest!\n"
				+ "Luckily they don't have anything besides their fists to hit you with. But you choose (" + character.getWeapon() + ") and you"
						+ " may use that to destroy the skeletons!");
		for(int i = 0; i < 5; i++) {
			skeleton = 20;
			int option;
	        do {
	        	if(i == 0) {
	        	System.out.println("The skeletons come out and try to attack you!\n"
	        			+ "What will you do??");
	        	}
	        	else if(i != 0 & i != 4){
	        		System.out.println("You see more skeletons doing everything they can to kill you!\n"
		    				+ "They try to hit you!");
	        	}
	        	else {
	        		System.out.println("You see one last skeleton! You must destroy it!");
	        	}
	        	System.out.print("You have your (" + character.getWeapon().getWeaponName() + "). What would you like to do?\n"
						+ "1. Swing your (" + character.getWeapon().getWeaponName() + ").\n"
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
	        
	        
	        if(option == 1) {
	        	System.out.println("You swing your (" + character.getWeapon() + ")!!");
		        skeleton = skeleton - character.getDamage(BadGuys.skeletons);
		        character.getWeapon().useWeapon();
	        }
	        if(option == 2) {
	        	if(character.getStrength() < 10) {
	        		System.out.println("You swing your fist!\n"
		        			+ "You hit the skeleton but you only do " + String.valueOf(character.getFistDamage()) + " points of damage because you are weak!\n"
		        			+ "You get overwhelmed by the skeletons as they come to attack you and die!!");
		        	skeleton = skeleton - (character.getFistDamage()*character.getStrength());
		        	System.out.println("The skeleton you hit still has " + String.valueOf(skeleton) + " HP.\n"
		        			+ "The skeleton as well as his friends team up and kill you!!");
		        	return 0;
	        	}
	        	if(character.getStrength() >= 10) {
	        		System.out.println("You are stronger than average!!\n"
	        				+ "You hit the skeleton and it shatters to the ground!");
	        		skeleton = skeleton - (character.getFistDamage()*character.getStrength());
	        	}
	        	
	        }
	        if(option == 3) {
	        	System.out.println("The skeletons hit you as you are running away and you die!");
	        	return 0;
	        }
	        if(i == 4) {
	        	System.out.println("You knocked out the last skeleton!! You won!\n"
	    				+ "The mayor is so happy! He congradulated you!");
	    		return 1;
	        }
		}
		return 0;
	}
}
