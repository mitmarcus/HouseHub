package Model;

import org.junit.jupiter.api.BeforeEach;

public class UserListTest {
    private UserList list;

    @BeforeEach
    void setUp() {
        this.list = new UserList();
    }

  //Constructor: only initialization needed

    /*
  addReservation()
  Z - add a reservation to a empty list
  O - add a reservation in a one element list;
  O - add a reservation that already exist in the list should throw exception
  M - add one or more reservations in a list with elements;
  B - there is no upper limit for this reservation list;
  E - add a reservation  with null values in Room should throw an exception, it is already being checked in Room , cannot create a room with null values;
  E - E = add a reservation with null values should throw an exception, already being checked in Reservation;
   */
}
