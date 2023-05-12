package View;

import ViewModel.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ListYourRoomViewController extends ViewController
{
  private ListYourRoomViewModel viewModel;
  @FXML
  private TextField price;

  @FXML
  private TextField roomSize;

  @FXML private TextField announcement;
  @FXML
  private TextField roomAddress;
  @FXML
  private TextField numberOfRooms;
  @FXML TextField filePathField;
  @FXML Label label;
  @Override public void init(ViewHandler viewHandler, ViewModel viewModel,
      Region root)
  {
    this.viewHandler= viewHandler;
    this.root=root;
    this.viewModel = (ListYourRoomViewModel)viewModel;
    this.price.textProperty().bindBidirectional(((ListYourRoomViewModel) viewModel).getPriceProperty());
    this.numberOfRooms.textProperty().bindBidirectional(((ListYourRoomViewModel) viewModel).getNumberOfRoomsProperty());
    this.roomAddress.textProperty().bindBidirectional(((ListYourRoomViewModel) viewModel).getRoomAddressProperty());
    this.roomSize.textProperty().bindBidirectional(((ListYourRoomViewModel) viewModel).getRoomSizeProperty());
    this.announcement.textProperty().bindBidirectional(((ListYourRoomViewModel) viewModel).getAnnouncementProperty());
    this.filePathField.textProperty().bindBidirectional(((ListYourRoomViewModel) viewModel).getFilePathFieldProperty());
    this.label.textProperty().bind(((ListYourRoomViewModel) viewModel).getLabelProperty());

  }

  @Override public void reset() {
    viewModel.clear();
  }

  @FXML public void goBack(){
    viewHandler.openView("main");
  }

  @FXML public void browseForFile(){
    viewModel.addImage();
  }
  @FXML public void postButtonPressed(){
    viewModel.postRoom();
    viewHandler.openView("main"
    );
  }

}
