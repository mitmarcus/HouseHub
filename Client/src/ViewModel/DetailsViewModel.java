package ViewModel;

import ModelClient.Room;
import ModelClient.ModelClient;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.awt.*;

public class DetailsViewModel extends ViewModel{
    private ViewState viewState;
    private ModelClient model;
    private StringProperty price;
    private StringProperty roomSize;
    private StringProperty roomAddress;
    private StringProperty numberOfRooms;


    public DetailsViewModel(ModelClient model, ViewState viewState){
        this.model = model;
        this.viewState = viewState;
        this.price = new SimpleStringProperty();
        this.roomAddress = new SimpleStringProperty();
        this.roomSize= new SimpleStringProperty();
        this.numberOfRooms = new SimpleStringProperty();
    }

    public StringProperty getPriceProperty() {
        return price;
    }
    public StringProperty getRoomSizeProperty(){
        return roomSize;
    }
    public StringProperty getRoomAddressProperty(){
        return roomAddress;
    }
    public StringProperty getNumberOfRoomsProperty(){
        return numberOfRooms;
    }

    @Override
    public void clear() {
        Room room = model.getRoomByAnnouncement(viewState.getId());

        this.price.setValue(room.getPrice());
        this.roomSize.setValue(room.getSize());
        this.numberOfRooms.setValue(room.getBedrooms());
        this.roomAddress.setValue(room.getAddress());
    }

}
