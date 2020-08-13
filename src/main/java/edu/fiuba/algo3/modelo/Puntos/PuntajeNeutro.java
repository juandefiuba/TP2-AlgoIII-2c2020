package edu.fiuba.algo3.modelo.Puntos;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.ExclusividadValida;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCuadruple;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDeEmpate;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDoble;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadSimple;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;

public class PuntajeNeutro implements Puntaje {
    int puntos;

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
    public void sumarPuntos(PuntajeValido unPuntajeAsumar){ }

    @Override
    public EstadoExclusividad emparejarPuntaje(Puntaje unPuntaje) {
        return unPuntaje.emparejarPuntaje(this);
    }

    @Override
    public EstadoExclusividad emparejarPuntaje(PuntajeValido unPuntaje) {
        return new ExclusividadValida();
    }

    @Override
    public EstadoExclusividad emparejarPuntaje(PuntajeNeutro unPuntaje) {
        return new ExclusividadInvalida();
    }

    @Override
    public void aplicarExclusividad(ExclusividadSimple exclusividadSimple) {

    }

    @Override
    public void aplicarExclusividad(ExclusividadDoble exclusividadDoble) {

    }

    @Override
    public void aplicarExclusividad(ExclusividadCuadruple exclusividadCuadruple) {

    }

    @Override
    public int obtenerPuntos() {
        return this.puntos;
    }

    @Override
    public void multiplicar(MultiplicadorTriple multiplicadorTriple) {

    }

    @Override
    public void multiplicar(MultiplicadorDoble multiplicadorDoble) {

    }

    @Override
    public void aplicarExclusividad(ExclusividadDeEmpate exclusividadDeEmpate) {

    }
}
