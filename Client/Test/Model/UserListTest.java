package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserListTest {
    private UserList list;

    @BeforeEach
    void setUp() {
        this.list = new UserList();
    }

    //Constructor: only initialization needed

    /*
  addUser(User user)
  Z - add a user to an empty list should not throw an exception
  O - add a user in a one element list should not throw an exception
  O - add a user that already exist in the list should throw exception
  M - add two users to the list should not throw an exception;
  B - getting a user from index -1 from the list should throw an exception; *there is no upper limit for this user list*
  E - already checked in the UserList class
   */
    @Test
    void addUserZero() {
        User user = new User("Nural", "Hasan", "barcht6969", "1234567", "12345678");
        assertDoesNotThrow(() -> list.addUser(user));
    }

    @Test
    void addUserOne() {
        User user = new User("Nural", "Hasan", "barcht6969", "1234567", "12345678");
        User user1 = new User("Nural", "Hasan", "barcht6969", "1234567", "12345678");
        assertDoesNotThrow(() -> list.addUser(user1));
    }

    @Test
    void addSameUser() {
        User user = new User("Nural", "Hasan", "barcht6969", "1234567", "12345678");
        User user1 = new User("Nural", "Hasan", "barcht6969", "1234567", "12345678");
        list.addUser(user);
        assertThrows(IllegalStateException.class,()->list.addUser(user1));
    }
    @Test
    void addManyUsers(){
        User user = new User("Nural", "Hasan", "barcht6969", "1234567", "12345678");
        User user1 = new User("Nural", "Hasan", "bart6969", "1234567", "12345678");
        list.addUser(user);
        list.addUser(user1);
        User user3 = new User("Nural", "Hassan", "barcht6969", "1234567", "12345678");
        User user4 = new User("Nural", "Hasssan", "barcht6969", "1234567", "12345678");
        assertDoesNotThrow(()-> list.addUser(user3));
        assertDoesNotThrow(()-> list.addUser(user4));
    }
    @Test
    void lowerBoundaryTest(){
        assertThrows(IndexOutOfBoundsException.class, ()-> list.getUserByIndex(-1));
    }

}
