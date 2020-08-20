package edu.fiuba.algo3.vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MarcarOpcionEnOrden implements EventHandler<ActionEvent> {

    private Button boton;
    private VBox contenedorAntiguo;
    private VBox contenedorNuevo;

    public MarcarOpcionEnOrden(Button boton, VBox contenedorAntiguo, VBox contenedorNuevo) {
        this.contenedorAntiguo = contenedorAntiguo;
        this.contenedorNuevo = contenedorNuevo;
        this.boton = boton;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        contenedorAntiguo.getChildren().remove(boton);
        contenedorNuevo.getChildren().add(boton);
        boton.setOnAction(e->{});
    }

}
