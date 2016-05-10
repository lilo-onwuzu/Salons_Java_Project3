// import static spark.Spark.*;
// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import java.util.ArrayList;
// import java.util.HashMap;
//
// public class App {
//
//   public static void main(String [] args) {
//     staticFileLocation("/public");
//     String layout = "templates/layout.vtl";
//
//     get("/stylists", (request, response) -> {
//       HashMap model = new HashMap();
//       String newInputStylist = request.queryParams("inputStylist");
//       Stylist newStylist = new Word(newInputStylist);
//       model.put("stylists", Stylist.getStylists());
//       model.put("template", "templates/stylists.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/stylists", (request, response) -> {
//       HashMap model = new HashMap();
//       String newInputStylist = request.queryParams("inputStylist");
//       Stylist newStylist = new Word(newInputStylist);
//       model.put("stylists", Stylist.getStylists());
//       model.put("template", "templates/stylists.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/stylists/new", (request, response) -> {
//       HashMap model = new HashMap();
//       model.put("template", "templates/newStylist.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/clients/new", (request, response) -> {
//       HashMap model = new HashMap();
//       model.put("template", "templates/newClient.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/stylists/:id", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
//       ArrayList<Clients> clients = stylist.getClients();
//       model.put("stylist", stylist);
//       model.put("clients", clients);
//       model.put("template", "templates/stylist.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/stylists/:id", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       // find the selected stylist
//       Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
//       // add a new client
//       String newInputClient = request.queryParams("newClient");
//       Client client = new Client(newInputClient);
//       stylist.addClient(client);
//       // delete client. Some browsers only handle get and post requests. Some may handle others like: delete, update and patch. We will handle this delete request using a post request
//
//       // update client
//
//       // get client list
//       ArrayList<Clients> clients = stylist.getClients();
//       model.put("stylist", stylist);
//       model.put("clients", clients);
//       model.put("template", "templates/stylist.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//   }
// }
