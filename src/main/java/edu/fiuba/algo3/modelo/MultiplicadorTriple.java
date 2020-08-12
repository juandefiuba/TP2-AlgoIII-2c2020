package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Puntos.Puntaje;

public class MultiplicadorTriple implements Multiplicador {
    @Override
    public void multiplicar(Puntaje puntajeDelJugador) {
        puntajeDelJugador.multiplicar(this);
    }
}
