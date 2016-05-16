import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class ClientTest {
  // add rule to connect to the database before each Test and store objects created within each test there. Also add rule to delete all test objects created in the hair_salon_test database after each test so the follow up tests will have the correct id
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true(){
    Client testClient = new Client("client", 2);
    assertEquals(true, testClient instanceof Client);
  }

  @Test
  public void Client_instantiatedwithString_String(){
    Client testClient = new Client("client", 2);
    assertEquals("client", testClient.getName());
  }

  @Test
  public void getStylistId_returnsStylistIdCorrectly() {
    Client testClient = new Client("client", 2);
    assertEquals(2, testClient.getStylistId());
  }

  @Test
  public void all_EmptyAtFirst_true() {
    assertEquals(0, Client.all().size());
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAreTheSame_true() {
    Client firstClient = new Client("client1", 2);
    Client secondClient = new Client("client1", 2);
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_savesObjectIntoDatabase_true() {
    Client testClient = new Client("client", 2);
    testClient.save();
    assertTrue(Client.all().get(0).equals(testClient));
  }

  @Test
  public void save_assignsIdToObject_int() {
    Client testClient = new Client("client", 2);
    testClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(testClient.getId(), savedClient.getId());
  }

  @Test
  public void find_findClientInDatabase_true() {
    Client testClient = new Client("client", 2);
    testClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(savedClient, Client.find(testClient.getId()));
  }

  @Test
  public void update_updateClientNameInDatabase_true() {
    Client testClient = new Client("client", 2);
    testClient.save();
    testClient.update("other client");
    assertEquals("other client", Client.find(testClient.getId()).getName());
  }

  @Test
  public void updateStylistId_updateStylistIdInDatabase_true() {
    Client testClient = new Client("client", 2);
    testClient.save();
    testClient.updateStylistId(4);
    assertEquals(4, Client.find(testClient.getId()).getStylistId());
  }

  @Test
  public void deleteClients_deletesClientsfromDatabase_true() {
    Client myClient = new Client("Bram Stoker", 2);
    myClient.save();
    myClient.delete();
    assertEquals(0, myClient.all().size());
  }

}
