package plan.service.generate_report.interface_adapter;
import plan.service.generate_report.GenerateReportInputBoundary;
public class GenerateReportController {

    final GenerateReportInputBoundary userGenerateReportUseCaseInteractor;

    public GenerateReportController(GenerateReportInputBoundary userGenerateReportUseCaseInteractor) {
        this.userGenerateReportUseCaseInteractor = userGenerateReportUseCaseInteractor;
    }

}
