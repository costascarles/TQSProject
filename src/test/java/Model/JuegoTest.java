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
    @Test
    void turno(){
        String[][] tableroTest= { {null,null,null},
                                  {null,null,null},
                                  {null,null,null} };
        //empezamos en turno 0, pintamos en pos 1
        Assertions.assertTrue(juego.turno(1));
        Assertions.assertEquals(juego.getTurno(), 1);

        //ahora estamos en turno 1, pintmos en 3
        Assertions.assertTrue(juego.turno(3));
        Assertions.assertEquals(juego.getTurno(), 0);

        //estamos en turno 0, pintamos en 1, no debemos cambiar de turno.
        Assertions.assertFalse(juego.turno(1));
        Assertions.assertEquals(juego.getTurno(),0);

        //pintamos fuera de rango, no cambiamos de turno
        Assertions.assertFalse(juego.turno(0));
        Assertions.assertEquals(juego.getTurno(),0);

        //pintamos fuera de rango, no cambiamos de turno
        Assertions.assertFalse(juego.turno(10));
        Assertions.assertEquals(juego.getTurno(),0);

    }
    @Test
    void winner(){
        String[][] tableroTest= { {null,null,null},
                                  {null,null,null},
                                  {null,null,null} };
        //no condicion de victoria
        Assertions.assertFalse(juego.winner(tableroTest,juego.getCruz()));

        String[][] tableroTest2= { {"X",null,null},
                                   {null,"X",null},
                                   {null,null,"X"} };
        //condicion de victoria diagonal
        Assertions.assertTrue(juego.winner(tableroTest2,juego.getCruz()));

        String[][] tableroTest2_1= { {null,null,"O"},
                                     {null,"O",null},
                                     {"O",null,null} };
        //condicion de victoria diagonal
        Assertions.assertTrue(juego.winner(tableroTest2_1,juego.getCruz()));

        String[][] tableroTest3= { {"X",null,"X"},
                                   {null,"X",null},
                                   {"O",null,"O"} };
        //no condicion de victoria
        Assertions.assertFalse(juego.winner(tableroTest3,juego.getCruz()));
        Assertions.assertFalse(juego.winner(tableroTest3,juego.getCirculo()));


        String[][] tableroTest4= { {null,null,null},
                                  {"O","O","O"},
                                  {null,null,null} };
        //condicion de victoria fila
        Assertions.assertTrue(juego.winner(tableroTest4,juego.getCirculo()));
        Assertions.assertFalse(juego.winner(tableroTest4,juego.getCruz()));

        String[][] tableroTest5= { {"X",null,"X"},
                                   {"X","X","X"},
                                   {"O",null,"O"} };
        //condicion de victoria fila
        Assertions.assertTrue(juego.winner(tableroTest5,juego.getCruz()));
        Assertions.assertFalse(juego.winner(tableroTest5,juego.getCirculo()));

        String[][] tableroTest6= { {"X",null,"X"},
                                   {"X","X","O"},
                                   {"O",null,"O"} };
        //no condicion de victoria
        Assertions.assertFalse(juego.winner(tableroTest6,juego.getCruz()));
        Assertions.assertFalse(juego.winner(tableroTest6,juego.getCirculo()));

        String[][] tableroTest7= { {null,"O",null},
                                   {null,"O",null},
                                   {null,"O",null} };
        //condicion de victoria columna
        Assertions.assertFalse(juego.winner(tableroTest7,juego.getCruz()));
        Assertions.assertTrue(juego.winner(tableroTest7,juego.getCirculo()));

        String[][] tableroTest8= { {null,null,"X"},
                                   {null,null,"X"},
                                   {null,null,"X"} };
        //condicion de victoria columna
        Assertions.assertTrue(juego.winner(tableroTest8,juego.getCruz()));
        Assertions.assertTrue(juego.winner(tableroTest8,juego.getCirculo()));


    }
}
