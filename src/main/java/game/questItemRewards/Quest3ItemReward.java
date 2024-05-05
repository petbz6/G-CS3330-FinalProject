package game.questItemRewards;

import game.Character;
import game.items.*;

public class Quest3ItemReward extends AbstractQuestItemReward {
    @Override
    public void applyReward(int rewardChoice, Character character) {
    	switch (rewardChoice) {
	        case 1:
	            character.addUnique(new game.items.BootsOfSwiftness());
	            System.out.println("Added Boots of Swiftness to inventory.");
	            break;
	        case 2:
	            character.addProtectant(new game.items.RingOfProtection());
	            System.out.println("Added Ring of Protection to inventory.");
	            break;
	        case 3:
	            character.addUnique(new game.items.CloakOfInvisibility());
	            System.out.println("Added Cloak of Invisibilty to inventory.");
	            break;
	        default:
	            System.out.println("Invalid reward choice.");
	            break;
	    }
    }
}
