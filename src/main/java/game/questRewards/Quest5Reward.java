package game.questRewards;

import game.Character;
import game.items.*;

public class Quest5Reward extends AbstractQuestReward {
    @Override
    public void applyReward(int rewardChoice, Character character) {
    	switch (rewardChoice) {
	        case 1:
	            character.addUnique(new game.items.AmuletOfFire());
	            System.out.println("Added Amulet of Fire to inventory.");
	            break;
	        case 2:
	            character.addWeapon(new game.items.InfernoStaff());
	            System.out.println("Added Inferno Staff to inventory.");
	            break;
	        case 3:
	            character.addWeapon(new game.items.GreatSwordOfDestruction());
	            System.out.println("Added Greatsword of Destruction to inventory.");
	            break;
	        default:
	            System.out.println("Invalid reward choice.");
	            break;
	    }
    }
}
