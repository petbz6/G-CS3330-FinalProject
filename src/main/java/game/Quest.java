package game;

import java.util.List;


public class Quest {
    protected String questName;
    protected List<String> equipmentReward;
    protected int xpReward;
    protected boolean completed;
    protected String selectedReward;
    
    // Constructor
    public Quest(String questName, List<String> equipmentReward, int xpReward) {
        this.questName = questName;
        this.equipmentReward = equipmentReward;
        this.xpReward = xpReward;
        this.completed = false;
        this.selectedReward = "";
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
	
	// Used for quest status (Checking whether or not a quest is completed)
	public boolean isCompleted() {
        return completed;
    }
	
	// Used to mark a quest as completed 
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

	public String getSelectedReward() {
		return selectedReward;
	}

	public void setSelectedReward(String selectedReward) {
		this.selectedReward = selectedReward;
	}
    
    
	
}
