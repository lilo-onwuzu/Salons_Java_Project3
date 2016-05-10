public class Client {
  private String name;
  private int client_id;

  public Client(String name){
    this.name = name;
  }

  public String getClient(){
    return name;
  }

  public int getId() {
    return client_id;
  }

}
