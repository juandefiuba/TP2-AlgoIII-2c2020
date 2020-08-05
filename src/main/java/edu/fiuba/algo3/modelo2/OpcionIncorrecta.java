package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.Preguntas.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo2.Puntos.Punto;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNeutro;

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
    public Punto validarOpcion(PreguntaVerdaderoFalso pregunta) {
        return pregunta.calificarOpcion(this);
    }
}
