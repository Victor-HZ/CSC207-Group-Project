package plan.service.generate_report;

import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.Plan;

import java.util.List;

public class GenerateReportInteractor implements GenerateReportInputBoundary {
    private GenerateReportOutputBoundary outputBoundary;

    public GenerateReportInteractor(GenerateReportOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(GenerateReportInputData inputData) {
    }
}
//        if (inputData == null || inputData.getUser() == null || inputData.getUser().getPlan() == null) {
//            // Handle invalid input
//            outputBoundary.prepareFailView("Invalid input for report generation.");
//
//        }
//
//        Plan userPlan = inputData.getUser().getPlan();
//
//        List<Activity> activities = userPlan.getActivities();
//        double totalCost = userPlan.getCost();
//        DayInfo dayInfo = userPlan.getDayInfo();
//
//        GenerateReportOutputData outputData = new GenerateReportOutputData(activities, totalCost, dayInfo);
//        outputBoundary.prepareSuccessView(outputData);
//
//    }

