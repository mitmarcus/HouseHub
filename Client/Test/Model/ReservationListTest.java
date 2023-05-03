package Model;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationListTest
{
  private ReservationList list;

  @BeforeEach void setUp()
  {
    this.list=new ReservationList();
  }

  /*
  Constructor
  Only initializing the list , nothing to be tested
   */

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

  @Test void addReservationInEmpty(){
    LocalDate start = LocalDate.of(2022, 7, 15);
    LocalDate end =  LocalDate.of(2022, 7, 30);
    Reservation reservation = new Reservation(start,end,
        new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3",false));
    list.addReservation(reservation);
    assertEquals(reservation,list.getReservationAtIndex(0));
  }

  @Test void addReservationInOneElementList(){
    LocalDate start = LocalDate.of(2022, 7, 15);
    LocalDate end =  LocalDate.of(2022, 7, 30);
    Reservation reservation = new Reservation(start,end,
        new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3",false));
    list.addReservation(reservation);

    LocalDate start1 = LocalDate.of(2022, 6, 15);
    LocalDate end1 =  LocalDate.of(2022, 6, 30);
    Reservation reservation1 = new Reservation(start1,end1,
        new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3",false));
    list.addReservation(reservation1);
    assertEquals(reservation1,list.getReservationAtIndex(1));
  }
  @Test void addReservationThatAlreadyExists(){
    LocalDate start = LocalDate.of(2022, 7, 15);
    LocalDate end =  LocalDate.of(2022, 7, 30);
    Reservation reservation = new Reservation(start,end,
        new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3",false));
    list.addReservation(reservation);

    assertThrows(IllegalStateException.class,()->list.addReservation(reservation));
  }

  /*
  Z - remove a reservation from an empty list should throw an exception
  O - remove a reservation from a one element list can be done unless the reservation does not exist in the list , that should throw an exception
  M - remove a reservation from many element list can be done unless the reservation does not exist in the list , that should throw an exception
  B - already tested in z
  E - already tested in O,M
   */

  @Test void removeFromEmpty(){
    LocalDate start = LocalDate.of(2022, 7, 15);
    LocalDate end =  LocalDate.of(2022, 7, 30);
      assertThrows(IllegalStateException.class, ()-> list.removeReservation(new Reservation(start,end,
          new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3",false))));
  }
  @Test void  removeFromOneElement(){

    //Removing a element from the list
    LocalDate start = LocalDate.of(2022, 7, 15);
    LocalDate end =  LocalDate.of(2022, 7, 30);
    Reservation reservation = new Reservation(start,end,
        new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3",false));
    list.addReservation(reservation);
    assertDoesNotThrow(()-> list.removeReservation(reservation));

  }
  @Test void removeElementFromMany()
  {
    LocalDate start = LocalDate.of(2022, 7, 15);
    LocalDate end = LocalDate.of(2022, 7, 30);
    Reservation reservation = new Reservation(start, end,
        new Room("Room next Lovbjerg.", "$500", "123 Main St", "200", "3", false));
    list.addReservation(reservation);
    LocalDate start1 = LocalDate.of(2022, 7, 15);
    LocalDate end1 = LocalDate.of(2022, 7, 30);
    Reservation reservation1 = new Reservation(start, end,
        new Room("Room next Lovbjerg.", "$500", "123 Main St", "200", "3", false));
    list.addReservation(reservation1);
    assertDoesNotThrow(() -> list.removeReservation(reservation1));
  }

  /*
  getReservationAtIndex()
  Z - getting a reservation at index 0 does not throw exception;
  O - getting a reservation at index 1 does not throw exception;
  M - getting a reservation at index M does not throw exception;
  B - getting a reservation at index -1 does  throw exception
  E - already tested in B
   */

  @Test void getReservationAtIndex0(){
    LocalDate start = LocalDate.of(2022, 7, 15);
    LocalDate end = LocalDate.of(2022, 7, 30);
    Reservation reservation = new Reservation(start, end,
        new Room("Room next Lovbjerg.", "$500", "123 Main St", "200", "3", false));
    list.addReservation(reservation);

    assertDoesNotThrow(()->list.getReservationAtIndex(0));
    assertEquals(reservation,list.getReservationAtIndex(0));
  }

  @Test void getReservationAtIndex1(){
    LocalDate start = LocalDate.of(2022, 7, 15);
    LocalDate end = LocalDate.of(2022, 7, 30);
    Reservation reservation = new Reservation(start, end,
        new Room("Room next Lovbjerg.", "$500", "123 Main St", "200", "3", false));
    list.addReservation(reservation);
    LocalDate start1 = LocalDate.of(2022, 7, 15);
    LocalDate end1 = LocalDate.of(2022, 7, 30);
    Reservation reservation1 = new Reservation(start, end,
        new Room("Room next Lovbjerg.", "$500", "123 Main St", "200", "3", false));
    list.addReservation(reservation1);

    assertEquals(reservation1 , list.getReservationAtIndex(1));
    assertDoesNotThrow(()->list.getReservationAtIndex(1));
  }
  @Test void getReservationAtIndex2(){
    LocalDate start = LocalDate.of(2022, 7, 15);
    LocalDate end = LocalDate.of(2022, 7, 30);
    Reservation reservation = new Reservation(start, end,
        new Room("Room next Lovbjerg.", "$500", "123 Main St", "200", "3", false));
    list.addReservation(reservation);
    LocalDate start1 = LocalDate.of(2022, 7, 15);
    LocalDate end1 = LocalDate.of(2022, 7, 30);
    Reservation reservation1 = new Reservation(start, end,
        new Room("Room next Lovbjerg.", "$500", "123 Main St", "200", "3", false));
    list.addReservation(reservation1);
    LocalDate start3 = LocalDate.of(2022, 3, 15);
    LocalDate end3 = LocalDate.of(2022, 3, 30);
    Reservation reservation3 = new Reservation(start, end,
        new Room("Room next Lovbjerg.", "$500", "123 Main St", "200", "3", false));
    list.addReservation(reservation3);

    assertEquals(reservation3 , list.getReservationAtIndex(2));
    assertDoesNotThrow(()->list.getReservationAtIndex(2));
  }

  @Test void getReservationAtIndexB(){
    assertThrows(IndexOutOfBoundsException.class ,()-> list.getReservationAtIndex(-1));
  }



}