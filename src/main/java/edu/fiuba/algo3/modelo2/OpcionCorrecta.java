package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.Preguntas.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo2.Puntos.Punto;

import java.util.LinkedList;

public class OpcionCorrecta implements Opcion{

    LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;

    public OpcionCorrecta() {
        jugadoresQueEligieronEstaOpcion = new LinkedList<>();
    }

    public void agregarJugadorQueLaEligio(Jugador jugador) {
        this.jugadoresQueEligieronEstaOpcion.add(jugador);
    }

    public void obtenerPuntosDelJugador(Jugador jugador, LinkedList<Opcion> respuestasDelJugador) {
        if (jugadoresQueEligieronEstaOpcion.contains(jugador)){
            respuestasDelJugador.add(this);
        }
    }

    @Override
    public Punto validarOpcion(PreguntaVerdaderoFalso pregunta) {
        return pregunta.calificarOpcion(this);
    }
}
