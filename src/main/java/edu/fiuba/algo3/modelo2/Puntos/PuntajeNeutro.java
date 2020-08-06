package edu.fiuba.algo3.modelo2.Puntos;

import edu.fiuba.algo3.modelo2.Puntos.*;

public class PuntajeNeutro extends Puntaje {

    public PuntajeNeutro() {
        this.puntos = 0;
    }

    @Override
    public void sumarPuntos(Punto unTipoDePunto) {
        unTipoDePunto.validarTipoDePunto(this);
    }

    @Override
    public void sumarPuntos(PuntoNeutro unTipoDePunto) {
    }

    @Override
    public void sumarPuntos(PuntoNegativo unTipoDePunto) {
    }

    @Override
    public void sumarPuntos(PuntoPositivo unTipoDePunto) {
    }

    @Override
    public void sumarPuntos(PuntoEstatico unTipoDePunto){ }

    @Override
    public void sumarPuntos(Puntaje unPuntajeAsumar){ }
}
