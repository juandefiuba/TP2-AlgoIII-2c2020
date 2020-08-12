package edu.fiuba.algo3.modelo.Puntos;

import edu.fiuba.algo3.modelo.Multiplicador;
import edu.fiuba.algo3.modelo.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.MultiplicadorQueNoMultiplica;
import edu.fiuba.algo3.modelo.MultiplicadorTriple;

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

    public void sumarPuntos(PuntoPositivo unTipoDePunto) {  this.puntos++; }

    public void sumarPuntos(PuntoEstatico unTipoDePunto){ this.puntos = 1;}

    public void sumarPuntos(Puntaje unPuntajeAsumar){
        this.puntos += unPuntajeAsumar.obtenerPuntos();
    }

    public void multiplicar(MultiplicadorDoble multiplicadorDoble) {
        this.puntos = this.puntos * 2;
    }

    public void multiplicar(MultiplicadorTriple multiplicadorTriple) {
        this.puntos = this.puntos * 3;
    }
}
