package ViewModel;

import Model.ModelClient;
import Model.Room;
import Model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Optional;

public class ListYourRoomViewModel extends ViewModel
{
  private ViewState viewState;
  private ModelClient model;
  private StringProperty price;
  private StringProperty roomSize;
  private StringProperty roomAddress;
  private StringProperty numberOfRooms;
  private StringProperty announcement;
  private StringProperty filePathField;
  private StringProperty label;
  private ArrayList<byte[]> images;


  public ListYourRoomViewModel(ModelClient model , ViewState viewState)
  {
    this.viewState = viewState;
    this.model = model;
    this.price = new SimpleStringProperty();
    this.roomAddress = new SimpleStringProperty();
    this.roomSize = new SimpleStringProperty();
    this.numberOfRooms = new SimpleStringProperty();
    this.announcement = new SimpleStringProperty();
    this.filePathField = new SimpleStringProperty();
    this.label = new SimpleStringProperty();
    this.images = new ArrayList<>();
  }
  public StringProperty getLabelProperty()
  {
    return label;
  }
  public StringProperty getFilePathFieldProperty(){
    return filePathField;
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
    for (int i = 0 ; i < images.size();i++){
      model.sendFile(viewState.getUsername()+".png", images.get(i));
    }
    images.clear();
    return true;
  }
  public void addImage(){

    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null)
    {
      try
      {
        filePathField.set(selectedFile.getAbsolutePath());
        byte[] fileData = Files.readAllBytes(selectedFile.toPath());
        images.add(fileData);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successful");
        alert.setHeaderText("Image Added");
        Optional<ButtonType> result = alert.showAndWait();
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
      filePathField.set("");
    }
  }

  @Override public void clear()
  {
    this.announcement.setValue("");
    this.numberOfRooms.setValue("");
    this.price.setValue("");
    this.roomAddress.setValue("");
    this.roomSize.setValue("");
    this.label.set("Only PNG");
  }
}
