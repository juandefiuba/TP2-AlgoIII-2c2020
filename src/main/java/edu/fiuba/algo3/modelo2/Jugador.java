package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;

public class Jugador {

    String nombreJugador;
    private Puntaje puntaje;

    public Jugador(String nombre) {
        this.nombreJugador = nombre;
        this.puntaje = new Puntaje();
    }

    public int obtenerPuntos() {
        return puntaje.obtenerPuntos();
    }

    public void sumarPuntos(Pregunta pregunta){
        this.puntaje.sumarPuntos(pregunta.puntuarJugador(this));
    }

}
