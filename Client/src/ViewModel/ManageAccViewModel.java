package ViewModel;

import Model.ModelClient;
import Model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ManageAccViewModel extends ViewModel {
    private ModelClient model;
    private ViewState viewState;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty phonenumber;

    public ManageAccViewModel(ModelClient model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
        this.username = new SimpleStringProperty();
        this.lastname = new SimpleStringProperty();
        this.firstname = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.phonenumber = new SimpleStringProperty();
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public StringProperty getLastnameProperty() {
        return lastname;
    }

    public StringProperty getFirstnameProperty() {
        return firstname;
    }

    public StringProperty getPhoneNumberProperty() {
        return phonenumber;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    @Override
    public void clear() {
        User user = model.getUserByUsername(viewState.getUsername());
        username.set(user.getUsername());
        password.set(user.getPassword());
        firstname.set(user.getFirstName());
        lastname.set(user.getLastName());
        phonenumber.set(user.getPhoneNumber());
    }

    public boolean update() {
        User user = model.getUserByUsername(viewState.getUsername());
        user.setUsername(username.get());
        user.setFirstName(firstname.get());
        user.setPassword(password.get());
        user.setLastName(lastname.get());
        user.setPhoneNumber(phonenumber.get());
        boolean done = false;

        try {
            model.setUserInfo(user);
            done = true;
            clear();
        } catch (IllegalArgumentException exception) {
            clear();
        }

        return done;
    }

    public boolean info() {
        return model.getRoomsByUsername(viewState.getUsername()).isEmpty();
    }
}
