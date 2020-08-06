package edu.fiuba.algo3.modelo2.Puntos;

public class PuntoPositivo implements Punto {

    @Override
    public void validarTipoDePunto(Puntaje puntaje) {
        puntaje.sumarPuntos(this);
    }
}
