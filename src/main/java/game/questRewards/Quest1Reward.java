package game.questRewards;

import game.Character;
import game.items.*;

public class Quest1Reward extends AbstractQuestReward {
    @Override
    public void applyReward(int rewardChoice, Character character) {
        switch (rewardChoice) {
            case 1:
                character.addWeapon(new ShortSword());
                System.out.println("Added Short Sword to inventory.");
                break;
            case 2:
                character.addWeapon(new BattleAxe());
                System.out.println("Added Battle Axe to inventory.");
                break;
            case 3:
                character.addWeapon(new Warhammer());
                System.out.println("Added Warhammer to inventory.");
                break;
            default:
                System.out.println("Invalid reward choice.");
                break;
        }
    }
}
