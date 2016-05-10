import java.util.ArrayList;

public class Stylist {
  private String mName;
  private int stylist_id;
  private static ArrayList<Stylist> instances = new ArrayList<Stylist();
  private ArrayList<Client> mClients;

  // override default .equals() method of all java objects in java.lang package/class library
  // default comparison of objects of the same class (reference objects) will always return "true" even if the object are not identical. We need to "override" this behavior
  // instead if () ensures that the equals returns "false" if you are comparing objects of different classes. Else() ensures that the names of the objects are being compared as opposed to their reference class objects which will point to the same thing in memory
  @Override
  public boolean equals(Object otherStylist){
    if (!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist otherStylist = (Stylist) otherStylist;
      // evaluates to return true
      return this.getName().equals(otherStylist.getName());
    }
  }

  public Stylist(String name) {
    mName = name;
    instances.add(this);
    mClients = new ArrayList<Client>();
    stylist_id = instances.size();
  }

  public String getName() {
    return mName;
  }

  public int getId() {
    return stylist_id;
  }

  public void addClient(Client client) {
    mClients.add(client);
  }

  public static ArrayList<Stylist> getStylists() {
    return instances;
  }

  public ArrayList<Client> getClients() {
    return mClients;
  }

  public static void clear() {
    instances.clear();
  }

  public static Stylist find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

}
