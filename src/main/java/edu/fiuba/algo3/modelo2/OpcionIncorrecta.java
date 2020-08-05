package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.Preguntas.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;

import java.util.LinkedList;

public class OpcionIncorrecta implements Opcion{
    LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;

    public OpcionIncorrecta() {
        jugadoresQueEligieronEstaOpcion = new LinkedList<>();
    }

    public void obtenerPuntosDelJugador(Jugador jugador, LinkedList<Opcion> respuestasDelJugador) {
        if (jugadoresQueEligieronEstaOpcion.contains(jugador)){
            respuestasDelJugador.add(this);
        }
    }

    @Override
    public void agregarJugadorQueLaEligio(Jugador jugador) {
        this.jugadoresQueEligieronEstaOpcion.add(jugador);
    }

    @Override
    public Puntaje validarOpcion(PreguntaVerdaderoFalso pregunta, Puntaje puntajeDeRespuesta) {
        return pregunta.calificarOpcion(this, puntajeDeRespuesta);
    }
}
