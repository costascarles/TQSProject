package Controler;

import Model.Juego;
import Model.JuegoI;
import Model.MockJuego;
import View.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener {
    private  View view;
    private JuegoI juego;
    private String title = "3 en raya";

    public Controler(View vista, JuegoI juego){
        this.view= vista;
        this.juego=juego;

    }
    public void initView(){
        this.view.setLocationRelativeTo(null);
        this.view.casilla1.addActionListener(this);
        this.view.casilla2.addActionListener(this);
        this.view.casilla3.addActionListener(this);
        this.view.casilla4.addActionListener(this);
        this.view.casilla5.addActionListener(this);
        this.view.casilla6.addActionListener(this);
        this.view.casilla7.addActionListener(this);
        this.view.casilla8.addActionListener(this);
        this.view.casilla9.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        //System.out.println("evento e" + e);
        //System.out.println("botton no sacado de evento" +  this.view.casilla1);
        Object button= e.getSource();
        //System.out.println("botton sacado de evento" + button);
        if (this.juego.isGanador()==0){
            if( button == this.view.casilla1 )
                this.view.casilla1.setText(this.juego.turno(1));
            else if(button == this.view.casilla2)
                this.view.casilla2.setText( this.juego.turno(2) );
            else if(button == this.view.casilla3)
                this.view.casilla3.setText( this.juego.turno(3) );
            else if(button == this.view.casilla4)
                this.view.casilla4.setText( this.juego.turno(4) );
            else if(button == this.view.casilla5)
                this.view.casilla5.setText( this.juego.turno(5) );
            else if(button == this.view.casilla6)
                this.view.casilla6.setText( this.juego.turno(6) );
            else if(button == this.view.casilla7)
                this.view.casilla7.setText( this.juego.turno(7) );
            else if(button == this.view.casilla8)
                this.view.casilla8.setText( this.juego.turno(8) );
            else if(button == this.view.casilla9)
                this.view.casilla9.setText( this.juego.turno(9) );


            if (this.juego.isGanador()==1)
                mensaje(" 'X' ");
            else if( this.juego.isGanador()== 2 )
                mensaje(" 'O' ");
            else if( this.juego.isGanador()== 3 )
                mensaje(" 'Es un empate' ");


        }

    }
    private void mensaje(String s)
    {
        String message;
        if(this.juego.isGanador() == 3){
            message = s +"\n ¿Que desea hacer?";
        }else{
            message = "Gano el jugador " + s + "\n ¿Que desea hacer?";
        }
        //int seleccion = seleccion(message);
        int seleccion = Mockseleccion(message);
        if (seleccion != -1)
            if( (seleccion+1)==1 )
            {
                System.out.println("Entramos en segundo if");
                this.juego.new_game();
                //this.view.setTitle(title);
                this.view.casilla1.setText( "" );
                this.view.casilla2.setText( "" );
                this.view.casilla3.setText( "" );
                this.view.casilla4.setText( "" );
                this.view.casilla5.setText( "" );
                this.view.casilla6.setText( "" );
                this.view.casilla7.setText( "" );
                this.view.casilla8.setText( "" );
                this.view.casilla9.setText( "" );
                this.view.O_victories.setText(String.valueOf(this.juego.getOVictories()));
                this.view.X_victories.setText(String.valueOf(this.juego.getXVictories()));
            }
            else
                System.exit(0);
    }

    public int seleccion(String message){
        int seleccion = JOptionPane.showOptionDialog(null,message, "Fin del juego",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,    // null para icono por defecto.
            new Object[] { " Jugar otra vez ", " Salir de Programa " },
            "Jugar otra vez");

        return seleccion;
    }

    public int Mockseleccion(String message){
        return 0;
    }

}
