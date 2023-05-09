package ViewModel;

import Model.Reservation;
import Model.Room;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.ModelClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyReservationsViewModel extends ViewModel implements
    PropertyChangeListener
{
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
        this.model.addListener(this);
        clear();

    }

    @Override public void clear()
    {
        list.clear();
        try{
        for (Reservation reservation : model.getAllReservations()) {
            list.add(reservation.toString());
        }
    }
    catch (NullPointerException e)
    {
        e.getMessage();
    }
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

    public void removeReservation(String id)
    {
        Reservation reservation = model.getReservationById(id);
        Room room = reservation.getRoom();
        model.setRoomFree(room);
        model.removeReservation(reservation);
        System.out.println(reservation);
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        Platform.runLater(()->{
            if (evt.getPropertyName().equals("reserve"))
            {
                Reservation reservation = (Reservation) evt.getNewValue();
                list.add(reservation.toString());
            }
        });

        if (evt.getPropertyName().equals("removeReservation"))
        Platform.runLater(()->{
            System.out.println("hello");
                clear();
        });



    }
}
