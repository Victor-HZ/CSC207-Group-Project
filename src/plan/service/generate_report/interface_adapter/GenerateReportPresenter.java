package plan.service.generate_report.interface_adapter;

import plan.service.generate_report.GenerateReportOutputBoundary;

import javax.swing.*;

public class GenerateReportPresenter implements GenerateReportOutputBoundary {

    private final GenerateReportViewModel generateReportViewModel;

    public GenerateReportPresenter(GenerateReportViewModel generateReportViewModel) {
        this.generateReportViewModel = generateReportViewModel;
    }

    @Override
    public void prepareSuccessView() {
        GenerateReportState reportState = generateReportViewModel.getState();

        JOptionPane.showMessageDialog(null, reportState.getSuccessMessage());
    }

    @Override
    public void prepareFailView(String error) {
        GenerateReportState reportState = generateReportViewModel.getState();

        JOptionPane.showMessageDialog(null, reportState.getErrorMessage());
    }

}
