package Model;

public class Juego {
    private int turno;
    private String cruz;
    private String circulo;
    private boolean ganador;
    private String[][] tablero;
    public Juego(){
        this.turno = 0;
        this.cruz = "X";
        this.circulo = "O";
        this.ganador = false;
        this.tablero = new String[3][3];
    }

    public int getTurno() {
        return turno;
    }

    public String getCruz() {
        return cruz;
    }

    public String getCirculo() {
        return circulo;
    }

    public boolean isGanador() {
        return ganador;
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void turno(int pos){

    }
    public void pintarMarca(int pos,String marca){


    }
    public void setMatrixValue(int x,int y,String marca){


    }
}
