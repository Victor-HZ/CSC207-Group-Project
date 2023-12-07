package plan.service.delete_activity;

import plan.entity.activity.Activity;
import plan.entity.plan.Plan;
import plan.service.add_activity.AddActivityOutputBoundary;

import java.util.ArrayList;

public class DeleteActivityInteractor implements DeleteActivityInputBoundary {
    private final DeleteActivityOutputBoundary deleteActivityPresenter;

    public DeleteActivityInteractor (DeleteActivityOutputBoundary deleteActivityOutputBoundary) {
        this.deleteActivityPresenter = deleteActivityOutputBoundary;
    }

    @Override
    public void execute(DeleteActivityInputData deleteActivityInputData) {
        Plan plan = deleteActivityInputData.getPlan();
        Activity activity = deleteActivityInputData.getActivity();
        ArrayList<Activity> activities = plan.getActivities();
        // Cycles though activities in plan to ensure activity exists in plan
        for (int i = 0; i < plan.getActivities().size(); i++) {
            if (activities.get(i).equals(activity)) {
                plan.deleteActivity(activity);
                deleteActivityPresenter.prepareSuccessView();
                break;
            }
        }
        deleteActivityPresenter.prepareFailView("This activity is not in your planner!");
    }
}
