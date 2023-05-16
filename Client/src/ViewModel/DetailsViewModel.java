package ViewModel;

import Model.*;
import Model.ModelClient;
import javafx.beans.property.*;

import java.time.LocalDate;

public class DetailsViewModel extends ViewModel {
    private ViewState viewState;
    private ModelClient model;
    private StringProperty price;
    private StringProperty roomSize;
    private StringProperty roomAddress;
    private StringProperty numberOfRooms;
    private ObjectProperty<LocalDate> startDate;
    private ObjectProperty<LocalDate> endDate;

    private DoubleProperty avgRating;


    public DetailsViewModel(ModelClient model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
        this.price = new SimpleStringProperty();
        this.roomAddress = new SimpleStringProperty();
        this.roomSize = new SimpleStringProperty();
        this.numberOfRooms = new SimpleStringProperty();
        this.startDate = new SimpleObjectProperty<>();
        this.endDate = new SimpleObjectProperty<>();
        this.avgRating = new SimpleDoubleProperty();

    }

    public StringProperty getPriceProperty() {
        return price;
    }

    public StringProperty getRoomSizeProperty() {
        return roomSize;
    }

    public StringProperty getRoomAddressProperty() {
        return roomAddress;
    }

    public StringProperty getNumberOfRoomsProperty() {
        return numberOfRooms;
    }

    public ObjectProperty<LocalDate> getStartDate() {
        return startDate;
    }

    public ObjectProperty<LocalDate> getEndDate() {
        return endDate;
    }
    public DoubleProperty getAvgRating()
    {
        return avgRating;
    }

    public boolean addReservation(LocalDate startDate, LocalDate endDate) {
        Room room = model.getRoomByAnnouncement(viewState.getId());
        User user = model.getUserByUsername(viewState.getUsername());
        System.out.println(user.toString());
        Reservation reservation = new Reservation(user,startDate,endDate,room);
        model.addReservation(reservation);
        model.setRoomReserved(room);
            return true;
    }

    @Override
    public void clear() {
        price.setValue("");
        roomAddress.setValue("");
        numberOfRooms.setValue("");
        roomSize.setValue("");
        avgRating.setValue(0);
        Room room = model.getRoomByAnnouncement(viewState.getId());


        this.price.setValue(room.getPrice());
        this.roomSize.setValue(room.getSize());
        this.numberOfRooms.setValue(room.getBedrooms());
        this.roomAddress.setValue(room.getAddress());
        this.avgRating.setValue(model.getAvgRatingById(room.getRoomId()));

        this.startDate.setValue(null);
        this.endDate.setValue(null);
    }

}
