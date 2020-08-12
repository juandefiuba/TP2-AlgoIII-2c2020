package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Puntos.Puntaje;

public class MultiplicadorDoble implements Multiplicador {
    @Override
    public void multiplicar(Puntaje puntajeDelJugador) {
        puntajeDelJugador.multiplicar(this);
    }
}
