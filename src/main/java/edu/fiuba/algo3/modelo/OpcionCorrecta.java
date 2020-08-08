package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;

import java.util.LinkedList;

public class OpcionCorrecta implements Opcion{

    LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;

    public OpcionCorrecta() {
        jugadoresQueEligieronEstaOpcion = new LinkedList<>();
    }

    public void agregarJugadorQueLaEligio(Jugador jugador) {
        this.jugadoresQueEligieronEstaOpcion.add(jugador);
    }

    public void obtenerLRespuestaDelJugador(Jugador jugador, LinkedList<Opcion> respuestasDelJugador) {
        if (jugadoresQueEligieronEstaOpcion.contains(jugador)){
            respuestasDelJugador.add(this);
        }
    }

    @Override
    public Puntaje validarOpcion(Pregunta pregunta, Puntaje puntajeDeRespuesta) {
        return pregunta.calificarOpcion(this, puntajeDeRespuesta);
    }

    @Override
    public void agregarOpcionesCorrectasNoElegidas(Jugador jugador, LinkedList<Opcion> opcionesCorrectasNoElegidasPorElJugador) {
        if (!jugadoresQueEligieronEstaOpcion.contains(jugador)){
            opcionesCorrectasNoElegidasPorElJugador.add(this);
        }
    }

}
