import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String name;

  public Client(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public int getId() {
    return id;
  }

  public static List<Client> all(){
    String sql = "SELECT id, name FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
             this.getId() == newClient.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name) VALUES (:name);";
      // collect the primary key assigned through the DB, type-cast it to become an integer object and then assign it to the client_id
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

  public static Client find(int id) {
    String sql = "SELECT * FROM clients WHERE id=:id";
    try(Connection con = DB.sql2o.open()) {
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public void update(String update) {
    String sql = "UPDATE clients SET name=:name WHERE id=:id";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql)
        .addParameter("name", update)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public void delete() {
    // delete the client from clients table
    String deleteQuery = "DELETE FROM clients WHERE id=:id";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(deleteQuery)
        .addParameter("id", this.id)
        .executeUpdate();
    }

  }
}
