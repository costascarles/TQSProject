package View;
import javax.swing.*;
import java.awt.*;

public class ViewMessage {
  JOptionPane JugarOtraVez;
  ViewMessage(){
    JugarOtraVez = new JOptionPane();
  }
  public int panel_JugarOtraVez(String message){
    int seleccion = JugarOtraVez.showOptionDialog(null,message, "Fin del juego",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,    // null para icono por defecto.
        new Object[] { " Jugar otra vez ", " Salir de Programa " },
        "Jugar otra vez");

    return seleccion;
  }
}
