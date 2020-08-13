package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.LinkedList;

public class ManejadorDePuntuacion implements EventHandler<ActionEvent> {

    private LinkedList<Jugador> jugadores;
    private Pregunta pregunta;

    public ManejadorDePuntuacion(LinkedList<Jugador> jugadores, Pregunta pregunta) {
        this.jugadores = jugadores;
        this.pregunta = pregunta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //jugadores.forEach(jugador -> jugador.sumarPuntos(pregunta)); //Esto está chequeado?
    }
}
