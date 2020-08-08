package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;

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
