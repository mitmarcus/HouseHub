package ViewModel;

import Model.Reservation;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.ModelClient;


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

        try{
            for (Reservation reservation : model.getAllReservations()) {
                list.add(reservation.toString());
                System.out.println(model.getAllReservations().size());
            }
        }
        catch (NullPointerException e)
        {
            e.getMessage();
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

    public void removeReservation()
    {
        viewState.setId(selectedObject.get());
        Reservation reservation = model.getReservationAtIndex();
        model.removeReservation(reservation);
    }



}
