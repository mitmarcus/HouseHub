package View;

import ViewModel.MainMenuViewModel;
import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import ViewModel.LoginViewModel;

import java.util.Optional;


public class LoginViewController extends ViewController {
    private LoginViewModel viewModel;

    @FXML
    private TextField loginUsername;
    @FXML
    private TextField loginPassword;

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (LoginViewModel) viewModel;
        this.root = root;
        this.username.textProperty().bindBidirectional(((LoginViewModel) viewModel).getUsernameProperty());
        this.password.textProperty().bindBidirectional(((LoginViewModel) viewModel).getPasswordProperty());
        this.firstName.textProperty().bindBidirectional(((LoginViewModel) viewModel).getFirstNameProperty());
        this.lastName.textProperty().bindBidirectional(((LoginViewModel) viewModel).getLastNameProperty());
        this.phoneNumber.textProperty().bindBidirectional(((LoginViewModel) viewModel).getPhoneNumberProperty());
        this.loginUsername.textProperty().bindBidirectional(((LoginViewModel) viewModel).getLogInUsernameProperty());
        this.loginPassword.textProperty().bindBidirectional(((LoginViewModel) viewModel).getLogInPasswordProperty());

        initializeInputFields();
    }

    private void initializeInputFields() {
        // Set event handler for pressing Enter in the input fields
        loginUsername.setOnAction(event -> loginPassword.requestFocus());
        loginPassword.setOnAction(event -> logInPressed(new ActionEvent()));
        username.setOnAction(event -> password.requestFocus());
        password.setOnAction(event -> firstName.requestFocus());
        firstName.setOnAction(event -> lastName.requestFocus());
        lastName.setOnAction(event -> phoneNumber.requestFocus());
        phoneNumber.setOnAction(event -> signUpPressed(new ActionEvent())); // Perform sign up action
    }

    @Override
    public void reset() {
        viewModel.clear();
    }

    @FXML
    public void signUpPressed(ActionEvent actionEvent) {
        if (viewModel.addUser()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful Sign up");
            alert.setHeaderText("You're automatically signed in");
            Optional<ButtonType> result = alert.showAndWait();
            viewHandler.openView("main");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Please Try again");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    public void logInPressed(ActionEvent actionEvent) {
        if (viewModel.logIn()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful Signed in");
            alert.setHeaderText("You're signed in");
            Optional<ButtonType> result = alert.showAndWait();
            viewHandler.openView("main");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Please Try again");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
}
