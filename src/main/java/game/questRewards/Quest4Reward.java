package game.questRewards;

import game.Character;
import game.items.*;

public class Quest4Reward extends AbstractQuestReward {
    @Override
    public void applyReward(int rewardChoice, Character character) {
    	switch (rewardChoice) {
	        case 1:
	            character.addProtectant(new game.items.ChestplateOfFortitude());
	            System.out.println("Added Chestplate of Fortitude to inventory.");
	            break;
	        case 2:
	            character.addUnique(new game.items.CowlOfShadows());
	            System.out.println("Added Cowl of Shadows to inventory.");
	            break;
	        case 3:
	            character.addWeapon(new game.items.Darkblade());
	            System.out.println("Added Darkblade to inventory.");
	            break;
	        default:
	            System.out.println("Invalid reward choice.");
	            break;
	    	}
    }
}
