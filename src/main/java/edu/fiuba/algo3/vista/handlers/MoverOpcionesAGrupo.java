package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AgregarOpcionElegidaHandler;
import edu.fiuba.algo3.controlador.RemoverOpcionElegidaHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MoverOpcionesAGrupo implements EventHandler<ActionEvent> {

    private final VBox contenedorAntiguo;
    private final VBox contenedorNuevo;
    private final Button botonOk;
    private final Kahoot kahoot;
    private final boolean agregarOpcion;
    private final HashMap botonYOpcionesSelecc;

    public MoverOpcionesAGrupo(HashMap botonYOpcionesSelecc, VBox contenedorAntiguo, VBox contenedorNuevo, Button botonOk, Kahoot kahoot, boolean agregarOpcion) {
        this.contenedorAntiguo = contenedorAntiguo;
        this.contenedorNuevo = contenedorNuevo;
        this.botonOk = botonOk;
        this.kahoot = kahoot;
        this.agregarOpcion = agregarOpcion;
        this.botonYOpcionesSelecc = botonYOpcionesSelecc;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Iterator iter = botonYOpcionesSelecc.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry elemento = (Map.Entry) iter.next();
            Button boton = (Button) elemento.getKey();
            Opcion opcion = (Opcion) elemento.getValue();
            boton.setOnAction(e->{
                boton.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
                new RemoverOpcionElegidaHandler(kahoot, opcion).handle(new ActionEvent());
                new CambiarBotonDeContenedor(boton, contenedorNuevo, contenedorAntiguo, botonOk).handle(actionEvent);
                boton.setOnAction(new SeleccionarOpcionGroupChoice(boton, opcion, kahoot, botonYOpcionesSelecc));
            });
            new CambiarBotonDeContenedor(boton, contenedorAntiguo, contenedorNuevo, botonOk).handle(actionEvent);
            if(agregarOpcion)
                new AgregarOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
        }
        botonYOpcionesSelecc.clear();
        botonOk.requestFocus();
    }

}
