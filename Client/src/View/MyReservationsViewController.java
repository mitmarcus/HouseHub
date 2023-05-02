package View;

import ViewModel.MyReservationsViewModel;
import ViewModel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

import java.util.Optional;

public class MyReservationsViewController extends ViewController {
    @FXML private ListView<String> reservedRoomListView;
    private MyReservationsViewModel viewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel,
                     Region root)
    {
        this.viewHandler = viewHandler;
        this.viewModel = (MyReservationsViewModel) viewModel;
        this.reservedRoomListView.setItems(((MyReservationsViewModel) viewModel).getList());
        this.root = root;

    }

    @Override public void reset()
    {
        viewModel.clear();
    }

    @FXML
    public void goBack() {
        viewHandler.openView("showRooms");
    }
    @FXML
    public void removeButtonPressed() {
        int numberOfSelectedRows = reservedRoomListView.getSelectionModel().getSelectedItems().size();
        if (numberOfSelectedRows == 1) {
            viewModel.setSelectedObject(
                    reservedRoomListView.getSelectionModel().getSelectedItem());
            viewModel.roomDetails();
            viewHandler.openView("details");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Please select a Reservation");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }




}
