package plan.service.generate_report;

public interface GenerateReportOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
