package plan.service.generate_report.interface_adapter;
import plan.entity.plan.DatePlan;
import plan.entity.plan.Plan;
import plan.service.generate_report.GenerateReportInputBoundary;
import plan.service.generate_report.GenerateReportInputData;

public class GenerateReportController {
    private final GenerateReportInputBoundary generateReportInteractor;

    public GenerateReportController(GenerateReportInputBoundary generateReportInteractor) {
        this.generateReportInteractor = generateReportInteractor;
    }

    public void execute(Plan plan) {

        GenerateReportInputData inputData = new GenerateReportInputData(plan);

        generateReportInteractor.execute(inputData);
    }
}
