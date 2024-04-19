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
    public static void displayQuests(Scanner scanner) {
        List<Quest> quests = createQuests();

        System.out.println("\nAvailable Quests:");
        for (int i = 0; i < quests.size(); i++) {
            Quest quest = quests.get(i);
            System.out.println((i + 1) + ". " + quest.getName());
        }

        int choice;
        // Prompt for player to choose a quest
        do {
            System.out.print("Enter the number of the quest you would like to choose: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 
            if (choice < 1 || choice > quests.size()) {
                System.out.println("Invalid choice. Please enter a number between 1 and " + quests.size() + ".");
            }
        } while (choice < 1 || choice > quests.size());
        
        // Gets the quest selected by the player
        Quest selectedQuest = quests.get(choice - 1);
        
    }
}