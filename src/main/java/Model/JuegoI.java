package Model;

public abstract class JuegoI {
  //private int ganador;
  public abstract String turno(int pos);
  public abstract int isGanador();
  public abstract void new_game();
  public abstract int getOVictories();
  public abstract int getXVictories();
}
