package game;

import java.util.List;

public class Quest {
    private String questName;
    List<String> equipmentReward;
    

    public Quest(String questName, List<String> equipmentReward, int xpReward) {
        this.questName = questName;
        this.equipmentReward = equipmentReward;
    }

    public String getName() {
        return questName;
    }

    
    
    

    

    

    
}
