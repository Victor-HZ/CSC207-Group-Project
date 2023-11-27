package plan.service.delete_activity;

import plan.entity.activity.Activity;
import plan.entity.plan.Plan;
import plan.service.add_activity.AddActivityOutputBoundary;

public class DeleteActivityInteractor implements DeleteActivityInputBoundary {
    private final DeleteActivityOutputBoundary deleteActivityPresenter;

    public DeleteActivityInteractor (DeleteActivityOutputBoundary deleteActivityOutputBoundary) {
        this.deleteActivityPresenter = deleteActivityOutputBoundary;
    }

    @Override
    public void execute(DeleteActivityInputData deleteActivityInputData) {
        Plan plan = deleteActivityInputData.getPlan();
        Activity activity = deleteActivityInputData.getActivity();
        for (Activity this_activity : plan.getActivities()) {
            if (this_activity.equals(activity)) {
                plan.deleteActivity(activity);
                deleteActivityPresenter.prepareSuccessView();
            }
        }
        deleteActivityPresenter.prepareFailView("This activity is not in your planner!");
    }
}
