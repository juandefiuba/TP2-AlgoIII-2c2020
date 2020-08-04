package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.EstadosDeOpcion.EstadoOpcion;

import java.util.LinkedList;

public class Opcion {

    private final EstadoOpcion estado;
    private LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;
    private LinkedList<Jugador> jugadoresQueNoEligieronEstaOpcion;

    public Opcion(EstadoOpcion estadoOpcion) {
        this.estado = estadoOpcion;  // Correcto || Incorrecto
        this.jugadoresQueEligieronEstaOpcion = new LinkedList<>();
        this.jugadoresQueNoEligieronEstaOpcion = new LinkedList<>();
    }

    public void agregarJugadorQueLaEligio(Jugador jugador) {
        this.jugadoresQueEligieronEstaOpcion.add(jugador);
        this.jugadoresQueNoEligieronEstaOpcion.remove(jugador);
    }

    public void actualizarEstadoDeRespuestaAJugadores() {
        this.estado.asignarEstadoDeRespuestaAJugadores(jugadoresQueEligieronEstaOpcion);
        this.estado.asignarEstadoDeRespuestaAJugadoresQueNoMeEligieron(jugadoresQueNoEligieronEstaOpcion);
    }

    public void inscribirJugador(Jugador jugador) {
        this.jugadoresQueNoEligieronEstaOpcion.add(jugador);
    }
}
