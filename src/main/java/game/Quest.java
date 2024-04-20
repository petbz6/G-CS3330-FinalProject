package game;

import java.util.List;


public class Quest {
    protected String questName;
    protected List<String> equipmentReward;
    protected int xpReward;

    

    public Quest(String questName, List<String> equipmentReward, int xpReward) {
        this.questName = questName;
        this.equipmentReward = equipmentReward;
        this.xpReward = xpReward;

    }

    public List<String> getRewards() {
        return equipmentReward;
    }

	public String getQuestName() {
		return questName;
	}

	public void setQuestName(String questName) {
		this.questName = questName;
	}

	public List<String> getEquipmentReward() {
		return equipmentReward;
	}

	public void setEquipmentReward(List<String> equipmentReward) {
		this.equipmentReward = equipmentReward;
	}

	public int getXpReward() {
		return xpReward;
	}

	public void setXpReward(int xpReward) {
		this.xpReward = xpReward;
	}
	
	
       
}
