package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AgregarOpcionElegidaHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MoverOpcionAGrupo implements EventHandler<ActionEvent> {

    private final Button boton;
    private final VBox contenedorAntiguo;
    private final VBox contenedorNuevo;
    private final Button botonOk;
    private final Opcion opcion;
    private final Kahoot kahoot;

    public MoverOpcionAGrupo(Button boton, VBox contenedorAntiguo, VBox contenedorNuevo, Button botonOk, Opcion opcion, Kahoot kahoot) {
        this.contenedorAntiguo = contenedorAntiguo;
        this.contenedorNuevo = contenedorNuevo;
        this.boton = boton;
        this.botonOk = botonOk;
        this.opcion = opcion;
        this.kahoot = kahoot;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        new CambiarBotonDeContenedor(boton, contenedorAntiguo, contenedorNuevo, botonOk).handle(actionEvent);
        new AgregarOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
        boton.setOnAction(e->{});
        botonOk.requestFocus();
    }

}
