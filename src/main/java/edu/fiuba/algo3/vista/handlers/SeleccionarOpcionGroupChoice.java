package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.HashMap;

public class SeleccionarOpcionGroupChoice implements EventHandler<ActionEvent> {

    private final Button botonOpcion;
    private final Opcion opcion;
    private final Kahoot kahoot;
    private final HashMap botonYOpcionSelecc;

    public SeleccionarOpcionGroupChoice(Button botonOpcion, Opcion opcion, Kahoot kahoot, HashMap botonYOpcion) {
        this.botonOpcion = botonOpcion;
        this.opcion = opcion;
        this.kahoot = kahoot;
        this.botonYOpcionSelecc = botonYOpcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #46c2b8");
        this.botonYOpcionSelecc.put(botonOpcion, opcion);

        //Des-seleccionar la opción
        botonOpcion.setOnAction(e->{
            botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
            botonOpcion.setOnAction(new SeleccionarOpcionGroupChoice(botonOpcion,opcion, kahoot, botonYOpcionSelecc));
            botonYOpcionSelecc.remove(botonOpcion);
        });
    }
}
