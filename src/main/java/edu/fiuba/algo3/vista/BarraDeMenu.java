package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ManejadorDeSalida;
import edu.fiuba.algo3.vista.handlers.OpcionAcercaDeEventHandler;
import edu.fiuba.algo3.vista.handlers.OpcionPantallaCompletaEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage stage) {

        //this.prefWidthProperty().bind(stage.widthProperty());

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");
        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        menuArchivo.setStyle("-fx-font-size:25");
        menuVer.setStyle("-fx-font-size:25");
        menuAyuda.setStyle("-fx-font-size:25");
        opcionSalir.setStyle("-fx-font-size:25");
        opcionAcercaDe.setStyle("-fx-font-size:25");

        ManejadorDeSalida opcionSalirHandler = new ManejadorDeSalida();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);

        //opcionPantallaCompleta.setDisable(false);

        menuArchivo.getItems().addAll(new SeparatorMenuItem(), opcionSalir);
        menuAyuda.getItems().addAll(opcionAcercaDe);
        menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}