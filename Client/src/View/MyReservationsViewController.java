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
    @FXML
    private ListView<String> reservedRoomListView;
    private MyReservationsViewModel viewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel,
                     Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (MyReservationsViewModel) viewModel;
        this.reservedRoomListView.setItems(((MyReservationsViewModel) viewModel).getList());
        this.root = root;

    }

    @Override
    public void reset() {
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
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmation");
            confirmationAlert.setHeaderText("Are you sure you want to remove this reservation? ");
            Optional<ButtonType> result = confirmationAlert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                viewModel.removeReservation(reservedRoomListView.getSelectionModel().getSelectedItem());
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle(" Successful");
                successAlert.setHeaderText("Your reservation from as been removed");
                successAlert.showAndWait();
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Please select a Reservation");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }


}
