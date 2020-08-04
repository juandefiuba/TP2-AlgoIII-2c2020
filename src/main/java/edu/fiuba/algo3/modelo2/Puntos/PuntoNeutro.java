package edu.fiuba.algo3.modelo2.Puntos;

public class PuntoNeutro implements Punto {

    @Override
    public void validarTipoDePunto(Puntaje puntaje) {
        puntaje.sumarPuntos(this);
    }
}
