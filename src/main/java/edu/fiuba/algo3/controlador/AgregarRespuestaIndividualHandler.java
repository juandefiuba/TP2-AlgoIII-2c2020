package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.LinkedList;

public class AgregarRespuestaIndividualHandler implements EventHandler<ActionEvent> {

    private Kahoot kahoot;
    private LinkedList<Opcion> respuesta;

    public AgregarRespuestaIndividualHandler(Kahoot kahoot, Opcion opcion) {
        this.kahoot = kahoot;
        this.respuesta = new LinkedList<Opcion>();
        this.respuesta.add(opcion);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarRespuestaDeJugadorActual(respuesta);
    }
}



