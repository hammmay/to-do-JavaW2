/*For first test - Add our Task class with a constructor that (for now) takes only one argument: A A description of the Task we're adding to our To Do List:

public class Task {

  public Task(String description) {
  }
}*/

//For all tests - We need to create a member property (mDescription) to hold the task's description. Then, we need to save the description provided in the constructor to this property.Once that's done, any method on an instance of Task can access that instance's mDescription property using the getDescription() getter method:
public class Task {
  private String mDescription;

  public Task(String description) {
    mDescription = description;
  }

  public String getDescription() {
    return mDescription;
  }
}
