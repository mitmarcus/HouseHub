package View;


import ViewModel.MainMenuViewModel;
import ViewModel.ShowRoomsViewModel;
import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

public class MainMenuViewController extends ViewController {
    private MainMenuViewModel viewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (MainMenuViewModel) viewModel;
        this.root = root;
    }


    @Override
    public void reset() {
        viewModel.clear();
    }

    @FXML
    public void handleSearchRooms(ActionEvent actionEvent) {
        viewHandler.openView("showRooms");
    }

    @FXML
    public void handleListYourRoom(ActionEvent actionEvent) {

    }

    @FXML
    public void handleManageProfile(ActionEvent actionEvent) {
        viewHandler.openView("manageAcc");
    }

    @FXML
    public void handleMyReservation(ActionEvent actionEvent)
    {
        viewHandler.openView("myReservations");
    }
}
