package game;

import java.util.List;


public class Quest {
    protected String questName;
    protected List<String> itemReward;
    protected int xpReward;
    protected int gemReward;
    protected boolean completed;
    protected String selectedReward;
    
    // Constructor
    public Quest(String questName, List<String> itemReward, int xpReward, int gemReward) {
        this.questName = questName;
        this.itemReward = itemReward;
        this.xpReward = xpReward;
        this.gemReward = gemReward;
        this.completed = false;
        this.selectedReward = "";
    }

	public List<String> getRewards() {
        return itemReward;
    }

	public String getQuestName() {
		return questName;
	}

	public void setQuestName(String questName) {
		this.questName = questName;
	}

	public List<String> getItemReward() {
		return itemReward;
	}

	public void setItemReward(List<String> itemReward) {
		this.itemReward = itemReward;
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
	

	public int getGemReward() {
		return gemReward;
	}

	public void setGemReward(int gemReward) {
		this.gemReward = gemReward;
	}
	 
    
	
}
