package plan.service.main_view_models;

import view.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StartUpViewModel extends ViewModel {
    public final String TITLE_LABEL = "Planner";
    public static final String LOGIN_BUTTON_LABEL = "Login";
    public static final String SIGNUP_BUTTON_LABEL = "Sign Up";
    private StartUpState state = new StartUpState();
    public StartUpViewModel() {
        super("planner startup");
    }
    public void setState(StartUpState state) {
        this.state = state;
    }

    public StartUpState getState() {
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
