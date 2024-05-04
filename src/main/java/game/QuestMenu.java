package game;

import java.util.ArrayList; 
import java.util.List;
import java.util.Scanner;
import game.questRewards.*;

public class QuestMenu {

    // Stores the quest list as a class variable
    private static List<Quest> quests = questLog();

    // List of available quests, each with their own rewards and experience points
    private static List<Quest> questLog() {
        List<Quest> quests = new ArrayList<>();
        quests.add(new Quest("Defeat the Bandits", List.of("Short Sword", "Battle Axe", "Warhammer"), 50, 50));
        quests.add(new Quest("Defend the Village", List.of("Broad Shield", "Helm of Justice", "Gloves of Salvation"), 60, 100));
        quests.add(new Quest("Save the King", List.of("Boots of Swiftness", "Ring of Protection", "Cloak of Invisibility"), 75, 150));
        quests.add(new Quest("Defeat the Evil Knight", List.of("Chestplate of Fortitude", "Cowl of Shadows", "Darkblade"), 100, 200));
        quests.add(new Quest("Slay the Dragon", List.of("Amulet of Fire", "Inferno Staff", "Greatsword of Destruction"), 200, 250));

        return quests;
    }

    public static void displayQuests(Scanner scanner, Character character) {
        // Get the list of quests from the class variable
        List<Quest> quests = QuestMenu.quests;

        System.out.println("\nAvailable Quests:");
        for (int i = 0; i < quests.size(); i++) {
            Quest quest = quests.get(i);
            displayQuestProgression(i, quest, quests);
        }

        // Option 6: View Quest Status
        System.out.println("6. View Quest Status");
        // Option 7: Back to Character Menu
        System.out.println("7. Back to Character Menu");

        int questChoice;
        do {
            System.out.print("\nEnter the number of the quest you would like to choose (or 6 to view quest questStatus, or 7 to return to the character menu): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            questChoice = scanner.nextInt();

            scanner.nextLine();
            if (questChoice < 1 || questChoice > quests.size() + 2) {
                System.out.println("Invalid quest choice. Please enter a number between 1 and " + (quests.size() + 2) + ".");
            }
        } while (questChoice < 1 || questChoice > quests.size() + 2);

        if (questChoice == 6) {
            viewQuestStatus(scanner, character);
            return; 
        } else if (questChoice == 7) {
            CharacterMenu.displayCharacterMenu(scanner, character); 
            return;
        }

        Quest selectedQuest = quests.get(questChoice - 1);
        if (selectedQuest.isCompleted()) {
            System.out.println("Already Completed!");
            displayQuests(scanner, character);
            return;
        }
        switch (questChoice) {
            case 1:
                QuestMethods quest1 = new QuestMethods();
                if (quest1.quest1(scanner, character) == 1) {
                    questCompletedMenu(scanner, selectedQuest, character, questChoice);
                } else {
                    System.out.println("You failed the first quest!");
                }
                return; 
            case 2:
                QuestMethods quest2 = new QuestMethods();
                if (quest2.quest2(scanner, character) == 1) {
                    questCompletedMenu(scanner, selectedQuest, character, questChoice);
                } else {
                    System.out.println("You failed the first quest!");
                }
                return; 
            // Add cases for other quests
            case 3:
            	QuestMethods quest3 = new QuestMethods();
                if (quest3.quest3(scanner, character) == 1) {
                    questCompletedMenu(scanner, selectedQuest, character, questChoice);
                } else {
                    System.out.println("You failed the first quest!");
                }
                return; 
            case 4:
            	QuestMethods quest4 = new QuestMethods();
                if (quest4.quest4(scanner, character) == 1) {
                    questCompletedMenu(scanner, selectedQuest, character, questChoice);
                } else {
                    System.out.println("You failed the first quest!");
                }
                return; 
            case 5:
            	QuestMethods quest5 = new QuestMethods();
                if (quest5.quest5(scanner, character) == 1) {
                    questCompletedMenu(scanner, selectedQuest, character, questChoice);
                } else {
                    System.out.println("You failed the first quest!");
                }
                return; 
            default:
                System.out.println("Invalid quest choice.");
        }
    }

    // After combat (if player successfully wins combat), they will have completed the quest
    // The player will be prompted to select from the available rewards
    public static void questCompletedMenu(Scanner scanner, Quest selectedQuest, Character character, int questChoice) {
        System.out.println("\nQuest Completed!");

        // Marks current quest as completed
        Quest currentQuest = quests.get(questChoice - 1);
        currentQuest.setCompleted(true);
        handleXpReward(currentQuest, character);
        handleGemsReward(currentQuest, character);

        System.out.println("\nThe following rewards are available:");
        List<String> rewards = selectedQuest.getRewards();

        // Displays available rewards, assigning a number to each
        for (int i = 0; i < rewards.size(); i++) {
            System.out.println((i + 1) + ". " + rewards.get(i));
        }

        int rewardChoice;
        // Prompt for player to choose reward
        do {
            System.out.print("Choose your reward: ");
            while (!scanner.hasNextInt()) {
                // Handle non-numerical input
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            // Gets the reward choice
            rewardChoice = scanner.nextInt();
            scanner.nextLine();

            // Handles if numerical input falls outside the number of choices
            if (rewardChoice < 1 || rewardChoice > rewards.size()) {
                System.out.println("Invalid input. Please enter a number between 1 and " + rewards.size() + ".");
            }
        } while (rewardChoice < 1 || rewardChoice > rewards.size());

        // Handle the chosen reward 
        if (rewardChoice >= 1 && rewardChoice <= rewards.size()) {
            String selectedReward = rewards.get(rewardChoice - 1);
            selectedQuest.setSelectedReward(selectedReward); 
            handleEquipmentReward(scanner, selectedQuest, rewardChoice, character);
        }

        // After displaying the reward choice, display the quest menu
        displayQuests(scanner, character);
    }
    
    // Handles the reward selection by the player for each quest
    public static void handleEquipmentReward(Scanner scanner, Quest selectedQuest, int rewardChoice, Character character) {
        List<String> rewards = selectedQuest.getRewards();
        String selectedReward = rewards.get(rewardChoice - 1);
        System.out.println("You have chosen: " + selectedReward);

        String questName = selectedQuest.getQuestName();
        AbstractQuestReward questReward;

        switch (questName) {
            case "Defeat the Bandits":
                questReward = new Quest1Reward();
                break;
            case "Defend the Village":
            	questReward = new Quest2Reward();
            	break;
            case "Save the King":
            	questReward = new Quest3Reward();
            	break;
            case "Defeat the Evil Knight":
            	questReward = new Quest4Reward();
            	break;
            case "Slay the Dragon":
            	questReward = new Quest5Reward();
            	break;
            default:
                System.out.println("Invalid quest choice.");
                return;
        }

        questReward.applyReward(rewardChoice, character);
        QuestMenu.displayQuests(scanner, character);
    }

    // Handles XP rewards from quests
    private static void handleXpReward(Quest selectedQuest, Character character) {
        // Gets experience reward associated with the quest
        int xpReward = selectedQuest.getXpReward();
        // Displays how much experience gained
        System.out.println("You gained " + xpReward + " experience points.");
        // Adds the experience points to the character level
        character.gainXP(xpReward);
        System.out.println("Current Level: " + character.getLevel());
    }

    // Handles gems reward from quests
    private static void handleGemsReward(Quest selectedQuest, Character character) {
        // Get gems reward associated with the quest
        int gemsReward = selectedQuest.getGemReward();
        // Display how many gems received
        System.out.println("You received " + gemsReward + " gems.");
        // Add the gems reward to the character's gem count
        character.addGems(gemsReward);
    }

    
    // Menu option that displays whether or not a quest has been completed
    // Also displays the reward chosen by the player, the experience gained, and some dialogue pertaining to the outcome of the quest
    public static void viewQuestStatus(Scanner scanner, Character character) {
        List<Quest> quests = QuestMenu.quests;

        System.out.println("\nQuest Status:");
        for (Quest quest : quests) {
            String questStatus = quest.isCompleted() ? "Completed" : "Incomplete";
            String questOutcome = quest.isCompleted() ? questOutcomeMessage(quest.getQuestName()) : "";
            String rewardChoice = quest.isCompleted() && !quest.getSelectedReward().isEmpty() ?
                    "Reward Received: " + quest.getSelectedReward() : "";
            int completedQuestXP = quest.isCompleted() ? quest.getXpReward() : 0;
            int gemsReward = quest.isCompleted() ? quest.getGemReward() : 0; 

            System.out.println("Quest Name: " + quest.getQuestName());

            System.out.println("Status: " + questStatus);
            if (quest.isCompleted()) {
                System.out.println("Outcome: " + questOutcome);
                System.out.println(rewardChoice);
                System.out.println("Experience Gained: " + completedQuestXP);
                System.out.println("Received Gems: " + gemsReward); 
            }
            System.out.println();
        }

        // After displaying quest status, go back to the quest menu
        displayQuests(scanner, character);
    }


	// Part of Quest Status
    // Displays a message detailing the outcome of the quest
	private static String questOutcomeMessage(String questName) {
	    switch (questName) {
	        case "Defeat the Bandits":
	            return "\nYou defeated the bandits. Although no one was present to witness your"
	            		+ "\ndeeds, you gained a great sense of confidence in your abilities.";
	        case "Defend the Village":
	            return "\nYou successfully defended the village against the skeletal invaders. "
	            		+ "\nAll of the citizens gathered to sing praises of your bravery and"
	            		+ "\nthe mayor himself rewarded you for your efforts.";
	        case "Save the King":
	        	return "(INSERT)";
	        case "Defeat the Evil Knight":
	        	return "(INSERT)";
	        case "Slay the Dragon":
	        	return "INSERT";
	        default:
	            return "";
	    }
	}
	
	// Quest Progression
	private static void displayQuestProgression(int index, Quest quest, List<Quest> quests) {
	    // Player must complete quests in order. If the previous quest is not completed, the next one is set to locked
	    if (quest.isCompleted() || index == 0 || quests.get(index - 1).isCompleted()) {
	        System.out.println((index + 1) + ". " + quest.getQuestName());
	    } else {
	        System.out.println((index + 1) + ". " + quest.getQuestName() + " 🔒");
	    }
	}
}