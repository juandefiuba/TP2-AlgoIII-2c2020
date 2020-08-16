package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Exclusividad.*;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntos.*;

public interface Puntaje {

    void sumarPuntos(Punto unTipoDePunto);
    void sumarPuntos(PuntoNeutro unTipoDePunto);
    void sumarPuntos(PuntoNegativo unTipoDePunto);
    void sumarPuntos(PuntoPositivo unTipoDePunto);
    void sumarPuntos(PuntoEstatico unTipoDePunto);
    void sumarPuntos(Puntaje unPuntajeAsumar);

    EstadoExclusividad emparejarPuntaje(Puntaje unPuntaje);
    EstadoExclusividad emparejarPuntaje(PuntajeValido unPuntaje);
    EstadoExclusividad emparejarPuntaje(PuntajeNulo unPuntaje);

    void aplicarExclusividad(ExclusividadCompuestaSimple exclusividadSimple);

    void aplicarExclusividad(ExclusividadCompuestaDoble exclusividadDoble);

    void aplicarExclusividad(ExclusividadCompuestaCuadruple exclusividadCuadruple);

    int obtenerPuntos();

    void multiplicar(MultiplicadorTriple multiplicadorTriple);

    void multiplicar(MultiplicadorDoble multiplicadorDoble);

    void aplicarExclusividad(ExclusividadInvalida exclusividadInvalida);

    void aplicarExclusividad(ExclusividadCompuesta unaExclusividad);
}