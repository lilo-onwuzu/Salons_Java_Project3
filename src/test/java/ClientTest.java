import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
// server connection class library
import org.sql2o.*;

public class ClientTest {

  // add rule to connect to the database before each Test and store objects created within each test there. Also add rule to delete all test objects created in the hair_salon_test database after each test
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true(){
    Client testClient = new Client("client");
    assertEquals(true, testClient instanceof Client);
  }

  @Test
  public void Client_instantiatedwithString_String(){
    Client testClient = new Client("client");
    assertEquals("client", testClient.getClient());
  }

}
