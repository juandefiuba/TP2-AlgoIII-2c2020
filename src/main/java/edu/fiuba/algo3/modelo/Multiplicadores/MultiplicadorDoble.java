package edu.fiuba.algo3.modelo.Multiplicadores;

import edu.fiuba.algo3.modelo.Puntos.Puntaje;

public class MultiplicadorDoble implements Multiplicador {
    @Override
    public void multiplicar(Puntaje puntajeDelJugador) {
        puntajeDelJugador.multiplicar(this);
    }
}
