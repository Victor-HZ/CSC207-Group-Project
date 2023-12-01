package plan.service.generate_report;

public interface GenerateReportOutputBoundary {
    void prepareSuccessView(GenerateReportOutputData outputData);

    void prepareFailView(String error);
}
