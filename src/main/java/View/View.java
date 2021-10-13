package View;

import javax.swing.*;
import java.awt.*;

public class View {
    JFrame tablero;
    public JButton casilla1;
    public JButton casilla2;
    public JButton casilla3;
    public JButton casilla4;
    public JButton casilla5;
    public JButton casilla6;
    public JButton casilla7;
    public JButton casilla8;
    public JButton casilla9;
    View(){
        tablero = new JFrame("Tablero");
        casilla1 = new JButton("-");
        casilla2 = new JButton("-");
        casilla3 = new JButton("-");
        casilla4 = new JButton("-");
        casilla5 = new JButton("-");
        casilla6 = new JButton("-");
        casilla7 = new JButton("-");
        casilla8 = new JButton("-");
        casilla9 = new JButton("-");

        tablero.add(casilla1);
        tablero.add(casilla2);
        tablero.add(casilla3);
        tablero.add(casilla4);
        tablero.add(casilla5);
        tablero.add(casilla6);
        tablero.add(casilla7);
        tablero.add(casilla8);
        tablero.add(casilla9);

        tablero.setLayout(new GridLayout(3,3));
        tablero.setSize(300,300);
        tablero.setVisible(true);
    }
}
