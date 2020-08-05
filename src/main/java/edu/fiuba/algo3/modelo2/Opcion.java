package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.Preguntas.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo2.Puntos.Punto;

import java.util.LinkedList;

public interface Opcion {

    /*private final EstadoOpcion estado;
    private LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;
    private LinkedList<Jugador> jugadoresQueNoEligieronEstaOpcion;*/

    /*public Opcion(EstadoOpcion estadoOpcion) {
        this.estado = estadoOpcion;
        this.jugadoresQueEligieronEstaOpcion = new LinkedList<>();
        this.jugadoresQueNoEligieronEstaOpcion = new LinkedList<>();
    }*/

    public void agregarJugadorQueLaEligio(Jugador jugador);

    void obtenerPuntosDelJugador(Jugador jugador, LinkedList<Opcion> respuestasDelJugador);

    Punto validarOpcion(PreguntaVerdaderoFalso preguntaVerdaderoFalso);
}
