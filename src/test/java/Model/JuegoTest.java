package Model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest {
    Juego juego;
    @BeforeEach
    void setUp() {
        juego= new Juego();
    }
    @Test
    void constructorTest(){
        Assertions.assertEquals(juego.getTurno(),0);
        Assertions.assertEquals(juego.getCruz(),"X");
        Assertions.assertEquals(juego.getCirculo(),"O");
        Assertions.assertFalse(juego.isGanador());
        Assertions.assertArrayEquals(juego.getTablero(),new String[3][3]);
    }
    @Test
    void setMatrixValueTest(){
        juego.setMatrixValue(0,0,"X"); //Test the butom matrix limit
        juego.setMatrixValue(0,0,"O"); //Test that is not possible modify the not empty position
        juego.setMatrixValue(2,2,"O"); //Test the top matrix limit
        juego.setMatrixValue(4,0,"X"); //Test matrix segment violation
        String[][] tableroTest=new String[3][3];
        tableroTest[0][0]="X";
        tableroTest[2][2]="O";
        Assertions.assertArrayEquals(juego.getTablero(),tableroTest);
    }
    @Test
    void pintarMarcaTest(){
        juego.pintarMarca(1,"X"); //Test the correct position conversion Button
        juego.pintarMarca(9,"O"); //Test the correct position conversion Top
        juego.pintarMarca(10,"X"); //Test wrong position selection
        String[][] tableroTest=new String[3][3];
        tableroTest[0][0]="X";
        tableroTest[2][2]="O";
        Assertions.assertArrayEquals(juego.getTablero(),tableroTest);
    }
}
