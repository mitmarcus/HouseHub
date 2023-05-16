package ViewModel;

import Model.ModelClient;
import Model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class LoginViewModel extends ViewModel{
    private ModelClient model;
    private ViewState viewState;

    private StringProperty logInUsername;
    private StringProperty logInPassword;
    private StringProperty username;
    private StringProperty password;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phoneNumber;

    public LoginViewModel(ModelClient model, ViewState viewState){
        this.model = model;
        this.viewState = viewState;
        this.logInUsername = new SimpleStringProperty();
        this.logInPassword = new SimpleStringProperty();;
        this.username = new SimpleStringProperty();;
        this.password = new SimpleStringProperty();;
        this.firstName = new SimpleStringProperty();;
        this.lastName = new SimpleStringProperty();;
        this.phoneNumber = new SimpleStringProperty();;
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

    public boolean addUser(){
        User user  = new User(firstName.get(),lastName.get(), username.get(), password.get(), phoneNumber.get());
        viewState.setUsername(username.get());
        model.addUser(user);
        return true;
    }

    public boolean logIn(){
        User user = model.getUser(logInUsername.get(), logInPassword.get());
        if(user == null){
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
    }
}
