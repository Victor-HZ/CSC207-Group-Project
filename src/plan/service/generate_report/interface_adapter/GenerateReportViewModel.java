package plan.service.generate_report.interface_adapter;

import view.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GenerateReportViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Generate Report View";
    public static final String ACTIVITIES_LABEL = "Activities:";
    public static final String TOTAL_COST_LABEL = "Total Cost:";
    public static final String DAY_INFO_LABEL = "Day Info:";

    private GenerateReportState state = new GenerateReportState();
    private static final String VIEW_NAME = "Generate Report";

    public GenerateReportViewModel() {
        super(VIEW_NAME);
    }

    @Override
    public String getViewName() {
        return VIEW_NAME;
    }

    public void setState(GenerateReportState state) {
        this.state = state;
        firePropertyChanged();
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the GenerateReportPresenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GenerateReportState getState() {
        return state;
    }
}
