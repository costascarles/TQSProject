package Model;

public class Juego {
    private int turno;
    private String cruz;
    private String circulo;
    private int ganador;
    private String[][] tablero;
    private boolean empate;
    public Juego(){
        this.turno = 0;
        this.cruz = "X";
        this.circulo = "O";
        this.ganador = 0;
        this.tablero = new String[3][3];
        this.empate = false;
    }
    private boolean marcar(int posición){
        return false;
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

    public int isGanador() {
        return ganador;
    }

    public String[][] getTablero() {
        return tablero;
    }

    public String turno(int pos){
        boolean pasar_turno;
        String marca="";
        if(this.turno == 0){
            pasar_turno = pintarMarca(pos,cruz);
            if(pasar_turno) {
                this.turno = 1;
                marca=cruz;
                if(winner(this.tablero,cruz)){
                    this.ganador=1;
                }
            }
        }else{
            pasar_turno = pintarMarca(pos, circulo);
            if(pasar_turno) {
                this.turno = 0;
                marca=circulo;
                if(winner(this.tablero,circulo)){
                    this.ganador=2;
                }
            }
        }
        return marca;

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
        if (x<3 && x>-1 && y<3 && y>-1){ //NO hace falta solo aumenta complejidad
            if(tablero[x][y] == null){
                tablero[x][y]=marca;
                return true;
            }

        }


        return false;
    }
    public boolean winner(String[][] tablero, String marca){
        //busqueda ganador por diagonales
        if(tablero[1][1]  == marca){
            if(tablero[0][0] == marca && tablero[2][2] == marca)
            {
                return true;
            }
            if(tablero[0][2] == marca  && tablero[2][0] == marca){
                return true;
            }

        }

        for(int i = 0; i < 3; i ++){
            int count_files = 0;
            int count_columnes =0;
            //filas y columnas
            for(int j = 0; j < 3; j ++)
            {
                if(tablero[i][j] == marca){
                    count_files++;
                }
                if(tablero[j][i] == marca){
                    count_columnes++;
                }
            }
            if(count_files == 3 || count_columnes == 3){
                return true;
            }
        }

        return false;
    }
    public boolean draw(String[][] tablero){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(tablero[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }
}
