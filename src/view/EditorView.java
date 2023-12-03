package view;

import apis.ActivitiesFetchInterface;
import plan.entity.activity.Activity;
import plan.service.add_activity.interface_adapter.AddActivityController;
import plan.service.delete_activity.interface_adapter.DeleteActivityController;
import plan.service.fetch_activities.interface_adapter.FetchActivitiesController;
import plan.service.main_view_models.EditorState;
import plan.service.main_view_models.EditorViewModel;
import user.service.signup.interface_adapter.SignupState;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class EditorView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "editor";

    private final EditorViewModel editorViewModel;
    private final JTable availableActivities = new JTable();
    private final JTable selectedActivities = new JTable();

    private final AddActivityController addActivityController;
    private final DeleteActivityController deleteActivityController;
    private final FetchActivitiesController fetchActivitiesController;

    private final JButton addActivity;
    private final JButton deleteActivity;
    private final JButton savePlan;
    private final JButton generateReport;

    public EditorView(EditorViewModel editorViewModel, AddActivityController addActivityController, DeleteActivityController deleteActivityController, FetchActivitiesController fetchActivitiesController){
        this.editorViewModel = editorViewModel;

        this.addActivityController = addActivityController;
        this.deleteActivityController = deleteActivityController;
        this.fetchActivitiesController = fetchActivitiesController;
        editorViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(EditorViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


//        ArrayList<Activity> activities = this.fetchActivitiesController.execute();

        LabelTablePanel availableActivitiesTable = new LabelTablePanel(
                new JLabel(EditorViewModel.AVAILABLE_ACTIVITIES_LABEL), availableActivities);
        LabelTablePanel selectedActivitiesTable = new LabelTablePanel(
                new JLabel(EditorViewModel.SELECTED_ACTIVITIES_LABEL), selectedActivities);

        JPanel buttons = new JPanel();
        addActivity = new JButton(EditorViewModel.ADD_ACTIVITY_BUTTON_LABEL);
        buttons.add(addActivity);
        deleteActivity = new JButton(EditorViewModel.DELETE_ACTIVITY_BUTTON_LABEL);
        buttons.add(deleteActivity);
        savePlan = new JButton(EditorViewModel.SAVE_PLAN_BUTTON_LABEL);
        buttons.add(savePlan);
        generateReport = new JButton(EditorViewModel.GENERATE_REPORT_LABEL);
        buttons.add(generateReport);

        addActivity.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addActivity)) {
                            EditorState currentState = editorViewModel.getState();
                        }
                    }
                }
        );

        deleteActivity.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deleteActivity)) {
                            EditorState currentState = editorViewModel.getState();
                        }
                    }
                }
        );

        savePlan.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(savePlan)) {
                            EditorState currentState = editorViewModel.getState();
                        }
                    }
                }
        );

        generateReport.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(generateReport)) {
                            EditorState currentState = editorViewModel.getState();
                        }
                    }
                }
        );

        availableActivitiesTable.addAncestorListener(
                new AncestorListener() {
                    @Override
                    public void ancestorAdded(AncestorEvent event) {

                    }

                    @Override
                    public void ancestorRemoved(AncestorEvent event) {

                    }

                    @Override
                    public void ancestorMoved(AncestorEvent event) {

                    }
                }
        );

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
