package game;

import java.util.Scanner;

public class QuestMethods {
	public int quest1(Scanner scanner, Character character) { // Defeat the Bandits
	    // Print initial room description
	    System.out.println("\nYou enter the room");

	    // Check character class and print corresponding description
	    if (character.characterClass.equals("Fighter")) {
	        System.out.println("You are a fighter in a dark room.");
	    } else if (character.characterClass.equals("Wizard")) {
	        System.out.println("You are a wizard in a dark room");
	    } else if (character.characterClass.equals("Rogue")) {
	        System.out.println("You are a rogue in a dark room");
	    }

	    // Set character's initial HP
	    character.setHP(20);

	    // Introduce the story
	    System.out.println("Once upon a time, in the kingdom of Crazies, there was a king named Bob the Just. His reign was marked by prosperity and peace, \n"
	            + "as he ruled with fairness and compassion, earning the love and respect of his subjects. \n"
	            + "However, not all were content under his rule.");

	    // Decrease character's HP
	    character.setHP(character.getHP() - 2);

	    // Encounter bandits in a loop
	    for (int i = 0; i < 3; i++) {
	        int option;
	        do {
	            // Print bandit encounter message
	            if (i == 0) {
	                System.out.println("You hear bandits hiding!\n"
	                        + "They swing a bat at you!");
	            } else {
	                System.out.println("You hear bandits hiding!\n"
	                        + "They swing a bat at you again!");
	            }
	            // Prompt user for action
	            System.out.print("You have your fists. What would you like to do?\n"
	                    + "1. Swing your fist.\n"
	                    + "2. Ask this question: \"Why are you hitting me!!\"\n"
	                    + "3. Run!\n"
	                    + "Select your option: ");

	            // Validate user input
	            while (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next();
	            }
	            option = scanner.nextInt();
	            
	            // Space out lines
	            System.out.println("");
	            
	            scanner.nextLine();
	            if (option < 1 || option > 3) {
	                System.out.println("Invalid option. Please enter a number between 1 and 3");
	            }
	        } while (option < 1 || option > 3);

	        // Process user's choice
	        if (option == 2 || option == 3) {
	            // If the user chooses to ask or run, they lose
	            System.out.println("The bandits hit you and you die!\n");
	            return 0;
	        }
	    }

	    // If the loop completes, the player has defeated the bandits
	    System.out.println("You knocked out the last bandit!!");
	    System.out.println("You won!");
	    return 1;
	}
	
	public int quest2(Scanner scanner, Character character) { // Defend the Village
	    // Print initial room description
	    System.out.println("\nYou enter the room");

	    // Check character class and print corresponding description
	    if (character.characterClass.equals("Fighter")) {
	        System.out.println("You are a fighter in a village.");
	    } else if (character.characterClass.equals("Wizard")) {
	        System.out.println("You are a wizard in a village");
	    } else if (character.characterClass.equals("Rogue")) {
	        System.out.println("You are a rogue in a village");
	    }

	    // Initialize variables
	    int skeleton;
	    character.setHP(20);

	    // Introduce the quest
	    System.out.println("The Skeletons are invading the village!! You see them attacking and tormenting the villagers! You have to save them!!\n"
	            + "They are going to die if you don't! You might get a prize from the mayor if you do!!\n"
	            + "There are 5 skeletons and each one has an unknown amount of HP. You must defeat each one to win the quest!\n"
	            + "Luckily they don't have anything besides their fists to hit you with. But you choose (" + character.getWeapon().printType() + ") and you"
	            + " may use that to destroy the skeletons!");

	    // Loop through encounters with skeletons
	    for (int i = 0; i < 5; i++) {
	        skeleton = 20;
	        int option;
	        do {
	            // Print skeleton encounter message
	            if (i == 0) {
	                System.out.println("\nThe skeletons come out and try to attack you!\n"
	                        + "What will you do??");
	            } else if (i != 0 && i != 4) {
	                System.out.println("\nYou see more skeletons doing everything they can to kill you!\n"
	                        + "They try to hit you!");
	            } else {
	                System.out.println("\nYou see one last skeleton! You must destroy it!");
	            }
	            // Prompt user for action
	            System.out.print("You have your (" + character.getWeapon().printType() + "). What would you like to do?\n"
	                    + "1. Swing your (" + character.getWeapon().printType() + ").\n"
	                    + "2. Swing your fist.\n"
	                    + "3. Run!\n"
	                    + "Select your option: ");

	            // Validate user input
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

	        // Process user's choice
	        if (option == 1) { // Swing Weapon
	            System.out.println("You swing your (" + character.getWeapon().getWeaponName() + ")!!");
	            skeleton -= character.getDamage(BadGuys.skeletons);
	            character.getWeapon().useWeapon();
	        }
	        if (option == 2) { // Swing Fist
	            if (character.getStrength() < 10) {
	                System.out.println("You swing your fist!\n"
	                        + "You hit the skeleton but you only do " + character.getFistDamage() + " points of damage because you are weak!\n"
	                        + "You get overwhelmed by the skeletons as they come to attack you and die!!");
	                skeleton -= (character.getFistDamage() * character.getStrength());
	                System.out.println("The skeleton you hit still has " + skeleton + " HP.\n"
	                        + "The skeleton as well as his friends team up and kill you!!");
	                return 0;
	            }
	            if (character.getStrength() >= 10) {
	                System.out.println("You are stronger than average!!\n"
	                        + "You hit the skeleton and it shatters to the ground!");
	                skeleton -= (character.getFistDamage() * character.getStrength());
	            }

	        }
	        if (option == 3) { // Run
	            System.out.println("The skeletons hit you as you are running away and you die!");
	            return 0;
	        }
	        if (i == 4) { // Knocked out all skeletons
	            System.out.println("You knocked out the last skeleton!! You won!\n"
	                    + "The mayor is so happy! He congratulated you!");
	            return 1;
	        }
	    }
	    return 0;
	}

	public int quest3(Scanner scanner, Character character) { // Save the king
	    // Print initial quest conditions
		int option = -1;
	    do {
	    	System.out.println("\nYou have put the bandits in their place and destroyed the skeletons! That was a lot of work!\n"
		            + "You are feeling super tired. What will you decide to do?");
		    System.out.print("You have your (" + character.getWeapon().getWeaponName() + "). What would you like to do?\n"
		            + "1. Take a rest day.\n"
		            + "2. Buy some coffee.\n"
		            + "3. Retire\n"
		            + "Select your option: ");

            // Validate user input
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

	    
	    // You take a rest day.
	    int option2 = -1;
	    if (option == 1) {
	        int complete = 0;
	        do {
	            do {
	            	System.out.print("\nYou decide to take a rest day. First you have to look for a hotel.\n"
		                    + "Which hotel would you like to stay at?\n"
		                    + "1. Expensive hotel (100 gems)\n"
		                    + "2. Normal hotel (50 gems)\n"
		                    + "3. Cheap hotel (25 gems)\n"
		                    + "4. No rest day :/\n"
		                    + "Select your option: ");

	                // Validate user input
	                while (!scanner.hasNextInt()) {
	                    System.out.println("Invalid input. Please enter a number.");
	                    scanner.next();
	                }
	                
	                option2 = scanner.nextInt();

	                scanner.nextLine();
	                if (option2 < 1 || option2 > 4) {
	                    System.out.println("Invalid option. Please enter a number between 1 and 3");
	                }
	            } while (option2 < 1 || option2 > 4);

	            if (option2 == 1) {
	                if (character.getGems() < 100) {
	                    System.out.println("\n" + character.getName() + " doesn't have enough gems to pay for the expensive hotel");
	                } else {
	                    character.spendGems(100);
	                    System.out.println("\nYou decide to take a rest day at the expensive hotel. You feel extremely rested.");
	                    complete = 1;
	                }
	                System.out.print("\nAfter your super relaxed night of rest you wake up to a village of panic! \n"
	                		+ "Someone informs you that the king is getting captured by the bandits you beat up durring the first quest!\n"
	                		+ "Their stronger and more powerful now! "
	                		+ "With more powerful weapons!!\n"
	                		+ "You rush to the scene and find the group of 6 bandits (They added another member to their team) carrying the King away.\n"
	                		+ "You chase after the king!");
	            }

	            if (option2 == 2) {
	                if (character.getGems() < 50) {
	                    System.out.println("\n" + character.getName() + " doesn't have enough gems to pay for the normal hotel");
	                } else {
	                    character.spendGems(50);
	                    System.out.println("\nYou decide to take a rest day at the normal hotel. You feel extremely rested.");
	                    complete = 1;
	                }
	                System.out.print("\nAfter your relaxed night of rest you wake up to a village of panic! \n"
	                		+ "Someone informs you that the king is getting captured by the bandits you beat up durring the first quest!\n"
	                		+ "Their stronger and more powerful now! "
	                		+ "With more powerful weapons!!\n"
	                		+ "You rush to the scene and find the group of 6 bandits (They added another member to their team) carrying the King away.\n"
	                		+ "You chase after the king!");
	            }

	            if (option2 == 3) {
	                if (character.getGems() < 25) {
	                    System.out.println("\n" + character.getName() + " doesn't have enough gems to pay for the cheap hotel");
	                } else {
	                    character.spendGems(25);
	                    System.out.println("\nYou decide to take a rest day at the cheap hotel. You feel extremely rested.");
	                    complete = 1;
	                }
	                System.out.print("\nAfter your night of rest you wake up to a village of panic! \n"
	                		+ "Someone informs you that the king is getting captured by the bandits you beat up durring the first quest!\n"
	                		+ "Their stronger and more powerful now! "
	                		+ "With more powerful weapons!!\n"
	                		+ "You rush to the scene and find the group of 6 bandits (They added another member to their team) carrying the King away.\n"
	                		+ "You chase after the king!");
	            }

	            if (option2 == 4) {
	                System.out.println("You really don't need a rest day.");
	                complete = 1;
	                System.out.print("\nYou find a village of panic! \n"
	                		+ "Someone informs you that the king is getting captured by the bandits you beat up durring the first quest!\n"
	                		+ "Their stronger and more powerful now! "
	                		+ "With more powerful weapons!!\n"
	                		+ "You rush to the scene and find the group of 6 bandits (They added another member to their team) carrying the King away.\n"
	                		+ "You chase after the king!");
	            }
	        } while (complete != 1);
	    }
	    
	    // You buy coffee
	    if (option == 2) {
	        int complete = 0;
	        do {
	            
	            option2 = -1;
	            do {
	            	System.out.println("You decide to buy coffee. First you have to choose a coffee shop.\n"
		                    + "Which coffee shop would you like to go to?\n"
		                    + "1. Expensive coffee shop (50 gems)\n"
		                    + "2. Normal coffee shop (25 gems)\n"
		                    + "3. Cheap coffee shop (20 gems)"
		                    + "4. No coffee :/\n"
		                    + "Select your option: ");

	                // Validate user input
	                while (!scanner.hasNextInt()) {
	                    System.out.println("Invalid input. Please enter a number.");
	                    scanner.next();
	                }
	                option2 = scanner.nextInt();

	                scanner.nextLine();
	                if (option2 < 1 || option2 > 4) {
	                    System.out.println("Invalid option. Please enter a number between 1 and 3");
	                }
	            } while (option2 < 1 || option2 > 4);
	            

	            if (option2 == 1) {
	                if (character.getGems() < 50) {
	                    System.out.println(character.getName() + " doesn't have enough gems to buy coffee from the expensive coffee shop.");
	                } else {
	                    character.spendGems(50);
	                    System.out.println("You decide to buy coffee from the expensive coffee shop. You feel refreshed.");
	                    complete = 1;
	                }
	                System.out.print("\nAfter your full cup of coffee you look up to a village of panic!\n"
	                		+ "Someone informs you that the king is getting captured by the bandits you beat up durring the first quest!\n"
	                		+ "Their stronger and more powerful now! "
	                		+ "With more powerful weapons!!\n"
	                		+ "You rush to the scene and find the group of 6 bandits (They added another member to their team) carrying the King away.\n"
	                		+ "You chase after the king!");
	            }

	            if (option2 == 2) {
	                if (character.getGems() < 25) {
	                    System.out.println(character.getName() + " doesn't have enough gems to buy coffee from the normal coffee shop.");
	                } else {
	                    character.spendGems(25);
	                    System.out.println("You decide to buy coffee from the normal coffee shop. You feel refreshed.");
	                    complete = 1;
	                }
	                System.out.print("\nAfter your cup of coffee you look up to a village of panic!\n"
	                		+ "Someone informs you that the king is getting captured by the bandits you beat up durring the first quest!\n"
	                		+ "Their stronger and more powerful now! "
	                		+ "With more powerful weapons!!\n"
	                		+ "You rush to the scene and find the group of 6 bandits (They added another member to their team) carrying the King away.\n"
	                		+ "You chase after the king!");
	            }

	            if (option2 == 3) {
	                if (character.getGems() < 20) {
	                    System.out.println(character.getName() + " doesn't have enough gems to buy coffee from the cheap coffee shop.");
	                } else {
	                    character.spendGems(20);
	                    System.out.println("You decide to buy coffee from the cheap coffee shop. You feel sorta refreshed.");
	                    complete = 1;
	                }
	                System.out.print("\nAfter your horrible coffee you look up to a village of panic!\n"
	                		+ "Someone informs you that the king is getting captured by the bandits you beat up durring the first quest!\n"
	                		+ "Their stronger and more powerful now! "
	                		+ "With more powerful weapons!!\n"
	                		+ "You rush to the scene and find the group of 6 bandits (They added another 3 members to their team) carrying the King away.\n"
	                		+ "You chase after the king!");
	            }

	        } while (complete != 1);
	    }
	    // You retire
	    if (option == 3) {
	        System.out.print("You decide to retire. This leaves you with little to no money to live off for the rest of your life.\n"
	                + "You only live to 53 because you didn't save enough gems to support your luxurious lifestyle.\n"
	                + "You fail the quest.");
	        return 0;
	    }
	    
	    // Knock out all the bandits
	    int option3 = -1;
	    System.out.println("");
	    if(character.getDexterity() < 10) {
            do {
            	System.out.print("You have a hard time catching up!\n"
    	    			+ "You must choose an option to help you catch up!\n"
    	    			+ "1. Steal a horse.\n"
    	    			+ "2. Give up :/\n"
    	    			+ "Select an option: ");

                // Validate user input
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
                option3 = scanner.nextInt();

                scanner.nextLine();
                if (option3 < 1 || option3 > 2) {
                    System.out.println("Invalid option. Please enter a number between 1 and 3");
                }
            } while (option3 < 1 || option3 > 2);
	    	if(option3 == 1) {
	    		System.out.println("\nYou stole the horse!!!\n"
	    				+ "After several minutes of chasing the bandits you catch up!");
	    	}
	    	if(option3 == 2) {
	    		System.out.println("You couldn't catch up and fail the quest! You might as well give up.");
	    		return 0;
	    	}
	    }
	    
	    if(character.getDexterity() >= 10) {
	    	System.out.println("You catch up to the bandits extremely fast!\n"
	    			+ "You ask them to stop several times and they just laugh and keep running.\n"
	    			+ "You feel obligated to do something about this unexpected turn of events!\n");
	    }
	    
		for(int i = 0; i < 6; i++) {
			int banditHealth = 20;
			int option4 = -1;
            do {
            	if(i == 0) {
    	        	System.out.println("You run up towards them!\n"
    	    				+ "They swing a knife at you!");
    	        	}
    	        	else {
    	        		System.out.println("\nThey swing a knife at you again!");
    	        	}
    	        	System.out.print("You have your fists and a " + character.getWeapon().printType() + ". What would you like to do?\n"
    						+ "1. Swing your fist.\n"
    						+ "2. Ask this question: \" Why are you hitting me!!\"\n"
    						+ "3. Swing your " + character.getWeapon().printType() + "!!\n"
    						+ "Select your option: ");

                // Validate user input
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
                option4 = scanner.nextInt();

                scanner.nextLine();
                if (option4 < 1 || option4 > 3) {
                    System.out.println("Invalid option. Please enter a number between 1 and 3");
                }
            } while (option4 < 1 || option4 > 3);
	        
	        if(option4 == 1) {
	        	System.out.println("You swing your fist at them in hopes to knock them out.");
	        	banditHealth -= character.getStrength()*2;
	        	if(banditHealth <= 0) {
	        		System.out.println("You knocked a bandit out!");
	        	}
	        	if(banditHealth > 0) {
	        		System.out.println("You couldn't knock out the bandit.\n"
	        				+ "You die!");
	        		return 0;
	        	}
	        	
	        }
	        
	        if(option4 == 2) {
	        	System.out.println("The bandits hit you and you die!");
	        	return 0;
	        }
	        
	        if(option4 == 3) {
	        	System.out.println("You swing your weapon at them in hopes to knock them out.");
	        	banditHealth -= character.getWeapon().getStat(game.BadGuys.zombies);
	        	if(banditHealth <= 0) {
	        		System.out.println("You knocked a bandit out!");
	        	}
	        	if(banditHealth > 0) {
	        		System.out.println("You couldn't knock out the bandit.\n"
	        				+ "You die!");
	        		return 0;
	        	}
	        	
	        }
	        
		}
		System.out.println("You knocked out the last bandit!!");
		System.out.println("You won!");
		return 1;
    }

	public int quest4(Scanner scanner, Character character) { // Defeat the Evil Knight
		// Initial quest conditions
	    System.out.println("On the way back from saving the king from the bandits, you come across an Evil Knight!\n"
	            + "He has so much armor and the biggest sword you have ever seen!\n"
	            + "In order to save you and the king's lives, you must kill this Evil Knight!");

	    int EvilKnightHealth = 100;
	    character.setHP(75);
	    int characterHealth = character.getHP();
	    int characterProtection = character.getProtectionAmount(game.BadGuys.evilKnight);

	    while (EvilKnightHealth > 0 && characterHealth > 0) {
	        int option = -1;
		    do {
		        // Display options for the player
		    	System.out.println("Choose your action:\n"
		    			+ "1. Attack\n"
		    			+ "2. Defend\n"
		    			+ "Select your option: ");

	            // Validate user input
	            while (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next();
	            }
	            option = scanner.nextInt();
	            
	            scanner.nextLine();
	            if (option < 1 || option > 2) {
	                System.out.println("Invalid option. Please enter a number between 1 and 2");
	            }
	        } while (option < 1 || option > 2);

	        switch (option) {
	            case 1:
	                // Player chooses to attack
	                int damageDealt = (int) (Math.random() * 20) + 10; // Random damage between 10 and 30
	                EvilKnightHealth -= damageDealt;
	                System.out.println("You attack the Evil Knight and deal " + damageDealt + " damage.");
	                break;
	            case 2:
	                // Player chooses to defend
	                System.out.println("You brace yourself and prepare to defend against the Evil Knight's attack.");
	                // Implement logic for defending (you can reduce the damage taken in this case)
	                break;
	            default:
	                System.out.println("Invalid option! Choose again.");
	                break;
	        }

	        // Evil Knight attacks
	        int damageTaken = (int) (Math.random() * 20); // Random damage between 0 and 20
	        characterHealth -= damageTaken;
	        System.out.println("The Evil Knight strikes you and deals " + damageTaken + " damage.");

	        // Check if player or Evil Knight is defeated
	        if (characterHealth <= 0) {
	            System.out.println("\nYou have been defeated by the Evil Knight. The king's fate remains uncertain.");
	            return 0; // Failure
	        } else if (EvilKnightHealth <= 0) {
	            System.out.println("\nYou have defeated the Evil Knight! The king is safe.");
	            return 1; // Success
	        }

	        // Display remaining health
	        System.out.println("Your health: " + characterHealth);
	        System.out.println("Evil Knight's health: " + EvilKnightHealth);
	    }

	    return 0; // This line should never be reached, but added for completeness
	}

	public int quest5(Scanner scanner, Character character) { // Slay the Dragon
	    System.out.println("You are faced with a mighty dragon guarding the king's treasure hoard!\n"
	            + "To ensure the safety of the kingdom, you must slay the dragon.");

	    int dragonHealth = 150;
	    int characterHealth = character.getHP();
	    int characterAttack = character.getStrength(); // Assuming strength affects attack damage

	    // Determine if the player can approach the dragon stealthily based on dexterity and intelligence
	    boolean stealthApproach = character.getDexterity() >= 15 && character.getIntelligence() >= 12;

	    if (stealthApproach) {
	        System.out.println("You use your agility and cunning to sneak up on the dragon...");
	        dragonHealth -= 50; // Dragon starts with less health due to the surprise attack
	    }

	    // Determine if the player can outsmart the dragon based on intelligence
	    boolean outsmartDragon = character.getIntelligence() >= 15;

	    while (dragonHealth > 0 && characterHealth > 0) {
	        int option = -1;
		    do {
		    	// Display options for the player
		    	System.out.println("Choose your action:\n"
		    			+ "1. Attack\n"
		    			+ "2. Defend");
		        // If the player can outsmart the dragon, provide an additional option
		        if (outsmartDragon) {
		            System.out.println("3. Use your intelligence to outsmart the dragon");
		        }
		        System.out.print("Select your option: ");

	            // Validate user input
	            while (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next();
	            }
	            option = scanner.nextInt();
	            
	            scanner.nextLine();
	            System.out.println("");
	            if (option < 1 || option > 3) {
	                System.out.println("Invalid option. Please enter a number between 1 and 3");
	            }
	        } while (option < 1 || option > 3);
	        
	        switch (option) {
	            case 1:
	                // Player chooses to attack
	                int damageDealt = characterAttack + (int) (Math.random() * 10) + 5; // Random damage between 5 and 15
	                dragonHealth -= damageDealt;
	                System.out.println("You attack the dragon and deal " + damageDealt + " damage.");
	                break;
	            case 2:
	                // Player chooses to defend
	                System.out.println("You prepare to defend against the dragon's attack.");
	                // Implement logic for defending (you can reduce the damage taken in this case)
	                break;
	            case 3:
	                // Player chooses to outsmart the dragon
	                if (outsmartDragon) {
	                    System.out.println("You use your intelligence to outsmart the dragon...");

	                    // Implement logic for outsmarting the dragon
	                    // For example, the player could trick the dragon into exposing a vulnerability
	                    System.out.println("You trick the dragon into revealing its weak spot!");

	                    // Inflict additional damage due to the dragon's vulnerability
	                    dragonHealth -= 30;
	                } else {
	                    System.out.println("You cannot use your intelligence to outsmart the dragon.");
	                }
	                break;
	            default:
	                System.out.println("Invalid option! Choose again.");
	                break;
	        }

	        // Dragon attacks
	        int damageTaken = (int) (Math.random() * 5); // Random damage between 0 and 5
	        characterHealth -= damageTaken;
	        System.out.println("The dragon breathes fire and deals " + damageTaken + " damage.");

	        // Check if player or dragon is defeated
	        if (characterHealth <= 0) {
	            System.out.println("You have been incinerated by the dragon's flames. The kingdom falls into darkness.");
	            return 0; // Failure
	        } else if (dragonHealth <= 0) {
	            System.out.println("You have slain the dragon! The kingdom is safe, and the king's treasure is yours.");
	            return 1; // Success
	        }

	        // Display remaining health
	        System.out.println("Your health: " + characterHealth);
	        System.out.println("Dragon's health: " + dragonHealth);
	    }

	    return 0; // This line should never be reached, but added for completeness
	}

}
