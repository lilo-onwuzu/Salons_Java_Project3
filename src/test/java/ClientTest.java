import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
// server connection class library
import org.sql2o.*;

public class ClientTest {

  // add rule to connect to the database before each Test and store objects created within each test there
  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  // add rule to delete objects created in the database after each test
  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open() {
      String sql = "DELETE FROM stylists *;"
      con.createQuery(sql).executeUpdate();
    }
  }

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
