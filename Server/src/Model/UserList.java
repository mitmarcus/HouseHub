package Model;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList(){
        this.users = new ArrayList<>();
    }
    public void addUser(String firstName, String lastName, String username, String password, String phoneNumber){
        users.add(new User(firstName, lastName, username, password, phoneNumber));
    }
    public void removeUserByUsername(String username){
        for (int i =0; i<users.size(); i++){
            if (users.get(i).getUsername().equals(username)){
                users.remove(users.get(i));
            }
        }
    }
    public void removeUserByPhoneNumber(String phoneNumber){
        for (int i =0; i<users.size(); i++){
            if (users.get(i).getPhoneNumber().equals(phoneNumber)){
                users.remove(users.get(i));
            }
        }
    }
    @Override
    public String toString(){
        return "Users: " + users;
    }
}
