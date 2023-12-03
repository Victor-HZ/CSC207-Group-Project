package plan.service.main_view_models;

import plan.entity.activity.Activity;
import plan.entity.plan.DatePlan;
import plan.entity.plan.Plan;

import java.util.ArrayList;

public class EditorState {
    private String addActivityError = null;
    private String deleteActivityError = null;
    private ArrayList<Activity> availableActivities = new ArrayList<>();
    private ArrayList<Activity> selectedActivities = new ArrayList<>();
    private Activity selectedAvailableTable;
    private Activity selectedSelectedTable;
    private Plan plan;

    public EditorState() {
    }

    public void setSelectedSelectedTable(Activity activity) {
        selectedSelectedTable = activity;
    }

    public Activity getSelectedSelectedTable() {
        return selectedSelectedTable;
    }

    public void setSelectedAvailableTable(Activity activity) {
        selectedAvailableTable = activity;
    }

    public Activity getSelectedAvailableTable() {
        return selectedAvailableTable;
    }

    public void setAvailableActivities(ArrayList<Activity> activities){
        this.availableActivities = activities;
    }

    public ArrayList<Activity> getAvailableActivities(){
        return availableActivities;
    }

    public void setSelectedActivities(ArrayList<Activity> selectedActivities) {
        this.selectedActivities = selectedActivities;
    }

    public ArrayList<Activity> getSelectedActivities() {
        return selectedActivities;
    }

    public void setAddActivityError(String activityError) {
        this.addActivityError = activityError;
    }

    public String getAddActivityError() {
        return addActivityError;
    }

    public void setDeleteActivityError(String activityError) {
        this.deleteActivityError = activityError;
    }

    public String getDeleteActivityError() {
        return deleteActivityError;
    }

    public void setPlan(Plan plan){
        this.plan = plan;
    }

    public Plan getPlan(){
        return plan;
    }

}
