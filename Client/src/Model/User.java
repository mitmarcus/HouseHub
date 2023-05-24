package Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNumber;

    /**
     * This constructor is used to create a user
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param username    the username
     * @param password    the password
     * @param phoneNumber the phone number
     */
    public User(String firstName, String lastName, String username, String password,String phoneNumber){
        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setPassword(password);
        setPhoneNumber(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Override
    public String toString(){
        return "User: " + firstName + " " + lastName + "\n Username: " + username +"\n Password: "+ password + "\n Phone Number: " + phoneNumber;
    }

    public void setFirstName(String firstName) {
        try
        {
            if (firstName.length() < 3) {
                throw new IllegalArgumentException();
            }
            this.firstName = firstName;
        }
        catch (IllegalArgumentException e)
        {}
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        if (username.length() < 3) {
            throw new IllegalArgumentException();
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException();
        }
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 8) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Error ,phone number must have 8 characters");
            Optional<ButtonType> result = alert.showAndWait();
            throw new IllegalArgumentException();
        }
        else
        this.phoneNumber = phoneNumber;
    }

    @Override public boolean equals(Object o){
        if (o==null){
            throw new NullPointerException();
        }
        if (this == o){
            return true;
        }
        if (!(o instanceof User user)) return false;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName)
                && Objects.equals(username, user.username) && Objects.equals(password, user.password)
                && Objects.equals(phoneNumber, user.phoneNumber);
    }
}
