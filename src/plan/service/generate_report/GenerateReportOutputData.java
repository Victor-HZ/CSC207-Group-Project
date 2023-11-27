package plan.service.generate_report;
import java.util.List;
public class GenerateReportOutputData {
    private List<String> reportDetails;

    public GenerateReportOutputData(List<String> reportDetails) {
        this.reportDetails = reportDetails;
    }

    public List<String> getReportDetails() {
        return reportDetails;
    }
}
