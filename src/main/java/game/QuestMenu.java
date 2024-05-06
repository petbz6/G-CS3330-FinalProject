package game;

import java.util.ArrayList;    
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import game.questItemRewards.*;

public class QuestMenu {

    // Stores the quest list as a class variable
    public static List<Quest> quests = questLog();

    // List of available quests, each with their own rewards and experience points
    public static List<Quest> questLog() {
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
            questProgression(i, quest, quests);
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
                scanner.nextLine(); 
            }
            questChoice = scanner.nextInt();
            try {
                scanner.nextLine(); 
            } catch (Exception e) { 
                return; 
            }
            if (questChoice < 1 || questChoice > quests.size() + 2) {
                System.out.println("Invalid quest choice. Please enter a number between 1 and " + (quests.size() + 2) + ".");
            }
        } while (questChoice < 1 || questChoice > quests.size() + 2);

        if (questChoice == 6) {
            QuestStatus.viewQuestStatus(scanner, character);
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

        System.out.println("\nThe following rewards are available:");
        List<String> rewards = selectedQuest.getRewards();

        // Displays available rewards, assigning a number to each
        for (int i = 0; i < rewards.size(); i++) {
            System.out.println((i + 1) + ". " + rewards.get(i));
        }

        int rewardChoice;
        
        // Prompt for player to choose reward
        do {
            System.out.print("\nChoose your reward: ");
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
            handleQuestRewards(scanner, selectedQuest, rewardChoice, character);
        }

        // After displaying the reward choice, display the quest menu
        displayQuests(scanner, character);
    }
    
    // Quest Reward Handling
    // Handles the item, experience and gem rewards
    public static void handleQuestRewards(Scanner scanner, Quest selectedQuest, int rewardChoice, Character character) {
    	// Handle item reward
        List<String> rewards = selectedQuest.getRewards();
        String selectedReward = rewards.get(rewardChoice - 1);
        System.out.println("You have chosen: " + selectedReward);
        
        // Handle XP reward
        int xpReward = selectedQuest.getXpReward();
        System.out.println("\nYou gained " + xpReward + " experience points.");
        character.gainXP(xpReward);

        // Handle gems reward
        int gemsReward = selectedQuest.getGemReward();
        System.out.println("You received " + gemsReward + " gems.");
        character.addGems(gemsReward);

        String questName = selectedQuest.getQuestName();
        selectedQuest.setSelectedReward(selectedReward);
        AbstractQuestItemReward questReward;

        switch (questName) {
            case "Defeat the Bandits":
                questReward = new Quest1ItemReward();
                break;
            case "Defend the Village":
                questReward = new Quest2ItemReward();
                break;
            case "Save the King":
                questReward = new Quest3ItemReward();
                break;
            case "Defeat the Evil Knight":
                questReward = new Quest4ItemReward();
                break;
            case "Slay the Dragon":
                questReward = new Quest5ItemReward();
                break;
            default: 
                System.out.println("Invalid quest choice.");
                return;
        }

        questReward.applyReward(rewardChoice, character);

        // Display updated quest menu
        displayQuests(scanner, character);
    }

	
	// Quest Progression
	// Player must complete quests in order. If the previous quest is not completed, the next one is set to locked
	public static void questProgression(int index, Quest quest, List<Quest> quests) {
	    if (quest.isCompleted() || index == 0 || quests.get(index - 1).isCompleted()) {
	        System.out.println((index + 1) + ". " + quest.getQuestName());
	    } else {
	        System.out.println((index + 1) + ". " + quest.getQuestName() + " 🔒");
	    }
	}
}
