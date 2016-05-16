import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;
import java.util.Arrays;

public class StylistTest{
  // add rule to connect to the database before each Test and store objects created within each test there Also add rule to delete objects created in the database after each test
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true(){
    Stylist testStylist = new Stylist("Stylist");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getStylist_instantiatesWithName_String(){
    Stylist testStylist = new Stylist("Stylist");
    assertEquals("Stylist", testStylist.getName());
  }

  @Test
  // checks that database clean-up rules work
  public void all_emptyListOfStylistAtFirst_Zero(){
    Stylist testStylist = new Stylist("Stylist");
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  // checks that our override .equals() rule works
  public void equals_returnsTrueIfDescriptionsAretheSame(){
    Stylist testStylist = new Stylist("my Stylist");
    Stylist testStylist2 = new Stylist("my Stylist");
    assertTrue(testStylist.equals(testStylist2));
  }

  @Test
  public void save_savesStylistToDatabase_true(){
    Stylist testStylist = new Stylist("Stylist");
    testStylist.save();
    assertTrue(Stylist.all().get(0).equals(testStylist));
  }

  @Test
  // check that the database saves the Stylist object instance with the same id that was passed to it in the save() method
  public void saveStylist_assignsIdToObject_true() {
    Stylist testStylist = new Stylist("Stylist");
    testStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(testStylist.getId(), savedStylist.getId());
  }

  @Test
  public void find_findStylistInDatabase_true() {
    Stylist testStylist = new Stylist("Stylist");
    testStylist.save();
    Stylist savedStylist = Stylist.find(testStylist.getId());
    assertTrue(testStylist.equals(savedStylist));
  }

  @Test
  public void update_updateStylistNameInDatabase_true() {
    Stylist testStylist = new Stylist("stylist");
    testStylist.save();
    testStylist.update("other stylist");
    assertEquals("other stylist", Stylist.find(testStylist.getId()).getName());
  }

  @Test
  public void deleteStylists_deletesStylistsfromDatabase_true() {
    Stylist testStylist = new Stylist("Bram Stoker");
    testStylist.save();
    testStylist.delete();
    assertEquals(0, testStylist.all().size());
  }

  @Test
  public void getClients_getClientsReturnsAllClientsForThisStylist_true() {
    Stylist testStylist = new Stylist("stylist");
    testStylist.save();
    Client testClient1 = new Client("client", testStylist.getId());
    testClient1.save();
    Client testClient2 = new Client("client", testStylist.getId());
    testClient2.save();
    Client[] clients = new Client[] { testClient1, testClient2 };
    assertTrue(testStylist.getClients().containsAll(Arrays.asList(clients)));
  }
}
