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

    public GenerateReportView(GenerateReportViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);

        updateUI();
    }

    public void updateUI() {
        setLayout(new BorderLayout());

        activitiesTextArea = new JTextArea();
        activitiesTextArea.setEditable(false);

        totalCostLabel = new JLabel("Total Cost: ");

        add(new JScrollPane(activitiesTextArea), BorderLayout.CENTER);
        add(totalCostLabel, BorderLayout.SOUTH);

        updateUI();
    }

//    public void updateUI() {
//        GenerateReportState state = viewModel.getState();
//
//        if (state != null) {
//            StringBuilder sb = new StringBuilder();
//            for (Activity activity : state.getActivities()) {
//                sb.append(activity.toString()).append("\n");
//            }
//
//            activitiesTextArea.setText(sb.toString());
//            totalCostLabel.setText("Total Cost: " + state.getTotalCost());
//        }
//    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updateUI();
        }
    }
}
