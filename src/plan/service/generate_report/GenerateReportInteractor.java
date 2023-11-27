package plan.service.generate_report;
import java.util.ArrayList;
import java.util.List;
import plan.entity.activity.Activity;

public class GenerateReportInteractor {

    public GenerateReportOutputData generateReport(GenerateReportInputData inputData) {

        List<Activity> selectedActivities = inputData.getSelectedActivities();


        List<String> reportDetails = new ArrayList<>();
        for (Activity activity : selectedActivities) {
            String activityInfo = String.format(
                    "Name: %s, Cost: %.2f, Address: %s, Description: %s",
                    activity.getName(), activity.getCost(), activity.getAddress(), activity.getDescription()
            );
            reportDetails.add(activityInfo);
        }

        return new GenerateReportOutputData(reportDetails);
    }
}
