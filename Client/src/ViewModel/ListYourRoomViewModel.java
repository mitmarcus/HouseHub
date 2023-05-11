package ViewModel;

import Model.ModelClient;
import Model.Room;
import Model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ListYourRoomViewModel extends ViewModel
{
  private ViewState viewState;
  private ModelClient model;
  private StringProperty price;
  private StringProperty roomSize;
  private StringProperty roomAddress;
  private StringProperty numberOfRooms;
  private StringProperty announcement;


  public ListYourRoomViewModel(ModelClient model , ViewState viewState)
  {
    this.viewState = viewState;
    this.model = model;
    this.price = new SimpleStringProperty();
    this.roomAddress = new SimpleStringProperty();
    this.roomSize = new SimpleStringProperty();
    this.numberOfRooms = new SimpleStringProperty();
    this.announcement = new SimpleStringProperty();
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
  public StringProperty getAnnouncementProperty(){
    return announcement;
  }

  public boolean postRoom(){
    User user = model.getUserByUsername(viewState.getUsername());
    Room room = new Room(user,announcement.get(), price.get(),roomAddress.get(),roomSize.get(),numberOfRooms.get(),false);
    model.addRoom(room);
    return true;
  }

  @Override public void clear()
  {
    this.announcement.setValue("");
    this.numberOfRooms.setValue("");
    this.price.setValue("");
    this.roomAddress.setValue("");
    this.roomSize.setValue("");
  }
}
