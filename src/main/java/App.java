import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.List;
import java.util.HashMap;

public class App {

  public static void main(String [] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/stylists", (request, response) -> {
      HashMap model = new HashMap();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists", (request, response) -> {
      HashMap model = new HashMap();
      String newInputStylist = request.queryParams("inputStylist");
      Stylist stylist = new Stylist(newInputStylist);
      // save to the DB as a row in the sylists table
      stylist.save();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/new", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/newStylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients/new", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/newClient.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylist", stylist);
      model.put("clients", stylist.getClients());
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/stylists/:id", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   // find the selected stylist
    //   Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
    //   // add a new client
    //   String newInputClient = request.queryParams("inputClient");
    //   Client client = new Client(newInputClient);
    //   client.save();
    //   stylist.addClient(client);
    //
    //   model.put("stylist", stylist);
    //   model.put("clients", stylist.getClients());
    //   model.put("template", "templates/stylist.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }
}
