package Controler;

import Model.MockJuego;
import View.MockView;
import View.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
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
  void mensaje(){

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
    Assertions.assertEquals(vista.casilla1.getText(),"X");
    Assertions.assertEquals(vista.X_victories.getText(),"0");
    Assertions.assertEquals(vista.O_victories.getText(),"0");


    //Test printar posicion 9 --- frontera
    //juego.setGanador(0);
    e = new ActionEvent(vista.casilla9, 163," ");
    controler.actionPerformed(e);
    TestTabla[8] = "X";
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);
    Assertions.assertEquals(vista.casilla9.getText(),"X");
    Assertions.assertEquals(vista.X_victories.getText(),"0");
    Assertions.assertEquals(vista.O_victories.getText(),"0");

    //Test printar posicion 5
    //juego.setGanador(0);
    e = new ActionEvent(vista.casilla5, 163," ");
    controler.actionPerformed(e);
    TestTabla[4] = "X";
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);
    Assertions.assertEquals(vista.casilla5.getText(),"X");
    Assertions.assertEquals(vista.X_victories.getText(),"0");
    Assertions.assertEquals(vista.O_victories.getText(),"0");


    //Fuera de rango
    JButton casilla10 = new JButton("_");
    e = new ActionEvent(casilla10, 163," ");
    controler.actionPerformed(e);
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);
    Assertions.assertNotEquals(casilla10.getText(),"X");
    Assertions.assertEquals(vista.X_victories.getText(),"0");
    Assertions.assertEquals(vista.O_victories.getText(),"0");


    //Test Condicion de victoria

    System.out.println("dar ganador"+ juego.isGanador());
    e = new ActionEvent(vista.casilla6, 163," ");
    controler.actionPerformed(e);
    TestTabla = new String[9];
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);
    Assertions.assertEquals(juego.getXVictories(), 1);
    Assertions.assertEquals(vista.casilla1.getText(),"");
    Assertions.assertEquals(vista.casilla9.getText(),"");
    Assertions.assertEquals(vista.casilla5.getText(),"");
    Assertions.assertEquals(vista.casilla6.getText(),"");
    Assertions.assertEquals(vista.X_victories.getText(),"1");
    Assertions.assertEquals(vista.O_victories.getText(),"1");

    //Test Condicion de victoria

    e = new ActionEvent(vista.casilla7, 163," ");
    controler.actionPerformed(e);
    TestTabla = new String[9];
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);
    Assertions.assertEquals(juego.getXVictories(), 2);
    Assertions.assertEquals(vista.casilla7.getText(),"");
    Assertions.assertEquals(vista.X_victories.getText(),"2");
    Assertions.assertEquals(vista.O_victories.getText(),"2");

    //Test Condicio empat

    e = new ActionEvent(vista.casilla8, 163," ");
    controler.actionPerformed(e);
    TestTabla= new String[9];
    Assertions.assertArrayEquals(juego.getTabla(),TestTabla);
    Assertions.assertEquals(juego.isGanador(), 0);
    Assertions.assertEquals(juego.getXVictories(), 3);
    Assertions.assertEquals(vista.casilla8.getText(),"");
    Assertions.assertEquals(vista.X_victories.getText(),"3");
    Assertions.assertEquals(vista.O_victories.getText(),"3");

  }
}
