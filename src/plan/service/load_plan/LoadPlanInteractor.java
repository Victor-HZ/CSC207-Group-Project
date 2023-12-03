package plan.service.load_plan;
import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.Plan;

import java.util.ArrayList;

public class LoadPlanInteractor implements LoadPlanInputBoundary {
    private LoadPlanOutputBoundary outputBoundary;

    public LoadPlanInteractor(LoadPlanOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void loadPlan(LoadPlanInputData inputData) {
        if (inputData == null || inputData.getDatePlan() == null) {

            outputBoundary.prepareFailView("Invalid input for plan loading.");
            return;
        }

        Plan plan = inputData.getDatePlan();


        ArrayList<Activity> activities = plan.getActivities();
        double totalCost = plan.getCost();
        DayInfo dayInfo = plan.getDayInfo();


        LoadPlanOutputData outputData = new LoadPlanOutputData(activities, totalCost, dayInfo);


        outputBoundary.prepareSuccessView(outputData);
    }
}
