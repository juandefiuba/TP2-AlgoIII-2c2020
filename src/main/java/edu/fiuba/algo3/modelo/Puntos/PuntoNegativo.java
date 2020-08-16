package edu.fiuba.algo3.modelo.Puntos;

public class PuntoNegativo implements Punto {

    @Override
    public void validarTipoDePunto(Puntaje puntaje) {
        puntaje.sumarPuntos(this);
    }
}
