package view;

import apis.ActivitiesFetchInterface;
import plan.entity.activity.Activity;
import plan.entity.address.CanadaAddress;
import plan.entity.day_info.Date;
import plan.entity.day_info.ToStringType;
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
import java.util.HashMap;

public class EditorView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "editor";

    private final EditorViewModel editorViewModel;
    private final JTable availableActivities;
    private final JTable selectedActivities;

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

//        Temp helper code
        Date date = new Date();
        date.setYear(2023);
        date.setMonth(12);
        date.setDay(5);
        date.setHour(12);
        CanadaAddress address = new CanadaAddress();
        address.setCity("Toronto");
        address.setCountry("Canada");
        address.setPostCode("M6K, 3C3");
        address.setStreetNumber(170);
        address.setStreetName("Princes' Blvd");
        ArrayList<Activity> activities = this.fetchActivitiesController.execute(date, address);
        HashMap<Integer, Activity> hashActivities = new HashMap<>();
        Integer i = 0;
        for (Activity activity: activities){
            hashActivities.put(i, activity);
            i ++;
        }
        ArrayList<String[]> displayActivities = new ArrayList<>();

        for (Integer index : hashActivities.keySet()){
            String[] item = {index.toString(), hashActivities.get(index).getName(), hashActivities.get(index).getCost().toString(), hashActivities.get(index).getAddress().toString(), hashActivities.get(index).getDayInfo().toString()};
            displayActivities.add(item);
        }

        // Initialization of JTable
        String[] columnNames = {"Index", "Name", "Cost", "Address", "Time"};
        String[][] displayActivitiesArray = new String[displayActivities.size()][100];
        String[][] selectedActivitiesArray = new String[displayActivities.size()][100];
        displayActivities.toArray(displayActivitiesArray);
        availableActivities = new JTable(displayActivitiesArray, columnNames);
        availableActivities.setCellSelectionEnabled(true);
        selectedActivities = new JTable(selectedActivitiesArray, columnNames);
        selectedActivities.setCellSelectionEnabled(true);

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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(availableActivitiesTable);
        this.add(selectedActivitiesTable);
        this.add(buttons);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditorState state = (EditorState) evt.getNewValue();
    }
}
