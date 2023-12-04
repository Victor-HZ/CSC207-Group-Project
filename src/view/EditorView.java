package view;

import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.address.CanadaAddress;
import plan.entity.day_info.Date;
import plan.entity.plan.Plan;
import plan.service.add_activity.interface_adapter.AddActivityController;
import plan.service.delete_activity.interface_adapter.DeleteActivityController;
import plan.service.fetch_activities.interface_adapter.FetchActivitiesController;
import plan.service.generate_report.interface_adapter.GenerateReportController;
import plan.service.main_view_models.EditorState;
import plan.service.main_view_models.EditorViewModel;
import plan.service.save_plan.interface_adapter.SavePlanController;
import user.entity.User;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

public class EditorView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "plan editor";

    private final EditorViewModel editorViewModel;
    private final JTable availableActivities;
    private final JTable selectedActivities;

    private final AddActivityController addActivityController;
    private final DeleteActivityController deleteActivityController;
    private final FetchActivitiesController fetchActivitiesController;
    private final GenerateReportController generateReportController;
    private final SavePlanController savePlanController;

    private final JButton addActivity;
    private final JButton deleteActivity;
    private final JButton savePlan;
    private final JButton generateReport;

    public EditorView(EditorViewModel editorViewModel,
                      AddActivityController addActivityController,
                      DeleteActivityController deleteActivityController,
                      FetchActivitiesController fetchActivitiesController,
                      GenerateReportController generateReportController,
                      SavePlanController savePlanController,
                      Plan plan,
                      Address address,
                      User user){
        this.editorViewModel = editorViewModel;
        this.addActivityController = addActivityController;
        this.deleteActivityController = deleteActivityController;
        this.fetchActivitiesController = fetchActivitiesController;
        this.generateReportController = generateReportController;
        this.savePlanController = savePlanController;

        editorViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(EditorViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        EditorState state = editorViewModel.getState();
        state.setPlan(plan);
        state.setAddress(address);
        state.setUser(user);
        state.setDayInfo(plan.getDayInfo());


        state.setApiTokens(User.API_TOKEN.Ticketmaster, state.getUser().getAPIToken(User.API_TOKEN.Ticketmaster));
        state.setApiTokens(User.API_TOKEN.TripAdvisor, state.getUser().getAPIToken(User.API_TOKEN.TripAdvisor));
        state.setApiTokens(User.API_TOKEN.Coordinate, state.getUser().getAPIToken(User.API_TOKEN.Coordinate));

        editorViewModel.setState(state);

        state = editorViewModel.getState();

        ArrayList<Activity> activities = this.fetchActivitiesController.execute(state.getDayInfo(), state.getAddress(), state.getApiTokens());
        HashMap<Integer, Activity> hashActivities = new HashMap<>();
        Integer i = 0;
        for (Activity activity: activities){
            hashActivities.put(i, activity);
            i ++;
        }
        state.setAvailableActivities(hashActivities);
        editorViewModel.setState(state);

        String[] columnNames = {"Index", "Name", "Cost", "Address", "Postal Code"};
        availableActivities = new JTable(state.getDisplayAvailableActivitiesArray(), columnNames);
        availableActivities.setCellSelectionEnabled(true);
        availableActivities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneAvailableActivities = new JScrollPane(availableActivities);
        selectedActivities = new JTable(state.getDisplaySlectedActivitiesArray(), columnNames);
        selectedActivities.setCellSelectionEnabled(true);
        selectedActivities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneSelectedActivities = new JScrollPane(selectedActivities);

        LabelTablePanel availableActivitiesTable = new LabelTablePanel(
                new JLabel(EditorViewModel.AVAILABLE_ACTIVITIES_LABEL), scrollPaneAvailableActivities);
        LabelTablePanel selectedActivitiesTable = new LabelTablePanel(
                new JLabel(EditorViewModel.SELECTED_ACTIVITIES_LABEL), scrollPaneSelectedActivities);


        JPanel buttons = new JPanel();
        addActivity = new JButton(EditorViewModel.ADD_ACTIVITY_BUTTON_LABEL);
        buttons.add(addActivity);
        deleteActivity = new JButton(EditorViewModel.DELETE_ACTIVITY_BUTTON_LABEL);
        buttons.add(deleteActivity);
        savePlan = new JButton(EditorViewModel.SAVE_PLAN_BUTTON_LABEL);
        buttons.add(savePlan);
        generateReport = new JButton(EditorViewModel.GENERATE_REPORT_LABEL);
        buttons.add(generateReport);

        availableActivities.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Integer row = availableActivities.getSelectedRow();
                Integer column = availableActivities.getSelectedColumn();
                if (column == 0){
                    Integer activityID = Integer.parseInt((String) availableActivities.getValueAt(row, column));
                    EditorState state = editorViewModel.getState();
                    state.setSelectedAvailableTable(state.getAvailableActivities().get(activityID));
                    state.setSelectedAvailableTableID(activityID);
                    editorViewModel.setState(state);
                    System.out.println("Selected" + state.getSelectedAvailableTable());
                }
            }
        });

        selectedActivities.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Integer row = selectedActivities.getSelectedRow();
                Integer column = selectedActivities.getSelectedColumn();
                if (column == 0){
                    Integer activityID =Integer.parseInt ((String) selectedActivities.getValueAt(row, column));
                    EditorState state = editorViewModel.getState();
                    state.setSelectedSelectedTable(state.getSelectedActivities().get(activityID));
                    state.setSelectedSelectedTableID(activityID);
                    editorViewModel.setState(state);
                    System.out.println("Selected" + state.getSelectedSelectedTable());
                }
            }
        });



        addActivity.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addActivity)) {
                            EditorState currentState = editorViewModel.getState();
                            addActivityController.execute(currentState.getPlan(), currentState.getSelectedAvailableTable());
                            currentState.addSelectedActivity(currentState.getSelectedAvailableTableID(), currentState.getSelectedAvailableTable());
                            currentState.deleteAvailableActivity(currentState.getSelectedAvailableTableID());
                            editorViewModel.setState(currentState);

                        }
                    }
                }
        );

        deleteActivity.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deleteActivity)) {
                            EditorState currentState = editorViewModel.getState();
                            deleteActivityController.execute(currentState.getPlan(), currentState.getSelectedSelectedTable());
                            currentState.addAvailableActivity(currentState.getSelectedSelectedTableID(), currentState.getSelectedSelectedTable());
                            currentState.deleteSelectedActivity(currentState.getSelectedSelectedTableID());
                            editorViewModel.setState(currentState);
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
        buttons.setBackground(Color.PINK);
        this.add(availableActivitiesTable);
        this.add(selectedActivitiesTable);
        this.add(buttons);
        this.setSize(1000, 1000);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditorState state = (EditorState) evt.getNewValue();
    }
}
