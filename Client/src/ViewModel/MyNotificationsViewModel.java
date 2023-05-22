package ViewModel;

import Model.ModelClient;
import Model.Reservation;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MyNotificationsViewModel extends ViewModel{

    private ViewState viewState;
    private ModelClient model;

    private ObservableList<String> list;
    private StringProperty selectedObject;

    public MyNotificationsViewModel(ModelClient model, ViewState viewState)
    {
        this.model = model;
        this.viewState = viewState;
        this.list = FXCollections.observableArrayList();
        this.selectedObject = new SimpleStringProperty();
        this.selectedObject = new SimpleStringProperty();
        clear();
    }
    @Override
    public void clear() {
        list.clear();
        try {
            for (
                    String notification : model.getAllNotificationsByUsername(viewState.getUsername())) {
                list.add(notification);
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public ObservableList<String> getList() {
        return list;
    }
    public void setId(String id) {
        viewState.setId(id);
    }

}
