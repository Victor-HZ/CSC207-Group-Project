package plan.service.fetch_activities;

import plan.entity.activity.Activity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FetchActivitiesOutputData {
    private final ArrayList<Activity> activities;
    private final boolean useCaseFaild;
    private String creationTime;

    public FetchActivitiesOutputData(ArrayList<Activity> activities, boolean useCaseFaild, String creationTime){
        this.activities = activities;
        this.useCaseFaild = useCaseFaild;
        this.creationTime = creationTime;
    }

    public ArrayList<Activity> getActivities(){
        return this.activities;
    }

    public void setCreationTime(String creationTime){
        this.creationTime = creationTime;
    }

    public String getCreationTime(){
        return this.creationTime;
    }
}
