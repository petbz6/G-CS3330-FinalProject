package game.questItemRewards;

import game.Character;

public abstract class AbstractQuestItemReward {
	
    public abstract void applyReward(int rewardChoice, Character character);
}
