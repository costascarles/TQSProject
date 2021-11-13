package Model;

public class MockJuego extends JuegoI{
  private int ganador;
  private String marca;
  private int victories;
  private String[] tabla;

  public MockJuego(){
    tabla = new String [9];
    ganador = 0;
  }
  public String turno(int pos){
    tabla[pos-1] = "X";
    ganador();
    empate();
    return "X";
  }
  public String[] getTabla(){return tabla;}
  public int isGanador() {return ganador;}
  public void new_game(){
    ganador = 0;
    tabla = new String[9];
    victories++;
  }
  public int getOVictories(){return victories;}
  public int getXVictories(){return victories;};
  public void ganador(){
    if(tabla[5] == "X")
      ganador = 1;
    else if (tabla[6] == "X")
      ganador = 2;
  }
  public void empate(){
    if(tabla[7] == "X")
      ganador = 3;
  }
}
