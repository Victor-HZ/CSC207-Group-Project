package plan.service.add_activity;
import plan.entity.activity.Activity;
import plan.entity.plan.Plan;
import plan.service.add_activity.interface_adapter.AddActivityPresenter;

public class AddActivityInteractor implements AddActivityInputBoundary {

    private final AddActivityOutputBoundary addActivityPresenter;

    public AddActivityInteractor (AddActivityOutputBoundary addActivityOutputBoundary) {
        this.addActivityPresenter = addActivityOutputBoundary;
    }
    @Override
    public void execute(AddActivityInputData addActivityInputData) {
        Plan plan = addActivityInputData.getPlan();
        Activity activity = addActivityInputData.getActivity();

        // Cycles through activities in plan to make sure activity isn't already added.
        for (Activity this_activity : plan.getActivities()) {
            if (this_activity.equals(activity)) {
                addActivityPresenter.prepareFailView("This activity is already in your planner.");
            }
        }
        plan.addActivity(activity);
        addActivityPresenter.prepareSuccessView();
    }
}
