package plan.service.generate_report.interface_adapter;

import plan.service.generate_report.GenerateReportOutputBoundary;
import plan.service.generate_report.GenerateReportOutputData;
import plan.service.generate_report.GenerateReportGenerateReportState;
import plan.service.generate_report.GenerateReportViewModel;
import view.interface_adapter.ViewManagerModel;

public class GenerateReportPresenter implements GenerateReportOutputBoundary {

    private final GenerateReportViewModel generateReportViewModel;
    private final ViewManagerModel viewManagerModel;

    public GenerateReportPresenter(ViewManagerModel viewManagerModel, GenerateReportViewModel generateReportViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.generateReportViewModel = generateReportViewModel;
    }

    @Override
    public void prepareSuccessView(GenerateReportOutputData outputData) {

        GenerateReportState reportState = generateReportViewModel.getState();


        reportState.setActivities(outputData.getActivities());
        reportState.setTotalCost(outputData.getTotalCost());
        reportState.setDayInfo(outputData.getDayInfo());

        // Update the view model state
        generateReportViewModel.setState(reportState);
        generateReportViewModel.firePropertyChanged();

        // Switch to the generate report view
        viewManagerModel.setActiveView(generateReportViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        generateReportViewModel.setErrorMessage(error);
        generateReportViewModel.firePropertyChanged();
    }
}
