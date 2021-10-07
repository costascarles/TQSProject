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
}
