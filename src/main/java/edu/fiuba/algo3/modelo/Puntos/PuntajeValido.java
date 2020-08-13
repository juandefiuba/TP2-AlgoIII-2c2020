package edu.fiuba.algo3.modelo.Puntos;

import edu.fiuba.algo3.modelo.Exclusividad.*;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.ExclusividadValida;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;

public class PuntajeValido implements Puntaje {
    int puntos;

    public PuntajeValido(){
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

    public void sumarPuntos(PuntajeValido unPuntajeAsumar){
        this.puntos += unPuntajeAsumar.obtenerPuntos();
    }

    @Override
    public EstadoExclusividad emparejarPuntaje(Puntaje unPuntaje) {
        return unPuntaje.emparejarPuntaje(this);
    }

    @Override
    public EstadoExclusividad emparejarPuntaje(PuntajeValido unPuntaje) {
        return new ExclusividadInvalida();
    }

    @Override
    public EstadoExclusividad emparejarPuntaje(PuntajeNeutro unPuntaje) {
        return new ExclusividadValida();
    }

    @Override
    public void aplicarExclusividad(ExclusividadSimple exclusividadSimple) {

    }

    @Override
    public void aplicarExclusividad(ExclusividadDoble exclusividadDoble) {
        this.puntos = this.puntos * 2;
    }

    @Override
    public void aplicarExclusividad(ExclusividadCuadruple exclusividadCuadruple) {
        this.puntos = this.puntos * 4;
    }

    public void multiplicar(MultiplicadorDoble multiplicadorDoble) {
        this.puntos = this.puntos * 2;
    }

    @Override
    public void aplicarExclusividad(ExclusividadDeEmpate exclusividadDeEmpate) {
        this.puntos = 0;
    }

    public void multiplicar(MultiplicadorTriple multiplicadorTriple) {
        this.puntos = this.puntos * 3;
    }


    public void sumarPuntos(Puntaje unPuntaje) {
        this.puntos = this.puntos + unPuntaje.obtenerPuntos();
    }
}
