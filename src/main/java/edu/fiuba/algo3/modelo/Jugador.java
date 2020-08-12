package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;

public class Jugador {

    String nombreJugador;
    private Puntaje puntaje;
    Multiplicador multiplicadorDoble;
    Multiplicador multiplicadorTriple;
    Multiplicador multiplicadorActual;

    public Jugador(String nombre) {
        this.nombreJugador = nombre;
        this.puntaje = new Puntaje();
        this.multiplicadorDoble = new MultiplicadorDoble();
        this.multiplicadorTriple = new MultiplicadorTriple();
        this.multiplicadorActual = new MultiplicadorQueNoMultiplica();
    }

    public int obtenerPuntos() {
        return puntaje.obtenerPuntos();
    }

    public void sumarPuntos(Pregunta pregunta){
        this.puntaje.sumarPuntos(pregunta.puntuarJugador(this));
    }

    public void activarMultiplicadorPorDos() {
        this.multiplicadorActual = this.multiplicadorDoble;
        this.multiplicadorDoble = new MultiplicadorQueNoMultiplica();
    }

    public void activarMultiplicadorPorTres() {
        this.multiplicadorActual = this.multiplicadorTriple;
        this.multiplicadorTriple = new MultiplicadorQueNoMultiplica();
    }

    public Multiplicador obtenerMultiplicador(){
        Multiplicador multiplicadorAUsar = this.multiplicadorActual;
        this.multiplicadorActual = new MultiplicadorQueNoMultiplica();
        return multiplicadorAUsar;
    }

}
