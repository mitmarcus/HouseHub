package ViewModel;

import Model.ModelClient;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
        model.addUser(firstName.get(),lastName.get(),username.get(),password.get(),phoneNumber.get());
        return true;
    }
    @Override
    public void clear() {


    }
}
