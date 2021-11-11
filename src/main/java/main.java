

import Controler.Controler;
import Model.Juego;
import View.View;

import java.awt.event.ActionEvent;


class Main {

    public static void main(String[] args) {
        //nuevas instancias de clase
        Juego modelo = new Juego();
        View vista = new View();
        Controler controlador = new Controler(vista, modelo);
        controlador.initView();

    }
}