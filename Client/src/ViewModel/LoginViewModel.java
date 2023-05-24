package ViewModel;

import Model.ModelClient;
import Model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.Optional;

public class LoginViewModel extends ViewModel {
    private ModelClient model;
    private ViewState viewState;

    private StringProperty logInUsername;
    private StringProperty logInPassword;
    private StringProperty username;
    private StringProperty password;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phoneNumber;

    public LoginViewModel(ModelClient model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
        this.logInUsername = new SimpleStringProperty();
        this.logInPassword = new SimpleStringProperty();
        ;
        this.username = new SimpleStringProperty();
        ;
        this.password = new SimpleStringProperty();
        ;
        this.firstName = new SimpleStringProperty();
        ;
        this.lastName = new SimpleStringProperty();
        ;
        this.phoneNumber = new SimpleStringProperty();
        ;
    }

    public StringProperty getLogInUsernameProperty() {
        return logInUsername;
    }

    public StringProperty getLogInPasswordProperty() {
        return logInPassword;
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    public StringProperty getFirstNameProperty() {
        return firstName;
    }

    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public StringProperty getPhoneNumberProperty() {
        return phoneNumber;
    }

    public boolean addUser() {
        try {
            User userTest = model.getUserByUsername(username.get());
            if (username.get().equals(userTest.getUsername())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setHeaderText("This username already exist");
                Optional<ButtonType> result = alert.showAndWait();
                return false;
            }
        } catch (Exception e) {
            e.getCause();
        }

        if (firstName.get() == (null) || lastName.get() == (null) || username.get() == (null) || password.get() == (null) || phoneNumber.get() == (null)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Error ,the is still information missing");
            Optional<ButtonType> result = alert.showAndWait();
            return false;
        } else if (password.get().length() < 6 || password.get() == (null)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Password must be more than 5 characters");
            Optional<ButtonType> result = alert.showAndWait();
            return false;
        } else if (phoneNumber.get().length() != 8) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Error ,phone number must have 8 characters");
            Optional<ButtonType> result = alert.showAndWait();
            return false;
        } else {
            User user = new User(firstName.get(), lastName.get(), username.get(), password.get(), phoneNumber.get());
            viewState.setUsername(username.get());
            model.addUser(user);
            return true;
        }
    }

    public boolean logIn() {
        User user = model.getUser(logInUsername.get(), logInPassword.get());
        if (user == null) {
            URL url = getClass().getResource("/utility/error.mp3");
            Media sound = new Media(url.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

            return false;
        }

        URL url = getClass().getResource("/utility/intro.mp3");
        Media sound = new Media(url.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        viewState.setUsername(logInUsername.get());
        return true;
    }

    @Override
    public void clear() {
        username.set("");
        password.set("");
    }
}
