package ViewModel;

import ModelClient.Room;
import ModelClient.ModelClient;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DetailsViewModel extends ViewModel{
    private ViewState viewState;
    private ModelClient model;
    private ObservableList<Room> list;

    public DetailsViewModel(ModelClient model, ViewState viewState){
        this.model = model;
        this.viewState = viewState;
        this.list = FXCollections.observableArrayList();
        this.list.add(new Room("Room next Lovbjerg.","$300,000", "123 Main St", 200, 3));
        this.list.add(new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", 300, 2));
        this.list.add(new Room("Available room close to city center","$700,000", "789 Oak St", 120, 1));
    }

    @Override
    public void clear() {

    }

    public ObservableList<Room> getList() {
        return list;
    }
}
