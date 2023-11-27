package plan.service.delete_activity.interface_adapter;

import plan.entity.activity.Activity;
import plan.entity.plan.Plan;
import plan.service.delete_activity.DeleteActivityInputBoundary;
import plan.service.delete_activity.DeleteActivityInputData;

public class DeleteActivityController {
    final DeleteActivityInputBoundary deleteActivityInteractor;
    public DeleteActivityController(DeleteActivityInputBoundary deleteActivityInteractor) {
        this.deleteActivityInteractor = deleteActivityInteractor;
    }

    public void execute(Plan plan, Activity activity) {
        DeleteActivityInputData deleteActivityInputData = new DeleteActivityInputData(plan, activity);

        deleteActivityInteractor.execute(deleteActivityInputData);
    }
}
