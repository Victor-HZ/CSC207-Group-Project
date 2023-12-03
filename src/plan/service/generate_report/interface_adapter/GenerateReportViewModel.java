package plan.service.generate_report.interface_adapter;
import view.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GenerateReportViewModel extends ViewModel {

    public final String TITLE_LABEL = "Generate Report View";
    public final String ACTIVITIES_LABEL = "Activities:";
    public final String TOTAL_COST_LABEL = "Total Cost:";
    public final String DAY_INFO_LABEL = "Day Info:";

    private GenerateReportState state = new GenerateReportState();

    public GenerateReportViewModel() {
        super("generate report");
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GenerateReportState getState() {
        return state;
    }

    public void setErrorMessage(String error) {
    }
}
