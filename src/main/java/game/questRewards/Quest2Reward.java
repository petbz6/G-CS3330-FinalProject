package game.questRewards;

import game.Character;
import game.items.*;

public class Quest2Reward extends AbstractQuestReward {
    @Override
    public void applyReward(int rewardChoice, Character character) {
    	switch (rewardChoice) {
        case 1:
            character.addProtectant(new game.items.BroadShield());
            System.out.println("Added Broad Shield to inventory.");
            break;
        case 2:
            character.addProtectant(new game.items.HelmOfJustice());
            System.out.println("Added Helm of Justice to inventory.");
            break;
        case 3:
            character.addProtectant(new game.items.GlovesOfSalvation());
            System.out.println("Added Gloves of Salvation to inventory.");
            break;
        default:
            System.out.println("Invalid reward choice.");
            break;
    	}
    }
}
