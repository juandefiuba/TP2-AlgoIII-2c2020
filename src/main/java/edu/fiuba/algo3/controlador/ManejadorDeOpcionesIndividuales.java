package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.LinkedList;

public class ManejadorDeOpcionesIndividuales implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private LinkedList<Opcion> respuesta;
    private Pregunta pregunta;
    private Button terminarTurno;

    public ManejadorDeOpcionesIndividuales(Jugador jugador, Opcion opcion , Pregunta pregunta, Button terminarTurno) {
        this.jugador = jugador;
        this.respuesta.add(opcion);
        this.pregunta = pregunta;
        this.terminarTurno = terminarTurno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //pregunta.agregarRespuestaDeJugador(this.jugador, this.respuesta);
        terminarTurno.fire(); //ManejadorDeRespuesta
    }
}



