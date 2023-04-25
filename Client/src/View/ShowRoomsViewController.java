package View;

import ViewModel.ViewModel;
import ViewModel.ShowRoomsViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;



public class ShowRoomsViewController extends ViewController
{
  @FXML private ListView<String> roomListView;

  private ShowRoomsViewModel viewModel;
  @Override
  public void init(ViewHandler viewHandler, ViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = (ShowRoomsViewModel) viewModel;
    this.roomListView.setItems(((ShowRoomsViewModel) viewModel).getList());
    this.root = root;

  }

  @Override public void reset()
  {
    viewModel.clear();
  }

  @FXML
  public void goBack() {
    viewHandler.openView("main");
  }
  @FXML
  public void detailsButtonPressed(){
   // int numberOfSelectedRows = roomListView.getSelectionModel().getSelectedItems().size();
   // if (numberOfSelectedRows == 1) {
      viewModel.setSelectedObject(roomListView.getSelectionModel().getSelectedItem());
      viewModel.roomDetails();
      viewHandler.openView("details");
    }
    @FXML public void reservationsButtonPressed()
    {
      viewHandler.openView("main");
    }
  }

