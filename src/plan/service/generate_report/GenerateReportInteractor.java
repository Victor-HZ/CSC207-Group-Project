package plan.service.generate_report;
import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.DatePlan;

import java.util.List;

public class GenerateReportInteractor implements GenerateReportInputBoundary {
    private GenerateReportOutputBoundary outputBoundary;

    public GenerateReportInteractor(GenerateReportOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void generateReport(GenerateReportInputData inputData) {
        if (inputData == null || inputData.getDatePlan() == null) {
            // Handle invalid input
            outputBoundary.prepareFailView("Invalid input for report generation.");
            return;
        }

        DatePlan datePlan = inputData.getDatePlan();


        double totalCost = datePlan.getCost();


        GenerateReportOutputData outputData = new GenerateReportOutputData(
                datePlan.getActivities(),
                totalCost,
                datePlan.getDayInfo());
        outputBoundary.prepareSuccessView(outputData);
    }
}
