package plan.service.generate_report.interface_adapter;
import plan.entity.plan.DatePlan;
import plan.service.generate_report.GenerateReportInputBoundary;
import plan.service.generate_report.GenerateReportInputData;
import user.entity.CommonUser;

public class GenerateReportController {
    private final GenerateReportInputBoundary generateReportInteractor;

    public GenerateReportController(GenerateReportInputBoundary generateReportInteractor) {
        this.generateReportInteractor = generateReportInteractor;
    }

    public void execute(CommonUser user) {

        GenerateReportInputData inputData = new GenerateReportInputData(user);

        generateReportInteractor.execute(inputData);

    }
}
