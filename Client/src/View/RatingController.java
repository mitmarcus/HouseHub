package View;

import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import ViewModel.RatingViewModel;

import java.util.Optional;

public class RatingController extends ViewController {
    @FXML
    private VBox rootVBox;

    @FXML
    private ChoiceBox<Integer> ratingChoiceBox;
    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private RatingViewModel viewModel;


    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel,
                     Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (RatingViewModel) viewModel;
        this.root = root;

    }

    @Override
    public void reset() {
        viewModel.clear();
    }

    @FXML
    private void onOKClicked(ActionEvent event) {
        int rating = ratingChoiceBox.getValue();
        if (rating == 0) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Please select a value to rate the room!");
            errorAlert.showAndWait();
            return;
        }

        // Set the rating value in the viewModel
        viewModel.addRating(rating);

        // Navigate back to the "details" view
        viewHandler.openView("details"); //needed for the realtime update
        viewHandler.closeRatingWindow();
    }

    @FXML
    private void onCancelClicked(ActionEvent event) {

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Are you sure you do not want to rate this room?");
        Optional<ButtonType> result = confirmationAlert.showAndWait();

        viewHandler.openView("details"); //needed for the realtime update
        viewHandler.closeRatingWindow();
    }

}