package user.service.clear_users.interface_adapter;

import view.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class ClearViewModel extends ViewModel {
    public final String TITLE_LABEL = "Clear View";

    public static final String OK_BUTTON_LABEL = "OK";

    private ClearState state = new ClearState();

    public ClearViewModel(){
        super("Clear");
    }

    public void setState(ClearState state){
        this.state = state;
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

    public ClearState getState(){
        return this.state;
    }
}
