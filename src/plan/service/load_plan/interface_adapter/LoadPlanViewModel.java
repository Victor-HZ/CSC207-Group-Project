package plan.service.load_plan.interface_adapter;
import view.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoadPlanViewModel extends ViewModel {

    public final String TITLE_LABEL = "Load Plan View";
    public final String ACTIVITIES_LABEL = "Activities:";
    public final String TOTAL_COST_LABEL = "Total Cost:";
    public final String DAY_INFO_LABEL = "Day Info:";

    private LoadPlanState state = new LoadPlanState();

    public LoadPlanViewModel() {
        super("load plan");
    }

    public void setState(LoadPlanState state) {
        this.state = state;
        firePropertyChanged();
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the LoadPlanPresenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoadPlanState getState() {
        return state;
    }
}