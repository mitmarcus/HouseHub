package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @BeforeEach
    void setUp()
    {

    }

  /*
      Constructor
  Z - Create a user with zero argument constructor should trow an exception;
  O - Create a user with one argument constructor should trow an exception;
  M - Create a user with all arguments constructor should  not trow an exception;
  B - Already tested before.
  E - Already tested before.
   */
  @Test
  void createUserZero(){

      assertThrows(
              NullPointerException.class,()->new User(null,null,null,null,null));
  }
  @Test
  void createUserOne(){
      assertThrows(NullPointerException.class, () -> new User("Nuri",null,null,null,null));
  }
  @Test
    void createUserAll(){
      assertDoesNotThrow(
              ()-> new User("Nural", "Hasan", "barcht6969", "1234567","12345678"));
  }
  @Test void setFirstName(){
      User user = new User("Nural", "Hasan", "barcht6969", "1234567","12345678");
      assertThrows(IllegalArgumentException.class, () -> user.setFirstName("nh"));
      assertThrows(IllegalArgumentException.class, () -> user.setFirstName(""));
      assertThrows(NullPointerException.class, () -> user.setFirstName(null));
  }
  @Test void setLastName(){
      User user = new User("Nural", "Hasan", "barcht6969", "1234567","12345678");
      assertThrows(IllegalArgumentException.class, () -> user.setLastName("nh"));
      assertThrows(IllegalArgumentException.class, () -> user.setLastName(""));
      assertThrows(NullPointerException.class, () -> user.setLastName(null));
  }
  @Test void setUsername(){
      User user = new User("Nural", "Hasan", "barcht6969", "1234567","12345678");
      assertThrows(IllegalArgumentException.class, () -> user.setUsername("nh"));
      assertThrows(IllegalArgumentException.class, () -> user.setUsername(""));
      assertThrows(NullPointerException.class, () -> user.setUsername(null));
  }
  @Test void setPassword(){
      User user = new User("Nural", "Hasan", "barcht6969", "1234567","12345678");
      assertThrows(IllegalArgumentException.class, () -> user.setPassword("nh87"));
      assertThrows(IllegalArgumentException.class, () -> user.setPassword(""));
      assertThrows(NullPointerException.class, () -> user.setPassword(null));
  }
    @Test void setPhoneNumber(){
        User user = new User("Nural", "Hasan", "barcht6969", "1234567","12345678");
        assertThrows(IllegalArgumentException.class, () -> user.setPhoneNumber("231287"));
        assertThrows(IllegalArgumentException.class, () -> user.setPhoneNumber(""));
        assertThrows(NullPointerException.class, () -> user.setPhoneNumber(null));
    }
    @Test void equals(){
        User user = new User("Nural", "Hasan", "barcht6969", "1234567","12345678");
        assertThrows(NullPointerException.class, ()-> user.equals(null));
    }
}
