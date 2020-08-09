package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public class OpcionIncorrecta implements Opcion{
    LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;

    public OpcionIncorrecta() {
        jugadoresQueEligieronEstaOpcion = new LinkedList<>();
    }

    public void obtenerLRespuestaDelJugador(Jugador jugador, LinkedList<Opcion> respuestasDelJugador) {
        if (jugadoresQueEligieronEstaOpcion.contains(jugador)){
            respuestasDelJugador.add(this);
        }
    }

    @Override
    public void agregarJugadorQueLaEligio(Jugador jugador) {
        this.jugadoresQueEligieronEstaOpcion.add(jugador);
    }


    @Override
    public void agregarOpcionesCorrectasNoElegidas(Jugador jugador, LinkedList<Opcion> opcionesCorrectasNoElegidasPorElJugador) {

    }

    @Override
    public void validarOpcion(Pregunta pregunta) {
        pregunta.calificarOpcion(this);
    }

}
