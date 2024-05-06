package game;

import java.util.List;
import java.util.Scanner;

public class QuestStatus {
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
	    
	    System.out.println("Press any key to return to the quest menu...");
	    if (scanner.hasNextLine()) { 
	        QuestMenu.displayQuests(scanner, character); 
	    } else {
	        System.out.println("No input available. Exiting quest status view.");
	    }
	}

    
    // Displays a message detailing the outcome of the each quest
	public static String questOutcomeMessage(String questName) {
	    switch (questName) {
	        case "Defeat the Bandits":
	            return "\nYou defeated the bandits. Although no one was present to witness your" 
	            		+ "\ndeeds, you gained a great sense of confidence in your abilities.";
	        case "Defend the Village":
	            return "\nYou successfully defended the village against the skeletal invaders. "
	            		+ "\nAll of the citizens gathered to sing praises of your bravery and"
	            		+ "\nthe mayor himself rewarded you for your efforts.";
	        case "Save the King":
	        	return "\nAfter saving the life of the King, you became a hero to the kingdom, "
	        			+ "\nbut you had no time to rest, for evil still prowls the lands. "
	        			+ "\nYou must continue your journey and prove yourself worthy of the title of hero.";
	        case "Defeat the Evil Knight":
	        	return "\nThe duel with the Evil Knight shook your resolve, yet you stand triumphant! "
	        			+ "\nWhat possessed the Knight to turn to darkness eludes you, but deep down "
	        			+ "\nyou know the same could happen to you if your not careful.";
	        case "Slay the Dragon":
	        	return "\nWith the slaying of the great dragon, you have solidified your place in "
	        			+ "\nthe history books. Such a victory will be told of for ages. The king, fortunate "
	        			+ "\nfor the return of his treasure rewards you with land and enough gold and gems to last forever."; 
	        default:
	            return "";
	    }
	}
}
