package plan.service.generate_report;
import java.util.List;
import plan.entity.activity.Activity;

public class GenerateReportInputData {
    private List<Activity> selectedActivities;

    public GenerateReportInputData(List<Activity> selectedActivities) {
        this.selectedActivities = selectedActivities;
    }

    public List<Activity> getSelectedActivities() {
        return selectedActivities;
    }
}
