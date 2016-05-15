import java.util.List;
import org.sql2o.*;

public class Stylist {
  // if you are using a DB to generate ids, the id variables on the columns in the DB and in the .java file must match
  private int id;
  private String name;
  // the database will be used for data collection of stylists and stylists
  // the DB helps so that we to not have to re-add stylists and stylists everytime we run the program

  public Stylist(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  // method to return full list of stylists. sql2o class collect the database queries and return them as a list of objects of the class Stylist
  public static List<Stylist> all() {
    String sql = "SELECT id, name FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  // override default .equals() method of all java objects in java.lang package/class library
  // default comparison of objects of the same class (reference objects) will always return "true" even if the object are not identical. We need to "override" this behavior
  // instead if () ensures that the equals returns "false" if you are comparing objects of different classes. Else() ensures that the names of the objects are being compared as opposed to their reference class objects which will point to the same thing in memory
  // therefore everytime we use .equals() to compare two Stylist object instances it will use this to check comparison
  @Override
  public boolean equals(Object otherStylist){
    if (!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      // evaluates to return true
      return this.getName().equals(newStylist.getName()) &&
             this.getId() == newStylist.getId();
    }
  }

  // method to save a stylist object instance to the database
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        // assign unique database ID or "key" to the added object instance. You should test that this key equals the stylist_id
        .getKey();
    }
  }

  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id=:id";
      Stylist stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public void update(String update) {
    String sql = "UPDATE stylists SET name=:name WHERE id=:id";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql)
        .addParameter("name", update)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public void delete() {
    // delete the stylist from stylists table
    String deleteQuery = "DELETE FROM stylists WHERE id=:id";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(deleteQuery)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }
}
