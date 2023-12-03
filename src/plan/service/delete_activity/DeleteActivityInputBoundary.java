package plan.service.delete_activity;


public interface DeleteActivityInputBoundary {
    void execute(DeleteActivityInputData deleteActivityInputData); // takes in plan and activity
}
