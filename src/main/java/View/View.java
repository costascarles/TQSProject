package View;

//import netscape.javascript.JSObject;

import javax.swing.*;
import java.awt.*;

public class View  extends javax.swing.JFrame {
    JFrame game;
    JPanel tablero;
    public JButton casilla1;
    public JButton casilla2;
    public JButton casilla3;
    public JButton casilla4;
    public JButton casilla5;
    public JButton casilla6;
    public JButton casilla7;
    public JButton casilla8;
    public JButton casilla9;
    public JLabel X_victories;
    public JLabel O_victories;

    public View(){
        game = new JFrame("3 en raya");
        game.setLayout(new BoxLayout(game.getContentPane(), BoxLayout.Y_AXIS));
        tablero = new JPanel();
        JPanel puntuacion = new JPanel();
        JPanel X = new JPanel();
        JPanel O = new JPanel();
        X_victories = new JLabel("0");
        O_victories = new JLabel("0");
        puntuacion.add(X);
        puntuacion.add(O);
        O.add(O_victories);
        X.add(X_victories);
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
        puntuacion.setLayout(new GridLayout(1,2));
        //puntuacion.setSize(300,50);

        puntuacion.setVisible(true);
        game.setSize(300,375);
        game.setMaximumSize(new Dimension(300,375));
        tablero.setVisible(true);
        game.add(tablero);
        game.add(puntuacion);

        puntuacion.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        puntuacion.setPreferredSize(new Dimension(300,75));
        puntuacion.setMaximumSize(new Dimension(300,75));
        puntuacion.setBorder(BorderFactory.createTitledBorder("puntuacion"));

        tablero.setAlignmentY(Component.TOP_ALIGNMENT);
        tablero.setPreferredSize(new Dimension(300,300));
        tablero.setMaximumSize(new Dimension(300,300));
        tablero.setBorder(BorderFactory.createTitledBorder("tablero"));

        O.setBorder(BorderFactory.createTitledBorder("Jugador O"));
        X.setBorder(BorderFactory.createTitledBorder("Jugador X"));

        game.setVisible(true);
    }
}
