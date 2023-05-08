package Model;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable {
    private ArrayList<User> users;

    public UserList(){
        this.users = new ArrayList<>();
    }
    public void addUser(User user){
        System.out.println(user.toString());
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).equals(user)){
                throw  new IllegalStateException();
            }
        }
        users.add(user);
    }
    public void removeUser(User user){
        if (users.size() == 0){
            throw  new IllegalStateException();
        }
        users.remove(user);
    }
    public void removeUserByUsername(String username){
        if (users.size() == 0){
            throw  new IllegalStateException();
        }
        else {
            for (int i =0; i<users.size(); i++){
                if (users.get(i).getUsername().equals(username)){
                    users.remove(users.get(i));
                }
            }
        }
    }
    public void removeUserByPhoneNumber(String phoneNumber){
        if (users.size() == 0){
            throw  new IllegalStateException();
        }
        for (int i =0; i<users.size(); i++){
            if (users.get(i).getPhoneNumber().equals(phoneNumber)){
                users.remove(users.get(i));
            }
        }
    }
    public User getUserByUsername(String username){
        if (username == null){
            throw new NullPointerException();
        }
        for (int i = 0; i<users.size(); i++){
            if (users.get(i).getUsername().equals(username)){
                return users.get(i);
            }
        }
        return null;
    }
    public User getUserByIndex(int index){
        if (index<0) {
            throw  new IndexOutOfBoundsException();
        }
        return users.get(index);
    }
    @Override
    public String toString(){
        return "Users: " + users;
    }
}
