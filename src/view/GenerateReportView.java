package view;

import plan.entity.activity.Activity;
import plan.service.generate_report.interface_adapter.GenerateReportState;
import plan.service.generate_report.interface_adapter.GenerateReportViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GenerateReportView extends JPanel implements PropertyChangeListener {

    public final String viewName = "generate report";
    private final GenerateReportViewModel viewModel;

    private JTextArea activitiesTextArea;
    private JLabel totalCostLabel;
    private JLabel dayInfoLabel;

    public GenerateReportView(GenerateReportViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);

        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        activitiesTextArea = new JTextArea();
        activitiesTextArea.setEditable(false);

        totalCostLabel = new JLabel("Total Cost: ");

        dayInfoLabel = new JLabel("Day Info: ");

        add(new JScrollPane(activitiesTextArea), BorderLayout.CENTER);
        add(totalCostLabel, BorderLayout.SOUTH);
        add(dayInfoLabel, BorderLayout.SOUTH);

        updateUI();
    }

    public void updateUI() {
        GenerateReportState state = viewModel.getState();

        activitiesTextArea.setText(getActivitiesText(state));
        totalCostLabel.setText("Total Cost: " + state.getTotalCost());
        dayInfoLabel.setText("Day Info: " + state.getDayInfo());
    }

    private String getActivitiesText(GenerateReportState state) {
        StringBuilder sb = new StringBuilder();
        for (Activity activity : state.getActivities()) {
            sb.append(activity.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updateUI();
        }
    }
}