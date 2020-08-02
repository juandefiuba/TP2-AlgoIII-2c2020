package edu.fiuba.algo3.modelo2;

import java.util.LinkedList;

public class Opcion {

    private final EstadoOpcion estado;
    private LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;


    public Opcion(EstadoOpcion estadoOpcion) {
        this.estado = estadoOpcion;
        this.jugadoresQueEligieronEstaOpcion = new LinkedList<>();
    }

    public void agregarJugadorQueLaEligio(Jugador jugador) {
        jugadoresQueEligieronEstaOpcion.add(jugador);
    }

    public void puntuarSegunEstado() {
        estado.asignarPuntajeAJugadores(jugadoresQueEligieronEstaOpcion);
    }
}
