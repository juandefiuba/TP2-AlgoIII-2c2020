package edu.fiuba.algo3.modelo2.Puntos;

import edu.fiuba.algo3.modelo2.Puntos.Punto;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNeutro;
import edu.fiuba.algo3.modelo2.Puntos.PuntoPositivo;

public class Puntaje {
    int puntos;

    public Puntaje(){
        this.puntos = 0;
    }

    public int obtenerPuntos() {
        return this.puntos;
    }

    public void sumarPuntos(Punto unTipoDePunto) {
        unTipoDePunto.validarTipoDePunto(this);
    }
    public void sumarPuntos(PuntoNeutro unTipoDePunto) { }

    public void sumarPuntos(PuntoNegativo unTipoDePunto) { this.puntos--; }

    public void sumarPuntos(PuntoPositivo unTipoDePunto) { this.puntos++; }

    public void sumarPuntos(Puntaje unPuntajeAsumar){
        this.puntos += unPuntajeAsumar.obtenerPuntos();
    }

}
