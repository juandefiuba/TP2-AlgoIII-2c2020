package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.RemoverOpcionElegidaHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class BotonCambiarDeGrupoYDesmarcarComoElegida implements EventHandler<ActionEvent> {

    private final Kahoot kahoot;
    private final Button boton;
    private final Opcion opcion;
    private final VBox contenedorAntiguo;
    private final VBox contenedorNuevo;
    private final Button botonOk;


    public BotonCambiarDeGrupoYDesmarcarComoElegida(Kahoot kahoot, Button boton, Opcion opcion, VBox contenedorAntiguo, VBox contenedorNuevo, Button botonOk){
        this.kahoot = kahoot;
        this.opcion = opcion;
        this.boton = boton;
        this.contenedorAntiguo = contenedorAntiguo;
        this.contenedorNuevo = contenedorNuevo;
        this.botonOk = botonOk;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        botonOk.requestFocus();
        new CambiarBotonDeContenedor(boton, contenedorNuevo, contenedorAntiguo, botonOk).handle(actionEvent);
        new RemoverOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
        boton.setOnAction(new BotonCambiarDeGrupoYMarcarComoElegida(kahoot, boton, opcion, contenedorAntiguo, contenedorNuevo, botonOk));
    }
}
