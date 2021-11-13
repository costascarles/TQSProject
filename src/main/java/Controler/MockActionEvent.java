package Controler;
import java.awt.event.ActionEvent;

public class MockActionEvent extends ActionEvent{


  public MockActionEvent(Object source, int id, String command) {
    super(source, id, command);
  }
}
