package View;

import ViewModel.ViewModel;
import ViewModel.ShowRoomsViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    this.root = root;
    roomListView.setItems(((ShowRoomsViewModel) viewModel).getList());
  }

  @Override public void reset()
  {
    viewModel.clear();
  }

   // public void handleImageButton(ActionEvent actionEvent) {
    //goback
    //}
}
