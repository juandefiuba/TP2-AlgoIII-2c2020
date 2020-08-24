package edu.fiuba.algo3.vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class cambiarBotonDeContenedor implements EventHandler<ActionEvent> {

    private final Button boton;
    private final VBox contenedorAntiguo;
    private final VBox contenedorNuevo;
    private final Button botonOk;

    public cambiarBotonDeContenedor(Button boton, VBox contenedorAntiguo, VBox contenedorNuevo, Button botonOk) {
        this.contenedorAntiguo = contenedorAntiguo;
        this.contenedorNuevo = contenedorNuevo;
        this.boton = boton;
        this.botonOk = botonOk;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        contenedorAntiguo.getChildren().remove(boton);
        contenedorNuevo.getChildren().add(boton);
        botonOk.requestFocus();
        boton.setOnAction(new cambiarBotonDeContenedor(boton, contenedorNuevo, contenedorAntiguo, botonOk));
    }

}
