package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ManejadorDeSalida;
import edu.fiuba.algo3.controlador.OpcionAcercaDeEventHandler;
import edu.fiuba.algo3.controlador.OpcionPantallaCompletaEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage stage) {

        //OPCIONES DEL MENU
        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");
        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        //TAMAÑO DE LAS OPCIONES DEL MENU
        menuArchivo.setStyle("-fx-font-size:15");
        menuVer.setStyle("-fx-font-size:15");
        menuAyuda.setStyle("-fx-font-size:15");
        opcionSalir.setStyle("-fx-font-size:15");
        opcionAcercaDe.setStyle("-fx-font-size:15");

        //MANEJADORES DE LAS OPCIONES
        ManejadorDeSalida opcionSalirHandler = new ManejadorDeSalida();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        //TODAVÍA NO ANDA LA PANTALLA COMPLETA (PROBLEMAS DE RESOLUCIÓN :( )
        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);

        //AGREGANDO OPCIONES A LA BARRA DE MENU
        menuArchivo.getItems().addAll(new SeparatorMenuItem(), opcionSalir);
        menuAyuda.getItems().addAll(opcionAcercaDe);
        menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}