package edu.fiuba.algo3.modelo.Multiplicadores;

import edu.fiuba.algo3.modelo.Puntos.Puntaje;

public class MultiplicadorTriple implements Multiplicador {
    @Override
    public void multiplicar(Puntaje puntajeDelJugador) {
        puntajeDelJugador.multiplicar(this);
    }
}
