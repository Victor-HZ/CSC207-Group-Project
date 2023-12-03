package plan.service.main_view_models;

public class EditorState {
    private String addActivityError = null;
    private String deleteActivityError = null;
    private String savePlanError = null;

    public EditorState() {
    }
    public void setAddActivityError(String activityError) {
        this.addActivityError = activityError;
    }
    public void deleteActivityError(String activityError) {
        this.deleteActivityError = activityError;
    }
    public void savePlanError(String saveError) {this.savePlanError = saveError;}
}
