package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaCuadruple;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaDoble;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaSimple;
import edu.fiuba.algo3.modelo.Exclusividades.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Exclusividades.Estados.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.Exclusividades.Estados.ExclusividadValida;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorQueNoMultiplica;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntos.*;

public class PuntajeNulo implements Puntaje {

    int puntos;

    public PuntajeNulo() {
        this.puntos = 0;
    }

    @Override
    public void sumarPuntos(Punto unTipoDePunto) {
        unTipoDePunto.validarTipoDePunto(this);
    }

    @Override
    public void sumarPuntos(PuntoNeutro unTipoDePunto) {}

    @Override
    public void sumarPuntos(PuntoNegativo unTipoDePunto) {}

    @Override
    public void sumarPuntos(PuntoPositivo unTipoDePunto) {}

    @Override
    public void sumarPuntos(PuntoEstatico unTipoDePunto){}

    @Override
    public void sumarPuntos(Puntaje unPuntajeAsumar){}

    @Override
    public EstadoExclusividad emparejarPuntaje(Puntaje unPuntaje) {
        return unPuntaje.emparejarPuntaje(this);
    }

    @Override
    public EstadoExclusividad emparejarPuntaje(PuntajeValido unPuntaje) {
        return new ExclusividadValida();
    }

    @Override
    public EstadoExclusividad emparejarPuntaje(PuntajeNulo unPuntaje) {
        return new ExclusividadInvalida();
    }

    @Override
    public void aplicarExclusividad(ExclusividadCompuestaSimple exclusividadSimple) {}

    @Override
    public void aplicarExclusividad(ExclusividadCompuestaDoble exclusividadDoble) {}

    @Override
    public void aplicarExclusividad(ExclusividadInvalida exclusividadInvalida) {

    }

    @Override
    public void aplicarExclusividad(ExclusividadCompuesta unaExclusividad) {

    }

    @Override
    public void multiplicar(MultiplicadorQueNoMultiplica multiplicadorQueNoMultiplica) {

    }

    @Override
    public void aplicarExclusividad(ExclusividadCompuestaCuadruple exclusividadCuadruple) {}

    @Override
    public int obtenerPuntos() {
        return this.puntos;
    }

    @Override
    public void multiplicar(MultiplicadorTriple multiplicadorTriple) {}

    @Override
    public void multiplicar(MultiplicadorDoble multiplicadorDoble) {}

}
