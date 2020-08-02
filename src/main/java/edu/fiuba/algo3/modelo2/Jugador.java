package edu.fiuba.algo3.modelo2;

public class Jugador {

    String nombreJugador;
    int puntos;

    public Jugador(String nombre) {
        nombreJugador = nombre;
        puntos = 0;

    }

    public int obtenerPuntos() {
        return puntos;
    }

    public void elegirOpcion(Opcion unaOpcion) {
        unaOpcion.agregarJugadorQueLaEligio(this);
    }

    public void sumarPuntos(int unPuntaje) {
        puntos = puntos + unPuntaje;
    }

}
