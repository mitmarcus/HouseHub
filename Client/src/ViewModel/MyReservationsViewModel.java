package ViewModel;

import View.MyReservationsViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ModelClient.ModelClient;

public class MyReservationsViewModel extends ViewModel {
    private ViewState viewState;
    private ModelClient model;
    private ObservableList<String> list;

    private StringProperty selectedObject;

    public MyReservationsViewModel(ModelClient model, ViewState viewState)
    {
        this.model = model;
        this.viewState = viewState;
        this.list = FXCollections.observableArrayList();
        this.selectedObject = new SimpleStringProperty();
        for (int i = 0; i < model.getAllRooms().size();i++)
        {
            list.add(model.getAllRooms().get(i).getAnnouncement());/* change */
        }
    }

    @Override public void clear()
    {
        //
    }
    public ObservableList<String> getList()
    {
        return list;
    }

    public void setSelectedObject(String id){
        this.selectedObject.set(id);
    }

    public void setId(String id)
    {
        viewState.setId(id);
    }

    public void roomDetails() {
        viewState.setId(selectedObject.get());
    }

}
