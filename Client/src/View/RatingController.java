package View;

import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import ViewModel.RatingViewModel;

public class RatingController extends ViewController{
    @FXML
    private VBox rootVBox;

    @FXML
    private ChoiceBox<Float> ratingChoiceBox;
    @FXML
    private Button okButton;

    @FXML
   private Button cancelButton;

    private RatingViewModel viewModel;


    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel,
                     Region root)
    {
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
        Float rating = ratingChoiceBox.getValue();
        System.out.println("Selected rating: " + rating);
    }

    @FXML
    private void onCancelClicked(ActionEvent event) {
        // Close the dialog ?
    }
}