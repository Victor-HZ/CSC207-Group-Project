package plan.service.main_view_models;

public class EditorState {
    private String addActivityError = null;
    private String deleteActivityError = null;

    public EditorState() {
    }
    public void setAddActivityError(String activityError) {
        this.addActivityError = activityError;
    }
    public void deleteActivityError(String activityError) {
        this.deleteActivityError = activityError;
    }
}
