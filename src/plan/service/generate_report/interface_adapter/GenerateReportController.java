package plan.service.generate_report.interface_adapter;
import plan.service.generate_report.GenerateReportInputBoundary;
import plan.service.generate_report.GenerateReportInputData;

public class GenerateReportController {
    private final GenerateReportInputBoundary generateReportInteractor;

    public GenerateReportController(GenerateReportInputBoundary generateReportInteractor) {
        this.generateReportInteractor = generateReportInteractor;
    }

    public void execute(DatePlan datePlan) {

        GenerateReportInputData inputData = new GenerateReportInputData(datePlan);

        generateReportInteractor.generateReport(inputData);
    }
}
