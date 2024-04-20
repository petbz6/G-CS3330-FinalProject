package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestMenu {

    // List of available quests, each with their own rewards and experience points
    public static List<Quest> createQuests() {
        List<Quest> quests = new ArrayList<>();
        quests.add(new Quest("Defeat the bandits", List.of("Short Sword", "Battle Axe", "Warhammer"), 50));
        quests.add(new Quest("Defend the village", List.of("Broad Shield", "Helm of Justice", "Gloves of Salvation"), 60));
        quests.add(new Quest("Save the king", List.of("Boots of Swiftness", "Ring of Protection", "Cloak of Invisibility"), 75));
        quests.add(new Quest("Defeat the evil knight", List.of("Chestplate of Fortitude", "Cowl of Shadows", "Darkblade"), 100));
        quests.add(new Quest("Slay the dragon", List.of("Amulet of Fire", "Inferno Staff", "Greatsword of Destruction"), 200));

        return quests;
    }

    // Method that displays the quests and handles quest selection by player
    public static void displayQuests(Scanner scanner, Character playerCharacter) {
        List<Quest> quests = createQuests();

        System.out.println("\nAvailable Quests:");
        for (int i = 0; i < quests.size(); i++) {
            Quest quest = quests.get(i);
            System.out.println((i + 1) + ". " + quest.getQuestName());
        }

        int questChoice;
        // Prompt for player to choose a quest
        do {
            System.out.print("\nEnter the number of the quest you would like to choose: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            questChoice = scanner.nextInt();
            scanner.nextLine(); 
            if (questChoice < 1 || questChoice > quests.size()) {
                System.out.println("Invalid questChoice. Please enter a number between 1 and " + quests.size() + ".");
            }
        } while (questChoice < 1 || questChoice > quests.size());
        
        // Gets the quest selected by the player
        Quest selectedQuest = quests.get(questChoice - 1);
        
        // Placeholder: Combat occurs after player selects a quest
        System.out.println("\n{PLACEHOLDER: Combat Occurs}\n");
        
        // Call the method for player to choose quest reward
        questCompletedMenu(scanner, selectedQuest, playerCharacter);
    }

 
    // After combat (if player successfully wins combat), they will have completed the quest
    // The player will be prompted to select from the available rewards
    public static void questCompletedMenu(Scanner scanner, Quest selectedQuest, Character playerCharacter) {
        System.out.println("Quest Completed!");

        handleXpReward(selectedQuest, playerCharacter);

        System.out.println("\nThe following rewards are available:");
        List<String> rewards = selectedQuest.getRewards();

        // Displays available rewards, assigning a number to each
        for(int i = 0; i < rewards.size(); i++) {
            System.out.println((i + 1) + ". " + rewards.get(i));
        }

        int rewardChoice;
        // Prompt for player to choose reward
        do {
            System.out.print("Choose your reward: ");
            while (!scanner.hasNextInt()) {
                // Handle non-numeric input
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            // Gets the reward choice
            rewardChoice = scanner.nextInt();
            scanner.nextLine();

            // Handles if numeric input falls outside the number of choices
            if (rewardChoice < 1 || rewardChoice > rewards.size()) {
                System.out.println("Invalid input. Please enter a number between 1 and " + rewards.size() + ".");
            }

        } while (rewardChoice < 1 || rewardChoice > rewards.size());

        // Handle the chosen reward 
        if (rewardChoice >= 1 && rewardChoice <= rewards.size()) {
            handleEquipmentReward(scanner, selectedQuest, rewardChoice);
        }
        
        // After completing the quest, go back to the quest menu
        displayQuests(scanner, playerCharacter);
    }
    
    // Handles the equipment reward choice by the player
    public static void handleEquipmentReward(Scanner scanner, Quest selectedQuest, int rewardChoice) {
    	// Gets the available rewards associated with the quest
        List<String> rewards = selectedQuest.getRewards();
        // Gets the reward chosen by the player
        String selectedReward = rewards.get(rewardChoice - 1);
        System.out.println("You have chosen: " + selectedReward);
    }

    // Handles the XP reward for the player and quest
    public static void handleXpReward(Quest selectedQuest, Character playerCharacter) {
    	// Gets experience reward associated with the quest
        int xpReward = selectedQuest.getXpReward(); 
        // Displays how much experience gained
        System.out.println("You gained " + xpReward + " experience points.");
        // Adds the experience points to the character level
        playerCharacter.gainXP(xpReward); 
        System.out.println("Current Level: " + playerCharacter.getLevel());
    }

}
