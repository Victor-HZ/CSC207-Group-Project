package plan.service.fetch_activities;

import plan.entity.activity.Activity;

import java.util.ArrayList;

public class FetchActivitiesOutputData {
    private final ArrayList<Activity> activities;
    private final boolean useCaseFaild;

    public FetchActivitiesOutputData(ArrayList<Activity> activities, boolean useCaseFaild){
        this.activities = activities;
        this.useCaseFaild = useCaseFaild;
    }

    public ArrayList<Activity> getActivities(){
        return this.activities;
    }
}
