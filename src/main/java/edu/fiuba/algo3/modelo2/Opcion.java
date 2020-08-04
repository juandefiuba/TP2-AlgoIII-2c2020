package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.EstadosDeOpcion.EstadoOpcion;

import java.util.LinkedList;

public class Opcion {

    private final EstadoOpcion estado;
    private LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;
    private LinkedList<Jugador> jugadoresQueNoEligieronEstaOpcion;

    public Opcion(EstadoOpcion estadoOpcion) {
        this.estado = estadoOpcion;
        this.jugadoresQueEligieronEstaOpcion = new LinkedList<>();
        this.jugadoresQueNoEligieronEstaOpcion = new LinkedList<>();
    }

    public void agregarJugadorQueLaEligio(Jugador jugador) {
        jugadoresQueEligieronEstaOpcion.add(jugador);
        jugadoresQueNoEligieronEstaOpcion.remove(jugador);
    }

    public void actualizarEstadoDeRespuestaAJugadores() {
        estado.asignarEstadoDeRespuestaAJugadores(jugadoresQueEligieronEstaOpcion);
        estado.asignarEstadoDeRespuestaAJugadoresQueNoMeEligieron(jugadoresQueNoEligieronEstaOpcion);
    }

    public void inscribirJugador(Jugador jugador) {
        jugadoresQueNoEligieronEstaOpcion.add(jugador);
    }
}
