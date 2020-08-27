package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.SalirDelJuegoHandler;
import edu.fiuba.algo3.vista.handlers.OpcionAcercaDeEventHandler;
import edu.fiuba.algo3.vista.handlers.botonesOk.MusicaPlayOPausa;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    public BarraDeMenu(Stage stage) {

        //OPCIONES DEL MENU
        Menu menuArchivo = new Menu("Archivo");
        Menu menuSonido = new Menu("Sonido");
        Menu menuAyuda = new Menu("Ayuda");
        Menu opcionPlayPausa = new Menu("Play/Pausa");
        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        //TAMAÑO DE LAS OPCIONES DEL MENU
        menuArchivo.setStyle("-fx-font-size:15");
        menuSonido.setStyle("-fx-font-size:15");
        menuAyuda.setStyle("-fx-font-size:15");
        opcionSalir.setStyle("-fx-font-size:15");
        opcionAcercaDe.setStyle("-fx-font-size:15");

        //MANEJADORES DE LAS OPCIONES
        SalirDelJuegoHandler opcionSalirHandler = new SalirDelJuegoHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        opcionPlayPausa.setOnAction(new MusicaPlayOPausa());

        //AGREGANDO OPCIONES A LA BARRA DE MENU
        menuArchivo.getItems().addAll(new SeparatorMenuItem(), opcionSalir);
        menuAyuda.getItems().addAll(opcionAcercaDe);
        menuSonido.getItems().addAll(opcionPlayPausa);



        this.getMenus().addAll(menuArchivo, menuSonido, menuAyuda);
    }

}