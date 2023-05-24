package ViewModel;

import Model.ModelClient;
import Model.Room;
import Model.User;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class MyRoomsViewModel extends ViewModel {
    private ViewState viewState;
    private ModelClient model;
    private ObservableList<MyRoomsViewModel> list;

    private StringProperty roomId;
    private StringProperty address;
    private StringProperty bedrooms;
    private StringProperty price;
    private BooleanProperty reserved;
    private ObjectProperty<MyRoomsViewModel> selectedRoom;

    public MyRoomsViewModel(ModelClient model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
        this.roomId = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.bedrooms = new SimpleStringProperty();
        this.price = new SimpleStringProperty();
        this.reserved = new SimpleBooleanProperty();
        this.selectedRoom = new SimpleObjectProperty<>();
        this.list = FXCollections.observableArrayList();
        loadList();
    }

    public MyRoomsViewModel(Room room) {
        roomId = new SimpleStringProperty(room.getRoomId());
        price = new SimpleStringProperty(room.getPrice());
        bedrooms = new SimpleStringProperty(room.getBedrooms());
        address = new SimpleStringProperty(room.getAddress());
        reserved = new SimpleBooleanProperty(room.isReserved());
        selectedRoom = new SimpleObjectProperty<>();
    }

    public StringProperty getRoomIdProperty() {
        return roomId;
    }

    public StringProperty getPriceProperty() {
        return price;
    }

    public StringProperty getAddressProperty() {
        return address;
    }

    public StringProperty getBedroomsProperty() {
        return bedrooms;
    }

    public BooleanProperty getReservedProperty() {
        return reserved;
    }

    public ObjectProperty getSelectedRoomProperty() {
        return selectedRoom;
    }

    public void setSelectedRoom(MyRoomsViewModel room) {
        selectedRoom.set(room);
    }

    private void loadList() {
        list.clear();
        for (Room room : model.getRoomsByUsername(viewState.getUsername())) {
            list.add(new MyRoomsViewModel(room));
        }
    }

    @Override
    public void clear() {
        loadList();
    }

    public ObservableList<MyRoomsViewModel> getAll() {
        return list;
    }

    public boolean removeRoom() {
        if (selectedRoom.get() == null) {
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle(" Error");
            successAlert.setHeaderText("Please select a room");
            successAlert.showAndWait();
            return false;
        }
        if (selectedRoom.get().reserved.get() == true) {
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle(" Error");
            successAlert.setHeaderText("Can remove , this room is reserved , Please contact support");
            successAlert.showAndWait();
            return false;
        }
        User user = model.getUserByUsername(viewState.getUsername());
        Room room = model.getRoomById(selectedRoom.get().roomId.get());
        model.removeRoom(room);
        loadList();
        return true;
    }
}
