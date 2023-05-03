package ModelServer.ModelServer;

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
}
