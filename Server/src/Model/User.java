package Model;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNumber;

    public User(String firstName, String lastName, String username, String password,String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        if (firstName == null || lastName == null|| username == null|| password == null || phoneNumber == null){
            throw new NullPointerException();
        }
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
        if (firstName.length() < 3 || firstName == "") {
            throw new IllegalArgumentException();
        }
        if (firstName == null){
            throw new NullPointerException();
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3 || lastName == "") {
            throw new IllegalArgumentException();
        }
        if (lastName == null ){
            throw new NullPointerException();
        }
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        if (username.length() < 3 || username == "") {
            throw new IllegalArgumentException();
        }
        if (username == null ){
            throw new NullPointerException();
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (password.length() < 6 || password == "") {
            throw new IllegalArgumentException();
        }
        if (password == null ){
            throw new NullPointerException();
        }
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() < 8 || phoneNumber == "") {
            throw new IllegalArgumentException();
        }
        if (phoneNumber == null ){
            throw new NullPointerException();
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
