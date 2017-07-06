//we'll add the necessary components to our test file. This includes importing JUnit and its assertion library, and declaring a test class:

import org.junit.*;
import static org.junit.Assert.*;

public class TaskTest {

//our first test will confirm we can successfully instantiate Task objects, and fail each test first before writing the constructor in Task.java:
  @Test
  public void Task_instantiatesCorrectly_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }

//add a test to make sure we can assign each task a description and then retrieve it:
  @Test
  public void Task_instantiatesWithDescription_String() {
    Task myTask = new Task("Mow the lawn");
    assertEquals("Mow the lawn", myTask.getDescription());
  }


}
