package edu.fiuba.algo3.modelo.Puntos;

public class PuntoEstatico implements Punto{
    @Override
    public void validarTipoDePunto(Puntaje puntaje) {
        puntaje.sumarPuntos(this);
    }
}
