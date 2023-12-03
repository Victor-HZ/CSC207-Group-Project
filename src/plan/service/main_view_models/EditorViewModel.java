package plan.service.main_view_models;

import user.service.signup.interface_adapter.SignupState;
import view.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditorViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Plan Editor View";
    public static final String ADD_ACTIVITY_BUTTON_LABEL = "Add Activity";
    public static final String DELETE_ACTIVITY_BUTTON_LABEL = "Delete Activity";
    public static final String SAVE_PLAN_BUTTON_LABEL = "Save Plan";
    public static final String AVAILABLE_ACTIVITIES_LABEL = "Available Activities";
    public static final String SELECTED_ACTIVITIES_LABEL = "Selected Activities";
    public static final String GENERATE_REPORT_LABEL = "Generate Report";

    private EditorState state = new EditorState();

    public EditorViewModel() {
        super("plan editor");
    }

    private static final String thisViewName = "plan editor";

    @Override
    public String getViewName() {
        return thisViewName;
    }

    public void setState(EditorState state) {
        this.state = state;
    }

    public EditorState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
