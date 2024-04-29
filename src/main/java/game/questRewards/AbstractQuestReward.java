package game.questRewards;

import game.Character;

public abstract class AbstractQuestReward {
	
    public abstract void applyReward(int rewardChoice, Character character);
}
