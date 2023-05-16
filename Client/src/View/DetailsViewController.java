package View;

import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import ViewModel.DetailsViewModel;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.Optional;

public class DetailsViewController extends ViewController {
    private DetailsViewModel viewModel;
    @FXML
    private DatePicker fromDate = new DatePicker();

    @FXML
    private DatePicker toDate = new DatePicker();

    @FXML
    private ImageView cancelButton;

    @FXML
    private TextField price;

    @FXML
    private TextField roomSize;

    @FXML
    private TextField roomAddress;
    @FXML
    private TextField numberOfRooms;

    @FXML private TextField avgRating;

    @FXML
    private Button reserveButton;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (DetailsViewModel) viewModel;
        this.root = root;
        this.price.textProperty().bind(((DetailsViewModel) viewModel).getPriceProperty());
        this.numberOfRooms.textProperty().bind(((DetailsViewModel) viewModel).getNumberOfRoomsProperty());
        this.roomAddress.textProperty().bind(((DetailsViewModel) viewModel).getRoomAddressProperty());
        this.roomSize.textProperty().bind(((DetailsViewModel) viewModel).getRoomSizeProperty());
        this.toDate.valueProperty().bindBidirectional(((DetailsViewModel) viewModel).getEndDate());
        this.fromDate.valueProperty().bindBidirectional(((DetailsViewModel) viewModel).getStartDate());
       // this.avgRating.textProperty().bindBidirectional(((DetailsViewModel) viewModel).getAvgRating());


    }

    @FXML
    private void goBack() {
        viewHandler.openView("showRooms");
    }

    @FXML
    private void reserveButtonPressed() {
        LocalDate fromDateValue = fromDate.getValue();
        LocalDate toDateValue = toDate.getValue();

        if (fromDateValue == null || toDateValue == null) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Please select both the 'From' and 'To' dates.");
            errorAlert.showAndWait();
            return;
        }

        LocalDate today = LocalDate.now();
        if (fromDateValue.isBefore(today)) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Reservation can't start from yesterday or earlier.");
            errorAlert.showAndWait();
            return;
        }

        LocalDate threeMonthsAhead = today.plusMonths(3);
        if (fromDateValue.isAfter(threeMonthsAhead)) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Reservations can only be made up to 3 months in advance.");
            errorAlert.showAndWait();
            return;
        }

        if (toDateValue.isBefore(fromDateValue)) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("'From' date should be before 'To' date.");
            errorAlert.showAndWait();
            return;
        }

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Are you sure you want to reserve from " + fromDateValue + " to " + toDateValue + "?");
        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            viewModel.addReservation(fromDateValue, toDateValue);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Reservation Successful");
            successAlert.setHeaderText("Your reservation from " + fromDateValue + " to " + toDateValue + " has been made successfully.");
            successAlert.showAndWait();
        }

        viewHandler.openView("showRooms");
    }

    @FXML private  void rate(ActionEvent event)
    {
        viewHandler.openView("rating");
    }

    @Override
    public void reset() {
        viewModel.clear();
    }
}

