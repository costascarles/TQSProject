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

    public boolean turno(int pos){
        boolean pasar_turno;

        if(this.turno == 0){
            pasar_turno = pintarMarca(pos,cruz);
            if(pasar_turno) {
                this.turno = 1;
            }
        }else{
            pasar_turno = pintarMarca(pos, circulo);
            if(pasar_turno) {
                this.turno = 0;
            }
        }
        return pasar_turno;

    }
    public boolean pintarMarca(int pos,String marca){
        boolean result=false;
        switch (pos){
            case 1:
                result = setMatrixValue(0,0,marca);
                break;
            case 2:
                result = setMatrixValue(0,1,marca);
                break;
            case 3:
                result = setMatrixValue(0,2,marca);
                break;
            case 4:
                result = setMatrixValue(1,0,marca);
                break;
            case 5:
                result = setMatrixValue(1,1,marca);
                break;
            case 6:
                result = setMatrixValue(1,2,marca);
                break;
            case 7:
                result = setMatrixValue(2,0,marca);
                break;
            case 8:
                result = setMatrixValue(2,1,marca);
                break;
            case 9:
                result = setMatrixValue(2,2,marca);
                break;
        }
        return result;
    }
    public boolean setMatrixValue(int x,int y,String marca){
        if (x<3 && x>-1 && y<3 && y>-1){
            if(tablero[x][y] == null){
                tablero[x][y]=marca;
                return true;
            }

        }


        return false;
    }
}
