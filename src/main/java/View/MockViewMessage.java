package View;

public class MockViewMessage extends ViewMessage{
  private int seleccion;
  public MockViewMessage(){ seleccion = 0;}
  public void setSeleccion(int i){seleccion = 1;}
  public int panel_JugarOtraVez(String message){
    return seleccion;
  }

}
