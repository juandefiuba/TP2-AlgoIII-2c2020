package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaCuadruple;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaDoble;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaSimple;
import edu.fiuba.algo3.modelo.Exclusividades.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Exclusividades.Estados.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.Exclusividades.Estados.ExclusividadValida;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntos.*;

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

    public void sumarPuntos(Puntaje unPuntaje) {
        this.puntos = this.puntos + unPuntaje.obtenerPuntos();
    }

    @Override
    public void aplicarExclusividad(ExclusividadCompuestaSimple exclusividadSimple) { }

    @Override
    public void aplicarExclusividad(ExclusividadCompuestaDoble exclusividadDoble) {
        this.puntos = this.puntos * 2;
    }

    @Override
    public void aplicarExclusividad(ExclusividadCompuestaCuadruple exclusividadCuadruple) {
        this.puntos = this.puntos * 4;
    }

    @Override
    public void aplicarExclusividad(ExclusividadInvalida exclusividad) {
        this.puntos = 0;
    }

    @Override
    public void aplicarExclusividad(ExclusividadCompuesta unaExclusividad) {
        unaExclusividad.aplicarExclusividad(this);
    }


    public void multiplicar(MultiplicadorDoble multiplicadorDoble) {
        this.puntos = this.puntos * 2;
    }

    public void multiplicar(MultiplicadorTriple multiplicadorTriple) {
        this.puntos = this.puntos * 3;
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
    public EstadoExclusividad emparejarPuntaje(PuntajeNulo unPuntaje) {
        return new ExclusividadValida();
    }

}
