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
    public User(String firstName, String lastName, String username, String password, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setPassword(password);
        setPhoneNumber(phoneNumber);
    }

    /**
     * This method is used to get the first Name
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method is used to get the last Name
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method is used to get the username
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method is used to get the password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method is used to get the phone number
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method is used to get the string representation of the room
     *
     * @return the string representation of the room
     */
    @Override
    public String toString() {
        return "User: " + firstName + " " + lastName + "\n Username: " + username + "\n Password: " + password + "\n Phone Number: " + phoneNumber;
    }

    /**
     * This method is set the first name
     *
     * @param firstName the first name
     * @return the first name
     * @throws IllegalArgumentException if the first name is less than 3 characters
     */
    public void setFirstName(String firstName) {
        try {
            if (firstName.length() < 3) {
                throw new IllegalArgumentException();
            }
            this.firstName = firstName;
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * This method is set the last name
     *
     * @param lastName the last name
     * @return the last name
     * @throws IllegalArgumentException if the last name is less than 3 characters
     */
    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    /**
     * This method is set the username
     *
     * @param username the username
     * @return the username
     * @throws IllegalArgumentException if the username is less than 3 characters
     */
    public void setUsername(String username) {
        if (username.length() < 3) {
            throw new IllegalArgumentException();
        }
        this.username = username;
    }

    /**
     * This method is set the password
     *
     * @param password the password
     * @return the password
     * @throws IllegalArgumentException if the password is less than 6 characters
     */
    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException();
        }
        this.password = password;
    }

    /**
     * This method is set the phone number
     *
     * @param phoneNumber the phone number
     * @return the phone number
     * @throws IllegalArgumentException if the phone number is not 8 characters
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 8) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Error ,phone number must have 8 characters");
            Optional<ButtonType> result = alert.showAndWait();
            throw new IllegalArgumentException();
        } else
            this.phoneNumber = phoneNumber;
    }

    /**
     * This method is used to check if two users are equal
     *
     * @param o the object to compare with
     * @return true if the given object is equal to this user
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) return false;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName)
                && Objects.equals(username, user.username) && Objects.equals(password, user.password)
                && Objects.equals(phoneNumber, user.phoneNumber);
    }
}
