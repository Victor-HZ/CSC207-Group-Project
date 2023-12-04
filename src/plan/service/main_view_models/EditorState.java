package plan.service.main_view_models;

import plan.entity.activity.Activity;

import java.util.ArrayList;

public class EditorState {
    private String addActivityError = null;
    private String deleteActivityError = null;

    private String savePlanError = null;

    private ArrayList<Activity> avaliableActivities = new ArrayList<>();
    private ArrayList<Activity> selectedActivities = new ArrayList<>();


    public EditorState() {
    }
    public void setAddActivityError(String activityError) {
        this.addActivityError = activityError;
    }
    public void setDeleteActivityError(String activityError) {
        this.deleteActivityError = activityError;
    }
    public void savePlanError(String saveError) {this.savePlanError = saveError;}
}
