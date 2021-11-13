package Controler;

import Model.MockJuego;
import View.MockView;
import View.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;




public class ControlerTest {
  Controler controler;
  MockJuego juego;
  MockView vista;
  @BeforeEach
  void setUp() {
    juego = new MockJuego();
    vista = new MockView();
    controler = new Controler(vista, juego);
  }
  @Test
  void Controlador(){
    ActionEvent e;
    //Test printar posición 1 --- frontera
    //juego.setGanador(0);
    e = new ActionEvent(vista.casilla1, 163," ");
    controler.actionPerformed(e);
    String[] TestTabla = new String[9];
    TestTabla[0] = "X";
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);


    //Test printar posicion 9 --- frontera
    //juego.setGanador(0);
    e = new ActionEvent(vista.casilla9, 163," ");
    controler.actionPerformed(e);
    TestTabla[8] = "X";
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);

    //Test printar posicion 5
    //juego.setGanador(0);
    e = new ActionEvent(vista.casilla5, 163," ");
    controler.actionPerformed(e);
    TestTabla[4] = "X";
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);

    //Test Condicion de victoria

    System.out.println("dar ganador"+ juego.isGanador());
    e = new ActionEvent(vista.casilla6, 163," ");
    controler.actionPerformed(e);
    TestTabla = new String[9];
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);
    Assertions.assertEquals(juego.getXVictories(), 1);

    //Test Condicion de victoria

    e = new ActionEvent(vista.casilla7, 163," ");
    controler.actionPerformed(e);
    TestTabla = new String[9];
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);
    Assertions.assertEquals(juego.getXVictories(), 2);

    //Test Condicio empat

    e = new ActionEvent(vista.casilla8, 163," ");
    controler.actionPerformed(e);
    TestTabla= new String[9];
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);
    Assertions.assertEquals(juego.getXVictories(), 3);



  }
}
