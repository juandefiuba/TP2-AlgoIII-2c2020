package edu.fiuba.algo3.modelo.Puntos;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class PuntoNegativo implements Punto {

    @Override
    public void validarTipoDePunto(Puntaje puntaje) {
        puntaje.sumarPuntos(this);
    }
}
