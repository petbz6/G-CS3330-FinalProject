package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestMenu {

    // Stores the quest list as a class variable
    private static List<Quest> quests = questLog();

    // List of available quests, each with their own rewards and experience points
    private static List<Quest> questLog() {
        List<Quest> quests = new ArrayList<>();
        quests.add(new Quest("Defeat the bandits", List.of("Short Sword", "Battle Axe", "Warhammer"), 50));
        quests.add(new Quest("Defend the village", List.of("Broad Shield", "Helm of Justice", "Gloves of Salvation"), 60));
        quests.add(new Quest("Save the king", List.of("Boots of Swiftness", "Ring of Protection", "Cloak of Invisibility"), 75));
        quests.add(new Quest("Defeat the evil knight", List.of("Chestplate of Fortitude", "Cowl of Shadows", "Darkblade"), 100));
        quests.add(new Quest("Slay the dragon", List.of("Amulet of Fire", "Inferno Staff", "Greatsword of Destruction"), 200));

        return quests;
    }

    public static void displayQuests(Scanner scanner, Character character) {
        // Get the list of quests from the class variable
        List<Quest> quests = QuestMenu.quests;

        System.out.println("\nAvailable Quests:");
        for (int i = 0; i < quests.size(); i++) {
            Quest quest = quests.get(i);
            // Quest Progression
            // Player must complete quests in order. If the previous quest is not completed, the next one is set to locked
            if (quest.isCompleted() || i == 0 || quests.get(i - 1).isCompleted()) {
                System.out.println((i + 1) + ". " + quest.getQuestName());
            } else {
                System.out.println((i + 1) + ". " + quest.getQuestName() + " 🔒");
            }
        }

        // Option 6: View Quest Status
        System.out.println("6. View Quest Status");
        // Option 7: Back to Character Menu
        System.out.println("7. Back to Character Menu");

        int questChoice;
        do {
            System.out.print("\nEnter the number of the quest you would like to choose (or 6 to view quest status, or 7 to return to the character menu): ");
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
            return; // Exit method as the status is displayed
        } else if (questChoice == 7) {
            CharacterMenu.displayCharacterMenu(scanner, character); // Return to Character Menu
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
                    character.gainXP(10);
                } else {
                    System.out.println("You failed the first quest!");
                }
                return; // Add return statement to exit the method after completing a quest
            case 2:
                QuestMethods quest2 = new QuestMethods();
                if (quest2.quest2(scanner, character) == 1) {
                    questCompletedMenu(scanner, selectedQuest, character, questChoice);
                    character.gainXP(10);
                } else {
                    System.out.println("You failed the first quest!");
                }
                return; // Add return statement to exit the method after completing a quest
            // Add cases for other quests
            default:
                System.out.println("Invalid quest choice.");
        }
    }

    // Menu option that displays whether or not a quest has been completed
    public static void viewQuestStatus(Scanner scanner, Character character) {
        List<Quest> quests = QuestMenu.quests;

        System.out.println("\nQuest Status:");
        for (Quest quest : quests) {
            System.out.println(quest.getQuestName() + " - " + (quest.isCompleted() ? "Completed" : "Incomplete"));
        }
        // After displaying quest status, go back to the quest menu
        displayQuests(scanner, character);
    }

    // After combat (if player successfully wins combat), they will have completed the quest
    // The player will be prompted to select from the available rewards
    public static void questCompletedMenu(Scanner scanner, Quest selectedQuest, Character character, int questChoice) {
        System.out.println("\nQuest Completed!");

        // Marks current quest as completed
        Quest currentQuest = quests.get(questChoice - 1);
        currentQuest.setCompleted(true);
        handleXpReward(currentQuest, character);

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
            handleEquipmentReward(scanner, selectedQuest, rewardChoice, character);

        }

        // After displaying the reward choice, display the quest menu
        displayQuests(scanner, character);
    }


    public static void handleEquipmentReward(Scanner scanner, Quest selectedQuest, int rewardChoice, Character character) {
        // Gets the available rewards associated with the quest
        List<String> rewards = selectedQuest.getRewards();
        // Gets the reward chosen by the player
        String selectedReward = rewards.get(rewardChoice - 1);
        System.out.println("You have chosen: " + selectedReward);
        
        // Process the reward choice
        switch (rewardChoice) {
            case 1:
            	character.addWeapon(new game.items.ShortSword());
                System.out.println("Added Short Sword to inventory.");
                break;
            case 2:
                
                character.addWeapon(new game.items.BattleAxe());
                System.out.println("Added Battle Axe to inventory.");
                break;
            case 3:
//        		character.addWeapon(new game.items.Warhammer());
//        		return;
            default:
                System.out.println("Invalid reward choice.");
                break;
        }
        
        // Loop back to the quest menu
        QuestMenu.displayQuests(scanner, character);
    }


    // Handles the XP reward for the player and quest
    public static void handleXpReward(Quest selectedQuest, Character character) {
        // Gets experience reward associated with the quest
        int xpReward = selectedQuest.getXpReward();
        // Displays how much experience gained
        System.out.println("You gained " + xpReward + " experience points.");
        // Adds the experience points to the character level
        character.gainXP(xpReward);
        System.out.println("Current Level: " + character.getLevel());
    }
}
