//App.java is responsible for the front-end user interface of the application. When we created command line interface applications it was responsible for prompting the user through the command line. Now that we're working with Spark, it's responsible for Spark routing.

import java.util.Map; //QS: why wasn't this added with HashMap in the second step (the root route) when they are both first mentioned?
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

//we'll import all the necessary classes at the top of the file, and below, declare our App class and main() method, set the staticFileLocation as "/public", and create a String called layout to contain the filepath of layout.vtl to use in all our future routes.

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


//Create a root route in App.java file that will render our home page. In the second step you add the line model.put("task", request.session().attribute("task")); is retrieving the task from the session, and placing it in model under the key "task".:
  get("/", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("task", request.session().attribute("task"));
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

//because the form's action attribute is "/tasks, and its method attribute is post, Spark will send this form's data to a route with the post() action and "/tasks"
//1.)We create our HashMap named model. 2.) We fetch the user-inputted task description from the form and save it into a String with the line String description = request.queryParams("description"); 3.) We use our Task constructor to create a new Task with the user's provided description. 4.) We save our Task object into the user's session with request.session().attribute("task", newTask); 5.) We render a success page that informs our user they've successfully added a new task to their list:
  post("/tasks", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();

    String description = request.queryParams("description");
    Task newTask = new Task(description);
    request.session().attribute("task", newTask);

    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  }
}
