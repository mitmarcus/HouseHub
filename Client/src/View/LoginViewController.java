package View;

import ViewModel.MainMenuViewModel;
import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import ViewModel.LoginViewModel;


public class LoginViewController extends ViewController{
    private LoginViewModel viewModel;
    private ViewHandler viewHandler;

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
    }

    @Override
    public void reset() {
        viewModel.clear();
    }

    @FXML
    public void signUpPressed(ActionEvent actionEvent) {
        
    }

    public void logInPressed(ActionEvent actionEvent) {
        viewHandler.openView("main");
    }
}
