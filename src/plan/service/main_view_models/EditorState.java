package plan.service.main_view_models;

import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.DatePlan;
import plan.entity.plan.Plan;
import user.entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class EditorState {
    private String addActivityError = null;
    private String deleteActivityError = null;
    private String savePlanError = null;

    private HashMap<Integer, Activity> availableActivities = new HashMap<>();
    private HashMap<Integer, Activity> selectedActivities = new HashMap<>();

    private HashMap<User.API_TOKEN, String> apiTokens = new HashMap<>();
    private Activity selectedAvailableTable;
    private Integer selectedAvailableTableID;
    private Integer selectedSelectedTableID;
    private Activity selectedSelectedTable;
    private Plan plan;
    private DayInfo dayInfo;
    private Address address;
    private User user;
    private String selection;
    private ArrayList<String> selected = new ArrayList<String>();

    public EditorState() {
    }

    public Activity getActivity(String text) {
        Integer key = Integer.parseInt(text);
        return this.availableActivities.get(key);
    }

    public void setSelection(String text) {
        this.selection = text;
    }
    public String getSelection() {
        return this.selection;
    }

    public void addSelected(String text) {
        if (!this.selected.contains(text)) {
            this.selected.add(text);
        }
    }
    public void deleteSelected(String text) {
        this.selected.remove(text);
    }
    public String getSelected() {
        return this.selected.toString();
    }

    public void addAvailableActivity(Integer activityID, Activity activity){
        availableActivities.put(activityID, activity);
    }

    public void addSelectedActivity(Integer activityID, Activity activity){
        selectedActivities.put(activityID, activity);
    }

    public void deleteAvailableActivity(Integer activityID){
        availableActivities.remove(activityID);
    }

    public void deleteSelectedActivity(Integer activityID){
        selectedActivities.remove(activityID);
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

    public void setAvailableActivities(HashMap<Integer, Activity> activities){
        this.availableActivities = activities;
    }

    public HashMap<Integer, Activity> getAvailableActivities(){
        return availableActivities;
    }

    public void setSelectedActivities(HashMap<Integer, Activity> selectedActivities) {
        this.selectedActivities = selectedActivities;
    }

    public HashMap<Integer, Activity> getSelectedActivities() {
        return selectedActivities;
    }

    public void setAddActivityError(String activityError) {
        this.addActivityError = activityError;
    }

    public void setDeleteActivityError(String activityError) {
        this.deleteActivityError = activityError;
    }

    public void savePlanError(String saveError) {this.savePlanError = saveError;}

    public void setDayInfo(DayInfo dayInfo) {
        this.dayInfo = dayInfo;
    }

    public DayInfo getDayInfo() {
        return dayInfo;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Plan getPlan() {
        return plan;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setApiTokens(User.API_TOKEN name, String token) {
        apiTokens.put(name, token);
    }

    public HashMap<User.API_TOKEN, String> getApiTokens() {
        return apiTokens;
    }

    public void setSelectedAvailableTableID(Integer selectedAvailableTableID) {
        this.selectedAvailableTableID = selectedAvailableTableID;
    }

    public void setSelectedSelectedTableID(Integer selectedSelectedTableID) {
        this.selectedSelectedTableID = selectedSelectedTableID;
    }

    public Integer getSelectedSelectedTableID() {
        return selectedSelectedTableID;
    }

    public Integer getSelectedAvailableTableID() {
        return selectedAvailableTableID;
    }

    public String[][] getDisplayAvailableActivitiesArray() {
        String[][] displayAvailableActivitiesArray = new String[availableActivities.size()][4];
        ArrayList<String[]> displayActivities = new ArrayList<>();

        for (Integer index : availableActivities.keySet()){
            String[] item = {index.toString(),
                    availableActivities.get(index).getName(),
                    availableActivities.get(index).getCost().toString(),
                    availableActivities.get(index).getAddress().getStreetNumber() + " " + availableActivities.get(index).getAddress().getStreetName(),
                    availableActivities.get(index).getAddress().getPostalCode()};
            displayActivities.add(item);
        }
        displayActivities.toArray(displayAvailableActivitiesArray);
        return displayAvailableActivitiesArray;
    }

    public String[][] getDisplaySlectedActivitiesArray() {
        String[][] displaySlectedActivitiesArray = new String[selectedActivities.size() + 1][4];
        ArrayList<String[]> displayActivities = new ArrayList<>();

        for (Integer index : selectedActivities.keySet()){
            String[] item = {index.toString(),
                    selectedActivities.get(index).getName(),
                    selectedActivities.get(index).getCost().toString(),
                    selectedActivities.get(index).getAddress().getStreetNumber() + " " + selectedActivities.get(index).getAddress().getStreetName(),
                    selectedActivities.get(index).getAddress().getPostalCode()};
            displayActivities.add(item);
        }
        displayActivities.toArray(displaySlectedActivitiesArray);
        if (selectedActivities.size() == 0){
            displaySlectedActivitiesArray = new String[][]{{"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}};
        }
        return displaySlectedActivitiesArray;
    }
}
