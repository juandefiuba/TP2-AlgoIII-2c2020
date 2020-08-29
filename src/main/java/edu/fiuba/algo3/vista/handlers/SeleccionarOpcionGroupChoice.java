package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.HashMap;

public class SeleccionarOpcionGroupChoice implements EventHandler<ActionEvent> {

    private final Button pasarAGrupo1;
    private final Button pasarAGrupo2;
    private final Button botonOpcion;
    private final VBox grupo1;
    private final VBox grupo2;
    private final Button botonOk;
    private final Opcion opcion;
    private final Kahoot kahoot;
    private final VBox grupoDado;
    private final HashMap botonYOpcionSelecc;

    public SeleccionarOpcionGroupChoice(Button botonOpcion, Button pasarAGrupo1, Button pasarAGrupo2, VBox grupo1, VBox grupo2, VBox grupoDado, Button botonOk, Opcion opcion, Kahoot kahoot, HashMap botonYOpcion) {
        this.botonOpcion = botonOpcion;
        this.opcion = opcion;
        this.pasarAGrupo1 = pasarAGrupo1;
        this.pasarAGrupo2 = pasarAGrupo2;
        this.botonOk = botonOk;
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
        this.kahoot = kahoot;
        this.grupoDado = grupoDado;
        this.botonYOpcionSelecc = botonYOpcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #46c2b8");
        this.botonYOpcionSelecc.put(botonOpcion, opcion);
        botonOpcion.setOnAction(e->{
            botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
            botonYOpcionSelecc.remove(botonOpcion);
        });
    }
}
