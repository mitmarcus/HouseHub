package Model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNumber;

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
        if (firstName.length() < 3) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
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
        if (phoneNumber.length() < 8) {
            throw new IllegalArgumentException();
        }
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
